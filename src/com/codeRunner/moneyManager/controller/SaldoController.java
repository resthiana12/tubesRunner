/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeRunner.moneyManager.controller;

import com.codeRunner.moneyManager.model.data.PendapatanModel;
import com.codeRunner.moneyManager.model.data.SaldoModel;
import com.codeRunner.moneyManager.model.pojo.Saldo;
import java.sql.SQLException;

/**
 *
 * @author resthiana
 */
public class SaldoController {
    
    public void tambahSaldo(Saldo saldo) throws SQLException{
        SaldoModel model = new SaldoModel();
        model.tambahSaldo(saldo);
    }
    
    public void hapusSaldo(Saldo saldo) throws SQLException {
        SaldoModel model = new SaldoModel();
        model.hapusSaldo(saldo);
    }
    
}
