package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_02.thema_05.aufgabe_06.teilaufgabe_a.buchstabenhaeufigkeit;

/**
 * Klasse ermöglicht eine Häufigkeitsanalyse von Buchstaben in einem Text
 *
 * @author Peter Brichzin
 *
 * @version 30.5.24
 */
class Haeufigkeitsanalyse
{
    private BinBaum textzeichen;

    /**
     * Konstruktor für Objekte der Klasse Häufigkeitsanalyse
     */
    Haeufigkeitsanalyse()
    {
        textzeichen = new BinBaum();
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
}
