package hu.elte.polozgai.movie.view;

import hu.elte.polozgai.movie.controller.MainMenuController;
/**
 *
 * @author polozgai
 */
public class MainMenuView extends javax.swing.JFrame {

    private MainMenuController controller;
    
    /**
     * {@link MainMenuView} konstru�l�sa.
     * @param controller {@link MainMenuController}
     */
    public MainMenuView(MainMenuController controller) {
        initComponents();
        this.controller=controller;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nyilvantartasButton = new javax.swing.JButton();
        kolcsonzesekButton = new javax.swing.JButton();
        panikButton = new javax.swing.JButton();
        ujFilmButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("F�oldal");

        nyilvantartasButton.setText("Nyilv�ntart�s");
        nyilvantartasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nyilvantartasButtonActionPerformed(evt);
            }
        });

        kolcsonzesekButton.setText("K�lcs�nz�sek nyilv�ntart�sa");
        kolcsonzesekButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kolcsonzesekButtonActionPerformed(evt);
            }
        });

        panikButton.setText("P�nik!");
        panikButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panikButtonActionPerformed(evt);
            }
        });

        ujFilmButton.setText("�j film felvitele");
        ujFilmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ujFilmButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ujFilmButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panikButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kolcsonzesekButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nyilvantartasButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(113, 113, 113))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(nyilvantartasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kolcsonzesekButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panikButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ujFilmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nyilvantartasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nyilvantartasButtonActionPerformed
        controller.onNyilvantartasClick();
    }//GEN-LAST:event_nyilvantartasButtonActionPerformed

    private void kolcsonzesekButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kolcsonzesekButtonActionPerformed
        controller.onKolcsonzesekClick();
    }//GEN-LAST:event_kolcsonzesekButtonActionPerformed

    private void panikButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panikButtonActionPerformed
        controller.onPanikClick();
    }//GEN-LAST:event_panikButtonActionPerformed

    private void ujFilmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ujFilmButtonActionPerformed
        controller.onUjFilmClick();
    }//GEN-LAST:event_ujFilmButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton kolcsonzesekButton;
    private javax.swing.JButton nyilvantartasButton;
    private javax.swing.JButton panikButton;
    private javax.swing.JButton ujFilmButton;
    // End of variables declaration//GEN-END:variables
}
