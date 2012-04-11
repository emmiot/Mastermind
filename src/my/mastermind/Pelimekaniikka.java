package my.mastermind;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Hoitaa keskeisen pelimekaniikan.
 * @author Emmi Otava
 */
public class Pelimekaniikka implements ActionListener{
    private Tietokone tietokone;
    private boolean arvattuOikein;
    
    /**
     * Konstruktori. arvattuOikein asetetaan falseksi ja uusi Tietokone-olio luodaan.
     */
    public Pelimekaniikka() {
        this.arvattuOikein = false;
        this.tietokone = new Tietokone();
    }
    
    /**
     * Aloittaa pelin.
     */
    public void aloitaPeli() {
        tietokone.generoiRivi();
    }
    
    /**
     * Pyörittää keskeistä pelimekaniikkaa.
     */
    public void loop() {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}