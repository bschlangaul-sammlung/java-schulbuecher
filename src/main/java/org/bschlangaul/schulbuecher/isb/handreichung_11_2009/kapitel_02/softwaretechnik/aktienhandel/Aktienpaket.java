package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.aktienhandel;

/**
 * Angaben über ein einzelnes Aktienpaket.
 *
 * @version 1.0
 */
class Aktienpaket
{
    private int anzahl;

    private int paketNummer;

    private String aktienName;

    private int aktienID;

    private double kaufKurs;

    private String kaufDatum;

    /**
     * Besetzt die Attribute vor.
     *
     * @param paketNummer laufende Nummer des Aktienpakets
     * @param anzahl Anzahl der Aktien im Paket
     * @param aktienName Name der Aktie
     */
    Aktienpaket(int paketNummer, int anzahl, String aktienName, int aktienID,
            double kaufKurs, String kaufDatum)
    {
        this.anzahl = anzahl;
        this.paketNummer = paketNummer;
        this.aktienName = aktienName;
        this.aktienID = aktienID;
        this.kaufKurs = kaufKurs;
        this.kaufDatum = kaufDatum;
    }

    /**
     * Stückzahl erhöhen
     *
     * @param stueckzahl Anzahl der hinzukommenden Aktien
     */
    void AnzahlErhoehen(int stueckzahl)
    {
        anzahl += stueckzahl;
    }

    /**
     * Stückzahl verringern
     *
     * @param stueckzahl Anzahl der abgehenden Aktien
     */
    void AnzahlVerringern(int stueckzahl)
    {
        anzahl -= stueckzahl;
    }

    /**
     * Anzeigedaten als String melden
     *
     * @return Daten in der Reihenfolge PaketNummer, Name, Anzahl
     */
    String AnzeigedatenGeben()
    {
        return "" + paketNummer + " " + aktienName + " " + anzahl;
    }

    /**
     * Paketnummer melden
     *
     * @return Nummer des Aktienpaketes
     */
    int PaketNummerGeben()
    {
        return paketNummer;
    }

    /**
     * Anzahl melden
     *
     * @return Anzahl der Aktien im Paketes
     */
    int AnzahlGeben()
    {
        return anzahl;
    }

    /**
     * Namen melden
     *
     * @return Namen der Aktien im Paketes
     */
    String AktiennameGeben()
    {
        return aktienName;
    }

    /**
     * Aktiennummer melden
     *
     * @return Nummer der Aktien im Paketes
     */
    int AktiennummerGeben()
    {
        return aktienID;
    }

    /**
     * Kaufkurs melden
     *
     * @return Kaufkurs der Aktien im Paketes
     */
    double KaufKursGeben()
    {
        return kaufKurs;
    }

    /**
     * KaufDatum melden
     *
     * @return KaufDatum der Aktien im Paketes
     */
    String KaufDatumGeben()
    {
        return kaufDatum;
    }
}
