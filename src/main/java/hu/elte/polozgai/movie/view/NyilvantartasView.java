package hu.elte.polozgai.movie.view;


import hu.elte.polozgai.movie.controller.NyilvantartasController;
import hu.elte.polozgai.movie.model.Film;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author polozgai
 */
public class NyilvantartasView extends javax.swing.JFrame {

    private List<Film> filmLista=new ArrayList<Film>();
    private NyilvantartasController controller;
    private DefaultTableModel model1;
    private String jTextFieldTemp;
    private String jComboBoxTemp;
    
    /**
     * {@link NyilvantartasView} konstru�l�sa.
     * @param controller {@link NyilvantartasController}
     */
    public NyilvantartasView(NyilvantartasController controller) {
        initComponents();
        model1= (DefaultTableModel) nyilvantartasTabla.getModel();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.controller=controller;
        filmLista=controller.getFilm();
        fillTable();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        keresesTextField = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        keresesButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        nyilvantartasTabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        f5Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nyilv�ntart�s");

        keresesTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keresesTextFieldActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cim", "Rendezo", "Foszereplo", "Megjelenes", "Hossz", "Adathordozo tipus", "Eredeti", "Kolcsonadott" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        keresesButton.setText("Keres�s");
        keresesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keresesButtonActionPerformed(evt);
            }
        });

        nyilvantartasTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "C�m", "Rendez�", "F�szerepl�", "Megjelen�s", "Hossz", "Adathordoz� t�pus", "Eredeti", "H�nyszor k�lcs�nadva", "K�lcs�nadott"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Integer.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        nyilvantartasTabla.setEnabled(false);
        nyilvantartasTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nyilvantartasTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(nyilvantartasTabla);

        jLabel1.setText("Keres�s:");

        f5Button.setText("F5");
        f5Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f5ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(f5Button)
                .addGap(61, 61, 61)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(keresesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(keresesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(keresesButton, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(jComboBox1)
                        .addComponent(f5Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(keresesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void keresesTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keresesTextFieldActionPerformed
        jTextFieldTemp=keresesTextField.getText();
    }//GEN-LAST:event_keresesTextFieldActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        jComboBoxTemp=jComboBox1.getSelectedItem().toString();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void keresesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keresesButtonActionPerformed
        try {
            controller.kereses(jTextFieldTemp, jComboBoxTemp);
            keresesTabla();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_keresesButtonActionPerformed

    private void nyilvantartasTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nyilvantartasTablaMouseClicked
        int index=nyilvantartasTabla.rowAtPoint(evt.getPoint());
        int id=(int) nyilvantartasTabla.getValueAt(index, 0);
        Film film=null;
        for(int i=0;i<filmLista.size();i++){
            if(filmLista.get(i).getId()==id){
                film=filmLista.get(i);
            }
        }
        controller.onTableClick(film);
    }//GEN-LAST:event_nyilvantartasTablaMouseClicked

    private void f5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f5ButtonActionPerformed
        controller.update();
        filmLista=new ArrayList<>();
        filmLista=controller.getFilm();
        deleteTabla();
        fillTable();
    }//GEN-LAST:event_f5ButtonActionPerformed

    private void fillTable(){
        for(int i=0;i<filmLista.size();i++){
            model1.addRow(new Object[]{null, null, null,null,null,null,null,null,null,null,null});
        }
        for(int i=0;i<filmLista.size();i++){  
            nyilvantartasTabla.setValueAt(filmLista.get(i).getId(), i, 0);
            nyilvantartasTabla.setValueAt(filmLista.get(i).getCim(), i, 1);
            nyilvantartasTabla.setValueAt(filmLista.get(i).getRendezok(), i, 2);
            nyilvantartasTabla.setValueAt(filmLista.get(i).getFoszereplok(), i, 3);
            nyilvantartasTabla.setValueAt(filmLista.get(i).getMegjelenes(), i, 4);
            nyilvantartasTabla.setValueAt(filmLista.get(i).getHossz(), i, 5);
            nyilvantartasTabla.setValueAt(filmLista.get(i).getAdathordozoTipus(), i, 6);
            nyilvantartasTabla.setValueAt(filmLista.get(i).isEredeti(), i, 7);
            nyilvantartasTabla.setValueAt(filmLista.get(i).getHanyszor(), i, 8);
            nyilvantartasTabla.setValueAt(filmLista.get(i).isVisszahozva(), i, 9);
        }
    }
    
    private void deleteTabla(){
        model1 = (DefaultTableModel) nyilvantartasTabla.getModel();
        for(int i=model1.getRowCount()-1;i>-1;i--){
            model1.removeRow(i);
        }
    }
    
    private void keresesTabla(){
        deleteTabla();
        filmLista=new ArrayList<Film>();
        filmLista=controller.getKeresesLista();
        //System.out.println(filmLista.size());
        for(int i=0;i<filmLista.size();i++){
            model1.addRow(new Object[]{null, null, null,null,null,null,null,null,null,null,null});
        }
        for(int i=0;i<filmLista.size();i++){  
            nyilvantartasTabla.setValueAt(filmLista.get(i).getId(), i, 0);
            nyilvantartasTabla.setValueAt(filmLista.get(i).getCim(), i, 1);
            nyilvantartasTabla.setValueAt(filmLista.get(i).getRendezok(), i, 2);
            nyilvantartasTabla.setValueAt(filmLista.get(i).getFoszereplok(), i, 3);
            nyilvantartasTabla.setValueAt(filmLista.get(i).getMegjelenes(), i, 4);
            nyilvantartasTabla.setValueAt(filmLista.get(i).getHossz(), i, 5);
            nyilvantartasTabla.setValueAt(filmLista.get(i).getAdathordozoTipus(), i, 6);
            nyilvantartasTabla.setValueAt(filmLista.get(i).isEredeti(), i, 7);
            nyilvantartasTabla.setValueAt(filmLista.get(i).getHanyszor(), i, 8);
            nyilvantartasTabla.setValueAt(filmLista.get(i).isVisszahozva(), i, 9);
        }
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton f5Button;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton keresesButton;
    private javax.swing.JTextField keresesTextField;
    private javax.swing.JTable nyilvantartasTabla;
    // End of variables declaration//GEN-END:variables
}
