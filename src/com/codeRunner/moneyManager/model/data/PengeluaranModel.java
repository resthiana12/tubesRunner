/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeRunner.moneyManager.model.data;
import com.codeRunner.moneyManager.model.pojo.Pengeluaran;
import com.codeRunner.moneyManager.utilities.DatabaseUtilities;
import com.codeRunner.moneyManager.view.PendapatanFrame;
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
                pengeluaran.setIdPengeluaran(rs.getString("id_pengeluaran"));
                pengeluaran.setTanggalPilih(rs.getDate("tanggal_pilih"));
                pengeluaran.setTransportasi(rs.getInt("transportasi"));
                pengeluaran.setMakanan(rs.getInt("makanan"));
                pengeluaran.setKesehatan(rs.getInt("kesehatan"));
                pengeluaran.setKecantikan(rs.getInt("kecantikan"));
                pengeluaran.setPakaian(rs.getInt("pakaian"));
                pengeluaran.setKomunikasi(rs.getInt("komunikasi"));
                pengeluaran.setLainnya(rs.getInt("lainnya"));
                pengeluaran.setJumlah(rs.getInt("jumlah"));
                pengeluaran.setCatatan(rs.getString("catatan"));
                
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
                stat.setString(1, pengeluaran.getIdPengeluaran());
                stat.setDate(2, pengeluaran.getTanggalPilih());
                stat.setInt(3, pengeluaran.getTransportasi());
                stat.setInt(4, pengeluaran.getMakanan());
                stat.setInt(5, pengeluaran.getKesehatan());
                stat.setInt(6, pengeluaran.getKecantikan());
                stat.setInt(7, pengeluaran.getPakaian());
                stat.setInt(8, pengeluaran.getKomunikasi());
                stat.setInt(9, pengeluaran.getLainnya());
                stat.setInt(10, pengeluaran.getJumlah());
                stat.setString(11, pengeluaran.getCatatan());
            return stat.executeUpdate();
        } finally {
            if(con != null){
                con.close();
            }
        }
    }
    
    public int delete(Pengeluaran pengeluaran) throws SQLException{
        Connection con = DatabaseUtilities.getConnection();
        try{
            String query = "DELETE FROM pengeluaran WHERE id_pengeluaran = ?";
            PreparedStatement stat = con.prepareStatement(query);
            stat.setString(1, pengeluaran.getIdPengeluaran());
            return stat.executeUpdate();
        } finally {
            if(con != null){
                con.close();
            }
        }
    }
    
   public int update(Pengeluaran pengeluaran) throws SQLException{
       Connection con = DatabaseUtilities.getConnection();
        try{
            PreparedStatement stat = con.prepareStatement("UPDATE pengeluaran SET tanggal_pilih = ?,transportasi = ?, makanan = ?, kesehatan = ?, kecantikan = ?,pakaian = ?, komunikasi = ?, lainnya = ?,jumlah = ?, catatan = ?WHERE id_pengeluaran = ?");
            stat.setDate(1, pengeluaran.getTanggalPilih());
            stat.setInt(2, pengeluaran.getTransportasi());
            stat.setInt(3, pengeluaran.getMakanan());
            stat.setInt(4, pengeluaran.getKesehatan());
             stat.setInt(5, pengeluaran.getKecantikan());
             stat.setInt(6, pengeluaran.getPakaian());
             stat.setInt(7, pengeluaran.getKomunikasi());
             stat.setInt(8, pengeluaran.getLainnya());
             stat.setInt(9, pengeluaran.getJumlah());
             stat.setString(10, pengeluaran.getCatatan());
             stat.setString(11, pengeluaran.getIdPengeluaran());
             return stat.executeUpdate();
        }finally{
            if (con !=null){
                con.close();
            }
            
        }
    }
    
}
