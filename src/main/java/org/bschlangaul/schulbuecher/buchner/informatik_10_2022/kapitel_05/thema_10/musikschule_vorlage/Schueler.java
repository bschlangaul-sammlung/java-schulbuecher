package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.musikschule_vorlage;

/**
 * Projekt 5-10_Musikschule (ÜuV Aufgabe 14)
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
public class Schueler
{
    String name;

    int alter;

    Instrument instrument;

    Lehrer lehrer;

    public Schueler(String name, int alter, Instrument instrument,
            Lehrer lehrer)
    {
        this.name = name;
        this.alter = alter;
        this.instrument = instrument;
        this.lehrer = lehrer;
    }

    public String nenneSchueler()
    {
        return this.name + ", ist " + this.alter + " alt und spielt "
                + this.instrument.nenneInstrument() + " bei "
                + this.lehrer.nenneLehrer();
    }

    public int nenneAlter()
    {
        return this.alter;
    }
}
