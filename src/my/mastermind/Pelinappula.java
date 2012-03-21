
package my.mastermind;

public class Pelinappula {
    private String vari;
    
    // Käyttäjä syöttää värin nappulaa painamalla eli syötteen oikeellisuus jää pelin sisällä toteutettavaksi.
    // Siksi väri asetetaan suoraan ilman kummempaa syötteentarkistusta.
    
    public Pelinappula(String haluttuVari) {
        vari = haluttuVari;
    }
    
    public String getVari() {
        return vari;
    }
}