package com.dxt.monhoc;

public class DeCuongMonHoc {
    private MonHoc monHoc;
    private MucTieu mucTieu;
    private String noiDung;
    private HeDaoTao heDaoTao;
    private GiangVien nguoiBienSoan;
    private HinhThucDanhGia hinhThucDG;

    public DeCuongMonHoc(MonHoc monHoc, MucTieu mucTieu, String noiDung, HeDaoTao heDaoTao, GiangVien nguoiBienSoan, HinhThucDanhGia hinhThucDG) {
        this.monHoc = monHoc;
        this.mucTieu = mucTieu;
        this.noiDung = noiDung;
        this.heDaoTao = heDaoTao;
        this.nguoiBienSoan = nguoiBienSoan;
        this.hinhThucDG = hinhThucDG;
    }

    public DeCuongMonHoc() {
    }
    
    public DeCuongMonHoc timDeCuong(String ma, String hdt) {
	return null;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public MucTieu getMucTieu() {
        return mucTieu;
    }

    public void setMucTieu(MucTieu mucTieu) {
        this.mucTieu = mucTieu;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public HeDaoTao getHeDaoTao() {
        return heDaoTao;
    }

    public void setHeDaoTao(HeDaoTao heDaoTao) {
        this.heDaoTao = heDaoTao;
    }

    public GiangVien getNguoiBienSoan() {
        return nguoiBienSoan;
    }

    public void setNguoiBienSoan(GiangVien nguoiBienSoan) {
        this.nguoiBienSoan = nguoiBienSoan;
    }

    public HinhThucDanhGia getHinhThucDG() {
        return hinhThucDG;
    }

    public void setHinhThucDG(HinhThucDanhGia hinhThucDG) {
        this.hinhThucDG = hinhThucDG;
    }
    
}
