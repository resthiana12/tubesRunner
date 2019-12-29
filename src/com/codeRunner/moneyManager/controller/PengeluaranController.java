/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeRunner.moneyManager.controller;

import com.codeRunner.moneyManager.model.data.PendapatanModel;
import com.codeRunner.moneyManager.model.data.PengeluaranModel;
import com.codeRunner.moneyManager.model.pojo.Pendapatan;
import com.codeRunner.moneyManager.model.pojo.Pengeluaran;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author resthiana
 */
public class PengeluaranController {
    public List<Pengeluaran> loadPengeluaran() throws SQLException {
        PengeluaranModel model = new PengeluaranModel();
        return model.loadPengeluaran();
    }
    
    public int insert(Pengeluaran pengeluaran) throws SQLException {
        PengeluaranModel model = new PengeluaranModel();
        return model.save(pengeluaran);
    }
    
    public int delete(Pengeluaran pengeluaran) throws SQLException {
        PengeluaranModel model = new PengeluaranModel();
        return model.delete(pengeluaran);
    }

    public void tambahPengeluaran() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
