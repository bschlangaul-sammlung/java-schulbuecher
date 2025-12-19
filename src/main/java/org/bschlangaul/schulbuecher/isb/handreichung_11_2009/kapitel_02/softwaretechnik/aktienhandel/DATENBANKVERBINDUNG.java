package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.aktienhandel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Verwaltet die Verbindung des Programms zu Datenbank.
 *
 * @version 1.0
 */
class DATENBANKVERBINDUNG implements STATUSERZEUGER
{
    private String treiber = "com.mysql.jdbc.Driver"; // Treiber
    // private String treiber = "sun.jdbc.odbc.JdbcOdbcDriver";

    private String pfad = "jdbc:mysql://localhost/aktienhandel"; // Pfad zur
                                                                 // Datenbank
    // String pfad ="jdbc:odbc:aktienhandel";

    private String user = "aktien";

    private String pWort = "handel";

    // Erzeugung eines Objekts (Klassenvariable) Datenbankanbindung
    private Connection conn;

    // Hält die Referenz auf das einzige existierende Objekt der Klasse
    // DATENBANKVERBINDUNG
    private static DATENBANKVERBINDUNG verbindung = new DATENBANKVERBINDUNG();

    // Zum Absetzen der Fehlermeldungen
    private STATUSBEOBACHTER beobachter;

    /**
     * Der Konstruktor öffnet die Datenbankverbindung
     */
    private DATENBANKVERBINDUNG()
    {
        // Datenbankverbindung öffnen
        // Darf nur ein mal ausgeführt werden, daher wird das Muster Singleton
        // verwendet.
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
        beobachter = null;
    }

    /**
     * Registriert den Beobachter für die Fehlermeldungen
     *
     * @param b der Beobachter
     */
    public void Registrieren(STATUSBEOBACHTER b)
    {
        beobachter = b;
    }

    /**
     * Setzt die Fehlermeldung an einen Beobachter ab (falls vorhanden)
     *
     * @param text Fehlertext
     */
    private void Fehlermeldung(String text)
    {
        if (beobachter != null)
        {
            beobachter.FehlerSetzen(text);
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
            verbindung = null;
        }
        catch (Exception e)
        {
            Fehlermeldung("Fehler beim Beenden der Datenbankverbindung\n" + e);
        }
    }

    /**
     * Name einer Aktie holen
     *
     * @param aktienID Schlüssel der Aktie
     *
     * @return Name der angegebenen Aktie.
     */
    String AktienNameHolen(int aktienID)
    {
        ResultSet sqlResult;
        Statement stmt;
        String name;
        name = "";
        try
        {
            stmt = conn.createStatement();
            sqlResult = stmt.executeQuery(
                    "SELECT Name FROM aktie WHERE AktienID=" + aktienID);
            if (sqlResult.next())
            {
                name = sqlResult.getString("Name");
            }
            sqlResult.close();
            stmt.close();
        }
        catch (Exception e)
        {
            Fehlermeldung("AktieHolen: Fehler bei SQL Abfrage\n" + e);
        }
        return name;
    }

    /**
     * Liste der Aktien im Depot herausgeben
     *
     * @return Feld mit den IDs und Namen der Aktien.
     */
    String[] AktienNamenHolen()
    {
        ResultSet sqlResult;
        Statement stmt;
        String[] liste;
        try
        {
            stmt = conn.createStatement();
            sqlResult = stmt.executeQuery("SELECT AktienID, Name FROM aktie");
            sqlResult.afterLast();
            sqlResult.previous();
            liste = new String[sqlResult.getRow()];
            sqlResult.beforeFirst();
            int i = 0;
            while (sqlResult.next())
            {
                liste[i] = sqlResult.getString("AktienID") + " "
                        + sqlResult.getString("Name");
                i++;
            }
            sqlResult.close();
            stmt.close();
            return liste;
        }
        catch (Exception e)
        {
            Fehlermeldung("AktienHolen: Fehler bei SQL Abfrage\n" + e);
            return null;
        }
    }

    /**
     * Die gegebene Anzahl von Kursen einer Aktie holen
     */
    double[] KurseHolen(int kursAnzahl, int id)
    {
        double[] kurswerte;
        ResultSet sqlResult;
        Statement stmt;
        // Kurswertefeld initialisieren
        kurswerte = new double[kursAnzahl];
        // Aktieninformation aus der Datenbank holen
        try
        {
            stmt = conn.createStatement();
            sqlResult = stmt.executeQuery(
                    "SELECT Wert " + " FROM kurs " + " WHERE AktienID = " + id + // AktienID
                                                                                 // wird
                                                                                 // beim
                                                                                 // Aufruf
                                                                                 // mitgegeben
                            " ORDER BY Datum DESC " + // die jüngsten Kurse
                            " LIMIT " + kursAnzahl); // Anzahl wird beim Aufruf
                                                     // mitgegeben
        }
        catch (Exception e)
        {
            Fehlermeldung("KurseHolen: Fehler bei SQL Abfrage  \n" + e);
            return kurswerte;
        }
        // Die letzten kursAnzahl-vielen (festgelegt in Klasse Kursverlauf)
        // Aktienkurse aus der SQL Abfrage in die Kurseliste füllen
        try
        {
            int i = kursAnzahl;
            while ((sqlResult.next()) && (i > 0))
            {
                i--;
                kurswerte[i] = sqlResult.getDouble("Wert");
            }
            sqlResult.close();
            stmt.close();
        }
        catch (Exception e)
        {
            Fehlermeldung("KurseHolen: Fehler bei Datenbankzugriff  \n" + e);
        }
        return kurswerte;
    }

    /**
     * Liste der Aktienpakete im Depot herausgeben
     *
     * @return Arraylist mit allen vorhandenen Aktienpaketen
     */
    ArrayList<AKTIENPAKET> AktienpaketeGeben()
    {
        ArrayList<AKTIENPAKET> liste;
        ResultSet sqlResult = null;
        Statement stmt = null;
        liste = new ArrayList<AKTIENPAKET>();
        try
        {
            stmt = conn.createStatement();
            sqlResult = stmt.executeQuery(
                    "SELECT PaketNummer, Name, aktie.AktienID AS AktienID, Stueckzahl, KaufDatum, KaufKurs "
                            + "FROM depotaktie, aktie "
                            + "WHERE depotaktie.AktienID = aktie.AktienID;");
        }
        catch (Exception e)
        {
            Fehlermeldung("AktienpaketeGeben: Fehler bei SQL Abfrage\n" + e);
        }
        // Aktien aus der SQL Abfrage in die Depotliste füllen
        try
        {
            while (sqlResult.next())
            {
                liste.add(new AKTIENPAKET(sqlResult.getInt("PaketNummer"),
                        sqlResult.getInt("Stueckzahl"),
                        sqlResult.getString("Name"),
                        sqlResult.getInt("AktienID"),
                        sqlResult.getDouble("KaufKurs"),
                        sqlResult.getString("KaufDatum")));
            }
            sqlResult.close();
            stmt.close();
        }
        catch (Exception e)
        {
            Fehlermeldung(
                    "AktienpaketeGeben: Fehler bei Datenbankzugriff\n" + e);
        }
        return liste;
    }

    /**
     * Gesamtzahl aller Aktien einer Sorte im Depot ermitteln
     *
     * @param aktienID Schlüssel der Aktie
     *
     * @return Gesamtzahl der Aktien
     */
    int AktienAnzahlGeben(int aktienID)
    {
        ResultSet sqlResult;
        Statement stmt;
        int res;
        res = 0;
        try
        {
            stmt = conn.createStatement();
            sqlResult = stmt
                    .executeQuery("SELECT SUM(Stueckzahl) FROM depotaktie "
                            + "WHERE AktienID = " + aktienID);
            if (sqlResult.next())
            {
                res = sqlResult.getInt(1);
            }
            sqlResult.close();
            stmt.close();
        }
        catch (Exception e)
        {
            Fehlermeldung("AktienAnzahlGeben: Fehler bei SQL Abfrage\n" + e);
        }
        return res;
    }

    /**
     * Kleinstes Paket der gegebenen Aktie mit der gewünschten Mindestanzahl
     * holen.
     *
     * @param anzahl Mindestanzehl der Aktien im Paket
     * @param aktienID gewünschte Aktie
     */
    AKTIENPAKET AktienpaketGeben(int anzahl, int aktienID)
    {
        ResultSet sqlResult;
        Statement stmt;
        AKTIENPAKET res;
        res = null;
        try
        {
            stmt = conn.createStatement();
            sqlResult = stmt.executeQuery(
                    "SELECT PaketNummer, Name, Stueckzahl, KaufDatum, KaufKurs "
                            + "FROM depotaktie, aktie "
                            + "WHERE depotaktie.AktienID = aktie.AktienID AND aktie.AktienID="
                            + aktienID + " AND Stueckzahl>=" + anzahl
                            + " ORDER BY Stueckzahl;");
            if (sqlResult.next())
            {
                res = new AKTIENPAKET(sqlResult.getInt("PaketNummer"),
                        sqlResult.getInt("Stueckzahl"),
                        sqlResult.getString("Name"), aktienID,
                        sqlResult.getDouble("KaufKurs"),
                        sqlResult.getString("KaufDatum"));
            }
            sqlResult.close();
            stmt.close();
        }
        catch (Exception e)
        {
            Fehlermeldung("AktienpaketGeben: Fehler bei SQL Abfrage\n" + e);
        }
        return res;
    }

    /**
     * Größtes Paket der gegebenen Aktie holen.
     *
     * @param aktienID gewünschte Aktie
     */
    AKTIENPAKET GroesstesAktienpaketGeben(int aktienID)
    {
        ResultSet sqlResult;
        Statement stmt;
        AKTIENPAKET res;
        int maxanzahl;
        res = null;
        try
        {
            stmt = conn.createStatement();
            sqlResult = stmt
                    .executeQuery("SELECT MAX(Stueckzahl) FROM depotaktie "
                            + "WHERE AktienID = " + aktienID);
            if (sqlResult.next())
            {
                maxanzahl = sqlResult.getInt(1);
            }
            else
            {
                Fehlermeldung("GroesstesAktienpaketGeben: Dateninkonsistenz 1");
                return null;
            }
            sqlResult = stmt.executeQuery(
                    "SELECT PaketNummer, Name, KaufDatum, KaufKurs "
                            + "FROM depotaktie, aktie "
                            + "WHERE depotaktie.AktienID = aktie.AktienID AND aktie.AktienID="
                            + aktienID + " AND Stueckzahl=" + maxanzahl);
            if (sqlResult.next())
            {
                res = new AKTIENPAKET(sqlResult.getInt("PaketNummer"),
                        maxanzahl, sqlResult.getString("Name"), aktienID,
                        sqlResult.getDouble("KaufKurs"),
                        sqlResult.getString("KaufDatum"));
            }
            else
            {
                Fehlermeldung("GroesstesAktienpaketGeben: Dateninkonsistenz 2");
                return null;
            }
            sqlResult.close();
            stmt.close();
        }
        catch (Exception e)
        {
            Fehlermeldung("AktienpaketGeben: Fehler bei SQL Abfrage\n" + e);
        }
        return res;
    }

    /**
     * Verkauf aus einem Paket eintragen
     *
     * @param paketID Schlüssel des Pakets
     * @param aktienID Schlüssel der AKtie
     * @param anzahl Anzahl der zu verkaufenden Aktien
     * @param restAnzahl Anzahl der restlichen Aktien im Paket
     * @param kaufdat Datum des Kaufs
     * @param kaufkurs Kurs beim Einkauf
     * @param verkaufdat Datum des Verkaufs
     * @param verkaufkurs Kurs beim Verkauf
     */
    void VerkaufEintragen(int paketID, int aktienID, int anzahl, int restAnzahl,
            String kaufdat, double kaufkurs, String verkaufdat,
            double verkaufkurs)
    {
        Statement stmt;
        try
        {
            stmt = conn.createStatement();
            stmt.executeUpdate(
                    "INSERT INTO verkaeufe (AktienID, Stueckzahl, KDatum, KKurs, VDatum, VKurs) "
                            + " VALUES (" + aktienID + "," + anzahl + ", '"
                            + kaufdat + "'," + kaufkurs + ", '" + verkaufdat
                            + "'," + verkaufkurs + ");");
            if (restAnzahl > 0)
            {
                stmt.executeUpdate("UPDATE depotaktie SET Stueckzahl = "
                        + restAnzahl + " WHERE PaketNummer = " + paketID);
            }
            else
            {
                stmt.executeUpdate("DELETE FROM depotaktie WHERE PaketNummer = "
                        + paketID);
            }
            stmt.close();
        }
        catch (Exception e)
        {
            Fehlermeldung("VerkaufEintragen: Fehler bei SQL Abfrage\n" + e);
        }
    }

    /**
     * Gekauftes Aktienpaket in die Datenbank eintragen
     *
     * @param anzahl Zahl der Aktien im Paket
     * @param aktienID Schlüssel der Aktien
     * @param datum Datum des Kaufs
     * @param kurs Kurs, mit dem gekauft wurde.
     */
    void KaufEintragen(int anzahl, int aktienID, String datum, double kurs)
    {
        Statement stmt;
        try
        {
            stmt = conn.createStatement();
            stmt.executeUpdate(
                    "INSERT INTO DepotAktie(AktienId, Stueckzahl, Kaufdatum, Kaufkurs) "
                            + "VALUES (" + aktienID + "," + anzahl + ", '"
                            + datum + "'," + kurs + ");");
            stmt.close();
        }
        catch (Exception e)
        {
            Fehlermeldung("KaufEintragen: Fehler bei SQL Abfrage\n" + e);
        }
    }

    /**
     * Aktuellen Aktienkurs aus der Datenbank erfragen
     *
     * @param aktienID Schlüssel der Aktie
     *
     * @return Kursinformation oder null
     */
    KURSINFO AktuellerKurs(int aktienID)
    {
        ResultSet sqlResult;
        Statement stmt;
        KURSINFO info;
        info = null;
        try
        {
            stmt = conn.createStatement();
            sqlResult = stmt.executeQuery(
                    "SELECT Wert, Datum FROM Kurs WHERE AktienID =" + aktienID
                            + " ORDER BY Datum DESC;");
            if (sqlResult.next())
            {
                info = new KURSINFO(aktienID, sqlResult.getDouble("Wert"),
                        sqlResult.getString("Datum"));
            }
            stmt.close();
        }
        catch (Exception e)
        {
            Fehlermeldung("AktuellerKurs: Fehler bei SQL Abfrage\n" + e);
        }
        return info;
    }

    /**
     * Ermittelt die neuesten Kurse aller Aktien
     */
    KURSINFO[] AlleKurseGeben()
    {
        ResultSet sqlResult, sqlResult2;
        Statement stmt, stmt2;
        int anzahl, i;
        KURSINFO[] res;
        res = null;
        try
        {
            stmt = conn.createStatement();
            stmt2 = conn.createStatement();
            sqlResult = stmt.executeQuery(
                    "SELECT COUNT(*) FROM (SELECT DISTINCT AktienID FROM kurs) AS Ids");
            if (sqlResult.next())
            {
                anzahl = sqlResult.getInt(1);
                res = new KURSINFO[anzahl];
            }
            else
            {
                stmt.close();
                return null;
            }
            sqlResult = stmt.executeQuery(
                    "SELECT AktienID, MAX(Datum) AS Datum FROM kurs GROUP BY AktienID");
            i = 0;
            while (sqlResult.next())
            {
                sqlResult2 = stmt2
                        .executeQuery("SELECT AktienID, Wert, Datum FROM kurs "
                                + "WHERE AktienID="
                                + sqlResult.getString("AktienID")
                                + " AND Datum='" + sqlResult.getString("Datum")
                                + "'");
                if (sqlResult2.next())
                {
                    res[i] = new KURSINFO(sqlResult2.getInt("AktienID"),
                            sqlResult2.getDouble("Wert"),
                            sqlResult.getString("Datum"));
                }
                i++;
                sqlResult2.close();
            }
            sqlResult.close();
            stmt.close();
            stmt2.close();
        }
        catch (Exception e)
        {
            Fehlermeldung("AlleKurseGeben: Fehler bei SQL Abfrage \n" + e);
        }
        return res;
    }

    /**
     * Kurswerte eintragen
     */
    void NeueKurseEintragen(KURSINFO[] infos)
    {
        Statement stmt;
        ResultSet sqlResult;
        String datum;
        datum = null;
        try
        {
            stmt = conn.createStatement();
            sqlResult = stmt.executeQuery(
                    "SELECT  DATE_ADD(MAX(Datum), INTERVAL 1 DAY) AS Datum FROM kurs");
            if (sqlResult.next())
            {
                datum = sqlResult.getString("Datum");
            }
            else
            {
                sqlResult.close();
                sqlResult = stmt.executeQuery("SELECT  CURDATE() AS Datum");
                if (sqlResult.next())
                {
                    datum = sqlResult.getString("Datum");
                }
            }
            sqlResult.close();
            for (int i = 0; i < infos.length; i++)
            {
                stmt.executeUpdate("INSERT INTO kurs(AktienID, Wert, Datum) "
                        + " VALUES (" + infos[i].AktienIDGeben() + " ,"
                        + infos[i].KursGeben() + ",'" + datum + "');");
            }
            stmt.close();
        }
        catch (SQLException e)
        {
            Fehlermeldung("NeueKurseEintragen: Fehler bei SQL Abfrage\n" + e);
        }
    }

    /**
     * Gibt eine Referenz auf das Verbindungsobjekt zurück.
     *
     * @return Referenz auf das Verbindungsobjekt
     */
    static DATENBANKVERBINDUNG VerbindungGeben()
    {
        return verbindung;
    }
}
