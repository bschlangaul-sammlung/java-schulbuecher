package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_02.thema_05.aufgabe_06.teilaufgabe_e.buchstabenhaeufigkeit;

/**
 * Klasse ermöglicht eine Analyse der absoluten Häufigkeiten von Zeichen in
 * einem Text
 *
 * @author Peter Brichzin
 *
 * @version 30.5.24
 */
class Haeufigkeitsanalyse
{
    private BinBaum textzeichen;

    private Dateileser dateileser;

    /**
     * Konstruktor für Objekte der Klasse Häufigkeitsanalyse
     */
    Haeufigkeitsanalyse()
    {
        textzeichen = new BinBaum();
        dateileser = null;
    }

    /**
     * Analysiere der absoluten Häufigkeiten von Zeichen in einen Text und
     * Ausgabe auf der Konsole
     *
     * @param text zu analysierender Text
     */
    void TextAnalysieren(String text)
    {
        for (int i = 0; i < text.length(); i = i + 1)
        {
            textzeichen.Einfügen(new Textzeichen(text.charAt(i)));
        }
        textzeichen.InorderAusgeben();
    }

    /**
     * Analysiere der absoluten Häufigkeiten von Zeichen in einen Text und
     * Ausgabe auf der Konsole OHNE Leer- und Satzzeichen
     *
     * @param text zu analysierender Text
     */
    void TextAnalysieren2(String text)
    {
        String angepassterText;
        // Groß und Kleinschreibung ignorieren
        angepassterText = text.toLowerCase();
        // Leerzeichen ignorieren
        angepassterText = angepassterText.replace(" ", "");
        // Satzzeichen ignorieren
        angepassterText = angepassterText.replace(",", "");
        angepassterText = angepassterText.replace(".", "");
        angepassterText = angepassterText.replace(";", "");
        angepassterText = angepassterText.replace(":", "");
        angepassterText = angepassterText.replace("?", "");
        angepassterText = angepassterText.replace("!", "");
        angepassterText = angepassterText.replace("-", "");
        angepassterText = angepassterText.replace("“", "");
        angepassterText = angepassterText.replace("”", "");
        angepassterText = angepassterText.replace("«", "");
        angepassterText = angepassterText.replace("»", "");

        for (int i = 0; i < angepassterText.length(); i = i + 1)
        {
            textzeichen.Einfügen(new Textzeichen(angepassterText.charAt(i)));
        }
        textzeichen.InorderAusgeben();
    }

    /**
     * Analysiere der absoluten Häufigkeiten von Zeichen in einen Text, der aus
     * einer Datei eingelesen wird, und Ausgabe des Ergebnisses auf der Konsole.
     *
     * @param dateiname Dateiname
     */
    void TextEinlesenUndAnalysieren(String dateiname)
    {
        dateileser = new Dateileser(dateiname);
        TextAnalysieren(dateileser.TextAuslesen());
    }

    /**
     * Analysiere der absoluten Häufigkeiten von Zeichen OHNE Leer- und
     * Satzzeichen in einen Text, der aus einer Datei eingelesen wird, und
     * Ausgabe des Ergebnisses auf der Konsole.
     *
     * @param dateiname Dateiname
     */
    void TextEinlesenUndAnalysieren2(String dateiname)
    {
        dateileser = new Dateileser(dateiname);
        TextAnalysieren2(dateileser.TextAuslesen());
    }
}
