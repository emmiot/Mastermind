package my.mastermind;

import java.awt.Color;
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
    Rivi rivi2;
    Rivi rivi3;
    Rivi rivi4;
    Rivi oikeaRivi;
    Rivi palauteRivi;
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
        peli = new Pelimekaniikka();
        ui = new MastermindUI(peli);
        tietokone = new Tietokone();
        rivi = new Rivi();
        rivi.aseta(0, Color.BLUE);
        rivi.aseta(1, Color.RED);
        rivi.aseta(2, Color.BLUE);
        rivi.aseta(3, Color.BLACK);
        oikeaRivi = new Rivi();
        oikeaRivi.aseta(0, Color.YELLOW);
        oikeaRivi.aseta(1, Color.GREEN);
        oikeaRivi.aseta(2, Color.BLACK);
        oikeaRivi.aseta(3, Color.GREEN);
        tietokone.asetaOikeaRivi(oikeaRivi);
        rivi2 = new Rivi();
        rivi2.aseta(0, Color.RED);
        rivi2.aseta(1, Color.YELLOW);
        rivi2.aseta(2, Color.BLUE);
        rivi2.aseta(3, Color.BLUE);
        rivi3 = new Rivi();
        rivi3.aseta(0, Color.GREEN);
        rivi3.aseta(1, Color.YELLOW);
        rivi3.aseta(2, Color.BLACK);
        rivi3.aseta(3, Color.GREEN);
        rivi4 = new Rivi();
        rivi4.aseta(0, Color.BLUE);
        rivi4.aseta(1, Color.BLUE);
        rivi4.aseta(2, Color.BLACK);
        rivi4.aseta(3, Color.WHITE);

    }

    @After
    public void tearDown() {
    }

    // Pelimekaniikka testit -----------
    // ------------ Pelimekaniikka testit
    // Tietokone testit -----------
    @Test
    public void rivinTarkistusAntaaValkoisen() {
        palauteRivi = tietokone.tarkistaRivi(rivi2);
        assertTrue(palauteRivi.getVari(0).equals(Color.WHITE) && rivi.getVari(1) != null && rivi.getVari(2) != null && rivi.getVari(3) != null);
    }

    @Test
    public void rivinTarkistusAntaaMustan() {
        palauteRivi = tietokone.tarkistaRivi(rivi4);
        assertTrue(palauteRivi.getVari(0).equals(Color.BLACK) && rivi.getVari(1) != null && rivi.getVari(2) != null && rivi.getVari(3) != null);
    }

    @Test
    public void rivinTarkistusTarkistaaMelkeinOikean() {
        palauteRivi = tietokone.tarkistaRivi(rivi3);
        palauteRivi.tulosta();
        assertTrue(palauteRivi.getVari(0).equals(Color.BLACK) && palauteRivi.getVari(1).equals(Color.BLACK) && palauteRivi.getVari(2).equals(Color.WHITE) && palauteRivi.getVari(3).equals(Color.WHITE));
    }
    // ------------ Tietokone testit

    // Rivi testit ---------
    @Test
    public void teeRivi() {
        assertTrue(rivi.getVari(0) != null && rivi.getVari(1) != null && rivi.getVari(2) != null && rivi.getVari(3) != null);
    }

    @Test
    public void etsiVariJaLoyda() {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista = rivi.etsiVari(Color.BLACK);
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void etsiVariJaEiLoydy() {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista = rivi.etsiVari(Color.WHITE);
        assertTrue(lista.isEmpty());
    }
    // --------- Rivi testit
}
