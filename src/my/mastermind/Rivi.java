package my.mastermind;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Luokasta voi tehdä neljän värin rivejä.
 *
 * @author Emmi Otava
 */
public class Rivi {

    private Color[] rivi;

    /**
     * Konstruktori. Luo rivi-muuttujaan uuden neljän kokoisen Color-taulukon.
     */
    public Rivi() {
        rivi = new Color[4];
    }

    /**
     * Asettaa haluttuun indeksiin halutun värin.
     *
     * @param indeksi
     * @param vari
     */
    public void aseta(int indeksi, Color vari) {
        rivi[indeksi] = vari;
    }

    /**
     * Palauttaa sen värin, joka sijaitsee syötetyssä indeksissä.
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

    /**
     * Testauskäyttöön tulostusmetodi.
     */
    public void tulosta() {
        for (int i = 0; i < rivi.length; i++) {
            System.out.println((i + 1) + ". " + mikaVari(rivi[i]));
        }
    }

    /**
     * Tulostusmetodin apumetodi. Selvittää, mitä selvätekstin väriä mikäkin
     * väri-olio vastaa.
     *
     * @param vari
     * @return
     */
    private String mikaVari(Color vari) {
        if (vari.equals(Color.BLUE)) {
            return "Sininen";
        }
        if (vari.equals(Color.RED)) {
            return "Punainen";
        }
        if (vari.equals(Color.GREEN)) {
            return "Vihreä";
        }
        if (vari.equals(Color.YELLOW)) {
            return "Keltainen";
        }
        if (vari.equals(Color.BLACK)) {
            return "Musta";
        }
        if (vari.equals(Color.WHITE)) {
            return "Valkoinen";
        } else {
            return "(tyhjä)";
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

    public void kopioiRivi(Rivi kopioitava) {
        for (int i = 0; i < 4; i++) {
            rivi[i] = kopioitava.getVari(i);
        }
    }

    public void alusta() {
        for (int i = 0; i < 4; i++) {
            rivi[i] = Color.BLACK;
        }
    }
}