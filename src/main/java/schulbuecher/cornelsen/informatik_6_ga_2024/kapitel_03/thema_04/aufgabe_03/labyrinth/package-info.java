/**
 * Labyrinth (Teil 1)
 * <p>
 * Das Tiefensuche-Verfahren hilft, systematisch einen Weg aus einem Labyrinth
 * zu finden. Alle Kreuzungen und Verzweigungen werden als Knoten betrachtet,
 * ebenso die Enden der Sackgassen. Die Gänge sind die Kanten des Graphen.
 * </p>
 *
 * <ol>
 * <li>a Der griechischen Mythologie zufolge fand der Held Theseus mithilfe
 * eines langen Fadens, den ihm die Prinzessin Ariadne geschenkt hatte
 * (Ariadnefaden), den Weg aus dem Labyrinth, in dem sich das Monster Minotauros
 * befand. Beschreiben Sie, wie man, unter Verwendung eines langen, auf- und
 * abspulbaren Fadens, ein Labyrinth nach dem Tiefensuchverfahren ablaufen kann,
 * bis man den Ausgang erreicht hat. Nennen Sie eine mögliche Regel, wie man an
 * einer Verzweigungsstelle die möglichen Gänge für das Weitergehen auswählt.
 * Geben Sie auch an, woran Sie erkennen können, dass ein Knoten (eine
 * Verzweigungsstelle) schon besucht wurde.</li>
 * <li>b Ergänzen Sie den Rumpf der Methode KnotenBesuchen in Klasse
 * GRAPH_MATRIX gemäß der Strategie in Aufgabe 2. Fügen Sie zusätzlich beim
 * Eintritt in die Methode den aktuellen Knoten an das Feld weg an; bei einer
 * erfolglosen Suche (Rückkehr mit FALSCH) müssen Sie den Knoten wieder vom Weg
 * entfernen. Starten Sie die „Flucht“ nach den Anweisungen im Projekt.</li>
 * </ol>
 */
package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_04.aufgabe_03.labyrinth;
