/**
 * Tiefensuche mit Adjazenzlisten
 *
 * <p>
 * Gibt es in einem Graphen viele Knoten, aber nur relativ wenige Kanten, so
 * äußert sich das in Form von vielen „leeren“ Zellen in der Adjazenzmatrix. Bei
 * der Speicherung des Graphen mit Hilfe einer Adjazenzmatrix wird in diesen
 * Fällen sehr viel Speicherplatz verschwendet.
 * </p>
 *
 * <p>
 * Eine Möglichkeit, mit dieser Situation speichersparend umzugehen, ist die
 * Verwendung sogenannter Adjazenzlisten. Hier wird bei jedem Knoten ein Feld
 * mit den von diesem Knoten ausgehenden Kanten gespeichert; als Kantenattribute
 * sind in diesem Fall nur das Gewicht der Kanten und eine Referenz auf deren
 * Zielknoten nötig.
 * </p>
 *
 * <ol>
 * <li>a In den Klassen KNOTEN, KANTE und GRAPH_LISTE sind bereits die
 * grundlegenden Attribute und Methoden zum Einlesen und Aufbauen des Graphen
 * vorhanden. Vergleichen Sie diese Implementierung mit der bisher verwendeten
 * Implementierung in GRAPH_MATRIX. Geben Sie an, inwieweit vergleichbare
 * Methoden einfacher oder komplexer geworden sind.</li>
 *
 * <li>b Implementieren Sie nun den Rumpf der Methode KnotenBesuchen. Testen Sie
 * mit den vorhandenen Graphen.</li>
 *
 * <li>c Vergleichen Sie die neue Implementierung der Methode KnotenBesuchen mit
 * der bisherigen Implementierung. Geben Sie begründet an, welche
 * Implementierung Sie für besser halten.</li>
 * </ol>
 */
package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_03.aufgabe_08;
