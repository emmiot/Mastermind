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
     * Palauttaa pelaajan arvaaman rivin.
     */
    public void kysyPelaajalta();
    
    /**
     * Varmistaa ennen lähetystä, onko rivi OK.
     */
    public void rivinKorjaus();
    
    public Rivi getRivi();

    public int riviOk();
}
