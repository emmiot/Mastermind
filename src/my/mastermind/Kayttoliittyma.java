
package my.mastermind;

import java.util.Scanner;

/**
 *Tekstipohjainen käyttöliittymä väliaikaiskäyttöön.
 * @author eotava
 */
public class Kayttoliittyma {
    
    private static Scanner lukija = new Scanner(System.in);
    
    private Pelimekaniikka peli;

    /**
     * Käynnistää loopin.
     */
    void kaynnisty() {
        System.out.println("Tervetuloa pelaamaan Mastermind-peliä!");
        loop();
    }

    /**
     * Hoitaa keskeiset toiminnot.
     */
    private void loop() {
        while (true) {
            System.out.println("0 : Aloita uusi peli");
            System.out.println("1: Lopeta");
            int a = lukija.nextInt();
            if (a == 1) {
                break;
            }
            if (a == 0) {
                uusiPeli();
            }
        }
    }

    /**
     * Aloittaa uuden pelin.
     */
    private void uusiPeli() {
        peli = new Pelimekaniikka();
        
    }
    
}
