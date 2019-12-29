/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeRunner.moneyManager.model.data;

import com.codeRunner.moneyManager.model.pojo.Pendapatan;
import com.codeRunner.moneyManager.model.pojo.Pengeluaran;
import com.codeRunner.moneyManager.utilities.DatabaseUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author resthiana
 */
public class PengeluaranModel {
    public List<Pengeluaran> loadPengeluaran() throws SQLException {
        List<Pengeluaran> pengeluaranList;
        Connection con = DatabaseUtilities.getConnection();
        try{
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM pengeluaran");
            pengeluaranList = new ArrayList<>();
            while (rs.next()){
                Pengeluaran pengeluaran = new Pengeluaran();
                pengeluaran.setIdExpenses(rs.getInt("id_expenses"));
                pengeluaran.setTanggal(rs.getDate("tanggal"));
                pengeluaran.setTransport(rs.getInt("transport"));
                pengeluaran.setFoodstuff(rs.getInt("foodstuff"));
                pengeluaran.setHealth(rs.getInt("health"));
                pengeluaran.setBeauty(rs.getInt("beauty"));
                pengeluaran.setFashion(rs.getInt("fashion"));
                pengeluaran.setCommunication(rs.getInt("communication"));
                pengeluaran.setOthers(rs.getInt(rs.getInt("others")));
                pengeluaran.setJumlah(rs.getInt("jumlah"));
                pengeluaran.setNote(rs.getString("note"));
                
                pengeluaranList.add(pengeluaran);
            }
        } finally {
            if(con != null){
                con.close();
            }
        }
        return pengeluaranList;
    }
    
    
    public int save(Pengeluaran pengeluaran) throws SQLException {
        Connection con = DatabaseUtilities.getConnection();
        try{
            PreparedStatement stat = con.prepareStatement("INSERT INTO pengeluaran VALUES(?,?,?,?,?,?,?,?,?,?,?)");
                stat.setInt(1, pengeluaran.getIdExpenses());
                stat.setDate(2, pengeluaran.getTanggal());
                stat.setInt(3, pengeluaran.getTransport());
                stat.setInt(4, pengeluaran.getFoodstuff());
                stat.setInt(5, pengeluaran.getHealth());
                stat.setInt(6, pengeluaran.getBeauty());
                stat.setInt(7, pengeluaran.getFashion());
                stat.setInt(8, pengeluaran.getCommunication());
                stat.setInt(9, pengeluaran.getOthers());
                stat.setInt(10, pengeluaran.getJumlah());
                stat.setString(11, pengeluaran.getNote());
            return stat.executeUpdate();
        } finally {
            if(con != null){
                con.close();
            }
        }
    }
    
    public int delete(Pengeluaran pengeluaran) throws SQLException {
        Connection con = DatabaseUtilities.getConnection();
        try{
            PreparedStatement stat = con.prepareStatement("DELETE FROM pengeluarann WHERE id_expenses =?");
            stat.setInt(1, pengeluaran.getIdExpenses());
            return stat.executeUpdate();
        } finally {
            if(con != null){
                con.close();
            }
        }
    }
    
}
