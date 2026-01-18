package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_angestellter;

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
     * Baut die Verbindung zur Datenbank auf.
     */
    private DATENBANKVERBINDUNG()
    {
        allebeobachter = new ArrayList<MELDUNGSBEOBACHTER>();
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
     * @param nummer Schlüssel des Objekts
     *
     * @return Info über das Objekt.
     */
    OBJEKTINFO ObjektHolen(int nummer)
    {
        OBJEKTINFO res;
        Statement st;
        ResultSet rs;
        res = null;
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery(
                    "SELECT Name, Groesse, AnzahlZimmer, AnzahlPersonen, Landnummer, Art, Preis, Ausstattung, Sperre "
                            + "FROM objekt WHERE Wohnungsnummer = " + nummer);
            if (rs.next())
            {
                res = new OBJEKTINFO(nummer, rs.getString("Name"),
                        rs.getInt("Groesse"), rs.getInt("AnzahlZimmer"),
                        rs.getInt("AnzahlPersonen"), rs.getInt("Landnummer"),
                        rs.getString("Art"), rs.getDouble("Preis"),
                        rs.getString("Ausstattung"), rs.getBoolean("Sperre"));
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
     * @return Infos über die Objekte.
     */
    OBJEKTINFO[] AlleObjekteHolen()
    {
        OBJEKTINFO[] res;
        int index;
        Statement st;
        ResultSet rs;
        res = null;
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT(*) FROM objekt");
            if (rs.next())
            {
                res = new OBJEKTINFO[rs.getInt(1)];
                rs.close();
                index = 0;
                rs = st.executeQuery(
                        "SELECT WohnungsNummer, Name, Groesse, AnzahlZimmer, AnzahlPersonen, Landnummer, Art, Preis, Ausstattung, Sperre "
                                + "FROM objekt ORDER BY WohnungsNummer");
                while (rs.next())
                {
                    res[index] = new OBJEKTINFO(rs.getInt("WohnungsNummer"),
                            rs.getString("Name"), rs.getInt("Groesse"),
                            rs.getInt("AnzahlZimmer"),
                            rs.getInt("AnzahlPersonen"),
                            rs.getInt("Landnummer"), rs.getString("Art"),
                            rs.getDouble("Preis"), rs.getString("Ausstattung"),
                            rs.getBoolean("Sperre"));
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
     * Holt die Daten der Kunden.
     *
     * @return Infos über die Objekte.
     */
    KUNDENINFO[] AlleKundenHolen()
    {
        KUNDENINFO[] res;
        int index;
        Statement st;
        ResultSet rs;
        res = null;
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT(*) FROM kunde");
            if (rs.next())
            {
                res = new KUNDENINFO[rs.getInt(1)];
                rs.close();
                index = 0;
                rs = st.executeQuery(
                        "SELECT Benutzername, Name, Vorname, Passwort "
                                + "FROM kunde ORDER BY Name, Vorname");
                while (rs.next())
                {
                    res[index] = new KUNDENINFO(rs.getString("Benutzername"),
                            rs.getString("Name"), rs.getString("Vorname"),
                            rs.getString("Passwort"));
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
     * Trägt ein neues Land in die Liste der Länder ein.
     *
     * @param name Name des neuen Landes
     */
    void NeuesLandEintragen(String name)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO land (Name) VALUES ('" + name + "')");
            st.close();
            LogeintragMelden("Neues Land eingetragen: " + name);
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * ändern eines Objekts mit den gegebenen Daten.
     *
     * @param nummer Schlüssel des Objekts
     * @param name Name des Objekts
     * @param groesse Wohnfläche des Objekts
     * @param zimmer Anzahl der Zimmer
     * @param personen Maximale Anzahl der Personen
     * @param land Beschreibung des Landes
     * @param art "Wohnung" oder "Haus"
     * @param preis Wochenpreis
     * @param gesperrt Buchungssperre
     * @param ausstattungen Zusatzausstattungen
     */
    void ObjektAendern(int nummer, String name, int groesse, int zimmer,
            int personen, int land, String art, double preis, boolean gesperrt,
            String ausstattungen)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE objekt SET Name = '" + name
                    + "', Groesse = " + groesse + ", Anzahlzimmer = " + zimmer
                    + ", Anzahlpersonen = " + personen + ", Landnummer = "
                    + land + ", Ausstattung = '" + ausstattungen + "', Preis = "
                    + preis + ", Sperre = " + (gesperrt ? 1 : 0)
                    + " WHERE WohnungsNummer = " + nummer);
            st.close();
            LogeintragMelden(
                    "Objekt ge\u00E4ndert: " + nummer + " (" + name + ")");
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Einfügen eines Objekts mit den gegebenen Daten.
     *
     * @param name Name des Objekts
     * @param groesse Wohnfläche des Objekts
     * @param zimmer Anzahl der Zimmer
     * @param personen Maximale Anzahl der Personen
     * @param land Beschreibung des Landes
     * @param art "Wohnung" oder "Haus"
     * @param preis Wochenpreis
     * @param gesperrt Buchungssperre
     * @param ausstattungen Zusatzausstattungen
     */
    int NeuesObjektAnlegen(String name, int groesse, int zimmer, int personen,
            int land, String art, double preis, boolean gesperrt,
            String ausstattungen)
    {
        Statement st;
        ResultSet rs;
        int res;
        res = 0;
        try
        {
            st = conn.createStatement();
            st.executeUpdate(
                    "INSERT INTO objekt (Name, Groesse, Anzahlzimmer, Anzahlpersonen, Landnummer, Ausstattung, Art, Preis, Sperre) "
                            + "VALUES ('" + name + "', " + groesse + ", "
                            + zimmer + ", " + personen + ", " + land + ", '"
                            + ausstattungen + "', '" + art + "', " + preis
                            + ", " + (gesperrt ? 1 : 0) + ")");
            rs = st.executeQuery("SELECT MAX(WohnungsNummer) FROM objekt");
            if (rs.next())
            {
                res = rs.getInt(1);
            }
            rs.close();
            st.close();
            LogeintragMelden("Neues Objekt eingetragen: " + name);
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
        return res;
    }

    /**
     * Löschen des angegebenen Objekts.
     *
     * @param nummer Schlüssel des Objekts
     */
    void ObjektLoeschen(int nummer)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate(
                    "DELETE FROM objekt WHERE WohnungsNummer = " + nummer);
            st.close();
            LogeintragMelden("Objekt gel\u00F6scht: " + nummer);
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Einfügen eines Kunden mit den gegebenen Daten.
     *
     * @param benutzername Schlüssel des Kunden
     * @param name Name des Kunden
     * @param vorname Vorname des Kunden
     */
    void NeuenKundenAnlegen(String benutzername, String name, String vorname)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate(
                    "INSERT INTO kunde (Benutzername, Name, Vorname, Passwort) "
                            + "VALUES ('" + benutzername + "', '" + name
                            + "', '" + vorname + "', '')");
            st.close();
            LogeintragMelden("Neuen Kunden eingetragen: " + benutzername);
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * ändern eines Kunden mit den gegebenen Daten.
     *
     * @param benutzername Schlüssel des Kunden
     * @param name Name des Kunden
     * @param vorname Vorname des Kunden
     */
    void KundenAendern(String benutzername, String name, String vorname)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE kunde SET Name = '" + name
                    + "', Vorname = '" + vorname + "' "
                    + " WHERE Benutzername = '" + benutzername + "'");
            st.close();
            LogeintragMelden("Kunde ge\u00E4ndert: " + benutzername + " ("
                    + name + ", " + vorname + ")");
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Veranlasst das Löschen des angegebenen Kunden.
     *
     * @param benutzername Schlüssel des Kunden
     */
    void KundenLoeschen(String benutzername)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate(
                    "DELETE FROM kunde WHERE Benutzername = " + benutzername);
            st.close();
            LogeintragMelden("Kunde gel\u00F6scht: " + benutzername);
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
            LogeintragMelden("Passwort ge\u00E4ndert: " + benutzername + " ("
                    + pass + ")");
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Erzeugt einen eindeutigen Benutzernamen
     *
     * @param name Name des Benutzers
     * @param vorname Vorname des Benutzers
     *
     * @return eindeutiger
     */
    String BenutzernamenErzeugen(String name, String vorname)
    {
        String res;
        Statement st;
        ResultSet rs;
        int index;
        name = name.toLowerCase();
        vorname = vorname.toLowerCase();
        res = vorname + "." + name;
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery(
                    "SELECT COUNT(*) FROM kunde WHERE Benutzername = '" + res
                            + "'");
            if (rs.next() && (rs.getInt(1) > 0))
            {
                index = 1;
                do
                {
                    res = vorname + "." + name + index;
                    if (res.length() > 16)
                    {
                        res = res.substring(0, 14) + index;
                    }
                    rs.close();
                    rs = st.executeQuery(
                            "SELECT COUNT(*) FROM kunde WHERE Benutzername = '"
                                    + res + "'");
                }
                while (rs.next() && (rs.getInt(1) > 0));
            }
            rs.close();
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
        return res;
    }

    /**
     * Holt die Liste Buchungen für ein bestimmtes Objekt
     *
     * @param nummer Schlüssel des Objekts
     *
     * @return Info über alle Buchungen des Objekts
     */
    RESERVIERUNGSINFO[] BuchungenFuerObjektHolen(int nummer)
    {
        RESERVIERUNGSINFO[] res;
        int index;
        Statement st;
        ResultSet rs;
        res = null;
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery(
                    "SELECT COUNT(*) FROM reservierungen WHERE WohnungsNummer = "
                            + nummer);
            if (rs.next())
            {
                res = new RESERVIERUNGSINFO[rs.getInt(1)];
                rs.close();
                rs = st.executeQuery(
                        "SELECT Nummer, reservierungen. WohnungsNummer AS WohnungsNummer, Benutzername, "
                                + "reservierungen. Art AS Art, Startdatum, Enddatum, Name FROM reservierungen, objekt "
                                + "WHERE reservierungen. WohnungsNummer = objekt. WohnungsNummer AND reservierungen. WohnungsNummer = "
                                + nummer + " ORDER BY Startdatum");
                index = 0;
                while (rs.next())
                {
                    res[index] = new RESERVIERUNGSINFO(rs.getInt("Nummer"),
                            rs.getInt("WohnungsNummer"), "",
                            rs.getString("Benutzername"), rs.getString("Art"),
                            rs.getDate("Startdatum"), rs.getDate("Enddatum"));
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
     * Holt die Liste Buchungen für einen bestimmten Kunden
     *
     * @param name Schlüssel des Kunden
     *
     * @return Info über alle Buchungen des Kunden
     */
    RESERVIERUNGSINFO[] BuchungenFuerKundenHolen(String name)
    {
        RESERVIERUNGSINFO[] res;
        int index;
        Statement st;
        ResultSet rs;
        res = null;
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery(
                    "SELECT COUNT(*) FROM reservierungen WHERE Benutzername = '"
                            + name + "'");
            if (rs.next())
            {
                res = new RESERVIERUNGSINFO[rs.getInt(1)];
                rs.close();
                rs = st.executeQuery(
                        "SELECT Nummer, reservierungen. WohnungsNummer AS WohnungsNummer, Benutzername, "
                                + "reservierungen. Art AS Art, Startdatum, Enddatum, Name FROM reservierungen, objekt "
                                + "WHERE reservierungen. WohnungsNummer = objekt. WohnungsNummer AND Benutzername = '"
                                + name + "' ORDER BY Startdatum");
                index = 0;
                while (rs.next())
                {
                    res[index] = new RESERVIERUNGSINFO(rs.getInt("Nummer"),
                            rs.getInt("WohnungsNummer"), rs.getString("Name"),
                            rs.getString("Benutzername"), rs.getString("Art"),
                            rs.getDate("Startdatum"), rs.getDate("Enddatum"));
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
     * Veranlasst das Löschen der angegebenen Buchung.
     *
     * @param nummer Schlüssel der Buchung
     */
    void BuchungLoeschen(int nummer)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate(
                    "DELETE FROM reservierungen WHERE Nummer = " + nummer);
            st.close();
            LogeintragMelden("Buchung gel\u00F6scht: " + nummer);
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Veranlasst das Umwandeln einer Reservierung in eine feste Buchung.
     *
     * @param nummer Schlüssel der Buchung
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
            LogeintragMelden("Reservierung gebucht: " + nummer);
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }
}
