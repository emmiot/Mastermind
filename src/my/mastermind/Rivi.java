package my.mastermind;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Luokasta voi tehdä neljän nappulan rivejä.
 *
 * @author Emmi Otava
 */
public class Rivi {

    private Color[] rivi;

    /**
     * Luo rivin.
     */
    public Rivi() {
        rivi = new Color[4];
    }

    /**
     * Asettaa haluttuun indeksiin halutun värisen nappulan.
     *
     * @param indeksi
     * @param vari
     */
    public void aseta(int indeksi, Color vari) {
        rivi[indeksi] = vari;
    }

    /**
     * Palauttaa sen nappulan, joka sijaitsee syötetyssä indeksissä.
     *
     * @param indeksi
     * @return nappula halutun indeksin alta
     */
    public Color getVari(int indeksi) {
        return rivi[indeksi];
    }

    /**
     * Etsii halutun värin kaikki ilmentymät rivistä.
     *
     * @param vari
     * @return lista, jossa kaikki oikeanväristen nappuloiden indeksit
     */
    public ArrayList<Integer> etsiVari(Color vari) {
        ArrayList<Integer> palautus = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            if (rivi[i].equals(vari)) {
                palautus.add(i);
            }
        }
        return palautus;
    }
    
    public void tulosta() {
        for (int i = 0; i < rivi.length; i++) {
            System.out.println((i+1) + ". " + rivi[i]);
        }
    }
    
    public boolean tarkistaOnkoTyhjia() {
        for (int i = 0; i < rivi.length; i++) {
            if (rivi[i] == null) {
                return true;
            }
        }
        return false;
    }
    
    public void varit() {
        
    }
}