/**
 * Ball animieren (ab 4.6)
 *
 * <p>
 * Manchmal ist es wünschenswert, dass gewisse Aufgaben automatisch oder
 * regelmäßig erle- digt werden. Solche Mechanismen erbt man in der Regel von
 * einer Oberklasse und über- schreibt sie in einer entsprechenden Methode.
 * </p>
 *
 * <ul>
 * <li>a Erzeuge in deiner Entwicklungsumgebung ein Objekt der Klasse BALL.
 * Erkunde die Methoden starteTickerNeu(double sekunden) und stoppeTicker().
 * Achte dabei darauf, dass du alle Fenster deines Programms im Blick hast.
 * Halte die Wirkung der Methoden schriftlich fest. Notiere auch die Bedeutung
 * des Parameterwerts.</li>
 *
 * <li>b Schreibe eine Unterklasse von BALL. Erstelle einen Konstruktor, dem man
 * die Farbe des Balls übergeben kann. Die Farbe wird einfach an den
 * Oberklassenkonstruktor weitergegeben. Der Konstruktor soll auch gleich das
 * Tickersystem starten. Überschreibe die Methode tick, so dass bei jedem Aufruf
 * von tick der Ball mit der Methode bewegen bewegt wird. Überprüfe das Ergebnis
 * deiner Arbeit. Experimentiere mit dem Wert des Tickerintervalls im Rumpf
 * deines Konstruktors bis der Ball das Grafikfenster zügig verlässt.</li>
 *
 * <li>c Der Ball soll so animiert werden, dass er an den Rändern des
 * Grafikfensters reflektiert wird. Das untenstehende Struktogramm zeigt, wie
 * dies in der Methode tick für die rechte und linke Wand umgesetzt werden kann.
 * Analysiert den angegebenen Algorithmus zu zweit. Erklärt euch dazu
 * gegenseitig alle vorkommenden Methodenaufrufe. Setzt das Struktogramm
 * anschließend in Quelltext um und ergänzt auch die Reflexion an der oberen und
 * unteren Wand.</li>
 * </ul>
 */
package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_projekt.aufgabe_4.ball_animiert;
