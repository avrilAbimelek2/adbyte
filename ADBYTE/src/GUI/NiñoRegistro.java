/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.MaestraDAO;
import DAO.NinoDAO;
import DAO.TutorDAO;
import POJO.Nino;

import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Avril
 */
public class NiñoRegistro extends javax.swing.JFrame {

    /**
     * Creates new form NiñoRegistro
     */
     TutorDAO td = new TutorDAO();
      MaestraDAO md = new MaestraDAO();
    NinoDAO nd;
//    DefaultTableModel dtm;
    TableRowSorter<TableModel> sorter;

    public NiñoRegistro() throws SQLException {
        initComponents();
        setTitle("Registrar Niño");
        setSize(660, 490);
        setLocationRelativeTo(this);
        nd = new NinoDAO();
       loadCombo();
       loadComboM();
    }

    void loadCombo() throws SQLException{
       jComboBox1.setModel(td.loadCombo());
   }
     void loadComboM() throws SQLException{
       jComboBox3.setModel(md.cargarCombo());
   }
   

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(160, 110, 160, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(220, 250, 270, 80);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Femenino");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(330, 160, 80, 23);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Masculino");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(190, 160, 80, 23);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES GUARDEÍA/btnVerRegistro200.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(410, 390, 220, 70);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES GUARDEÍA/btnGuardar200.png"))); // NOI18N
        jButton1.setText("jButton1");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 380, 220, 90);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES GUARDEÍA/Registro400.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 10, 380, 73);

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES GUARDEÍA/Atras50.png"))); // NOI18N
        jButton17.setBorderPainted(false);
        jButton17.setContentAreaFilled(false);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton17);
        jButton17.setBounds(20, 20, 84, 50);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tutor" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(160, 360, 150, 24);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maestro" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(450, 360, 140, 24);
        getContentPane().add(jDateChooser2);
        jDateChooser2.setBounds(170, 200, 140, 30);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES GUARDEÍA/regresarMenu135.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(510, -10, 150, 130);
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(440, 200, 140, 30);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(440, 110, 160, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES GUARDEÍA/formularioNiño5650.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 40, 640, 420);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES GUARDEÍA/cp926.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-210, -10, 850, 490);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 710, 470);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        TutorRegistro tutorRegistro = new TutorRegistro();
        tutorRegistro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        NiñoDatos niñoDatos;
         try {
             niñoDatos = new NiñoDatos();
             niñoDatos.setVisible(true);
        this.setVisible(false);
         } catch (SQLException ex) {
             Logger.getLogger(NiñoRegistro.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         String nombre = jTextField3.getText();
         int uno = nombre.length();
         String apellido = jTextField2.getText();
         int dos= apellido.length();
         String comen = jTextArea1.getText();
         int tres = comen.length();
//         String fecha1 = jDateChooser2.getDateFormatString();
//         int cuatro = fecha1.length();
//         String fecha2 = jDateChooser1.getDateFormatString();
//         int cinco = fecha2.length();
        
        if (uno==0||dos==0||tres==0) {
            JOptionPane.showMessageDialog(null, "Dejaste un campo vacio, vuelve a rellenarlos");
            jTextArea1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
        }else{
        
        try {
            if (crearp()!=0) {
                JOptionPane.showMessageDialog(null, "Éxito");
                
              
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NiñoRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        }                              
    }//GEN-LAST:event_jButton1ActionPerformed

    int crearp() throws SQLException{
        
        String nombre = jTextField3.getText();
        String apellido = jTextField2.getText();
        String sexo = null;
        Date fec = new java.sql.Date(jDateChooser2.getDate().getTime());
        Date fecnac = new java.sql.Date(jDateChooser1.getDate().getTime());
        String enf = jTextArea1.getText();
        int tut = (int) jComboBox1.getSelectedIndex();
        int mat = (int) jComboBox3.getSelectedIndex();
      
        if (jRadioButton1.isSelected()) {
        sexo="Masculino";
    }else if(jRadioButton2.isSelected()){
            sexo="Femenino";
        }
    
        Nino m = new Nino (nombre,apellido,sexo,fec,fecnac,enf,tut,mat);
        int id = nd.insertar(m);
        return id;
    }
    
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

  

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
            java.util.logging.Logger.getLogger(NiñoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NiñoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NiñoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NiñoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NiñoRegistro().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(NiñoRegistro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
