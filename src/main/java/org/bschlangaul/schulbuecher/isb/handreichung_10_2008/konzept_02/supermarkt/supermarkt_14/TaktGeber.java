package org.bschlangaul.schulbuecher.isb.handreichung_10_2008.konzept_02.supermarkt.supermarkt_14;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

/**
 * Zeitkontrolle der Simulation.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class TaktGeber
{
    /**
     * Timerobjekt für die zentrale Zeitverwaltung
     */
    private Timer timer;

    /**
     * zu steuernde Objekte, mssen von jedem Takt benachrichtigt werden.
     */
    private ArrayList<TaktKlient> klienten;

    /**
     * Legt den eigentlichen Zeitgeber an. Der Impulsabstand betrgt eine
     * Sekunde
     */
    TaktGeber()
    {
        klienten = new ArrayList<TaktKlient>();
        timer = new Timer(1000, new ActionListener()
        {
            /**
             * vom Timer aufgerufen benachrichtigt alle eingetragenen Objekte
             *
             * @param evt der Timerevent
             */
            public void actionPerformed(ActionEvent evt)
            {
                for (TaktKlient klient : klienten)
                {
                    klient.TaktImpulsAusfuehren();
                }
            }
        });
    }

    /**
     * Timer starten
     */
    void Starten()
    {
        timer.start();
    }

    /**
     * Timer anhalten
     */
    void Anhalten()
    {
        timer.stop();
    }

    /**
     * Taktimpulsabtand einstellen
     *
     * @param dauer Impulsabstand in Millisekunden
     */
    void DauerSetzen(int dauer)
    {
        timer.setDelay(dauer);
    }

    /**
     * Registriert einen neuen Klienten beim Taktgeber.
     *
     * @param k der neuen Klient
     */
    void Registrieren(TaktKlient k)
    {
        klienten.add(k);
    }
}
