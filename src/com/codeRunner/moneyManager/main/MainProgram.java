/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeRunner.moneyManager.main;
import com.codeRunner.moneyManager.model.pojo.Pengeluaran;
import com.codeRunner.moneyManager.view.PendapatanFrame;
import com.codeRunner.moneyManager.view.PengeluaranFrame;

import java.sql.SQLException;

/**
 *
 * @author adind
 */
public class MainProgram {
    public static void main (String[] args) throws SQLException{
        new PengeluaranFrame().setVisible(true);
    }
    
}
