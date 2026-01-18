package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.verwaltung_der_kundendaten;

abstract class DATENELEMENT
{
    abstract void Ausgeben();

    abstract int Vergleichen(DATENELEMENT vergleichsObjekt);
}
