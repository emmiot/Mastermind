package my.mastermind;

import java.awt.Color;

/**
 * Luokasta voi tehdä sekä peli- että palautenappuloita. Pelin sisäinen
 * mekaniikka hoitaa tarkistukset parametrien oikeellisuudesta.
 *
 * @author Emmi Otava
 */
public class Nappula {

//    private String vari;
    private Color vari;

    // Käyttäjä syöttää värin nappulaa painamalla eli syötteen oikeellisuus jää pelin sisällä toteutettavaksi.
    // Siksi väri asetetaan suoraan ilman kummempaa syötteentarkistusta.
    /**
     * Luo olion ja asettaa sille halutun värin.
     *
     * @param haluttuVari
     */
//    public Nappula(String haluttuVari) {
//        vari = haluttuVari;
//    }
    public Nappula(Color haluttuVari) {
        vari = haluttuVari;
    }

    /**
     * Palauttaa nappulan värin.
     *
     * @return
     */
//    public String getVari() {
//        return vari;
//    }

    public Color getVari() {
        return vari;
    }
}