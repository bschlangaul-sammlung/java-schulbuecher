package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_12.snake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * Zeitkontrolle des Spiels.
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class TaktGeber implements ActionListener
{
    /**
     * Timerobjekt für die zentrale Zeitverwaltung
     */
    private Timer timer;

    /**
     * zu steuernde Objekte, müssen von jedem Takt benachrichtigt werden.
     */
    private Spiel spiel;

    /**
     * Standardkonstruktor für Objekte der Klasse TAKTGEBER. Erzeugt den
     * Taktgeber und trägt das Spiel als Klient ein.
     *
     * @param s das zu bedienende Spiel
     */
    TaktGeber(Spiel s)
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
