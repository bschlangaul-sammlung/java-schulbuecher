package schulbuecher.buchner.informatik_11_2023.kapitel_03.thema_05.bahnhoefe;

/**
 * Beschreiben Sie hier die Klasse Graph.
 *
 * @author Anja Stube
 *
 * @version 2023-04-24
 */
public class GRAPH
{
    private KNOTEN[] knotennamen;

    private boolean[][] adja;

    private int aktAnzahl, maxAnzahl;

    boolean[] besucht; // Feld, um zu markieren, ob der Knoten schon besucht
                       // wurde

    int[] warteschlange; // abzuarbeitende Warteschlange

    int[] reihenfolge; // Feld für die Ausgabe der Reihenfolge

    public GRAPH(int anzKnoten)
    {
        adja = new boolean[anzKnoten][anzKnoten];
        knotennamen = new KNOTEN[anzKnoten];
        maxAnzahl = anzKnoten;
        besucht = new boolean[maxAnzahl];
        reihenfolge = new int[maxAnzahl];
        warteschlange = new int[maxAnzahl];
    }

    private void warteschlangeVorbereiten()
    {
        // Alle Plätze der Warteschlange werden mit -1 initalisiert, um zu
        // kennzeichnen, dass sie
        // nicht benutzt werden.
        for (int i = 0; i < warteschlange.length; i++)
        {
            warteschlange[i] = -1;
        }
    }

    public void breitensuche_2b(String start, String ende)
    {
        warteschlangeVorbereiten();
        int indexStart = -1;
        int indexEnde = -1;
        for (int i = 0; i < maxAnzahl; i++)
        {
            if (knotennamen[i].bezeichnerIstGleich(start))
            {
                indexStart = i;
            }
            if (knotennamen[i].bezeichnerIstGleich(ende))
            {
                indexEnde = i;
            }
        }
        // Überprüfe, ob Start- und Zielknoten im Graphen vorhanden sind
        if (indexStart == -1 || indexEnde == -1)
        {
            System.out.println("Start- oder Zielknoten nicht gefunden.");
            return;
        }
        besucht[indexStart] = true; // Der Startknoten wird als besucht
                                    // markiert.
        warteschlange[0] = indexStart; // Der Start-Knoten wird als 1.
                                       // abzuarbeitender Knoten
                                       // abgespeichert.
        int wartePos = 1; // Variable gibt die Anzahl der Elemente in der
                          // Warteschlange an.
        int besKnoten = 0; // Variable, die die Anzahl der besuchten Knoten
                           // angibt.
        int vorgaenger[] = new int[maxAnzahl]; // Array zur Speicherung der
                                               // Vorgänger-Knoten
        vorgaenger[indexStart] = -1; // Startknoten hat keinen Vorgänger, daher
                                     // negativer Wert
        // Schleife überprüft, ob noch mind. ein Element in der Schlange ist.
        while (wartePos != 0)
        {
            int tmp = warteschlange[0];
            entfernen(warteschlange);
            wartePos--;
            // reihenfolge[besKnoten]=tmp;
            // besKnoten++;
            for (int nachbar = 0; nachbar < maxAnzahl; nachbar++)
            {
                if (adja[tmp][nachbar] && (!besucht[nachbar]))
                {
                    besucht[nachbar] = true;
                    vorgaenger[nachbar] = tmp; // setze den Vorgängerknoten des
                                               // Nachbarknotens
                    warteschlange[wartePos] = nachbar;
                    wartePos++;
                }
            }
            // Überprüfe, ob der Zielknoten erreicht wurde und breche die
            // Schleife dann ab.
            if (tmp == indexEnde)
            {
                wartePos = 0;
            }
        }
        // Verfolge den kürzesten Weg vom Zielknoten zum Startknoten
        int aktuellerKnoten = indexEnde;
        int schritt = 0;
        while (aktuellerKnoten != -1)
        {
            reihenfolge[schritt] = aktuellerKnoten;
            aktuellerKnoten = vorgaenger[aktuellerKnoten];
            schritt++;
        }
        // Ausgabe der kürzesten Verbindung
        System.out.println(
                "Kürzeste Verbindung von " + start + " nach " + ende + ":");
        for (int i = schritt - 1; i >= 0; i--)
        {
            System.out.print(
                    knotennamen[reihenfolge[i]].bezeichnerGeben() + " -> ");
        }
        System.out.print(" Ende ");
    }
    // Die folgenden Methoden sind für dich nicht relevant.

    private int[] entfernen(int[] feld)
    {
        for (int i = 1; i < feld.length; i++)
        {
            feld[i - 1] = feld[i];
        }
        feld[feld.length - 1] = -1;
        return feld;
    }

    private void reihenfolgeAusgeben(int[] feld)
    {
        System.out.println(
                "Der Durchlauf der Breitensuche ergibt die Reihenfolge: ");
        System.out.print(knotennamen[feld[0]].bezeichnerGeben()); // feld[0]
        for (int i = 1; i < feld.length; i++)
        {
            System.out.print("  -  " + knotennamen[feld[i]].bezeichnerGeben());
        }
    }

    public void knotenHinzufuegen(KNOTEN k)
    {
        if (aktAnzahl < maxAnzahl)
        {
            knotennamen[aktAnzahl] = k;
            aktAnzahl++;
        }
        else
        {
            System.out.println("Ein Einfügen ist leider nicht möglich.");
        }
    }

    public void kanteHinzufuegen(int start, int ende)
    {
        if ((start > maxAnzahl) || (ende > maxAnzahl))
        {
            System.out.println("Ein Einfügen ist leider nicht möglich.");
        }
        else
        {
            adja[start][ende] = true;
            adja[ende][start] = true;
        }
    }

    public void adjaAusgeben()
    {
        System.out.print("      ");
        for (int i = 0; i < maxAnzahl; i++)
        {
            System.out.print(knotennamen[i].kuerzelGeben() + "     ");
        }
        System.out.println(" ");
        for (int i = 0; i < maxAnzahl; i++)
        {
            System.out.print(knotennamen[i].kuerzelGeben() + "     ");
            for (int j = 0; j < maxAnzahl; j++)
            {
                if (adja[i][j])
                {
                    System.out.print("x     ");
                }
                else
                {
                    System.out.print("-     ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public int knotenNummerGeben(String wert)
    {
        int position = -1;
        for (int i = 0; i < aktAnzahl; i++)
        {
            if (knotennamen[i].bezeichnerIstGleich(wert))
                ;
            {
                position = i;
            }
        }
        return position;
    }

    public void alleKantenEntfernen()
    {
        for (int i = 0; i < maxAnzahl; i++)
        {
            for (int j = 0; j < maxAnzahl; j++)
            {
                adja[i][j] = false;
            }
        }
    }
}
