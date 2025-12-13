package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittenes_formular;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingUtilities;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.werkzeuge.Fenster;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.werkzeuge.Notiz;

/**
 * Diese Klasse implementiert ein simples Formular, das die Positionierung, die
 * Skalierung und den Zeilenumbruch seiner Elemente vollautomatisch übernimmt.
 * Das Formular kann verschoben und skaliert werden. Durch Betaetigen der
 * Pfeiltasten kann alternativ zur Maus der Scrollbalken bedient werden.
 * Mögliche Elemente sind: Texte, Bilder, Eingabefelder. Die Elemente bekommen
 * entweder in ihrem Konstruktor ein selbst erzeugtes Formular uebergeben, oder
 * erhalten automatisch ein Objekt nach der Singleton-Idee geliefert. Alle
 * Elemente implementieren das Interface Formulargrafik und können mit der
 * Methode anzeigen() bzw. verstecken() auf das Formular gelegt bzw. davon
 * entfernt werden.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 05.2008
 */
public class Formular implements Fenster
{
    private int hoehe = 500;// 500

    private int breite = 300;// 300

    private static int offset = 0;

    /**
     * Hier wird gehalten, wieviele Formularfenster bisher erzeugt wurden. Es
     * wird nicht nach Standardfenster (Singleton) und Fenster unterschieden
     * sondern einfach durchgezaehlt.
     */
    private static int formularanzahl = 0;

    private final int komponentenabstand = 10;

    private final int minimalhoehe = 50;// 300

    private final int minimalbreite = 100;// 200

    private int aktuelleKomponentenhoehe = komponentenabstand;

    private static Formular formular;

    private JPanel panel;

    private JFrame frame;

    private JPanel hintergrundebene;

    private JScrollBar scrollleiste;

    private JMenu optionsmenue;

    private JMenuBar menueleiste;

    private LinkedList<Formulargrafik> komponentenliste;

    private LinkedList<Sensor> sensoren;

    /**
     * Liefert ein Formularobjekt nach der Singleton-Idee
     *
     * @return das Formularobjekt
     */
    public static Formular formularGeben()
    {
        if (formular == null)
            formular = new Formular(true);// true: Standardformular erzeugen
        return formular;
    }

    private Formular(boolean singleton)
    {
        formularErzeugen(breite, hoehe, singleton);
    }

    public Formular()
    {
        this(false);
    }

    public Formular(int neueBreite, int neueHoehe)
    {
        formularErzeugen(neueBreite, neueHoehe, false);
    }

    private void formularErzeugen(int neueBreite, int neueHoehe,
            boolean singleton)
    {
        komponentenliste = new LinkedList<Formulargrafik>();
        sensoren = new LinkedList<Sensor>();
        formularanzahl++;
        if (singleton)
        {
            frame = new JFrame("Standard-Formular");
        }
        else
        {
            frame = new JFrame("Formular" + " (" + formularanzahl + ")");
        }
        frame.setAlwaysOnTop(true);
        frame.setLayout(null);
        frame.setBounds(offset, offset, neueBreite + 20, neueHoehe);// 0,0
        offset = offset + 10;
        frame.setResizable(true);
        frame.setBackground(Color.white);
        frame.setMinimumSize(new Dimension(minimalbreite, minimalhoehe));
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // UH
        menueleiste = new JMenuBar();
        optionsmenue = new JMenu("");
        menueleiste.add(optionsmenue);
        frame.setJMenuBar(menueleiste);
        frame.getRootPane().setBackground(Color.red);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        panel.setBackground(Color.white);
        frame.add(panel);
        scrollleiste = new JScrollBar(JScrollBar.VERTICAL, 0, 1, 0, 1);
        scrollleiste.addAdjustmentListener(new MeinJustierungsHorcher());
        scrollleiste.setBounds(panel.getWidth() - 35, 0, 20,
                panel.getHeight() - 58);
        frame.addWindowListener(new MeinSchliessHorcher());
        frame.getRootPane()
                .addComponentListener(new MeinKomponentenHorcher(false));
        frame.addComponentListener(new MeinKomponentenHorcher(true));
        frame.addKeyListener(new MeinTastenHorcher());
        panel.setVisible(true);
        frame.setVisible(true);
        new OnTopThread().start();
    }

    public Component verknuepfungGeben()
    {
        return frame;
    }

    /**
     * Loescht alle Formularsensoren vom Formular.
     */
    public synchronized void formularsensorenLöschen()
    {
        sensoren.clear();
        formularAktualisieren();
    }

    /**
     * Liefert die Formulargrafik mit der gegebenen ID, falls moeglich. Null
     * sonst.
     *
     * @param id die zu suchende ID
     *
     * @return die Formulargrafik
     */
    synchronized Formulargrafik formulargrafikSuchen(int id)
    {
        for (Formulargrafik g : komponentenliste)
        {
            if (g.equals(id))
                return g;
        }
        return null;
    }

    /**
     * Loescht alle Formulargrafiken vom Formular.
     */
    public synchronized void formulargrafikenLöschen()
    {
        komponentenliste.clear();
        aktuelleKomponentenhoehe = komponentenabstand;
        formularAktualisieren();
    }

    /**
     * Liefert die nutzbare Breite des Formulars.
     *
     * @return die Breite
     */
    public int breiteGeben()
    {
        return breite;
    }

    /**
     * Liefert die nutzbare Hoehe des Formulars.
     *
     * @return die Hoehe
     */
    public int hoeheGeben()
    {
        return hoehe;
    }

    /**
     * Wird von Sensoren aufgerufen.
     */
    synchronized void menuepunktHinzufuegen(Sensor sensor)
    {
        if (sensor == null)
            return;
        if (sensoren.contains(sensor))
            return;
        sensoren.addLast(sensor);
        formularAktualisieren();
    }

    /**
     * Wird vom Formular aufgerufen.
     */
    synchronized void menuepunktEntfernen(Sensor sensor)
    {
        if (sensor == null)
            return;
        if (!sensoren.contains(sensor))
            return;
        sensoren.remove(sensor);
        formularAktualisieren();
    }

    /**
     * Wird vom Sensor aufgerufen.
     */
    synchronized boolean sensorenVorhanden()
    {
        return (sensoren.size() > 0);
    }

    /**
     * Wird vom Formular aufgerufen.
     */
    synchronized void formulargrafikEntfernen(Formulargrafik g)
    {
        if (g == null)
            return;
        int id = g.idGeben();
        if (komponentenliste.remove(new DummyGrafik(id)))
        {
            scrollleiste.setValue(0);
            formularAktualisieren();
        }
    }

    /**
     * Wird vom Formular aufgerufen.
     */
    synchronized void formulargrafikHinzufuegen(Formulargrafik k,
            boolean aktualisieren)
    {
        if (k == null)
            return;
        if (komponentenliste.contains(k))
            return;
        k.formatieren();
        scrollleiste.setValue(0);
        Component c = k.awtKomponenteGeben();
        if (c == null)
            return;
        c.setBounds(breite / 2 - (c.getWidth() / 2), aktuelleKomponentenhoehe,
                c.getWidth(), c.getHeight());
        k.urspruenglichePositionSichern();
        komponentenliste.addLast(k);
        aktuelleKomponentenhoehe += c.getHeight() + komponentenabstand;
        if (aktualisieren)
            formularAktualisieren();
    }

    /**
     * Wird vom Sensor aufgerufen.
     */
    void formularAktualisieren()
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                aktualisieren();
            }
        });
    }

    private synchronized void aktualisieren()
    {
        optionsmenue.removeAll();
        for (Sensor e : sensoren)
        {
            JMenuItem mpunkt = new JMenuItem(e.toString());
            optionsmenue.add(mpunkt);
            mpunkt.addActionListener(new MenueHorcher(e));
        }
        panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        breite = frame.getWidth() - 20;
        hoehe = frame.getHeight();
        int kompensator = komponentenErneuern();
        if (aktuelleKomponentenhoehe > hoehe - 58 - kompensator)
        {
            breite = frame.getWidth() - 40;
            komponentenErneuern();
            scrollleiste.setBounds(panel.getWidth() - 35, 0, 20,
                    panel.getHeight() - 58);
            scrollleiste.setMaximum(aktuelleKomponentenhoehe - hoehe + 50);
            scrollleiste.setVisible(true);
        }
        else
        {
            scrollleiste.setVisible(false);
        }
        panelZeichnen();
    }

    synchronized private int komponentenErneuern()
    {
        LinkedList<Formulargrafik> komponentenKopie = new LinkedList<Formulargrafik>();
        for (Formulargrafik g : komponentenliste)
        {
            komponentenKopie.addLast(g);
        }
        aktuelleKomponentenhoehe = komponentenabstand;
        komponentenliste.clear();
        for (Formulargrafik k : komponentenKopie)
        {
            formulargrafikHinzufuegen(k, false);
        }
        if (!komponentenKopie.isEmpty())
        {
            Formulargrafik letzte = komponentenKopie.getLast();
            if (letzte == null || !(letzte instanceof Text))
                return 0;
            else
            {
                Font f = ((Text) letzte).awtKomponenteGeben().getFont();
                return ((Text) letzte).awtKomponenteGeben().getFontMetrics(f)
                        .getHeight();
            }
        }
        return 0;
    }

    synchronized private void panelZeichnen()
    {
        panel.removeAll();
        for (Formulargrafik k : komponentenliste)
        {
            panel.add(k.awtKomponenteGeben());
        }
        panel.add(scrollleiste);
        panel.setVisible(true);
        frame.setVisible(true);
        frame.repaint();
    }

    synchronized private void scrollingVerarbeiten(int wert)
    {
        for (Formulargrafik k : komponentenliste)
        {
            int yPos = k.urspruenglicheYPosGeben() - wert;
            k.rahmenSetzen(k.xPositionGeben(), yPos, k.breiteGeben(),
                    k.hoeheGeben());
        }
    }

    /**
     * Wird vom Sensor aufgerufen.
     */
    void menueleisteAktualisieren()
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                leisteAktualisieren();
            }
        });
    }

    synchronized private void leisteAktualisieren()
    {
        menueleiste.removeAll();
        if (sensorenVorhanden())
        {
            optionsmenue = new JMenu("Ereignisse");
        }
        else
        {
            optionsmenue = new JMenu("");
        }
        menueleiste.add(optionsmenue);
        aktualisieren();
    }

    private class DummyGrafik extends Formulargrafik
    {
        private DummyGrafik(int id)
        {
            super(id);
        }

        void formatieren()
        {
        }
    }

    private class AktualisierungsThread extends Thread
    {
        public void run()
        {
            formularAktualisieren();
        }
    }

    private class AdjustmentThread extends Thread
    {
        private int value;

        public AdjustmentThread(int value)
        {
            this.value = value;
        }

        public void run()
        {
            frame.requestFocus();
            scrollingVerarbeiten(value);
        }
    }

    private class EingabeThread extends Thread
    {
        private Sensor sensor;

        public EingabeThread(Sensor aktuellerSensor)
        {
            sensor = aktuellerSensor;
        }

        public void run()
        {
            sensor.ausloesen();
        }
    }

    private class MeinTastenHorcher implements KeyListener
    {
        public void keyPressed(KeyEvent arg0)
        {
            if (arg0.getKeyCode() == 40 && scrollleiste.isVisible())
                scrollleiste.setValue(scrollleiste.getValue() + 10);
            if (arg0.getKeyCode() == 38 && scrollleiste.isVisible())
                scrollleiste.setValue(scrollleiste.getValue() - 10);
            if (arg0.getKeyCode() == 37 && scrollleiste.isVisible())
                scrollleiste.setValue(scrollleiste.getMinimum());
            if (arg0.getKeyCode() == 39 && scrollleiste.isVisible())
                scrollleiste.setValue(scrollleiste.getMaximum());
        }

        public void keyReleased(KeyEvent arg0)
        {
        }

        public void keyTyped(KeyEvent arg0)
        {
        }
    }

    private class MeinSchliessHorcher implements WindowListener
    {
        public void windowActivated(WindowEvent arg0)
        {
        }

        public void windowClosed(WindowEvent arg0)
        {
        }

        public void windowClosing(WindowEvent arg0)
        {
            Notiz meldung = new Notiz();// UH
            if (meldung.jaNeinAntwortLesen(
                    "Wenn Sie schliessen werden ALLE erzeugten "
                            + "Objekte entfernt.\n Beabsichtigen Sie dies?"))
            {
                System.exit(0);
            }
        }

        public void windowDeactivated(WindowEvent arg0)
        {
        }

        public void windowDeiconified(WindowEvent arg0)
        {
        }

        public void windowIconified(WindowEvent arg0)
        {
        }

        public void windowOpened(WindowEvent arg0)
        {
        }
    }

    private class MeinKomponentenHorcher implements ComponentListener
    {
        private boolean istFrameListener;

        public MeinKomponentenHorcher(boolean istFrameListener)
        {
            this.istFrameListener = istFrameListener;
            hintergrundebene = new JPanel();
            hintergrundebene.setBackground(Color.white);
            hintergrundebene.setBounds(0, 0,
                    Toolkit.getDefaultToolkit().getScreenSize().width,
                    Toolkit.getDefaultToolkit().getScreenSize().height);
            hintergrundebene.setLayout(null);
            JLabel groesseAendern = new JLabel(
                    "Fenster wird " + "beim Loslassen neu gezeichnet...");
            groesseAendern.setBounds(0, 0, hintergrundebene.getWidth(), 20);
            hintergrundebene.add(groesseAendern);
            hintergrundebene.setVisible(false);
            frame.add(hintergrundebene);
        }

        public void componentHidden(ComponentEvent arg0)
        {
        }

        public void componentMoved(ComponentEvent arg0)
        {
        }

        public void componentResized(ComponentEvent arg0)
        {
            if (istFrameListener)
            {
                hintergrundebene.setVisible(false);
                new AktualisierungsThread().start();
            }
            else
            {
                int bildschirmbreite = Toolkit.getDefaultToolkit()
                        .getScreenSize().width;
                int bildschirmhoehe = Toolkit.getDefaultToolkit()
                        .getScreenSize().height;
                if (frame.getWidth() >= bildschirmbreite
                        && frame.getHeight() >= bildschirmhoehe)
                {
                    hintergrundebene.setVisible(false);
                    new AktualisierungsThread().start();
                }
                else
                {
                    panel.setVisible(false);
                    hintergrundebene.setVisible(true);
                }
            }
        }

        public void componentShown(ComponentEvent arg0)
        {
        }
    }

    private class MeinJustierungsHorcher implements AdjustmentListener
    {
        public void adjustmentValueChanged(AdjustmentEvent e)
        {
            new AdjustmentThread(e.getValue()).start();
        }
    }

    private class MenueHorcher implements ActionListener
    {
        Sensor sensor;

        public MenueHorcher(Sensor aktuellerSensor)
        {
            sensor = aktuellerSensor;
        }

        public void actionPerformed(ActionEvent arg0)
        {
            frame.requestFocus();
            new EingabeThread(sensor).start();
        }
    }

    private class OnTopThread extends Thread
    {
        public void run()
        {
            frame.setAlwaysOnTop(true);
            try
            {
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
            }
            frame.setAlwaysOnTop(false);
        }
    }
}
