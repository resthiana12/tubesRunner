/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeRunner.moneyManager.controller;

import com.codeRunner.moneyManager.model.data.PendapatanModel;
import com.codeRunner.moneyManager.model.data.SaldoModel;
import com.codeRunner.moneyManager.model.pojo.Saldo;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author resthiana
 */
public class SaldoController {
    
    public void tambahSaldoPendapatan(Saldo saldo) throws SQLException{
        SaldoModel model = new SaldoModel();
        model.tambahSaldoPendapatan(saldo);
    }
    
    public void tambahTotalPengeluaran(Saldo saldo) throws SQLException{
        SaldoModel model = new SaldoModel();
        model.tambahTotalPengeluaran(saldo);
    }
    
    public void hapusSaldoPendapatan(Saldo saldo) throws SQLException {
        SaldoModel model = new SaldoModel();
        model.hapusSaldoPendapatan(saldo);
    }
    
    public void ubahSaldoPendapatan(Saldo saldo) throws SQLException{
        SaldoModel model = new SaldoModel();
        model.ubahSaldoPendapatan(saldo);
    }
    
    public void hapusTotalPengeluaran(Saldo saldo) throws SQLException {
        SaldoModel model = new SaldoModel();
        model.hapusTotalPengeluaran(saldo);
    }
    
    public void ubahTotalPengeluaran(Saldo saldo) throws SQLException{
        SaldoModel model = new SaldoModel();
        model.ubahTotalPengeluaran(saldo);
    }
    
    public int totalkanPendapatan() throws SQLException{
        SaldoModel model = new SaldoModel();
        return model.totalkanPendapatan();
    }
    
    public int saldoAkhir() throws SQLException {
        SaldoModel model = new SaldoModel();
        return model.saldoAkhir();
    }
}
