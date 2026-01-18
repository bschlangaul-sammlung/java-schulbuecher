package schulbuecher.cornelsen.informatik_5_2023.kapitel_01.thema_02.aufgabe_05.graph_matrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Stellt Methoden zum Lesen der Graphendaten bereit
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Lesen
{
    /**
     * Liest die Datenbank unter dem gegebenen Namen ein und trägt die Daten in
     * den Graphen ein.
     *
     * @param name Name (und Pfad) der Datenbankcontainerdatei
     * @param g das Graphenobjekt, in dem die Daten eingetragen werden sollen
     */
    boolean LesenDatenbank(String name, GraphMatrix g)
    {
        Connection verbindung;
        try
        {
            verbindung = DriverManager.getConnection("jdbc:sqlite:" + name);
            Statement anweisung = verbindung.createStatement();
            ResultSet daten = anweisung
                    .executeQuery("SELECT bezeichner, x, y FROM knoten");
            while (daten.next())
            {
                g.KnotenEinfügen(daten.getString("bezeichner"),
                        daten.getInt("x"), daten.getInt("y"));
            }
            daten.close();
            daten = anweisung.executeQuery(
                    "SELECT bezeichnerStart, bezeichnerZiel, gewicht, gerichtet FROM kanten");
            while (daten.next())
            {
                g.KanteEinfügen(daten.getString("bezeichnerStart"),
                        daten.getString("bezeichnerZiel"),
                        daten.getInt("gewicht"));
            }
            daten.close();
            verbindung.close();
            return true;
        }
        catch (Exception e)
        {
            System.out.println(
                    "Fehler beim Lesen der Datenbank: " + e.getMessage());
            return false;
        }
    }

    /**
     * Liest die Datei unter dem gegebenen Namen ein und trägt die Daten in den
     * Graphen ein.
     *
     * @param name Name (und Pfad) der Datei
     * @param g das Graphenobjekt, in dem die Daten eingetragen werden sollen
     */
    boolean LesenDatei(String name, GraphMatrix g)
    {
        try
        {
            BufferedReader eingabe = new BufferedReader(new FileReader(name));
            String zeile = eingabe.readLine();
            String[] teile = zeile.split(": ");
            int anzahl = new Integer(teile[1]);
            for (int i = 1; i <= anzahl; i += 1)
            {
                zeile = eingabe.readLine();
                teile = zeile.split("\t");
                g.KnotenEinfügen(teile[2], new Integer(teile[0]),
                        new Integer(teile[1]));
            }
            zeile = eingabe.readLine();
            teile = zeile.split(": ");
            anzahl = new Integer(teile[1]);
            for (int i = 1; i <= anzahl; i += 1)
            {
                zeile = eingabe.readLine();
                teile = zeile.split("\t");
                g.KanteEinfügen(teile[0], teile[1], new Integer(teile[2]));
            }
            eingabe.close();
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Fehler beim Lesen der Datei '" + name + "': "
                    + e.getMessage());
            return false;
        }
    }
}
