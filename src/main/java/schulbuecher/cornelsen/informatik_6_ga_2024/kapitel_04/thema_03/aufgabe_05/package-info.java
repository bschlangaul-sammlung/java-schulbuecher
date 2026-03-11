/**
 * Erzeuger-Verbraucher-Problem
 *
 * <p>
 * Im vorliegenden Projekt ist das Erzeuger-Verbraucher-Problem implementiert.
 * In den Klassen ERZEUGER und VERBRAUCHER wird das Produzieren bzw. Einlagern
 * in Millisekundenschritten simuliert.
 * </p>
 *
 * <ol>
 * <li>a Der Zugriff von Erzeuger und Verbraucher auf die gemeinsame Ressource
 * wurde im Projekt bereits synchronisiert. Benennen und erklären Sie das
 * Konzept, das dabei umgesetzt wurde.</li>
 *
 * <li>b Betrachten Sie die grafische Darstellung im Vorlagenprojekt.
 * <ol>
 * <li>i Erklären Sie anhand der grafischen Darstellung, welche Strategie zum
 * Warten auf einen freien Ablageplatz im Projekt verwendet wird.</li>
 * <li>ii Verifizieren Sie Ihre Vermutung anhand des Quellcodes. Erklären Sie,
 * warum die Strategie ungünstig ist. Begründen Sie auch, warum für die
 * Umsetzung ein Rückgabewert der Methode Ablegen() notwendig ist.</li>
 * <li>iii Ergänzen Sie eine Variable zum Mitzählen der Vergleiche in den
 * Methoden von SPEICHER und geben Sie deren Wert aus.</li>
 * </ol>
 * </li>
 *
 * <li>c Verbessern Sie den Quellcode in einer Kopie des Projekts: Sorgen Sie
 * dafür, dass die Threads passiv warten. Vergleichen Sie dann - für eine etwa
 * gleich große Zeitspanne - die vorherige Anzahl von Vergleichen mit der
 * jetzigen. Arbeiten Sie im Folgenden in der Projektvorlage ohne grafische
 * Darstellung.</li>
 *
 * <li>d Zählen Sie mit einer Variablen, wie häufig Warten() vom Erzeuger- bzw.
 * Verbraucherthread aufgerufen wird. Erweitern Sie dann die Anzahl der
 * verfügbaren Ablegeplätze in SPEICHER mit Hilfe eines Felds auf 10 und
 * vergleichen Sie die Variablenwerte für eine etwa gleich große Zeitspanne.
 * Erklären Sie Ihre Beobachtung.</li>
 *
 * <li>e Erweitern Sie auf fünf Erzeuger und fünf Verbraucher. Vergessen Sie
 * nicht, die Benachrichtigung in den Methoden von SPEICHER anzupassen.
 * Vergleichen Sie die Werte Ihrer Variablen zum Zählen der Vergleiche bzw.
 * Warten-Aufrufe und ordnen Sie Ihre Beobachtung ein.</li>
 *
 * <li>f Für Schnelle: Implementieren Sie in einer Kopie des Projekts eine
 * Umsetzung mit Semaphoren. Die Zugriffsversuche beim aktiven Warten sollen mit
 * einem Zeitabstand von 100 ms erfolgen.</li>
 * </ol>
 */
package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_05;
