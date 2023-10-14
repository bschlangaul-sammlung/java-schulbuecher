# java-schulbuecher

Java-Code-Beispiele aus verschiedenen Schulbüchern

## Ordner-Struktur

`kapitel_01` -> `thema_01` -> `aufgabe_01` -> `teilaufgabe_a`

Ohne dem Suffix `_vorlage` handelt es sich um die Lösung:

- Lösung: `buchner/informatik_9_2021/kapitel_05/thema_04/hasenjagd`
- Vorlage für die Schüler: `buchner/informatik_9_2021/kapitel_05/thema_04/hasenjagd_vorlage`

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

```
mvn install:install-file \
   -Dfile=.jars/Engine.Alpha-4.jar \
   -DgroupId=ea.edu \
   -DartifactId=AlphaEngine \
   -Dversion=4.0.0 \
   -Dpackaging=jar \
   -DgeneratePom=true
```

### javakarol

```
mvn install:install-file \
   -Dfile=.jars/javakarol-3.0.jar \
   -DgroupId=javakarol \
   -DartifactId=javakarol \
   -Dversion=3.0 \
   -Dpackaging=jar \
   -DgeneratePom=true
```

# Formatierung

eclipse-formatter.xml

```
mvn formatter:format
```
