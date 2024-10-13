
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Verwaltet das Ausgabefenster.
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class Oberflaeche
{
    /**
     * Beschreibt die Methoden, die die Oberfäche beim Drücken der Knöpfe aufrufen kann.
     */
    interface Steuerung
    {
        /**
         * Setzt den Starttakt für das Spiel.
         * @param starttakt Der Starttakt in Millisekunden
         */
        void StartTaktSetzen(int starttakt);
        
        /**
         * Startet das Spiel.
         */
        void StartAusführen();
    }
    /** Anzeigegröße für eine Rasterkachel */
    private static final int rasterGröße = 40;
    /** Höhe des Anzeigefensters */
    private static final int höheFenster = rasterGröße * 20;
    /** Breite des Anzeigefensters */
    private static final int breiteFenster = rasterGröße * 26;
    private static Oberflaeche o = new Oberflaeche();
    private JFrame fenster;
    /** Eingabefeld für die Startgeschwindigkeit */
    private JTextField eingabe;
    /** Referenz auf das zu steuernde Objekt.*/
    private Steuerung s;

    /**
     * Baut die Bedienoberfläche auf
     */
    private Oberflaeche()
    {
        fenster = new JFrame("Snake");
        fenster.setResizable(false);
        fenster.setVisible(true);
        fenster.setLayout(null);
        fenster.getContentPane().setBackground(new Color(240, 240, 240));
        Insets i = fenster.getInsets();
        int hoeheGesamt = höheFenster + i.top + 70;         // Ausgleich für Fenstertitel, Platz für Knöpfe
        fenster.setSize(breiteFenster, hoeheGesamt);
        fenster.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
        JComponent hintergrund = new JComponent()
        {
             /**
             * Zeichnet das Hintergrundmuster.
             */
            public void paintComponent(Graphics g)
            {
                g.setColor(Color.lightGray);
                for (int i = 1; i <= höheFenster / (rasterGröße * 2); i++)
                {
                    g.drawLine(0, höheFenster / 2 + i * rasterGröße, breiteFenster - 1, höheFenster / 2 + i * rasterGröße);
                    g.drawLine(0, höheFenster / 2 - i * rasterGröße, breiteFenster - 1, höheFenster / 2 - i * rasterGröße);
                }
                for (int i = 1; i <= breiteFenster / (rasterGröße * 2); i++)
                {
                    g.drawLine(breiteFenster / 2 + i * rasterGröße, 0, breiteFenster / 2 + i * rasterGröße, höheFenster - 1);
                    g.drawLine(breiteFenster / 2 - i * rasterGröße, 0, breiteFenster / 2 - i * rasterGröße, höheFenster - 1);
                }
                g.setColor(Color.black);
                g.drawLine(0, höheFenster / 2, breiteFenster - 1, höheFenster / 2);
                g.drawLine(breiteFenster / 2, 0, breiteFenster / 2, höheFenster - 1);
            }
        };
        hintergrund.setVisible(true);
        hintergrund.setSize(breiteFenster, höheFenster);
        hintergrund.setLocation(0, 0);
        fenster.add(hintergrund);
        JLabel l = new JLabel();
        l.setText("Starttakt in Millisekunden:");
        l.setLocation(20, hoeheGesamt - 65);
        l.setVisible(true);
        l.setSize(180, 20);
        fenster.add(l);
        eingabe = new JTextField();
        eingabe.setLocation(200, hoeheGesamt - 65);
        eingabe.setText("500");
        eingabe.setVisible(true);
        eingabe.setSize(80, 20);
        eingabe.setEnabled(true);
        fenster.add(eingabe);
        JButton buttonTakt = new JButton();
        buttonTakt.setLocation(300, hoeheGesamt - 70);
        buttonTakt.setText("Setzen");
        buttonTakt.setVisible(true);
        buttonTakt.setSize(80, 30);
        buttonTakt.setEnabled(true);
        buttonTakt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try
                {
                    int zeit = Integer.parseInt(eingabe.getText());
                    s.StartTaktSetzen(zeit);
                }
                catch (Exception ex)
                {
                    (Toolkit.getDefaultToolkit()).beep();
                }
            }
        });
        fenster.add(buttonTakt);
        JButton buttonStart = new JButton();
        buttonStart.setLocation(breiteFenster - 120, hoeheGesamt - 70);
        buttonStart.setText("Starten");
        buttonStart.setVisible(true);
        buttonStart.setSize(100, 30);
        buttonStart.setEnabled(true);
        buttonStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l.setEnabled(false);
                eingabe.setEnabled(false);
                buttonTakt.setEnabled(false);
                buttonStart.setEnabled(false);
                fenster.requestFocusInWindow();
                s.StartAusführen();
            }
        });
        fenster.add(buttonStart);
    }
    
    /**
     * Setzt das zu steuernde Objekt.
     * @param s das zu steuernde Objekt
     */
    void SteuerungSetzen(Steuerung s)
    {
        this.s = s;
    }

    /**
     * Gibt die Oberfläche zurück und erzeugt sie gegebenenfalls.
     * @return Ausgabefenster
     */
    static Oberflaeche OberflächeGeben()
    {
        return o;
    }

    /**
     * Gibt das Ausgabefenster zurück und erzeugt es gegebenenfalls.
     * @return Ausgabefenster
     */
    static JFrame FensterGeben()
    {
        return o.fenster;
    }

    /**
     * Gibt die Rastergröße zurück.
     * @return Ausgabefenster
     */
    static int RasterGrößeGeben()
    {
        return rasterGröße;
    }

    /**
     * Gibt die Breite des Fensters zurück.
     * @return Fensterbreite
     */
    static int FensterBreiteGeben()
    {
        return breiteFenster;
    }

    /**
     * Gibt die Höhe des Fensters zurück.
     * @return Fensterhöhe
     */
    static int FensterHöheGeben()
    {
        return höheFenster;
    }
}
