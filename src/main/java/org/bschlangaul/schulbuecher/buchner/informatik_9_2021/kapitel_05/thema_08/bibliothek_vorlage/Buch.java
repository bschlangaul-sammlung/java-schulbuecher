package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_08.bibliothek_vorlage;

import greenfoot.Actor;

public class Buch extends Actor
{
    String titel;

    String autor;

    double preisInEuro;

    Buch(String titel, String autor, double preisInEuro)
    {
        this.titel = titel;
        this.autor = autor;
        this.preisInEuro = preisInEuro;
        // zeigt ein Buch mit dessen Preis an
        aktualisiereBild();
    }

    double gibPreisInEuro()
    {
        return preisInEuro;
    }

    void setzePreisInEuro(double neuerPreisInEuro)
    {
        preisInEuro = neuerPreisInEuro;
        aktualisiereBild();
    }

    /**
     * Der Programmtext ab hier braucht für die Bearbeitung der Arbeitsaufträge
     * und Aufgaben weder gelesen noch verstanden zu werden.
     */
    void aktualisiereBild()
    {
        setImage(BildHilfe.erstelleBuchBild(this));
    }
}
