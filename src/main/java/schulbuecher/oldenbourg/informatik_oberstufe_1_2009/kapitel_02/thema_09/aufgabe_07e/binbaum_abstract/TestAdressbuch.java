package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_09.aufgabe_07e.binbaum_abstract;

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
public class TestAdressbuch
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    Adressbuch adressbuch;

    /**
     * Konstruktor für Objekte der Klasse TESTADRESSBUCH
     */
    public TestAdressbuch()
    {
        adressbuch = new Adressbuch();
        adressbuch.Einfuegen(new Adressbucheintrag("Heidrun", "97000101"));
        adressbuch.Einfuegen(new Adressbucheintrag("Albert", "97000102"));
        adressbuch.Einfuegen(new Adressbucheintrag("Barbara", "97000103"));
        adressbuch.Einfuegen(new Adressbucheintrag("Klaus", "97000104"));
        adressbuch.Einfuegen(new Adressbucheintrag("Birgit", "97000105"));
        adressbuch.Einfuegen(new Adressbucheintrag("Ulli", "97000106"));
        adressbuch.Einfuegen(new Adressbucheintrag("Jennni", "97000108"));
        adressbuch.Einfuegen(new Adressbucheintrag("Peter", "97000109"));
    }

    public Adressbuch AdressbuchGeben()
    {
        return adressbuch;
    }
}
