/**
 * Knoten mit einer bestimmten Eigenschaft suchen (Teil 1)
 *
 * <p>
 * Eine Vertreterin hat in ihrer Landkarte alle Orte markiert, in denen sie
 * mindestens eine Kundin oder einen Kunden hat. Weiter sind die Orte markiert,
 * in denen ein Geschäft ihrer Firma ist. Im gegebenen Projekt sind bei den
 * Knoten zusätzlich die Attribute kundeVorhanden und ladenVorhanden
 * (WAHRHEITSWERT) ergänzt sowie die Methoden IstKundeVorhanden() bzw.
 * IstLadenVorhanden(), die jeweils den Wert des Attributs zur Verfügung stellt.
 * </p>
 *
 * <ol>
 * <li>a Ändern Sie die Methoden TiefensucheAusführen und KnotenBesuchen der
 * Klasse GRAPH_MATRIX so ab, dass die Suche beendet wird, wenn ein Knoten mit
 * einem Laden gefunden wurde. Markieren Sie auch die in Arbeit befindlichen
 * Knoten, so dass der Weg grob angezeigt wird. Tipp: KnotenBesuchen benötigt
 * als Resultat einen Wahrheitswert.</li>
 * <li>b Testen Sie Ihre Lösung mit der Suche von verschiedenen Startpunkten
 * aus. Begründen Sie, warum nicht immer der kürzeste Weg gefunden wird.</li>
 * <li>c Für Schnelle: Ergänzen Sie die Methoden TiefensucheAusführen und
 * KnotenBesuchen so, dass als Parameter angegeben werden kann, nach welchem der
 * vorhandenen Kriterien gesucht werden soll.</li>
 * </ol>
 */
package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_04.aufgabe_02;
