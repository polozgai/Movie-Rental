package hu.elte.polozgai.movie.view;


import hu.elte.polozgai.movie.controller.FunkcioController;
import hu.elte.polozgai.movie.model.Film;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class FunkcioView extends javax.swing.JFrame {

    private FunkcioController funkcioController;
    private Film film;
    
    /**
     * {@link FunkcioView} konstru�l�sa.
     * @param funkcioController {@link FunkcioController}
     */
    public FunkcioView(FunkcioController funkcioController) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.funkcioController=funkcioController;
        this.film=this.funkcioController.getFilm();
        loadImage();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kolcsonAdButton = new javax.swing.JButton();
        visszaVeszButton = new javax.swing.JButton();
        modositButton = new javax.swing.JButton();
        torolbutton = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Funkci�k");

        kolcsonAdButton.setText("K�lcs�nad");
        kolcsonAdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kolcsonAdButtonActionPerformed(evt);
            }
        });

        visszaVeszButton.setText("Visszavesz");
        visszaVeszButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visszaVeszButtonActionPerformed(evt);
            }
        });

        modositButton.setText("M�dos�t");
        modositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modositButtonActionPerformed(evt);
            }
        });

        torolbutton.setText("T�r�l");
        torolbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                torolbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(visszaVeszButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(modositButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addComponent(torolbutton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(kolcsonAdButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kolcsonAdButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(visszaVeszButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(modositButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(torolbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kolcsonAdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kolcsonAdButtonActionPerformed
        funkcioController.onKolcsonzesClick();
        dispose();
    }//GEN-LAST:event_kolcsonAdButtonActionPerformed

    private void visszaVeszButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visszaVeszButtonActionPerformed
        try {
            funkcioController.onVisszaveszClick();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);
        }
        setVisible(false);
        dispose();
    }//GEN-LAST:event_visszaVeszButtonActionPerformed

    private void modositButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modositButtonActionPerformed
        funkcioController.onModositasClick();
        dispose();
    }//GEN-LAST:event_modositButtonActionPerformed

    private void torolbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_torolbuttonActionPerformed
        try {
            funkcioController.onTorlesClick();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);
        }
        setVisible(false);
        dispose();
    }//GEN-LAST:event_torolbuttonActionPerformed

    private void loadImage(){
        if(film!=null){
            Blob blob=film.getBoritokep();
            if(blob!=null){
                try{
                    InputStream in=blob.getBinaryStream();
                    BufferedImage image=ImageIO.read(in);
                    imageLabel.setIcon(new ImageIcon(image));
                }catch(SQLException | IOException e){
            
                }
            }else{
                imageLabel.setText("Nincs megadva kep!");
            }
        }    
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton kolcsonAdButton;
    private javax.swing.JButton modositButton;
    private javax.swing.JButton torolbutton;
    private javax.swing.JButton visszaVeszButton;
    // End of variables declaration//GEN-END:variables
}
