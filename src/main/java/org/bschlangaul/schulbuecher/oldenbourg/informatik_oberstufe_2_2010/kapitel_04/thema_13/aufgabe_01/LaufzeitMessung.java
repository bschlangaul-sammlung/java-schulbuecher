package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_04.thema_13.aufgabe_01;

/**
 * Messung der Laufzeit
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class LaufzeitMessung
{
    int i = 0;

    /**
     * Methode zum Testen der Laufzeit einer anderen Methode, die unterhalb des
     * Kommentars aufgerufen werden muss.
     *
     * @return Ausführungsdauer
     */
    public long LaufzeitTesten()
    {
        long startNanoTime;
        startNanoTime = System.nanoTime();
        // Hier muss die zu testende Methode notiert werden. Als Beispiel hier
        // ObjektErzeugen().
        ObjektErzeugen();
        return System.nanoTime() - startNanoTime;
    }

    /**
     * Beispielmethode erzeugt ein Objekt
     */
    public void ObjektErzeugen()
    {
        new Object();
    }

    /**
     * Beispielmethode erzeugt ein Feld
     */
    public void FeldErzeugen()
    {
        @SuppressWarnings("unused")
        int[] feld = new int[10];
    }

    /**
     * Beispielmethode inkrementiert den Wert eines Attributs
     */
    public void Inkrementieren()
    {
        i++;
    }
}
