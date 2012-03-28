package my.mastermind;

import java.util.Random;

/**
 * Hoitaa vastapuolen pelimekaniikan.
 * @author Emmi Otava
 */
public class Tietokone {

    private Rivi oikeaRivi;
    private Random random;

    /**
     * Luodaan olio sekä uusi Random-olio, joka laitetaan talteen.
     */
    public Tietokone() {
        random = new Random();
    }

    /**
     * Generoi satunnaisen rivin, jota pelaaja yrittää arvata. Rivi jää olion sisälle muistiin.
     */
    public void generoiRivi() {
        oikeaRivi = new Rivi();
        for (int i = 0; i < 4; i++) {
            oikeaRivi.aseta(i, arvoVari());
        }
    }

    /**
     * generoiRivin apumetodi, joka arpoo värin.
     * @return Satunnainen väri sallituista nappulan väreistä.
     */
    private String arvoVari() {
        int arpaluku = random.nextInt(6);
        if (arpaluku == 0) {
            return "sininen";
        }
        if (arpaluku == 1) {
            return "punainen";
        }
        if (arpaluku == 2) {
            return "vihreä";
        }
        if (arpaluku == 3) {
            return "keltainen";
        }
        if (arpaluku == 4) {
            return "musta";
        } else {
            return "valkoinen";
        }
    }
}