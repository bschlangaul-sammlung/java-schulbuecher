package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.adressverwaltung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Stellt die Methoden zum Zugriff auf die Datenbank zur Verfügung.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class DATENBANKVERBINDUNG implements MELDUNGSERZEUGER
{
    /**
     * Speichert das einzige Objekt der Klasse DATENBANKVERBINDUNG.
     */
    private static DATENBANKVERBINDUNG verb = new DATENBANKVERBINDUNG();

    /**
     * Speichert die Verbindung zur Datenbank.
     */
    private Connection conn;

    /**
     * Die Meldungsbeobachter
     */
    private ArrayList<MELDUNGSBEOBACHTER> allebeobachter;

    /**
     * Baut die Verbindung zur Datenbank auf.
     */
    private DATENBANKVERBINDUNG()
    {
        allebeobachter = new ArrayList<MELDUNGSBEOBACHTER>();
        try
        {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor()
                    .newInstance();
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/adressverwaltung?user=adress&password=verwaltung");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Meldet das Verbindungsobjekt.
     *
     * @return verbindug
     */
    static DATENBANKVERBINDUNG VerbindungGeben()
    {
        return verb;
    }

    /**
     * Registriert einen Beobachter beim Produzenten.
     *
     * @param beobachter der neue Beobachter
     */
    public void Registrieren(MELDUNGSBEOBACHTER beobachter)
    {
        allebeobachter.add(beobachter);
    }

    /**
     * Meldet einen Beobachter beim Produzenten ab.
     *
     * @param beobachter der abzumeldende Beobachter
     */
    public void Abmelden(MELDUNGSBEOBACHTER beobachter)
    {
        allebeobachter.remove(beobachter);
    }

    /**
     * Meldet die Ausnahemsituation an alle Beobachter
     *
     * @param e die Ausnahemsituation
     */
    private void ExceptionMelden(Exception e)
    {
        StackTraceElement[] stack = e.getStackTrace();
        for (MELDUNGSBEOBACHTER b : allebeobachter)
        {
            b.FehlermeldungEmpfangen(e.getMessage());
            for (int i = 0; i < stack.length; i++)
            {
                b.FehlermeldungEmpfangen(stack[i].toString());
            }
        }
    }

    /**
     * Meldet einen Fehler an alle Beobachter
     *
     * @param text der Fehler
     */
    @SuppressWarnings("unused")
    private void FehlerMelden(String text)
    {
        for (MELDUNGSBEOBACHTER b : allebeobachter)
        {
            b.FehlermeldungEmpfangen(text);
        }
    }

    /**
     * Beendet die Verbindung, danach ist Schluss.
     */
    void VerbindungBeenden()
    {
        try
        {
            conn.close();
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Holt die Daten aller Personen.
     *
     * @param personen Liste zum Abspeichern der Daten
     */
    void PersonenHolen(LISTE personen)
    {
        Statement st, st2;
        ResultSet rs, rs2;
        try
        {
            st = conn.createStatement();
            st2 = conn.createStatement();
            rs = st.executeQuery(
                    "SELECT personennummer, name, vorname, adressnummer FROM person");
            while (rs.next())
            {
                rs2 = st2.executeQuery(
                        "SELECT strasse, hausnummer, plz, ort FROM adresse WHERE adressnummer = "
                                + rs.getInt("adressnummer"));
                if (rs2.next())
                {
                    personen.Einfuegen(new PERSON(rs.getInt("personennummer"),
                            rs.getString("name"), rs.getString("vorname"),
                            rs.getInt("adressnummer"), rs2.getString("strasse"),
                            rs2.getString("hausnummer"), rs2.getString("plz"),
                            rs2.getString("ort")));
                }
                rs2.close();
            }
            rs.close();
            st.close();
            st2.close();
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Holt die Telefonnummern der angegebenen Person.
     *
     * @param nummern Liste zum Abspeichern der Daten
     * @param personennummer Schlüssel der Person
     */
    void TelefonnummernHolen(LISTE nummern, int personennummer)
    {
        Statement st;
        ResultSet rs;
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery(
                    "SELECT lfnr, nummer, notiz, art FROM telefon WHERE personennummer = "
                            + personennummer);
            while (rs.next())
            {
                nummern.Einfuegen(new TELEFON(personennummer, rs.getInt("lfnr"),
                        rs.getString("nummer"), rs.getString("notiz"),
                        rs.getString("art")));
            }
            rs.close();
            st.close();
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Holt die E-Mail-Adressen der angegebenen Person.
     *
     * @param adressen Liste zum Abspeichern der Daten
     * @param personennummer Schlüssel der Person
     */
    void EMailadressenHolen(LISTE adressen, int personennummer)
    {
        Statement st;
        ResultSet rs;
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery(
                    "SELECT lfnr, email, notiz FROM email WHERE personennummer = "
                            + personennummer);
            while (rs.next())
            {
                adressen.Einfuegen(new EMAIL(personennummer, rs.getInt("lfnr"),
                        rs.getString("email"), rs.getString("notiz")));
            }
            rs.close();
            st.close();
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Setzt den Personendatenanteil einer Person.
     *
     * @param person die Person
     *
     * @return Erfolgsmeldung
     */
    boolean PersonendatenAendern(PERSON person)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE person SET Name = '" + person.NameGeben()
                    + "', Vorname = '" + person.VornameGeben()
                    + "' WHERE Personennummer = " + person.NummerGeben());
            st.close();
            return true;
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
            return false;
        }
    }

    /**
     * Legt den Datenanteil einer Person neu an.
     *
     * @param person die Person
     *
     * @return Erfolgsmeldung
     */
    boolean PersonAnlegen(PERSON person)
    {
        try
        {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            st.executeUpdate(
                    "INSERT INTO person (Name, Vorname, Adressnummer) VALUES ('"
                            + person.NameGeben() + "',  '"
                            + person.VornameGeben() + "',  "
                            + person.AdressNummerGeben() + ")");
            rs = st.executeQuery("SELECT MAX(Personennummer) FROM person");
            if (rs.next())
            {
                int nummer = rs.getInt(1);
                person.PersonenNummerSetzen(nummer);
            }
            rs.close();
            st.close();
            return true;
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
            return false;
        }
    }

    /**
     * Löscht die Person.
     *
     * @param person die Person
     *
     * @return Erfolgsmeldung
     */
    boolean PersonLoeschen(PERSON person)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM person WHERE Personennummer = "
                    + person.NummerGeben());
            st.close();
            return true;
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
            return false;
        }
    }

    /**
     * Setzt den Adressdatenanteil einer Person.
     *
     * @param person die Person
     *
     * @return Erfolgsmeldung
     */
    boolean AdressdatenAendern(PERSON person)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE adresse SET Strasse = '"
                    + person.StrasseGeben() + "', Hausnummer = '"
                    + person.HausnummerGeben() + "', PLZ = '"
                    + person.PlzGeben() + "', Ort = '" + person.OrtGeben()
                    + "' WHERE Adressnummer = " + person.AdressNummerGeben());
            st.close();
            return true;
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
            return false;
        }
    }

    /**
     * Legt den Adressdatenanteil einer Person neu an.
     *
     * @param person die Person
     *
     * @return Erfolgsmeldung
     */
    boolean AdressdatenAnlegen(PERSON person)
    {
        try
        {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            st.executeUpdate(
                    "INSERT INTO adresse (Strasse, Hausnummer, PLZ, Ort) VALUES ('"
                            + person.StrasseGeben() + "',  '"
                            + person.HausnummerGeben() + "',  '"
                            + person.PlzGeben() + "', '" + person.OrtGeben()
                            + "')");
            rs = st.executeQuery("SELECT MAX(Adressnummer) FROM adresse");
            if (rs.next())
            {
                int nummer = rs.getInt(1);
                person.AdressNummerSetzen(nummer);
                st.executeUpdate("UPDATE person SET Adressnummer = " + nummer
                        + " WHERE Personennummer = " + person.NummerGeben());
            }
            else
            {
                person.AdressNummerSetzen(-1);
            }
            rs.close();
            st.close();
            return true;
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
            return false;
        }
    }

    /**
     * Legt den Adressdatenanteil einer Person neu an.
     *
     * @param person die Person
     *
     * @return Erfolgsmeldung
     */
    boolean AdressdatenUebernehmen(PERSON person)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE person SET Adressnummer = "
                    + person.AdressNummerGeben() + " WHERE Personennummer = "
                    + person.NummerGeben());
            st.close();
            return true;
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
            return false;
        }
    }

    /**
     * ändert eine Telefonnummer.
     *
     * @param telefon die Nummernbeschreibung
     *
     * @return Erfolgsmeldung
     */
    boolean TelefonAendern(TELEFON telefon)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate(
                    "UPDATE telefon SET Nummer = '" + telefon.NummerGeben()
                            + "', Art = '" + telefon.ArtGeben() + "', Notiz = '"
                            + telefon.NotizGeben() + "' WHERE Personennummer = "
                            + telefon.PersonenNummerGeben() + " AND Lfnr = "
                            + telefon.LaufendeNummerGeben());
            st.close();
            return true;
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
            return false;
        }
    }

    /**
     * Legt eine Telefonnummer neu an.
     *
     * @param telefon die Nummernbeschreibung
     *
     * @return Erfolgsmeldung
     */
    boolean TelefonAnlegen(TELEFON telefon)
    {
        Statement st;
        ResultSet rs;
        int lfnr;
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery(
                    "SELECT MAX(Lfnr) FROM telefon WHERE Personennummer = "
                            + telefon.PersonenNummerGeben());
            if (rs.next())
            {
                lfnr = rs.getInt(1) + 1;
            }
            else
            {
                lfnr = -1;
            }
            telefon.LaufendeNummerSetzen(lfnr);
            st.executeUpdate(
                    "INSERT INTO telefon (Personennummer, Lfnr, Nummer, Art, Notiz) VALUES ("
                            + telefon.PersonenNummerGeben() + ", " + lfnr
                            + ", '" + telefon.NummerGeben() + "', '"
                            + telefon.ArtGeben() + "', '" + telefon.NotizGeben()
                            + "')");
            st.close();
            return true;
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
            return false;
        }
    }

    /**
     * Löscht eine Telefonnummer.
     *
     * @param telefon die Nummernbeschreibung
     *
     * @return Erfolgsmeldung
     */
    boolean TelefonLoeschen(TELEFON telefon)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM telefon WHERE Personennummer = "
                    + telefon.PersonenNummerGeben() + " AND Lfnr = "
                    + telefon.LaufendeNummerGeben());
            st.close();
            return true;
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
            return false;
        }
    }

    /**
     * ändert eine Emailadresse.
     *
     * @param email die Adressbeschreibung
     *
     * @return Erfolgsmeldung
     */
    boolean EmailAendern(EMAIL email)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE email SET EMail = '" + email.AdresseGeben()
                    + "', Notiz = '" + email.NotizGeben()
                    + "' WHERE Personennummer = " + email.PersonenNummerGeben()
                    + " AND Lfnr = " + email.LaufendeNummerGeben());
            st.close();
            return true;
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
            return false;
        }
    }

    /**
     * Legt eine Mailadresse neu an.
     *
     * @param email die Adressbeschreibung
     *
     * @return Erfolgsmeldung
     */
    boolean EmailAnlegen(EMAIL email)
    {
        Statement st;
        ResultSet rs;
        int lfnr;
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery(
                    "SELECT MAX(Lfnr) FROM email WHERE Personennummer = "
                            + email.PersonenNummerGeben());
            if (rs.next())
            {
                lfnr = rs.getInt(1) + 1;
            }
            else
            {
                lfnr = -1;
            }
            email.LaufendeNummerSetzen(lfnr);
            st.executeUpdate(
                    "INSERT INTO email (Personennummer, Lfnr, EMail, Notiz) VALUES ("
                            + email.PersonenNummerGeben() + ", " + lfnr + ", '"
                            + email.AdresseGeben() + "', '" + email.NotizGeben()
                            + "')");
            st.close();
            return true;
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
            return false;
        }
    }

    /**
     * Löscht eine Mailadresse.
     *
     * @param email die Adressbeschreibung
     *
     * @return Erfolgsmeldung
     */
    boolean EmailLoeschen(EMAIL email)
    {
        try
        {
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM email WHERE Personennummer = "
                    + email.PersonenNummerGeben() + " AND Lfnr = "
                    + email.LaufendeNummerGeben());
            st.close();
            return true;
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
            return false;
        }
    }

    /**
     * Entfernt alle nicht mehr referenzierten Adressbeschreibungen
     *
     * @return Anzahl der gelöschten Einträge
     */
    int AdressenBereinigen()
    {
        try
        {
            Statement st = conn.createStatement();
            int res = st.executeUpdate(
                    "DELETE FROM adresse WHERE NOT (Adressnummer IN (SELECT DISTINCT Adressnummer FROM person))");
            st.close();
            return res;
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
            return -1;
        }
    }

    /**
     * Holt die Daten aller Personen mit gegebenem Vornamensteil.
     *
     * @param personen Liste zum Abspeichern der Daten
     * @param text das Suchkriterium
     */
    void VornamenSuchen(LISTE personen, String text)
    {
        Statement st, st2;
        ResultSet rs, rs2;
        try
        {
            st = conn.createStatement();
            st2 = conn.createStatement();
            rs = st.executeQuery(
                    "SELECT personennummer, name, vorname, adressnummer FROM person WHERE vorname LIKE '%"
                            + text + "%'");
            while (rs.next())
            {
                rs2 = st2.executeQuery(
                        "SELECT strasse, hausnummer, plz, ort FROM adresse WHERE adressnummer = "
                                + rs.getInt("adressnummer"));
                if (rs2.next())
                {
                    personen.Einfuegen(new PERSON(rs.getInt("personennummer"),
                            rs.getString("name"), rs.getString("vorname"),
                            rs.getInt("adressnummer"), rs2.getString("strasse"),
                            rs2.getString("hausnummer"), rs2.getString("plz"),
                            rs2.getString("ort")));
                }
                rs2.close();
            }
            rs.close();
            st.close();
            st2.close();
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Holt die Daten aller Personen mit gegebenem Vornamensteil.
     *
     * @param personen Liste zum Abspeichern der Daten
     * @param strasse Strassennamen(steil)
     * @param ort Ort(steil)
     */
    void AdresseSuchen(LISTE personen, String strasse, String ort)
    {
        Statement st;
        ResultSet rs;
        String bedingung;
        try
        {
            st = conn.createStatement();
            if (strasse == "")
            {
                bedingung = "ort LIKE '%" + ort + "%'";
            }
            else if (ort == "")
            {
                bedingung = "strasse LIKE '%" + strasse + "%'";
            }
            else
            {
                bedingung = "ort LIKE '%" + ort + "%' AND strasse LIKE '%"
                        + strasse + "%'";
            }
            rs = st.executeQuery(
                    "SELECT personennummer, name, vorname, person.adressnummer AS adressnummer, strasse, hausnummer, plz, ort FROM person, adresse "
                            + "WHERE person.adressnummer = adresse.adressnummer AND "
                            + bedingung);
            while (rs.next())
            {
                personen.Einfuegen(new PERSON(rs.getInt("personennummer"),
                        rs.getString("name"), rs.getString("vorname"),
                        rs.getInt("adressnummer"), rs.getString("strasse"),
                        rs.getString("hausnummer"), rs.getString("plz"),
                        rs.getString("ort")));
            }
            rs.close();
            st.close();
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Holt die Daten aller Personen mit gegebenem Telefonnummernteil.
     *
     * @param personen Liste zum Abspeichern der Daten
     * @param text das Suchkriterium
     */
    void NummerSuchen(LISTE personen, String text)
    {
        Statement st, st2;
        ResultSet rs, rs2;
        try
        {
            st = conn.createStatement();
            st2 = conn.createStatement();
            rs = st.executeQuery(
                    "SELECT personennummer, name, vorname, adressnummer FROM person WHERE personennummer IN "
                            + "(SELECT DISTINCT Personennummer FROM telefon WHERE nummer LIKE '%"
                            + text + "%')");
            while (rs.next())
            {
                rs2 = st2.executeQuery(
                        "SELECT strasse, hausnummer, plz, ort FROM adresse WHERE adressnummer = "
                                + rs.getInt("adressnummer"));
                if (rs2.next())
                {
                    personen.Einfuegen(new PERSON(rs.getInt("personennummer"),
                            rs.getString("name"), rs.getString("vorname"),
                            rs.getInt("adressnummer"), rs2.getString("strasse"),
                            rs2.getString("hausnummer"), rs2.getString("plz"),
                            rs2.getString("ort")));
                }
                rs2.close();
            }
            rs.close();
            st.close();
            st2.close();
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }

    /**
     * Holt die Daten aller Personen mit gegebenem Emailadressenteil.
     *
     * @param personen Liste zum Abspeichern der Daten
     * @param text das Suchkriterium
     */
    void EmailSuchen(LISTE personen, String text)
    {
        Statement st, st2;
        ResultSet rs, rs2;
        try
        {
            st = conn.createStatement();
            st2 = conn.createStatement();
            rs = st.executeQuery(
                    "SELECT personennummer, name, vorname, adressnummer FROM person WHERE personennummer IN "
                            + "(SELECT DISTINCT Personennummer FROM email WHERE Email LIKE '%"
                            + text + "%')");
            while (rs.next())
            {
                rs2 = st2.executeQuery(
                        "SELECT strasse, hausnummer, plz, ort FROM adresse WHERE adressnummer = "
                                + rs.getInt("adressnummer"));
                if (rs2.next())
                {
                    personen.Einfuegen(new PERSON(rs.getInt("personennummer"),
                            rs.getString("name"), rs.getString("vorname"),
                            rs.getInt("adressnummer"), rs2.getString("strasse"),
                            rs2.getString("hausnummer"), rs2.getString("plz"),
                            rs2.getString("ort")));
                }
                rs2.close();
            }
            rs.close();
            st.close();
            st2.close();
        }
        catch (Exception e)
        {
            ExceptionMelden(e);
        }
    }
}
