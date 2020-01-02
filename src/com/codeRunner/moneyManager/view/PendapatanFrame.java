/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeRunner.moneyManager.view;

import javax.swing.table.DefaultTableModel;
import com.codeRunner.moneyManager.model.pojo.Pendapatan;
import com.codeRunner.moneyManager.controller.PendapatanController;
import com.codeRunner.moneyManager.model.data.PendapatanModel;
import com.codeRunner.moneyManager.model.pojo.Saldo;
import com.codeRunner.moneyManager.utilities.DatabaseUtilities;
import java.sql.Connection;
import java.util.logging.Logger;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 *
 * @author adind
 */
public class PendapatanFrame extends javax.swing.JFrame {
    PendapatanController con = new PendapatanController();
    private DefaultTableModel model;
    SimpleDateFormat sdf;

    /**
     * Creates new form IncomeFrame
     */
    public PendapatanFrame() throws SQLException{
        initComponents();
        populateDataToTable();
        sum();
        
      txtSaldo.setText(String.valueOf(sum()));
    }
    
    
    public void populateDataToTable() throws SQLException{
        model = (DefaultTableModel) tblPendapatan.getModel();
        List<Pendapatan> pendapatan = con.loadPendapatan();
        
        for(Pendapatan p : pendapatan) {
            Object[] row = new Object[4];
            row[0] = p.getIdPendapatan();
            row[1] = p.getTanggal();
            row[2] = p.getJumlah();
            row[3] = p.getCatatan();
            model.addRow(row);
        }
    }
    
    
    public void refreshTable() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tblPendapatan.getModel();
        model.setRowCount(0);
        populateDataToTable();
    }
    
    public int sum() throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tblPendapatan.getModel();
        int jumlah = model.getRowCount();
        int sumBalance = 0;
        for (int i = 0; i < jumlah; i++) {
            int dataJumlah = Integer.valueOf(model.getValueAt(i, 2).toString());
            sumBalance += dataJumlah;
        }
//        con.sumBalance(sumBalance);
          return sumBalance;
//          txtSaldo.setText(String.valueOf(sumBalance));
    }
  
        
        
     public void autonumber() throws SQLException{
        Connection con = DatabaseUtilities.getConnection();
        try {
            PreparedStatement stat = con.prepareStatement("SELECT * FROM pendapatan");
            Statement state = con.createStatement();
            ResultSet rs = stat.executeQuery();
            rs.last();
            int baris = rs.getRow();
            String baru;
            if (baris == 0) {
                baru = "PDN-001";
            } else {
                int tambah = Integer.valueOf(rs.getString(1).substring(6,7)) + 1;
                if (tambah < 10) {
                    baru = "PDN-00" + tambah;
                } else if (tambah < 100) {
                    baru = "PDN-0" + tambah;
                } else {
                    baru = "PDN-" + tambah;
                }
            }

            txtIdPendapatan.setText(baru);
        } catch (SQLException ex) {
            System.out.println("Error di autonumber pegawai" + ex);
        }
    }
     
     public void bersihkanField(){
        txtIdPendapatan.setText("");
        dateTanggalChooser.setCalendar(null);
        txtJumlah.setText("");
        textAreaCatatan.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIdPendapatan = new javax.swing.JLabel();
        lblJumlah = new javax.swing.JLabel();
        lblCatatan = new javax.swing.JLabel();
        lblTanggal = new javax.swing.JLabel();
        txtIdPendapatan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPendapatan = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        txtJumlah = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaCatatan = new javax.swing.JTextArea();
        btnTambahData = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        dateTanggalChooser = new com.toedter.calendar.JDateChooser();
        txtSaldo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblCari = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Income");

        lblIdPendapatan.setText("ID-Pendapatan : ");

        lblJumlah.setText("Jumlah : ");

        lblCatatan.setText("Catatan :");

        lblTanggal.setText("Tanggal :");

        txtIdPendapatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPendapatanActionPerformed(evt);
            }
        });

        tblPendapatan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID-Pendapatan", "Tanggal ", "Jumlah ", "Catatan"
            }
        ));
        tblPendapatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPendapatanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPendapatan);

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        txtJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahActionPerformed(evt);
            }
        });

        textAreaCatatan.setColumns(20);
        textAreaCatatan.setRows(5);
        jScrollPane2.setViewportView(textAreaCatatan);

        btnTambahData.setText("Tambah Data Pendapatan!");
        btnTambahData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahDataActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        txtSaldo.setEditable(false);

        jLabel1.setText("Total Saldo");

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lblCari.setText("Cari data berdasarkan ID :");

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCari)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCari)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCari)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblIdPendapatan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIdPendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblTanggal)
                                                .addGap(42, 42, 42))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblCatatan)
                                                    .addComponent(lblJumlah))
                                                .addGap(41, 41, 41)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnSimpan)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnEdit)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnHapus))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(dateTanggalChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtJumlah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnTambahData)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTambahData, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIdPendapatan)
                            .addComponent(txtIdPendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTanggal)
                            .addComponent(dateTanggalChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblJumlah)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCatatan)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdPendapatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPendapatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPendapatanActionPerformed

    private void txtJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
       int status = 0;
       
       
       Pendapatan pendapatan = new Pendapatan();
       try {
           DefaultTableModel model = (DefaultTableModel) tblPendapatan.getModel();
           sdf = new SimpleDateFormat("yyyy-M-d");
           status = con.delete(new Pendapatan(txtIdPendapatan.getText(),Date.valueOf(sdf.format((dateTanggalChooser.getDate()))),
                   Integer.valueOf(txtJumlah.getText()),textAreaCatatan.getText()));
           refreshTable();
       } catch( SQLException ex ){
           Logger.getLogger(PendapatanFrame.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       if(status == 1){
           JOptionPane.showMessageDialog(this, "Pendapatan berhasil di hapus!");
       } else {
           JOptionPane.showMessageDialog(this, "Pendapatan gagal di hapus!");
 
       }
       bersihkanField();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnTambahDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahDataActionPerformed
        try {
            autonumber();
        } catch (SQLException ex) {
            Logger.getLogger(PendapatanFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTambahDataActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        int status =0;
        
        try{
            DefaultTableModel model = (DefaultTableModel) tblPendapatan.getModel();
            sdf = new SimpleDateFormat("yyyy-M-d");
            status = con.insert(new Pendapatan(
                    txtIdPendapatan.getText(),
                    Date.valueOf(sdf.format((dateTanggalChooser.getDate()))),
                    Integer.valueOf(txtJumlah.getText()), 
                    textAreaCatatan.getText()
            ));     
            
            refreshTable();
        } catch(SQLException ex){
            Logger.getLogger(PendapatanFrame.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        if (status == 1){
            JOptionPane.showMessageDialog(this, "Pendapatan berhasil ditambahkan");
        } else {
            JOptionPane.showMessageDialog(this, "Pendapatan gagal ditambahkan");
        }
        bersihkanField();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tblPendapatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPendapatanMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblPendapatan.getModel();
        int selectedIndex = tblPendapatan.getSelectedRow();
       
        txtIdPendapatan.setText(model.getValueAt(selectedIndex, 0).toString());
        dateTanggalChooser.setDate(Date.valueOf(model.getValueAt(selectedIndex, 1).toString()));
        txtJumlah.setText(model.getValueAt(selectedIndex, 2).toString());
        textAreaCatatan.setText(model.getValueAt(selectedIndex, 3).toString());
    }//GEN-LAST:event_tblPendapatanMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int status = 0;
        Pendapatan pendapatan = new Pendapatan();
        try {
            DefaultTableModel model = (DefaultTableModel)tblPendapatan.getModel();
            sdf = new SimpleDateFormat("yyy-M-d");
            status = con.update(new Pendapatan(txtIdPendapatan.getText(),
                   Date.valueOf(sdf.format(dateTanggalChooser.getDate())),
                   Integer.valueOf(txtJumlah.getText()),
                   textAreaCatatan.getText()));
            refreshTable();
        } catch (SQLException ex) {
            Logger.getLogger(PengeluaranFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
         if(status == 1){
           JOptionPane.showMessageDialog(this, "Pengeluaran berhasil diubah!");
       } else{
           JOptionPane.showMessageDialog(this, "Pengeluaran gagal diubah!");
       }
         bersihkanField();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        Connection con = DatabaseUtilities.getConnection();
        String a,d;
        Date b;
        int c;
        try {
            Object[] row = {"ID-Pendapatan", "Tanggal", "Jumlah", "Catatan"};
            DefaultTableModel model = new DefaultTableModel(null, row);
            tblPendapatan.setModel(model);
            PreparedStatement stat = con.prepareStatement("SELECT * FROM pendapatan where id_pendapatan = '" + txtCari.getText() + "'");
            Statement state = con.createStatement();
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                a = rs.getString("id_pendapatan");
                b = rs.getDate("tanggal");
                c = rs.getInt("jumlah");
                d = rs.getString("catatan");
                Object[] data = {a, b, c, d,};
                model.addRow(data);
            }
        } catch (SQLException ex) {
            System.out.println("Error di cari pegawai" + ex);
        }
        txtCari.setText("");
    }//GEN-LAST:event_btnCariActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahData;
    private com.toedter.calendar.JDateChooser dateTanggalChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblCatatan;
    private javax.swing.JLabel lblIdPendapatan;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JTable tblPendapatan;
    private javax.swing.JTextArea textAreaCatatan;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdPendapatan;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
