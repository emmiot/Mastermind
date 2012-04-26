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
     * Luodaan olio sekä uusi Random-olio, joka laitetaan talteen.
     */
    public Tietokone() {
        random = new Random();
        this.arvattuOikein = false;
    }

    /**
     * Generoi satunnaisen rivin, jota pelaaja yrittää arvata. Rivi jää olion
     * sisälle muistiin.
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
     * @return
     */
    public Rivi tarkistaRivi(Rivi pelaajanArvaus) {
        Rivi apuRivi = new Rivi();
        apuRivi.alusta();
        int musta = 0;
        int valkoinen = 0;
        for (int i = 0; i < 4; i++) {
            if (pelaajanArvaus.getVari(i).equals(oikeaRivi.getVari(i))) {
                musta++;
                apuRivi.aseta(i, Color.LIGHT_GRAY);
            }
        }
        if (musta == 4) {
            arvattuOikein = true;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (apuRivi.getVari(j).equals(Color.LIGHT_GRAY) == false) {
                    if (pelaajanArvaus.getVari(i).equals(oikeaRivi.getVari(j))) {
                        valkoinen++;
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
     * @return
     */
    public Rivi generoiPalauterivi(int mustienMaara, int valkoistenMaara) {
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
     * Tulostaa oikean rivin.
     */
    public Rivi getOikeaRivi() {
        return oikeaRivi;
    }
    
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