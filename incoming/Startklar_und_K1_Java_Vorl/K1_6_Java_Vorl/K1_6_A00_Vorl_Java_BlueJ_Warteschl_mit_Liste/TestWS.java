

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class TestWS.
 *
 * @author  Klaus Reinold
 * @version 1.0
 */
public class TestWS
{
    private Warteschlange wartesch1;
    private Patient patient1;
    private Patient patient2;
    private Patient patient3;
    private Darstellung darstell1;
    private Patient patient4;
    private Patient patient5;
    private Patient patient6;
    private Patient patient7;
    private Patient patient8;

    
    
    
    
    

    
    
    
    

    /**
     * Default constructor for test class TestWS
     */
    public TestWS()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        wartesch1 = new Warteschlange();
        patient1 = new Patient("Hugo");
        patient2 = new Patient("Emil");
        patient3 = new Patient("Kasimir");
        wartesch1.Einfügen(patient1);
        wartesch1.Einfügen(patient2);
        wartesch1.Einfügen(patient3);
        darstell1 = new Darstellung(wartesch1);
        darstell1.Anzeigen();
        patient4 = new Patient("Nummer4");
        patient5 = new Patient("Nummer5");
        patient6 = new Patient("Nummer6");
        patient7 = new Patient("Nummer7");
        patient8 = new Patient("Nummer8");
        wartesch1.Einfügen(patient4);
        wartesch1.Einfügen(patient5);
        wartesch1.Einfügen(patient6);
        wartesch1.Einfügen(patient7);
        wartesch1.Einfügen(patient8);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
