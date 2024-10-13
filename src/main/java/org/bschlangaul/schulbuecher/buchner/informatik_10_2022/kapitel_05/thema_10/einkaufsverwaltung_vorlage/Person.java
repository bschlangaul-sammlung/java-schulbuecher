package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.einkaufsverwaltung_vorlage;

import java.time.LocalDate;
import java.util.*;

/**
 * Projekt 5-10_Einkaufsverwaltung (ÜuV Aufgabe 24)
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
public class Person
{
    String name;

    Einkauf[] einkaeufe;

    public Person()
    {
        this.name = "Tochter Geizig";
        this.einkaeufe = new Einkauf[10];
        einkaeufe[0] = new Einkauf();
        // TODO: Hier für Tochter sämtliche Einkäufe reinpacken einkaeufe[1] =
        // new Einkauf({new
        // Artikel("
    }

    public Person(String name, Einkauf[] einkaeufe)
    {
        this.name = name;
        this.einkaeufe = einkaeufe;
    }

    public String berechneAusgabenImGeschaeft(String geschaeft)
    {
        // 24j
        return "In dem Geschaeft " + "xxx" + " wurde insgesamt " + 5
                + " mal eingekauft und insgesamt " + 3 + " € ausgegeben ";
    }

    public double berechneAusgaben(String kategorie)
    {
        // 24k
        return -1.0;
    }

    public String berechneTeuersterTag()
    {
        LocalDate datum = einkaeufe[0].nenneDatum();
        // 24l
        return "Am " + datum + " wurde der höchste Geldbetrag, nämlich " + 5
                + " Euro ausgegeben.";
    }

    public String berechneUnbeliebtesteKategorie(int index)
    {
        // 24m
        return "In der unbeliebtesten Kategorie " + "xxx" + " wurden insgesamt "
                + 5 + " Euro ausgegeben.";
    }
}
