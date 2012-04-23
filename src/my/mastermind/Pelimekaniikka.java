package my.mastermind;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Hoitaa keskeisen pelimekaniikan.
 *
 * @author Emmi Otava
 */
public class Pelimekaniikka implements ActionListener {

    private Kayttoliittyma kayttis;
    private MastermindUI ui;
    private Tietokone tietokone;
    private boolean arvattuOikein; // tarvitaankohan edes?
    private int arvauksia;
    Rivi[] edellisetArvaukset;
    int edArvIterator;

    /**
     * Konstruktori. arvattuOikein asetetaan falseksi ja uusi Tietokone-olio
     * luodaan. Arvauksien määrä asetetaan nollaksi ja annetaan viite
     * Käyttöliittymä-rajapinnan toteuttavaan olioon.
     */
//    public Pelimekaniikka(MastermindUI ui) {
      public Pelimekaniikka(Kayttoliittyma kayttis) {
        this.arvattuOikein = false;
        this.tietokone = new Tietokone();
        this.ui = ui;
        this.arvauksia = 0;
        edellisetArvaukset = new Rivi[10];
        edArvIterator = 0;
        ui.setListener(this);
        ui.setVisible(true);
    }

    /**
     * Joko aloittaa uuden pelin tai lopettaa, riippuen pelaajan valinnasta.
     */
    public void valikko() {
        int valinta = kayttis.valikko();
        if (valinta == 0) {
            aloitaPeli();
        } else {
            System.exit(0);
        }
    }

    /**
     * Aloittaa pelin.
     */
    public void aloitaPeli() {
        tietokone.generoiRivi();
        loop();
    }

    /**
     * Pyörittää keskeistä pelimekaniikkaa.
     */
    public void loop() {
        if (arvauksia >= 10) {
            havio();
        }
        kayttis.kysyPelaajalta();
        if (kayttis.riviOk() == 1) {
            kayttis.rivinKorjaus();
        }
        edellisetArvaukset[edArvIterator] = kayttis.getRivi();
        edArvIterator++;
        arvauksia++;
        tietokone.tarkistaRivi(kayttis.getRivi());
    }

    private void havio() {
        System.out.println("Hävisit! Liikaa arvauksia.");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}