package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Verwaltet die Einträge in die Logdatei.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class LOGDATEI implements MELDUNGSBEOBACHTER
{
    /**
     * Zeichenstrom zur Ausgabedatei
     */
    BufferedWriter writer;

    /**
     * öffnet die Logdatei.
     */
    LOGDATEI()
    {
        try
        {
            writer = new BufferedWriter(new FileWriter("log.dat", true));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Schliesst die Logdatei.
     */
    void Schliessen()
    {
        try
        {
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Fehlermeldungen beim Ausführen von Aktionen
     */
    public void FehlermeldungEmpfangen(String text)
    {
        // nichts
    }

    /**
     * Aktionslog für den Ablauf
     */
    public void LogeintragEmpfangen(String text)
    {
        try
        {
            writer.write(text);
            writer.newLine();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
