package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.eierautomat;

/**
 * Besserer Eierautomat auf dem Lande
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class BessererEierautomat extends Eierautomat
{
    /**
     * Besetzt die Attribute vor.
     */
    BessererEierautomat()
    {
        super();
    }

    /**
     * Befüllen des Eierautomaten mit neuen Eierkartons
     */
    @Override
    synchronized void Befüllen()
    {
        // So lange der Automat noch Eierkartons enthält, muss mit dem Befüllen
        // gewartet werden.
        while (eierkartons.size() > 0)
        {
            try
            {
                wait(); // Der Thread wechselt in einen Wartezustand.
            }
            catch (InterruptedException e)
            {
            }
        }

        // Der leere Automat wird mit zehn neuen Kartons befüllt.
        for (int zähler = 0; zähler < 10; zähler++)
        {
            eierkartons.add(new Eierkarton());
            eierkartons.get(zähler).PositionSetzen(375, 205 + 20 * zähler);
        }

        // Der Zustand der Variable in der Wartebedingung hat sich verändert.
        // Ein wartender Thread wird benachrichtigt.
        notify();
    }

    /**
     * Holen eines Eierkartons aus dem Automaten
     *
     * @return Eierkarton oder null bei Fehlversuch
     */
    @Override
    synchronized Eierkarton EierHolen()
    {
        // solange eine bestimmte Bedingung gilt, müssen Abholer abwarten
        // --- HIER PROGRAMMCODE ERGÄNZEN
        // --- HINWEIS: Die Bedingung um die folgenden Anweisungen könnte dann
        // entfernt werden,
        // --- ebenso die Rückgabe der leeren Referenz.

        if (eierkartons.size() > 0)
        {
            // Ein Eierkarton wird aus dem Feld entfernt und seine Darstellung
            // aus dem Zeichenfenster
            Eierkarton gekaufterKarton = eierkartons.remove(0);
            gekaufterKarton.Entfernen();

            // Unter einer bestimmten Bedingung muss die Baeuerin informiert
            // werden
            // --- HIER PROGRAMMCODE ERGÄNZEN

            // Rueckgabe des gekauften Kartons
            return gekaufterKarton;
        }
        return null;
    }
}
