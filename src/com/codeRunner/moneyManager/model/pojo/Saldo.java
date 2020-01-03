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
    private int id;
    private String idPendapatan;
    private String idPengeluaran;
    private int saldo;

    public Saldo(int id, String idPendapatan, String idPengeluaran, int saldo) {
        this.id = id;
        this.idPendapatan = idPendapatan;
        this.idPengeluaran = idPengeluaran;
        this.saldo = saldo;
    }

    public Saldo() {
    }

    public Saldo(String idPendapatan, int jumlah) {
        this.idPendapatan = idPendapatan;
        this.saldo = jumlah;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdPendapatan() {
        return idPendapatan;
    }

    public void setIdPendapatan(String idPendapatan) {
        this.idPendapatan = idPendapatan;
    }

    public String getIdPengeluaran() {
        return idPengeluaran;
    }

    public void setIdPengeluaran(String idPengeluaran) {
        this.idPengeluaran = idPengeluaran;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    

   
    
}
