package com.dxt.monhoc;

public class DiemDanhGia {
    private String thanhPhan;
    private String phuongPhapDanhGia;
    private String noiDungDanhGia;
    private double tyTrong;

    public DiemDanhGia(String thanhPhan, String phuongPhapDanhGia, String noiDungDanhGia, double tyTrong) {
        this.thanhPhan = thanhPhan;
        this.phuongPhapDanhGia = phuongPhapDanhGia;
        this.noiDungDanhGia = noiDungDanhGia;
        this.tyTrong = tyTrong;
    }

    public DiemDanhGia() {
    }
    
    public String getThanhPhan() {
        return thanhPhan;
    }

    public void setThanhPhan(String thanhPhan) {
        this.thanhPhan = thanhPhan;
    }

    public String getPhuongPhapDanhGia() {
        return phuongPhapDanhGia;
    }

    public void setPhuongPhapDanhGia(String phuongPhapDanhGia) {
        this.phuongPhapDanhGia = phuongPhapDanhGia;
    }

    public String getNoiDungDanhGia() {
        return noiDungDanhGia;
    }

    public void setNoiDungDanhGia(String noiDungDanhGia) {
        this.noiDungDanhGia = noiDungDanhGia;
    }

    public double getTyTrong() {
        return tyTrong;
    }

    public void setTyTrong(double tyTrong) {
        this.tyTrong = tyTrong;
    }
}


