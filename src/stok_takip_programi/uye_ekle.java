/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stok_takip_programi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author CASPER
 */
public class uye_ekle extends javax.swing.JFrame {

    /**
     * Creates new form uye_ekle
     */
    public uye_ekle() {
        
         super("Üye Ekle Formu");  
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

        lbl_kategori = new javax.swing.JLabel();
        lbl_kadi = new javax.swing.JLabel();
        lbl_parola = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        txt_kategori = new javax.swing.JTextField();
        txt_kadi = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        btn_uye_ekle = new javax.swing.JButton();
        txt_parola = new javax.swing.JPasswordField();
        btn_cikis = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(410, 320));
        setPreferredSize(new java.awt.Dimension(410, 320));
        getContentPane().setLayout(null);

        lbl_kategori.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_kategori.setText("Kategori");
        getContentPane().add(lbl_kategori);
        lbl_kategori.setBounds(50, 40, 50, 17);

        lbl_kadi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_kadi.setText("Kullanıcı Adı");
        getContentPane().add(lbl_kadi);
        lbl_kadi.setBounds(40, 90, 68, 17);

        lbl_parola.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_parola.setText("Parola");
        getContentPane().add(lbl_parola);
        lbl_parola.setBounds(50, 140, 37, 17);

        lbl_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_email.setText("E-Posta");
        getContentPane().add(lbl_email);
        lbl_email.setBounds(50, 190, 47, 17);
        getContentPane().add(txt_kategori);
        txt_kategori.setBounds(130, 30, 170, 30);
        getContentPane().add(txt_kadi);
        txt_kadi.setBounds(130, 80, 170, 30);
        getContentPane().add(txt_email);
        txt_email.setBounds(130, 180, 170, 30);

        btn_uye_ekle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_uye_ekle.setText("Kaydet");
        btn_uye_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_uye_ekleActionPerformed(evt);
            }
        });
        getContentPane().add(btn_uye_ekle);
        btn_uye_ekle.setBounds(130, 240, 170, 34);
        getContentPane().add(txt_parola);
        txt_parola.setBounds(130, 130, 170, 30);

        btn_cikis.setText("ÇIKIŞ");
        btn_cikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cikisActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cikis);
        btn_cikis.setBounds(309, 10, 80, 23);

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_uye_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uye_ekleActionPerformed
        
            String kategori=txt_kategori.getText();
            String kadi=txt_kadi.getText();
            String parola=txt_parola.getText();
            String email=txt_email.getText();
                
            try {
                    
                if (kategori.equals("") || kadi.equals("") || parola.equals("") || email.equals("")) {

                    JOptionPane.showMessageDialog(this, "Lütfen Boş Alanları Doldurunuz!");

                } else {            
                    Class.forName("com.mysql.jdbc.Driver");

                    Connection con = null;
                    Statement st = null;
                    ResultSet rs = null;
                    
                    con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");
                    st = con.createStatement();
                    
                    String sql = "INSERT INTO uyeler (kategori,kadi,parola,email)" 
                            + " VALUES ('"+kategori+"', '"+kadi+"', '"+parola+"', '"+email+"')";

                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Hoşgeldiniz " + kadi);
            
                }
            
            } catch (ClassNotFoundException ex) {
                 JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
            }  
        
    }//GEN-LAST:event_btn_uye_ekleActionPerformed

    private void btn_cikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cikisActionPerformed

        raporlar kapat = new raporlar();
        kapat.setVisible(false);
        dispose();
    }//GEN-LAST:event_btn_cikisActionPerformed

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
            java.util.logging.Logger.getLogger(uye_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uye_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uye_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uye_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new uye_ekle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cikis;
    private javax.swing.JButton btn_uye_ekle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_kadi;
    private javax.swing.JLabel lbl_kategori;
    private javax.swing.JLabel lbl_parola;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_kadi;
    private javax.swing.JTextField txt_kategori;
    private javax.swing.JPasswordField txt_parola;
    // End of variables declaration//GEN-END:variables
}
