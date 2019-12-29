/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeRunner.moneyManager.main;
import com.codeRunner.moneyManager.view.PendapatanFrame;

import java.sql.SQLException;

/**
 *
 * @author adind
 */
public class MainProgram {
    public static void main (String[] args) throws SQLException{
        new PendapatanFrame().setVisible(true);
    }
    
}
