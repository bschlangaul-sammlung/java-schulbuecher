package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.robotersimulation;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.Zeichenfenster;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.robotersimulation.robotergrafik.Roboterarm;

/**
 * Simulation eines zweidimensionalen Roboters, bestehend aus einem drehbaren
 * Arm, einer Greifhand, einem Fliessband mit Kugeln und zwei Toepfen, in die
 * die Kugeln abgelegt werden koennen. Die Kugeln dieser Simulation sind
 * schwarz, grau, gruen, blau, rot, cyan, magenta, pink orange, gelb und weiss
 * (weiss nur deshalb, weil wir im Buch eine Aufgabe mit weissen Kugeln haben).
 * Weisse Kugeln werden hier (auf weissem Hintergrund) durch transparente
 * "Glaskugeln" mit schwarzem Rand dargestellt.
 *
 * @author Florian Prager, Ute Heuer, Frank Fiedler
 *
 * @version 03.2008
 */
public class Roboter
{
    /**
     * Das Attribut roboterarm ermoeglicht dieser Simulation, die Dienste eines
     * Roboterarms zu nutzen.
     */
    private Roboterarm roboterarm;

    /**
     * Haelt die Winkelstellung des Arms. Ist der Arm in "3 Uhr Stellung" wird 0
     * gespeichert. Ist der Arm am Fliessband, wird 150 gespeichert. Ist der Arm
     * ueber dem linken Topf, wird 250 gespeichert. Ist der Arm ueber dem linken
     * Topf, wird 310 gespeichert.
     */
    private int winkel;

    /**
     * Haelt die Farbe der Kugel, die der Roboter momentan in der Greifhand
     * haelt. Hat der Roboter momentan keine Kugel in der Hand, wird man
     * darueber mit einer netten Zeichenkette informiert.
     */
    private String gegriffeneFarbe;

    /**
     * Legt fest, ob die Animation animiert ist
     */
    private boolean istAnimiert;

    /**
     * Erzeugt einen Roboterarm inklusive Umgebung, die dieser bedienen kann.
     * Sodann wird der Arm zum Fliessband hingedreht.
     */
    public Roboter()
    {
        istAnimiert = false;
        winkel = 0;
        roboterarm = new Roboterarm(100);// Anzahl Kugeln auf dem Fliessband
        drehen(150);
        greifen();// initialisiert auch das Attribut gegriffeneFarbe
        istAnimiert = true;
    }

    public Zeichenfenster fensterGeben()
    {
        return roboterarm.fensterGeben();
    }

    /**
     * Drehen des Arms mit Hand um den vom Nutzer eingegebenen Wert im
     * Gegenuhrzeigersinn. Der Arm nimmt nur dann eine Kugel mit, wenn er sie
     * vorher gegriffen hat. Will man vom Flie�band zum linken Topf kommen, gibt
     * man 100 ein. Will man vom Flie�band zum rechten Topf kommen, gibt man 160
     * ein.
     */
    public void drehen(int umWinkel)
    {
        roboterarm.drehen(umWinkel, istAnimiert);
        winkel = winkel + umWinkel;
    }

    /**
     * Greifen einer Kugel. Eine Kugel kann nur dann vom Roboter gegriffen
     * werden, falls sie direkt unter der Greifhand des Roboters am Fliessband
     * liegt.
     */
    public void greifen()
    {
        roboterarm.greifen();
        gegriffeneFarbe = kugelFarbeGeben();
    }

    /**
     * Loslassen der Kugel in der Greifhand. Befindet sich die Greifhand
     * senkrecht ueber einem der Toepfe, faellt die Kugel in den Topf hinein.
     */
    public void loslassen()
    {
        roboterarm.loslassen();
        gegriffeneFarbe = kugelFarbeGeben();
    }

    /**
     * Informiert ueber die Farbe der Kugel, die der Roboter momentan in der
     * Greifhand haelt. Hat der Roboter momentan keine Kugel in der Hand, wird
     * man darueber mit einer netten Zeichenkette informiert.
     */
    public String kugelFarbeGeben()
    {
        return roboterarm.kugelFarbeGeben();
    }

    /**
     * Die Farbe der gegriffenen Kugel kann geprueft werden. Mögliche
     * Kugelfarben sind: "weiss", "gelb", "orange", "rot", "pink", "magenta",
     * "cyan", "gruen", "blau", "grau", "schwarz" Achtung: Die
     * Anfuehrungsstriche sind noetig! Hat der Roboter keine Kugel in der Hand,
     * wird false zurueckgegeben.
     */
    public boolean hatGegriffen(String kugelfarbe)
    {
        return kugelfarbe == kugelFarbeGeben();
    }

    /**
     * -> kann bei Bedarf auch privatiesiert werden Informiert ueber den Zustand
     * der Greifhand. Der Wert true steht fuer eine offene, der Wert false fuer
     * eine geschlossene Greifhand.
     */
    public boolean hatOffeneHand()
    {
        return roboterarm.istOffen();
    }

    /**
     * Informiert ueber die Winkelstellung des Arms. Ist der Arm in "3 Uhr
     * Stellung" wird 0 ausgegeben. Ist der Arm am Flie�band, wird 150
     * ausgegeben. Ist der Arm ueber dem linken Topf, wird 250 ausgegeben. Ist
     * der Arm ueber dem linken Topf, wird 310 ausgegeben.
     */
    public int winkelGeben()
    {
        return winkel;
    }

    public void animationEinschalten()
    {
        istAnimiert = true;
    }

    public void animationAusschalten()
    {
        istAnimiert = false;
    }
}
