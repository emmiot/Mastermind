package my.mastermind;

import java.util.Random;

public class Tietokone {

    private Rivi oikeaRivi;
    private Random random;

    public Tietokone() {
        random = new Random();
    }

    public void generoiRivi() {
        oikeaRivi = new Rivi();
        for (int i = 0; i < 4; i++) {
            oikeaRivi.aseta(i, arvoVari());
        }
    }

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