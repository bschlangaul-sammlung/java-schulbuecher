package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.aktienhandel;

/**
 * Verwaltet den Kurs einer Aktie mit dem Datum.
 *
 * @author
 *
 * @version 1.0
 */
class KURSINFO
{
    private int aktienID;

    private double kurs;

    private String datum;

    /**
     * Initialisiert die Attribute.
     *
     * @param kurs Kurs der Aktie
     * @param datum Datum, zu dem der Kurs bestimmt wurde
     */
    KURSINFO(int aktienID, double kurs, String datum)
    {
        this.aktienID = aktienID;
        this.kurs = kurs;
        this.datum = datum;
    }

    /**
     * Meldet den ID der Aktie
     *
     * @return Schlüsselwert der Aktie
     */
    double AktienIDGeben()
    {
        return aktienID;
    }

    /**
     * Meldet den Kurs
     *
     * @return kurswert
     */
    double KursGeben()
    {
        return kurs;
    }

    /**
     * Meldet das Datum
     *
     * @return kurswert
     */
    String DatumGeben()
    {
        return datum;
    }

    /**
     * Setzt einen neuen Kurswert.
     *
     * @param kurs neuer Kurs
     */
    void KursSetzen(double kurs)
    {
        this.kurs = kurs;
    }
}
