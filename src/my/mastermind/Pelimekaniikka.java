package my.mastermind;

public class Pelimekaniikka {
    private Tietokone tietokone;
    
    public Pelimekaniikka() {
        this.tietokone = new Tietokone();
    }
    
    public void aloitaPeli() {
        tietokone.generoiRivi();
    }
}