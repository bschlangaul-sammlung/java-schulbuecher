package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_auskunft;

import java.sql.*;

/**
 * Stellt die Methoden zum Zugriff auf die Datenbank zur Verfügung.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class DATENBANKVERBINDUNG
{
    /** Speichert das einzige Objekt der Klasse DATENBANKVERBINDUNG. */
    private static DATENBANKVERBINDUNG verb = new DATENBANKVERBINDUNG();

    /** Speichert die Verbindung zur Datenbank. */
    private Connection conn;

    /**
     * Baut die Verbindung zur Datenbank auf.
     */
    private DATENBANKVERBINDUNG()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/fahrplan?user=fahr&password=plan");
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
     * Beendet die Verbindung, danach ist Schluss.
     */
    void VerbindungBeenden()
    {
        try
        {
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Holt alle Daten.
     *
     * @param bliste in dieser Liste wird die Bahnhofsinformation aufgebaut.
     * @param aliste in dieser Liste wird die Abschnittsinformation aufgebaut.
     * @param uliste in dieser Liste wird die Umsteigeinformation aufgebaut.
     */
    void BahnhoefeHolen(BAHNHOFSLISTE bliste, ABSCHNITTSLISTE aliste,
            UMSTEIGELISTE uliste)
    {
        Statement st;
        ResultSet rs;
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT Nummer, Name, X, Y FROM bahnhof");
            while (rs.next())
            {
                bliste.Einfuegen(new BAHNHOF(rs.getInt("Nummer"),
                        rs.getString("Name"), rs.getInt("X"), rs.getInt("Y")));
            }
            rs.close();
            rs = st.executeQuery(
                    "SELECT linie, bahnhof1, bahnhof2, laenge FROM abschnitt");
            while (rs.next())
            {
                aliste.Einfuegen(
                        new ABSCHNITT(rs.getInt("linie"), rs.getInt("bahnhof1"),
                                rs.getInt("bahnhof2"), rs.getFloat("laenge")));
            }
            rs.close();
            rs = st.executeQuery(
                    "SELECT Nummer, Linie1, Linie2 FROM umsteigen");
            while (rs.next())
            {
                uliste.Einfuegen(new UMSTEIGEINFO(rs.getInt("Nummer"),
                        rs.getInt("Linie1"), rs.getInt("Linie2")));
            }
            rs.close();
            st.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
