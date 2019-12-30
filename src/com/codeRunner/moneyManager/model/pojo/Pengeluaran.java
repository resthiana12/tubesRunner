/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeRunner.moneyManager.model.pojo;

import java.sql.Date;

/**
 *
 * @author resthiana
 */
public class Pengeluaran {
    private String idPengeluaran;
    private Date tanggalPilih;
    private int transportasi;
    private int makanan;
    private int kesehatan;
    private int kecantikan;
    private int pakaian;
    private int komunikasi;
    private int lainnya;
    private int jumlah;
    private String catatan;

    public Pengeluaran(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Pengeluaran(String text, Date valueOf, Integer valueOf0, Integer valueOf1, Integer valueOf2, Integer valueOf3, Integer valueOf4, Integer valueOf5, Integer valueOf6, Integer valueOf7, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Pengeluaran(){}

    public String getIdPengeluaran() {
        return idPengeluaran;
    }

    public void setIdPengeluaran(String idPengeluaran) {
        this.idPengeluaran = idPengeluaran;
    }

    public Date getTanggalPilih() {
        return tanggalPilih;
    }

    public void setTanggalPilih(Date tanggalPilih) {
        this.tanggalPilih = tanggalPilih;
    }

    public int getTransportasi(){
        return transportasi;
    }
    
    public void setTransportasi(int transportasi) {
        this.transportasi = transportasi;
    }

    public int getMakanan() {
        return makanan;
    }

    public void setMakanan(int makanan) {
        this.makanan = makanan;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public int getKecantikan() {
        return kecantikan;
    }

    public void setKecantikan(int kecantikan) {
        this.kecantikan = kecantikan;
    }

    public int getPakaian() {
        return pakaian;
    }

    public void setPakaian(int pakaian) {
        this.pakaian = pakaian;
    }

    public int getKomunikasi() {
        return komunikasi;
    }

    public void setKomunikasi(int komunikasi) {
        this.komunikasi = komunikasi;
    }

    public int getLainnya() {
        return lainnya;
    }

    public void setLainnya(int lainnya) {
        this.lainnya = lainnya;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public Pengeluaran(String idPengeluaran, Date tanggalPilih, int transportasi, int makanan, int kesehatan, int kecantikan, int pakaian, int komunikasi, int lainnya, int jumlah, String catatan) {
        this.idPengeluaran = idPengeluaran;
        this.tanggalPilih = tanggalPilih;
        this.transportasi = transportasi;
        this.makanan = makanan;
        this.kesehatan = kesehatan;
        this.kecantikan = kecantikan;
        this.pakaian = pakaian;
        this.komunikasi = komunikasi;
        this.lainnya = lainnya;
        this.jumlah = jumlah;
        this.catatan = catatan;
    }

    
    
}
