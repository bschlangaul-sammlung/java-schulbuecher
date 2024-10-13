package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_06.aufgabe_03.e_patientenakte;

/**
 * Klasse für einen E-Akten-Eintrag
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class EAktenEintrag implements Datenelement
{
    /** der Eintrag */
    private String eintrag;

    /**
     * Konstruktor
     *
     * @param eintragNeu der Eintrag
     */
    EAktenEintrag(String eintragNeu)
    {
        eintrag = eintragNeu;
    }

    /**
     * Methode zur Ausgabe von Information über das Datenelement
     */
    public void InformationAusgeben()
    {
        System.out.println(eintrag);
    }

    /**
     * Gibt zurück, ob der Name gleich den übergebenen Wert ist.
     *
     * @param gesuchterWert gesuchter Wert
     *
     * @return Wahrheitswert, der angibt, ob der Name der gesuchte ist.
     */
    public boolean SchlüsselIstGleich(String gesuchterWert)
    {
        return eintrag == gesuchterWert;
    }

    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation
     *
     * @param dvergleich Datenelement zum Vergleich
     */
    public boolean IstKleinerAls(Datenelement dvergleich)
    {
        return eintrag.compareTo(((EAktenEintrag) dvergleich).eintrag) < 0;
    }
}
