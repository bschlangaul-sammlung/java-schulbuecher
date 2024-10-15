package org.bschlangaul.schulbuecher.klett.informatik_2_2021.kapitel_06.thema_03.aufgabe_02.flaggen_der_erde_iii;

class Flagge
{
    Rechteck r1, r2, r3, r4, r5, r6, r7, r8, r9;

    Dreieck d1, d2, d3, d4, d5, d6, d7, d8, d9;

    Kreis k1, k2, k3, k4, k5, k6, k7, k8, k9;

    Flagge()
    {
        r1 = new Rechteck(0, 0, 300, 200, "gelb");
        d1 = new Dreieck(0, 0, 0, 200, 200, 0, "grün");
        d2 = new Dreieck(300, 200, 300, 0, 100, 200, "rot");
    }

    // Definition des zweiten Konstruktors ergänzen.

}
