/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeRunner.moneyManager.model.data;

import com.codeRunner.moneyManager.model.pojo.Pendapatan;
import com.codeRunner.moneyManager.model.pojo.Saldo;
import com.codeRunner.moneyManager.utilities.DatabaseUtilities;
import com.codeRunner.moneyManager.view.PendapatanFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author resthiana
 */
public class SaldoModel {
    
     public void hapusSaldoPendapatan(Saldo saldo) throws SQLException {
        Connection con = DatabaseUtilities.getConnection();
        try{
            PreparedStatement stat = con.prepareStatement("DELETE FROM saldobalance WHERE id_pendapatan = ?");
            stat.setString(1, saldo.getIdPendapatan());
            stat.executeUpdate();
        } finally {
            if(con != null){
                con.close();
            }
        }
    }
     
    public void tambahSaldoPendapatan(Saldo saldo) throws SQLException{
        Connection con = DatabaseUtilities.getConnection();
        try{
            PreparedStatement stat = con.prepareStatement("INSERT INTO saldobalance(id_pendapatan, jumlah) VALUES (?, ?)");
            stat.setString(1, saldo.getIdPendapatan());
            stat.setInt(2, saldo.getJumlah());
            stat.executeUpdate();
        } finally {
            if(con != null){
                con.close();
            }
        }
    }
    
    public void tambahSaldoPengeluaran(Saldo saldo) throws SQLException{
        Connection con = DatabaseUtilities.getConnection();
        try{
            PreparedStatement stat = con.prepareStatement("INSERT INTO saldobalance(id_pengeluaran, jumlah) VALUES (?, ?)");
            stat.setString(1, saldo.getIdPengeluaran());
            stat.setInt(2, saldo.getJumlah());
            stat.executeUpdate();
        } finally {
            if(con != null){
                con.close();
            }
        }
    }

    public void ubahSaldoPendapatan(Saldo saldo) throws SQLException {
         Connection con = DatabaseUtilities.getConnection();
          try{
            PreparedStatement stat = con.prepareStatement("UPDATE saldobalance SET jumlah = ? WHERE id_pendapatan = ?");
            stat.setInt(1, saldo.getJumlah());
            stat.setString(2, saldo.getIdPendapatan());
            stat.executeUpdate();
          } finally{
              if(con != null){
                  con.close();
              }
          }
    }
}
