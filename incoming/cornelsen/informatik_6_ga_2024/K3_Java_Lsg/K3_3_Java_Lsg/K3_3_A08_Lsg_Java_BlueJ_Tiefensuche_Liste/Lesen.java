
import java.io.*;
import java.sql.*;
/**
 * Stellt Methoden zum Lesen der Graphendaten bereit
 * 
 * @author Albert Wiedemann 
 * @version 1.0
 */
class Lesen
{
    
    /**
     * Liest die Datenbank unter dem gegebenen Namen ein und trägt die Daten in den Graphen ein.
     * @param name Name (und Pfad) der Datenbankcontainerdatei
     * @param g das Graphenobjekt, in dem die Daten eingetragen werden sollen
     */
    boolean LesenDatenbank(String name, GraphListe g)
    {
        Connection verbindung;
        try
        {
            verbindung = DriverManager.getConnection("jdbc:sqlite:" + name);
            Statement anweisung = verbindung.createStatement();
            ResultSet daten = anweisung.executeQuery("SELECT bezeichner, x, y FROM knoten ORDER BY bezeichner");
            while (daten.next())
            {
                g.KnotenEinfügen(daten.getString("bezeichner"), daten.getInt("x"), daten.getInt("y"));
            }
            daten.close();
            daten = anweisung.executeQuery("SELECT bezeichnerStart, bezeichnerZiel, gewicht, gerichtet FROM kanten");
            while (daten.next())
            {
                g.KanteEinfügen(daten.getString("bezeichnerStart"), daten.getString("bezeichnerZiel"), daten.getInt("gewicht"));
            }
            daten.close();
            verbindung.close();
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Fehler beim Lesen der Datenbank: " +e.getMessage());
            return false;
        }
    }
}
