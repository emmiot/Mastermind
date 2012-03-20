package my.mastermind;

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
    
    public int[] etsiVari(String vari) {
        int[] palautus = new int[4];
        for (int i=0; i<3; i++) {
            if (rivi[i].equals(vari)) {
                palautus[i] = i;
            }
        }
        return palautus;
    }
}