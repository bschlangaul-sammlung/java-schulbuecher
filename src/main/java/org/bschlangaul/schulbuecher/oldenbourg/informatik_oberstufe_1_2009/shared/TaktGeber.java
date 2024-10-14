package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.shared;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * Zeitkontrolle der Kreuzung.
 *
 * @author Klaus Reinold und Barbara Leidorn
 *
 * @version 1.0
 */
public class TaktGeber implements ActionListener
{
    /**
     * Timerobjekt für die zentrale Zeitverwaltung
     */
    Timer timer;

    /**
     * zu steuernde Objekte, müssen von jedem Takt benachrichtigt werden.
     */
    // Hierher kommen die Attribute für die zu benachrichtigenden Objekte
    TaktKlient klient;

    /**
     * Standardkonstruktor für Objekte der Klasse Taktgeber. Erzeugt den
     * Taktgeber und trägt die Kreuzung als Klient ein.
     *
     * @param klient der zu bedienende Klient
     */
    public TaktGeber(TaktKlient klient)
    {
        timer = new Timer(1000, this);
        this.klient = klient;
    }

    /**
     * vom Timer aufgerufen erhöht die Simulationszeit und benachrichtigt alle
     * eingetragenen Objekte
     *
     * @param evt der Timerevent
     */
    public void actionPerformed(ActionEvent evt)
    {
        // hierher kommen die Aufrufe für die zu benachrichtigenden Objekte
        klient.TaktImpulsAusfuehren();
    }

    /**
     * Timer starten
     */
    public void Starten()
    {
        timer.start();
    }

    /**
     * Timer anhalten
     */
    public void Anhalten()
    {
        timer.stop();
    }

    /**
     * Ablaufgeschwindigkeit einstellen
     *
     * @param dauer: Angabe in Millisekunden
     */
    public void TaktdauerSetzen(int dauer)
    {
        timer.setDelay(dauer);
    }
}
