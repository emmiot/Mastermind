package my.mastermind;

import java.awt.Color;
import java.util.Random;

/**
 * Hoitaa vastapuolen pelimekaniikan.
 *
 * @author Emmi Otava
 */
public class Tietokone {

    private Rivi oikeaRivi;
    private Random random;
    private boolean arvattuOikein;

    /**
     * Konstruktori. Luodaan myös uusi Random-olio, joka laitetaan talteen, ja
     * asetetaan arvattuOikein falseksi.
     */
    public Tietokone() {
        random = new Random();
        this.arvattuOikein = false;
    }

    /**
     * Generoi satunnaisen rivin, jota pelaaja yrittää arvata. Rivi otetaan
     * talteen olion sisälle.
     */
    public void generoiRivi() {
        oikeaRivi = new Rivi();
        for (int i = 0; i < 4; i++) {
            oikeaRivi.aseta(i, arvoVari());
        }
    }

    /**
     * generoiRivin apumetodi, joka arpoo värin.
     *
     * @return Satunnainen väri sallituista nappulan väreistä.
     */
    private Color arvoVari() {
        int arpaluku = random.nextInt(6);
        if (arpaluku == 0) {
            return Color.BLUE;
        }
        if (arpaluku == 1) {
            return Color.RED;
        }
        if (arpaluku == 2) {
            return Color.GREEN;
        }
        if (arpaluku == 3) {
            return Color.YELLOW;
        }
        if (arpaluku == 4) {
            return Color.BLACK;
        } else {
            return Color.WHITE;
        }
    }

    /**
     * Tarkistaa pelaajan syöttämän rivin, ja antaa ohjeet
     * generoiPalauterivi():lle, millainen palauterivi pitää tehdä.
     *
     * @param pelaajanArvaus Pelaajan arvaama rivi.
     * @return Rivi
     */
    public Rivi tarkistaRivi(Rivi pelaajanArvaus) {
        Rivi oikeanKopio = new Rivi();
        oikeanKopio.kopioiRivi(oikeaRivi);
        Rivi pelaajanKopio = new Rivi();
        pelaajanKopio.kopioiRivi(pelaajanArvaus);
        int musta = 0;
        int valkoinen = 0;
        for (int i = 0; i < 4; i++) {
            if (pelaajanKopio.getVari(i).equals(oikeanKopio.getVari(i))) {
                musta++;
                oikeanKopio.aseta(i, Color.LIGHT_GRAY);
                pelaajanKopio.aseta(i, Color.LIGHT_GRAY);
            }
        }
        if (musta == 4) {
            arvattuOikein = true;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!oikeanKopio.getVari(j).equals(Color.LIGHT_GRAY) && !pelaajanKopio.getVari(i).equals(Color.LIGHT_GRAY)) {
                    if (pelaajanKopio.getVari(i).equals(oikeanKopio.getVari(j))) {
                        valkoinen++;
                        oikeanKopio.aseta(j, Color.LIGHT_GRAY);
                        pelaajanKopio.aseta(i, Color.LIGHT_GRAY);
                    }
                }
            }
        }
        return generoiPalauterivi(musta, valkoinen);
    }

    /**
     * Generoi palauterivin, joka kertoo pelaajalle, montako arvauksesta meni
     * oikein tai edes lähelle.
     *
     * @param mustienMaara Palauteriviin tulevien mustien nappuloiden määrä.
     * @param valkoistenMaara Palauteriviin tulevien valkoisten nappuloiden
     * määrä.
     * @return Rivi
     */
    private Rivi generoiPalauterivi(int mustienMaara, int valkoistenMaara) {
        Rivi palauteRivi = new Rivi();
        for (int i = 0; i < 4; i++) {
            if (mustienMaara > 0) {
                palauteRivi.aseta(i, Color.BLACK);
                mustienMaara = mustienMaara - 1;
            } else if (valkoistenMaara > 0) {
                palauteRivi.aseta(i, Color.WHITE);
                valkoistenMaara = valkoistenMaara - 1;
            } else {
                palauteRivi.aseta(i, Color.LIGHT_GRAY);
            }
        }
        return palauteRivi;
    }

    /**
     * Palauttaa oikean rivin.
     *
     * @return Rivi
     */
    public Rivi getOikeaRivi() {
        return oikeaRivi;
    }

    /**
     * Palauttaa tiedon, onko pelaaja jo arvannut oikein.
     *
     * @return boolean
     */
    public boolean getArvattuOikein() {
        return arvattuOikein;
    }

    /**
     * Testikäyttöön. Asetetaan oikea rivi halutuksi, arpomatta.
     *
     * @param rivi Haluttu oikea rivi.
     */
    public void asetaOikeaRivi(Rivi rivi) {
        oikeaRivi = rivi;
    }
}