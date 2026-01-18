package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_kunde;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Stellt die Methoden zum Zugriff auf die Datenbank zur Verfügung.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class DATENBANKVERBINDUNG implements MELDUNGSERZEUGER
{
    /**
     * Speichert das einzige Objekt der Klasse DATENBANKVERBINDUNG.
     */
    private static DATENBANKVERBINDUNG verb = new DATENBANKVERBINDUNG();

    /**
     * Speichert die Verbindung zur Datenbank.
     */
    private Connection conn;

    /**
     * Die Meldungsbeobachter
     */
    private ArrayList<MELDUNGSBEOBACHTER> allebeobachter;

    /**
     * Für Datumskonvertierungen
     */
    SimpleDateFormat format;

    /**
     * Baut die Verbindung zur Datenbank auf.
     */
    private DATENBANKVERBINDUNG()
    {
        allebeobachter = new ArrayList<MELDUNGSBEOBACHTER>();
        format = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor()
                    .newInstance();
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/ferienwohnung?user=ferien&password=wohnung");
            LogeintragMelden("Verbindung aufgebaut.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Meldet das Verbindungsobjekt.
     *
     * @return verbindug
     */
    static DATENBANKVERBINDUNG VerbindungGeben()
    {
        return verb;
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
    @SuppressWarnings("unused")
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
     * Holt die Liste der vorhandenen Länder
     *
     * @return Info über alle vorhandenen Länder
     */
    LANDINFO[] LaenderHolen()
    {
        LANDINFO[] res;
        int index;
        Statement st;
        ResultSet rs;
        res = null;
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT(*) FROM land");
            if (rs.next())
            {
                res = new LANDINFO[rs.getInt(1)];
                rs.close();
                rs = st.executeQuery("SELECT LandNummer, Name FROM land");
                index = 0;
                while (rs.next())
                {
                    res[index] = new LANDINFO(rs.getInt("LandNummer"),
                            rs.getString("Name"));
                    index += 1;
                }
            }
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
        return res;
    }

    /**
     * Holt die Daten des angegebenen Objekts.
     *
     * @param liste in dieser Liste wird die Objektinformation aufgebaut.
     */
    void AlleObjekteHolen(OBJEKTLISTE liste)
    {
        Statement st;
        ResultSet rs;
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery(
                    "SELECT WohnungsNummer, Name, Groesse, AnzahlZimmer, AnzahlPersonen, Landnummer, Art, Preis, Ausstattung, Sperre "
                            + "FROM objekt ORDER BY WohnungsNummer");
            while (rs.next())
            {
                liste.Einfuegen(new OBJEKTINFO(rs.getInt("WohnungsNummer"),
                        rs.getString("Name"), rs.getInt("Groesse"),
                        rs.getInt("AnzahlZimmer"), rs.getInt("AnzahlPersonen"),
                        rs.getInt("Landnummer"), rs.getString("Art"),
                        rs.getDouble("Preis"), rs.getString("Ausstattung"),
                        rs.getBoolean("Sperre")));
            }
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Holt die Daten des angegebenen Kunden.
     *
     * @return Info über den Kunden.
     */
    KUNDENINFO KundeHolen(String benutzername)
    {
        KUNDENINFO res;
        Statement st;
        ResultSet rs;
        res = null;
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT Name, Vorname, Passwort "
                    + "FROM kunde WHERE Benutzername = '" + benutzername + "'");
            if (rs.next())
            {
                res = new KUNDENINFO(benutzername, rs.getString("Name"),
                        rs.getString("Vorname"), rs.getString("Passwort"));
            }
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
        return res;
    }

    /**
     * Holt die Reservierungen einer Wohnung im angegebenen Zeitraum
     */
    RESERVIERUNGSINFO[] ReservierungenHolen(int wohnung,
            java.util.Date startDatum, java.util.Date endeDatum)
    {
        RESERVIERUNGSINFO[] res;
        int index;
        Statement st;
        ResultSet rs;
        res = null;
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT(*) FROM reservierungen "
                    + "WHERE WohnungsNummer = " + wohnung
                    + " AND Startdatum <= '" + format.format(endeDatum)
                    + "' AND Enddatum >= '" + format.format(startDatum) + "'");
            if (rs.next())
            {
                res = new RESERVIERUNGSINFO[rs.getInt(1)];
                rs.close();
                rs = st.executeQuery(
                        "SELECT Nummer, WohnungsNummer, Benutzername, Art, Startdatum, Enddatum FROM reservierungen "
                                + "WHERE WohnungsNummer = " + wohnung
                                + " AND Startdatum <= '"
                                + format.format(endeDatum)
                                + "' AND Enddatum >= '"
                                + format.format(startDatum)
                                + "' ORDER BY Startdatum");
                index = 0;
                while (rs.next())
                {
                    res[index] = new RESERVIERUNGSINFO(rs.getInt("Nummer"),
                            rs.getInt("WohnungsNummer"), "",
                            rs.getString("Benutzername"), rs.getString("Art"),
                            rs.getDate("Startdatum"), rs.getDate("Enddatum"));
                    index += 1;
                }
                rs.close();
            }
            st.close();
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
        return res;
    }

    /**
     * Reserviert das angegebene Objekt im angegebenen Zeitraum (wenn frei);
     *
     * @param wohnung das gewählte Objekt
     * @param benutzer der reservierende Benutzer
     * @param start Startdatum des Interessezeitraums
     * @param ende Endedatum des Interessezeitraums
     */
    boolean Reservieren(int wohnung, String benutzer, java.util.Date start,
            java.util.Date ende)
    {
        Statement st;
        ResultSet rs;
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT(*) FROM reservierungen "
                    + "WHERE WohnungsNummer = " + wohnung
                    + " AND Startdatum <= '" + format.format(ende)
                    + "' AND Enddatum >= '" + format.format(start) + "'");
            if (!rs.next() || (rs.getInt(1) == 0))
            {
                rs.close();
                rs = st.executeQuery("SELECT COUNT(*) FROM reservierungen "
                        + "WHERE Benutzername = '" + benutzer
                        + "' AND Art = 'reserviert'");
                if (!rs.next() || (rs.getInt(1) < 4))
                {
                    st.executeUpdate(
                            "INSERT INTO reservierungen (WohnungsNummer, Benutzername, Art, Startdatum, Enddatum) "
                                    + "VALUES (" + wohnung + ", '" + benutzer
                                    + "', 'reserviert', '"
                                    + format.format(start) + "', '"
                                    + format.format(ende) + "')");
                    rs.close();
                    st.close();
                    return true;
                }
                rs.close();
                st.close();
            }
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
        return false;
    }

    /**
     * Holt alle (echten) Reservierungen für den angegebenen Benutzer
     *
     * @param benutzer der Benutzer
     *
     * @return Feld mit den echten Reservierungen
     */
    RESERVIERUNGSINFO[] ReservierungenFuerBenutzerHolen(String benutzer)
    {
        RESERVIERUNGSINFO[] res;
        int index;
        Statement st;
        ResultSet rs;
        res = null;
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT(*) FROM reservierungen "
                    + "WHERE Art = 'reserviert' AND Benutzername = '" + benutzer
                    + "'");
            if (rs.next())
            {
                res = new RESERVIERUNGSINFO[rs.getInt(1)];
                rs.close();
                rs = st.executeQuery(
                        "SELECT Nummer, reservierungen. WohnungsNummer AS WohnungsNummer, Benutzername, reservierungen. Art AS Art, Startdatum, Enddatum, Name FROM reservierungen, objekt "
                                + "WHERE reservierungen. Art = 'reserviert' AND objekt. WohnungsNummer = reservierungen. Wohnungsnummer AND Benutzername = '"
                                + benutzer + "'");
                index = 0;
                while (rs.next())
                {
                    res[index] = new RESERVIERUNGSINFO(rs.getInt("Nummer"),
                            rs.getInt("WohnungsNummer"), rs.getString("Name"),
                            rs.getString("Benutzername"), rs.getString("Art"),
                            rs.getDate("Startdatum"), rs.getDate("Enddatum"));
                    index += 1;
                }
                rs.close();
            }
            st.close();
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
        return res;
    }

    /**
     * Löschen der angegebenen Reservierung.
     *
     * @param nummer Schlüssel der Reservierung
     */
    void ReservierungLoeschen(int nummer)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate(
                    "DELETE FROM reservierungen WHERE Nummer = " + nummer);
            st.close();
            LogeintragMelden("Reservierung gel\u00F6scht: " + nummer);
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Wandelt die angegebenen Reservierung in eine feste Buchung um
     *
     * @param nummer Schlüssel der Reservierung
     */
    void ReservierungBuchen(int nummer)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate(
                    "UPDATE reservierungen SET Art = 'gebucht' WHERE Nummer = "
                            + nummer);
            st.close();
            LogeintragMelden("Reservierung fest gebucht: " + nummer);
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Veranlasst das Setzen des Passworts für den angegebenen Kunden.
     *
     * @param benutzername Schlüssel des Kunden
     * @param pass das Passwort des Kunden
     */
    void PasswortSetzen(String benutzername, String pass)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE kunde SET Passwort = '" + pass + "' "
                    + " WHERE Benutzername = '" + benutzername + "'");
            st.close();
            LogeintragMelden("Passwort ge\u00E4ndert: " + benutzername);
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }
}
