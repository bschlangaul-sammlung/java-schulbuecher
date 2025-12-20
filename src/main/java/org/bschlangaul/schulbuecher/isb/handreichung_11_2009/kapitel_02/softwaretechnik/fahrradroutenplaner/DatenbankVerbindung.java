package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.fahrradroutenplaner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Verwaltet die Verbindung des Programms zu Datenbank.
 *
 * @version 1.0
 */
class DatenbankVerbindung
{
    private String treiber = "com.mysql.jdbc.Driver"; // Treiber
    // private String treiber = "sun.jdbc.odbc.JdbcOdbcDriver";

    private String pfad = "jdbc:mysql://localhost/frp"; // Pfad zur Datenbank
    // String pfad ="jdbc:odbc:frp";

    private String user = "rm";

    private String pWort = "5678";

    // Erzeugung eines Objekts (Klassenvariable) Datenbankanbindung
    private Connection conn;

    /**
     * Der Konstruktor öffnet die Datenbankverbindung
     */
    DatenbankVerbindung()
    {
        // ODBC bzw. JDBC Treiber laden
        try
        {
            Class.forName(treiber);
        }
        catch (Exception e)
        {
            System.out
                    .println("Start_Fehler beim Laden des JDBC-Treibers " + e);
            System.exit(-1);
        }
        // öffnen der Datenbank beim MySqlServer
        try
        {
            conn = DriverManager.getConnection(pfad, user, pWort);
        }
        catch (Exception e)
        {
            System.out.println("Start_Fehler bei Datenbankzugriff\n" + e);
            System.exit(-1);
        }
    }

    /**
     * Beendet die Verbindung zur Datenbank, alle Resourcen werden freigegeben.
     */
    void Schliessen()
    {
        try
        {
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println(
                    "Fehler beim Beenden der Datenbankverbindung\n" + e);
        }
    }

    /**
     * Die Liste der Orte besetzen
     *
     * @param orte Liste für die Verwaltung der Orte
     */
    void OrteHolen(Liste orte)
    {
        ResultSet sqlResult;
        Statement stmt;
        try
        {
            stmt = conn.createStatement();
            sqlResult = stmt.executeQuery("SELECT * FROM ort");
            while (sqlResult.next())
            {
                orte.Anfuegen(new Ort(sqlResult.getString("Name"),
                        sqlResult.getString("Infos"), sqlResult.getInt("xpos"),
                        sqlResult.getInt("ypos")));
            }
            sqlResult.close();
            stmt.close();
        }
        catch (Exception e)
        {
            System.out.println("OrteHolen: Fehler bei SQL Abfrage\n" + e);
        }
    }

    /**
     * Die Liste der Orte besetzen.
     *
     * @param strecken Liste für die Verwaltung der Wege
     * @param orte Liste mit den Orten zur Bildung der Ortsreferenzen
     */
    void StreckenHolen(Liste strecken, Liste orte)
    {
        ResultSet sqlResult;
        Statement stmt;
        Ort ort1, ort2;
        try
        {
            stmt = conn.createStatement();
            sqlResult = stmt.executeQuery("SELECT * FROM strecke");
            while (sqlResult.next())
            {
                ort1 = (Ort) orte.Suchen(sqlResult.getString("Startort"));
                ort2 = (Ort) orte.Suchen(sqlResult.getString("Zielort"));
                if (ort1 == null)
                {
                    System.out.println("StreckenHolen: Unbekannter Ort: "
                            + sqlResult.getString("Startort"));
                }
                else if (ort2 == null)
                {
                    System.out.println("StreckenHolen: Unbekannter Ort: "
                            + sqlResult.getString("Zielort"));
                }
                else
                {
                    strecken.Anfuegen(new Strecke(ort1, ort2,
                            sqlResult.getString("Infos"),
                            sqlResult.getInt("Laenge"),
                            sqlResult.getInt("Steigung")));
                }
            }
            sqlResult.close();
            stmt.close();
        }
        catch (Exception e)
        {
            System.out.println("StreckenHolen: Fehler bei SQL Abfrage\n" + e);
        }
    }
}
