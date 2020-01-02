/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeRunner.moneyManager.controller;
import com.codeRunner.moneyManager.model.pojo.Pendapatan;
import com.codeRunner.moneyManager.model.data.PendapatanModel;
import com.codeRunner.moneyManager.model.pojo.Saldo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author adind
 */
public class PendapatanController {
    public List<Pendapatan> loadPendapatan() throws SQLException {
        PendapatanModel model = new PendapatanModel();
        return model.loadPendapatan();
    }
    
    public int insert(Pendapatan pendapatan) throws SQLException {
        PendapatanModel model = new PendapatanModel();
        return model.save(pendapatan);
    }
    
    
    public int delete(Pendapatan pendapatan) throws SQLException {
        PendapatanModel model = new PendapatanModel();
        return model.delete(pendapatan);
    }
    
    public int tambahSaldo(Saldo saldo) throws SQLException{
        PendapatanModel model = new PendapatanModel();
        return model.tambahSaldo(saldo);
    }
    
   

//    public int updateSaldo(Saldo saldo) throws SQLException {
//        PendapatanModel model = new PendapatanModel();
//        //return model.updateSaldo(saldo);
//    }
//     public int update(Pendapatan pendapatan) throws SQLException{
//          PendapatanModel model = new PendapatanModel();
//          return model.update(pendapatan);
//      }
    
    public int update(Pendapatan pendapatan) throws SQLException{
        PendapatanModel model = new PendapatanModel();
        return model.update(pendapatan);
    }
}
