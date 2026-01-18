package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_03.thema_11.aufgabe_07.teilaufgabe_b.graph_liste;

/**
 * Baut Adjazenzlisten entsprechend der Aufgabe 4 in Kapitel 11 auf Buch
 * Informatik Oberstufe 1 Oldenbourg Verlag
 *
 * @author U.Freiberger
 *
 * @version 1.0
 */
public class Arbeit
{
    GraphListe g;

    /**
     * Konstruktor der Klasse ARBEIT
     */
    public Arbeit()
    {
    }

    /**
     * Methode AusfuehrenAutobahn()
     * <p>
     * führt sämtliche Arbeiten zur Implementierung des Graphen entsprechend der
     * Vorgabe in der Teilaufgabe Autobahn aus Instanzieren des Graphenobjekts;
     * Einfügen der Knoten und Einfügen der Kanten
     * <p>
     * Am Ende Ausgabe der Adjazenzlisten zur Kontrolle
     *
     */
    public void AusfuehrenAutobahn()
    {
        // Erzeugen eines Graphenobjekts g mit Adjazenzlisten
        GraphListe g = new GraphListe();
        // Anlegen der Knoten
        g.KnotenEinfuegen("A");
        g.KnotenEinfuegen("F");
        g.KnotenEinfuegen("FD");
        g.KnotenEinfuegen("HO");
        g.KnotenEinfuegen("KA");
        g.KnotenEinfuegen("LI");
        g.KnotenEinfuegen("M");
        g.KnotenEinfuegen("N");
        g.KnotenEinfuegen("PA");
        g.KnotenEinfuegen("R");
        g.KnotenEinfuegen("RO");
        g.KnotenEinfuegen("S");
        g.KnotenEinfuegen("UL");
        g.KnotenEinfuegen("WÜ");
        // Anlegen der Kanten
        g.KanteEinfuegen("KA", "F", 127);
        g.KanteEinfuegen("F", "WÜ", 131);
        g.KanteEinfuegen("WÜ", "N", 104);
        g.KanteEinfuegen("N", "R", 80);
        g.KanteEinfuegen("R", "PA", 72);
        g.KanteEinfuegen("HO", "WÜ", 192);
        g.KanteEinfuegen("HO", "N", 116);
        g.KanteEinfuegen("HO", "R", 166);
        g.KanteEinfuegen("FD", "WÜ", 98);
        g.KanteEinfuegen("M", "A", 64);
        g.KanteEinfuegen("M", "N", 163);
        g.KanteEinfuegen("M", "R", 117);
        g.KanteEinfuegen("M", "RO", 60);
        g.KanteEinfuegen("UL", "A", 59);
        g.KanteEinfuegen("UL", "WÜ", 165);
        g.KanteEinfuegen("UL", "LI", 126);
        g.KanteEinfuegen("UL", "S", 103);
        g.KanteEinfuegen("S", "KA", 53);
        g.KanteEinfuegen("S", "WÜ", 155);
        // Ausgeben der Adjazenzlisten in der Konsole
        g.Ausgeben();
    }
}
