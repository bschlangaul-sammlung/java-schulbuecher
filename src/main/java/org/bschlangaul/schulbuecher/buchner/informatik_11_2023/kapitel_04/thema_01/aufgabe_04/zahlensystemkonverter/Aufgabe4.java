package org.bschlangaul.schulbuecher.buchner.informatik_11_2023.kapitel_04.thema_01.aufgabe_04.zahlensystemkonverter;

public class Aufgabe4
{
    public Aufgabe4()
    {
    }

    // Aufgabe 4a
    public String dezimalZuBinär(int eingabeDezimal)
    {
        String ausgabe = "";
        if (eingabeDezimal < 0)
        {
            System.out.println("Nur positive Zahlen verwenden");
            return "-1";
        }
        else
        {
            // Eine direkte Umwandlung kann mit
            // ausgabe = Integer.toBinaryString(eingabeDezimal);
            // gemacht werden
            // Lösung nach dem Algorithmus aus dem Buch
            // Finden der größten Stufenzahl im Dualsystem
            int basis = 2;
            int stufenzahl = 1;
            // Ist die nächste Stufenzahl noch größer als unsere Eingabe?
            while (stufenzahl * basis <= eingabeDezimal)
            {
                stufenzahl = stufenzahl * basis;
            }
            // Zerlegen der Eingabe
            while (stufenzahl >= 1)
            {
                // Rest der Division wird als Binärstelle gespeichert
                ausgabe = ausgabe + eingabeDezimal / stufenzahl;
                // Eingabe wird reduziert
                eingabeDezimal = eingabeDezimal % stufenzahl;
                // Nächste Stufenzahl
                stufenzahl = stufenzahl / basis;
            }
            System.out.println(ausgabe);
            return ausgabe;
        }
    }

    // Aufgabe 4b
    public String dezimalZuHexadezimal(int eingabeDezimal)
    {
        String ausgabe = "";
        if (eingabeDezimal < 0)
        {
            System.out.println("Nur positive Zahlen verwenden");
            return "-1";
        }
        else
        {
            // Eine direkte Umwandlung kann mit
            // ausgabe = Integer.toHexString(eingabeDezimal);
            // gemacht werden
            // Lösung nach dem Algorithmus aus dem Buch
            // Finden der größten Stufenzahl im Dualsystem
            int basis = 16;
            int stufenzahl = 1;
            // Ist die nächste Stufenzahl noch größer als unsere Eingabe?
            while (stufenzahl * basis <= eingabeDezimal)
            {
                stufenzahl = stufenzahl * basis;
            }
            // Zerlegen der Eingabe
            while (stufenzahl >= 1)
            {
                // Rest der Division wird als Binärstelle gespeichert, Zahlen
                // größer als 9 müssen in
                // Buchstaben umgeandelt werden.
                if (eingabeDezimal / stufenzahl < 10)
                    ausgabe = ausgabe + eingabeDezimal / stufenzahl;
                else if (eingabeDezimal / stufenzahl == 10)
                    ausgabe = ausgabe + "A";
                else if (eingabeDezimal / stufenzahl == 10)
                    ausgabe = ausgabe + "B";
                else if (eingabeDezimal / stufenzahl == 10)
                    ausgabe = ausgabe + "C";
                else if (eingabeDezimal / stufenzahl == 10)
                    ausgabe = ausgabe + "D";
                else if (eingabeDezimal / stufenzahl == 10)
                    ausgabe = ausgabe + "E";
                else
                    ausgabe = ausgabe + "F";
                // Eingabe wird reduziert
                eingabeDezimal = eingabeDezimal % stufenzahl;
                // Nächste Stufenzahl
                stufenzahl = stufenzahl / basis;
            }
            System.out.println(ausgabe);
            return ausgabe;
        }
    }

    // Aufgabe 4c
    public String binaerZuHexadezimal(String eingabeBinaer)
    {
        int ausgabe = 0;
        // Lösung über Half-Byte entspricht einer Hexadezimalstelle
        // 0000 -> 0; 0001 -> 1; 0010 -> 2; ... ; 1110 -> E; 1111 -> F
        // wäre möglich
        // Hier verwendent wird:
        // Binär- in Dezimalzahl und dann den Algorithmus von 4b verwenden
        int basis = 2;
        int stufenzahl = 1;
        int stelle = eingabeBinaer.length() - 1;
        // eingabeBinaer wird von Rechts nach Links durchgelaufen und
        // entsprechend der Stufenzahl
        // ausgewertet
        while (stelle >= 0)
        {
            if (eingabeBinaer.charAt(stelle) == '0')
                ;
            if (eingabeBinaer.charAt(stelle) == '1')
            {
                ausgabe = ausgabe + stufenzahl * 1;
            }
            stufenzahl = stufenzahl * basis;
            stelle--;
        }
        System.out.println("Zwischenschritt Dezimal: " + ausgabe);
        return dezimalZuHexadezimal(ausgabe);
    }
}
