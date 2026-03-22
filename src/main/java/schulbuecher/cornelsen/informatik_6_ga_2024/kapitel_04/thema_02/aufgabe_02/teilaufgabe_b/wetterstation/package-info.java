/**
 * Monitore zur Threadsynchronisation einsetzen
 *
 * <p>
 * In dem zu dieser Aufgabe bereitgestellten Programm wird eine Wetterstation
 * simuliert. Das Programm arbeitet dabei mit mehreren Threads, wobei jede
 * erfasste Messgröße (Temperatur, Luftdruck usw.) von einem eigenen Thread
 * erfasst und als Text ausgegeben wird.
 * </p>
 * <ol>
 * <li>a Identifizieren Sie alle kritischen Abschnitte im vorgegebenen
 * Programmcode.</li>
 * <li>b Ergänzen Sie den Programmcode sinnvoll, damit fehlerhafte Ausgaben
 * zukünftig vermieden werden. Verwenden Sie zur Synchronisation der Threads das
 * Monitorkonzept.</li>
 * </ol>
 *
 * Quelle: <a href=
 * "https://webcodes-prod.obs-website.eu-de.otc.t-systems.com/codes/assetfiles/mafeso/9F6AARFVaxlB8tBSoZ8lbF/K4_Java_Lsg.zip">K4_Java_Lsg.zip</a>
 */
package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_02.aufgabe_02.teilaufgabe_b.wetterstation;
