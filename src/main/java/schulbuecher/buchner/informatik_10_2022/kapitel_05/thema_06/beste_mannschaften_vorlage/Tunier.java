package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_06.beste_mannschaften_vorlage;

import java.time.LocalDate;

/**
 * Projekt 5-6_BesteMannschaften
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
@SuppressWarnings("unused")
public class Tunier
{
    private Mannschaft[] mannschaften;

    private String name;

    private LocalDate datum;

    private Mannschaft[] bestenliste;

    public Tunier(String name, LocalDate datum)
    {
        this.name = name;
        this.datum = datum;
        this.bestenliste = new Mannschaft[5];
    }

    // Kapitel 5-6, Aufgabe 1
    public void platzwechsel(int position1, int position2)
    {
        Mannschaft h = bestenliste[position1];
        bestenliste[position1] = bestenliste[position2];
        bestenliste[position2] = h;
    }
}
