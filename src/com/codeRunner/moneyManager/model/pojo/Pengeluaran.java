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
    private String idExpenses;
    private Date tanggal;
    private int transport;
    private int foodstuff;
    private int health;
    private int beauty;
    private int fashion;
    private int communication;
    private int others;
    private int jumlah;
    private String note;

    public String getIdExpenses() {
        return idExpenses;
    }

    public void setIdExpenses(String idExpenses) {
        this.idExpenses = idExpenses;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public int getTransport() {
        return transport;
    }

    public void setTransport(int transport) {
        this.transport = transport;
    }

    public int getFoodstuff() {
        return foodstuff;
    }

    public void setFoodstuff(int foodstuff) {
        this.foodstuff = foodstuff;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getBeauty() {
        return beauty;
    }

    public void setBeauty(int beauty) {
        this.beauty = beauty;
    }

    public int getFashion() {
        return fashion;
    }

    public void setFashion(int fashion) {
        this.fashion = fashion;
    }

    public int getCommunication() {
        return communication;
    }

    public void setCommunication(int communication) {
        this.communication = communication;
    }

    public int getOthers() {
        return others;
    }

    public void setOthers(int others) {
        this.others = others;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getNote() {
        return note;
    }

    public Pengeluaran(String idExpenses, Date tanggal, int transport, int foodstud, int health, int beauty, int fashion, int communication, int others, int jumlah, String note) {
        this.idExpenses = idExpenses;
        this.tanggal = tanggal;
        this.transport = transport;
        this.foodstuff = foodstud;
        this.health = health;
        this.beauty = beauty;
        this.fashion = fashion;
        this.communication = communication;
        this.others = others;
        this.jumlah = jumlah;
        this.note = note;
    }
    
    public Pengeluaran(){}

    public void setNote(String note) {
        this.note = note;
    }
}
