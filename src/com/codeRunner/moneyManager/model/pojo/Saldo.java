/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeRunner.moneyManager.model.pojo;

/**
 *
 * @author resthiana
 */
public class Saldo {
    private int saldo;
    private int pengeluaran;

    public Saldo(int saldo) {
        this.saldo = saldo;
    }

    public Saldo() {
        
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getPengeluaran() {
        return pengeluaran;
    }

    public void setPengeluaran(int pengeluaran) {
        this.pengeluaran = pengeluaran;
    }

    public Saldo(int saldo, int pengeluaran) {
        this.saldo = saldo;
        this.pengeluaran = pengeluaran;
    }
    
    
}
