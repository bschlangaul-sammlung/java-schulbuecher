package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_03.thema_12.aufgabe_05.graph_matrix;

/**
 * Baut eine Adjazenzmatrix entsprechend der Aufgabe 4 in Kapitel 11 im Buch
 * Informatik Oberstufe 1 Oldenbourg Verlag auf
 *
 * @author U.Freiberger
 *
 * @version 1.0
 */
public class Arbeit
{
    GraphMatrix g;

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
     * Am Ende Ausgabe der Adjazenzmatrix zur Kontrolle
     *
     */
    public void AusfuehrenAutobahn()
    {
        // Erzeugen eines Graphenobjekts g für 14 Knoten
        GraphMatrix g = new GraphMatrix(14);
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
        // Formatiertes Ausgeben der Adjazenzmatrix in der Konsole
        g.Ausgeben();
        g.TiefenSuche("M");
    }

    /**
     * Methode AusfuehrenFlug()
     * <p>
     * führt sämtliche Arbeiten zur Implementierung des Graphen entsprechend der
     * Vorgabe in der Teilaufgabe Flugroute aus Instanzieren des Graphenobjekts;
     * Einfügen der Knoten und Einfügen der Kanten
     * <p>
     * Am Ende Ausgabe der Adjazenzmatrix zur Kontrolle
     *
     */
    public void AusfuehrenFlug()
    {
        // Erzeugen eines Graphenobjekts g für 21 Knoten
        GraphMatrix g = new GraphMatrix(21);
        // Anlegen der Knoten
        g.KnotenEinfuegen("AMS");
        g.KnotenEinfuegen("ARN");
        g.KnotenEinfuegen("BKK");
        g.KnotenEinfuegen("CAI");
        g.KnotenEinfuegen("CDG");
        g.KnotenEinfuegen("DEL");
        g.KnotenEinfuegen("DME");
        g.KnotenEinfuegen("FRA");
        g.KnotenEinfuegen("GRU");
        g.KnotenEinfuegen("JFK");
        g.KnotenEinfuegen("JNB");
        g.KnotenEinfuegen("LHR");
        g.KnotenEinfuegen("MAD");
        g.KnotenEinfuegen("MEX");
        g.KnotenEinfuegen("MUC");
        g.KnotenEinfuegen("NRT");
        g.KnotenEinfuegen("ORD");
        g.KnotenEinfuegen("PEK");
        g.KnotenEinfuegen("SFO");
        g.KnotenEinfuegen("SIN");
        g.KnotenEinfuegen("TXL");
        // Anlegen der Kanten mit der Gewichtung Flugzeit in Minuten
        g.KanteEinfuegen("FRA", "AMS", 70);
        g.KanteEinfuegen("FRA", "ARN", 125);
        g.KanteEinfuegen("FRA", "BKK", 620);
        g.KanteEinfuegen("FRA", "CAI", 235);
        g.KanteEinfuegen("FRA", "CDG", 70);
        g.KanteEinfuegen("FRA", "DEL", 440);
        g.KanteEinfuegen("FRA", "DME", 195);
        g.KanteEinfuegen("FRA", "GRU", 710);
        g.KanteEinfuegen("FRA", "JFK", 525);
        g.KanteEinfuegen("FRA", "JNB", 645);
        g.KanteEinfuegen("FRA", "LHR", 100);
        g.KanteEinfuegen("FRA", "MAD", 150);
        g.KanteEinfuegen("FRA", "MEX", 705);
        g.KanteEinfuegen("FRA", "MUC", 55);
        g.KanteEinfuegen("FRA", "NRT", 660);
        g.KanteEinfuegen("FRA", "ORD", 565);
        g.KanteEinfuegen("FRA", "PEK", 550);
        g.KanteEinfuegen("FRA", "SFO", 684);
        g.KanteEinfuegen("FRA", "SIN", 720);
        g.KanteEinfuegen("FRA", "TXL", 65);
        g.KanteEinfuegen("MUC", "AMS", 95);
        g.KanteEinfuegen("MUC", "ARN", 130);
        g.KanteEinfuegen("MUC", "BKK", 620);
        g.KanteEinfuegen("MUC", "CAI", 230);
        g.KanteEinfuegen("MUC", "CDG", 100);
        g.KanteEinfuegen("MUC", "DEL", 445);
        g.KanteEinfuegen("MUC", "DME", 190);
        g.KanteEinfuegen("MUC", "GRU", 760);
        g.KanteEinfuegen("MUC", "JFK", 550);
        g.KanteEinfuegen("MUC", "JNB", 645);
        g.KanteEinfuegen("MUC", "LHR", 125);
        g.KanteEinfuegen("MUC", "MAD", 155);
        g.KanteEinfuegen("MUC", "NRT", 705);
        g.KanteEinfuegen("MUC", "ORD", 600);
        g.KanteEinfuegen("MUC", "PEK", 590);
        g.KanteEinfuegen("MUC", "SFO", 730);
        g.KanteEinfuegen("MUC", "SIN", 725);
        g.KanteEinfuegen("MUC", "TXL", 70);
        g.KanteEinfuegen("TXL", "ARN", 90);
        g.KanteEinfuegen("TXL", "CDG", 105);
        g.KanteEinfuegen("TXL", "DME", 165);
        // Formatiertes Ausgeben der Adjazenzmatrix in der Konsole
        g.Ausgeben();
        g.TiefenSuche("MUC");
    }

    /**
     * Methode AusfuehrenICE()
     * <p>
     * führt sämtliche Arbeiten zur Implementierung des Graphen entsprechend der
     * Vorgabe in der Teilaufgabe ICE-Verbindungen aus Instanzieren des
     * Graphenobjekts; Einfügen der Knoten und Einfügen der Kanten
     * <p>
     * Am Ende Ausgabe der Adjazenzmatrix zur Kontrolle
     *
     */
    public void AusfuehrenICE()
    {
        // Erzeugen eines Graphenobjekts g für 16 Knoten
        GraphMatrix g = new GraphMatrix(16);
        // Anlegen der Knoten
        g.KnotenEinfuegen("A");
        g.KnotenEinfuegen("B");
        g.KnotenEinfuegen("D");
        g.KnotenEinfuegen("DD");
        g.KnotenEinfuegen("F");
        g.KnotenEinfuegen("F2");
        g.KnotenEinfuegen("FD");
        g.KnotenEinfuegen("HH");
        g.KnotenEinfuegen("H");
        g.KnotenEinfuegen("K");
        g.KnotenEinfuegen("L");
        g.KnotenEinfuegen("M");
        g.KnotenEinfuegen("MA");
        g.KnotenEinfuegen("N");
        g.KnotenEinfuegen("S");
        g.KnotenEinfuegen("WÜ");
        // Anlegen der Kanten mit der Gewichtung Fahrzeit in Minuten
        g.KanteEinfuegen("F2", "F", 10);
        g.KanteEinfuegen("FD", "F", 52);
        g.KanteEinfuegen("HH", "B", 143);
        g.KanteEinfuegen("H", "B", 98);
        g.KanteEinfuegen("H", "D", 100);
        g.KanteEinfuegen("H", "FD", 88);
        g.KanteEinfuegen("H", "HH", 74);
        g.KanteEinfuegen("K", "D", 77);
        g.KanteEinfuegen("K", "F2", 67);
        g.KanteEinfuegen("L", "B", 67);
        g.KanteEinfuegen("L", "DD", 73);
        g.KanteEinfuegen("L", "FD", 151);
        g.KanteEinfuegen("M", "A", 40);
        g.KanteEinfuegen("MA", "F", 30);
        g.KanteEinfuegen("MA", "F2", 30);
        g.KanteEinfuegen("N", "A", 62);
        g.KanteEinfuegen("N", "L", 189);
        g.KanteEinfuegen("N", "M", 71);
        g.KanteEinfuegen("S", "A", 98);
        g.KanteEinfuegen("S", "MA", 37);
        g.KanteEinfuegen("WÜ", "F", 70);
        g.KanteEinfuegen("WÜ", "FD", 34);
        g.KanteEinfuegen("WÜ", "N", 58);
        // Formatiertes Ausgeben der Adjazenzmatrix in der Konsole
        g.Ausgeben();
        g.TiefenSuche("M");
    }

    /**
     * Methode AusfuehrenAusschnitt()
     * <p>
     * führt sämtliche Arbeiten zur Implementierung des Graphen entsprechend der
     * Vorgabe in der Teilaufgabe Autobahnkartenausschnitt aus: Instanzieren des
     * Graphenobjekts; Einfügen der Knoten und Einfügen der Kanten
     * <p>
     * Am Ende Ausgabe der Adjazenzmatrix zur Kontrolle
     *
     */
    public void AusfuehrenAusschnitt()
    {
        // Erzeugen eines Graphenobjekts g für 14 Knoten
        GraphMatrix g = new GraphMatrix(14);
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
        // Anlegen der Kanten mit der Gewichtung AutobahnKilometer
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
        // Formatiertes Ausgeben der Adjazenzmatrix in der Konsole
        g.Ausgeben();
        g.TiefenSuche("M");
    }

    /**
     * Methode AusfuehrenSUBahn()
     * <p>
     * führt sämtliche Arbeiten zur Implementierung des Graphen entsprechend der
     * Vorgabe in der Teilaufgabe S- und U-Bahn-Verbindungen aus: Instanzieren
     * des Graphenobjekts; Einfügen der Knoten und Einfügen der Kanten
     * <p>
     * Am Ende Ausgabe der Adjazenzmatrix zur Kontrolle
     *
     */
    public void AusfuehrenSUBahn()
    {
        // Erzeugen eines Graphenobjekts g für 41 Knoten
        GraphMatrix g = new GraphMatrix(41);
        // Anlegen der Knoten
        g.KnotenEinfuegen("A");
        g.KnotenEinfuegen("Altomünster");
        g.KnotenEinfuegen("Arabellapark");
        g.KnotenEinfuegen("Dachau");
        g.KnotenEinfuegen("Donnersbergerbrücke");
        g.KnotenEinfuegen("Ebersberg");
        g.KnotenEinfuegen("Erding");
        g.KnotenEinfuegen("Feldmoching");
        g.KnotenEinfuegen("Flughafen");
        g.KnotenEinfuegen("Freising");
        g.KnotenEinfuegen("Fürstenried");
        g.KnotenEinfuegen("Garching");
        g.KnotenEinfuegen("Geltendorf");
        g.KnotenEinfuegen("Giesing");
        g.KnotenEinfuegen("Großhadern");
        g.KnotenEinfuegen("Harras");
        g.KnotenEinfuegen("Hauptbahnhof");
        g.KnotenEinfuegen("Heimeranplatz");
        g.KnotenEinfuegen("Herrsching");
        g.KnotenEinfuegen("Holzkirchen");
        g.KnotenEinfuegen("Innsbrucker Ring");
        g.KnotenEinfuegen("Karlsplatz");
        g.KnotenEinfuegen("Kreuzstraße");
        g.KnotenEinfuegen("Laim");
        g.KnotenEinfuegen("Laimer Platz");
        g.KnotenEinfuegen("Mammendorf");
        g.KnotenEinfuegen("Mangfallplatz");
        g.KnotenEinfuegen("Marienplatz");
        g.KnotenEinfuegen("Messe");
        g.KnotenEinfuegen("Neufahrn");
        g.KnotenEinfuegen("Neuperlach");
        g.KnotenEinfuegen("Odeonsplatz");
        g.KnotenEinfuegen("OEZ");
        g.KnotenEinfuegen("Ostbahnhof");
        g.KnotenEinfuegen("Pasing");
        g.KnotenEinfuegen("Petershausen");
        g.KnotenEinfuegen("Scheidplatz");
        g.KnotenEinfuegen("Sendlinger Tor");
        g.KnotenEinfuegen("Trudering");
        g.KnotenEinfuegen("Tutzing");
        g.KnotenEinfuegen("Wolfratshausen");
        // Anlegen der Kanten mit der Gewichtung "ist verbunden"
        g.KanteEinfuegen("Dachau", "Altomünster", 1);
        g.KanteEinfuegen("Harras", "Großhadern", 1);
        g.KanteEinfuegen("Hauptbahnhof", "Donnersbergerbrücke", 1);
        g.KanteEinfuegen("Heimeranplatz", "Donnersbergerbrücke", 1);
        g.KanteEinfuegen("Heimeranplatz", "Harras", 1);
        g.KanteEinfuegen("Heimeranplatz", "Hauptbahnhof", 1);
        g.KanteEinfuegen("Holzkirchen", "Giesing", 1);
        g.KanteEinfuegen("Innsbrucker Ring", "Giesing", 1);
        g.KanteEinfuegen("Karlsplatz", "Hauptbahnhof", 1);
        g.KanteEinfuegen("Laim", "Dachau", 1);
        g.KanteEinfuegen("Laim", "Donnersbergerbrücke", 1);
        g.KanteEinfuegen("Laim", "Feldmoching", 1);
        g.KanteEinfuegen("Laimer Platz", "Heimeranplatz", 1);
        g.KanteEinfuegen("Marienplatz", "Karlsplatz", 1);
        g.KanteEinfuegen("Neufahrn", "Feldmoching", 1);
        g.KanteEinfuegen("Neufahrn", "Flughafen", 1);
        g.KanteEinfuegen("Neufahrn", "Freising", 1);
        g.KanteEinfuegen("Neuperlach", "Giesing", 1);
        g.KanteEinfuegen("Neuperlach", "Innsbrucker Ring", 1);
        g.KanteEinfuegen("Neuperlach", "Kreuzstraße", 1);
        g.KanteEinfuegen("Odeonsplatz", "Arabellapark", 1);
        g.KanteEinfuegen("Odeonsplatz", "Garching", 1);
        g.KanteEinfuegen("Odeonsplatz", "Karlsplatz", 1);
        g.KanteEinfuegen("Odeonsplatz", "Marienplatz", 1);
        g.KanteEinfuegen("OEZ", "Hauptbahnhof", 1);
        g.KanteEinfuegen("Ostbahnhof", "Erding", 1);
        g.KanteEinfuegen("Ostbahnhof", "Flughafen", 1);
        g.KanteEinfuegen("Ostbahnhof", "Giesing", 1);
        g.KanteEinfuegen("Ostbahnhof", "Innsbrucker Ring", 1);
        g.KanteEinfuegen("Ostbahnhof", "Marienplatz", 1);
        g.KanteEinfuegen("Ostbahnhof", "Odeonsplatz", 1);
        g.KanteEinfuegen("Pasing", "Geltendorf", 1);
        g.KanteEinfuegen("Pasing", "Herrsching", 1);
        g.KanteEinfuegen("Pasing", "Laim", 1);
        g.KanteEinfuegen("Pasing", "Mammendorf", 1);
        g.KanteEinfuegen("Petershausen", "Dachau", 1);
        g.KanteEinfuegen("Scheidplatz", "Feldmoching", 1);
        g.KanteEinfuegen("Scheidplatz", "Hauptbahnhof", 1);
        g.KanteEinfuegen("Scheidplatz", "OEZ", 1);
        g.KanteEinfuegen("Sendlinger Tor", "Fürstenried", 1);
        g.KanteEinfuegen("Sendlinger Tor", "Giesing", 1);
        g.KanteEinfuegen("Sendlinger Tor", "Harras", 1);
        g.KanteEinfuegen("Sendlinger Tor", "Hauptbahnhof", 1);
        g.KanteEinfuegen("Sendlinger Tor", "Marienplatz", 1);
        g.KanteEinfuegen("Trudering", "Ebersberg", 1);
        g.KanteEinfuegen("Trudering", "Innsbrucker Ring", 1);
        g.KanteEinfuegen("Trudering", "Messe", 1);
        g.KanteEinfuegen("Trudering", "Ostbahnhof", 1);
        g.KanteEinfuegen("Tutzing", "Pasing", 1);
        g.KanteEinfuegen("Wolfratshausen", "Harras", 1);
        // Formatiertes Ausgeben der Adjazenzmatrix in der Konsole
        g.Ausgeben();
        g.TiefenSuche("Pasing");
    }
}
