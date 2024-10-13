# java-schulbuecher

Java-Code-Beispiele und Java-Projekte aus verschiedenen Schulbüchern in einem
großen Java-Paket.

## Ordner-Struktur / Namensschema der Pakete

`kapitel_01` -> `thema_01` -> `aufgabe_01` -> `teilaufgabe_a`

Ohne suffix `_vorlage` handelt es sich um die Lösung

- Lösung: `buchner/informatik_9_2021/kapitel_05/thema_04/hasenjagd`
- Vorlage für die Schüler: `buchner/informatik_9_2021/kapitel_05/thema_04/hasenjagd_vorlage`

## Quellen

### Buchner-Verlag

#### `informatik_9_2021`

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
```

#### `informatik_10_2022`

```yml
folder: buchner/informatik_10_2022
reference_title: Informatik 10
reference_subtitle: Gymnasium Bayern (NTG)
isbn: 978-3-661-38010-0
publisher: Buchner
release_date: 2022
author: >-
    Dieter Bergmann, André Greubel, Verena Haller, Peter Mahns, Thomas
    Rau, Julia Reitberger, Wolfgang Riffelmacher, Ulrich Schneider, Anja
    Stube, Hilmar Vogel und Barbara Wieczorek
```

### Cornelsen

```yml
folder: cornelsen/informatik-3_2017
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

### ISB

```yml
folder: isb/handreichung_10
```

```yml
folder: isb/handreichung_11
```

```yml
folder: isb/handreichung_12
```



```yml
folder: oldenbourg/informatik-oberstufe-1_2009
reference_title: Informatik Oberstufe 1
reference_subtitle: Datenstrukturen und Softwareentwicklung
publisher: Oldenbourg
author: Peter Brichzin, Ulrich Freiberger, Klaus Reinold, Albert Wiedemann
release_date: 2009
isbn: 978-3-637-00160-2
approval_number: 83/09-G
approval_date: 02.07.2009
```

```yml
folder: oldenbourg/informatik-oberstufe-2_2010
reference_title: Informatik Oberstufe 2
reference_subtitle: Maschinenkommunikation, Theoretische Informatik
publisher: Oldenbourg
author: Peter Brichzin, Ulrich Freiberger, Klaus Reinold, Albert Wiedemann
release_date: 2010
isbn: 978-3-637-00830-4
approval_number: 61/10-G
approval_date: 06.07.2010
```

```yml
folder: paetec/informatik_10_2008
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

eclipse-formatter.xml

```
mvn formatter:format
```
