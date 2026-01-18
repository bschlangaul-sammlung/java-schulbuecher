package schulbuecher.cornelsen.shared.graphen_aufbau_tool;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

/**
 * Die Klasse stellt ein Fenster mit einer Malfläche für den Graphen zur
 * Verfügung.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Oberflaeche
{
    /**
     * Fenster für die Zeichenfläche.
     */
    private JFrame fenster;

    /**
     * Die eigentliche Darstellungskomponente.
     */
    private Zeichenflaeche malfläche;

    /**
     * Der Empfänger für die Oberflächenereignisse
     */
    private EreignisEmpfaenger empfänger;

    /**
     * Die Menüzeile für das Fenser
     */
    private JMenuBar menüZeile;

    /**
     * Das Dateimenü.
     */
    private JMenu dateiMenü;

    /**
     * Das Bearbeiten-Menü.
     */
    private JMenu bearbeitenMenü;

    /**
     * Das Werkzeugmenü.
     */
    private JMenu werkzeugMenü;

    /**
     * Menüpunkt Fenster schließen.
     */
    private JMenuItem schließenItem;

    /**
     * Menüpunkt Datei sichern.
     */
    private JMenuItem sichernItem;

    /**
     * Menüpunkt Datei sichern unter.
     */
    private JMenuItem sichernUnterItem;

    /**
     * Menüpunkt Knoten löschen.
     */
    private JMenuItem knotenLöschen;

    /**
     * Menüpunkt Knoten editieren.
     */
    private JMenuItem knotenEditieren;

    /**
     * Menüpunkt Kante löschen.
     */
    private JMenuItem kanteLöschen;

    /**
     * Menüpunkt Kante editieren.
     */
    private JMenuItem kanteEditieren;

    /**
     * Daten des aktiven Knoten
     */
    private String[] aktiverKnotenDaten;

    /**
     * Der Dialog zum editieren der Knoten.
     */
    private KnotenDialog knotenDialog;

    /**
     * Daten der aktiven Kante
     */
    private String[] aktiveKanteDaten;

    /**
     * Der Dialog zum editieren der Knoten.
     */
    private KantenDialog kantenDialog;

    /**
     * Der zuletzt verwendete Ordner für Sicherungsdateien.
     */
    private File letzterOrdner;

    /**
     * Die aktuelle Datei.
     */
    private File aktuelleDatei;

    /**
     * Dialog zun Sichern und Öffnen einer Graphendatei.
     */
    private JFileChooser öffnenDialog;

    /**
     * Popupmenü zum Editieren und Löschen selektierter Knoten
     */
    private JPopupMenu knotenPopup;

    /**
     * Popupmenü zum Editieren und Löschen selektierter Kanten
     */
    private JPopupMenu kantenPopup;

    /**
     * Zeitstempel des letzten Mouse-Down
     */
    private long klickZeit;

    /**
     * Legt die Oberflächenelemente an
     */
    Oberflaeche()
    {
        letzterOrdner = null;
        aktuelleDatei = null;
        öffnenDialog = null;
        aktiverKnotenDaten = null;
        aktiveKanteDaten = null;
        empfänger = null;
        klickZeit = 0;
        fenster = new JFrame("Graphenaufbau");
        fenster.setLocation(50, 50);
        fenster.setSize(800, 600);
        fenster.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); // Close-Button
                                                                               // kann
                                                                               // nicht
                                                                               // versteckt
                                                                               // oder
                                                                               // abgestellt
                                                                               // werden.
        malfläche = new Zeichenflaeche();
        malfläche.setOpaque(true);
        malfläche.addMouseListener(new MouseAdapter()
        {
            /**
             * Gibt den Ort eines Mausklicks an die eigentliche Aktionsmethode
             * weiter.
             *
             * @param e das zugestellte Ereignis
             */
            public void mousePressed(MouseEvent e)
            {
                klickZeit = e.getWhen();
                malfläche.requestFocus();
                empfänger.MausGedrückt(e.getX(), e.getY(),
                        e.getButton() == MouseEvent.BUTTON3, e.isControlDown(),
                        e.isShiftDown(), e.isAltDown());
            }

            /**
             * Gibt den Ort eines Mouseclicks an die eigentliche Aktionsmethode
             * weiter.
             *
             * @param e das zugestellte Ereignis
             */
            public void mouseReleased(MouseEvent e)
            {
                empfänger.MausLosgelassen(e.getX(), e.getY(),
                        e.getButton() == MouseEvent.BUTTON3, e.isControlDown(),
                        e.isShiftDown(), e.isAltDown());
            }

            /**
             * Gibt den Ort eines Mouseclicks an die eigentliche Aktionsmethode
             * weiter.
             *
             * @param e das zugestellte Ereignis
             */
            public void mouseClicked(MouseEvent e)
            {
                empfänger.MausGeklickt(e.getX(), e.getY(), e.getClickCount(),
                        e.getButton() == MouseEvent.BUTTON3, e.isControlDown(),
                        e.isShiftDown(), e.isAltDown());
            }
        });
        malfläche.addMouseMotionListener(new MouseMotionAdapter()
        {
            /**
             * Gibt den Ort der gezogenen Maus an die eigentliche Aktionsmethode
             * weiter.
             *
             * @param e das zugestellte Ereignis
             */
            public void mouseDragged(MouseEvent e)
            {
                if (e.getWhen() >= klickZeit + 500)
                {
                    empfänger.MausGezogen(e.getX(), e.getY());
                }
            }
        });
        fenster.add(malfläche, BorderLayout.CENTER);
        MenüsAnlegen();
        fenster.setVisible(true);
        knotenDialog = new KnotenDialog(fenster);
        kantenDialog = new KantenDialog(fenster);
        FileChooserErstellen();
    }

    /**
     * Legt die Menüs an.
     */
    private void MenüsAnlegen()
    {
        int kommando = 0;
        boolean isMac = System.getProperty("os.name", "").startsWith("Mac");
        if (isMac)
        {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            kommando = InputEvent.META_DOWN_MASK;
        }
        else
        {
            kommando = InputEvent.CTRL_DOWN_MASK;
        }
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            // Dann lassen wirs eben
        }
        JMenuItem item;
        menüZeile = new JMenuBar();
        dateiMenü = new JMenu("Ablage");
        menüZeile.add(dateiMenü);
        item = new JMenuItem("Neu", KeyEvent.VK_N);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, kommando));
        item.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (!empfänger.IstGeändert() || (JOptionPane.showConfirmDialog(
                        fenster, "Ungesicherte Änderungen verwerfen?",
                        "Achtung",
                        JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION))
                {
                    aktuelleDatei = null;
                    fenster.setTitle("Graphenaufbau");
                    empfänger.ZurückSetzen();
                }
            }
        });
        dateiMenü.add(item);
        item = new JMenuItem("Öffnen …", KeyEvent.VK_O);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, kommando));
        item.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (!empfänger.IstGeändert() || (JOptionPane.showConfirmDialog(
                        fenster, "Ungesicherte Änderungen verwerfen?",
                        "Achtung",
                        JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION))
                {
                    DateiLesen();
                }
            }
        });
        dateiMenü.add(item);
        dateiMenü.addSeparator();
        schließenItem = new JMenuItem("Schließen", KeyEvent.VK_W);
        schließenItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_W, kommando));
        schließenItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (!empfänger.IstGeändert() || (JOptionPane.showConfirmDialog(
                        fenster, "Ungesicherte Änderungen verwerfen?",
                        "Achtung",
                        JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION))
                {
                    aktuelleDatei = null;
                    fenster.setTitle("Graphenaufbau");
                    empfänger.ZurückSetzen();
                }
            }
        });
        dateiMenü.add(schließenItem);
        sichernItem = new JMenuItem("Sichern", KeyEvent.VK_S);
        sichernItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, kommando));
        sichernItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                SichernAusführen(false);
            }
        });
        dateiMenü.add(sichernItem);
        sichernUnterItem = new JMenuItem("Sichern unter …");
        sichernUnterItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                kommando + InputEvent.SHIFT_DOWN_MASK));
        sichernUnterItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                SichernAusführen(true);
            }
        });
        dateiMenü.add(sichernUnterItem);
        dateiMenü.addSeparator();
        item = new JMenuItem("Beenden", KeyEvent.VK_Q);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, kommando));
        item.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (!empfänger.IstGeändert() || (JOptionPane.showConfirmDialog(
                        fenster, "Ungesicherte Änderungen verwerfen?",
                        "Achtung",
                        JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION))
                {
                    System.exit(0);
                }
            }
        });
        dateiMenü.add(item);

        bearbeitenMenü = new JMenu("Bearbeiten");
        menüZeile.add(bearbeitenMenü);
        item = new JMenuItem("Ausschneiden", KeyEvent.VK_X);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
                InputEvent.META_DOWN_MASK));
        item.setEnabled(false);
        bearbeitenMenü.add(item);
        item = new JMenuItem("Kopieren", KeyEvent.VK_C);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
                InputEvent.META_DOWN_MASK));
        item.setEnabled(false);
        bearbeitenMenü.add(item);
        item = new JMenuItem("Einfügen", KeyEvent.VK_V);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
                InputEvent.META_DOWN_MASK));
        item.setEnabled(false);
        bearbeitenMenü.add(item);
        item = new JMenuItem("Alles auswählen", KeyEvent.VK_A);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                InputEvent.META_DOWN_MASK));
        item.setEnabled(false);
        bearbeitenMenü.add(item);

        werkzeugMenü = new JMenu("Werkzeuge");
        menüZeile.add(werkzeugMenü);
        knotenLöschen = new JMenuItem("Knoten löschen", 0);
        knotenLöschen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                empfänger.KnotenLöschen();
            }
        });
        knotenLöschen.setEnabled(false);
        werkzeugMenü.add(knotenLöschen);
        knotenEditieren = new JMenuItem("Knoten editieren …", 0);
        knotenEditieren.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                knotenDialog.Anzeigen(aktiverKnotenDaten, empfänger);
            }
        });
        knotenEditieren.setEnabled(false);
        werkzeugMenü.add(knotenEditieren);
        kanteLöschen = new JMenuItem("Kante löschen", 0);
        kanteLöschen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                empfänger.KanteLöschen();
            }
        });
        kanteLöschen.setEnabled(false);
        werkzeugMenü.add(kanteLöschen);
        kanteEditieren = new JMenuItem("Kante editieren", 0);
        kanteEditieren.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kantenDialog.Anzeigen(aktiveKanteDaten, empfänger);
            }
        });
        kanteEditieren.setEnabled(false);
        werkzeugMenü.add(kanteEditieren);
        fenster.setJMenuBar(menüZeile);
        knotenPopup = new JPopupMenu();
        item = new JMenuItem("Knoten löschen", 0);
        item.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                empfänger.KnotenLöschen();
            }
        });
        item.setEnabled(true);
        knotenPopup.add(item);
        item = new JMenuItem("Knoten editieren …", 0);
        item.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                knotenDialog.Anzeigen(aktiverKnotenDaten, empfänger);
            }
        });
        item.setEnabled(true);
        knotenPopup.add(item);
        kantenPopup = new JPopupMenu();
        item = new JMenuItem("Kante löschen", 0);
        item.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                empfänger.KanteLöschen();
            }
        });
        item.setEnabled(true);
        kantenPopup.add(item);
        item = new JMenuItem("Kante editieren", 0);
        item.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kantenDialog.Anzeigen(aktiveKanteDaten, empfänger);
            }
        });
        kanteEditieren.setEnabled(true);
        kantenPopup.add(item);
    }

    /**
     * Erstellt die Dateidialoge für Öffnen und Sichern.
     */
    private void FileChooserErstellen()
    {
        öffnenDialog = new JFileChooser();
        öffnenDialog
                .addChoosableFileFilter(new javax.swing.filechooser.FileFilter()
                {
                    public boolean accept(File f)
                    {
                        String n = f.getName();
                        return (n.toLowerCase().endsWith(".grph"))
                                || f.isDirectory();
                    }

                    public String getDescription()
                    {
                        return ("Graphendatei");
                    }
                });
        javax.swing.filechooser.FileFilter dbFilter = new javax.swing.filechooser.FileFilter()
        {
            public boolean accept(File f)
            {
                String n = f.getName();
                return (n.toLowerCase().endsWith(".db"))
                        || (n.toLowerCase().endsWith(".grdb"))
                        || f.isDirectory();
            }

            public String getDescription()
            {
                return ("Graphendatenbank");
            }
        };
        öffnenDialog.addChoosableFileFilter(dbFilter);
        öffnenDialog.setFileFilter(dbFilter);
    }

    /**
     * Fragt ab, ob die Datei gesichert werden sollte.
     *
     * @param immer Der Sicherndialog wird immer aufgerufen (z. B. Sichern
     *     unter)
     */
    private void SichernAusführen(boolean immer)
    {
        if ((aktuelleDatei == null) || immer)
        {
            if (aktuelleDatei != null)
            {
                öffnenDialog.setSelectedFile(aktuelleDatei);
            }
            else
            {
                öffnenDialog.setCurrentDirectory(letzterOrdner);
            }

            int res = öffnenDialog.showSaveDialog(fenster);
            if (res == JFileChooser.APPROVE_OPTION)
            {
                aktuelleDatei = öffnenDialog.getSelectedFile();
                if (öffnenDialog.getFileFilter().getDescription()
                        .equals("Graphendatei"))
                {
                    if (!aktuelleDatei.getName().toLowerCase()
                            .endsWith(".grph"))
                    {
                        aktuelleDatei = new File(
                                aktuelleDatei.getPath() + ".grph");
                    }
                    letzterOrdner = aktuelleDatei;
                }
                else if (öffnenDialog.getFileFilter().getDescription()
                        .equals("Graphendatenbank"))
                {
                    if (!(aktuelleDatei.getName().toLowerCase()
                            .endsWith(".grdb")
                            || aktuelleDatei.getName().toLowerCase()
                                    .endsWith(".db")))
                    {
                        aktuelleDatei = new File(
                                aktuelleDatei.getPath() + ".grdb");
                    }
                    letzterOrdner = aktuelleDatei;
                }
                letzterOrdner = aktuelleDatei;
                empfänger.Sichern(aktuelleDatei);
                fenster.setTitle(aktuelleDatei.getName());
            }
        }
        else
        {
            empfänger.Sichern(aktuelleDatei);
        }
    }

    /**
     * Öffnet eine Datei und liest den Inhalt in das Fenster.
     */
    private void DateiLesen()
    {
        öffnenDialog.setCurrentDirectory(letzterOrdner);
        int res = öffnenDialog.showOpenDialog(fenster);
        if (res == JFileChooser.APPROVE_OPTION)
        {
            aktuelleDatei = öffnenDialog.getSelectedFile();
            if (empfänger.Lesen(aktuelleDatei))
            {
                letzterOrdner = aktuelleDatei;
                fenster.setTitle(aktuelleDatei.getName());
            }
            else
            {
                aktuelleDatei = null;
            }
        }
        else
        {
            aktuelleDatei = null;
        }
    }

    /**
     * Trägt den Empfänger für die Ereignisse ein.
     *
     * @param e der Ereignisempfänger
     */
    void EmpfängerAnmelden(EreignisEmpfaenger e)
    {
        empfänger = e;
    }

    /**
     * Trägt das angegebene Symbol in die Liste ein.
     *
     * @param symbol das einzutragende Symbol
     */
    void Eintragen(GraphenSymbol symbol)
    {
        malfläche.Eintragen(symbol);
    }

    /**
     * Entfernt das angegebene Symbol.
     *
     * @param symbol das zu entfernende Symbol
     */
    void Entfernen(GraphenSymbol symbol)
    {
        malfläche.Entfernen(symbol);
    }

    /**
     * Aktualisiert die Malfläche.
     */
    void Aktualisieren()
    {
        malfläche.repaint();
    }

    /**
     * Erlaubt, den angegebenen Knoten zu bearbeiten
     *
     * @param aktiverKnotenDaten die Daten des selektierten Knoten
     */
    void KnotenBearbeitenErmöglichen(String[] aktiverKnotenDaten)
    {
        knotenLöschen.setEnabled(true);
        knotenEditieren.setEnabled(true);
        this.aktiverKnotenDaten = aktiverKnotenDaten;
    }

    /**
     * Stoppt die Knotenbearbeitung
     */
    void KnotenBearbeitenStoppen()
    {
        knotenLöschen.setEnabled(false);
        knotenEditieren.setEnabled(false);
        aktiverKnotenDaten = null;
    }

    /**
     * Erlaubt, die angegebene Kante zu bearbeiten
     *
     * @param aktiveKanteDaten Daten der selektierten Kante
     */
    void KantenBearbeitenErmöglichen(String[] aktiveKanteDaten)
    {
        kanteLöschen.setEnabled(true);
        kanteEditieren.setEnabled(true);
        this.aktiveKanteDaten = aktiveKanteDaten;
    }

    /**
     * Stoppt die Kantenbearbeitung
     */
    void KantenBearbeitenStoppen()
    {
        kanteLöschen.setEnabled(false);
        kanteEditieren.setEnabled(false);
        aktiveKanteDaten = null;
    }

    /**
     * Zeigt das Popup-Menü für den gewälten Knoten
     *
     * @param x x-Koordinate des Mausklicks
     * @param y y-Koordinate des Mausklicks
     * @param aktiverKnotenDaten die Daten des selektierten Knoten
     */
    void KnotenPopupAnzeigen(int x, int y, String[] aktiverKnotenDaten)
    {
        knotenLöschen.setEnabled(true);
        knotenEditieren.setEnabled(true);
        this.aktiverKnotenDaten = aktiverKnotenDaten;
        knotenPopup.show(malfläche, x, y);
    }

    /**
     * Zeigt das Popup-Menü für den gewälten Kanten
     *
     * @param x x-Koordinate des Mausklicks
     * @param y y-Koordinate des Mausklicks
     * @param aktiveKanteDaten die Daten des selektierten Knoten
     */
    void KantenPopupAnzeigen(int x, int y, String[] aktiveKanteDaten)
    {
        kanteLöschen.setEnabled(true);
        kanteEditieren.setEnabled(true);
        this.aktiveKanteDaten = aktiveKanteDaten;
        kantenPopup.show(malfläche, x, y);
    }

    public static void main(String[] args)
    {
        new Oberflaeche();
    }
}
