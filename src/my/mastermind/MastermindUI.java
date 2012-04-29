package my.mastermind;

import java.awt.Color;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Graafinen käyttöliittymä ja pelin keskeinen mekaniikka.
 *
 * @author Emmi Otava
 */
public class MastermindUI extends javax.swing.JFrame {

    private Tietokone tietokone;
    private Rivi pelaajanRivi;
    private Rivi palauteRivi;
    private int arvauksia;
    private Point origin;
    private int koko;

    /**
     * Konstruktori. Asettaa alkuarvot.
     */
    public MastermindUI() {
        initComponents();
        nollaaKaikki();
        System.out.println("Tietokoneen rivi aluksi:");
        tietokone.getOikeaRivi().tulosta();
        koko = 35;
        origin = new Point(40, 25);
        jTextPane1.setEditable(false);
        jTextPane1.setText("Select colors and submit. \n\nComputer's feedback: \nBlack: A right color in the right place \nWhite: A right color in a wrong place");
    }

    /**
     * Uuden pelin alkaessa nollaa ja alustaa kaikki arvot.
     */
    private void nollaaKaikki() {
        jPanel1.removeAll();
        jPanel2.removeAll();
        jPanel3.removeAll();
        this.repaint();
        this.arvauksia = 0;
        pelaajanRivi = new Rivi();
        alustaPelaajanRivi();
        this.tietokone = new Tietokone();
        tietokone.generoiRivi();
        submit.setEnabled(true);
    }

    /**
     * Piirtää parametrina annetun pelaajan rivin.
     *
     * @param rivi
     */
    public void piirraRivi(Rivi rivi) {
        for (int i = 0; i < 4; i++) {
            JLabel label = createColoredLabel(rivi.getVari(i), ((origin.x) + (koko * i)), ((origin.y) + (koko * arvauksia)));
            jPanel2.add(label);
        }
    }

    /**
     * Piirtää parametrina annetun palauterivin.
     *
     * @param palaute
     */
    public void piirraPalauteRivi(Rivi palaute) {
        for (int i = 0; i < 4; i++) {
            if (!palaute.getVari(i).equals(Color.LIGHT_GRAY)) {
                JLabel label = createColoredLabel(palaute.getVari(i), ((origin.x) + (koko * i)), ((origin.y) + (koko * arvauksia)));
                jPanel3.add(label);
            }
        }
    }

    public void piirraOikeaRivi(Rivi rivi) {
        for (int i = 0; i < 4; i++) {
            JLabel label = createColoredLabel(rivi.getVari(i), ((origin.x) + (koko * i)), ((origin.y)));
            jPanel1.add(label);
        }
    }

    /**
     * Piirtää väritetyn ruudun annettujen parametrien mukaan. Ruudun koko on
     * vakio.
     *
     * @param color Haluttu väri.
     * @param x Sijainti x-akselilla.
     * @param y Sijainti y-akselilla.
     * @return
     */
    private JLabel createColoredLabel(Color color, int x, int y) {
        JLabel label = new JLabel();
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);
        label.setBackground(color);
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setBounds(x, y, koko, koko);
        return label;
    }

    /**
     * Asettaa pelaajan riviin halutulle indeksille halutun värin.
     *
     * @param indeksi Haluttu indeksi (väliltä 0-3)
     * @param vari Haluttu väri kuuden hyväksytyn joukosta.
     */
    public void asetaPelaajanRivi(int indeksi, String vari) {
        pelaajanRivi.aseta(indeksi, mikaVari(vari));
    }

    /**
     * asetaPelaajanRivi()n apumetodi, joka saa parametrina värin
     * String-muodossa ja palauttaa sitä vastaavan Color-olion.
     *
     * @param vari
     * @return Halutunvärinen Color-olio.
     */
    private Color mikaVari(String vari) {
        if (vari.toLowerCase().equals("blue")) {
            return Color.BLUE;
        }
        if (vari.toLowerCase().equals("red")) {
            return Color.RED;
        }
        if (vari.toLowerCase().equals("yellow")) {
            return Color.YELLOW;
        }
        if (vari.toLowerCase().equals("green")) {
            return Color.GREEN;
        }
        if (vari.toLowerCase().equals("black")) {
            return Color.BLACK;
        } else {
            return Color.WHITE;
        }
    }

    /**
     * Alustaa pelaajan rivin kaikki värit sinisiksi, sillä se on ensimmäinen
     * valinta combo boxissa.
     */
    private void alustaPelaajanRivi() {
        for (int i = 0; i < 4; i++) {
            pelaajanRivi.aseta(i, Color.BLUE);
        }
    }

    /**
     * Ilmoittaa voitosta.
     */
    private void voitto() {
        JOptionPane.showMessageDialog(null, "Onneksi olkoon, voitit pelin!");
    }

    /**
     * Ilmoittaa häviöstä.
     */
    private void havio() {
        piirraOikeaRivi(tietokone.getOikeaRivi());
        this.repaint();
        JOptionPane.showMessageDialog(null, "Hävisit! Liikaa arvauksia. Oikea rivi näkyy peliruudun oikeassa alareunassa.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submit = new javax.swing.JButton();
        valinta1 = new javax.swing.JComboBox();
        valinta2 = new javax.swing.JComboBox();
        valinta3 = new javax.swing.JComboBox();
        valinta4 = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mastermind");

        submit.setText("Submit");
        submit.setToolTipText("");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        valinta1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blue", "Red", "Green", "Yellow", "Black", "White" }));
        valinta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valinta1ActionPerformed(evt);
            }
        });

        valinta2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blue", "Red", "Green", "Yellow", "Black", "White" }));
        valinta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valinta2ActionPerformed(evt);
            }
        });

        valinta3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blue", "Red", "Green", "Yellow", "Black", "White" }));
        valinta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valinta3ActionPerformed(evt);
            }
        });

        valinta4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blue", "Red", "Green", "Yellow", "Black", "White" }));
        valinta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valinta4ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Player's Guesses"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Computer's Feedback"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jTextPane1);

        jLabel1.setText("1.");

        jLabel2.setText("2.");

        jLabel3.setText("3.");

        jLabel4.setText("4.");

        jLabel5.setText("5.");

        jLabel6.setText("6.");

        jLabel7.setText("7.");

        jLabel8.setText("8.");

        jLabel9.setText("9.");

        jLabel10.setText("10.");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        jMenuItem1.setText("New Game");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(valinta1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(valinta2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(valinta3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(valinta4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(submit, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valinta2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valinta3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valinta1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valinta4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        nollaaKaikki();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void valinta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valinta1ActionPerformed
        String vari1 = (String) valinta1.getSelectedItem();
        asetaPelaajanRivi(0, vari1);
    }//GEN-LAST:event_valinta1ActionPerformed

    private void valinta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valinta4ActionPerformed
        String vari4 = (String) valinta4.getSelectedItem();
        asetaPelaajanRivi(3, vari4);
    }//GEN-LAST:event_valinta4ActionPerformed

    private void valinta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valinta2ActionPerformed
        String vari2 = (String) valinta2.getSelectedItem();
        asetaPelaajanRivi(1, vari2);
    }//GEN-LAST:event_valinta2ActionPerformed

    private void valinta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valinta3ActionPerformed
        String vari3 = (String) valinta3.getSelectedItem();
        asetaPelaajanRivi(2, vari3);
    }//GEN-LAST:event_valinta3ActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        System.out.println("Pelaajan rivi ennen tarkistusta");
        pelaajanRivi.tulosta();
        System.out.println("Tietokoneen rivi ennen tarkistusta:");
        tietokone.getOikeaRivi().tulosta();
        palauteRivi = tietokone.tarkistaRivi(pelaajanRivi);
        System.out.println("Pelaajan rivi tarkistuksen jälkeen");
        pelaajanRivi.tulosta();
        System.out.println("Palauterivi tarkistuksen jälkeen");
        palauteRivi.tulosta();
        System.out.println("Tietokoneen rivi tarkistuksen jälkeen:");
        tietokone.getOikeaRivi().tulosta();
        piirraRivi(pelaajanRivi);
        piirraPalauteRivi(palauteRivi);
        arvauksia++;
        this.repaint();
        if (tietokone.getArvattuOikein()) {
            submit.setEnabled(false);
            voitto();
        } else if (arvauksia == 10) {
            submit.setEnabled(false);
            havio();
        }
    }//GEN-LAST:event_submitActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton submit;
    private javax.swing.JComboBox valinta1;
    private javax.swing.JComboBox valinta2;
    private javax.swing.JComboBox valinta3;
    private javax.swing.JComboBox valinta4;
    // End of variables declaration//GEN-END:variables
}
