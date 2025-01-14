package org.bschlangaul.schulbuecher.isb.handreichung_10_2008.konzept_01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class ZEICHENFENSTER - Eine Klasse, die einfache grafische Zeichnungen in
 * einem Programmfenster ermöglicht.
 *
 * @author Michael Kolling (mik)
 * @author Bruce Quig
 * @author Christian Heidrich
 *
 * @version 2007.05.07
 */
public class ZeichenFenster
{
    private JFrame frame;

    private CanvasPane canvas;

    private JPanel steuerungOst, steuerungSued;

    private Graphics2D graphic;

    private Color backgroundColor;

    private Image canvasImage;

    private static ZeichenFenster singleton;

    /**
     * Erzeugt eine Zeichenfenster mit Standardmaßen 600*500 und
     * Hintergrundfarbe weiß
     *
     * @param titel Titel des Fensters
     */
    public ZeichenFenster(String titel)
    {
        this(titel, 600, 500, Color.white);
    }

    /**
     * Erzeugt ein Zeichenfenster mit weißem Hintergrund.
     *
     * @param titel Fensterueberschirft
     * @param breite Breite des Fensters
     * @param hoehe Hoehe des Fensters
     */
    public ZeichenFenster(String titel, int breite, int hoehe)
    {
        this(titel, breite, hoehe, Color.white);
    }

    /**
     * Erzeugt ein Zeichenfenster.
     *
     * @param titel Fensterueberschirft
     * @param breite Breite des Fensters
     * @param hoehe Hoehe des Fensters
     * @param hintergrundFarbe Hintergrundfarbe des Zeichenfensters
     */
    private ZeichenFenster(String titel, int breite, int hoehe,
            Color hintergrundFarbe)
    {
        frame = new JFrame();
        canvas = new CanvasPane();
        canvas.setPreferredSize(new Dimension(breite, hoehe));
        frame.getContentPane().add(canvas, BorderLayout.CENTER);
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        steuerungOst = new JPanel();
        steuerungSued = new JPanel();
        steuerungOst.setLayout(new BoxLayout(steuerungOst, BoxLayout.Y_AXIS));
        steuerungSued.setLayout(new BoxLayout(steuerungSued, BoxLayout.X_AXIS));
        p1.add(steuerungOst, BorderLayout.NORTH);
        frame.getContentPane().add(p1, BorderLayout.EAST);
        frame.getContentPane().add(steuerungSued, BorderLayout.SOUTH);
        frame.setTitle(titel);
        backgroundColor = hintergrundFarbe;
        frame.pack();
        zeige();
    }

    public static ZeichenFenster gibFenster()
    {
        if (singleton == null)
        {
            singleton = new ZeichenFenster("Das Zeichenfenster");
        }
        singleton.zeige();
        return singleton;
    }

    /**
     * Macht das Zeichenfenster sichtbar bzw. setzt es in den Vordergrund, falls
     * es bereits sichtbar ist.
     */
    public void zeige()
    {
        if (graphic == null)
        {
            // nur beim ersten Aufruf wird der Hintergrund mit der
            // Hintergrundfarbe
            // gefuellt
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D) canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(true);
    }

    /**
     * Gibt Information über die Sichtbarkeit.
     *
     * @return true falls das Fenster sichtbar ist.
     */
    public boolean istSichtbar()
    {
        return frame.isVisible();
    }

    /**
     * Zeichnet einen Elipsenbogen (Siehe Graphics.drawArc)
     *
     * @param x x-Koordinate des Elipsenmittelpunkts
     * @param y y-Koordinate des Elipsenmittelpunkts
     * @param halbachseX Halbachse der Elipse in x-Richtung
     * @param halbachseY Halbachse der Elipse in y-Richtung
     * @param startWinkel Polarwinkel, an dem der Bogen anfängt
     * @param winkel Polarwinkel, welchen der Bogen durchläuft
     */
    public void zeichneBogen(int x, int y, int halbachseX, int halbachseY,
            int startWinkel, int winkel)
    {
        graphic.drawArc(x - halbachseX, y - halbachseY, 2 * halbachseX,
                2 * halbachseY, startWinkel, winkel);
        canvas.repaint();
    }

    /**
     * Zeichnet einen Kreis (Siehe Graphics.drawOval)
     *
     * @param x x-Koordinate des Mittelpunkts
     * @param y y-Koordinate des Mittelpunkts
     * @param radius Kreisradius
     */
    public void zeichneKreis(int x, int y, int radius)
    {
        graphic.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
        canvas.repaint();
    }

    /**
     * Füllt das Innere eines Kreises mit der angegebenen Farbe.
     *
     * @param x x-Koordinate des Mittelpunkts
     * @param y y-Koordinate des Mittelpunkts
     * @param radius Kreisradius
     * @param farbe Füllfarbe für den Kreis, erlaubt sind "weiss" "schwarz"
     *     "rot" "gruen" "blau" "gelb" "magenta" "cyan" "grau"
     */
    public void fuelleKreis(int x, int y, int radius, String farbe)
    {
        Color original = graphic.getColor();
        graphic.setColor(farbeZuColor(farbe));
        graphic.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * Füllt das Innere eines Kreises mit der angegebenen Farbe.
     *
     * @param x x-Koordinate des Mittelpunkts
     * @param y y-Koordinate des Mittelpunkts
     * @param radius Kreisradius
     * @param farbnr Füllfarbnummer für den Kreis (0 bis 8)
     */
    public void fuelleKreis(int x, int y, int radius, int farbnr)
    {
        Color original = graphic.getColor();
        graphic.setColor(farbeZuColor(farbnr));
        graphic.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * Löscht das Innere eines Kreises
     *
     * @param x x-Koordinate des Mittelpunkts
     * @param y y-Koordinate des Mittelpunkts
     * @param radius Kreisradius
     */
    public void loescheKreis(int x, int y, int radius)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(x - radius, y - radius,
                2 * radius, 2 * radius);
        loesche(circle);
    }

    /**
     * Zeichnet den Umriss eines Shape-Objekts.
     *
     * @param shape das Shape-Object, welches gezeichnet werden soll
     */
    public void zeichne(Shape shape)
    {
        graphic.draw(shape);
        canvas.repaint();
    }

    /**
     * Füllt das Innere eines Shape-Objekts mit der angegebenen Farbe.
     *
     * @param shape das Shape-Objekt, welches gefüllt werden soll
     * @param farbe Füllfarbe für das Shape-Objekt, erlaubt sind "weiss"
     *     "schwarz" "rot" "gruen" "blau" "gelb" "magenta" "cyan" "grau"
     */
    public void fuelle(Shape shape, String farbe)
    {
        Color original = graphic.getColor();
        graphic.setColor(farbeZuColor(farbe));
        graphic.fill(shape);
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * Füllt das Innere eines Shape-Objekts mit der angegebenen Farbe.
     *
     * @param shape das Shape-Objekt, welches gefüllt werden soll
     * @param farbnr Füllfarbnummer für das Shape-Objekt (0 bis 8)
     */
    public void fuelle(Shape shape, int farbnr)
    {
        Color original = graphic.getColor();
        graphic.setColor(farbeZuColor(farbnr));
        graphic.fill(shape);
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * Löscht das Innere eines Shape-Objekts.
     *
     * @param shape das Shape-Object, welches gelöscht werden soll
     */
    public void loesche(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.fill(shape); // erase by filling background color
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Zeichnet den Rand des Rechtecks mit der aktuellen Farbe.
     *
     * @param xPos,yPos Koordinaten der linken oberen Ecke
     * @param breite, hoehe Breite und Höhe des Rechtecks
     */
    public void zeichneRechteck(int xPos, int yPos, int breite, int hoehe)
    {
        graphic.drawRect(xPos, yPos, breite, hoehe);
        canvas.repaint();
        // fill(new Rectangle(xPos, yPos, breite, hoehe));
    }

    /**
     * Füllt das Innere des Rechtecks mit der angegebenen Farbe.
     *
     * @param xPos,yPos Koordinaten der linken oberen Ecke
     * @param breite, hoehe Breite und Höhe des Rechtecks
     * @param farbe Füllfarbe für das Rechteck, erlaubt sind "weiss" "schwarz"
     *     "rot" "gruen" "blau" "gelb" "magenta" "cyan" "grau"
     */
    public void fuelleRechteck(int xPos, int yPos, int breite, int hoehe,
            String farbe)
    {
        Color original = graphic.getColor();
        graphic.setColor(farbeZuColor(farbe));
        graphic.fillRect(xPos, yPos, breite, hoehe);
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * Füllt das Innere des Rechtecks mit der angegebenen Farbe.
     *
     * @param xPos,yPos Koordinaten der linken oberen Ecke
     * @param breite, hoehe Breite und Höhe des Rechtecks
     * @param farbnr Füllfarbnummer für das Rechteck (0 bis 8)
     */
    public void fuelleRechteck(int xPos, int yPos, int breite, int hoehe,
            int farbnr)
    {
        Color original = graphic.getColor();
        graphic.setColor(farbeZuColor(farbnr));
        graphic.fillRect(xPos, yPos, breite, hoehe);
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * Löscht das Innere eines Rechtecks.
     *
     * @param xPos,yPos Koordinaten der linken oberen Ecke
     * @param breite, hoehe Breite und Höhe des Rechtecks
     */
    public void loescheRechteck(int xPos, int yPos, int breite, int hoehe)
    {
        loesche(new Rectangle(xPos, yPos, breite, hoehe));
    }

    private Polygon gibDreieck(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        Polygon p = new Polygon();
        p.addPoint(x1, y1);
        p.addPoint(x2, y3);
        p.addPoint(x3, y3);
        return p;
    }

    /**
     * Zeichnet den Rand eines Dreiecks mit der aktuellen Farbe.
     *
     * @param x1,y1 Koordinaten des ersten Eckpunkts
     * @param x2,y2 Koordinaten des zweiten Eckpunkts
     * @param x3,y3 Koordinaten des dritten Eckpunkts
     */
    public void zeichneDreieck(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        graphic.drawPolygon(gibDreieck(x1, y1, x2, y2, x3, y3));
        canvas.repaint();
    }

    /**
     * Füllt das Innere eines Dreiecks mit der angegebenen Farbe.
     *
     * @param x1,y1 Koordinaten des ersten Eckpunkts
     * @param x2,y2 Koordinaten des zweiten Eckpunkts
     * @param x3,y3 Koordinaten des dritten Eckpunkts
     * @param farbe Füllfarbe für das Dreieck, erlaubt sind "weiss" "schwarz"
     *     "rot" "gruen" "blau" "gelb" "magenta" "cyan" "grau"
     */
    public void fuelleDreieck(int x1, int y1, int x2, int y2, int x3, int y3,
            String farbe)
    {
        Color original = graphic.getColor();
        graphic.setColor(farbeZuColor(farbe));
        graphic.fillPolygon(gibDreieck(x1, y1, x2, y2, x3, y3));
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * Füllt das Innere eines Dreiecks mit der angegebenen Farbe.
     *
     * @param x1,y1 Koordinaten des ersten Eckpunkts
     * @param x2,y2 Koordinaten des zweiten Eckpunkts
     * @param x3,y3 Koordinaten des dritten Eckpunkts
     * @param farbnr Füllfarbnummer für das Dreieck (0 bis 8)
     */
    public void fuelleDreieck(int x1, int y1, int x2, int y2, int x3, int y3,
            int farbnr)
    {
        Color original = graphic.getColor();
        graphic.setColor(farbeZuColor(farbnr));
        graphic.fillPolygon(gibDreieck(x1, y1, x2, y2, x3, y3));
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * Löscht das Innere eines Dreicks
     *
     * @param x1,y1 Koordinaten des ersten Eckpunkts
     * @param x2,y2 Koordinaten des zweiten Eckpunkts
     * @param x3,y3 Koordinaten des dritten Eckpunkts
     */
    public void loescheDreieck(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        loesche(gibDreieck(x1, y1, x2, y2, x3, y3));
    }

    /**
     * Löscht den Inhalt des Zeichenfensters.
     */
    public void loescheAlles()
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Löscht den Umriss eines Shape-Objekts.
     *
     * @param shape das Shape-Object, dessen Umriss gelöscht werden soll
     */
    public void loescheRand(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.draw(shape); // Löschen durch übermalen mit Hintergrundfarbe
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Zeichnet ein Bild in das Zeichnenfenster .
     *
     * @param bild das anzuzeigende Bild
     * @param x x-Koordinate des linken Bildrands
     * @param y y-Koordinate des oberen Bildrands
     *
     * @return gibt eines booleschen Wert zurück, der angibt, ob das Bild
     *     vollständig geladen werden konnte
     */
    public boolean zeichneBild(Image bild, int x, int y)
    {
        boolean result = graphic.drawImage(bild, x, y, null);
        canvas.repaint();
        return result;
    }

    /**
     * Zeichnet einen Text.
     *
     * @param text die anzuzeigende Zeichenkette
     * @param x x-Koordinate des linken Rands
     * @param y y-Koordinate des oberen Rands
     */
    public void zeichneText(String text, int x, int y)
    {
        graphic.drawString(text, x, y);
        canvas.repaint();
    }

    /**
     * Löscht einen Text vom Zeichenfenster.
     *
     * @param text die zu löschende Zeichenkette
     * @param x x-Koordinate des linken Rands
     * @param y y-Koordinate des oberen Rands
     */
    public void loescheText(String text, int x, int y)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.drawString(text, x, y);
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Zeichnet eine Strecke ins Zeichenfenster.
     *
     * @param x1 x-Koordinate des Anfangspunkts der Strecke
     * @param y1 y-Koordinate des Anfangspunkts der Strecke
     * @param x2 x-Koordinate des Endpunkts der Strecke
     * @param y2 y-Koordinate des Endpunkts der Strecke
     */
    public void zeichneStrecke(int x1, int y1, int x2, int y2)
    {
        graphic.drawLine(x1, y1, x2, y2);
        canvas.repaint();
    }

    /**
     * Setzt die Vordergrundfarbe des Zeichenfensters.
     *
     * @param neueFarbe neue Vordergrundfarbe
     */
    public void setzeVordergrundFarbe(String neueFarbe)
    {
        graphic.setColor(farbeZuColor(neueFarbe));
    }

    private Color farbeZuColor(int farbnr)
    {
        switch (farbnr)
        {
        case 0:
            return Color.black;

        case 1:
            return Color.blue;

        case 2:
            return Color.green;

        case 3:
            return Color.cyan;

        case 4:
            return Color.red;

        case 5:
            return Color.magenta;

        case 6:
            return Color.yellow;

        case 7:
            return Color.gray;

        case 8:
            return Color.white;

        default:
            return graphic.getColor();
        }
    }

    private Color farbeZuColor(String farbe)
    {
        if (farbe == "weiss")
            return Color.white;
        if (farbe == "schwarz")
            return Color.black;
        if (farbe == "rot")
            return Color.red;
        if (farbe == "gruen")
            return Color.green;
        if (farbe == "blau")
            return Color.blue;
        if (farbe == "gelb")
            return Color.yellow;
        if (farbe == "magenta")
            return Color.magenta;
        if (farbe == "cyan")
            return Color.cyan;
        if (farbe == "grau")
            return Color.gray;
        return graphic.getColor();
    }

    private String colorZuFarbe(Color color)
    {
        if (color == Color.white)
            return "weiss";
        if (color == Color.black)
            return "schwarz";
        if (color == Color.red)
            return "rot";
        if (color == Color.green)
            return "gruen";
        if (color == Color.blue)
            return "blau";
        if (color == Color.yellow)
            return "gelb";
        if (color == Color.magenta)
            return "magenta";
        if (color == Color.cyan)
            return "cyan";
        if (color == Color.gray)
            return "gruen";
        return "";
    }

    /**
     * Gibt die aktuelle Vordergrundfarbe des Zeichenfensters zurück.
     *
     * @return die aktuelle Vordergrundfarbe
     */
    public String gibVordergrundFarbe()
    {
        return colorZuFarbe(graphic.getColor());
    }

    /**
     * Setzt die Hintergrundfarbe des Zeichenfensters.
     *
     * @param neueFarbe neue Hintergrundfarbe
     */
    public void setzeHintergrundFarbe(String neueFarbe)
    {
        backgroundColor = farbeZuColor(neueFarbe);
        graphic.setBackground(backgroundColor);
    }

    /**
     * Gibt die aktuelle Hintergrundfarbe des Zeichenfensters zurück.
     *
     * @return die aktuelle Hintergrundfarbe
     */
    public String gibHintergrundFarbe()
    {
        return colorZuFarbe(backgroundColor);
    }

    /**
     * Ändert den aktuellen Zeichensatz des Zeichenfensters.
     *
     * @param neuerZeichensatz Zeichensatz, der künftig für
     *     Zeichenkettenausgaben verwendet wird
     */
    public void setzeZeichensatz(Font neuerZeichensatz)
    {
        graphic.setFont(neuerZeichensatz);
    }

    /**
     * Gibt den aktuellen Zeichensatz des Zeichenfensters zurück.
     *
     * @return den aktuellen Zeichensatz
     **/
    public Font gibZeichensatz()
    {
        return graphic.getFont();
    }

    /**
     * Ändert die Abmessungen des Zeichenfensters.
     *
     * @param breite neue Breite
     * @param hoehe neue Höhe
     */
    public void setzeMasse(int breite, int hoehe)
    {
        canvas.setPreferredSize(new Dimension(breite, hoehe));
        Image oldImage = canvasImage;
        canvasImage = canvas.createImage(breite, hoehe);
        graphic = (Graphics2D) canvasImage.getGraphics();
        graphic.drawImage(oldImage, 0, 0, null);
        frame.pack();
    }

    /**
     * Gibt die Abmessungen des Zeichenfensters zurück.
     *
     * @return die aktuellen Abmessungen des Zeichenfensters
     */
    public Dimension gibMasse()
    {
        return canvas.getSize();
    }

    /**
     * Wartet eine bestimmte Zeit. Eine kurze Verzögerung kann z. B. für
     * Animationen verwendet werden.
     *
     * @param zeit Wartezeit in Millisekunden
     */
    public void warte(int zeit)
    {
        try
        {
            Thread.sleep(zeit);
        }
        catch (InterruptedException e)
        {
            // ignoring exception at the moment
        }
    }

    /**
     * Fügt ein weiteres Steuerungselement in die rechte Steuerungsleiste ein.
     *
     * @param element Das einzufügende Steuerungselement muss aus JComponent
     *     abgeleitet sein. z. B. JButton, JComboBox.
     */
    public void komponenteHinzufuegen(JComponent element, String position)
    {
        if (position == "rechts")
            steuerungOst.add(element);
        else if (position == "unten")
            steuerungSued.add(element);
        frame.pack();
    }

    /**
     * Beschriftet den Titel des Zeichenfensters neu.
     *
     * @param titelNeu Text der neuen Fensterüberschrift
     */
    public void setzeTitel(String titelNeu)
    {
        frame.setTitle(titelNeu);
    }

    /************************************************************************
     * Nested class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class CanvasPane extends JPanel
    {
        private static final long serialVersionUID = 20060330L;

        public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
}
