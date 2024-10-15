package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_02.aufgabe_04.kreuzung;

import java.util.Random;

/**
 * Die Klasse KREUZUNG beschreibt eine Kreuzung, die aus vier Kfz- und acht
 * Fussgängerampeln besteht. Alle Ampeln sind um den Koordinatenursprung
 * positioniert. Die Lichtsignale können verschiedene Phasen durchlaufen, wobei
 * mit der Grünphase in Ost/West Richtung und gleichzeitig der Rotphase in
 * Nord/Süd Richtung begonnen wird.
 *
 *
 * @author Peter Cody
 *
 * @version 1.0
 */
class KREUZUNG implements TAKTKLIENT
{
    /**
     * Das Attribut Phase beschreibt welche Verkehrsströme innerhalb der Ampel
     * freigegeben bzw. gesperrt sind; nur die Werte 1 bis 8 sind erlaubt. <BR>
     *
     * 1: in Ost/West Richtung: KfZ: grün | Fussgänger grün <BR>
     * &nbsp;&nbsp;&nbsp; in Nord/Süd Richtung: KfZ: rot | Fussgänger rot <BR>
     * 2: in Ost/West Richtung: KfZ: grün | Fussgänger rot <BR>
     * &nbsp;&nbsp;&nbsp; in Nord/Süd Richtung: KfZ: rot | Fussgänger rot <BR>
     * 3: in Ost/West Richtung: KfZ: gelb | Fussgänger rot <BR>
     * &nbsp;&nbsp;&nbsp; in Nord/Süd Richtung: KfZ: rot | Fussgänger rot <BR>
     * 4: in Ost/West Richtung: KfZ: rot | Fussgänger rot <BR>
     * &nbsp;&nbsp;&nbsp; in Nord/Süd Richtung: KfZ: rotgelb | Fussgänger grün
     * <BR>
     * 5: in Ost/West Richtung: KfZ: rot | Fussgänger rot <BR>
     * &nbsp;&nbsp;&nbsp; in Nord/Süd Richtung: KfZ: grün | Fussgänger grün <BR>
     * 6: in Ost/West Richtung: KfZ: rot | Fussgänger rot <BR>
     * &nbsp;&nbsp;&nbsp; in Nord/Süd Richtung: KfZ: grün | Fussgänger rot <BR>
     * 7: in Ost/West Richtung: KfZ: rot | Fussgänger rot <BR>
     * &nbsp;&nbsp;&nbsp; in Nord/Süd Richtung: KfZ: gelb | Fussgänger rot <BR>
     * 8: in Ost/West Richtung: KfZ: rotgelb | Fussgänger grün <BR>
     * &nbsp;&nbsp;&nbsp; in Nord/Süd Richtung: KfZ: rot | Fussgänger rot <BR>
     */
    private int schaltphase;

    // Zeitsteuerung für die Ampelschaltung
    private int wartezeitAmpel;

    private int wartezeitKurz;

    private int wartezeitLang;

    private int wartezeitFahrzeugNachOst;

    private int wartezeitFahrzeugNachWest;

    private int wartezeitFahrzeugNachNord;

    private int wartezeitFahrzeugNachSued;

    private int mittlereWartezeit;

    private Random zzgenerator;
    // Referenzattribute

    private AMPEL ampelNord;

    private AMPEL ampelOst;

    private AMPEL ampelSued;

    private AMPEL ampelWest;

    private FUSSGAENGERAMPEL fgAmpelNord1;

    private FUSSGAENGERAMPEL fgAmpelNord2;

    private FUSSGAENGERAMPEL fgAmpelOst1;

    private FUSSGAENGERAMPEL fgAmpelOst2;

    private FUSSGAENGERAMPEL fgAmpelSued1;

    private FUSSGAENGERAMPEL fgAmpelSued2;

    private FUSSGAENGERAMPEL fgAmpelWest1;

    private FUSSGAENGERAMPEL fgAmpelWest2;

    private FAHRBAHN nachOst;

    private FAHRBAHN nachWest;

    private FAHRBAHN nachNord;

    private FAHRBAHN nachSued;

    /**
     * Erzeugt die vier Ampeln, positioniert sie um den Ursprung und setzt die
     * Lichtsignale so, dass eine Grünphase in Ost/West Richtung und
     * gleichzeitig der Rotphase in Nord/Süd Richtung vorliegt.
     */
    public KREUZUNG()
    {
        schaltphase = 1;
        ampelNord = new AMPEL(-2, -6, 'N');
        ampelNord.RotSetzen();
        fgAmpelNord1 = new FUSSGAENGERAMPEL(-4, -2, 'N');
        fgAmpelNord1.RotSetzen();
        fgAmpelNord2 = new FUSSGAENGERAMPEL(3, -2, 'N');
        fgAmpelNord2.RotSetzen();
        ampelOst = new AMPEL(5, -2, 'O');
        ampelOst.GruenSetzen();
        fgAmpelOst1 = new FUSSGAENGERAMPEL(1, -4, 'O');
        fgAmpelOst1.GruenSetzen();
        fgAmpelOst2 = new FUSSGAENGERAMPEL(1, 3, 'O');
        fgAmpelOst2.GruenSetzen();
        ampelSued = new AMPEL(1, 5, 'S');
        ampelSued.RotSetzen();
        fgAmpelSued1 = new FUSSGAENGERAMPEL(3, 1, 'S');
        fgAmpelSued1.RotSetzen();
        fgAmpelSued2 = new FUSSGAENGERAMPEL(-4, 1, 'S');
        fgAmpelSued2.RotSetzen();
        ampelWest = new AMPEL(-6, 1, 'W');
        ampelWest.GruenSetzen();
        fgAmpelWest1 = new FUSSGAENGERAMPEL(-2, 3, 'W');
        fgAmpelWest1.GruenSetzen();
        fgAmpelWest2 = new FUSSGAENGERAMPEL(-2, -4, 'W');
        fgAmpelWest2.GruenSetzen();
        nachOst = new FAHRBAHN(ampelOst);
        nachOst.PositionSetzen(0, 0);
        nachOst.AusrichtungSetzen('O');
        nachWest = new FAHRBAHN(ampelWest);
        nachWest.PositionSetzen(0, 0);
        nachWest.AusrichtungSetzen('W');
        nachNord = new FAHRBAHN(ampelNord);
        nachNord.PositionSetzen(0, 0);
        nachNord.AusrichtungSetzen('N');
        nachSued = new FAHRBAHN(ampelSued);
        nachSued.PositionSetzen(0, 0);
        nachSued.AusrichtungSetzen('S');
        wartezeitKurz = 5;
        wartezeitLang = 30;
        wartezeitAmpel = 0;
        wartezeitFahrzeugNachOst = 0;
        wartezeitFahrzeugNachWest = 0;
        wartezeitFahrzeugNachNord = 0;
        wartezeitFahrzeugNachSued = 0;
        mittlereWartezeit = 6;
        zzgenerator = new Random(0); // Bei jedem Start die gleiche Zufallsfolge
    }

    /**
     * Schaltet die Phase entprechend der beim Attribut Phase angegebenen
     * Reihenfolge weiter.
     *
     */
    public void Weiterschalten()
    {
        switch (schaltphase)
        {
        case 1:
            fgAmpelWest1.RotSetzen();
            fgAmpelWest2.RotSetzen();
            fgAmpelOst1.RotSetzen();
            fgAmpelOst2.RotSetzen();
            schaltphase = 2;
            wartezeitAmpel = wartezeitLang;
            break;

        case 2:
            ampelWest.GelbSetzen();
            ampelOst.GelbSetzen();
            schaltphase = 3;
            wartezeitAmpel = wartezeitKurz;
            break;

        case 3:
            ampelWest.RotSetzen();
            ampelOst.RotSetzen();
            ampelNord.RotgelbSetzen();
            ampelSued.RotgelbSetzen();
            fgAmpelNord1.GruenSetzen();
            fgAmpelNord2.GruenSetzen();
            fgAmpelSued1.GruenSetzen();
            fgAmpelSued2.GruenSetzen();
            schaltphase = 4;
            wartezeitAmpel = wartezeitKurz;
            break;

        case 4:
            ampelNord.GruenSetzen();
            ampelSued.GruenSetzen();
            schaltphase = 5;
            wartezeitAmpel = wartezeitLang;
            break;

        case 5:
            fgAmpelNord1.RotSetzen();
            fgAmpelNord2.RotSetzen();
            fgAmpelSued1.RotSetzen();
            fgAmpelSued2.RotSetzen();
            schaltphase = 6;
            wartezeitAmpel = wartezeitLang;
            break;

        case 6:
            ampelNord.GelbSetzen();
            ampelSued.GelbSetzen();
            schaltphase = 7;
            wartezeitAmpel = wartezeitKurz;
            break;

        case 7:
            ampelWest.RotgelbSetzen();
            ampelOst.RotgelbSetzen();
            ampelNord.RotSetzen();
            ampelSued.RotSetzen();
            fgAmpelWest1.GruenSetzen();
            fgAmpelWest2.GruenSetzen();
            fgAmpelOst1.GruenSetzen();
            fgAmpelOst2.GruenSetzen();
            schaltphase = 8;
            wartezeitAmpel = wartezeitKurz;
            break;

        case 8:
            ampelWest.GruenSetzen();
            ampelOst.GruenSetzen();
            schaltphase = 1;
            wartezeitAmpel = wartezeitLang;
            break;
        }
    }

    /**
     * Erzeugt eine zufällige Wartezeit mit großer Wahrscheinlichkeit in der
     * Mitte
     *
     * @return die erzeugte Wartezeit
     */
    private int WartezeitGenerieren()
    {
        float auswahl;
        auswahl = zzgenerator.nextFloat();
        if (auswahl < 0.1f)
        {
            return mittlereWartezeit - 2; // 10% Wahrscheinlichkeit
        }
        else if (auswahl < 0.30f)
        {
            return mittlereWartezeit - 1; // 20% Wahrscheinlichkeit
        }
        else if (auswahl < 0.70f)
        {
            return mittlereWartezeit; // 40% Wahrscheinlichkeit
        }
        else if (auswahl < 0.90f)
        {
            return mittlereWartezeit + 1; // 20% Wahrscheinlichkeit
        }
        else
        {
            return mittlereWartezeit + 2; // 10% Wahrscheinlichkeit
        }
    }

    /**
     * Erzeugt ein neues Fahrzeug
     *
     * @return das neue Fahrzeug
     */
    FAHRZEUG FahrzeugGenerieren()
    {
        switch (zzgenerator.nextInt(5))
        {
        case 0:
        case 1:
            return new PKW();

        case 2:
            return new LKW();

        case 3:
            return new SPORTWAGEN();

        case 4:
            return new LKWMITANHAENGER();

        default:
            return null;
        }
    }

    /**
     * Empfängt die Impulse des Taktgebers Sie schaltet die Ampeln weiter und
     * erzeugt und bewegt die Fahrzeuge.
     */
    public void TaktImpulsAusfuehren()
    {
        // Ampeln weiterschalten
        if (wartezeitAmpel <= 0)
        {
            Weiterschalten();
        }
        else
        {
            wartezeitAmpel = wartezeitAmpel - 1;
        }
        // Fahrzeuge bewegen
        nachOst.FahrzeugeBewegen();
        nachWest.FahrzeugeBewegen();
        nachSued.FahrzeugeBewegen();
        nachNord.FahrzeugeBewegen();
        // neue Fahrzeuge erzeugen
        if (wartezeitFahrzeugNachOst <= 0)
        {
            nachOst.FahrzeugEinreihen(FahrzeugGenerieren());
            wartezeitFahrzeugNachOst = WartezeitGenerieren();
        }
        else
        {
            wartezeitFahrzeugNachOst = wartezeitFahrzeugNachOst - 1;
        }
        if (wartezeitFahrzeugNachWest <= 0)
        {
            nachWest.FahrzeugEinreihen(FahrzeugGenerieren());
            wartezeitFahrzeugNachWest = WartezeitGenerieren();
        }
        else
        {
            wartezeitFahrzeugNachWest = wartezeitFahrzeugNachWest - 1;
        }
        if (wartezeitFahrzeugNachNord <= 0)
        {
            nachNord.FahrzeugEinreihen(FahrzeugGenerieren());
            wartezeitFahrzeugNachNord = WartezeitGenerieren();
        }
        else
        {
            wartezeitFahrzeugNachNord = wartezeitFahrzeugNachNord - 1;
        }
        if (wartezeitFahrzeugNachSued <= 0)
        {
            nachSued.FahrzeugEinreihen(FahrzeugGenerieren());
            wartezeitFahrzeugNachSued = WartezeitGenerieren();
        }
        else
        {
            wartezeitFahrzeugNachSued = wartezeitFahrzeugNachSued - 1;
        }
    }

    /**
     * Setzt die mittlere Wartezeit zwischen 2 Fahrzeugen
     *
     * @param zeit mittlere Wartezeit
     */
    void FahrzeugabstandSetzen(int zeit)
    {
        mittlereWartezeit = zeit;
    }
}
