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
public class uye_giris extends javax.swing.JFrame {

    /**
     * Creates new form uye_giris
     */
    public uye_giris() {
        
        super("Üye Girişi Formu");
        
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

        lbl_kadi = new javax.swing.JLabel();
        lbl_sifre = new javax.swing.JLabel();
        txt_kadi = new javax.swing.JTextField();
        txt_sifre = new javax.swing.JPasswordField();
        btn_giris = new javax.swing.JButton();
        lbl_sifremi_unuttum = new javax.swing.JLabel();
        btn_cikis = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(410, 310));
        setPreferredSize(new java.awt.Dimension(410, 310));
        getContentPane().setLayout(null);

        lbl_kadi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_kadi.setText("Kullanıcı Adı");
        getContentPane().add(lbl_kadi);
        lbl_kadi.setBounds(80, 100, 68, 17);

        lbl_sifre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_sifre.setText("Şifre");
        getContentPane().add(lbl_sifre);
        lbl_sifre.setBounds(80, 170, 26, 17);
        getContentPane().add(txt_kadi);
        txt_kadi.setBounds(170, 100, 170, 30);
        getContentPane().add(txt_sifre);
        txt_sifre.setBounds(170, 160, 170, 30);

        btn_giris.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_giris.setText("Giriş");
        btn_giris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_girisActionPerformed(evt);
            }
        });
        getContentPane().add(btn_giris);
        btn_giris.setBounds(170, 220, 170, 36);

        lbl_sifremi_unuttum.setText("Şifremi Unuttum");
        lbl_sifremi_unuttum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_sifremi_unuttum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_sifremi_unuttumMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_sifremi_unuttum);
        lbl_sifremi_unuttum.setBounds(220, 280, 76, 14);

        btn_cikis.setText("ÇIKIŞ");
        btn_cikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cikisActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cikis);
        btn_cikis.setBounds(309, 20, 80, 23);

        jLabel1.setMaximumSize(new java.awt.Dimension(400, 300));
        jLabel1.setMinimumSize(new java.awt.Dimension(400, 300));
        jLabel1.setPreferredSize(new java.awt.Dimension(400, 300));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_girisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_girisActionPerformed
        
            String kadi=txt_kadi.getText();
            String parola=txt_sifre.getText();
            new urun_ekle().genel_kadi=txt_kadi.getText();
                
            try {
                    
                if (kadi.equals("") || parola.equals("")) {

                    JOptionPane.showMessageDialog(this, "Lütfen Boş Alanları Doldurunuz!");

                } else {            
                    Class.forName("com.mysql.jdbc.Driver");

                    Connection con = null;
                    Statement st = null;
                    ResultSet rs = null;
                    
                    con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");
                    st = con.createStatement();
                    
                    rs = st.executeQuery("select * from uyeler where kadi='"+kadi+"' and parola='"+parola+"'");
                    
                    if(rs.last()){
                        
                        if(rs.getString("kategori").equals("Müdür")){
                            raporlar ac = new raporlar();
                            ac.setVisible(true);
                        }
                        else if(rs.getString("kategori").equals("Satış Danışmanı")){
                            satislar ac = new satislar();
                            ac.setVisible(true);
                        }
                        else if(rs.getString("kategori").equals("Depocu")){
                            urun_ekle ac = new urun_ekle();
                            ac.setVisible(true);
                        }
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Kullanıcı Adı veya Parola Hatalı! "); 
                    }
                }
            
            } catch (ClassNotFoundException ex) {
                 JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
            }
        
    }//GEN-LAST:event_btn_girisActionPerformed

    private void lbl_sifremi_unuttumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_sifremi_unuttumMouseClicked
        
        unuttum goster = new unuttum();
        goster.setVisible(true);
        
    }//GEN-LAST:event_lbl_sifremi_unuttumMouseClicked

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
            java.util.logging.Logger.getLogger(uye_giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uye_giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uye_giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uye_giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new uye_giris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cikis;
    private javax.swing.JButton btn_giris;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_kadi;
    private javax.swing.JLabel lbl_sifre;
    private javax.swing.JLabel lbl_sifremi_unuttum;
    private javax.swing.JTextField txt_kadi;
    private javax.swing.JPasswordField txt_sifre;
    // End of variables declaration//GEN-END:variables
}
