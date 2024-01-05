package com.dxt.monhoc;
import java.util.ArrayList;
import java.util.List;

public class MonHoc {
    private String maMH;
    private String tenMH;
    private String moTaMH;
    private int soTin;
    private KhoiKienThuc khoiKT;
    private List<MonHoc> monTruoc;
    private List<MonHoc> monTQ;

    public MonHoc(String maMH, String tenMH, String moTaMH, int soTin, KhoiKienThuc khoiKT) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.moTaMH = moTaMH;
        this.soTin = soTin;
        this.khoiKT = khoiKT;
    }

    public MonHoc(String maMH, String tenMH, String moTaMH, int soTin, KhoiKienThuc khoiKT, List<MonHoc> monTruoc, List<MonHoc> monTQ) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.moTaMH = moTaMH;
        this.soTin = soTin;
        this.khoiKT = khoiKT;
        this.monTruoc = new ArrayList<>();
        this.monTQ = new ArrayList<>();
    }

    public MonHoc() {
    }
    
    public void hienThi() {
        System.out.println("Ma mon: " + maMH);
        System.out.println("Ten mon hoc: " + tenMH);
        System.out.println("Mo ta mon hoc: " + moTaMH);
        System.out.println("So tin chi: " + soTin);
        System.out.println("Khoi kien thuc: " + khoiKT);
        
        // Hiển thị môn trước
        if (monTruoc != null && !monTruoc.isEmpty()) {
            System.out.println("Mon Truoc: ");
            for (MonHoc mon : monTruoc) {
                System.out.println("- " + mon.getTenMH());
            }
        } else {
            System.out.println("Khong co mon truoc.");
        }
        
        // Hiển thị môn tiên quyết
        if (monTQ != null && !monTQ.isEmpty()) {
            System.out.println("Mon tien quyett: ");
            for (MonHoc mon : monTQ) {
                System.out.println("- " + mon.getTenMH());
            }
        } else {
            System.out.println("Khong co mon tien quyet.");
        }

        System.out.println("---------------------------");
    }

    public void suaMonHoc(String ma) {

    }
    
    public String getMaMH() {
        return maMH;
    }
    
    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getMoTaMH() {
        return moTaMH;
    }

    public void setMoTaMH(String moTaMH) {
        this.moTaMH = moTaMH;
    }

    public int getSoTin() {
        return soTin;
    }

    public void setSoTin(int soTin) {
        this.soTin = soTin;
    }

    public KhoiKienThuc getKhoiKT() {
        return khoiKT;
    }

    public void setKhoiKT(KhoiKienThuc khoiKT) {
        this.khoiKT = khoiKT;
    }

    public List<MonHoc> getMonTruoc() {
        return monTruoc;
    }

    public void setMonTruoc(List<MonHoc> monTruoc) {
        this.monTruoc = monTruoc;
    }

    public List<MonHoc> getMonTQ() {
        return monTQ;
    }

    public void setMonTQ(List<MonHoc> monTQ) {
        this.monTQ = monTQ;
    }
}

