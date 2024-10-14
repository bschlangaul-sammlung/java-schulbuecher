package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_07.aufgabe_09.druckauftraege;

/**
 * Klasse DRUCKER ermöglicht das mehrfache "Drucken" von ASCII-Bilder auf der
 * Standardausgabe. Gerne kannst du weitere Standardmotive ergänzen.
 *
 * @author Peter Brichzin
 *
 * @version Version 1.0
 */
class Drucker
{
    /**
     * Mehrfaches Drucken eines Motivs.
     */
    void Drucken(int anzahl, char motiv)
    {
        for (int nummer = 0; nummer < anzahl; nummer = nummer + 1)
        {
            switch (motiv)
            {
            case 'F':
                FahrradfahrerDrucken();
                break;

            case 'K':
                KatzeDrucken();
                break;

            case 'T':
                TorteDrucken();
                break;

            default:
                System.out.println("Falsche Auswahl! Nur möglich");
                System.out.println("F für Fahrradfahrer");
                System.out.println("K für Katze");
                System.out.println("T für Torte");
            }
        }
    }

    /**
     * Drucken einer Katze auf der Standardausgabe.
     */
    void KatzeDrucken()
    {
        System.out.println("        /\\_/\\ ");
        System.out.println("   ____/ o o \\ ");
        System.out.println(" /~____  =ø= / ");
        System.out.println("(______)__m_m) ");
        System.out.println("       ");
    }

    /**
     * Drucken einer Torte auf der Standardausgabe.
     */
    void TorteDrucken()
    {
        System.out.println("        ()     ()       ()      ()");
        System.out.println("        ||     ||       ||      ||");
        System.out.println("    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(" {~*~*~*~*~*~*~*~ ALLES GUTE ~*~*~*~*~*~} ");
        System.out.println(" {~*~*~*~*~*~*~ ZUM GEBURTSTAG ~*~*~*~*~} ");
        System.out.println(" {~*~*~*~*~*~*~*~ ALLES GUTE ~*~*~*~*~*~} ");
        System.out.println(" {~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~**~} ");
        System.out.println("       ");
    }

    /**
     * Drucken eines Fahrradfahrers auf der Standardausgabe.
     */
    void FahrradfahrerDrucken()
    {
        System.out.println("   ------- __@");
        System.out.println("----- _`\\<,_    ");
        System.out.println("---- (*)/ (*)   ");
        System.out.println("       ");
    }
}
