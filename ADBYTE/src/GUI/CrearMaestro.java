/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.MaestraDAO;
import DAO.NinoDAO;
import POJO.Maestra;
import POJO.Nino;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Avril
 */
public class CrearMaestro extends javax.swing.JFrame {

    /**
     * Creates new form CrearMaestro
     */
      MaestraDAO md;
//    DefaultTableModel dtm;
    TableRowSorter<TableModel> sorter;
    public CrearMaestro() {
        initComponents();
        setTitle("Crear Maestro");
         setSize(643, 445);
           setLocationRelativeTo(this);
            md = new MaestraDAO();   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(jTextField1);
        jTextField1.setBounds(180, 170, 170, 40);

        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(jTextField2);
        jTextField2.setBounds(180, 100, 170, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES GUARDEÍA/VerMaestros160.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesxd/VerMaestros150.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesxd/VerMaestros170.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(430, 260, 220, 90);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES GUARDEÍA/btnGuardar200.png"))); // NOI18N
        jButton1.setText("jButton1");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesxd/btnGuardar190.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesxd/btnGuardar210.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(430, 180, 220, 90);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES GUARDEÍA/cuadroMaestro600.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 80, 430, 310);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES GUARDEÍA/Maestros500.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-30, 10, 450, 80);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES GUARDEÍA/regresarMenu160.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesxd/regresarMenu150.png"))); // NOI18N
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesxd/regresarMenu170.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(450, 0, 180, 130);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/F.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 630, 418);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        VerMaestro verMaestro;
          try {
              verMaestro = new VerMaestro();
              verMaestro.setVisible(true);
        this.setVisible(false);
          } catch (SQLException ex) {
              Logger.getLogger(CrearMaestro.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String a = jTextField1.getText();
        int uno = a.length();
        String b = jTextField2.getText();
        int dos = b.length();
        
        if (uno==0||dos==0) {
            JOptionPane.showMessageDialog(null, "Dejaste un campo vacio, duelve a llenarlos");
            jTextField1.setText("");
            jTextField2.setText("");
            
        }else{
           try {
            if (crearp()!=0) {
                JOptionPane.showMessageDialog(null, "Éxito");
                
              
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrearMaestro.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
int crearp() throws SQLException{
        String nombre = jTextField2.getText();
        String apellido = jTextField1.getText();
       
        Maestra m = new Maestra (nombre,apellido);
        int id = md.insertar(m);
        return id;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrearMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearMaestro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}