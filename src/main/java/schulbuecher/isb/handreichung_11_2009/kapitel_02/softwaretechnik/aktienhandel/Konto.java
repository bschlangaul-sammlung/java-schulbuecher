package schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.aktienhandel;

/**
 * Beschreibt die Struktur eines Girokontos eines Kunden Momentan hat ein Kunde
 * nur genau ein Konto, "kontoId" wird daher nicht genutzt. Abprüfungen wegen
 * überziehung werden nicht gemacht.
 *
 * @version 1.0
 */
class Konto
{
    private int kontoID;

    private double kontoStand;

    /**
     * Initialisiert die Attribute
     */
    Konto(int nummer)
    {
        kontoID = nummer;
        kontoStand = 100000;
    }

    /**
     * Abheben eines bestimmten Betrages
     *
     * @param betrag der abzuhebende Betrag
     */
    void Abheben(double betrag)
    {
        kontoStand -= betrag;
    }

    /**
     * Einzahlen eines bestimmten Betrages
     *
     * @param betrag der einzuzahlende Betrag
     */
    void Einzahlen(double betrag)
    {
        kontoStand += betrag;
    }

    /**
     * Kontostand auslesen
     *
     * @return der aktuelle Kontostand
     */
    double KontoStandGeben()
    {
        return kontoStand;
    }

    /**
     * Nummer des Kontos melden
     *
     * @return die Kontonummer
     */
    int KontoNummerGeben()
    {
        return kontoID;
    }
}
