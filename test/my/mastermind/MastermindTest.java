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
        oikeaRivi = new Rivi();
        oikeaRivi.aseta(0, "keltainen");
        oikeaRivi.aseta(1, "vihrea");
        oikeaRivi.aseta(2, "musta");
        oikeaRivi.aseta(3, "vihrea");
        tietokone.asetaOikeaRivi(oikeaRivi);
        rivi2 = new Rivi();
        rivi2.aseta(0, "punainen");
        rivi2.aseta(1, "keltainen");
        rivi2.aseta(2, "sininen");
        rivi2.aseta(3, "sininen");
        rivi3 = new Rivi();
        rivi3.aseta(0, "vihrea");
        rivi3.aseta(1, "keltainen");
        rivi3.aseta(2, "musta");
        rivi3.aseta(3, "vihrea");
        rivi4 = new Rivi();
        rivi4.aseta(0, "sininen");
        rivi4.aseta(1, "sininen");
        rivi4.aseta(2, "musta");
        rivi4.aseta(3, "valkoinen");

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
        assertTrue(palauteRivi.getNappula(0).getVari().equals("valkoinen") && rivi.getNappula(1) != null && rivi.getNappula(2) != null && rivi.getNappula(3) != null);
    }

    @Test
    public void rivinTarkistusAntaaMustan() {
        palauteRivi = tietokone.tarkistaRivi(rivi4);
        assertTrue(palauteRivi.getNappula(0).getVari().equals("musta") && rivi.getNappula(1) != null && rivi.getNappula(2) != null && rivi.getNappula(3) != null);
    }

    @Test
    public void rivinTarkistusTarkistaaMelkeinOikean() {
        palauteRivi = tietokone.tarkistaRivi(rivi3);
        palauteRivi.tulosta();
        assertTrue(palauteRivi.getNappula(0).getVari().equals("musta") && palauteRivi.getNappula(1).getVari().equals("musta") && palauteRivi.getNappula(2).getVari().equals("valkoinen") && palauteRivi.getNappula(3).getVari().equals("valkoinen"));
    }
    // ------------ Tietokone testit

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
