package com.dxt.monhoc;

public class Nguoi {
    private String maID;
    private String ten;

    public Nguoi(String maID, String ten) {
        this.ten = ten;
        this.maID = maID;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMaID() {
        return maID;
    }

    public void setMaID(String maID) {
        this.maID = maID;
    }
}

