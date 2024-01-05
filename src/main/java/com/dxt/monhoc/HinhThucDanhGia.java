package com.dxt.monhoc;

import java.util.ArrayList;
import java.util.List;

public class HinhThucDanhGia {
    private int soCotDiem;
    private List<DiemDanhGia> diemDanhGia = new ArrayList<>();
    
    public HinhThucDanhGia(int soCotDiem, List<DiemDanhGia> diemDanhGia) {
        this.soCotDiem = soCotDiem;
        this.diemDanhGia = diemDanhGia;
    }

    public HinhThucDanhGia() {
    }

    public int getSoCotDiem() {
        return soCotDiem;
    }

    public void setSoCotDiem(int soCotDiem) {
        this.soCotDiem = soCotDiem;
    }

    public List<DiemDanhGia> getDiemDanhGia() {
        return diemDanhGia;
    }

    public void setDiemDanhGia(List<DiemDanhGia> diemDanhGia) {
        this.diemDanhGia = diemDanhGia;
    }
}

