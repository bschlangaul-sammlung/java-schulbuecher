package org.bschlangaul.schulbuecher.cornelsen.shared.graphen_aufbau_tool;

/**
 * Die Rahmenklasse startet das Programm.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Rahmen
{

    /**
     * Erzeugt die Bestandteile des Programms
     */
    Rahmen()
    {
        Oberflaeche o = new Oberflaeche();
        Aufbau a = new Aufbau(o);
        o.EmpfängerAnmelden(a);
    }

    /**
     * Rahmenmethode
     *
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args)
    {
        new Rahmen();
    }
}
