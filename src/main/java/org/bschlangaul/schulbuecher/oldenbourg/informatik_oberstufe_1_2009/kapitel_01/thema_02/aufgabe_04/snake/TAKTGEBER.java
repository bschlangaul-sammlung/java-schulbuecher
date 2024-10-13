package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_02.aufgabe_04.snake;

import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;

/**
 * Zeitkontrolle des Spiels.
 *
 * @author Klaus van Dijkstran
 *
 * @version 1.0
 */
class TAKTGEBER implements ActionListener
{
    /** Timerobjekt für die zentrale Zeitverwaltung */
    private Timer timer;

    /** zu steuernde Objekte, müssen von jedem Takt benachrichtigt werden. */
    private SPIEL spiel;

    /**
     * Standardkonstruktor für Objekte der Klasse TAKTGEBER. Erzeugt den
     * Taktgeber und trägt das Spiel als Klient ein.
     *
     * @param s das zu bedienende Spiel
     */
    TAKTGEBER(SPIEL s)
    {
        timer = new Timer(1, this);
        spiel = s;
        TaktdauerSetzen(400);
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
        spiel.SpielSchritt();
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
