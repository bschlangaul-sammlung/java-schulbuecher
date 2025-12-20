/**
 * Rangierbahnhof – Abgeänderte Situation (Seite 112)
 *
 * <p>
 * 3.2.1.2 Rangierbahnhof – Abgeänderte Situation
 * </p>
 *
 * <p>
 * Die Reihenfolge der Waggons, die auf Gleis 1 stehen, soll nun geändert
 * werden. Dazu hat der Rangiermeister die Waggons mit Nummern markiert. Die
 * Waggons sollen nun so rangiert werden, dass sie nach dem Rangiervorgang am
 * Gleis 3 nach der vom Rangiermeister vergebenen Nummer geordnet sind. Dabei
 * soll der Waggon mit der kleinsten Nummer ganz vorne, d. h. bei der
 * Lokomotive, stehen.
 * </p>
 *
 * <p>
 * Folgender Algorithmus löst das Problem:
 * </p>
 *
 * <ol>
 * <li>Verschiebe die Waggons von Gleis 1 auf 3, solange die richtige
 * Reihenfolge auf Gleis 3 gewährleistet ist.</li>
 *
 * <li>Wenn die Nummer des (nächsten) Waggons auf Gleis 1 größer als die Nummer
 * des Waggons auf Gleis 3 ist, verschiebe solange Waggons von Gleis 3 nach
 * Gleis 2, bis der Waggon von Gleis 1 an der richtigen Stelle auf Gleis 3
 * eingefügt werden kann.</li>
 *
 * <li>Wiederhole Schritt 1 und 2, bis Gleis 1 leer ist.</li>
 *
 * <li>Ist das Gleis 2 nicht leer, so verschiebe alle Waggons von Gleis 2 nach
 * Gleis 1 und beginne bei Schritt 1.
 *
 * <ol>
 * <li>Vollziehen Sie die Strategie mit der obigen Gleisbelegung auf einem Blatt
 * Papier nach.</li>
 *
 * <li>Setzen Sie die Simulation mit einem Programm um. Der Rangiervorgang soll
 * dabei wieder in der Methode Rangieren() umgesetzt werden. Dabei soll die
 * Anzahl der Rangierschritte mitprotokolliert und auf der Konsole ausgegeben
 * werden.
 *
 * <p>
 * Es stellt sich nun die Frage, ob man den Rangiervorgang in der Regel
 * schneller, d. h. in weniger Schritten, durchführen kann.
 * </p>
 *
 * <p>
 * Beim obigen Algorithmus kann man dazu beispielsweise bei Schritt 4 ansetzen:
 * </p>
 *
 * <p>
 * Gleis 2 hat beim ersten Durchlauf der Schritte 1 bis 3 die Funktion eines
 * Hilfsgleises. Man kann nun auf das Umrangieren von Gleis 2 auf Gleis 1
 * verzichten, wenn man bei einem erneut notwendigen Durchlauf der Schritte 1
 * bis 3 das Gleis1 als Hilfsgleis verwendet. Ist nach dem Arbeiten der Schritte
 * 1 bis 3 das Hilfsgleis 1 noch mit Waggons belegt, so übernimmt wiederum Gleis
 * 2 die Funktion des Hilfsgleises.
 * </p>
 * </li>
 *
 * <li>Vollziehen Sie die geänderte Strategie mit obiger Gleisbelegung wiederum
 * auf Papier nach und zeigen Sie, dass mit dieser Verbesserung das Umrangieren
 * bei der obigen Situation in acht Schritten möglich ist.</li>
 *
 * <li>Setzen Sie den verbesserten Algorithmus in einer Methode
 * RangierenBesser() um und testen Sie die Methoden für verschiedene
 * Gleisbelegungen.</li>
 *
 * <li>Ist der verbesserte Algorithmus in jedem Fall schneller als der
 * ursprüngliche? Begründen Sie kurz!</li>
 *
 * </ol>
 *
 * </li>
 * </ol>
 */
package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.abgeaenderte_situation;
