package my.mastermind;

import java.awt.Color;

/**
 * Hoitaa keskeisen pelimekaniikan.
 *
 * @author Emmi Otava
 */
public class Pelimekaniikka {

    private Kayttoliittyma kayttis;
    private MastermindUI ui;
    
    Rivi palaute;


    /**
     * Konstruktori. arvattuOikein asetetaan falseksi ja uusi Tietokone-olio
     * luodaan. Arvauksien määrä asetetaan nollaksi ja annetaan viite
     * Käyttöliittymä-rajapinnan toteuttavaan olioon.
     */
    public Pelimekaniikka() {
        
    }




    
    
   



    

    /**
     * Pyörittää keskeistä pelimekaniikkaa.
     */
    public void loop() {
        while (true) {
            if (arvauksia >= 10) {
                havio();
            }
            palaute = tietokone.tarkistaRivi(kayttis.getRivi());
            if (tietokone.getArvattuOikein()) {
                voitto();
            } else {
                kayttis.naytaPalaute(palaute, arvauksia);
            }
        }
    }

    public void laheta() {
    }

    

    private void voitto() {
        System.out.println("Onneksi olkoon, voitit pelin " + arvauksia + " arvauksella!");
//        valikko();
    }

    private void havio() {
        System.out.println("Hävisit! Liikaa arvauksia.");
        System.out.println("Oikea rivi olisi ollut: ");
        tietokone.tulostaOikeaRivi();
//        valikko();
    }
//     /**
//     * Joko aloittaa uuden pelin tai lopettaa, riippuen pelaajan valinnasta.
//     */
//    public void valikko() {
//        int valinta = kayttis.valikko();
//        if (valinta == 0) {
//            aloitaPeli();
//        } else {
//            System.exit(0);
//        }
//    }
}