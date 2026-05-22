/**
 * Der Handelsreisende („traveling salesman”)
 *
 * <p>
 * Eine weitere „klassische” Backtracking-Aufgabe neben dem Rucksackproblem ist
 * das Problem des Handelsreisenden. Von seinem Büro aufbrechend muss er alle
 * seine Kundinnen und Kunden besuchen. Anschließend muss er wieder zurück in
 * das Büro. Der Weg soll möglichst kurz sein. Dabei ist es nicht zu vermeiden,
 * dass manche Orte doppelt (oder öfter) besucht werden. Um diese sehr lästige
 * Komplikation vom Programm fernzuhalten, trägt man Wege zwischen allen Orten
 * ein. Für den Algorithmus ist nur wichtig, dass z. B. die Entfernung von
 * München nach Würzburg 167 km ist. Ob dieser Weg über Nürnberg oder Ulm führt,
 * ist für das Ergebnis (und für den Vertreter) nicht wesentlich.
 * </p>
 *
 * <ol>
 * <li>a Implementieren Sie die Methoden TiefensucheAusführen und KnotenBesuchen
 * so, dass zu dem gegebenen Wegenetz und einem angebbaren Startknoten (Ort für
 * das Büro) der optimale Routenplan bestimmt wird.</li>
 *
 * <li>b Für Schnelle: Wenn ein Vertreter seinen Bezirk neu aufbaut, kann er
 * sich den Ort für das Büro wählen. Erweitern Sie Ihre Lösung von Teilaufgabe
 * a) so, dass der beste Ort für das Büro berechnet wird.</li>
 * </ol>
 */
package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_04.aufgabe_07;
