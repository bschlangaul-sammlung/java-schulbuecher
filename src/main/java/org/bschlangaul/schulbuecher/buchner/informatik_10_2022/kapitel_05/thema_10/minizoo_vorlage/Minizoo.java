package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.minizoo_vorlage;

/**
 * Klasse zur Darstellung eines kleinen Zoos mit Löwen, Elefanten und Kamelen
 */
public class Minizoo
{
    private Loewe[] loewen;

    private Elefant[] elefanten;

    private Kamel[] kamele;

    public Minizoo()
    {
        loewen = new Loewe[4];
        loewen[0] = new Loewe("Mufasa", 'm');
        loewen[1] = new Loewe("Simba", 'm');
        loewen[2] = new Loewe("Nala", 'w');
        loewen[3] = new Loewe("Sarabi", 'w');
        elefanten = new Elefant[3];
        elefanten[0] = new Elefant("Panang", 'w');
        elefanten[1] = new Elefant("Mangala", 'w');
        elefanten[2] = new Elefant("Gajendra", 'm');
        kamele = new Kamel[3];
        kamele[0] = new Kamel("Shamoo", 'm', 1.9);
        kamele[1] = new Kamel("Sanja", 'w', 2.0);
        kamele[2] = new Kamel("Piotr", 'm', 1.95);
    }
}
