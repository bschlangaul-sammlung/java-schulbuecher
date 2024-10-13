package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.aktienhandel;

/**
 * Write a description of class AKTIENHANDEL here.
 *
 * @author (your name)
 *
 * @version (a version number or a date)
 */
class AKTIENHANDEL
{
    /**
     * Constructor for objects of class AKTIENHANDEL
     */
    private AKTIENHANDEL()
    {
        KONTROLLEUR k;
        OBERFLAECHE o;
        BOERSE b;
        KONTENLISTE konten;
        konten = new KONTENLISTE();
        konten.Einfuegen(new KONTO(1));
        konten.Einfuegen(new KONTO(2));
        konten.Einfuegen(new KONTO(3));
        konten.Einfuegen(new KONTO(4));
        konten.Einfuegen(new KONTO(5));
        b = new BOERSE();
        k = new KONTROLLEUR(b, konten, new KURSANZEIGE());
        o = new OBERFLAECHE(k);
        k.OberflaecheSetzen(o);
        DATENBANKVERBINDUNG.VerbindungGeben().Registrieren(o);
        b.Registrieren(o);
    }

    /**
     * Startmethode des Pakets
     */
    public static void main(String[] args)
    {
        new AKTIENHANDEL();
    }
}
