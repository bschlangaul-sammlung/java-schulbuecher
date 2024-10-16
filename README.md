# java-schulbuecher

Java-Code-Beispiele und Java-Projekte aus verschiedenen Schulbüchern in einem
großen Java-Paket.

## Veränderungen / Anpassungen

- Der Code wurde neu formatiert, um einen einheitlichen Coding-Style (Einrückung
  entspricht vier Leerzeichen, öffnende Klammer startet in einer neuen Zeile) zu folgen.
- Klassennamen, die allschließlich Großbuchstaben verwenden, wurden umbenannt,
  damit sie der in der Java-Welt etablierten `UpperCamelCase`-Konvention
  entsprechen.
- Zusätzliche main-Methoden erlauben das einfache Starten der Projekte in der
  IDE.
- UTF-8
- HTML-Entities -> UTF-8
- Javadoc-Fehler ausbessern
- Deprecations beheben, z. B. `new Integer()` -> `Integer.valueOf()` oder `Integer.parseInt()`
- `*` Imports in einzelne Imports auflösen
- Unnötige Imports entfernt
- Rechtschreibfehler ausbessert
- Unterdrücken von Warnungen `@SupressWarning("unused")`

## Ordner-Struktur / Namensschema der Pakete

`kapitel_01` -> `thema_01` -> `aufgabe_01` -> `teilaufgabe_a`

Ohne suffix `_vorlage` handelt es sich um die Lösung

- Lösung: `buchner/informatik_9_2021/kapitel_05/thema_04/hasenjagd`
- Vorlage für die Schüler: `buchner/informatik_9_2021/kapitel_05/thema_04/hasenjagd_vorlage`

## Quellen

### `buchner`

#### `buchner/informatik_9_2021`

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

```yml
reference_title: Informatik 11
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

* [9. Jahrgangsstufe](https://informatikschulbuch.de/jahrgangsstufe-9-uebersicht/objektorientierte-modellierung-und-programmierung/)
* [10. Jahrgangsstufe](https://informatikschulbuch.de/jahrgangsstufe-10/objektorientierte-modellierung-und-programmierungjgst10/)
* [11. Jahrgangsstufe](https://informatikschulbuch.de/jahrgangsstufe-11/vernetze-strukturen-grapen-kapitel-1-informatik-5/)

#### `cornelsen/informatik-3_2017`

```yml
reference_title: Informatik 3
reference_subtitle: >-
  Funktionale Modellierung, Datenmodellierung, Objektorientierte
  Modellierung (Jgst. 9)
isbn: 978-3-637-02467-0
publisher: Cornelsen
author: Peter Brichzin, Franz Jetzinger
release_date: 2017
approval_number: 76/21-G+
approval_date: 28.05.2021
```

#### `cornelsen/informatik_5_2023`

```yml
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

```yml
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

```

### `isb` (Staatsinstitut für Schulqualität und Bildungsforschung)

#### `isb/handreichung_10_2008`

```yml
reference_title: Handreichung Informatik 10
reference_subtitle: Informatik am Naturwissenschaftlich-technologischen Gymnasium
  Jahrgangsstufe 10
author: Elke Frey, Christian Heidrich, Christian Scheungrab, Matthias Spohrer, Albert Wiedemann
year: 2008
publisher: >-
  Staatsinstitut für Schulqualität und Bildungsforschung München (ISB)
```

#### `isb/handreichung_11_2009`

```yml
reference_title: Handreichung Informatik 11
reference_subtitle: Informatik am Naturwissenschaftlich-technologischen Gymnasium
  Jahrgangsstufe 11
author: Dr. Petra Schwaiger, Dr. Andrea Bierschneider-Jacobs, Ulrich Freiberger, Albert Wiedemann, Stefan Winter
year: 2009
publisher: >-
  Staatsinstitut für Schulqualität und Bildungsforschung München (ISB)

```

#### `isb/handreichung_12_2010`

```yml
reference_title: Handreichung Informatik 12
reference_subtitle:  >-
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

```yml
reference_title: Informatik 10
reference_subtitle: Gymnasium Bayern - 10. Jahrgangsstufe
author:  Matthias Ehmann, Frank Fiedler, Franz Xaver Forman, Manuel Friedrich, Ute Heuer, Susanne Ritzer
isbn: 978-3-835-56002-4
year: 2008
publisher: Duden Paetec
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
