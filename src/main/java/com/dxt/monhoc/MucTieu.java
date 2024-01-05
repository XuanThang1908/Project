package com.dxt.monhoc;

public class MucTieu {
    private String mucTieu;
    private String moTa;
    private ChuanDauRa chuanDauRa;
    
    public MucTieu() {
    }
    
    public MucTieu(String mucTieu, String moTa, ChuanDauRa chuanDauRa) {
        this.mucTieu = mucTieu;
        this.moTa = moTa;
        this.chuanDauRa = chuanDauRa;
    }
    
    public String getMucTieu() {
        return mucTieu;
    }

    public void setMucTieu(String mucTieu) {
        this.mucTieu = mucTieu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public ChuanDauRa getChuanDauRa() {
        return chuanDauRa;
    }

    public void setChuanDauRa(ChuanDauRa chuanDauRa) {
        this.chuanDauRa = chuanDauRa;
    }
}

