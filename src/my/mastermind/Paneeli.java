package my.mastermind;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Paneeli extends JPanel {
    
//    public Paneeli(int xpos, int ypos, int width, int height) {
//        
//    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawRect(0, 0, 200, 20);     // nelikulmio, vasen nurkka, leveys, korkeus
    }
}