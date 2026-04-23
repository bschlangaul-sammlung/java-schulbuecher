/**
 * 4 Einfache Grafik
 *
 * <p>
 * Für viele Darstellungen ist ein grobes Raster der Elemente z.B. von 10
 * Punkten günstiger. Dazu muss die Einheit in Positions- und Längenangaben 10
 * Punkte bedeuten.
 * </p>
 *
 * <ol>
 * <li>a Erstelle eine Klasse RASTERRECHTECK, die von RECHTECK erbt, und ergänze
 * die Methode PositionSetzen so, dass als Koordinaten nur ganzzahlige Vielfache
 * von 10 verwendet werden, d.h., der Parameter 5 für x bedeutet jetzt die
 * fünfte Rasterlinie; die Spitze des grünen Dreiecks rechts hat die Position
 * (2|5). Teste die neue Methode.</li>
 *
 * <li>b Ergänze in der Klasse RASTERRECHTECK die Methode GrößeSetzen so, dass
 * als Breite und Höhe nur ganzzahlige Vielfache von 10 verwendet werden; die
 * neuen Parameter geben also Breite und Höhe in Kästchen an. Teste wieder.</li>
 *
 * <li>c Benenne Situationen, in denen diese grobe Rasterung der Positionen und
 * Größen sinnvoll ist. Analysiere dann alle Methoden der Klasse RECHTECK und
 * überprüfe, welche noch überschrieben werden müssen, um das Kästchenraster
 * vollständig zu unterstützen.</li>
 *
 * <li>d Betrachte nun auch die Klassen KREIS und DREIECK. Erstelle zwei Klassen
 * RASTERDREIECK und RASTERKREIS, in denen du alle Methoden entsprechend
 * überschreibst, die an das 10er-Raster angepasst werden müssen.</li>
 *
 * <li>e Erstelle mit den neuen Klassen eine kleine Grafik und prüfe, dass die
 * Einzelfiguren gut zusammenpassen.</li>
 * </ol>
 */
package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_05.aufgabe_04.einfache_grafik;
