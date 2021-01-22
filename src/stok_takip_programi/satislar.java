/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stok_takip_programi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CASPER
 */
public class satislar extends javax.swing.JFrame {

    /**
     * Creates new form satislar
     */
    
    
    private void satisurunGuncelle(){
    
     try {
            String baslik[] = new String[]{ "Kategori", "Ürün Adı", "Beden", "Renk", "Fiyat", "Adet", "Açıklama" };  
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");
            
            st = con.createStatement();                
            rs = st.executeQuery("select * from satislar ORDER BY id DESC");
            rs.last();
           
            int kayitsayisi = rs.getRow();
            rs.beforeFirst();

            Object data[][] = new Object[kayitsayisi][];
            int i = 0;

            while (rs.next()) {

                data[i] = new Object[]{  
                    
                    
                    rs.getString("kategori"),  
                    rs.getString("urunadi"),
                    rs.getString("beden"),
                    rs.getString("renk"),  
                    rs.getString("fiyat"),
                    rs.getString("adet"),
                    rs.getString("aciklama"), 
                };
                i++;
            }
           
            con.close();
            table_satistaki_urunler.setModel(new DefaultTableModel(data, baslik));
            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
    }
    
    private void UrunListeGuncelle(){
    
     try {
             String baslik[] = new String[]{"id","Kategori", "Ürün Adı", "Beden", "Renk", "Fiyat", "Adet", "Açıklama" };  
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");
            
            st = con.createStatement();                
            rs = st.executeQuery("select * from urunler");
            rs.last();
           
            int kayitsayisi = rs.getRow();
            rs.beforeFirst();

            Object data[][] = new Object[kayitsayisi][];
            int i = 0;

            while (rs.next()) {

                data[i] = new Object[]{  
                 rs.getInt("id"),
                    rs.getString("kategori"),  
                    rs.getString("urunadi"),
                    rs.getString("beden"),
                    rs.getString("renk"),  
                    rs.getString("fiyat"),
                    rs.getString("adet"),
                    rs.getString("aciklama"),
                       
                };
                i++;
            }
           
            con.close();
            table_urunler.setModel(new DefaultTableModel(data, baslik));
            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
    }
    
    
    public satislar() 
    {
        super("Satış Ekranı");
        initComponents();
        
        String baslik[] = new String[]{"id", "Kategori", "Ürün Adı", "Beden", "Renk", "Fiyat", "Adet", "Açıklama" };
        String baslik1[] = new String[]{"id", "Kategori", "Ürün Adı", "Beden", "Renk", "Fiyat", "Adet", "Açıklama" }; 

        try {
            
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;
            Statement st,st1 = null;
            ResultSet rs,rs1 = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");
            
            st = con.createStatement();  
            st1 = con.createStatement();
            rs = st.executeQuery("select * from urunler ORDER BY id DESC");
            rs1 = st1.executeQuery("select * from satislar ORDER BY id DESC");
            rs.last();
            rs1.last();
            
            int kayitsayisi = rs.getRow();
            rs.beforeFirst();

            Object data[][] = new Object[kayitsayisi][];
            int i = 0;

            while (rs.next()) {

                data[i] = new Object[]{  
                    
                    rs.getString("kategori"),  
                    rs.getString("urunadi"),
                    rs.getString("beden"),
                    rs.getString("renk"),  
                    rs.getString("fiyat"),
                    rs.getString("adet"),
                    rs.getString("aciklama"), 
                };
                i++;
            }
            //
            table_urunler.setModel(new DefaultTableModel(data, baslik));
            
            //
            int kayitsayisi1 = rs1.getRow();
            rs1.beforeFirst();

            Object data1[][] = new Object[kayitsayisi1][];
            int j = 0;

            while (rs1.next()) {

                data1[j] = new Object[]{  
                    
                    rs1.getString("id"),
                    rs1.getString("kategori"),  
                    rs1.getString("urunadi"),
                    rs1.getString("beden"),
                    rs1.getString("renk"),  
                    rs1.getString("fiyat"),
                    rs1.getString("adet"),
                    rs1.getString("aciklama"), 
                };
                j++;
            }
           
            //con.close();
            table_satistaki_urunler.setModel(new DefaultTableModel(data1, baslik1));
            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        
        UrunListeGuncelle();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_adet = new javax.swing.JTextField();
        lbl_fiyat2 = new javax.swing.JLabel();
        txt_aciklama = new javax.swing.JTextField();
        txt_beden = new javax.swing.JTextField();
        lbl_fiyat1 = new javax.swing.JLabel();
        lbl_adi = new javax.swing.JLabel();
        lbl_kategori = new javax.swing.JLabel();
        txt_adi = new javax.swing.JTextField();
        txt_guncelle = new javax.swing.JButton();
        lbl_renk = new javax.swing.JLabel();
        txt_kategori = new javax.swing.JTextField();
        lbl_fiyat = new javax.swing.JLabel();
        txt_renk = new javax.swing.JTextField();
        txt_fiyat = new javax.swing.JTextField();
        lbl_renk1 = new javax.swing.JLabel();
        lbl_filtrele = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_urunler = new javax.swing.JTable();
        txt_ara = new javax.swing.JTextField();
        btn_ara = new javax.swing.JButton();
        btn_cikis = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_satistaki_urunler = new javax.swing.JTable();
        lbl_satislar = new javax.swing.JLabel();
        lbl_stok = new javax.swing.JLabel();
        lbl_satis_filtrele = new javax.swing.JLabel();
        btn_satis_ara = new javax.swing.JButton();
        txt_satis_ara = new javax.swing.JTextField();
        resim = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(825, 670));
        setPreferredSize(new java.awt.Dimension(825, 670));
        getContentPane().setLayout(null);
        getContentPane().add(txt_adet);
        txt_adet.setBounds(76, 255, 170, 30);

        lbl_fiyat2.setText("Açıklama");
        getContentPane().add(lbl_fiyat2);
        lbl_fiyat2.setBounds(25, 311, 120, 14);
        getContentPane().add(txt_aciklama);
        txt_aciklama.setBounds(76, 303, 170, 30);
        getContentPane().add(txt_beden);
        txt_beden.setBounds(76, 118, 170, 30);

        lbl_fiyat1.setText("Adet");
        getContentPane().add(lbl_fiyat1);
        lbl_fiyat1.setBounds(25, 263, 100, 14);

        lbl_adi.setText("Ürün Adı");
        getContentPane().add(lbl_adi);
        lbl_adi.setBounds(25, 78, 90, 14);

        lbl_kategori.setText("Kategori");
        getContentPane().add(lbl_kategori);
        lbl_kategori.setBounds(26, 38, 70, 14);
        getContentPane().add(txt_adi);
        txt_adi.setBounds(76, 70, 170, 30);

        txt_guncelle.setText("Satışı Gerçekleştir");
        txt_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_guncelleActionPerformed(evt);
            }
        });
        getContentPane().add(txt_guncelle);
        txt_guncelle.setBounds(100, 360, 117, 23);

        lbl_renk.setText("Renk");
        getContentPane().add(lbl_renk);
        lbl_renk.setBounds(25, 174, 110, 14);
        getContentPane().add(txt_kategori);
        txt_kategori.setBounds(76, 30, 170, 30);

        lbl_fiyat.setText("Fiyat");
        getContentPane().add(lbl_fiyat);
        lbl_fiyat.setBounds(25, 215, 70, 14);
        getContentPane().add(txt_renk);
        txt_renk.setBounds(76, 166, 170, 30);
        getContentPane().add(txt_fiyat);
        txt_fiyat.setBounds(76, 207, 170, 30);

        lbl_renk1.setText("Beden");
        getContentPane().add(lbl_renk1);
        lbl_renk1.setBounds(25, 126, 80, 14);

        lbl_filtrele.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_filtrele.setText("Filtrele");
        getContentPane().add(lbl_filtrele);
        lbl_filtrele.setBounds(279, 35, 37, 17);

        table_urunler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_urunler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_urunlerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_urunler);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(279, 116, 509, 207);
        getContentPane().add(txt_ara);
        txt_ara.setBounds(326, 30, 170, 30);

        btn_ara.setText("Ara");
        btn_ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_araActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ara);
        btn_ara.setBounds(510, 34, 49, 23);

        btn_cikis.setText("ÇIKIŞ");
        btn_cikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cikisActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cikis);
        btn_cikis.setBounds(707, 11, 90, 23);

        table_satistaki_urunler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_satistaki_urunler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_satistaki_urunlerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_satistaki_urunler);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(280, 420, 509, 207);

        lbl_satislar.setText("Satışı Yapılan Ürünler");
        getContentPane().add(lbl_satislar);
        lbl_satislar.setBounds(280, 390, 160, 14);

        lbl_stok.setText("Stoktaki Ürünler");
        getContentPane().add(lbl_stok);
        lbl_stok.setBounds(279, 92, 170, 14);

        lbl_satis_filtrele.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_satis_filtrele.setText("Filtrele");
        getContentPane().add(lbl_satis_filtrele);
        lbl_satis_filtrele.setBounds(279, 338, 37, 17);

        btn_satis_ara.setText("Ara");
        btn_satis_ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_satis_araActionPerformed(evt);
            }
        });
        getContentPane().add(btn_satis_ara);
        btn_satis_ara.setBounds(510, 337, 49, 23);
        getContentPane().add(txt_satis_ara);
        txt_satis_ara.setBounds(326, 333, 170, 30);

        resim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(resim);
        resim.setBounds(0, 0, 820, 650);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_guncelleActionPerformed

        try {
            
            int row = table_urunler.getSelectedRow();            
            int secim_yap=Integer.parseInt((table_urunler.getValueAt(row, 0)).toString());
             
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");
            st = con.createStatement();
            
            rs = st.executeQuery("select * from urunler where id='"+secim_yap+"'");
            rs.next();
            
            int eski_adet=Integer.parseInt(rs.getString("adet"));            
            int satilan_adet = Integer.parseInt(txt_adet.getText());
            int kalan = eski_adet - satilan_adet;
            
            String sorgu1 = "UPDATE urunler SET kategori='"+txt_kategori.getText()+"'"
            +",urunadi='"+txt_adi.getText()+"'"
            +",beden='"+txt_beden.getText()+"'"
            +",renk='"+txt_renk.getText()+"'"
            +",fiyat='"+txt_fiyat.getText()+"'"
            +",adet='"+kalan+"'"
            +",aciklama='"+txt_aciklama.getText()+"' where id='"+secim_yap+"'";
            
            
            int fiyat = Integer.parseInt(txt_fiyat.getText());
            int Toplam_fiyat =fiyat;
            
            String sorgu = "INSERT INTO satislar (kategori,urunadi,beden,renk,fiyat,adet,aciklama)" 
                        + " VALUES ('"+txt_kategori.getText()+"', '"+txt_adi.getText()+"', '"+txt_beden.getText()+"'"
                        +", '"+txt_renk.getText()+"', '"+Toplam_fiyat+"', '"+txt_adet.getText()+"'"
                        +", '"+txt_aciklama.getText()+"')";
            
            
            
            st.executeUpdate(sorgu);
            st.executeUpdate(sorgu1);

            JOptionPane.showMessageDialog(null, txt_adi.getText() + " adlı ürün satılmışır.");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        
        satisurunGuncelle();
        UrunListeGuncelle();

    }//GEN-LAST:event_txt_guncelleActionPerformed

    private void table_urunlerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_urunlerMouseClicked

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement st1 =null;

        try {

            int row = table_urunler.getSelectedRow();            
            int secim_yap=Integer.parseInt((table_urunler.getValueAt(row, 0)).toString());
    
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");

            String sorgu = "select * from urunler where id='"+secim_yap+"'";
            
            st = con.createStatement();
            rs = st.executeQuery(sorgu);
      
               
            if(rs.last()){

                txt_kategori.setText(rs.getString("kategori"));
                txt_adi.setText(rs.getString("urunadi"));
                txt_beden.setText(rs.getString("beden"));
                txt_renk.setText(rs.getString("renk"));
                txt_fiyat.setText(rs.getString("fiyat"));
                txt_adet.setText(rs.getString("adet"));
                txt_aciklama.setText(rs.getString("aciklama"));
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
    }//GEN-LAST:event_table_urunlerMouseClicked

    private void btn_araActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_araActionPerformed

        String ara =txt_ara.getText();
        String baslik[] = new String[]{"Kategori", "Ürün Adı", "Beden", "Renk", "Fiyat", "Adet", "Açıklama" };

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");

            String sorgu ="select * from urunler where urunadi like '%"+txt_ara.getText()+"%' or"
            +" kategori like '%"+txt_ara.getText()+"%' or"
            +" beden like '%"+txt_ara.getText()+"%' or"
            +" renk like '%"+txt_ara.getText()+"%' ";

            st = con.createStatement();
            rs = st.executeQuery(sorgu);

            rs.last();

            int say = rs.getRow();
            rs.beforeFirst();

            String sayi = null;
            sayi = String.valueOf(rs.getRow());

            if(say < 1){
                JOptionPane.showMessageDialog(null, "Aradığınız Ürün Bulunamadı!");
            }
            else{
                Object data[][] = new Object[say][];
                int i = 0;

                while (rs.next()) {

                    data[i] = new Object[]{

                        rs.getString("kategori"),
                        rs.getString("urunadi"),
                        rs.getString("beden"),
                        rs.getString("renk"),
                        rs.getString("fiyat"),
                        rs.getString("adet"),
                        rs.getString("aciklama"),
                    };
                    i++;
                }
                table_urunler.setModel(new DefaultTableModel(data, baslik));
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }

    }//GEN-LAST:event_btn_araActionPerformed

    private void btn_cikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cikisActionPerformed

        urun_ekle a = new urun_ekle();
        a.setVisible(false);
        dispose();

    }//GEN-LAST:event_btn_cikisActionPerformed

    private void table_satistaki_urunlerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_satistaki_urunlerMouseClicked

        
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement st1 =null;

        try {

            int row = table_satistaki_urunler.getSelectedRow();            
            int secim_yap=Integer.parseInt((table_satistaki_urunler.getValueAt(row, 0)).toString());

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");

            String sorgu = "select * from satislar where id='"+secim_yap+"'";
            //st = con.createStatement();
            st = con.createStatement();
            rs = st.executeQuery(sorgu);
   
            if(rs.last()){

                txt_kategori.setText(rs.getString("kategori"));
                txt_adi.setText(rs.getString("urunadi"));
                txt_beden.setText(rs.getString("beden"));
                txt_renk.setText(rs.getString("renk"));
                txt_fiyat.setText(rs.getString("fiyat"));
                txt_adet.setText(rs.getString("adet"));
                txt_aciklama.setText(rs.getString("aciklama"));
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        
        
    }//GEN-LAST:event_table_satistaki_urunlerMouseClicked

    private void btn_satis_araActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_satis_araActionPerformed
        
        
        String baslik[] = new String[]{"Kategori", "Ürün Adı", "Beden", "Renk", "Fiyat", "Adet", "Açıklama" };

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");

            String sorgu ="select * from satislar where urunadi like '%"+txt_satis_ara.getText()+"%' or"
            +" kategori like '%"+txt_satis_ara.getText()+"%' or"
            +" beden like '%"+txt_satis_ara.getText()+"%' or"
            +" renk like '%"+txt_satis_ara.getText()+"%' or"
            +" adet like '%"+txt_satis_ara.getText()+"%' ";

            st = con.createStatement();
            rs = st.executeQuery(sorgu);

            rs.last();

            int say = rs.getRow();
            rs.beforeFirst();

            String sayi = null;
            sayi = String.valueOf(rs.getRow());

            if(say < 1){
                JOptionPane.showMessageDialog(null, "Aradığınız Ürün Bulunamadı!");
            }
            else{
                Object data[][] = new Object[say][];
                int i = 0;

                while (rs.next()) {

                    data[i] = new Object[]{

                        rs.getString("kategori"),
                        rs.getString("urunadi"),
                        rs.getString("beden"),
                        rs.getString("renk"),
                        rs.getString("fiyat"),
                        rs.getString("adet"),
                        rs.getString("aciklama"),
                    };
                    i++;
                }
                table_satistaki_urunler.setModel(new DefaultTableModel(data, baslik));
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        
    }//GEN-LAST:event_btn_satis_araActionPerformed

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
            java.util.logging.Logger.getLogger(satislar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(satislar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(satislar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(satislar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new satislar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ara;
    private javax.swing.JButton btn_cikis;
    private javax.swing.JButton btn_satis_ara;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_adi;
    private javax.swing.JLabel lbl_filtrele;
    private javax.swing.JLabel lbl_fiyat;
    private javax.swing.JLabel lbl_fiyat1;
    private javax.swing.JLabel lbl_fiyat2;
    private javax.swing.JLabel lbl_kategori;
    private javax.swing.JLabel lbl_renk;
    private javax.swing.JLabel lbl_renk1;
    private javax.swing.JLabel lbl_satis_filtrele;
    private javax.swing.JLabel lbl_satislar;
    private javax.swing.JLabel lbl_stok;
    private javax.swing.JLabel resim;
    private javax.swing.JTable table_satistaki_urunler;
    private javax.swing.JTable table_urunler;
    private javax.swing.JTextField txt_aciklama;
    private javax.swing.JTextField txt_adet;
    private javax.swing.JTextField txt_adi;
    private javax.swing.JTextField txt_ara;
    private javax.swing.JTextField txt_beden;
    private javax.swing.JTextField txt_fiyat;
    private javax.swing.JButton txt_guncelle;
    private javax.swing.JTextField txt_kategori;
    private javax.swing.JTextField txt_renk;
    private javax.swing.JTextField txt_satis_ara;
    // End of variables declaration//GEN-END:variables
}
