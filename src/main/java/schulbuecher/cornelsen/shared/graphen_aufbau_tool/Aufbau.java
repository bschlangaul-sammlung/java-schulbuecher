package schulbuecher.cornelsen.shared.graphen_aufbau_tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Manueller Aufbau eies Graphen
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Aufbau implements EreignisEmpfaenger
{
    /**
     * Der Status für Dragging
     */
    private enum DraggingStatus
    {
        keinDragging, draggingMöglich, draggingAktiv
    }

    /**
     * Radius der Knotensymbole
     */
    private final int standardRadius = 20;

    /**
     * Farbe der Knotensymbole
     */
    private final String standardKnotenFarbe = "weiß";

    /**
     * Dicke der Kantensymbole
     */
    private final int standardDicke = 3;

    /**
     * Farbe der Kantensymbole
     */
    private final String standardKantenFarbe = "blau";

    /**
     * Die zugeordnete Oberfläche
     */
    private Oberflaeche oberfläche;

    /**
     * Der Draggingstatus
     */
    private DraggingStatus draggingStatus;

    /**
     * Die Knotensymbole
     */
    private ArrayList<KnotenSymbol> knoten;

    /**
     * Die Kantensymbole
     */
    private ArrayList<KantenSymbol> kanten;

    /**
     * Ein geklickter Knoten
     */
    private KnotenSymbol geklickterKnoten;

    /**
     * Ein gegebenenfalls selektierter Knoten
     */
    private KnotenSymbol selektierterKnoten;

    /**
     * Der selektierte Startknoten für eine Kante
     */
    private KnotenSymbol startKnoten;

    /**
     * Der selektierte Zielknoten für eine Kante
     */
    private KnotenSymbol zielKnoten;

    /**
     * Eine geklickte Kante
     */
    private KantenSymbol geklickteKante;

    /**
     * Eine gegebenenfalls selektierte Kante
     */
    private KantenSymbol selektierteKante;

    /**
     * Das Symbol für einen gezogenen Knoten
     */
    private GezogenerKnotenSymbol gezogenerKnoten;

    /**
     * wenn wahr, wurde der Graph geändert.
     */
    private boolean geändert;

    /**
     * Zähler für eindeutigen Knotenbezeichner
     */
    private int zähler;

    /**
     * Legt die Attribute an
     *
     * @param o das Oberflächenobjekt
     */
    Aufbau(Oberflaeche o)
    {
        oberfläche = o;
        knoten = new ArrayList<KnotenSymbol>();
        kanten = new ArrayList<KantenSymbol>();
        selektierterKnoten = null;
        startKnoten = null;
        zielKnoten = null;
        selektierteKante = null;
        geklickterKnoten = null;
        gezogenerKnoten = null;
        geklickteKante = null;
        selektierteKante = null;
        geändert = false;
        zähler = 0;
        draggingStatus = DraggingStatus.keinDragging;
        oberfläche.EmpfängerAnmelden(this);
    }

    /**
     * Die Maus wurde gedrückt.
     *
     * @param x x-Koordinate der Maus
     * @param y y-Koordinate der Maus
     * @param rechtsKlick rechte Maustaste gedrückt
     * @param ctrl Control-Taste ist fest gehalten
     * @param shift Shift-Taste ist fest gehalten
     * @param alt Alt-Taste ist fest gehalten
     */
    public void MausGedrückt(int x, int y, boolean rechtsKlick, boolean ctrl,
            boolean shift, boolean alt)
    {
        if (selektierterKnoten != null)
        {
            selektierterKnoten.FarbeSetzen(standardKnotenFarbe);
            selektierterKnoten = null;
        }
        if (selektierteKante != null)
        {
            selektierteKante.FarbeSetzen(standardKantenFarbe);
            selektierteKante = null;
        }
        oberfläche.KnotenBearbeitenStoppen();
        oberfläche.KantenBearbeitenStoppen();
        geklickterKnoten = IstKlickAufKnoten(x, y);
        if (geklickterKnoten != null)
        {
            selektierterKnoten = geklickterKnoten;
            geklickteKante = null;
            if (!(rechtsKlick || ctrl || shift || alt))
            {
                draggingStatus = DraggingStatus.draggingMöglich;
            }
        }
        else
        {
            geklickteKante = IstKlickAufKante(x, y);
            selektierteKante = geklickteKante;
        }
    }

    /**
     * Die Maus wurde geklickt.
     *
     * @param x x-Koordinate der Maus
     * @param y y-Koordinate der Maus
     * @param anzahl Anzahl der Klicks
     * @param rechtsKlick rechte Maustaste gedrückt
     * @param ctrl Control-Taste ist fest gehalten
     * @param shift Shift-Taste ist fest gehalten
     * @param alt Alt-Taste ist fest gehalten
     */
    public void MausGeklickt(int x, int y, int anzahl, boolean rechtsKlick,
            boolean ctrl, boolean shift, boolean alt)
    {
        if (geklickteKante != null)
        {
            selektierteKante.FarbeSetzen("orange");
            String[] daten = { selektierteKante.GewichtGeben(),
                    "" + selektierteKante.IstGerichtet() };
            oberfläche.KantenBearbeitenErmöglichen(daten);
            if (rechtsKlick || ctrl)
            {
                oberfläche.KantenPopupAnzeigen(x, y, daten);
            }
        }
        else
        {
            if (geklickterKnoten == null)
            {
                startKnoten = null;
                zielKnoten = null;
                selektierteKante = null;
                draggingStatus = DraggingStatus.keinDragging;
                if (shift)
                {
                    while (!BezeichnerPrüfen("K" + zähler))
                    {
                        zähler += 1;
                    }
                    KnotenSymbol k = new KnotenSymbol(x, y, standardRadius,
                            standardKnotenFarbe, "K" + zähler, oberfläche);
                    knoten.add(k);
                    geändert = true;
                    zähler += 1;
                }
            }
            else if (rechtsKlick || ctrl)
            {
                selektierterKnoten.FarbeSetzen("rot");
                String[] daten = { "" + selektierterKnoten.XGeben(),
                        "" + selektierterKnoten.YGeben(),
                        selektierterKnoten.BezeichnerGeben() };
                oberfläche.KnotenPopupAnzeigen(x, y, daten);
            }
            else if (shift)
            {
                if (geklickterKnoten != null)
                {
                    if (startKnoten == null)
                    {
                        startKnoten = geklickterKnoten;
                        startKnoten.FarbeSetzen("grün");
                    }
                    else
                    {
                        startKnoten.FarbeSetzen(standardKnotenFarbe);
                        if (startKnoten != zielKnoten)
                        {
                            KantenSymbol k = new KantenSymbol(startKnoten,
                                    geklickterKnoten, alt, "1", standardDicke,
                                    standardKantenFarbe, oberfläche);
                            kanten.add(k);
                            geändert = true;
                        }
                        startKnoten = null;
                        zielKnoten = null;
                        selektierteKante = null;
                    }
                }
            }
            else
            {
                selektierterKnoten.FarbeSetzen("rot");
                String[] daten = { "" + selektierterKnoten.XGeben(),
                        "" + selektierterKnoten.YGeben(),
                        selektierterKnoten.BezeichnerGeben() };
                oberfläche.KnotenBearbeitenErmöglichen(daten);
            }
        }
    }

    /**
     * Die Maus wurde Losgelassen.
     *
     * @param x x-Koordinate der Maus
     * @param y y-Koordinate der Maus
     * @param rechtsKlick rechte Maustaste gedrückt
     * @param ctrl Control-Taste ist fest gehalten
     * @param shift Shift-Taste ist fest gehalten
     * @param alt Alt-Taste ist fest gehalten
     */
    public void MausLosgelassen(int x, int y, boolean rechtsKlick, boolean ctrl,
            boolean shift, boolean alt)
    {
        if (draggingStatus == DraggingStatus.draggingAktiv)
        {
            oberfläche.Entfernen(gezogenerKnoten);
            gezogenerKnoten = null;
            selektierterKnoten.FarbeSetzen(standardKnotenFarbe);
            selektierterKnoten.PositionSetzen(x, y);
            selektierterKnoten = null;
            geändert = true;
        }
        draggingStatus = DraggingStatus.keinDragging;
    }

    /**
     * Die Maus wurde gedrückt gezogen.
     *
     * @param x x-Koordinate der Maus
     * @param y y-Koordinate der Maus
     */
    public void MausGezogen(int x, int y)
    {
        if (draggingStatus == DraggingStatus.draggingMöglich)
        {
            draggingStatus = DraggingStatus.draggingAktiv;
            gezogenerKnoten = new GezogenerKnotenSymbol(x, y, standardRadius,
                    oberfläche);
            selektierterKnoten.FarbeSetzen("gelb");
        }
        else if (draggingStatus == DraggingStatus.draggingAktiv)
        {
            gezogenerKnoten.PositionSetzen(x, y);
        }
        if (startKnoten != null)
        {
            startKnoten.FarbeSetzen(standardKnotenFarbe);
            startKnoten = null;
            zielKnoten = null;
            selektierteKante = null;
        }
    }

    /**
     * Der Menüpunkt Knotenlöschen wurde gewählt
     */
    public void KnotenLöschen()
    {
        knoten.remove(selektierterKnoten);
        oberfläche.Entfernen(selektierterKnoten);
        for (KantenSymbol k : new ArrayList<KantenSymbol>(kanten))
        {
            if ((k.StartsymbolGeben() == selektierterKnoten)
                    || (k.ZielsymbolGeben() == selektierterKnoten))
            {
                kanten.remove(k);
                oberfläche.Entfernen(k);
            }
        }
        selektierterKnoten = null;
        oberfläche.KnotenBearbeitenStoppen();
        geändert = true;
    }

    /**
     * Der Menüpunkt Knoten editieren wurde gewählt.
     *
     * @param x neue x-Koordinate
     * @param y neue y-Koordinate
     * @param bezeichner neuer Knotenbezeichner
     */
    public void KnotenEditieren(int x, int y, String bezeichner)
    {
        selektierterKnoten.PositionSetzen(x, y);
        selektierterKnoten.BezeichnerSetzen(bezeichner);
        geändert = true;
        oberfläche.KnotenBearbeitenStoppen();
        String[] daten = { "" + selektierterKnoten.XGeben(),
                "" + selektierterKnoten.YGeben(),
                selektierterKnoten.BezeichnerGeben() };
        oberfläche.KnotenBearbeitenErmöglichen(daten);
    }

    /**
     * Der Menüpunkt Kantenlöschen wurde gewählt.
     */
    public void KanteLöschen()
    {
        kanten.remove(selektierteKante);
        oberfläche.Entfernen(selektierteKante);
        selektierteKante = null;
        oberfläche.KantenBearbeitenStoppen();
        geändert = true;
    }

    /**
     * Der Menüpunkt Kante editieren wurde gewählt.
     *
     * @param gewicht die Gewichtsbezeichnung
     * @param gerichtet wenn wahr, ist die Kante gerichtet
     */
    public void KanteEditieren(String gewicht, boolean gerichtet)
    {
        selektierteKante.GewichtSetzen(gewicht);
        selektierteKante.GerichtetSetzen(gerichtet);
        geändert = true;
        oberfläche.KantenBearbeitenStoppen();
        String[] daten = { selektierteKante.GewichtGeben(),
                "" + selektierteKante.IstGerichtet() };
        oberfläche.KantenBearbeitenErmöglichen(daten);
    }

    /**
     * Testet, ob der Mausklick einen existierenden Knoten trifft
     *
     * @param x x-Position des Mausklicks
     * @param y y-Position des Mausklicks
     */
    private KnotenSymbol IstKlickAufKnoten(int x, int y)
    {
        for (KnotenSymbol k : knoten)
        {
            int dx = x - k.XGeben();
            int dy = y - k.YGeben();
            if (dx * dx + dy * dy <= standardRadius * standardRadius)
            {
                return k;
            }
        }
        return null;
    }

    /**
     * Testet, ob der Mausklick eine existierende Kante trifft
     *
     * @param x x-Position des Mausklicks
     * @param y y-Position des Mausklicks
     */
    private KantenSymbol IstKlickAufKante(int x, int y)
    {
        for (KantenSymbol k : kanten)
        {
            double x1 = k.StartsymbolGeben().XGeben();
            double y1 = k.StartsymbolGeben().YGeben();
            double x2 = k.ZielsymbolGeben().XGeben();
            double y2 = k.ZielsymbolGeben().YGeben();
            if (x1 == x2)
            {
                if ((Math.abs(x - x1) <= 5.0)
                        && ((y1 < y2) && (y1 <= y) && (y <= y2)
                                || (y1 >= y2) && (y1 >= y) && (y >= y2)))
                {
                    return k;
                }
            }
            else
            {
                double m = (y2 - y1) / (x2 - x1);
                double d = Math
                        .abs((m * (x - x1) + y1 - y) / Math.sqrt(m * m + 1)); // HNF
                if (d <= 5.0)
                {
                    if (Math.abs(m) > 1)
                    {
                        if ((y1 < y2) && (y1 <= y) && (y <= y2)
                                || (y1 > y2) && (y1 >= y) && (y >= y2))
                        {
                            return k;
                        }
                    }
                    else
                    {
                        if ((x1 < x2) && (x1 <= x) && (x <= x2)
                                || (x1 > x2) && (x1 >= x) && (x >= x2))
                        {
                            return k;
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * Sucht das zum gegebenen Namen gehörende Knotensymbol
     *
     * @param name Name des Knotens
     *
     * @return Referenz auf das zum gegebenen Namen gehörende Knotensymbol oder
     *     null
     */
    private KnotenSymbol NameSuchen(String name)
    {
        for (KnotenSymbol k : knoten)
        {
            if (k.BezeichnerGeben().equals(name))
            {
                return k;
            }
        }
        return null;
    }

    /**
     * Speichert die Datei am angegebenen Ort. Eine exisiterende Datei wird
     * gegebenenfalls überschrieben, eine Datenbank zuerst gelöscht.
     *
     * @param datei Dateiidentifikator
     */
    public void Sichern(File datei)
    {
        if (datei.getName().toLowerCase().endsWith(".grph"))
        {
            SichernDatei(datei);
        }
        else
        {
            SichernDatenbank(datei.getPath());
        }
    }

    /**
     * Speichert die Datei am angegebenen Ort. Eine exisiterende Datei wird
     * gegebenenfalls überschrieben.
     *
     * @param datei Dateiidentifikator
     */
    private void SichernDatei(File datei)
    {
        try
        {
            PrintWriter ausgabe = new PrintWriter(datei);
            ausgabe.println("Knoten: " + knoten.size());
            for (KnotenSymbol k : knoten)
            {
                ausgabe.println("" + k.XGeben() + "\t" + k.YGeben() + "\t"
                        + k.BezeichnerGeben());
            }
            ausgabe.println("Kanten: " + kanten.size());
            for (KantenSymbol k : kanten)
            {
                ausgabe.println("" + k.StartsymbolGeben().BezeichnerGeben()
                        + "\t" + k.ZielsymbolGeben().BezeichnerGeben() + "\t"
                        + k.GewichtGeben() + "\t" + k.IstGerichtet());
            }
            ausgabe.close();
            geändert = false;
        }
        catch (Exception e)
        {
            System.out.println("Fehler beim Schreiben der Datei '"
                    + datei.getName() + "': " + e.getMessage());
        }
    }

    /**
     * Speichert die Datenbank am angegebenen Ort. Eine exisiterende Datenbank
     * wird gegebenenfalls überschrieben.
     *
     * @param name Name (und Pfad) der Datenbankcontainerdatei
     */
    private void SichernDatenbank(String name)
    {
        Connection verbindung;
        try
        {
            verbindung = DriverManager.getConnection("jdbc:sqlite:" + name);
            Statement anweisung = verbindung.createStatement();
            anweisung.executeUpdate("DROP TABLE IF EXISTS knoten");
            anweisung.executeUpdate("DROP TABLE IF EXISTS kanten");
            anweisung.executeUpdate(
                    "CREATE TABLE \"knoten\" (\"bezeichner\" TEXT,\"x\" INTEGER NOT NULL, \"y\" INTEGER NOT NULL, PRIMARY KEY(\"bezeichner\"))");
            anweisung.executeUpdate(
                    "CREATE TABLE \"kanten\" (\"bezeichnerStart\" TEXT, \"bezeichnerZiel\" TEXT, \"gewicht\" TEXT, \"gerichtet\" TEXT)");
            for (KnotenSymbol k : knoten)
            {
                anweisung.executeUpdate(
                        "INSERT INTO knoten (bezeichner, x, y) VALUES ('"
                                + k.BezeichnerGeben() + "', " + k.XGeben()
                                + ", " + k.YGeben() + ")");
            }

            for (KantenSymbol k : kanten)
            {
                anweisung.executeUpdate(
                        "INSERT INTO kanten (bezeichnerStart, bezeichnerZiel, gewicht, gerichtet) VALUES ('"
                                + k.StartsymbolGeben().BezeichnerGeben()
                                + "', '" + k.ZielsymbolGeben().BezeichnerGeben()
                                + "', " + k.GewichtGeben() + ", "
                                + k.IstGerichtet() + ")");
            }
            geändert = false;

            verbindung.close();
        }
        catch (Exception ex)
        {
            System.out.println(
                    "Fehler beim Bearbeiten der Datenbank: " + ex.getMessage());
        }
    }

    /**
     * Entfernt alle Graphensymbole aus der Anzeige
     */
    public void ZurückSetzen()
    {
        for (KnotenSymbol k : knoten)
        {
            oberfläche.Entfernen(k);
        }
        knoten.clear();
        for (KantenSymbol k : kanten)
        {
            oberfläche.Entfernen(k);
        }
        kanten.clear();
        selektierterKnoten = null;
        startKnoten = null;
        zielKnoten = null;
        selektierteKante = null;
        geändert = false;
    }

    /**
     * Liest die Datei unter dem gegebenen Namen ein.
     *
     * @param datei Dateiidentifikator
     *
     * @return wahr, wenn die Datei gelesen werden konnte
     */
    public boolean Lesen(File datei)
    {
        ZurückSetzen();
        if (datei.getName().toLowerCase().endsWith(".grph"))
        {
            return LesenDatei(datei);
        }
        else
        {
            return LesenDatenbank(datei.getPath());
        }
    }

    /**
     * Liest die Datei unter dem gegebenen Namen ein.
     *
     * @param datei Dateiidentifikator
     *
     * @return wahr, wenn die Datei gelesen werden konnte
     */
    private boolean LesenDatei(File datei)
    {
        try
        {
            BufferedReader eingabe = new BufferedReader(new FileReader(datei));
            String zeile = eingabe.readLine();
            String[] teile = zeile.split(": ");
            int anzahl = Integer.parseInt(teile[1]);
            for (int i = 1; i <= anzahl; i += 1)
            {
                zeile = eingabe.readLine();
                teile = zeile.split("\t");
                knoten.add(new KnotenSymbol(Integer.parseInt(teile[0]),
                        Integer.parseInt(teile[1]), standardRadius,
                        standardKnotenFarbe, teile[2], oberfläche));
            }
            zeile = eingabe.readLine();
            teile = zeile.split(": ");
            anzahl = Integer.parseInt(teile[1]);
            for (int i = 1; i <= anzahl; i += 1)
            {
                zeile = eingabe.readLine();
                teile = zeile.split("\t");
                kanten.add(new KantenSymbol(NameSuchen(teile[0]),
                        NameSuchen(teile[1]), teile[3].equals("true"), teile[2],
                        standardDicke, standardKantenFarbe, oberfläche));
            }
            eingabe.close();
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Fehler beim Lesen der Datei '" + datei.getName()
                    + "': " + e.getMessage());
            return false;
        }
    }

    /**
     * Liest die Datenbank unter dem gegebenen Namen ein.
     *
     * @param name Name (und Pfad) der Datenbankcontainerdatei
     */
    private boolean LesenDatenbank(String name)
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
                knoten.add(new KnotenSymbol(daten.getInt("x"),
                        daten.getInt("y"), standardRadius, standardKnotenFarbe,
                        daten.getString("bezeichner"), oberfläche));
            }
            daten.close();
            daten = anweisung.executeQuery(
                    "SELECT bezeichnerStart, bezeichnerZiel, gewicht, gerichtet FROM kanten");
            while (daten.next())
            {
                kanten.add(new KantenSymbol(
                        NameSuchen(daten.getString("bezeichnerStart")),
                        NameSuchen(daten.getString("bezeichnerZiel")),
                        !daten.getString("gerichtet").equals("0"),
                        daten.getString("gewicht"), standardDicke,
                        standardKantenFarbe, oberfläche));
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
     * Meldet, ob der Graph geändert wurde.
     *
     * @return wahr, wenn der Graph geändert wurde
     */
    public boolean IstGeändert()
    {
        return geändert;
    }

    /**
     * Prüft, ob ein Knotenbezeichner eindeutig ist. Der selektierte Knoten wird
     * nicht betrachtet, da sein Name bleiben kann.
     *
     * @param bezeichner der zu prüfende Bezeichner
     */
    public boolean BezeichnerPrüfen(String bezeichner)
    {
        for (KnotenSymbol k : knoten)
        {
            if ((k != selektierterKnoten)
                    && k.BezeichnerGeben().equals(bezeichner))
            {
                return false;
            }
        }
        return true;
    }
}
