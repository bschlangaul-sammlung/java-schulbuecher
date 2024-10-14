/**
 * Die Klasse Textzeichen dient zur Speicherung von
 * Textzeichen und deren absolute Häufigkeit (in einem Text).
 *
 * @author Peter Brichzin
 * @version 31.05.24
 */

class Textzeichen
{
    /**
     * Zeichen; Schlüssel dieses Datenelements   */
    private char zeichen;

    /**
     * absolute Häufigkeit des Zeichnes */
    private int anzahl;

    /**
     * Konstruktor für Objekte der Klasse Textzeichen
     * Die Anzahl wird auf 1 gesetzt, da es das erste Auftreten des Textzeichens ist.
     *
     * @param buchstabeNeu derBuchstabe.
     */
    Textzeichen(char zeichenNeu)
    {
        zeichen = zeichenNeu;
        anzahl = 1;
    }

    /**
     * Gibt Information über das Datenelement zu Kontrollzwecken
     * auf das Terminalfenster aus.
     */
    void InformationAusgeben()
    {
        System.out.println(zeichen + ": " + anzahl);
    }

    /**
     * Vergleicht zwei Datenelemente auf Gleichheit.
     * @param dvergleich Datenelement mit dem das Objekt verglichen wird.
     * @return true, wenn die beiden Datenelemente gleichen Schlüssel haben.
     */
    boolean IstGleich(Textzeichen dvergleich)
    {
        if(SchlüsselAlsStringGeben().compareTo( dvergleich.SchlüsselAlsStringGeben() ) ==0 )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Vergleicht zwei Datenelemente bezüglich der Ordnungsrelation.
     * Durch die Methode SchlüsselAlsStringGeben() wird das Zeichen in eine
     * Zeichenkette für den Vergleich umgewandelt.
     * @param vergleichselement Datenelement mit dem das Objekt verglichen wird.
     * @return true, wenn das aktuelle Element einen größeren Schlüssel hat, als das angegebene Vergleichselement.
     */
    boolean IstGrößerAls(Textzeichen dvergleich)
    {
        if(SchlüsselAlsStringGeben().compareTo(dvergleich.SchlüsselAlsStringGeben()) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, auf Gleichheit.
     * Durch die Methode SchlüsselAlsStringGeben() wird das Zeichen in eine
     * Zeichenkette für den Vergleich umgewandelt.
     * @param vergleichsSchluessel Schlüssel  mit dem der Schlüssel des Objekt verglichen wird.
     * @return true, wenn die beiden Schlüssel gleich sind.
     */
    boolean SchlüsselIstGleich (String vergleichsSchlüssel)
    {
        if(SchlüsselAlsStringGeben().compareTo(vergleichsSchlüssel) == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, bezüglich der Ordnungsrelation.
     * Durch die Methode SchlüsselAlsStringGeben() wird das Zeichen in eine
     * Zeichenkette für den Vergleich umgewandelt.
     * @param vergleichsSchluessel Schlüssel  mit dem der Schlüssel des Objekt verglichen wird.
     * @return true, wenn das aktuelle Element einen größeren Schlüssel hat, als das angegebene Vergleichselement.
     */
    boolean SchlüsselIstGrößerAls(String vergleichsSchlüssel)
    {
        if(SchlüsselAlsStringGeben().compareTo(vergleichsSchlüssel) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, bezüglich der Ordnungsrelation.
     * Durch die Methode SchlüsselAlsStringGeben() wird das Zeichen in eine
     * Zeichenkette für den Vergleich umgewandelt.
     * @param vergleichsSchluessel Schlüssel  mit dem der Schlüssel des Objekt verglichen wird.
     * @return true, wenn das aktuelle Element einen kleineren Schlüssel
     * hat, als das angegebene Vergleichselement.
     */
    boolean SchlüsselIstKleinerAls(String vergleichsSchlüssel)
    {
        if(SchlüsselAlsStringGeben().compareTo(vergleichsSchlüssel) < 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Gibt den Schlüssel des Datenelements als String aus, auch wenn der Datentyp vom
     * Durch die Methode SchluesselAlsStringGeben() wird das Zeichen in eine
     * Zeichenkette für den Vergleich umgewandelt.
     * String abweicht. Diese Methode wird beim Entfernen eines Knotens benötigt.
     * @return Schlüssel als String.
     */
    String SchlüsselAlsStringGeben()
    {
        return String.valueOf(zeichen);
    }

    /**
     * Geben-Methode zum Attribut zeichen
     * @return das Zeichen
     */
    char ZeichenGeben()
    {
        return zeichen;
    }

    /**
     * Geben-Methode zum Attribut anzahl
     *
     * @return   anzahl: Die Anzahl des Auftretens des Buchstabens.
     */
    int AnzahlGeben()
    {
        return anzahl;
    }

    /**
     * Erhöht den Wert des Attributs anzahl um 1
     *
     */
    void AnzahlErhöhen()
    {
        anzahl = anzahl + 1;
    }

}
