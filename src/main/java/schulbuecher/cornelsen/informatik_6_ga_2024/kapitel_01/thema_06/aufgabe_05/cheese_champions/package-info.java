
/**
 * Cheese-Champions (aus 17{@literal .} Bundeswettbewerb Informatik)
 *
 * <p>
 * Prof. Grips will die Durchsetzungsfähigkeit einzelner Mäuse einer
 * Mäusekolonie feststellen. Dazu hat er die folgende Versuchsanordnung
 * entworfen: Ausgehend von einem unterirdischen Gang gräbt er in einem spitzen
 * Winkel einen Ausgang zur Oberfläche, an dessen Ende er ein Stück duftenden
 * Käse deponiert. Die Mäuse der Kolonie kommen direkt hintereinander von links
 * in den unterirdischen Gang und wollen durch den Abzweig zum Käse. Da der Gang
 * zum Käse in einem spitzen Winkel abzweigt, muss jede Maus erst über den
 * Abzweig hinaus weiter in den Gang hineinlaufen. Dann dreht sie sich um und
 * hat möglicherweise ein Problem: Sie stößt auf die nachfolgende Maus, die
 * ebenfalls in den rechten Abschnitt möchte.
 * </p>
 *
 * <p>
 * Präziser gelten die folgenden Regeln für das Erreichen des Käses:
 * </p>
 *
 * <ul>
 * <li>Jede Maus muss zuerst an der Abzweigung vorbei.</li>
 *
 * <li>Wenn sie im rechten Teil nach der Abzweigung ist, kann sie entweder den
 * Zweikampf gegen die nachfolgende Maus gewinnen und so in die Abzweigung
 * gelangen oder sie wird weiter in den unterirdischen Gang geschoben. Die
 * nachfolgende Maus wird dann in einen Zweikampf mit der ihr nachfolgenden Maus
 * verwickelt.</li>
 * </ul>
 *
 * <p>
 * Prof. Grips nummeriert die Mäuse in der Reihenfolge, in der sie in den Gang
 * hineinlaufen, mit 1, 2, 3, .. und beobachtet, in welcher Reihenfolge sie beim
 * Käse ankommen.
 * </p>
 *
 * <ol>
 * <li>Schreiben Sie ein Programm, das aus der beobachteten Reihenfolge, in der
 * die Mäuse beim Käse ankommen, die Anzahl der gewonnenen Zweikämpfe für jede
 * Maus berechnet und ausgibt.</li>
 *
 * <li>Zusätzlich soll Ihr Programm nicht realisierbare Austrittsreihenfolgen
 * erkennen und zu- rückweisen (wie z. B. die Austrittsreihenfolge 3, 1,
 * 2).</li>
 * </ol>
 */
package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_06.aufgabe_05.cheese_champions;
