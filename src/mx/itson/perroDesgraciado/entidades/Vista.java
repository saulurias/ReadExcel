/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.perroDesgraciado.entidades;

import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *  Entidad que posee la vista del proyecto PerroDesgraciado
 * @author SaulUrias
 */
public class Vista extends javax.swing.JFrame {

    /**
     * Creates new form Vista
     */
    public Vista() {
        initComponents();  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSelectFile = new javax.swing.JButton();
        lblRutaArchivo = new javax.swing.JLabel();
        txtRutaArchivo = new javax.swing.JTextField();
        btnExportar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtHoras = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnSelectFile.setText("Seleccionar");
        btnSelectFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectFileActionPerformed(evt);
            }
        });
        getContentPane().add(btnSelectFile);
        btnSelectFile.setBounds(440, 40, 115, 29);

        lblRutaArchivo.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        lblRutaArchivo.setText("Ruta Archivo:");
        getContentPane().add(lblRutaArchivo);
        lblRutaArchivo.setBounds(30, 50, 120, 23);
        getContentPane().add(txtRutaArchivo);
        txtRutaArchivo.setBounds(163, 45, 270, 26);

        btnExportar.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        btnExportar.setText("Exportar Ahora");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });
        getContentPane().add(btnExportar);
        btnExportar.setBounds(210, 340, 180, 29);

        jLabel1.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 36)); // NOI18N
        jLabel1.setText("Migración De Datos");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 10, 340, 30);

        jLabel2.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 150, 80, 23);

        jLabel3.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        jLabel3.setText("Edad:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(190, 180, 60, 23);

        jLabel4.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        jLabel4.setText("Fecha:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(180, 220, 60, 23);

        jLabel5.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        jLabel5.setText("Horas:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(180, 250, 60, 23);

        txtNombre.setText("Nombre");
        getContentPane().add(txtNombre);
        txtNombre.setBounds(260, 140, 150, 26);

        txtEdad.setText("Edad");
        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });
        getContentPane().add(txtEdad);
        txtEdad.setBounds(260, 180, 150, 26);

        txtFecha.setText("Fecha");
        getContentPane().add(txtFecha);
        txtFecha.setBounds(260, 210, 150, 26);

        txtHoras.setText("Horas");
        getContentPane().add(txtHoras);
        txtHoras.setBounds(260, 250, 150, 26);

        jLabel6.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 24)); // NOI18N
        jLabel6.setText("Titulos Columnas:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(190, 90, 240, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * Acción que se genera al precionar el boton btnSelectFile
 * @param evt 
 */
    private void btnSelectFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectFileActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int ventana = fileChooser.showOpenDialog(null);
        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            txtRutaArchivo.setText(String.valueOf(file));
        }
    }//GEN-LAST:event_btnSelectFileActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
       
    }//GEN-LAST:event_txtEdadActionPerformed
/**
 * Acción que se genera al precionar el boton btnExportar
 * @param evt 
 */
    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        try {
        String fileName = txtRutaArchivo.getText();
        if (!fileName.equals("")) {
            try {
                new LectorExcel().Leer_Archivo_Excel(fileName, txtNombre.getText(), txtEdad.getText(), txtFecha.getText(), txtHoras.getText());
            } catch (SQLException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showConfirmDialog(null, "Favor de escorje una ruta");
        }
        
      }catch(Exception e){
          JOptionPane.showConfirmDialog(null, "Algo anda mal x.x");
          e.printStackTrace();
      }
        
        
    }//GEN-LAST:event_btnExportarActionPerformed

    
    
    
    
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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnSelectFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblRutaArchivo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHoras;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRutaArchivo;
    // End of variables declaration//GEN-END:variables
}
