package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Stellt die Methoden zum Zugriff auf die Datenbank zur Verfügung.
 *
 * @author Albert Wiedemann
 *
 * @version 16.06.06
 */
class DATENBANKVERBINDUNG implements MELDUNGSERZEUGER
{
    /**
     * Speichert die Verbindung zur Datenbank.
     */
    private Connection conn;

    /**
     * Die Meldungsbeobachter
     */
    private ArrayList<MELDUNGSBEOBACHTER> allebeobachter;

    /**
     * Baut die Verbindung zur Datenbank auf.
     */
    DATENBANKVERBINDUNG()
    {
        allebeobachter = new ArrayList<MELDUNGSBEOBACHTER>();
        try
        {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor()
                    .newInstance();
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/bankverwaltung?user=bank&password=verwaltung");
            // conn = DriverManager.
            // getConnection("jdbc:mysql://126.0.0.2/bankverwaltung?user=bank&password=verwaltung");
            LogeintragMelden("Verbindung aufgebaut.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Registriert einen Beobachter beim Produzenten.
     *
     * @param beobachter der neue Beobachter
     */
    public void Registrieren(MELDUNGSBEOBACHTER beobachter)
    {
        allebeobachter.add(beobachter);
    }

    /**
     * Meldet einen Beobachter beim Produzenten ab.
     *
     * @param beobachter der abzumeldende Beobachter
     */
    public void Abmelden(MELDUNGSBEOBACHTER beobachter)
    {
        allebeobachter.remove(beobachter);
    }

    /**
     * Trägt eine Logmeldung für alle Beobachte ein.
     *
     * @param text der Logeintrag
     */
    private void LogeintragMelden(String text)
    {
        for (MELDUNGSBEOBACHTER b : allebeobachter)
        {
            b.LogeintragEmpfangen(text);
        }
    }

    /**
     * Meldet die Ausnahemsituation an alle Beobachter
     *
     * @param e die Ausnahemsituation
     */
    private void ExceptionMelden(Exception e)
    {
        StackTraceElement[] stack = e.getStackTrace();
        for (MELDUNGSBEOBACHTER b : allebeobachter)
        {
            b.FehlermeldungEmpfangen(e.getMessage());
            for (int i = 0; i < stack.length; i++)
            {
                b.FehlermeldungEmpfangen(stack[i].toString());
            }
            b.LogeintragEmpfangen(e.getMessage());
        }
    }

    /**
     * Meldet einen Fehler an alle Beobachter
     *
     * @param text der Fehler
     */
    private void FehlerMelden(String text)
    {
        for (MELDUNGSBEOBACHTER b : allebeobachter)
        {
            b.FehlermeldungEmpfangen(text);
            b.LogeintragEmpfangen(text);
        }
    }

    /**
     * Beendet die Verbindung, danach ist Schluss.
     */
    void VerbindungBeenden()
    {
        try
        {
            conn.close();
            LogeintragMelden("Verbindung beendet.");
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Holt die Liste der Kunden aus der Datenbank.
     *
     * @param kunden Liste zur Verwaltung der Kunden.
     */
    void KundenHolen(PERSONENLISTE kunden)
    {
        try
        {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT name, pin FROM person WHERE klasse='k'");
            while (rs.next())
            {
                kunden.Einfuegen(
                        new KUNDE(rs.getString("name"), rs.getInt("pin")));
            }
            rs.close();
            st.close();
            LogeintragMelden("Kundenliste angefordert.");
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Holt die Liste der Kunden aus der Datenbank.
     *
     * @param angestellte Liste zur Verwaltung der Angestellten.
     * @param bank Bank, für die der Angestellte arbeitet.
     */
    void AngestellteHolen(PERSONENLISTE angestellte, BANK bank)
    {
        try
        {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT name, pin FROM person WHERE klasse='a'");
            while (rs.next())
            {
                angestellte.Einfuegen(new ANGESTELLTER(rs.getString("name"),
                        rs.getInt("pin"), bank));
            }
            rs.close();
            st.close();
            LogeintragMelden("Angestelltenliste angefordert.");
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Holt die Liste der Konten aus der Datenbank.
     *
     * @param konten Liste zur Verwaltung der Konten.
     */
    void KontenHolen(KONTENLISTE konten, PERSONENLISTE kunden)
    {
        try
        {
            Statement st;
            ResultSet rs;
            String eigentuemer;
            KUNDE akt;
            KONTO k;
            st = conn.createStatement();
            rs = st.executeQuery(
                    "SELECT konto.kontonummer, kontostand, eigentuemer, zinssatz FROM konto, sparkonto WHERE konto.kontonummer=sparkonto.kontonummer");
            while (rs.next())
            {
                eigentuemer = rs.getString("eigentuemer");
                akt = (KUNDE) kunden.Suchen(eigentuemer);
                k = new SPARKONTO(rs.getInt("kontonummer"),
                        rs.getFloat("kontostand"), rs.getFloat("zinssatz"), akt,
                        this);
                konten.Einfuegen(k);
            }
            rs.close();
            rs = st.executeQuery(
                    "SELECT konto.kontonummer, kontostand, eigentuemer, ueberziehungsrahmen FROM konto, girokonto WHERE konto.kontonummer=girokonto.kontonummer");
            while (rs.next())
            {
                eigentuemer = rs.getString("eigentuemer");
                akt = (KUNDE) kunden.Suchen(eigentuemer);
                k = new SPARKONTO(rs.getInt("kontonummer"),
                        rs.getFloat("kontostand"),
                        rs.getFloat("ueberziehungsrahmen"), akt, this);
                konten.Einfuegen(k);
            }
            rs.close();
            st.close();
            LogeintragMelden("Kontenliste angefordert.");
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Speichert den neuen Angestellten in der Datenbank. Die Eindeutigkeit des
     * Namens muss überprüft sein.
     *
     * @param a der zu speichernde Angestellte
     */
    void NeuenAngestelltenEinfuegen(ANGESTELLTER a)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO person (name, pin, klasse) VALUES ('"
                    + a.NameGeben() + "', '" + a.PinGeben() + "', 'a')");
            st.close();
            LogeintragMelden(
                    "Neuer Angestellter eingefügt: " + a.NameGeben() + ".");
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Speichert den neuen Kunden in der Datenbank. Die Eindeutigkeit des Namens
     * muss überprüft sein.
     *
     * @param k der zu speichernde Kunde
     */
    void NeuenKundenEinfuegen(KUNDE k)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO person (name, pin, klasse) VALUES ('"
                    + k.NameGeben() + "', '" + k.PinGeben() + "', 'k')");
            st.close();
            LogeintragMelden("Neuer Kunde eingefügt: " + k.NameGeben() + ".");
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Setzt eine neue PIN für den Kunden.
     *
     * @param name Name des Kunden
     * @param nummer die neue PIN
     */
    void PinSetzen(String name, int nummer)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE person SET pin=" + nummer + " WHERE name='"
                    + name + "'");
            st.close();
            LogeintragMelden("PIN gesetzt für Person: " + name + ".");
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Speichert das neue Sparkonto in der Datenbank.
     *
     * @param konto das neu einzurichtende Konto
     */
    void NeuesSparkontoEinfuegen(SPARKONTO konto)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate(
                    "INSERT INTO konto (kontonummer, kontostand, eigentuemer) VALUES ("
                            + konto.KontonummerGeben() + ", "
                            + konto.KontostandGeben() + ", '"
                            + konto.EigentuemerGeben().NameGeben() + "')");
            st.executeUpdate(
                    "INSERT INTO sparkonto (kontonummer, zinssatz) VALUES ("
                            + konto.KontonummerGeben() + ", "
                            + konto.ZinssatzGeben() + ")");
            st.close();
            LogeintragMelden("Neues Sparkonto eingefügt mit Nummer: "
                    + konto.KontonummerGeben() + ".");
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Speichert das neue Girokonto in der Datenbank.
     *
     * @param konto das neu einzurichtende Konto
     */
    void NeuesGirokontoEinfuegen(GIROKONTO konto)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate(
                    "INSERT INTO konto (kontonummer, kontostand, eigentuemer) VALUES ("
                            + konto.KontonummerGeben() + ", "
                            + konto.KontostandGeben() + ", '"
                            + konto.EigentuemerGeben().NameGeben() + "')");
            st.executeUpdate(
                    "INSERT INTO girokonto (kontonummer, ueberziehungsrahmen) VALUES ("
                            + konto.KontonummerGeben() + ", "
                            + konto.UeberziehungsrahmenGeben() + ")");
            st.close();
            LogeintragMelden("Neues Girokonto eingefügt mit Nummer: "
                    + konto.KontonummerGeben() + ".");
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Löscht das angegebene Konto aus der Datenbank. Der Kontostand wird als
     * "0" erwartet.
     *
     * @param konto das zu löschende Konto
     */
    void KontoLoeschen(KONTO konto)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM konto WHERE kontonummer="
                    + konto.KontonummerGeben());
            st.close();
            LogeintragMelden("Konto gel\u00F6scht mit Nummer: "
                    + konto.KontonummerGeben() + ".");
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Löscht die angegebene Person aus der Datenbank. Bei Kunden muss überprüft
     * sein, dass der Kunde keine Konten mehr hat.
     *
     * @param p die zu löschende Person
     */
    void PersonLoeschen(PERSON p)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate(
                    "DELETE FROM person WHERE name='" + p.NameGeben() + "'");
            st.close();
            LogeintragMelden(
                    "Person gel\u00F6scht mit Name: " + p.NameGeben() + ".");
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Setzt den Kontostand für das angegebene Konto. Ist bei jeder
     * Kontobewegung aufzurufen.
     *
     * @param konto das zu ändernde Konto
     * @param differenz die Kontoänderung
     */
    void KontostandSetzen(KONTO konto, double differenz, String beschreibung)
    {
        Statement st;
        ResultSet rs;
        int nummer;
        try
        {
            st = conn.createStatement();
            st.executeUpdate("UPDATE konto SET kontostand=kontostand+("
                    + differenz + ") WHERE kontonummer="
                    + konto.KontonummerGeben());
            rs = st.executeQuery(
                    "SELECT MAX(auszugsnummer) FROM auszugseintrag WHERE kontonummer="
                            + konto.KontonummerGeben());
            if (rs.next())
            {
                nummer = rs.getInt(1) + 1;
            }
            else
            {
                nummer = 1;
            }
            rs.close();
            st.executeUpdate(
                    "INSERT INTO auszugseintrag (kontonummer, auszugsnummer, datum, beschreibung, betrag) VALUES ("
                            + konto.KontonummerGeben() + ", " + nummer
                            + ", NOW(), '" + beschreibung + "', " + differenz
                            + ")");
            rs = st.executeQuery(
                    "SELECT kontostand FROM konto WHERE kontonummer="
                            + konto.KontonummerGeben());
            if ((!rs.next())
                    || (konto.KontostandGeben() != rs.getDouble("kontostand")))
            {
                FehlerMelden("Inkonsistez bei Kontostandsetzen für Konto: "
                        + konto.KontonummerGeben() + ", interner Stand: "
                        + konto.KontostandGeben() + ", gespeicherter Stand: "
                        + rs.getDouble("kontostand") + ".");
            }
            st.close();
            LogeintragMelden("Kontostand ge\u00E4ndert, Konto: "
                    + konto.KontonummerGeben() + ", Stand: "
                    + konto.KontostandGeben() + ".");
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Generiert die Daten für die Erstellung des Kontoauszugs.
     *
     * @param konto Konto, für das die Eintrsgäge erstellt werden sollen.
     *
     * @return Referenz auf das Ergebnisfeld oder null
     */
    AUSZUGSEINTRAG[] AuszugsdatenErstellen(KONTO konto)
    {
        Statement st;
        ResultSet rs;
        AUSZUGSEINTRAG[] resultat;
        int anzahl;
        int pos;
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery(
                    "SELECT COUNT(*) FROM auszugseintrag WHERE kontonummer="
                            + konto.KontonummerGeben());
            if (rs.next())
            {
                anzahl = rs.getInt(1);
            }
            else
            {
                anzahl = 0;
            }
            rs.close();
            if (anzahl == 0)
            {
                st.close();
                return null;
            }
            resultat = new AUSZUGSEINTRAG[anzahl];
            rs = st.executeQuery(
                    "SELECT * FROM auszugseintrag WHERE kontonummer="
                            + konto.KontonummerGeben()
                            + " ORDER BY auszugsnummer");
            for (pos = 0; rs.next(); pos++)
            {
                resultat[pos] = new AUSZUGSEINTRAG(rs.getInt("auszugsnummer"),
                        rs.getString("datum"), rs.getString("beschreibung"),
                        rs.getDouble("betrag"));
            }
            rs.close();
            st.close();
            LogeintragMelden("Auszüge angefordert für Konto: "
                    + konto.KontonummerGeben() + ".");
            return resultat;
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
        return null;
    }

    /**
     * Ermittelt die maximal bisher vergebene Kontonummer.
     *
     * @return maximal vergebene Kontonummer
     */
    int MaxKontonummerGeben()
    {
        Statement st;
        ResultSet rs;
        int max;
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT MAX(kontonummer) FROM konto ");
            if (rs.next())
            {
                max = rs.getInt(1);
            }
            else
            {
                max = 0;
            }
            rs.close();
            st.close();
            return max;
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
        return 0;
    }
}
