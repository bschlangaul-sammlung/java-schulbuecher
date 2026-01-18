package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.zweidimensionales_array_vorlage;

/**
 * Projekt 5-10_ZweidimensionalesArray (ÜuV Aufgabe 25)
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
public class Array
{
    private int[][] tabelle;

    public Array(int laenge, int breite)
    {
        tabelle = new int[laenge][breite];
        int i = 0;
        int j = 0;
        while (i < laenge)
        {
            while (j < breite)
            {
                tabelle[i][j] = j + breite * i;
                j = j + 1;
            }
            j = 0;
            i = i + 1;
        }
    }

    /**
     * Die Methode gibt die Werte der eingegebenen Zeile aus. Achtung: Hier wird
     * davon ausgegangen, dass der Benutzer Werte zwischen 1 und der maximalen
     * Anzahl an Zeilen angibt.
     */
    public void zeileAusgeben(int zeilennummer)
    {
        // 25b
    }

    public void tabelleAusgeben()
    {
        // 25c
    }
}
