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
        txtBalance.setText(Integer.toString(sum()));
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
//           txtBalance.setText(Integer.toString(sumBalance));  
    }
    
    
       public void IDOtomatis() throws SQLException{
        Connection con = DatabaseUtilities.getConnection();
        PendapatanFrame frame = new PendapatanFrame();
        try{
            PreparedStatement stat = con.prepareStatement("SELECT MAX(right([id_pendapatan],3)) as [nama_alias] FROM [pendapatan]");
            Statement state = con.createStatement();
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                if(rs.first()==false){
                    txtIdPendapatan.setText("PDN-001");
                } else {
                    rs.last();
                    int autoid = rs.getInt(1) + 1;
                    String nomor = String.valueOf(autoid);
                    int noLong = nomor.length();
                    
                    for(int a=0; a<3-noLong; a++){
                        nomor = "0" + nomor;
                    } 
                    txtIdPendapatan.setText("PDN-" + nomor);
                }
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
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
        lblBalance = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        btnTambahData = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        dateChooserTanggal = new com.toedter.calendar.JDateChooser();

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
                "ID-Income ", "Tanggal ", "Jumlah ", "Catatan"
            }
        ));
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

        lblBalance.setText("Balance :");

        txtBalance.setEditable(false);
        txtBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBalanceActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBalance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
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
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(dateChooserTanggal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtJumlah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)))))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTambahData))
            .addGroup(layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(btnSimpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHapus))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTambahData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdPendapatan)
                    .addComponent(txtIdPendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTanggal)
                    .addComponent(dateChooserTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBalance)
                    .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
           status = con.delete(new Pendapatan(txtIdPendapatan.getText(),Date.valueOf(sdf.format((dateChooserTanggal.getDate()))),
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
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBalanceActionPerformed
        // TODO add your handling code here: 
    }//GEN-LAST:event_txtBalanceActionPerformed

    private void btnTambahDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahDataActionPerformed
        try {
            IDOtomatis();
        } catch (SQLException ex) {
            Logger.getLogger(PendapatanFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTambahDataActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        int status =0;
        
        try{
            DefaultTableModel model = (DefaultTableModel) tblPendapatan.getModel();
            sdf = new SimpleDateFormat("yyyy-M-d");
            status = con.insert(new Pendapatan(txtIdPendapatan.getText(),Date.valueOf(sdf.format((dateChooserTanggal.getDate()))),
                    Integer.valueOf(txtJumlah.getText()), textAreaCatatan.getText()));
            refreshTable();
        } catch(SQLException ex){
            Logger.getLogger(PendapatanFrame.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        if (status == 1){
            JOptionPane.showMessageDialog(this, "Pendapatan berhasil ditambahkan");
        } else {
            JOptionPane.showMessageDialog(this, "Pendapatan gagal ditambahkan");
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahData;
    private com.toedter.calendar.JDateChooser dateChooserTanggal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblCatatan;
    private javax.swing.JLabel lblIdPendapatan;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JTable tblPendapatan;
    private javax.swing.JTextArea textAreaCatatan;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtIdPendapatan;
    private javax.swing.JTextField txtJumlah;
    // End of variables declaration//GEN-END:variables
}
