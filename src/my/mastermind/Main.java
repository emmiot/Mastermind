package my.mastermind;

import java.util.Random;

public class Main {

    public static Random random;

    public static void main(String args[]) {
//        random = new Random();
//        for (int i = 0; i < 100; i++) {
//            arvoVari();
//        }

        Tekstikayttoliittyma kayttis = new Tekstikayttoliittyma();
        Pelimekaniikka peli = new Pelimekaniikka(kayttis);
        peli.valikko();
    }

//    private static void arvoVari() {
//        int arpaluku = random.nextInt(6);
//        if (arpaluku == 0) {
//            System.out.println(arpaluku);
//        }
//        if (arpaluku == 1) {
//            System.out.println(arpaluku);
//        }
//        if (arpaluku == 2) {
//            System.out.println(arpaluku);
//        }
//        if (arpaluku == 3) {
//            System.out.println(arpaluku);
//        }
//        if (arpaluku == 4) {
//            System.out.println(arpaluku);
//        } else {
//            System.out.println(arpaluku);
//        }
//    }
}