/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeRunner.moneyManager.model.pojo;
import java.sql.Date;

/**
 *
 * @author adind
 */
public class Pendapatan {
    private String idPendapatan;
    private Date tanggal;
    private int jumlah;
    private String catatan;
    
    
    
    public Pendapatan(String idPendapatan, Date tanggal, int jumlah, String catatan){
        this.idPendapatan = idPendapatan;
        this.tanggal = tanggal;
        this.jumlah = jumlah;
        this.catatan = catatan;
    }

    public Pendapatan() {
        
    }
    
    
    
//    ----------------------------------- SETTER ----------------------------------
    public void setIdPendapatan (String idPendapatan){
        this.idPendapatan = idPendapatan;
    }
    
    public void setTanggal (Date tanggal){
        this.tanggal = tanggal;
    }
    
    public void setJumlah (int jumlah){
        this.jumlah = jumlah;
    }
    
    public void setCatatan (String catatan){
        this.catatan = catatan;
    }
    
//    --------------------------- END of  SETTER ----------------------------------
    
    
    
//    ----------------------------------- GETTER ----------------------------------

    public String getIdPendapatan(){
        return this.idPendapatan;
    }
    
    public Date getTanggal(){
        return this.tanggal;
    }
    
    public int getJumlah(){
        return this.jumlah;
    }
    
    public String getCatatan(){
        return this.catatan;
    }
    
//    --------------------------- END of  GETTER ----------------------------------

}


