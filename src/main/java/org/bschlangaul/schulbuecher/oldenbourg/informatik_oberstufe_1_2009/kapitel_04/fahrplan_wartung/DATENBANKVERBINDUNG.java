package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_wartung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Stellt die Methoden zum Zugriff auf die Datenbank zur Verfügung.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class DATENBANKVERBINDUNG
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

    /**
     * Fügt einen neuen Bahnhof in die Datenbank ein. Die Bahnhofsnummer wird
     * hier gesetzt.
     *
     * @param bahnhof der einzufügende Bahnhof.
     */
    void BahnhofEinfuegen(BAHNHOF bahnhof)
    {
        Statement st;
        ResultSet rs;
        try
        {
            st = conn.createStatement();
            st.executeUpdate("INSERT INTO bahnhof (Name, X, Y) VALUES ('"
                    + bahnhof.NameGeben() + "', " + bahnhof.XGeben() + ", "
                    + bahnhof.YGeben() + ")");
            rs = st.executeQuery("SELECT MAX(Nummer) FROM bahnhof");
            if (rs.next())
            {
                bahnhof.NummerSetzen(rs.getInt(1));
            }
            rs.close();
            st.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * ändert den angegebenen Bahnhof in der Datenbank. Die Bahnhofsnummer wird
     * hier gesetzt.
     *
     * @param bahnhof der zu ändernde Bahnhof.
     */
    void BahnhofAendern(BAHNHOF bahnhof)
    {
        Statement st;
        try
        {
            st = conn.createStatement();
            st.executeUpdate("UPDATE bahnhof SET Name='" + bahnhof.NameGeben()
                    + "', X=" + bahnhof.XGeben() + ", Y=" + bahnhof.YGeben()
                    + " WHERE Nummer=" + bahnhof.NummerGeben());
            st.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Löscht den angegebenen Bahnhof in der Datenbank. Die Bahnhofsnummer wird
     * hier gesetzt.
     *
     * @param bahnhof der zu löschende Bahnhof.
     */
    void BahnhofLoeschen(BAHNHOF bahnhof)
    {
        Statement st;
        try
        {
            st = conn.createStatement();
            st.executeUpdate("DELETE FROM bahnhof WHERE Nummer="
                    + bahnhof.NummerGeben());
            st.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Fügt einen neuen Abschnitt in die Datenbank ein.
     *
     * @param abschnitt der einzufügende Abschnitt.
     */
    void AbschnittEinfuegen(ABSCHNITT abschnitt)
    {
        Statement st;
        try
        {
            st = conn.createStatement();
            st.executeUpdate(
                    "INSERT INTO abschnitt (linie, bahnhof1, bahnhof2, laenge) VALUES ("
                            + abschnitt.LinieGeben() + ", "
                            + abschnitt.Bahnhof1Geben() + ", "
                            + abschnitt.Bahnhof2Geben() + ", "
                            + abschnitt.LaengeGeben() + ")");
            st.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * ändert die Länge eines Abschnitt in der Datenbank.
     *
     * @param abschnitt der einzufügende Abschnitt.
     */
    void AbschnittAendern(ABSCHNITT abschnitt)
    {
        Statement st;
        try
        {
            st = conn.createStatement();
            st.executeUpdate(
                    "UPDATE abschnitt SET laenge = " + abschnitt.LaengeGeben()
                            + " WHERE linie = " + abschnitt.LinieGeben()
                            + " AND bahnhof1 = " + abschnitt.Bahnhof1Geben()
                            + " AND bahnhof2 = " + abschnitt.Bahnhof2Geben());
            st.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Löscht einen Abschnitt aus der Datenbank.
     *
     * @param abschnitt der einzufügende Abschnitt.
     */
    void AbschnittLoeschen(ABSCHNITT abschnitt)
    {
        Statement st;
        try
        {
            st = conn.createStatement();
            st.executeUpdate("DELETE FROM abschnitt " + "WHERE linie = "
                    + abschnitt.LinieGeben() + " AND bahnhof1 = "
                    + abschnitt.Bahnhof1Geben() + " AND bahnhof2 = "
                    + abschnitt.Bahnhof2Geben());
            st.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Fügt eine neue Umsteigeinformation in die Datenbank ein.
     *
     * @param umsteigen die einzufügende Umsteigeinformation.
     */
    void UmsteigenEinfuegen(UMSTEIGEINFO umsteigen)
    {
        Statement st;
        try
        {
            st = conn.createStatement();
            st.executeUpdate(
                    "INSERT INTO umsteigen (Nummer, Linie1, Linie2) VALUES ("
                            + umsteigen.BahnhofGeben() + ", "
                            + umsteigen.VonLinieGeben() + ", "
                            + umsteigen.AbLinieGeben() + ")");
            st.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Löscht eine Umsteigeinformation aus der Datenbank.
     *
     * @param umsteigen die zu löschende Umsteigeinformation.
     */
    void UmsteigenLoeschen(UMSTEIGEINFO umsteigen)
    {
        Statement st;
        try
        {
            st = conn.createStatement();
            st.executeUpdate("DELETE FROM umsteigen WHERE Nummer ="
                    + umsteigen.BahnhofGeben() + " AND Linie1 = "
                    + umsteigen.VonLinieGeben() + " AND Linie2 = "
                    + umsteigen.AbLinieGeben());
            st.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
