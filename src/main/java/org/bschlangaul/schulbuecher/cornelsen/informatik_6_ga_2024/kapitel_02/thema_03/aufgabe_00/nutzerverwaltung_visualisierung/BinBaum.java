package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_02.thema_03.aufgabe_00.nutzerverwaltung_visualisierung;

/**
 * Die Klasse Binbaum ist die Grundstruktur eines geordneten Binärbaums und hier
 * zur Verwaltung von Usern eingesetzt wird. Die Methoden die ein Objekt dieser
 * Klasse anbietet, leiten den Aufruf an den Wurzelknoten weiter, wenn der Baum
 * nicht leer ist. (Implementierung ohne Entwurfsmuster Kompositum)
 *
 * @author Peter Brichzin
 *
 * @version 24.5.24
 */
class BinBaum
{
    /**
     * Die Wurzel des Baums
     */
    private Knoten wurzel;

    /**
     * Konstruktor für Objekte der Klasse Binbaum: Ein leerer Baum wird erzeugt.
     */
    BinBaum()
    {
        wurzel = null;
    }

    /**
     * Fügt ein Datenelement sortiert in den geordneten Binärbaum ein, d.h. die
     * Eigenschaft, dass der Baum geordnet ist bleibt bei jedem Einfügevorgang
     * erhalten.
     *
     * @param datenNeu neues Datenelement
     */
    void Einfügen(User datenNeu)
    {
        if (wurzel != null)
        {
            wurzel.Einfügen(datenNeu);
        }
        else
        {
            wurzel = new Knoten(datenNeu);
        }

        // Visualisierung des Baums
        BaumZeichnen();
    }

    /**
     * Zeichnet den Baum
     */
    void BaumZeichnen()
    {
        int höhenschritt = Zeichenfenster.MalflächenHöheGeben()
                / (HöheGeben() + 2); // +2 statt +1, damit unten ein Rand bleibt
        int breite = Zeichenfenster.MalflächenBreiteGeben();

        int maxAnzahlKnotenUntersteEbene = (int) Math.pow(2, HöheGeben());
        int dx = breite / (maxAnzahlKnotenUntersteEbene + 1); // +1, damit
                                                              // rechts und
                                                              // links ein Rand
                                                              // bleibt

        wurzel.KnotenZeichnen(0, breite, 25, höhenschritt, null); // y= 20 für
                                                                  // die 0te
                                                                  // Ebene,
                                                                  // damit der
                                                                  // Knoten
                                                                  // sichtbar
                                                                  // ist
    }

    /**
     * Berechnet die Höhe des Baums und gibt diesen Wert zurück
     *
     * @return Höhe des Baums
     */
    int HöheGeben()
    {
        return wurzel.HöheGeben(0);
    }

    public static void main(String[] args)
    {
        User user1 = new User(5781, "Geber", "Ann");
        User user2 = new User(4221, "Tross", "Albert");
        User user3 = new User(6345, "Fall", "Klara");
        User user4 = new User(5799, "Ter", "Lee");
        User user5 = new User(6300, "Sehr", "Kai");
        User user6 = new User(5888, "Pfahl", "Marta");
        BinBaum binBaum1 = new BinBaum();
        binBaum1.Einfügen(user1);
        binBaum1.Einfügen(user2);
        binBaum1.Einfügen(user3);
        binBaum1.Einfügen(user4);
        binBaum1.Einfügen(user5);

        binBaum1.Einfügen(user6);

        binBaum1.BaumZeichnen();

    }
}
