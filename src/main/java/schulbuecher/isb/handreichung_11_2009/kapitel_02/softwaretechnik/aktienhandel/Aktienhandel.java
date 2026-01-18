package schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.aktienhandel;

class Aktienhandel
{
    private Aktienhandel()
    {
        Kontrolleur k;
        Oberflaeche o;
        Boerse b;
        KnotenListe konten;
        konten = new KnotenListe();
        konten.Einfuegen(new Konto(1));
        konten.Einfuegen(new Konto(2));
        konten.Einfuegen(new Konto(3));
        konten.Einfuegen(new Konto(4));
        konten.Einfuegen(new Konto(5));
        b = new Boerse();
        k = new Kontrolleur(b, konten, new Kursanzeige());
        o = new Oberflaeche(k);
        k.OberflaecheSetzen(o);
        DatenbankVerbindung.VerbindungGeben().Registrieren(o);
        b.Registrieren(o);
    }

    /**
     * Startmethode des Pakets
     */
    public static void main(String[] args)
    {
        new Aktienhandel();
    }
}
