package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_00.eierautomat;

import java.util.ArrayList;

import schulbuecher.cornelsen.shared.graphics_and_games.Dreieck;
import schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Eierautomat auf dem Lande
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Eierautomat
{
    /**
     * Feld, das die Eierkartons im Automaten verwaltet
     **/
    protected ArrayList<Eierkarton> eierkartons;

    /**
     * Besetzt die Attribute vor.
     */
    Eierautomat()
    {
        Rechteck automat = new Rechteck();
        automat.GrößeSetzen(100, 200);
        automat.FarbeSetzen("grau");
        automat.PositionSetzen(350, 200);
        Dreieck dach = new Dreieck();
        dach.GrößeSetzen(140, 50);
        dach.FarbeSetzen("rot");
        dach.PositionSetzen(400, 150);
        eierkartons = new ArrayList<Eierkarton>();
    }

    /**
     * Befüllen des Eierautomaten mit neuen Eierkartons
     */
    synchronized void Befüllen()
    {
        if (eierkartons.size() == 0)
        {
            // Der leere Automat wird mit zehn neuen Kartons befüllt.
            for (int zähler = 0; zähler < 10; zähler++)
            {
                eierkartons.add(new Eierkarton());
                eierkartons.get(zähler).PositionSetzen(375, 205 + 20 * zähler);
            }
        }
    }

    /**
     * Holen eines Eierkartons aus dem Automaten
     *
     * @return Eierkarton oder null bei Fehlversuch
     */
    synchronized Eierkarton EierHolen()
    {
        if (eierkartons.size() > 0)
        {
            // Ein Eierkarton wird aus dem Feld entfernt und seine Darstellung
            // aus dem Zeichenfenster
            Eierkarton gekaufterKarton = eierkartons.remove(0);
            gekaufterKarton.Entfernen();

            // Rueckgabe des gekauften Kartons
            return gekaufterKarton;
        }
        return null;
    }
}
