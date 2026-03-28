/**
 * Jäger und Beute - Maussteuerung
 *
 * <p>
 * Ein Beuteobjekt (roter Kreis) bewegt sich zufallsgesteuert über das
 * Spielfeld. Der Jäger (blaues Quadrat mit gelbem Pfeil muss das Beuteobjekt
 * berühren. Seine Richtung kann durch Mausklicks gesteuert werden: Jeder
 * Mausklick dreht den Jäger genau in Richtung des Klicks.
 * </p>
 * <ol>
 *
 * <li>a Die Klasse BEUTE im Projekt JägerUndBeuteStart erbt von FIGUR. Ergänze
 * in der Klasse BEUTE den Konstruktor so, dass die Beute das von dir gewünschte
 * Aussehen bekommt. Beim Berühren wird die Methode Umfärben aufgerufen. Ergänze
 * die Methode, so dass sich das Aussehen der Beute passend verändert.</li>
 *
 * <li>b Ergänze den Konstruktor der Klasse JÄGER so, dass der Jäger das von dir
 * gewünschte Aussehen bekommt.</li>
 *
 * <li>c Erweitere die Klasse JÄGER um einen Zufallsgenerator (du kannst in der
 * Klasse BEUTE nachsehen) und sorge dafür, dass der Jäger mit zufälliger
 * Startposition und zufälligem Winkel beginnt.</li>
 *
 * <li>d Analysiere in der Klasse JÄGER, wie ein Mausklick verarbeitet wird.
 * Beschreibe dabei insbesondere die Aufgabe der Methode RichtungGeben, ohne
 * dabei auf deren Implementierung einzugehen. Gib die Bedeutung der einzelnen
 * Teile des Kopfs dieser Methode an und nenne die Anweisung, mit der das
 * Ergebnis zurückgegeben wird.</li>
 *
 * <li>e Ergänze in der Klasse JÄGER ein Attribut zum Zählen der Berührungen von
 * Jäger und Beute.</li>
 *
 * <li>f Ergänze die Klasse BEUTE so, dass die Beute an einen neuen, zufällig
 * bestimmten Ort wechselt, wenn sie berührt wurde.</li>
 *
 * <li>g Ergänze die Klasse BEUTE so, dass das Umfärben der Beute nach z.B. 10
 * Taktimpulsen rückgängig gemacht wird.</li>
 *
 * <li>h Für Schnelle: Recherchiere im Internet die Bedeutung der Funktion
 * Arcustangens. Gib mit Hilfe dieser Beschreibung an, wie die Methode
 * RichtungGeben ihre Aufgabe erfüllt.</li>
 * </ol>
 */
package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_08.aufgabe_11.jaeger_beute;
