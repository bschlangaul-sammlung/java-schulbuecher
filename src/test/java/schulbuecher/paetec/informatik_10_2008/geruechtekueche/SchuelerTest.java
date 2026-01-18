package schulbuecher.paetec.informatik_10_2008.geruechtekueche;

import org.junit.jupiter.api.Test;

public class SchuelerTest
{
    private Schueler frank;

    private Schueler barbara;

    private Schueler stefan;

    private Schueler birgit;

    private Schueler michael;

    private Schueler rosi;

    private Schueler leon;

    private Schueler melanie;

    private Schueler susanne;

    private Schueler andreas;

    /**
     * Stellt Freundschaftsbeziehungen zwischen 10 Objekten der Klasse Schueler
     * her.
     */
    @Test
    public void freundschaftBeginnen()
    {
        frank = new Schueler("Frank");
        barbara = new Schueler("Barbara");
        stefan = new Schueler("Stefan");
        birgit = new Schueler("Birgit");
        michael = new Schueler("Michael");
        rosi = new Schueler("Rosi");
        leon = new Schueler("Leon");
        melanie = new Schueler("Melanie");
        susanne = new Schueler("Susanne");
        andreas = new Schueler("Andreas");
        frank.freundschaftBeginnen(michael);
        frank.freundschaftBeginnen(birgit);
        stefan.freundschaftBeginnen(michael);
        stefan.freundschaftBeginnen(birgit);
        birgit.freundschaftBeginnen(susanne);
        birgit.freundschaftBeginnen(leon);
        michael.freundschaftBeginnen(susanne);
        michael.freundschaftBeginnen(barbara);
        barbara.freundschaftBeginnen(andreas);
        barbara.freundschaftBeginnen(stefan);
        rosi.freundschaftBeginnen(leon);
        rosi.freundschaftBeginnen(andreas);
        melanie.freundschaftBeginnen(rosi);
        melanie.freundschaftBeginnen(birgit);
        susanne.freundschaftBeginnen(melanie);
        susanne.freundschaftBeginnen(rosi);
        andreas.freundschaftBeginnen(susanne);
    }
}
