package my.mastermind;

import java.util.Scanner;

/**
 * Tekstipohjainen käyttöliittymä väliaikaiskäyttöön.
 *
 * @author eotava
 */
public class Tekstikayttoliittyma implements Kayttoliittyma {

    private static Scanner lukija = new Scanner(System.in);
    Rivi rivi;

    @Override
    public int valikko() {
        System.out.println("0 : Aloita uusi peli");
        System.out.println("1 : Lopeta");
        return lukija.nextInt();
    }

    public Tekstikayttoliittyma() {
    }

    @Override
    public void kysyPelaajalta() {
        rivi = new Rivi();
        for (int i = 0; i < 4; i++) {
            System.out.print("Anna rivin " + (i + 1) + ". väri: ");
            rivi.aseta(i, lukija.next());
        }
    }

    @Override
    public void rivinKorjaus() {
        while (true) {
            System.out.println("Rivisi: ");
            rivi.tulosta();
            System.out.println("Monennenko nappulan haluat vaihtaa?");
            int vaihdettavaIndeksi = lukija.nextInt() - 1;
            System.out.println("Mikä väri laitetaan?");
            rivi.aseta(vaihdettavaIndeksi, lukija.next());
            System.out.println("Haluatko muokata riviä lisää? ");
            System.out.println("0: Kyllä | 1: Ei");
            if (lukija.nextInt() == 1) {
                break;
            }
        }
    }

    @Override
    public Rivi getRivi() {
        return rivi;
    }

    @Override
    public int riviOk() {
        System.out.println("Rivisi: ");
        rivi.tulosta();
        System.out.println("Onko OK?");
        System.out.println("0 : OK");
        System.out.println("1 : Korjaa");
        return lukija.nextInt();
    }

    @Override
    public void naytaPalaute(Rivi palaute, int arvauksia) {
        System.out.println("Olet arvannut " + arvauksia + " kertaa.");
        System.out.println("Tietokoneen antama palauterivi:");
        System.out.println("(Musta : oikea väri oikeassa paikassa)");
        System.out.println("(Valkoinen: oikea väri väärässä paikassa)");
        palaute.tulosta();
    }
}
