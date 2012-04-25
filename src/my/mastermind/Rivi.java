package my.mastermind;

import java.util.ArrayList;

/**
 * Luokasta voi tehdä neljän nappulan rivejä.
 *
 * @author Emmi Otava
 */
public class Rivi {

    private Nappula[] rivi;

    /**
     * Luo rivin.
     */
    public Rivi() {
        rivi = new Nappula[4];
    }

    /**
     * Asettaa haluttuun indeksiin halutun värisen nappulan.
     *
     * @param indeksi
     * @param vari
     */
    public void aseta(int indeksi, String vari) {
        Nappula nappula = new Nappula(vari);
        rivi[indeksi] = nappula;
    }

    /**
     * Palauttaa sen nappulan, joka sijaitsee syötetyssä indeksissä.
     *
     * @param indeksi
     * @return nappula halutun indeksin alta
     */
    public Nappula getNappula(int indeksi) {
        return rivi[indeksi];
    }

    /**
     * Etsii halutun värin kaikki ilmentymät rivistä.
     *
     * @param vari
     * @return lista, jossa kaikki oikeanväristen nappuloiden indeksit
     */
    public ArrayList<Integer> etsiVari(String vari) {
        ArrayList<Integer> palautus = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            if (rivi[i].getVari().equals(vari)) {
                palautus.add(i);
            }
        }
        return palautus;
    }
    
    public void tulosta() {
        for (int i = 0; i < rivi.length; i++) {
            System.out.println((i+1) + ". " + rivi[i].getVari());
        }
    }
}