

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse Testklasse.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Testklasse
{
    private Patient patient1;
    private Patient patient2;
    private Liste patientenliste;

    /**
     * Konstruktor fuer die Test-Klasse Testklasse
     */
    public Testklasse()
    {
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @BeforeEach
    public void setUp()
    {
        patient1 = new Patient("Ben Deriss");
        patient2 = new Patient("Armin Gips");
        patient1.AktennotizHinzufügen("Beinbruch");
        patient1.AktennotizHinzufügen("Schnupfen");
        patient2.AktennotizHinzufügen("Husten");
        patient2.AktennotizHinzufügen("Bänderriss");
        patientenliste = new Liste();
        patientenliste.HintenEinfügen(patient1);
        patientenliste.HintenEinfügen(patient2);
        patientenliste.InformationAusgeben();
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
