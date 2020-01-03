/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeRunner.moneyManager.model.data;

import com.codeRunner.moneyManager.model.pojo.Saldo;
import com.codeRunner.moneyManager.utilities.DatabaseUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author resthiana
 */
public class SaldoModel {
    
     public void hapusSaldo(Saldo saldo) throws SQLException {
        Connection con = DatabaseUtilities.getConnection();
        try{
            PreparedStatement stat = con.prepareStatement("ON DELETE CASCADE FROM saldobalance WHERE id = ?");
            stat.setInt(1, saldo.getId());
            stat.executeUpdate();
        } finally {
            if(con != null){
                con.close();
            }
        }
    }
     
    public void tambahSaldo(Saldo saldo) throws SQLException{
        Connection con = DatabaseUtilities.getConnection();
        try{
            PreparedStatement stat = con.prepareStatement("INSERT INTO saldobalance(id_pendapatan, saldo) VALUES (?, ?)");
            stat.setString(1, saldo.getIdPendapatan());
            stat.setInt(2, saldo.getSaldo());
            stat.executeUpdate();
        } finally {
            if(con != null){
                con.close();
            }
        }
    }
}
