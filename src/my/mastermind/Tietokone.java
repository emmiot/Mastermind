package my.mastermind;

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
    private String arvoVari() {
        int arpaluku = random.nextInt(6);
        if (arpaluku == 0) {
            return "sininen";
        }
        if (arpaluku == 1) {
            return "punainen";
        }
        if (arpaluku == 2) {
            return "vihrea";
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

    /**
     * Tarkistaa pelaajan syöttämän rivin, ja antaa ohjeet
     * generoiPalauterivi():lle, millainen palauterivi pitää tehdä.
     *
     * @param pelaajanArvaus Pelaajan arvaama rivi.
     * @return
     */
    public Rivi tarkistaRivi(Rivi pelaajanArvaus) {
        Rivi apuRivi = new Rivi();
        int musta = 0;
        int valkoinen = 0;
        for (int i = 0; i < 4; i++) {
            if (pelaajanArvaus.getNappula(i).getVari().equals(oikeaRivi.getNappula(i).getVari())) {
                musta++;
                apuRivi.aseta(i, null);
            }
        }
        if (musta == 4) {
            arvattuOikein = true;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (apuRivi.getNappula(j) != null) {
                    if (pelaajanArvaus.getNappula(i).getVari().equals(oikeaRivi.getNappula(j).getVari())) {
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
                palauteRivi.aseta(i, "musta");
                mustienMaara = mustienMaara - 1;
            } else if (valkoistenMaara > 0) {
                palauteRivi.aseta(i, "valkoinen");
                valkoistenMaara = valkoistenMaara - 1;
            } else {
                palauteRivi.aseta(i, "tyhjä");
            }
        }
        return palauteRivi;
    }

    /**
     * Tulostaa oikean rivin.
     */
    public void tulostaOikeaRivi() {
        oikeaRivi.tulosta();
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