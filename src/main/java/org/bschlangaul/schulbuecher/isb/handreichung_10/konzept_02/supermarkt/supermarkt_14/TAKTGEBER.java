package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_02.supermarkt.supermarkt_14;

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
class TAKTGEBER
{
    /**
     * Timerobjekt für die zentrale Zeitverwaltung
     */
    private Timer timer;

    /**
     * zu steuernde Objekte, mssen von jedem Takt benachrichtigt werden.
     */
    private ArrayList<TAKTKLIENT> klienten;

    /**
     * Legt den eigentlichen Zeitgeber an. Der Impulsabstand betrgt eine
     * Sekunde
     */
    TAKTGEBER()
    {
        klienten = new ArrayList<TAKTKLIENT>();
        timer = new Timer(1000, new ActionListener()
        {
            /**
             * vom Timer aufgerufen benachrichtigt alle eingetragenen Objekte
             *
             * @param evt der Timerevent
             */
            public void actionPerformed(ActionEvent evt)
            {
                for (TAKTKLIENT klient : klienten)
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
    void Registrieren(TAKTKLIENT k)
    {
        klienten.add(k);
    }
}
