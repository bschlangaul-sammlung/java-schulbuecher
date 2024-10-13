package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittenes_formular;

/**
 * Diese Klasse kann zur Verarbeitung von Benutzereingaben eingesetzt werden.
 * Sie wird durch einen Menuepunkt auf dem Formular repraesentiert, bei dessen
 * Betaetigung automatisch die Methode ausloesen() aufgerufen wird.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 05.2008
 */
public abstract class Sensor
{
    private String ereignisname;

    private Formular formular;

    public Sensor(Formular aktuellesFormular)
    {
        if (aktuellesFormular == null)
        {
            formular = Formular.formularGeben();
        }
        else
        {
            formular = aktuellesFormular;
        }
        ereignisname = "Ereignisname";
        anzeigen();
    }

    public Sensor()
    {
        this(null);
    }

    /**
     * Wird bei Anwahl des Menuepunkts aufgerufen.
     */
    public abstract void ausloesen();

    /**
     * Aendert den Text des Menuepunkts.
     *
     * @param text der neue Text
     */
    public void textSetzen(String text)
    {
        ereignisname = text;
        formular.formularAktualisieren();
    }

    /**
     * Legt das Ereignis auf das Formular.
     */
    public void anzeigen()
    {
        if (!formular.sensorenVorhanden())
        {
            formular.menuepunktHinzufuegen(this);
            // Eintrag "Ereignisse" auf der Menueleiste hinzufuegen
            formular.menueleisteAktualisieren();
        }
        else
        {// Es gibt den Eintrag "Ereignisse" schon
            formular.menuepunktHinzufuegen(this);
        }
    }

    /**
     * Entfernt das Ereignis vom Formular.
     */
    public void verstecken()
    {
        formular.menuepunktEntfernen(this);
        if (!formular.sensorenVorhanden())
        {
            // Wir waren der letzte Sensor auf dem Formular, jetzt gibt es keine
            // mehr da drauf
            // Eintrag "Ereignisse" auf der Menueleiste entfernen
            formular.menueleisteAktualisieren();
        }
    }

    /**
     * Liefert den Ereignisnamen.
     */
    public String toString()
    {
        return ereignisname;
    }

    /**
     * Liefert das Formular, auf dem das Ereignis liegt.
     *
     * @return das Formular
     */
    protected Formular formularGeben()
    {
        return formular;
    }
}
