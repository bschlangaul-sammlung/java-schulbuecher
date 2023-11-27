package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_03.graphen.radnetz;

/**
 * Diese Klasse enthält die Datenelemente für das Radnetz, d.h. alle für
 * Radfahrer interessanten Informationen über die Orte.
 *
 */
class DATENELEMENT
{
    private String ortsname;

    private int uebernachtungsplaetze;

    private String sehenswuerdigkeiten;

    DATENELEMENT(String ortsname, int uebernachtungsplaetze,
            String sehenswuerdigkeiten)
    {
        this.ortsname = ortsname;
        this.uebernachtungsplaetze = uebernachtungsplaetze;
        this.sehenswuerdigkeiten = sehenswuerdigkeiten;
    }

    void ausgeben()
    {
        System.out.println(" Im Ort " + ortsname + " gibt es "
                + uebernachtungsplaetze + " Betten. ");
        System.out.println(
                " Sie können hier folgendes erleben: " + sehenswuerdigkeiten);
    }
}
