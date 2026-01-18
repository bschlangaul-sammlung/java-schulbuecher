package schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_08.bibliothek_vorlage;

import greenfoot.GreenfootImage;

/**
 * Der Programmtext dieser Klasse braucht für die Bearbeitung der
 * Arbeitsaufträge und Aufgaben weder gelesen noch verstanden zu werden.
 * Erstellt richtige Bilder für Objekte der Klassen Schueler und Buch.
 */
public class BildHilfe
{
    static GreenfootImage erstelleBuchBild(Buch buch)
    {
        double preisAusBuchInEuro = buch.gibPreisInEuro();
        GreenfootImage img;
        img = new GreenfootImage("Buch.png");
        String preisStr = String.format("%.2f", preisAusBuchInEuro) + "€";
        img.drawString(preisStr, 55, 111);
        return img;
    }

    static GreenfootImage erstelleSchuelerBild(char geschlecht, int alter)
    {
        GreenfootImage img;
        int groesse = 64;
        if (alter <= 16)
        {
            groesse = 48;
        }
        if (alter <= 14)
        {
            groesse = 32;
        }
        if (alter <= 12)
        {
            groesse = 24;
        }
        int closest = getClosest(groesse, new int[] { 16, 20, 24, 32, 48, 64 });
        char geschlechtFilename = geschlecht == 'm' ? 'm' : 'w';
        String filename = geschlechtFilename + "" + closest + ".png";
        img = new GreenfootImage(filename);
        img.scale(groesse, groesse);
        return img;
    }

    static int getClosest(int nr, int[] vals)
    {
        int dist = Integer.MAX_VALUE;
        int val = Integer.MAX_VALUE;
        for (int curVal : vals)
        {
            int curDist = Math.abs(nr - curVal);
            if (curDist < dist)
            {
                dist = curDist;
                val = curVal;
            }
            if (curDist == dist && curVal > val)
            {
                val = curVal;
            }
        }
        return val;
    }
}
