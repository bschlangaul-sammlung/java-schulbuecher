package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_09.aufgabe_07e.binbaum_abstract;

/**
 * Die KLasse ADRESSBUCH erzeugt ein gefülltes Adressbuch. über die Methode
 * WoerterbuchGeben kann man auf das erzteugte Objekt zugreifen und eigene bzw.
 * geerbte Methoden testen.
 *
 *
 * @author (Ihr Name)
 *
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TESTADRESSBUCH
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    ADRESSBUCH adressbuch;

    /**
     * Konstruktor für Objekte der Klasse TESTADRESSBUCH
     */
    public TESTADRESSBUCH()
    {
        adressbuch = new ADRESSBUCH();
        adressbuch.Einfuegen(new ADRESSBUCHEINTRAG("Heidrun", "97000101"));
        adressbuch.Einfuegen(new ADRESSBUCHEINTRAG("Albert", "97000102"));
        adressbuch.Einfuegen(new ADRESSBUCHEINTRAG("Barbara", "97000103"));
        adressbuch.Einfuegen(new ADRESSBUCHEINTRAG("Klaus", "97000104"));
        adressbuch.Einfuegen(new ADRESSBUCHEINTRAG("Birgit", "97000105"));
        adressbuch.Einfuegen(new ADRESSBUCHEINTRAG("Ulli", "97000106"));
        adressbuch.Einfuegen(new ADRESSBUCHEINTRAG("Jennni", "97000108"));
        adressbuch.Einfuegen(new ADRESSBUCHEINTRAG("Peter", "97000109"));
    }

    public ADRESSBUCH AdressbuchGeben()
    {
        return adressbuch;
    }
}
