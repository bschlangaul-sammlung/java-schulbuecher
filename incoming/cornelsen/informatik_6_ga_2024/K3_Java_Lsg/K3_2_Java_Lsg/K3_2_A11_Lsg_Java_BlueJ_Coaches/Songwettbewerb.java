
import java.util.*;
import java.io.*;
/**
 * Ermittelt günstige Paarungen von Coaches und Kandidaten für den Songwettbewerb
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class Songwettbewerb
{
    /**
     * Die Wunschlisten der Kandidaten für ihre Coaches */
    private ArrayList<ArrayList<Integer>> kandidatenWunschlisteCoaches;
    /**
     * Die Wunschlisten der Coaches für ihre Kandidaten */
    private ArrayList<ArrayList<Integer>> coachesWunschlisteKandidaten;
    /**
     * Das Feld der zugeordneten Coaches (-1 bedeutert, dass dem Kandidaten noch kein Coach zugeordnet wurde) */
    private ArrayList<Integer> coachFürKandidat;
    /**
     * Anzahl der Kandidaten und Coaches = maximaler Wunschwert */
    int anzahl;

    /**
     * Legt die Grunddaten an.
     */
    Songwettbewerb ()
    {
        kandidatenWunschlisteCoaches = new ArrayList<ArrayList<Integer>>();
        coachesWunschlisteKandidaten = new ArrayList<ArrayList<Integer>>();
        if (! Lesen("Wunschlisten.txt", kandidatenWunschlisteCoaches, coachesWunschlisteKandidaten))
        {
            return;
        }
        anzahl = coachesWunschlisteKandidaten.size();
        coachFürKandidat = new ArrayList<Integer>();
        for (int i = 0; i < anzahl; i += 1)
        {
            coachFürKandidat.add(-1);
        }
        SchrittAusführen(0);
    }

    /**
     * Liest die Wunschlistendaten aus der angegebenen Datei
     * @param name der Dateiname
     * @param kandidatenWunschlisteCoaches Wunschlisten der Kandidaten für ihre Coaches
     * @param coachesWunschlisteKandidaten Wunschlisten der Coaches für ihre Kandidaten
     * @return wahr, wenn das Lesen erfolgreich war
     */
    private boolean Lesen (String name, ArrayList<ArrayList<Integer>> kandidatenWunschlisteCoaches, ArrayList<ArrayList<Integer>> coachesWunschlisteKandidaten)
    {
        try
        {
            BufferedReader eingabe = new BufferedReader(new FileReader(name));
            String zeile = eingabe.readLine();
            if (zeile.charAt(0) != '*')
            {
                System.out.println("Falsche Dateistruktur Start");
                return false;
            }
            zeile = eingabe.readLine();
            int pos = -1;
            while (zeile.charAt(0) != '*')
            {
                String [] teile = zeile.split(",");
                kandidatenWunschlisteCoaches.add(new ArrayList<Integer>());
                pos += 1;
                for (String num: teile)
                {
                    kandidatenWunschlisteCoaches.get(pos).add(new Integer(num.strip()));
                }
                zeile = eingabe.readLine();
            }
            zeile = eingabe.readLine();
            pos = -1;
            while (zeile.charAt(0) != '*')
            {
                String [] teile = zeile.split(",");
                coachesWunschlisteKandidaten.add(new ArrayList<Integer>());
                pos += 1;
                for (String num: teile)
                {
                    coachesWunschlisteKandidaten.get(pos).add(new Integer(num.strip()));
                }
                zeile = eingabe.readLine();
            }
            eingabe.close();
            return (kandidatenWunschlisteCoaches.size() == coachesWunschlisteKandidaten.size());
        }
        catch (Exception e)
        {
            System.out.println("Fehler beim Lesen der Datei '" + name + "': " + e.getMessage());
            return false;
        }
    }

    /**
     * Gibt eine gefundene Lösung aus
     */
    private void LösungAusgeben()
    {
        int zufriedenheitKandidaten = 0;
        int zufriedenheitCoaches = 0;
        int kandidat = 0;
        for (Integer coach: coachFürKandidat)
        {
            String text = "   " + coach;
            System.out.print(text.substring(text.length() - 3));
            zufriedenheitKandidaten += kandidatenWunschlisteCoaches.get(kandidat).get(coach);
            zufriedenheitCoaches += coachesWunschlisteKandidaten.get(coach).get(kandidat);
            kandidat += 1;
        }
        String text = "    " + zufriedenheitKandidaten;
        System.out.print(text.substring(text.length() - 4));
        text = "    " + zufriedenheitCoaches;
        System.out.print(text.substring(text.length() - 4));
        text = "    " + (zufriedenheitCoaches + zufriedenheitKandidaten);
        System.out.print(text.substring(text.length() - 4));
        System.out.println();
    }

    /**
     * Sucht für den angegebenen Kandidaten den Coach, den der Kandidat mit dem gegebenen Wunschwert haben möchte)
     * @param kandidat der Kandidat, für den der Coach gesucht wird
     * @param wunschwert der Wunschwert für den Coach
     */
    private int CoachFürWunschwertGeben(int kandidat, int wunschwert)
    {
        for (int nummer = 0; nummer < anzahl; nummer += 1)
        {
            if (kandidatenWunschlisteCoaches.get(kandidat).get(nummer) == wunschwert)
            {
                return nummer;
            }
        }
        return -1;
    }

    /**
     * Sucht denjenigen Kandidaten, dem der Coach zur Zeit zugeordnet ist.
     * @param coach Coach, dessen Kandidat gesucht wird
     * @return der zugeordnete Kandidat
     */
    private int KandidatFürCoachGeben(int coach)
    {
        for (int kandidat = 0; kandidat < anzahl; kandidat += 1)
        {
            if (coachFürKandidat.get(kandidat) == coach)
            {
                return kandidat;
            }
        }
        return -1;
    }

    /**
     * Testet, ob die Aufstellung nach Hinzufügen des Paares Kandidat/Coach stabil bleibt
     * @param aktuellerKandidat der Kandidat
     * @param aktuellerCoach und dessen geplanter Coach
     * @return wahr, wenn die Aufstallung stabil bleibt
     */
    private boolean BleibtStabil (int aktuellerKandidat, int aktuellerCoach)
    {
        for (int kandidat = 0; kandidat < aktuellerKandidat; kandidat += 1)
        {
            if ((kandidatenWunschlisteCoaches.get(kandidat).get(aktuellerCoach) > kandidatenWunschlisteCoaches.get(kandidat).get(coachFürKandidat.get(kandidat))) &&
                (coachesWunschlisteKandidaten.get(aktuellerCoach).get(kandidat) > coachesWunschlisteKandidaten.get(aktuellerCoach).get(aktuellerKandidat)))
            {
                return false;
            }
        }
        for (int coach = 0; coach < anzahl; coach += 1)
        {
            if (coachFürKandidat.contains(coach))       //sonst ist der Coach noch frei
            {
                if ((coachesWunschlisteKandidaten.get(coach).get(aktuellerKandidat) > coachesWunschlisteKandidaten.get(coach).get(KandidatFürCoachGeben(coach))) &&
                    (kandidatenWunschlisteCoaches.get(aktuellerKandidat).get(coach) > kandidatenWunschlisteCoaches.get(aktuellerKandidat).get(aktuellerCoach)))
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Sucht einen Coach für den nächsten Kandidaten
     * @param kandidat der nächste Kandidat
     */
    private void SchrittAusführen(int kandidat)
    {
        for (int wunschwert = anzahl; wunschwert >= 1; wunschwert -= 1)
        {
            int coach = CoachFürWunschwertGeben(kandidat, wunschwert);
            if ((! coachFürKandidat.contains(coach)) && BleibtStabil(kandidat, coach))
            {
                coachFürKandidat.set(kandidat, coach);
                if (kandidat == anzahl - 1)
                {
                    LösungAusgeben();
                }
                else
                {
                    SchrittAusführen(kandidat + 1);
                }
                coachFürKandidat.set(kandidat, -1);
            }
        }
    }
}
