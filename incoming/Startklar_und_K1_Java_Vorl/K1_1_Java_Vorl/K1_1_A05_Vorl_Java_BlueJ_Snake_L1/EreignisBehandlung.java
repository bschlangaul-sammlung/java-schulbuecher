import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Verwaltet die Ereignisse
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class EreignisBehandlung
{
    /** Timerobjekt für die zentrale Zeitverwaltung */
    private Timer timer;
    
    /**
     * Standardkonstruktor für Objekte der Klasse Simulation.
     * Erzeugt den Taktgeber.
     */
    EreignisBehandlung()
    {
        timer = new Timer(1000, new ActionListener() {
            /**
             * vom Timer aufgerufen
             * erhöht die Simulationszeit
             * @param evt der Timerevent
             */
            public void actionPerformed(ActionEvent evt)
            {
                TaktImpulsAusführen();
            }
        });
        Oberflaeche.FensterGeben().addKeyListener(new KeyAdapter() {
            /**
             * Gibt die Taste an die eigentliche Aktionsmethode weiter.
             * @param e das zugrestellte Ereignis
             */
            public void keyPressed(KeyEvent e)
            {
                TasteGedrückt((char) e.getKeyCode());
            }
        });
        Oberflaeche.OberflächeGeben().SteuerungSetzen(new Oberflaeche.Steuerung()
        {
        /**
         * Setzt den Starttakt für das Spiel.
         * @param starttakt Der Starttakt in Millisekunden
         */
        public void StartTaktSetzen(int starttakt)
        {
            TaktdauerSetzen(starttakt);
        }
        
        /**
         * Startet das Spiel.
         */
        public void StartAusführen()
        {
            Starten();
        }
        });
    }
    
    /**
     * Die eigentliche Aktionsmethode des Timers.
     * Muss bei Bedarf von einer Unterklasse überschrieben werden.
     */
    void TaktImpulsAusführen()
    {
        System.out.println("Tick");
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
    
    /**
     * Die eigentliche Aktionsmethode für gedrückte Tasten.
     * <br>Muss bei Bedarf von einer Unterklasse überschrieben werden.
     * @param welche die gedrückte Taste
     */
    void TasteGedrückt(char welche)
    {
        System.out.println("Taste gedrückt: " + welche);
    }
}
