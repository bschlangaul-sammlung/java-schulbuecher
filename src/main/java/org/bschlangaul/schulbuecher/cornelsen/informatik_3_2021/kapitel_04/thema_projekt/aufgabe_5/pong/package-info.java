
/**
 * 5 Projekt Pong (ab 4.6)
 *
 * <p>
 * Hier programmierst du eine Variante des Spiels Pong.
 * </p>
 *
 * <ul>
 * <li>a Erzeuge ein Objekt der Klasse PONG und verschaffe dir einen Überblick
 * über seine Methoden. Folgende Fragen helfen dir dabei:
 *
 * <p>
 * Kannst du die Schläger nach oben und unten bewegen? Wie kannst du den Ball
 * bewegen? Kannst du ihn auf dem Boden springen lassen? Finde den Tastencode
 * der Tasten Pfeil rauf, Pfeil runter, w und s heraus. Notiere dir die Werte,
 * damit du später die Schläger steuern kannst.
 * </p>
 * </li>
 *
 * <li>b Erstelle eine Unterklasse von PONG. Bei der Erstellung eines Objekts
 * deiner Klasse müssen die nachfolgenden Aufgaben erledigt werden. Schreibe die
 * passenden Methodenaufrufe in den Konstruktor: Ball aktiv machen Ball
 * elastisch machen Boden passivmachen Schläger passiv machen</li>
 *
 * <li>c Damit der Ball nicht nur rauf und runter hüpft, musst du ihm im
 * Konstruktor noch einen seitlichen Stoß mitgeben. Verwende die Methode
 * ballWirkelmpuls(intx, int y). Stelle die Stoßstärke so ein, dass man später
 * noch eine Chance hat, den Ball mit dem Schläger zu spielen.</li>
 *
 * <li>Für Schnelle: Verwende die geerbte Methode zufallszahlVonBis(int
 * kleinsterWert, int größ- terWert) zusammen mit einer Fallunterscheidung, um
 * den Ball zu Beginn zufällig nach rechts oder links zu stoßen.</li>
 *
 * <li>d Nun ist es an der Zeit, die Schläger zu bewegen. Hierzu überschreibst
 * du die geerbte Me- thode tasteReagieren(int taste). Der rechte Schläger soll
 * mit den Pfeiltasten (rauf, runter) gesteuert werden, der linke Schläger
 * reagiert auf die Tasten w und s. Nutze die in Teilauf- gabe a) ermittelten
 * Tastencodes für eine bedingte Anweisung. Hinweis: Anfangs ist eine vertikale
 * Verschiebung von 1 pro Tastendruck ausreichend. Für Schnelle: Ergänze die
 * Steuerung, so dass die Schläger nicht über den Bildschirmrand hinausbewegt
 * werden können.</li>
 *
 * <li>e Um die Spiellogik zu vervollständigen, müssen folgende Aufgaben
 * erledigt werden: Wenn der Ball hinter dem rechten Schläger ist, muss der
 * Punktestand des linken Spielers erhöht werden. Anschließend muss der Ball
 * wieder in die Mitte gesetzt werden und einen neuen Impuls bekommen. Analog
 * müssen die gleichen Arbeiten erledigt werden, wenn der Ball hinter dem linken
 * Schläger verschwindet. Zeichne ein Struktogramm, das diese Aufgaben
 * abbildet.</li>
 *
 * <li>f Überschreibe die Methode tick und setze in ihr das Struktogramm aus e)
 * um. Tipp: Die x-Koordinaten des rechten und linken Schlägers sind 14 und -14.
 * Starte zudem im Konstruktor deiner Klasse den Ticker mit beispielsweise 1/10
 * Sekunde. Verwende dazu die Methode starteTickerNeu. Teste deine Arbeit.</li>
 * </ul>
 */
package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_projekt.aufgabe_5.pong;
