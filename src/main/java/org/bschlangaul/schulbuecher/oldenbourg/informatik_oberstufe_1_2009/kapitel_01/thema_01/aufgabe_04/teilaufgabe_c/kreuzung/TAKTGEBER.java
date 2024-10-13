package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_04.teilaufgabe_c.kreuzung;

import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;

/**
 * Zeitkontrolle der Kreuzung.
 *
 * @author Klaus van Dijkstran und Barbara Leidorn
 *
 * @version 1.0
 */
class TAKTGEBER implements ActionListener
{
    /** Timerobjekt für die zentrale Zeitverwaltung */
    Timer timer;

    /** zu steuernde Objekte, müssen von jedem Takt benachrichtigt werden. */
    // Hierher kommen die Attribute für die zu benachrichtigenden Objekte
    TAKTKLIENT klient;

    /**
     * Standardkonstruktor für Objekte der Klasse Taktgeber. Erzeugt den
     * Taktgeber und trägt die Kreuzung als Klient ein.
     *
     * @param klient der zu bedienende Klient
     */
    TAKTGEBER(TAKTKLIENT klient)
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
     * Ablaufgeschwindigkeit einstellen
     *
     * @param dauer: Angabe in Millisekunden
     */
    void TaktdauerSetzen(int dauer)
    {
        timer.setDelay(dauer);
    }
}
