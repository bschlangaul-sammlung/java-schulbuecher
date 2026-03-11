/**
 * Parkverbot
 *
 * <p>
 * In der Innenstadt gibt es eine beliebte Stelle im Parkverbot, die Platz für
 * ein einzelnes Fahrzeug bietet. Für schnelle Erledigungen werden Fahrzeuge
 * dort häufig bis zu fünf Minuten abgestellt. Ist der Platz gerade besetzt, hat
 * es sich etabliert, einmal um den Block zu fahren und es dann erneut zu
 * probieren. Im Folgenden soll der beschriebene Parkverkehr mit Threads
 * simuliert werden.
 * </p>
 *
 * <ol>
 * <li>a Erstellen Sie eine Programmsimulation für das im Text beschriebene
 * Szenario auf Basis des gegebenen Klassendiagramms und der Struktogramme.
 * Erstellen Sie auch eine Rahmenklasse, die zehn Fahrzeugthreads erstellt und
 * startet. Der Einfachheit halber sollen diese zehn Fahrzeuge immer wieder ein-
 * und ausparken.</li>
 *
 * <li>b Vergleichen Sie Ihr Programm mit der zur Verfügung gestellten Lösung
 * und korrigieren Sie gegebenenfalls. Führen Sie dann die Lösungssimulation aus
 * und begründen Sie anhand der Ausgaben, dass die Lösung noch einen Fehler
 * enthält. Erklären Sie, warum der Fehler z.B. mit einem Monitor vermieden
 * werden kann, und verbessern Sie den Quellcode entsprechend. Testen Sie
 * erneut.</li>
 *
 * <li>c Diskutieren Sie zu zweit, ob die Situation einer Ihnen bekannten
 * Problemklasse zugeordnet werden kann.</li>
 *
 * <li>d Mehrmals um den Block zu fahren ist aufwändig und nicht ökologisch.
 * Verbessern Sie das Programm, indem Sie die Strategie „Passives Warten” für
 * die Threads umsetzen. Diskutieren Sie zu zweit, ob sich diese auch auf den
 * Sachkontext der Parkplatzsuche übertragen lässt.</li>
 *
 * <li>e Anton hat sowohl in Beparken als auch in Verlassen den Aufruf der
 * Methode Benachrichtigen() vergessen. Treffen Sie eine Voraussage, welche
 * Ausgabe bei seinem Programm zu erwarten ist, und überprüfen Sie Ihre Lösung
 * dann.</li>
 * </ol>
 */
package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_06;
