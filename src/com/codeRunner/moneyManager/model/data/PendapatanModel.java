/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeRunner.moneyManager.model.data;


import com.codeRunner.moneyManager.controller.PendapatanController;
import com.codeRunner.moneyManager.model.pojo.Pendapatan;
import com.codeRunner.moneyManager.utilities.DatabaseUtilities;
import com.codeRunner.moneyManager.view.PendapatanFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adind
 */
public class PendapatanModel {
    public List<Pendapatan> loadPendapatan() throws SQLException {
        List<Pendapatan> pendapatanList;
        Connection con = DatabaseUtilities.getConnection();
        try{
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM pendapatan");
            pendapatanList = new ArrayList<>();
            while (rs.next()){
                Pendapatan pendapatan = new Pendapatan();
                pendapatan.setIdPendapatan(rs.getString("id_pendapatan"));
                pendapatan.setTanggal(rs.getDate("tanggal"));
                pendapatan.setJumlah(rs.getInt("jumlah"));
                pendapatan.setCatatan(rs.getString("catatan"));
                pendapatan.setSaldo(rs.getInt("totalSaldo"));
                pendapatanList.add(pendapatan);
            }
        } finally {
            if(con != null){
                con.close();
            }
        }
        return pendapatanList;
    }
    
    
    public int save(Pendapatan pendapatan) throws SQLException {
        Connection con = DatabaseUtilities.getConnection();
        try{
            PreparedStatement stat = con.prepareStatement("INSERT INTO pendapatan VALUES(?,?,?,?,?)");
            stat.setString(1, pendapatan.getIdPendapatan());
            stat.setDate(2, pendapatan.getTanggal());
            stat.setInt(3, pendapatan.getJumlah());
            stat.setString(4, pendapatan.getCatatan());
            stat.setInt(5, pendapatan.getSaldo());
            return stat.executeUpdate();
        } finally {
            if(con != null){
                con.close();
            }
        }
    }
    
    
    public int delete(Pendapatan pendapatan) throws SQLException {
        Connection con = DatabaseUtilities.getConnection();
        try{
            PreparedStatement stat = con.prepareStatement("DELETE FROM pendapatan WHERE id_pendapatan =?");
            stat.setString(1, pendapatan.getIdPendapatan());
            return stat.executeUpdate();
        } finally {
            if(con != null){
                con.close();
            }
        }
    }
  
    

}

