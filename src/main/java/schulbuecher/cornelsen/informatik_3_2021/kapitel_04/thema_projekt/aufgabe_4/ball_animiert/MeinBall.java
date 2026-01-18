package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_projekt.aufgabe_4.ball_animiert;

/**
 * Erweitert die Klasse BALL um die Fähigkeit am Rand abzuprallen
 *
 * @author Mike Ganshorn (Mike_Gans@yahoo.de)
 *
 * @version 1.0 (2019-12-28)
 */
public class MeinBall extends Ball
{
    public MeinBall(String farbe)
    {
        super(farbe);
        super.starteTickerNeu(0.01);
    }

    @Override
    public void tick()
    {
        if (super.nenneMittelpunktX() < -12 || super.nenneMittelpunktX() > 12)
        {
            super.setzeSchrittweite(-super.nenneSchrittweiteX(),
                    super.nenneSchrittweiteY());
        }
        if (super.nenneMittelpunktY() < -9 || super.nenneMittelpunktY() > 9)
        {
            super.setzeSchrittweite(super.nenneSchrittweiteX(),
                    -super.nenneSchrittweiteY());
        }
        super.bewegen();
    }
}
