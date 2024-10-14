package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_01.aufgabe_05.snake_l1;

/**
 * Verwaltet ein Minuszeichen. Das Minuszeichen bremst die Geschwindigkeit der
 * Schlange für 100 Züge.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Minus extends SonderFeld
{
    /**
     * Legt ein Minussymbol an zufälliger, freier Stelle an.
     *
     * @param s das Spiel, in dem das Minussymbol erzeut werden soll.
     */
    Minus(Spiel s)
    {
        super(s);
        symbol = new MinusSymbol();
        ZufälligPositionieren();
    }

    /**
     * Führt die Aktion des Minusfelds aus
     */
    @Override
    void Aktion()
    {
        spiel.Bremsen();
        spiel.Entfernen(this);
        symbol.Entfernen();
    }
}
