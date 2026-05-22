/**
 * Das gegebene Projekt sucht den Weg von einem Ort zu einem anderen.
 * <ol>
 * <li>a Erzeugen Sie ein Objekt der Klasse WEGE und rufen Sie die Methode
 * ReiseStarten1 mit Startknoten „M” und Zielknoten „N” auf. Wenn ein Weg
 * gefunden ist, halt das Programm an und macht nach Tastendruck weiter. Lassen
 * Sie sich alle gefundenen Wege anzeigen und notieren Sie dabei, welcher Weg
 * optimal wäre und warum.</li>
 * <li>b Wiederholen Sie Aufgabe a) mit einem anderen Paar von Start- und
 * Zielknoten.</li>
 * <li>c Stellen Sie eine Vermutung auf, wie der Algorithmus der Tiefensuche
 * modifiziert worden sein könnte, damit er alle möglichen Wege anzeigt und
 * nicht mehr nur alle Knoten besucht. Nennen Sie auch eine mögliche
 * Abbruchbedingung der Rekursion. Öffnen Sie den Quellcode der Methode
 * KnotenBesuchen1 in der Klasse GRAPH_MATRIX und vergleichen Sie Ihre Vermutung
 * mit der Implementierung.</li>
 * <li>d Skizzieren Sie eine Strategie, um aus allen Lösungen des Algorithmus
 * von KnotenBesuchen 1 den optimalen Weg herauszufinden und am Ende zu
 * zeigen.</li>
 * <li>e Verwenden Sie nun die Methode ReiseStarten2, lassen Sie sich den Weg
 * für die Knotenpaare aus a) bzw. b) anzeigen und verifizieren Sie, dass diese
 * Wege wirklich optimal sind.</li>
 * <li>f Betrachten Sie nun den Quellcode von KnotenBesuchen2 der Klasse
 * GRAPH_MATRIX. Geben Sie an, nach welcher Strategie die optimale Lösung
 * gefunden wurde und ob diese Strategie mit Ihrer Strategie aus Aufgabe c)
 * übereinstimmt.</li>
 * <li>g Für Schnelle: Ändern Sie die Reihenfolge beim Untersuchen der Knoten
 * (z. B. von hinten her). Geben Sie an, ob und wenn ja wie diese Änderung die
 * jeweils gefundene Lösung beeinflusst.</li>
 * </ol>
 */
package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_04.aufgabe_00.kurze_wege;
