package org.bschlangaul.schulbuecher.cornelsen.informatik_5_2023.kapitel_04.thema_02.aufgabe_01.autokennzeichen;

import java.util.ArrayList;

/**
 * Ein Programm, das Fragen nach Ortskürzeln mit dem passenden Ort beantwortet.
 * Daten der KfZ-Kennzeichen CC-BY Berlin Open Data
 * https://berlinonline.github.io/berlin-legacy-datasets/data/kfz-kennz-d.csv
 * bzw.
 * https://www.govdata.de/web/guest/suchen/-/details/kfz-kennzeichen-deutschland3785e
 *
 * @author (Stefan Seegerer, Peter Brichzin)
 *
 * @version (18.5.23)
 */
public class Kennzeichen_KI
{
    ArrayList<Kennzeichen> kennzeichenliste;

    int ergebnisIndex;

    Kennzeichen_KI()
    {
        kennzeichenliste = new ArrayList<Kennzeichen>();
        KennzeichenEinlesen();
        ergebnisIndex = -1; // -1 bedeutet noch kein Treffer
    }

    // TODO Der Rumpf dieser Methode muss ergänzt werden.
    // Zugriff auf das i-te Kennzeichen in der Liste über
    // kennzeichenliste.get(i).OertskuerzelGeben()
    // Zugriff auf den i-ten Ort in der Liste über
    // kennzeichenliste.get(i).OrtGeben()
    /**
     * Methode OrtZuKennzeichenAusgeben gibt den Ort zum eingegebenen
     * Kennzeichen aus.
     *
     * @param kennzeichen
     */
    void OrtZuKennzeichenAusgeben(String kennzeichen)
    {
        ergebnisIndex = -1; // -1 bedeutet noch kein Treffer
        for (int i = 0; i < kennzeichenliste.size(); i = i + 1) // HInweis für
                                                                // Schnelle:
                                                                // Über eine
                                                                // bedingte
                                                                // Wiederholung
                                                                // kann man die
                                                                // Suche noch
                                                                // effizienter
                                                                // gestalten
                                                                // (Abbruch der
                                                                // Wiederholungsanweisung,
                                                                // wenn das
                                                                // Kennzeichen
                                                                // gefunden
                                                                // wurde).
        {
            if (ergebnisIndex < 0 && kennzeichen == kennzeichenliste.get(i)
                    .OertskuerzelGeben())
            {
                ergebnisIndex = i;
            }

        }

        if (ergebnisIndex >= 0)
        {
            System.out.println("Klar, weiß ich das! Der Ort zum Kennzeichen ");
            System.out.println(
                    kennzeichenliste.get(ergebnisIndex).OertskuerzelGeben()
                            + " ist "
                            + kennzeichenliste.get(ergebnisIndex).OrtGeben()
                            + " .");
        }
        else
        {
            System.out.println(
                    "Da muss ich passen. Bist du sicher, dass das ein KFZ Kennzeichen ist?");
        }
    }

    /**
     * Methode KennzeichenEinlesen dient zum Einlesen aller deutschen
     * Autokennzeichen nach CC-BY Berlin Open Data
     * https://berlinonline.github.io/berlin-legacy-datasets/data/kfz-kennz-d.csv
     *
     */
    private void KennzeichenEinlesen()
    {
        kennzeichenliste.add(new Kennzeichen("A", "Augsburg"));
        kennzeichenliste.add(new Kennzeichen("AA", "Aalen Ostalbkreis"));
        kennzeichenliste.add(new Kennzeichen("AB", "Aschaffenburg"));
        kennzeichenliste.add(new Kennzeichen("ABI", "Anhalt-Bitterfeld"));
        kennzeichenliste.add(new Kennzeichen("ABG", "Altenburger Land"));
        kennzeichenliste.add(new Kennzeichen("AC", "Aachen"));
        kennzeichenliste.add(new Kennzeichen("AE", "Auerbach"));
        kennzeichenliste.add(new Kennzeichen("AIC", "Aichach-Friedberg"));
        kennzeichenliste.add(new Kennzeichen("AK", "Altenkirchen/Westerwald"));
        kennzeichenliste.add(new Kennzeichen("AM", "Amberg"));
        kennzeichenliste.add(new Kennzeichen("AN", "Ansbach"));
        kennzeichenliste.add(new Kennzeichen("AÖ", "Altötting"));
        kennzeichenliste.add(new Kennzeichen("AP", "Apolda - Weimarer Land"));
        kennzeichenliste.add(new Kennzeichen("AS", "Amberg-Sulzbach"));
        kennzeichenliste.add(new Kennzeichen("AUR", "Aurich"));
        kennzeichenliste.add(new Kennzeichen("AW", "Bad Neuenahr-Ahrweiler"));
        kennzeichenliste.add(new Kennzeichen("AZ", "Alzey-Worms"));
        kennzeichenliste.add(new Kennzeichen("B", "Berlin"));
        kennzeichenliste.add(new Kennzeichen("BA", "Bamberg"));
        kennzeichenliste.add(new Kennzeichen("BAD", "Baden-Baden"));
        kennzeichenliste.add(new Kennzeichen("BAR", "Barnim"));
        kennzeichenliste.add(new Kennzeichen("BB", "Böblingen"));
        kennzeichenliste.add(new Kennzeichen("BC", "Biberach/Riß"));
        kennzeichenliste.add(
                new Kennzeichen("BD", "Bundestag, Bundesrat, Bundesregierung"));
        kennzeichenliste.add(new Kennzeichen("BGL", "Berchtesgadener Land"));
        kennzeichenliste.add(new Kennzeichen("BI", "Bielefeld"));
        kennzeichenliste.add(
                new Kennzeichen("BIR", "Birkenfeld/Nahe und Idar-Oberstein"));
        kennzeichenliste.add(new Kennzeichen("BIT", "Bitburg-Prüm"));
        kennzeichenliste.add(new Kennzeichen("BK", "Bochum"));
        kennzeichenliste
                .add(new Kennzeichen("BL", "Zollernalbkreis / Balingen"));
        kennzeichenliste.add(new Kennzeichen("BLK", "Burgenlandkreis"));
        kennzeichenliste.add(new Kennzeichen("BM", "Erftkreis / Bergheim"));
        kennzeichenliste.add(new Kennzeichen("BN", "Bonn"));
        kennzeichenliste.add(new Kennzeichen("BO", "Bochum"));
        kennzeichenliste.add(new Kennzeichen("BOR", "Borken / Ahaus"));
        kennzeichenliste.add(new Kennzeichen("BOT", "Bottrop"));
        kennzeichenliste.add(new Kennzeichen("BP", "Bundespolizei"));
        kennzeichenliste.add(new Kennzeichen("BRA", "Wesermarsch / Brake"));
        kennzeichenliste.add(new Kennzeichen("BRB", "Brandenburg"));
        kennzeichenliste.add(new Kennzeichen("BS", "Braunschweig"));
        kennzeichenliste.add(new Kennzeichen("BT", "Bayreuth"));
        kennzeichenliste.add(new Kennzeichen("BTF", "Bitterfeld"));
        kennzeichenliste.add(new Kennzeichen("BÜS", "Büsingen am Hochrhein"));
        kennzeichenliste.add(new Kennzeichen("BW",
                "Bundes-Wasser- und Schiffahrtsverwaltung"));
        kennzeichenliste.add(new Kennzeichen("BWL",
                "Baden-Württemberg Landesregierung und Landtag"));
        kennzeichenliste.add(
                new Kennzeichen("BYL", "Bayern Landesregierung und Landtag"));
        kennzeichenliste.add(new Kennzeichen("BZ", "Bautzen"));
        kennzeichenliste.add(new Kennzeichen("C", "Chemnitz"));
        kennzeichenliste.add(new Kennzeichen("CB", "Cottbus"));
        kennzeichenliste.add(new Kennzeichen("CE", "Celle"));
        kennzeichenliste.add(new Kennzeichen("CHA", "Cham"));
        kennzeichenliste.add(new Kennzeichen("CO", "Coburg"));
        kennzeichenliste.add(new Kennzeichen("COC", "Cochem-Zell"));
        kennzeichenliste.add(new Kennzeichen("COE", "Coesfeld"));
        kennzeichenliste.add(new Kennzeichen("CUX", "Cuxhaven"));
        kennzeichenliste.add(new Kennzeichen("CW", "Calw"));
        kennzeichenliste.add(new Kennzeichen("D", "Düsseldorf"));
        kennzeichenliste.add(new Kennzeichen("DA", "Darmstadt-Dieburg"));
        kennzeichenliste.add(new Kennzeichen("DAH", "Dachau"));
        kennzeichenliste.add(new Kennzeichen("DAN", "Lüchow-Dannenberg"));
        kennzeichenliste.add(new Kennzeichen("DAU", "Daun (Eifel)"));
        kennzeichenliste.add(new Kennzeichen("DBR", "Bad Doberan"));
        kennzeichenliste.add(new Kennzeichen("DD", "Dresden"));
        kennzeichenliste.add(new Kennzeichen("DE", "Dessau-Roßlau"));
        kennzeichenliste.add(new Kennzeichen("DEG", "Deggendorf"));
        kennzeichenliste.add(new Kennzeichen("DEL", "Delmenhorst"));
        kennzeichenliste.add(new Kennzeichen("DGF", "Dingolfing-Landau"));
        kennzeichenliste.add(new Kennzeichen("DH", "Diepholz-Syke"));
        kennzeichenliste.add(new Kennzeichen("DL", "Döbeln"));
        kennzeichenliste.add(new Kennzeichen("DLG", "Dillingen"));
        kennzeichenliste.add(new Kennzeichen("DN", "Düren"));
        kennzeichenliste.add(new Kennzeichen("Do", "Dortmund"));
        kennzeichenliste.add(new Kennzeichen("DON", "Donauwörth"));
        kennzeichenliste.add(new Kennzeichen("DU", "Duisburg"));
        kennzeichenliste.add(
                new Kennzeichen("DÜW", "Bad Dürkheim / Neustadt/Weinstraße"));
        kennzeichenliste.add(new Kennzeichen("E", "Essen"));
        kennzeichenliste.add(new Kennzeichen("EA", "Eisenach"));
        kennzeichenliste.add(new Kennzeichen("EB", "Eilenburg"));
        kennzeichenliste.add(new Kennzeichen("EBE", "Ebersberg"));
        kennzeichenliste.add(new Kennzeichen("ED", "Erding"));
        kennzeichenliste.add(new Kennzeichen("EE", "Elbe-Elsterkreis"));
        kennzeichenliste.add(new Kennzeichen("EF", "Erfurt"));
        kennzeichenliste.add(new Kennzeichen("EI", "Eichstätt"));
        kennzeichenliste.add(new Kennzeichen("EIC", "Eichsfeld"));
        kennzeichenliste.add(new Kennzeichen("EL", "Emsland"));
        kennzeichenliste.add(new Kennzeichen("EM", "Emmendingen"));
        kennzeichenliste.add(new Kennzeichen("EMD", "Emden"));
        kennzeichenliste.add(new Kennzeichen("EMS", "Bad Ems/Lahn-Kreis"));
        kennzeichenliste.add(new Kennzeichen("EN", "Ennepe-Ruhr-Kreis"));
        kennzeichenliste.add(new Kennzeichen("ER", "Erlangen"));
        kennzeichenliste.add(new Kennzeichen("ERB", "Erbach/Odenwaldkreis"));
        kennzeichenliste.add(new Kennzeichen("ERH", "Erlangen-Höchstadt"));
        kennzeichenliste.add(new Kennzeichen("ERZ", "Erzgebirgskreis"));
        kennzeichenliste.add(new Kennzeichen("ES", "Esslingen"));
        kennzeichenliste.add(new Kennzeichen("ESW", "Eschwege"));
        kennzeichenliste.add(new Kennzeichen("EU", "Euskirchen"));
        kennzeichenliste.add(new Kennzeichen("F", "Frankfurt/Main"));
        kennzeichenliste.add(new Kennzeichen("FB", "Friedberg/Wetteraukreis"));
        kennzeichenliste.add(new Kennzeichen("FD", "Fulda"));
        kennzeichenliste.add(new Kennzeichen("FDS", "Freudenstadt"));
        kennzeichenliste.add(new Kennzeichen("FF", "Frankfurt/Oder"));
        kennzeichenliste.add(new Kennzeichen("FFB", "Fürstenfeldbruck"));
        kennzeichenliste.add(new Kennzeichen("FG", "Freiberg"));
        kennzeichenliste.add(new Kennzeichen("FL", "Flensburg"));
        kennzeichenliste
                .add(new Kennzeichen("FN", "Friedrichshafen/Bodenseekreis"));
        kennzeichenliste.add(new Kennzeichen("FO", "Forchheim"));
        kennzeichenliste.add(new Kennzeichen("FR", "Freiburg"));
        kennzeichenliste.add(new Kennzeichen("FRG", "Freyung-Grafenau"));
        kennzeichenliste.add(new Kennzeichen("FRI", "Friesland"));
        kennzeichenliste.add(new Kennzeichen("FS", "Freising"));
        kennzeichenliste.add(new Kennzeichen("FT", "Frankenthal"));
        kennzeichenliste.add(new Kennzeichen("FÜ", "Fürth"));
        kennzeichenliste.add(new Kennzeichen("G", "Gera"));
        kennzeichenliste.add(new Kennzeichen("GAP", "Garmisch-Partenkirchen"));
        kennzeichenliste.add(new Kennzeichen("GE", "Gelsenkirchen"));
        kennzeichenliste.add(new Kennzeichen("GER", "Germersheim"));
        kennzeichenliste.add(new Kennzeichen("GF", "Gifhorn"));
        kennzeichenliste.add(new Kennzeichen("GG", "Groß-Gerau"));
        kennzeichenliste.add(new Kennzeichen("GI", "Gießen"));
        kennzeichenliste.add(new Kennzeichen("GL", "Bergisch Gladbach"));
        kennzeichenliste.add(new Kennzeichen("GM", "Gummersbach"));
        kennzeichenliste.add(new Kennzeichen("GÖ", "Göttingen"));
        kennzeichenliste.add(new Kennzeichen("GP", "Göppingen"));
        kennzeichenliste.add(new Kennzeichen("GR", "Görlitz"));
        kennzeichenliste.add(new Kennzeichen("GRZ", "Greiz"));
        kennzeichenliste.add(new Kennzeichen("GS", "Goslar"));
        kennzeichenliste.add(new Kennzeichen("GT", "Gütersloh"));
        kennzeichenliste.add(new Kennzeichen("GTH", "Gotha"));
        kennzeichenliste.add(new Kennzeichen("GÜ", "Güstrow"));
        kennzeichenliste.add(new Kennzeichen("GZ", "Günzburg"));
        kennzeichenliste.add(new Kennzeichen("H", "Hannover"));
        kennzeichenliste.add(new Kennzeichen("HA", "Hagen"));
        kennzeichenliste.add(new Kennzeichen("HAL", "Halle"));
        kennzeichenliste.add(new Kennzeichen("HAM", "Hamm"));
        kennzeichenliste.add(new Kennzeichen("HAS", "Haßberge / Haßfurt"));
        kennzeichenliste
                .add(new Kennzeichen("HB", "Hansestadt Bremen/Bremerhaven"));
        kennzeichenliste.add(new Kennzeichen("HBN", "Hildburghausen"));
        kennzeichenliste.add(new Kennzeichen("HD", "Heidelberg"));
        kennzeichenliste.add(new Kennzeichen("HDH", "Heidenheim"));
        kennzeichenliste.add(new Kennzeichen("HE", "Helmstedt"));
        kennzeichenliste.add(new Kennzeichen("HEF", "Bad Hersfeld"));
        kennzeichenliste.add(new Kennzeichen("HEI", "Heide"));
        kennzeichenliste.add(
                new Kennzeichen("HEL", "Hessen Landesregierung und Landtag"));
        kennzeichenliste.add(new Kennzeichen("HER", "Herne"));
        kennzeichenliste.add(new Kennzeichen("HF", "Herford"));
        kennzeichenliste.add(new Kennzeichen("HG", "Bad Homburg"));
        kennzeichenliste.add(new Kennzeichen("HGW", "Hansestadt Greifswald"));
        kennzeichenliste.add(new Kennzeichen("HH", "Hansestadt Hamburg"));
        kennzeichenliste.add(new Kennzeichen("HI", "Hildesheim"));
        kennzeichenliste.add(new Kennzeichen("HL", "Hansestadt Lübeck"));
        kennzeichenliste.add(new Kennzeichen("HM", "Hameln-Pyrmont"));
        kennzeichenliste.add(new Kennzeichen("HN", "Heilbronn"));
        kennzeichenliste.add(new Kennzeichen("HO", "Hof"));
        kennzeichenliste.add(new Kennzeichen("HOL", "Holzminden"));
        kennzeichenliste.add(new Kennzeichen("HOM", "Homburg"));
        kennzeichenliste.add(new Kennzeichen("HP", "Heppenheim"));
        kennzeichenliste.add(new Kennzeichen("HR", "Homberg"));
        kennzeichenliste.add(new Kennzeichen("HRO", "Hansestadt Rostock"));
        kennzeichenliste.add(new Kennzeichen("HS", "Heinsberg"));
        kennzeichenliste.add(new Kennzeichen("HSK", "Hochsauerlandkreis"));
        kennzeichenliste.add(new Kennzeichen("HST", "Hansestadt Stralsund"));
        kennzeichenliste.add(new Kennzeichen("HU", "Hanau"));
        kennzeichenliste.add(new Kennzeichen("HVL", "Havelland"));
        kennzeichenliste.add(new Kennzeichen("HWI", "Hansestadt Wismar"));
        kennzeichenliste.add(new Kennzeichen("HX", "Höxter"));
        kennzeichenliste.add(new Kennzeichen("HZ", "Harz"));
        kennzeichenliste.add(new Kennzeichen("IGB", "St. Ingbert"));
        kennzeichenliste.add(new Kennzeichen("IK", "Ilm-Kreis"));
        kennzeichenliste.add(new Kennzeichen("IN", "Ingolstadt"));
        kennzeichenliste.add(new Kennzeichen("IZ", "Itzehoe"));
        kennzeichenliste.add(new Kennzeichen("J", "Jena"));
        kennzeichenliste.add(new Kennzeichen("JL", "Jerichower Land"));
        kennzeichenliste.add(new Kennzeichen("K", "Köln"));
        kennzeichenliste.add(new Kennzeichen("KA", "Karlsruhe"));
        kennzeichenliste.add(new Kennzeichen("KB", "Korbach"));
        kennzeichenliste.add(new Kennzeichen("KC", "Kronach"));
        kennzeichenliste.add(new Kennzeichen("KE", "Kempten"));
        kennzeichenliste.add(new Kennzeichen("KEH", "Kelheim"));
        kennzeichenliste.add(new Kennzeichen("KF", "Kaufbeuren"));
        kennzeichenliste.add(new Kennzeichen("KG", "Bad Kissingen"));
        kennzeichenliste.add(new Kennzeichen("KH", "Bad Kreuznach"));
        kennzeichenliste.add(new Kennzeichen("KI", "Kiel"));
        kennzeichenliste.add(new Kennzeichen("KIB", "Kirchheimbolanden"));
        kennzeichenliste.add(new Kennzeichen("KL", "Kaiserslautern"));
        kennzeichenliste.add(new Kennzeichen("KLE", "Kleve"));
        kennzeichenliste.add(new Kennzeichen("KN", "Konstanz"));
        kennzeichenliste.add(new Kennzeichen("KO", "Koblenz"));
        kennzeichenliste.add(new Kennzeichen("KR", "Krefeld"));
        kennzeichenliste.add(new Kennzeichen("KS", "Kassel"));
        kennzeichenliste.add(new Kennzeichen("KT", "Kitzingen"));
        kennzeichenliste.add(new Kennzeichen("KU", "Kulmbach"));
        kennzeichenliste.add(new Kennzeichen("KÜN", "Künzelsau"));
        kennzeichenliste.add(new Kennzeichen("KUS", "Kusel"));
        kennzeichenliste.add(new Kennzeichen("KYF", "Kyffhäuserkreis"));
        kennzeichenliste.add(new Kennzeichen("L", "Leipzig"));
        kennzeichenliste.add(new Kennzeichen("LA", "Landshut"));
        kennzeichenliste.add(new Kennzeichen("LAU", "Lauf/Nürnberger Land"));
        kennzeichenliste.add(new Kennzeichen("LB", "Ludwigsburg"));
        kennzeichenliste.add(new Kennzeichen("LD", "Landau"));
        kennzeichenliste.add(new Kennzeichen("LDK", "Lahn-Dill-Kreis"));
        kennzeichenliste.add(new Kennzeichen("LDS", "Dahme-Spreewald"));
        kennzeichenliste.add(new Kennzeichen("LER", "Leer/Ostfriesland"));
        kennzeichenliste.add(new Kennzeichen("LEV", "Leverkusen"));
        kennzeichenliste.add(new Kennzeichen("LG", "Lüneburg"));
        kennzeichenliste.add(new Kennzeichen("LI", "Lindau"));
        kennzeichenliste.add(new Kennzeichen("LIF", "Lichtenfels"));
        kennzeichenliste.add(new Kennzeichen("LIP", "Lippe"));
        kennzeichenliste.add(new Kennzeichen("LL", "Landsberg/Lech"));
        kennzeichenliste.add(new Kennzeichen("LM", "Limburg-Weilburg"));
        kennzeichenliste.add(new Kennzeichen("LÖ", "Lörrach"));
        kennzeichenliste
                .add(new Kennzeichen("LOS", "Oder-Spree-Kreis Beeskow"));
        kennzeichenliste.add(new Kennzeichen("LRO", "Landkreis Rostock"));
        kennzeichenliste.add(new Kennzeichen("LSA",
                "Sachsen-Anhalt Landesregierung und Landtag"));
        kennzeichenliste.add(
                new Kennzeichen("LSN", "Sachsen Landesregierung und Landtag"));
        kennzeichenliste.add(new Kennzeichen("LU", "Ludwigshafen"));
        kennzeichenliste.add(new Kennzeichen("LWL", "Ludwigslust"));
        kennzeichenliste.add(new Kennzeichen("M", "München"));
        kennzeichenliste.add(new Kennzeichen("MA", "Mannheim"));
        kennzeichenliste.add(new Kennzeichen("MB", "Miesbach"));
        kennzeichenliste.add(new Kennzeichen("MD", "Magdeburg"));
        kennzeichenliste.add(new Kennzeichen("ME", "Mettmann"));
        kennzeichenliste.add(new Kennzeichen("MEI", "Meißen"));
        kennzeichenliste.add(new Kennzeichen("MG", "Mönchengladbach"));
        kennzeichenliste.add(new Kennzeichen("MI", "Minden-Lübbecke"));
        kennzeichenliste.add(new Kennzeichen("MIL", "Miltenberg"));
        kennzeichenliste.add(new Kennzeichen("MK", "Märkischer Kreis"));
        kennzeichenliste.add(new Kennzeichen("MKK", "Main-Kinzig-Kreis"));
        kennzeichenliste.add(new Kennzeichen("MM", "Memmingen"));
        kennzeichenliste.add(new Kennzeichen("MN", "Mindelheim"));
        kennzeichenliste.add(new Kennzeichen("MOL", "Märkisch-Oderland"));
        kennzeichenliste.add(new Kennzeichen("MOS", "Mosbach"));
        kennzeichenliste.add(new Kennzeichen("MR", "Marburg-Biedenkopf"));
        kennzeichenliste.add(new Kennzeichen("MS", "Münster"));
        kennzeichenliste.add(new Kennzeichen("MSH", "Mansfeld-Südharz"));
        kennzeichenliste.add(new Kennzeichen("MSP", "Main-Spessart-Kreis"));
        kennzeichenliste.add(new Kennzeichen("MST", "Mecklenburg-Strelitz"));
        kennzeichenliste.add(new Kennzeichen("MTK", "Main-Taunus-Kreis"));
        kennzeichenliste.add(new Kennzeichen("MÜ", "Mühldorf am Inn"));
        kennzeichenliste.add(new Kennzeichen("MÜR", "Müritz"));
        kennzeichenliste.add(new Kennzeichen("MVL",
                "Mecklenburg-Vorpommern Landesregierung und Landtag"));
        kennzeichenliste.add(new Kennzeichen("MYK", "Mayen-Koblenz"));
        kennzeichenliste.add(new Kennzeichen("MZ", "Mainz"));
        kennzeichenliste.add(new Kennzeichen("MZG", "Merzig-Wadern"));
        kennzeichenliste.add(new Kennzeichen("N", "Nürnberg"));
        kennzeichenliste.add(new Kennzeichen("NB", "Neubrandenburg"));
        kennzeichenliste.add(new Kennzeichen("ND", "Neuburg-Schrobenhausen"));
        kennzeichenliste.add(new Kennzeichen("NDH", "Nordhausen"));
        kennzeichenliste.add(new Kennzeichen("NE", "Neuss"));
        kennzeichenliste
                .add(new Kennzeichen("NEA", "Neustadt-Bad Windsheim/Aisch"));
        kennzeichenliste.add(new Kennzeichen("NES", "Bad Neustadt/Saale"));
        kennzeichenliste.add(new Kennzeichen("NEW", "Neustadt/Waldnaab"));
        kennzeichenliste.add(new Kennzeichen("NF", "Nordfriesland"));
        kennzeichenliste.add(new Kennzeichen("NI", "Nienburg"));
        kennzeichenliste.add(new Kennzeichen("NK", "Neunkirchen"));
        kennzeichenliste.add(new Kennzeichen("NL",
                "Niedersachsen Landesregierung und Landtag"));
        kennzeichenliste.add(new Kennzeichen("NM", "Neumarkt/Oberpfalz"));
        kennzeichenliste.add(new Kennzeichen("NMS", "Neumünster"));
        kennzeichenliste.add(new Kennzeichen("NOH", "Nordhorn"));
        kennzeichenliste.add(new Kennzeichen("NOM", "Northeim"));
        kennzeichenliste.add(new Kennzeichen("NR", "Neuwied"));
        kennzeichenliste.add(new Kennzeichen("Nordrhein-Westfalen",
                "Nordrhein-Westfalen Landesregierung und Landtag"));
        kennzeichenliste.add(new Kennzeichen("NU", "Neu-Ulm"));
        kennzeichenliste.add(new Kennzeichen("NVP", "Nordvorpommern"));
        kennzeichenliste.add(new Kennzeichen("NW", "Neustadt/Weinstraße"));
        kennzeichenliste.add(new Kennzeichen("NWM", "Nordwestmecklenburg"));
        kennzeichenliste.add(new Kennzeichen("OA", "Oberallgäu / Sonthofen"));
        kennzeichenliste.add(new Kennzeichen("OAL", "Ostallgäu"));
        kennzeichenliste.add(new Kennzeichen("OB", "Oberhausen"));
        kennzeichenliste.add(new Kennzeichen("OD", "Bad Oldesloe"));
        kennzeichenliste.add(new Kennzeichen("OE", "Olpe"));
        kennzeichenliste.add(new Kennzeichen("OF", "Offenbach/Main"));
        kennzeichenliste.add(new Kennzeichen("OG", "Offenburg"));
        kennzeichenliste.add(new Kennzeichen("OH", "Ostholstein / Eutin"));
        kennzeichenliste.add(new Kennzeichen("OHA", "Osterode/Harz"));
        kennzeichenliste.add(new Kennzeichen("OHV", "Oberhavel"));
        kennzeichenliste.add(new Kennzeichen("OHZ", "Osterholz-Scharmbeck"));
        kennzeichenliste.add(new Kennzeichen("OL", "Oldenburg"));
        kennzeichenliste.add(new Kennzeichen("OPR", "Ostprignitz-Ruppin"));
        kennzeichenliste.add(new Kennzeichen("OS", "Osnabrück"));
        kennzeichenliste.add(new Kennzeichen("OSL", "Oberspreewald-Lausitz"));
        kennzeichenliste.add(new Kennzeichen("OVP", "Ostvorpommern"));
        kennzeichenliste.add(new Kennzeichen("P", "Potsdam"));
        kennzeichenliste.add(new Kennzeichen("PA", "Passau"));
        kennzeichenliste.add(new Kennzeichen("PAF", "Pfaffenhofen"));
        kennzeichenliste.add(new Kennzeichen("PAN", "Pfarrkirchen"));
        kennzeichenliste.add(new Kennzeichen("PB", "Paderborn"));
        kennzeichenliste.add(new Kennzeichen("PCH", "Parchim"));
        kennzeichenliste.add(new Kennzeichen("PE", "Peine"));
        kennzeichenliste.add(new Kennzeichen("PF", "Pforzheim"));
        kennzeichenliste.add(new Kennzeichen("PI", "Pinneberg"));
        kennzeichenliste
                .add(new Kennzeichen("PIR", "Pirna/Sächsische Schweiz"));
        kennzeichenliste.add(new Kennzeichen("PLÖ", "Plön"));
        kennzeichenliste.add(new Kennzeichen("PM", "Potsdam-Mittelmark"));
        kennzeichenliste.add(new Kennzeichen("PR", "Prignitz / Perleberg"));
        kennzeichenliste.add(new Kennzeichen("PS", "Pirmasens"));
        kennzeichenliste.add(new Kennzeichen("R", "Regensburg"));
        kennzeichenliste.add(new Kennzeichen("RA", "Rastatt"));
        kennzeichenliste.add(new Kennzeichen("RD", "Rendsburg-Eckernförde"));
        kennzeichenliste.add(new Kennzeichen("RE", "Recklinghausen"));
        kennzeichenliste.add(new Kennzeichen("REG", "Regen"));
        kennzeichenliste.add(new Kennzeichen("RO", "Rosenheim"));
        kennzeichenliste.add(new Kennzeichen("ROS", "Rostock/Landkreis"));
        kennzeichenliste.add(new Kennzeichen("ROW", "Rotenburg/Wümme"));
        kennzeichenliste.add(new Kennzeichen("RP", "Rhein-Pfalz-Kreis"));
        kennzeichenliste.add(new Kennzeichen("RPL",
                "Rheinland-Pfalzlz Landesregierung und Landtag"));
        kennzeichenliste.add(new Kennzeichen("RS", "Remscheid"));
        kennzeichenliste.add(new Kennzeichen("RT", "Reutlingen"));
        kennzeichenliste.add(new Kennzeichen("RÜD", "Rüdesheim"));
        kennzeichenliste.add(new Kennzeichen("RÜG", "Rügen"));
        kennzeichenliste.add(new Kennzeichen("RV", "Ravensburg"));
        kennzeichenliste.add(new Kennzeichen("RW", "Rottweil"));
        kennzeichenliste.add(new Kennzeichen("RZ", "Ratzeburg"));
        kennzeichenliste.add(new Kennzeichen("S", "Stuttgart"));
        kennzeichenliste.add(new Kennzeichen("SAD", "Schwandorf"));
        kennzeichenliste.add(
                new Kennzeichen("SAL", "Saarland Landesregierung und Landtag"));
        kennzeichenliste.add(new Kennzeichen("SAW", "Salzwedel"));
        kennzeichenliste.add(new Kennzeichen("SB", "Saarbrücken"));
        kennzeichenliste.add(new Kennzeichen("SC", "Schwabach"));
        kennzeichenliste.add(new Kennzeichen("SDL", "Stendal"));
        kennzeichenliste.add(new Kennzeichen("SE", "Bad Segeberg"));
        kennzeichenliste.add(new Kennzeichen("SG", "Solingen"));
        kennzeichenliste.add(new Kennzeichen("SH",
                "Schleswig-Holstein Landesregierung und Landtag"));
        kennzeichenliste.add(new Kennzeichen("SHA", "Schwäbisch Hall"));
        kennzeichenliste.add(new Kennzeichen("SHG", "Stadthagen"));
        kennzeichenliste.add(new Kennzeichen("SHK", "Saale-Holzlandkreis"));
        kennzeichenliste.add(new Kennzeichen("SHL", "Suhl"));
        kennzeichenliste.add(new Kennzeichen("SI", "Siegen-Wittgenstein"));
        kennzeichenliste.add(new Kennzeichen("SIG", "Sigmaringen"));
        kennzeichenliste.add(new Kennzeichen("SIM", "Rhein-Hunsrück-Kreis"));
        kennzeichenliste.add(new Kennzeichen("SK", "Saalkreis"));
        kennzeichenliste.add(new Kennzeichen("SL", "Schleswig-Flensburg"));
        kennzeichenliste.add(new Kennzeichen("SLF", "Saalfeld-Rudolstadt"));
        kennzeichenliste.add(new Kennzeichen("SLK", "Salzlandkreis"));
        kennzeichenliste.add(new Kennzeichen("SLS", "Saarlouis"));
        kennzeichenliste.add(new Kennzeichen("SM", "Schmalkalden-Meiningen"));
        kennzeichenliste.add(new Kennzeichen("SN", "Schwerin"));
        kennzeichenliste.add(new Kennzeichen("SO", "Soest"));
        kennzeichenliste.add(new Kennzeichen("SOK", "Saale-Orla-Kreis"));
        kennzeichenliste.add(new Kennzeichen("SÖM", "Sömmerda"));
        kennzeichenliste.add(new Kennzeichen("SON", "Sonneberg"));
        kennzeichenliste.add(new Kennzeichen("SP", "Speyer"));
        kennzeichenliste.add(new Kennzeichen("SPN", "Spree-Neiße"));
        kennzeichenliste.add(new Kennzeichen("SR", "Straubing-Bogen"));
        kennzeichenliste.add(new Kennzeichen("ST", "Steinfurt"));
        kennzeichenliste.add(new Kennzeichen("STA", "Starnberg"));
        kennzeichenliste.add(new Kennzeichen("STD", "Stade"));
        kennzeichenliste.add(new Kennzeichen("SU", "Siegburg"));
        kennzeichenliste.add(new Kennzeichen("SÜW", "Südliche Weinstraße"));
        kennzeichenliste.add(new Kennzeichen("SW", "Schweinfurt"));
        kennzeichenliste.add(new Kennzeichen("SZ", "Salzgitter"));
        kennzeichenliste.add(new Kennzeichen("TDO", "Nordsachsen"));
        kennzeichenliste.add(new Kennzeichen("TBB", "Tauberbischofsheim"));
        kennzeichenliste.add(new Kennzeichen("TF", "Teltow-Fläming"));
        kennzeichenliste.add(new Kennzeichen("TG", "Torgau"));
        kennzeichenliste.add(new Kennzeichen("THL",
                "Thüringen Landesregierung und Landtag"));
        kennzeichenliste.add(new Kennzeichen("THW", "Technisches Hilfswerk"));
        kennzeichenliste.add(new Kennzeichen("TIR", "Tirschenreuth"));
        kennzeichenliste.add(new Kennzeichen("TÖL", "Bad Tölz"));
        kennzeichenliste.add(new Kennzeichen("TR", "Trier"));
        kennzeichenliste.add(new Kennzeichen("TS", "Traunstein"));
        kennzeichenliste.add(new Kennzeichen("TÜ", "Tübingen"));
        kennzeichenliste.add(new Kennzeichen("TUT", "Tuttlingen"));
        kennzeichenliste.add(new Kennzeichen("UE", "Uelzen"));
        kennzeichenliste.add(new Kennzeichen("UL", "Ulm"));
        kennzeichenliste.add(new Kennzeichen("UM", "Uckermark"));
        kennzeichenliste.add(new Kennzeichen("UN", "Unna"));
        kennzeichenliste.add(new Kennzeichen("V", "Vogtlandkreis"));
        kennzeichenliste.add(new Kennzeichen("VB", "Vogelsbergkreis"));
        kennzeichenliste.add(new Kennzeichen("VEC", "Vechta"));
        kennzeichenliste.add(new Kennzeichen("VER", "Verden"));
        kennzeichenliste.add(new Kennzeichen("VIE", "Viersen"));
        kennzeichenliste.add(new Kennzeichen("VK", "Völklingen"));
        kennzeichenliste.add(new Kennzeichen("VR", "Vorpommern-Rügen"));
        kennzeichenliste.add(new Kennzeichen("VS", "Villingen-Schwenningen"));
        kennzeichenliste.add(new Kennzeichen("W", "Wuppertal"));
        kennzeichenliste.add(new Kennzeichen("WAF", "Warendorf"));
        kennzeichenliste.add(new Kennzeichen("WAK", "Wartburgkreis"));
        kennzeichenliste.add(new Kennzeichen("WB", "Wittenberg"));
        kennzeichenliste.add(new Kennzeichen("WE", "Weimar"));
        kennzeichenliste.add(new Kennzeichen("WEN", "Weiden"));
        kennzeichenliste.add(new Kennzeichen("WES", "Wesel"));
        kennzeichenliste.add(new Kennzeichen("WF", "Wolfenbüttel"));
        kennzeichenliste.add(new Kennzeichen("WHV", "Wilhelmshaven"));
        kennzeichenliste.add(new Kennzeichen("WI", "Wiesbaden"));
        kennzeichenliste.add(new Kennzeichen("WIL", "Wittlich"));
        kennzeichenliste.add(new Kennzeichen("WL", "Winsen/Luhe"));
        kennzeichenliste.add(new Kennzeichen("WM", "Weilheim-Schongau"));
        kennzeichenliste.add(new Kennzeichen("WN", "Waiblingen"));
        kennzeichenliste.add(new Kennzeichen("WND", "St. Wendel"));
        kennzeichenliste.add(new Kennzeichen("WO", "Worms"));
        kennzeichenliste.add(new Kennzeichen("WOB", "Wolfsburg"));
        kennzeichenliste.add(new Kennzeichen("WST", "Westerstede"));
        kennzeichenliste.add(new Kennzeichen("WT", "Waldshut-Tiengen"));
        kennzeichenliste.add(new Kennzeichen("WTM", "Wittmund"));
        kennzeichenliste.add(new Kennzeichen("WÜ", "Würzburg"));
        kennzeichenliste.add(new Kennzeichen("WUG", "Weißenburg-Gunzenhausen"));
        kennzeichenliste.add(new Kennzeichen("WUN", "Wunsiedel"));
        kennzeichenliste.add(new Kennzeichen("WW", "Westerwald"));
        kennzeichenliste.add(new Kennzeichen("WZ", "Wetzlar"));
        kennzeichenliste.add(new Kennzeichen("Y", "Bundeswehr"));
        kennzeichenliste.add(new Kennzeichen("Z", "Zwickau"));
        kennzeichenliste.add(new Kennzeichen("ZW", "Zweibrücken"));
    }

}
