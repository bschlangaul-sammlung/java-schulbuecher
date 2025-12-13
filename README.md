# java-schulbuecher

Bei diesem Repository handelt es sich um einen Versuch viele verschiedene
Java-Code-Beispiele, Java-Aufgaben bzw. Java-Projekte aus verschiedenen
Schulbüchern in einem großen Java-Paket zu vereinigen. Dieses Repository enthält
sowohl die Lösungen (ohne Suffix `_vorlage`) der Java-Aufgaben als auch die
Vorlagen (Suffix `_vorlage`), die den Schülern zur Verfügung gestellt werden.

## Ziele

- Vereinheitlichung
  - einheitlicher Coding-Style
  - einheitliche Paket bzw. Ordner-Struktur
- Steigerung der Code-Qualität
  - ein Syntax-Fehler in einer Aufgabe fällt sofort auf, weil das ganze Projekt dann nicht mehr kompiliert.
  - Linting kann über die ganze Code-Basis angewendet werden.

## Veränderungen / Anpassungen

- Der Code wurde neu formatiert, um einen einheitlichen Coding-Style (Einrückung
  entspricht vier Leerzeichen, öffnende Klammer startet in einer neuen Zeile) zu folgen.
- Klassennamen, die allschließlich Großbuchstaben verwenden, wurden umbenannt,
  damit sie der in der Java-Welt etablierten `UpperCamelCase`-Konvention
  entsprechen.
- Zusätzliche main-Methoden erlauben das einfache Starten der Projekte in der
  IDE.
- Die Quelltexte sind in UTF-8 codiert.
- HTML-Entities (z. B. `&auml;`, `auml;`, `"auml;`, `&aauml;` → `ä`) wurden nach UTF-8 konvertiert
- Javadoc-Fehler ausbessern
- Deprecations beheben, z. B. `new Integer()` -> `Integer.valueOf()` oder `Integer.parseInt()`
- `*` Imports in einzelne Imports auflösen
- Unnötige Imports entfernt
- Rechtschreibfehler ausbessert
- Unterdrücken von Warnungen `@SupressWarning("unused")`
- Vereinheitlichung der Kommentare: Block-Kommentar `/**\n *\n */`, Inline-Kommentar `// `

## Ordner-Struktur / Namensschema der Pakete

`kapitel_01` -> `thema_01` -> `aufgabe_01` -> `teilaufgabe_a`

Ohne suffix `_vorlage` handelt es sich um die Lösung

- Lösung: `buchner/informatik_9_2021/kapitel_05/thema_04/hasenjagd`
- Vorlage für die Schüler: `buchner/informatik_9_2021/kapitel_05/thema_04/hasenjagd_vorlage`

## Quellen

`package-info.java` bei Büchern

`reference_title, release_date: reference_subtitle`, zum Beispiel:

`Informatik 5 (Bayern | NTG), 2023: Graphen | Codierung | Kommunikation in Netzwerken | Künstliche Intelligenz`

### `buchner`

#### `buchner/informatik_9_2021`

Informatik 9, 2021: Gymnasium Bayern (NTG)

```yml
folder: buchner/informatik_9_2021
reference_title: Informatik 9
reference_subtitle: Gymnasium Bayern (NTG)
isbn: 978-3-661-38009-4
publisher: Buchner
release_date: 2021
author: Dieter Bergmann, André Greubel
approval_number: 272/21-G+
approval_date: 01.09.2021
publisher_website: https://www.ccbuchner.de/produkt/informatik-gymnasium-bayern-9-ntg-7198
```

#### `buchner/informatik_10_2022`

Informatik 10, 2022: Gymnasium Bayern (NTG)

```yml
reference_title: Informatik 10
reference_subtitle: Gymnasium Bayern (NTG)
isbn: 978-3-661-38010-0
publisher: Buchner
release_date: 2022
author: >-
  Dieter Bergmann, André Greubel, Verena Haller, Peter Mahns, Thomas
  Rau, Julia Reitberger, Wolfgang Riffelmacher, Ulrich Schneider, Anja
  Stube, Hilmar Vogel, Barbara Wieczorek
publisher_website: https://www.ccbuchner.de/produkt/informatik-gymnasium-bayern-10-ntg-7201
approval_number: 335/22-G+
```

#### `buchner/informatik_11_2022`

Informatik 11, 2023: Gymnasium Bayern Sek II

```yml
reference_title: Informatik 11
reference_subtitle: Gymnasium Bayern Sek II
publisher: Buchner
release_date: 2023
publisher_website: https://www.ccbuchner.de/produkt/informatik-gymnasium-bayern-11-8541
isb: 978-3-661-38011-7
approval_number: 51/24-G+
author: Tobias Dorsch, André Greubel, Peter Knoll, Verena Murr, Robert Stöhr, Anja Stube, Hilmar Vogel, Barbara Wieczorek
```

### `cornelsen`

Viele Java-Projekte des Cornelsen-Verlags verwenden die sogenannte
`GraphicsAndGames`-API. Die Autoren des Cornelsen-Verlags binden dabei
`GraphicsAndGames` nicht als JAR-Archiv ein, sondern kopieren alle Klassen von
`GraphicsAndGames` in die einzelnen Projekte. Es bedarf daher oft eine gewisse
Einlesezeit, um überhaupt den Code, der zu der entsprechenden Aufgabe gehört, zu
finden. In diesem Repository sind alle `GraphicsAndGames`-Klassen in des Paket
`org/bschlangaul/schulbuecher/cornelsen/shared/graphics_and_games` ausgelagert.
Neben den Klassen `Dreieck`, `Ereignisbehandlung`, `Figur`, `Kreis`, `Rechteck`,
`Text`, `Turtle` und `Zeichenfenster`, die offiziell in der
[Javadoc](http://gng4java.informatikschulbuch.de/package-summary.html)-Dokumentation
aufgelistet sind, sind dem Paket
`org/bschlangaul/schulbuecher/cornelsen/shared/graphics_and_games` noch weitere
Klassen (momentan nur `Zelle`) zugeordet, die auch in mehreren Projekten vorkommen.

Um Klassen von `GraphicsAndGames` zu verwenden, kann folgender `import`
verwendet werden.

```java
import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.*;
```

Vorlagen von `GraphicsAndGames`:

- [9. Jahrgangsstufe](https://informatikschulbuch.de/jahrgangsstufe-9-uebersicht/objektorientierte-modellierung-und-programmierung/)
- [10. Jahrgangsstufe](https://informatikschulbuch.de/jahrgangsstufe-10/objektorientierte-modellierung-und-programmierungjgst10/)
- [11. Jahrgangsstufe](https://informatikschulbuch.de/jahrgangsstufe-11/vernetze-strukturen-grapen-kapitel-1-informatik-5/)

#### `cornelsen/informatik-3_2021`

Informatik 3, 2021: Gymnasium Bayern - Ausgabe 2017 · Band 3 Funktionale Modellierung, Datenmodellierung, Objektorientierte Modellierung (Jgst. 9)

```yml
ref: Informatik-3_Cornelsen_2021
reference_title: Informatik 3
reference_subtitle: >-
  Gymnasium Bayern - Ausgabe 2017 · Band 3
  Funktionale Modellierung, Datenmodellierung, Objektorientierte
  Modellierung (Jgst. 9)
isbn: 978-3-637-02467-0
publisher: Cornelsen
author: Peter Brichzin, Franz Jetzinger
release_date: 2021
approval_number: 76/21-G+
approval_date: 28.05.2021
publisher_website: https://www.cornelsen.de/produkte/9783637024670
publisher_decription: |
  - Einführungsvideos online für alle Werkzeuge
  - Handlungsorientierte Einstiegsaufgaben nach dem PRIMM-Konzept (Predict, Run, Investigate, Modify, Make) mit Vorlagen für einen altersgerechten Unterricht von Anfang an
  - Sowohl kleine Aufgaben für mehr Abwechslung als auch größere themenzentrierte Aufgabenblöcke
  - Eine große Auswahl neuer kompetenzorientierter Aufgaben, praktisch gegliedert nach Kompetenzerwartungen
  - Zahlreiche Datenbanken mit schülernahen und echten Datensätzen. Die notwendigen Vorlagen für den eigenen Datenbankserver oder SQL-Abfragen lassen sich direkt im Browser durchführen.
  - Eine eigene kleine Game-Engine (Graphics and Games) für Programmieranfänger/-innen für interessante, schüleraktivierende und flexible Beispiele.
  - Die gleiche Plattform für alle Programmiersprachen: alle Vorlagen und Lösungen für Java, Stride, Python und Swift mit Möglichkeit der Adaption an weitere Sprachen. Dadurch werden die Gemeinsamkeiten der Sprachen und das Modellieren betont.

table_of_contents: |
  Funktionale Modellierung und Tabellenkalkulation (Seite 7)
    1.1 Tabellenkalkulationssysteme: Rechnen mit Rechenblättern (Seite 8)
    1.2 Geschickt kopieren: relative und absolute Zellbezüge (Seite 14)
    1.3 Funktionen (Seite 20)
    1.4 Berechnungen analysieren: Das Datenflussdiagramm (Seite 26)
    1.5 Die Übersicht behalten: Funktionen zusammenfassen (Seite 32)
    1.6 Eingabewerte mehrfach nutzen: Datenverteiler (Seite 36)
    1.7 WENN-Funktion (Seite 40)
    1.8 Logische Funktionen (Seite 44)
    1.9 Miniprojekte und weiterführende Aufgaben (Seite 48)
    Teste dich selbst! (Seite 51)
    Zusammenfassung (Seite 52)
    Zum Weiterlesen
      L1 Aus der Praxis: Unternehmensberatung (Seite 54)
      L2 Geschichte der Tabellenkalkulation (Seite 55)
      L3 Barcodes (Seite 56)
      L4 Zahlen unterschiedlich dargestellt (Seite 58)
  2 Datenmodellierung und Datenbanken (Seite 59)
    2.1 Einfache Datenbankabfragen (Seite 60)
    2.2 Tipps und Tricks für Abfragen (Seite 66)
    2.3 Objektorientierte Datenmodellierung (Seite 70)
    2.4 Primärschlüssel: natürlich oder künstlich (Seite 76)
    *2.5 Abfragen mit Aggregatfunktionen (Seite 80)
    *2.6 Ergebnisse durch Gruppierung zusammenfassen (Seite 84)
    2.7 Miniprojekte und weiterführende Aufgaben (Seite 87)
    Teste dich selbst! (Seite 90)
    Zusammenfassung (Seite 91)
    Zum Weiterlesen
      L5 Datenbankmanagementsysteme und ihre Datentypen (Seite 92)
      L6 Biometrische Daten als Schlüssel (Seite 92)
      L7 Aus der Praxis: Große Datenbank (Seite 93)
      L8 Index als schnelle Suchhilfe (Seite 94)
  3 Datenschutz (Seite 95)
    3.1 Datenschutzregelungen aus unterschiedlichen Blickwinkeln (Seite 96)
    3.2 Data Mining (Seite 100)
    Zum Weiterlesen
      L9 Aus der Praxis: Hacker (Seite 104)
  4 Objektorientierte Modellierung und Programmierung (Seite 105)
    4.1 Vorbereitung auf‘s Programmieren: Arbeiten mit Objekten (Seite 106)
    4.2 Erste eigene Klasse – Methoden in Unterklassen schreiben (Seite 112)
    4.3 Wiederholung mit Bedingung (Seite 118)
    4.4 Die bedingte Anweisung (Seite 124)
    4.5 Methoden anpassen (Seite 130)
    4.6 Attribute – Vereinbarung und Initialisierung (Seite 136)
    4.7 Vielseitig einsetzbar: Weitere Kontrollstrukturen (Seite 140)
    4.8 Methoden mit Rückgabewert und Variablenkonzept (Seite 146)
    4.9 Miniprojekte – Modellieren in der Informatik (Seite 152)
    Teste dich selbst! (Seite 156)
    Projekte mit einer Game-Engine (Seite 157)
    Zusammenfassung (Seite 162)
    Zum Weiterlesen
      L10 Entwicklung der Programmiersprachen (Seite 164)
      L11 Kleine Fehler, große Wirkung (Seite 166)
      L12 Zufallszahlengeneratoren (Seite 167)
      Lösungen zu „Teste dich selbst!“ (Seite 169)
      Stichwortverzeichnis (Seite 173)
      Bildquellenverzeichnis (Seite 176)
```

#### `cornelsen/informatik_5_2023`

Informatik 5 (Bayern | NTG), 2023: Graphen | Codierung | Kommunikation in Netzwerken | Künstliche Intelligenz

```yml
ref: Informatik-5_Cornelsen_2023
reference_title: Informatik 5 (Bayern | NTG)
reference_subtitle: >-
  Graphen | Codierung | Kommunikation in Netzwerken | Künstliche Intelligenz
isbn: 978-3-637-02473-1
publisher: Cornelsen
author: >-
   Peter Brichzin, Florian Janus, Franz Jetzinger, Johannes Neumeyer,
   Klaus Reinold, Dr. Stefan Seeger, Albert Wiedemann
release_date: 2023
edition: 1
approval_number: 164/23-G+
approval_date: 24.07.2023
publisher_website: https://www.cornelsen.de/produkte/9783637024731
```

#### `cornelsen/informatik_6_ga_2024`

Informatik 6 Bayern | NTG | Grundlegendes Niveau, 2024: Listen | Bäume | Rekursion - Nebenläufigkeit und Threads - Informationssicherheit -  Softwareprojekte

```yml
ref: Informatik-6_gA_Cornelsen_2024
reference_title: Informatik 6 Bayern | NTG | Grundlegendes Niveau
reference_subtitle: >-
  Listen | Bäume | Rekursion - Nebenläufigkeit und Threads - Informationssicherheit - Softwareprojekte
isbn: 978-3-637-02476-2
publisher: Cornelsen
author: >-
  Peter Brichzin, Florian Janus, Franz Jetzinger, Johannes Neumeyer,
  Klaus Reinold, Dr. Stefan Seegerer, Albert Wiedemann, Dennis Stanglemair
release_date: 2024
approval_number: 132/24-G+
approval_date: 06.08.2024
publisher_website: https://www.cornelsen.de/produkte/9783637024762
table_of_contents: |
  1 Die rekursive Datenstruktur Liste (Seite 13)
    1.1 Prototyp 1: Die rekursive Warteschlange (Seite 14)
    1.2 Prototyp 2: Trennung von Struktur und Daten (Seite 18)
    *1.3 Prototyp 2+: Bessere Trennung hilft beim Recycling (Seite 24)
    1.4 Prototyp 3: Rekursive Methoden der Liste (Seite 26)
    Einschub: Programme testen (Seite 30)
    Einschub: Prototyping (Seite 31)
    1.5 Endprodukt: Liste mit Entwurfsmuster Kompositum (Seite 32)
    1.6 Stapel und Warteschlange: Spezialformen der Liste (Seite 42)

  2 Die rekursive Datenstruktur Baum
    2.1 Effiziente Suchen unterstützen: Datenstruktur Baum (Seite 52)
    2.2 Suchen und Einfügen: Rekursion im geordneten Binärbaum (Seite 58)
    2.3 Entwurfsmuster nutzen: Binärbaum implementieren (Seite 62)
    2.4 Binärbäume durchlaufen: Information aller Daten abfragen (Seite 70)
    2.5 Üben und Vertiefen: Weiterführende Aufgaben (Seite 74)

  3 Rekursion
    3.1 Methoden rufen sich selbst auf: Rekursion (Seite 88)
    3.2 Anwendung der Rekursion: Backtracking (Seite 96)
    3.3 Alle Knoten eines Graphen besuchen: Tiefensuche (Seite 102)
    3.4 Anwendungen der Tiefensuche: Optimale Lösungen (Seite 108)

  4 Nebenläufigkeit und Threads
    4.1 Nebenläufigkeit: Prozesse und Threads (Seite 118)
    4.2 Wechselseitiger Ausschluss (Seite 122)
    4.3 Eine gemeinsame Ressource: Effiziente Synchronisierung (Seite 128)
    4.4 Mehrere gemeinsame Ressourcen: Deadlocks verhindern (Seite 134)

  5 Informationssicherheit
    5.1 Schwachstellen analysieren: Gefahren für IT-Systeme
    5.2 Systeme schützen: Maßnahmen der IT-Sicherheit

  6 Softwareentwicklung
    6.1 Im Team arbeiten: Agile Methoden
    6.2 Projekte organisieren: Das Wasserfallmodell
    6.3 Das Rad nicht neu erfinden: Bibliotheken nutzen
    6.4 Grafische Benutzeroberflächen
    6.5 Daten persistent speichern: Datenbank oder Datei
    6.6 Das Entwurfsmuster MVC
    6.7 Debuggen und Testen
    6.8 Softwarequalität aus Entwicklersicht
    6.9 Versionsverwaltungssysteme
    6.10 Projektvorschläge
```

### `isb` (Staatsinstitut für Schulqualität und Bildungsforschung)

#### `isb/abitur`

z. B. `isb/abitur/pruefung_2024/inf1/aufgabe_i/teilaufgabe_04/schwerionen_zerfall/Datenknoten.java`

#### `isb/handreichung_10_2008`

Handreichung Informatik 10, 2008: Informatik am Naturwissenschaftlich-technologischen Gymnasium Jahrgangsstufe 10

```yml
reference_title: Handreichung Informatik 10
reference_subtitle:
  Informatik am Naturwissenschaftlich-technologischen Gymnasium
  Jahrgangsstufe 10
author: Elke Frey, Christian Heidrich, Christian Scheungrab, Matthias Spohrer, Albert Wiedemann
year: 2008
publisher: >-
  Staatsinstitut für Schulqualität und Bildungsforschung München (ISB)
```

#### `isb/handreichung_11_2009`

Handreichung Informatik 11, 2009: Informatik am Naturwissenschaftlich-technologischen Gymnasium Jahrgangsstufe 11

```yml
reference_title: Handreichung Informatik 11
reference_subtitle:
  Informatik am Naturwissenschaftlich-technologischen Gymnasium
  Jahrgangsstufe 11
author: Dr. Petra Schwaiger, Dr. Andrea Bierschneider-Jacobs, Ulrich Freiberger, Albert Wiedemann, Stefan Winter
year: 2009
publisher: >-
  Staatsinstitut für Schulqualität und Bildungsforschung München (ISB)
```

#### `isb/handreichung_12_2010`

Handreichung Informatik 12, 2010: Informatik am Naturwissenschaftlich-technologischen Gymnasium Jahrgangsstufe 12

```yml
reference_title: Handreichung Informatik 12
reference_subtitle: >-
  Informatik am Naturwissenschaftlich-technologischen Gymnasium
  Jahrgangsstufe 12
publisher: >-
  Staatsinstitut für Schulqualität und Bildungsforschung München (ISB)
year: 2010
author: >-
  Dr. Petra Schwaiger, Dr. Siglinde Voß, Andreas Wagner, Albert
  Wiedemann, Stefan Winter
```

### `klett`

#### `klett/informatik_2_2021`

Informatik 2, 2021: Tabellenkalkulationssysteme, Datenbanken, Objektorientiere Programmierung, Datenschutz | Ausgabe Bayern ab 2018 | Klassen 9/10

```yml
reference_title: Informatik 2
reference_subtitle: >-
  Tabellenkalkulationssysteme, Datenbanken, Objektorientiere
  Programmierung, Datenschutz |
  Ausgabe Bayern ab 2018 |
  Klassen 9/10
author: >-
  Prof. Dr. Peter Hubwieser, Alexander Ruf, Dr. Matthias Spohrer, Dr.
  Siglinde Voß, Ferdinand Winhard
release_date: 2021
isbn: 978-3-12-731141-9
publisher: Klett
publisher_website: https://www.klett.de/produkt/isbn/978-3-12-731141-9
approval_number: 170/21-G+
approval_date: 29.06.2021
```

### `oldenbourg`

#### `oldenbourg/informatik_oberstufe_1_2009`

Informatik Oberstufe 1, 2009: Datenstrukturen und Softwareentwicklung

```yml
reference_title: Informatik Oberstufe 1
reference_subtitle: Datenstrukturen und Softwareentwicklung
publisher: Oldenbourg
author: Peter Brichzin, Ulrich Freiberger, Klaus Reinold, Albert Wiedemann
release_date: 2009
isbn: 978-3-637-00160-2
approval_number: 83/09-G
approval_date: 02.07.2009
```

#### `oldenbourg/informatik_oberstufe_2_2010`

Informatik Oberstufe 2, 2010: Maschinenkommunikation, Theoretische Informatik

```yml
reference_title: Informatik Oberstufe 2
reference_subtitle: Maschinenkommunikation, Theoretische Informatik
publisher: Oldenbourg
author: Peter Brichzin, Ulrich Freiberger, Klaus Reinold, Albert Wiedemann
release_date: 2010
isbn: 978-3-637-00830-4
approval_number: 61/10-G
approval_date: 06.07.2010
```

### `paetec` (Duden Paetec)

#### `paetec/informatik_10_2008`

Informatik 10, 2008: Gymnasium Bayern - 10. Jahrgangsstufe

```yml
reference_title: Informatik 10
reference_subtitle: Gymnasium Bayern - 10. Jahrgangsstufe
author: Matthias Ehmann, Frank Fiedler, Franz Xaver Forman, Manuel Friedrich, Ute Heuer, Susanne Ritzer
isbn: 978-3-835-56002-4
year: 2008
publisher: Duden Paetec / Buchner
```

## `package-info.java`

### `kapitel_xx`

```java
/**
 * Kapitel <b></b> <em></em> (Seite )
 */
package kapitel_xx;
```

```java
/**
 * Kapitel <b>I</b> <em>Die rekursive Datenstruktur Liste</em> (Seite 13)
 */
package kapitel_xx;
```

### `thema_xx`

```java
/**
 * Thema <b></b> <em></em> (Seite )
 */
package thema_xx;

```java
/**
 * Thema <b>1.1</b> <em>Einführung der Datenstruktur Schlange</em> (Seite 5)
 */
package thema_xx;
```

### `aufgabe_xx`

Vorsicht mit Satzzeichen innerhalb von `<em>`.

```java
/**
 * Aufgabe <b>3</b> (Seite 10): <em>Patientenverwaltung im Wartezimmer - Teil
 * 1</em>.
 *
 * <ol>
 * <li>
 * Setzen Sie das erweiterte Klassendiagramm aus Abbildung 7 in ein Programm
 * um. Implementieren Sie die Methoden und testen Sie ausführlich!
 * </li>
 *
 * <li>
 * Entwickeln Sie eine geeignete Oberfläche für die Ein- und Ausgabe!
 * </li>
 * </ol>
 */
package aufgabe_xx;
```

### `teilaufgabe_xx`

```java
/**
 * Teilaufgabe 4<b>b</b>: Stellen Sie ähnliche
 * Überlegungen wie bei a) und b) für die vorliegende Kreuzungssimulation an.
 */
package teilaufgabe_xx;
```

## Abhängigkeiten

`dpkg -L greenfoot`

```
mvn install:install-file \
   -Dfile=.jars/greenfoot-3.7.0.jar \
   -DgroupId=greenfoot \
   -DartifactId=greenfoot \
   -Dversion=3.7.0 \
   -Dpackaging=jar \
   -DgeneratePom=true
```

```
mvn install:install-file \
   -Dfile=.jars/Engine.Alpha-3.2.0.jar \
   -DgroupId=ea.edu \
   -DartifactId=AlphaEngine \
   -Dversion=3.2.0 \
   -Dpackaging=jar \
   -DgeneratePom=true
```

# Formatierung

```
mvn package
```
