/**
 * Bouncer (ab 4.1)
 *
 * <p>
 * In dieser Aufgabe lernst du erste Elemente der Game-Engine kennen. Am Ende
 * der Aufgabe wirst du einen „Bouncer” implementieren, also einen Ball, der
 * endlos nach unten fällt und vom Boden wieder abprallt. Die Teilaufgaben davor
 * helfen dir auf dem Weg dorthin.
 * </p>
 *
 * <ul>
 * <li>a Erzeuge ein Objekt der Klasse BODEN und betrachte das eingeblendete
 * Koordinatensystem. Gib die Koordinaten vom Mittelpunkt des Fensters an. Nenne
 * den Bereich fiir sinnvolle x- und y-Koordinaten.</li>
 *
 * <li>b Rufe nun geeignete Methoden deines Objekts auf und bringe es in eine
 * ahnliche Form wie in der Abbildung.</li>
 *
 * <li>c Erzeuge zusätzlich ein Objekt der Klasse BALL. Rufe die Methode
 * macheAktiv auf und beschreibe ihre Wirkung. Versuche den Ball mit einem
 * geeigneten Methodenaufruf zurück in das Grafikfenster zu holen.</li>
 *
 * <li>d Rufe nun die Methode machePassiv des Bodenobjekts auf und hole
 * anschließend den Ball wieder zurück in den Bildschirm. Beschreibe, wie sich
 * das Verhalten der Objekte nun verändert hat. Formuliere schriftlich die
 * Wirkung der Methode macheAktiv und beschreibe, wie aktive Objekte allgemein
 * mit anderen Objekten interagieren, bevor und nachdem ihre Methode machePassiv
 * aufgerufen wurde.</li>
 *
 * <li>e Mit der Methode setzeElastizitaet(double elastizitaet) kann angegeben
 * werden, wie sich ein Objekt bei der Berührung eines anderen Objektes verhält.
 * Setze die Elastizität des Balls auf verschiedene Werte zwischen 0.5 und 2 und
 * beobachte die Wirkung. Tipp: Dazu musst du den Ball unter Umständen immer
 * wieder in eine gewisse Höhe über den Boden bringen. Für Schnelle etwas Physik
 * für zwischendurch: Erkläre, wie der Wert der Elastizität mit der
 * Energieerhaltung zusammenhängt.</li>
 *
 * <li>f Erzeuge mit den dir bekannten Mitteln einen „Bouncer“, also einen Ball,
 * der endlos springt. Experimentiere weiter mit zwei Bällen, die sich
 * gegenseitig beeinflussen.</li>
 * </ul>
 */
package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_projekt.aufgabe_1.bouncer;
