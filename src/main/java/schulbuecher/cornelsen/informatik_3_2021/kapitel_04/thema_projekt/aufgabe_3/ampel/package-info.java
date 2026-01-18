/**
 * Ampel (4.2, 4.3, 4.4, 4.5)
 *
 * <p>
 * In dieser Aufgabe kannst du eine Ampelsimulation erstellen, in der es
 * zusätzlich möglich ist, die Ampelphasen mit den Pfeiltasten zu steuern.
 * </p>
 *
 * <ul>
 * <li>a Erzeuge in deiner Entwicklungsumgebung ein Objekt der Klasse AMPEL und
 * erkunde seine Methoden.</li>
 *
 * <li>b Benenne die dargestellten Ampelphasen und ordne sie in die richtige
 * Reihenfolge.</li>
 *
 * <li>c Schreibe eine Unterklasse von AMPEL und erstelle darin die Methode
 * rot(), welche das rote Licht einschaltet und die beiden anderen ausschaltet.
 * Erstelle zu den weiteren drei Ampelphasen auch je eine Methode, in welcher
 * jeweils der Zustand aller drei Lichter festgelegt wird. Schreibe auch eine
 * Methode zum Ausschalten aller Lichter. Teste deine Methoden.</li>
 *
 * <li>d Entwickle eine Methode ampeldurchlaufsimulieren(), welche die
 * bisherigen Methoden und die Methode warte(double sekunden) nutzt, um den
 * einmaligen Durchlauf einer Ampel mit den entsprechenden Wartezeiten zu
 * simulieren.</li>
 *
 * <li>e Nun soll die Ampel auf Eingaben der Computertastatur reagieren. Dafür
 * gibt es eine geerbte Methode. Lies dir ihre Dokumentation mit den Mitteln
 * deiner Entwicklungs- umgebung durch. Erstelle ein Objekt vom Typ der
 * Unterklasse und sorge durch einen Klick in die Kopfzeile des Grafikfensters
 * dafür, dass dieses den Fokus für Tastatureingaben bekommt. Drücke
 * anschließend beliebige Tasten und beobachte die ausgegebenen Zahlen. Halte
 * schriftlich fest, welche Nummern den vier Pfeiltasten zugeordnet werden.</li>
 *
 * <li>f Überschreibe nun in deiner Klasse die Methode tasteReagieren(int
 * tastencode). Achte dabei darauf, dass du den Methodenkopf exakt aus der
 * Oberklasse übernimmst. Mit den Pfeiltasten soll die Ampel in nebenstehende
 * Phasen geschaltet werden können. Setze den passenden Algorithmus um. Tipp:
 * Verwende eine geeignete Form der bedingten Anweisung.</li>
 *
 * <li>g Erstelle eine Methode einschalten(), welche mit einer
 * „Endloswiederholung” (wiederhole solange(WAHR)) endlos die Methode
 * ampeldurchlaufSimulieren aufruft. Finde heraus, wie du die Ampel wieder
 * ausschalten kannst.</li>
 * </ul>
 */
package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_projekt.aufgabe_3.ampel;
