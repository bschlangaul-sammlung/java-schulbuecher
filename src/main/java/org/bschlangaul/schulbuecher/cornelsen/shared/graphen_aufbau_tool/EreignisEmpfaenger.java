package org.bschlangaul.schulbuecher.cornelsen.shared.graphen_aufbau_tool;

/**
 * Beschreibt die Botschaften der Oberfläche an den Empfänger der Ereignisse
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */

interface EreignisEmpfaenger
{
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
    void MausGedrückt(int x, int y, boolean rechtsKlick, boolean ctrl,
            boolean shift, boolean alt);

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
    void MausGeklickt(int x, int y, int anzahl, boolean rechtsKlick,
            boolean ctrl, boolean shift, boolean alt);

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
    void MausLosgelassen(int x, int y, boolean rechtsKlick, boolean ctrl,
            boolean shift, boolean alt);

    /**
     * Die Maus wurde gedrückt gezogen.
     *
     * @param x x-Koordinate der Maus
     * @param y y-Koordinate der Maus
     */
    void MausGezogen(int x, int y);

    /**
     * Der Menüpunkt Knoten editieren wurde gewählt.
     *
     * @param x neue x-Koordinate
     * @param y neue y-Koordinate
     * @param bezeichner neuer Knotenbezeichner
     */
    void KnotenEditieren(int x, int y, String bezeichner);

    /**
     * Der Menüpunkt Knotenlöschen wurde gewählt
     */
    void KnotenLöschen();

    /**
     * Der Menüpunkt Kante editieren wurde gewählt.
     *
     * @param gewicht die Gewichtsbezeichnung
     * @param gerichtet wenn wahr, ist die Kante gerichtet
     */
    void KanteEditieren(String gewicht, boolean gerichtet);

    /**
     * Der Menüpunkt Kantenlöschen wurde gewählt
     */
    void KanteLöschen();

    /**
     * Speichert die Datei am angegebenen Ort. Eine exisiterende Datei wird
     * gegebenenfalls überschrieben.
     *
     * @param datei Dateiidentifikator
     */
    void Sichern(java.io.File datei);

    /**
     * Liest die Datei unter dem gegebenen Namen ein.
     *
     * @param datei Dateiidentifikator
     *
     * @return wahr, wenn die Datei gelesen werden konnte
     */
    boolean Lesen(java.io.File datei);

    /**
     * Entfernt alle Graphensymbole aus der Anzeige
     */
    void ZurückSetzen();

    /**
     * Meldet, ob der Graph geändert wurde.
     *
     * @return wahr, wenn der Graph geändert wurde
     */
    boolean IstGeändert();

    /**
     * Prüft, ob ein Knotenbezeichner eindeutig ist. Der selektierte Knoten wird
     * nihct betrachtet, da sein Name bleiben kann.
     *
     * @param bezeichner der zu prüfende Bezeichner
     */
    boolean BezeichnerPrüfen(String bezeichner);
}
