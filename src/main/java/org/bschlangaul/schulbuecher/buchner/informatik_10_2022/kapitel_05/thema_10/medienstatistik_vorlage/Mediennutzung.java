package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.medienstatistik_vorlage;

/**
 * Projekt 5-10_Medienstatistik (ÜuV Aufgabe 12)
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
@SuppressWarnings("unused")
public class Mediennutzung
{
    private double[] medien10A;

    private double[] medien10B;

    private double[] medien10C;

    private double[] klassenverbund;

    private int[] anzahlBildschirmgeraete;

    public Mediennutzung(int anzahlSchueler10A, int anzahlSchueler10B,
            int anzahlSchueler10C)
    {
        this.medien10A = new double[anzahlSchueler10A];
        this.medien10B = new double[anzahlSchueler10B];
        this.medien10C = new double[anzahlSchueler10C];
        int j = 0;
        while (j < anzahlSchueler10A)
        {
            this.medien10A[j] = 5.0;
            j = j + 1;
        }
        int k = 0;
        while (k < anzahlSchueler10B)
        {
            this.medien10B[k] = 6.0;
            k = k + 1;
        }
        int l = 0;
        while (l < anzahlSchueler10C)
        {
            this.medien10C[l] = 7.0;
            l = l + 1;
        }
        this.klassenverbund = new double[this.medien10A.length
                + this.medien10B.length + this.medien10C.length];
        // Hier erweitern für Aufgabe 12a
    }

    public double berechneMinimum()
    {
        // Hier erweitern für Aufgabe 12b
        return -1.0;
    }

    // Ab hier Dinge ändern für Aufgabe 12c
    public String vergleicheKlassendurchschnitt()
    {
        double durchschnitt10A = 0;
        double durchschnitt10C = 2;
        return "Den höchsten Durchschnitt hat: " + durchschnitt10C;
    }

    public double berechneDurchschnitt(double[] array)
    {
        return -1;
    }
}
