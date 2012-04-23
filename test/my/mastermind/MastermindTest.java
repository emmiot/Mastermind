
package my.mastermind;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Emmi Otava
 */
public class MastermindTest {

    public MastermindTest() {
    }
    
    
    Rivi rivi;
    Kayttoliittyma kayttis;
    Pelimekaniikka peli;
    Tietokone tietokone;
    MastermindUI ui;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        kayttis = new Tekstikayttoliittyma();
        ui = new MastermindUI();
//        peli = new Pelimekaniikka(ui);
        peli = new Pelimekaniikka(kayttis);
        tietokone = new Tietokone();
        rivi = new Rivi();
        rivi.aseta(0, "sininen");
        rivi.aseta(1, "punainen");
        rivi.aseta(2, "sininen");
        rivi.aseta(3, "musta");
    }

    @After
    public void tearDown() {
    }

    // Pelimekaniikka testit -----------
    
    
    
    
    // ------------ Pelimekaniikka testit
    
    // Rivi testit ---------
    @Test
    public void teeRivi() {
        assertTrue(rivi.getNappula(0) != null && rivi.getNappula(1) != null && rivi.getNappula(2) != null && rivi.getNappula(3) != null);
    }

    @Test
    public void etsiVariJaLoyda() {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista = rivi.etsiVari("musta");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void etsiVariJaEiLoydy() {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista = rivi.etsiVari("valkoinen");
        assertTrue(lista.isEmpty());
    }

    // --------- Rivi testit
    
    // Nappula testit ---------
    @Test
    public void variAsettuuOikein() {
        Nappula nappula = new Nappula("punainen");
        assertTrue(nappula.getVari().equals("punainen"));
    }
    // --------- Nappula testit
}

