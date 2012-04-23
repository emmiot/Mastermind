package my.mastermind;

/**
 * Luokasta voi tehdä sekä peli- että palautenappuloita. Pelin sisäinen
 * mekaniikka hoitaa tarkistukset parametrien oikeellisuudesta.
 *
 * @author Emmi Otava
 */
public class Nappula {

    private String vari;

    // Käyttäjä syöttää värin nappulaa painamalla eli syötteen oikeellisuus jää pelin sisällä toteutettavaksi.
    // Siksi väri asetetaan suoraan ilman kummempaa syötteentarkistusta.
    
    /**
     * Luo olion ja asettaa sille halutun värin.
     *
     * @param haluttuVari
     */
    public Nappula(String haluttuVari) {
        vari = haluttuVari;
    }

    /**
     * Palauttaa nappulan värin.
     * @return 
     */
    public String getVari() {
        return vari;
    }
    
    @Override
    public String toString() {
        return vari;
    }
}