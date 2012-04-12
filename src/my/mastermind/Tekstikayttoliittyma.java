package my.mastermind;

import java.util.Scanner;

/**
 * Tekstipohjainen käyttöliittymä väliaikaiskäyttöön.
 *
 * @author eotava
 */
public class Tekstikayttoliittyma implements Kayttoliittyma {

    private static Scanner lukija = new Scanner(System.in);

    @Override
    public int valikko() {
        System.out.println("0 : Aloita uusi peli");
        System.out.println("1: Lopeta");
        return lukija.nextInt();
    }

    @Override
    public void kysyPelaajalta() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
