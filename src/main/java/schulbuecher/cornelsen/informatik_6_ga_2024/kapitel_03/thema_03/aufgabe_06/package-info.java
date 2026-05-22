/**
 * Aufgabe <b>6</b>
 *
 * <p>
 * Tiefensuchbaum
 * </p>
 *
 * <p>
 * Da als Ergebnis derTiefensuche jeder Knoten - mit Ausnahme des Startknotens -
 * genau einen Vorgänger zugeteilt bekommt, lässt sich durch ein Baumdiagramm
 * sehr schnell ein Überblick über alle Pfade von einem Startknoten aus
 * erhalten. Das Bild rechts zeigt den Baum, der für das Beispiel aus dem
 * Lehrtext bei der Suche von ,M* aus entsteht.
 * </p>
 *
 * <ol>
 * <li>a Erstellen Sie für den Graphen aus dem Lehrtext den Tiefensuchbaum für
 * die Suche von Knoten „UL” aus.</li>
 *
 * <li>b Ergänzen Sie in dem Vorlagenprojekt die Methoden KnotenBesuchen und
 * TiefensucheAusführen so, dass bei der Tiefensuche auch der Tiefensuchbaum
 * erstellt und anschließend ausgegeben wird. Die Klasse KNOTEN stellt dazu eine
 * Methode NeuesBlattAnfügen(blatt: KNOTEN) zur Verfügung. Zur Visualisierung
 * können Sie die Methode BaumAnzeigen(wurzel: KNOTEN) der Klasse GRAPH_MATRIX
 * verwenden. Testen Sie insbesondere mit dem Graphen aus dem Lehrtext und
 * vergleichen Sie den von Ihnen in Teilaufgabe a) erstellten Tiefensuchbaum mit
 * dem Ergebnis des Programms.</li>
 * </ol>
 */
package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_03.aufgabe_06;
