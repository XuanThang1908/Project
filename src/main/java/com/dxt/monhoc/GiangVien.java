package com.dxt.monhoc;

import java.util.List;

public class GiangVien extends Nguoi {

    private QuanLyDeCuong dsdc = new QuanLyDeCuong();

    public GiangVien(String ma, String ten) {
        super(ma, ten);
    }

    public GiangVien() {
        super(null, null);
    }
    
    public QuanLyDeCuong getDsdc() {
        return dsdc;
    }

    public void setDsdc(QuanLyDeCuong dsDeCuong) {
        this.dsdc = dsDeCuong;
    }
    
    public GiangVien(String ma, String ten, QuanLyDeCuong dsDC) {
        super(ma, ten);
        this.dsdc = dsDC;
    }

    public void suaNoiDung(DeCuongMonHoc dc) {

    }

    public void themHinhThucDanhGia(DeCuongMonHoc dc) {

    }

    public void xoaHinhThucDanhGia(DeCuongMonHoc dc) {

    }

    public MonHoc timKiemMonHoc(String ma) {
        return null;
    }

    public List<MonHoc> timKiemDS(String ma) {
        return null;
    }

    public void sapXepDSDeCuong(List<DeCuongMonHoc> dsDeCuong) {

    }

    public List<DeCuongMonHoc> layDSTheoMaGiangVien(String maGV) {
        return null;
    }

    public void xuat1DeCuong(DeCuongMonHoc dc) {

    }

    public int thongKeSoLuongDeCuong(int soTin) {
        return 0;
    }
}
