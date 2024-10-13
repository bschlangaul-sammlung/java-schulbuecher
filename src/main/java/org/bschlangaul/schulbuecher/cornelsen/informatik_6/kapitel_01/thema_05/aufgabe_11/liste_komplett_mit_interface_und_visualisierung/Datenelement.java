package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_05.aufgabe_11.liste_komplett_mit_interface_und_visualisierung;

/**
 * Interface für Datenelemente
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */

public interface Datenelement
{
    /** Methode zur Ausgabe von Information über das Datenelement */
    void InformationAusgeben();

    /**
     * Gibt zurück, ob der Name gleich den übergebenen Wert ist.
     *
     * @param gesuchterWert gesuchter Wert
     *
     * @return Wahrheitswert, der angibt, ob der Name der gesuchte ist.
     */
    boolean SchlüsselIstGleich(String gesuchterWert);

    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation
     *
     * @param dvergleich Datenelement zum Vergleich
     */
    boolean IstKleinerAls(Datenelement dvergleich);

    /*
     * Gibt den Namen (Schlüssel) des Datenelements zurück
     * @return Name
     */
    String NameGeben();
}
