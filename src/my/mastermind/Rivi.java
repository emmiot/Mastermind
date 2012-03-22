package my.mastermind;

import java.util.ArrayList;

public class Rivi {

    private String[] rivi;

    public Rivi() {
        rivi = new String[4];
    }

    public void aseta(int indeksi, String vari) {
        rivi[indeksi] = vari;
    }
    
    public String getIndeksi(int indeksi) {
        return rivi[indeksi];
    }
    
    public ArrayList<Integer> etsiVari(String vari) {
        ArrayList<Integer> palautus = new ArrayList<Integer>();
        for (int i=0; i<4; i++) {
            if (rivi[i].equals(vari)) {
                palautus.add(i);
            }
        }
        return palautus;
    }
}