package org.bschlangaul.schulbuecher.cornelsen.shared.graph_visualisierung;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
public class Lesen
{

    /**
     * Liest die Datenbank unter dem gegebenen Namen ein und trägt die Daten in
     * den Graphen ein.
     *
     * @param name Name (und Pfad) der Datenbankcontainerdatei
     * @param g das Graphenobjekt, in dem die Daten eingetragen werden sollen
     */
    public boolean LesenDatenbank(String name, GraphMatrix g)
    {
        try
        {
            // Eingefügt, damit die Datei in main/resources/graph-datases
            // abgelegt werden kann.
            Path source = Paths.get(
                    getClass().getResource("/graph-databases/" + name).toURI());
            Path target = Paths.get(System.getProperty("java.io.tmpdir"), name);
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            Connection verbindung;
            verbindung = DriverManager
                    .getConnection("jdbc:sqlite:" + target.toString());
            Statement anweisung = verbindung.createStatement();
            ResultSet daten = anweisung.executeQuery(
                    "SELECT bezeichner, x, y FROM knoten ORDER BY bezeichner");
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
}
