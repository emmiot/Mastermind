package my.mastermind;

/**
 * Käyttöliittymä-rajapinta.
 * @author Emmi Otava
 */
public interface Kayttoliittyma {

    /**
     * Palauttaa tiedon, aloitetaanko uusi peli vai lopetetaanko.
     *
     * @return
     */
    public int valikko();

    /**
     * Palauttaa (sitten kun on implementoitu) pelaajan arvaaman rivin.
     */
    public void kysyPelaajalta();
}
