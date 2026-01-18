package schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittenes_formular;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;

import javax.swing.JLabel;

/**
 * Diese Klasse implementiert einen einfachen Text. Die Schriftart und die
 * Groesse des Textes kann veraendert werden.
 *
 * @author Florian Prager, Universität Passau
 *
 * @version 02.2008
 */
public class Text extends Formulargrafik
{
    private String originalInhalt;

    private String schriftart;

    private int groesse = 12;

    private Color farbe = Color.black;

    public Text()
    {
        super();
        schriftart = null;
        originalInhalt = "Hier steht Text.";
        MeinLabel l = new MeinLabel("Hier steht Text.");
        l.setBackground(Color.white);
        awtKomponenteSetzen(l);
    }

    public Text(Formular formular)
    {
        super(formular);
        schriftart = null;
        originalInhalt = "Hier steht Text.";
        MeinLabel l = new MeinLabel("Hier steht Text.");
        l.setBackground(Color.white);
        awtKomponenteSetzen(l);
    }

    public Text(String text)
    {
        if (text == null)
            text = "Hier steht Text.";
        schriftart = null;
        originalInhalt = text;
        MeinLabel l = new MeinLabel(text);
        l.setBackground(Color.white);
        awtKomponenteSetzen(l);
    }

    public Text(String text, Formular formular)
    {
        super(formular);
        if (text == null)
            text = "Hier steht Text.";
        schriftart = null;
        originalInhalt = text;
        MeinLabel l = new MeinLabel(text);
        l.setBackground(Color.white);
        awtKomponenteSetzen(l);
    }

    /**
     * Liefert den Text.
     *
     * @return der Text
     */
    public String inhaltGeben()
    {
        return originalInhalt;
    }

    /**
     * Aendert den Text.
     *
     * @param inhalt der neue Text
     */
    public void inhaltSetzen(String inhalt)
    {
        if (inhalt == null)
            inhalt = "";
        originalInhalt = inhalt;
        formularGeben().formularAktualisieren();
    }

    /**
     * Aendert die Farbe des Textes nach der RGB-Tabelle. Es sind Werte zwischen
     * 0 und 255 moeglich. Groessere Angaben werden auf 255 gesetzt. Negative
     * Angaben werden auf 0 gesetzt.
     */
    public void farbeSetzen(int rot, int gruen, int blau)
    {
        if (rot > 255)
            rot = 255;
        if (gruen > 255)
            gruen = 255;
        if (blau > 255)
            blau = 255;
        if (rot < 0)
            rot = 0;
        if (gruen < 0)
            gruen = 0;
        if (blau < 0)
            blau = 0;
        farbe = new Color(rot, gruen, blau);
        formularGeben().formularAktualisieren();
    }

    /**
     * Die Farbe des Textes kann gewaehlt werden. Mögliche Farben sind: "weiss",
     * "gelb", "orange", "rot", "pink", "magenta", "cyan", "gruen", "blau",
     * "grau", "schwarz" Achtung: Die Anfuehrungsstriche sind noetig! Alle
     * anderen Eingabewerte werden ignoriert.
     */
    public void farbeSetzen(String neueFarbe)
    {
        Color color = farbeAufloesen(neueFarbe);
        if (color != null)
        {
            farbe = color;
            formularGeben().formularAktualisieren();
        }
    }

    /**
     * Uebersetzt den String in ein Colorobjekt, falls moeglich. Ansonsten wird
     * null zurueckgegeben.
     */
    private Color farbeAufloesen(String farbe)
    {
        if (farbe.equals("rot"))
        {
            return Color.RED;
        }
        else if (farbe.equals("blau"))
        {
            return Color.BLUE;
        }
        else if (farbe.equals("gelb"))
        {
            return Color.YELLOW;
        }
        else if (farbe.equals("gruen"))
        {
            return Color.GREEN;
        }
        else if (farbe.equals("grau"))
        {
            return Color.GRAY;
        }
        else if (farbe.equals("schwarz"))
        {
            return Color.BLACK;
        }
        else if (farbe.equals("weiss"))
        {
            return Color.WHITE;
        }
        else if (farbe.equals("pink"))
        {
            return Color.PINK;
        }
        else if (farbe.equals("orange"))
        {
            return Color.ORANGE;
        }
        else if (farbe.equals("magenta"))
        {
            return Color.MAGENTA;
        }
        else if (farbe.equals("cyan"))
        {
            return Color.CYAN;
        } // bei ungueltiger Eingabe:
        return null;
    }

    /**
     * Aendert die Schriftart des Textes, wenn moeglich.
     *
     * @param name die neue Schriftart (bspw. "Arial")
     */
    public void schriftartSetzen(String name)
    {
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();
        for (int i = 0; i < fonts.length; i++)
        {
            if (fonts[i].equals(name))
            {
                schriftart = name;
                formularGeben().formularAktualisieren();
                return;
            }
        }
    }

    /**
     * Aendert die Groesse des Textes, wenn moeglich.
     *
     * @param groesse die neue Groesse
     */
    public void groesseSetzen(int groesse)
    {
        if (groesse < 1)
            this.groesse = 1;
        else if (groesse > 35)
            this.groesse = 35;
        else
            this.groesse = groesse;
        formularGeben().formularAktualisieren();
    }

    /**
     * Liefert die aktuelle Groesse des Textes.
     *
     * @return die Groesse.
     */
    public int groesseGeben()
    {
        return groesse;
    }

    /**
     * Liefert eine Liste der verfuegbaren Schriftarten auf dem aktuellen
     * System.
     *
     * @return die Liste
     */
    public String[] schriftartenGeben()
    {
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();
        return fonts;
        // String ergebnis = "";
        // if (fonts == null)
        // return ergebnis;
        // for (int i = 0; i < fonts.length; i++) {
        // if (i == fonts.length - 1)
        // ergebnis += fonts[i];
        // else
        // ergebnis += fonts[i] + "\n";
        // }
        // return ergebnis;
    }

    /**
     * Liefert die Schriftart des Textes.
     *
     * @return die Schriftart
     */
    public String schriftartGeben()
    {
        return schriftart;
    }

    /**
     * Wird vom Formular aufgerufen.
     */
    void formatieren()
    {
        char[] textArray = originalInhalt.toCharArray();
        String neu = "";
        for (int i = 0; i < textArray.length; i++)
        {
            neu += textArray[i];
        }
        String[] textAbschnitte = spalten(neu);
        MeinLabel l = new MeinLabel("");
        for (int i = 0; i < textAbschnitte.length; i++)
        {
            if (i == textAbschnitte.length - 1)
                textAnhaengen(textAbschnitte[i], l);
            else
            {
                textAnhaengen(textAbschnitte[i], l);
                l.setText(l.getText() + "<br>");
            }
        }
        l.setBackground(Color.white);
        awtKomponenteSetzen(l);
    }

    private String[] spalten(String text)
    {
        String kleinText = text.toLowerCase();
        String[] kleinTextArray = kleinText.split("<br>");
        String[] ergebnis = new String[kleinTextArray.length];
        for (int i = 0; i < kleinTextArray.length; i++)
        {
            int anfangsIndex = anfangsIndexBerechnen(kleinTextArray, i);
            ergebnis[i] = text.substring(anfangsIndex,
                    anfangsIndex + kleinTextArray[i].length());
        }
        return ergebnis;
    }

    private int anfangsIndexBerechnen(String[] array, int abschnitt)
    {
        if (abschnitt >= array.length || abschnitt < 0)
            return -1;
        int zaehler = 0;
        for (int i = 0; i < abschnitt; i++)
        {
            zaehler += array[i].length() + 4;
        }
        return zaehler;
    }

    synchronized private void textAnhaengen(String text, JLabel gesamtLabel)
    {
        // toDo: etwas aufraeumen! text nicht als lokale Variable missbrauchen.
        // auskommentiertes loeschen
        Font font = null;
        if (schriftart == null)
            schriftart = geeigneteFontFamilieSuchen();
        font = new Font(schriftart, Font.PLAIN, groesse);
        MeinLabel label = new MeinLabel(text);
        label.setFont(font);
        label.setText(text);
        int textbreite = label.getFontMetrics(font)
                .stringWidth(label.getText());
        int texthoehe = label.getFontMetrics(font).getHeight();
        char[] textArray = text.toCharArray();
        if (textbreite >= formularGeben().breiteGeben())
        {
            // textbreite = 0;
            int aktuellerStartindex = 0;
            text = "";
            String zeilenString = null;
            int letztesZeilenende = 0;
            for (int i = 0; i < textArray.length; i++)
            {
                zeilenString = stringExtrahieren(textArray, aktuellerStartindex,
                        i);
                int zeilenbreite = label.getFontMetrics(font)
                        .stringWidth(zeilenString);
                if (zeilenbreite >= formularGeben().breiteGeben())
                {
                    int zeilenende = i - 1;
                    if (textArray[i] != ' ')
                    {
                        zeilenende = zurueckVerfolgen(textArray, i,
                                letztesZeilenende + 1) - 1;
                    }
                    letztesZeilenende = zeilenende;
                    // int testbreite = label.getFontMetrics(font).stringWidth(
                    // stringExtrahieren(textArray, aktuellerStartindex,
                    // zeilenende));
                    // if (testbreite > textbreite)
                    // textbreite = testbreite;
                    text += stringExtrahieren(textArray, aktuellerStartindex,
                            zeilenende) + "<br>";
                    if (textArray[zeilenende + 1] == ' ')
                    {
                        aktuellerStartindex = zeilenende + 2;
                    }
                    else
                    {
                        aktuellerStartindex = zeilenende + 1;
                    }
                    i = aktuellerStartindex;
                    texthoehe += label.getFontMetrics(font).getHeight();
                    zeilenString = null;
                }
            }
            if (zeilenString != null)
            {
                text += zeilenString;
                if (hatZentrierungsProblem(text, zeilenString))
                    texthoehe += label.getFontMetrics(font).getHeight();
            }
        }
        label.setSize(formularGeben().breiteGeben(), texthoehe);
        label.setText(text);
        gesamtLabel.setFont(label.getFont());
        gesamtLabel.setText(gesamtLabel.getText() + label.getText());
        if (gesamtLabel.getWidth() < label.getWidth())
            gesamtLabel.setSize(label.getWidth(),
                    gesamtLabel.getHeight() + label.getHeight());
        else
            gesamtLabel.setSize(gesamtLabel.getWidth(),
                    gesamtLabel.getHeight() + label.getHeight());
    }

    private boolean hatZentrierungsProblem(String text, String zeile)
    {
        if (text == null || text.isEmpty())
            return false;
        if (text.length() <= zeile.length())
            return false;
        char[] ta = text.substring(0, text.length() - zeile.length() - 4)
                .toCharArray();
        for (int i = ta.length - 1; i >= 3; i--)
        {
            if (ta[i] == '>' && ta[i - 1] == 'r' && ta[i - 2] == 'b'
                    && ta[i - 3] == '>')
                return zeile.length() > text.substring(i + 1, ta.length)
                        .length();
        }
        return zeile.length() > text.substring(0, ta.length).length();
    }

    private String stringExtrahieren(char[] textArray, int startIndex,
            int endIndex)
    {
        if (endIndex >= textArray.length || startIndex > textArray.length
                || endIndex < 0 || startIndex < 0 || startIndex > endIndex)
            return null;
        else
        {
            String text = "";
            for (int i = startIndex; i <= endIndex; i++)
            {
                text += textArray[i];
            }
            return text;
        }
    }

    synchronized private int zurueckVerfolgen(char[] textArray, int index,
            int letztesZeilenende)
    {
        int i = index;
        while (textArray[i] != ' ' && i > letztesZeilenende)
        {
            i--;
        }
        if (i == letztesZeilenende)
        {
            return index;
        }
        return i;
    }

    private String geeigneteFontFamilieSuchen()
    {
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();
        String font = fonts[0];
        for (int i = 0; i < fonts.length; i++)
        {
            Font testFont = new Font(fonts[i], Font.PLAIN, groesse);
            int texthoehe = new MeinLabel("").getFontMetrics(testFont)
                    .getHeight();
            if (fonts[i].equals("Arial") || fonts[i].equals("Helvetica"))
                return fonts[i];
            if (testFont.canDisplay('\u00E4') && testFont.canDisplay('\u00F6')
                    && testFont.canDisplay('ü') && testFont.canDisplay('\u00C4')
                    && testFont.canDisplay('\u00D6')
                    && testFont.canDisplay('\u00DC')
                    && testFont.canDisplay('\u00DF') && testFont.canDisplay('?')
                    && testFont.canDisplay('!') && testFont.canDisplay('-')
                    && testFont.canDisplay(',') && testFont.canDisplay(';')
                    && testFont.canDisplay('.') && testFont.canDisplay('(')
                    && testFont.canDisplay(')') && testFont.isPlain()
                    && texthoehe > 15 && texthoehe < 25)
            {
                font = fonts[i];
            }
        }
        return font;
    }

    private class MeinLabel extends JLabel
    {
        private static final long serialVersionUID = 1L;

        private String text;

        public MeinLabel(String text)
        {
            this.text = text;
        }

        public void paint(Graphics g)
        {
            g.setColor(farbe);
            zeichnen(g, text);
        }

        public void setText(String text)
        {
            this.text = text;
        }

        public String getText()
        {
            return text;
        }

        private void zeichnen(Graphics g, String text)
        {
            String[] textArray = text.split("<br>");
            int hoehe = getFontMetrics(getFont()).getHeight();
            int y = getFont().getSize();
            for (int i = 0; i < textArray.length; i++)
            {
                int breite = getFontMetrics(getFont())
                        .stringWidth(textArray[i]);
                g.drawString(textArray[i], getWidth() / 2 - breite / 2, y);
                y += hoehe;
            }
        }
    }
}
