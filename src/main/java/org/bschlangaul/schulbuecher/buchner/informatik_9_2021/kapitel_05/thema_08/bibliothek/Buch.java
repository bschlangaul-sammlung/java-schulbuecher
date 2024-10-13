package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_08.bibliothek;

import greenfoot.Actor;

/**
 * Klasse zum Setzen der Eigenschaften der Buch-Objekte. Kap. 5.6, Aufgabe 1
 */
public class Buch extends Actor
{
    String name;

    String autor;

    // double preisInEuro;
    int preisInCent;

    Buch(String startName, String startAutor, double startPreisInEuro)
    {
        name = startName;
        autor = startAutor;
        preisInCent = (int) startPreisInEuro * 100;
        aktualisiereBild(); // zeigt ein Buch mit dessen Preis an
    }

    double gibPreisInEuro() // Getter für double preisInEuro
    {
        return preisInCent / 100;
    }
    // void setzePreisInEuro(double neuerPreisInEuro) // Setter für double
    // preisInEuro
    // {
    // preisInEuro = neuerPreisInEuro;
    // aktualisiereBild();
    // }

    int gibPreisInCent() // Getter für int preisInCent
    {
        return preisInCent;
    }

    void setzePreisInCent(int neuerPreisInCent) // Setter für int preisInCent
    {
        preisInCent = neuerPreisInCent;
        aktualisiereBild();
    }

    /*
     * Der Programmtext ab hier braucht für die Bearbeitung der Arbeitsaufträge
     * und Aufgaben weder gelesen noch verstanden zu werden.
     */
    void aktualisiereBild()
    {
        setImage(BildHilfe.erstelleBuchBild(this));
    }
}
