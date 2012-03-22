/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void teeRivi() {
        Rivi rivi = new Rivi();
        rivi.aseta(0, "sininen");
        rivi.aseta(1, "punainen");
        rivi.aseta(2, "musta");
        rivi.aseta(3, "sininen");
        assertTrue(rivi.getIndeksi(0) != null && rivi.getIndeksi(1) != null && rivi.getIndeksi(2) != null && rivi.getIndeksi(3) != null);
    }

    @Test
    public void variAsettuuOikein() {
        Pelinappula nappula = new Pelinappula("punainen");
        assertTrue(nappula.getVari().equals("punainen"));
    }

    @Test
    public void etsiVariJaLoyda() {
        Rivi rivi = new Rivi();
        ArrayList<Integer> lista = new ArrayList<Integer>();
        rivi.aseta(0, "sininen");
        rivi.aseta(1, "punainen");
        rivi.aseta(2, "sininen");
        rivi.aseta(3, "musta");
        lista = rivi.etsiVari("musta");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void etsiVariJaEiLoydy() {
        Rivi rivi = new Rivi();
        ArrayList<Integer> lista = new ArrayList<Integer>();
        rivi.aseta(0, "sininen");
        rivi.aseta(1, "punainen");
        rivi.aseta(2, "musta");
        rivi.aseta(3, "sininen");
        lista = rivi.etsiVari("valkoinen");
        assertTrue(lista.isEmpty());
    }
}
