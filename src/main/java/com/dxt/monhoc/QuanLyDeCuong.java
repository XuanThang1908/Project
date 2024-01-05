package com.dxt.monhoc;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class QuanLyDeCuong {

    private List<DeCuongMonHoc> dsDeCuong = new ArrayList<>();

    public List<DeCuongMonHoc> getDsDeCuong() {
        return dsDeCuong;
    }

    public void setDsDeCuong(List<DeCuongMonHoc> dsDeCuong) {
        this.dsDeCuong = dsDeCuong;
    }

    public void themDeCuongMonHoc(DeCuongMonHoc... d) {
        this.dsDeCuong.addAll(Arrays.asList(d));
    }

    public void ghiFileDeCuong(String filename) {
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            for (DeCuongMonHoc deCuong : getDsDeCuong()) {
                String line = deCuong.getMonHoc().getMaMH() + ";"
                        + deCuong.getMucTieu().getMucTieu() + ";"
                        + deCuong.getMucTieu().getMoTa() + ";"
                        + deCuong.getMucTieu().getChuanDauRa().getChuanDauRa() + ";"
                        + deCuong.getMucTieu().getChuanDauRa().getMoTa() + ";"
                        + deCuong.getNoiDung() + ";"
                        + deCuong.getHeDaoTao().toString() + ";"
                        + deCuong.getNguoiBienSoan().getTen() + ";";
                HinhThucDanhGia hinhThucDG = deCuong.getHinhThucDG();
                line += hinhThucDG.getSoCotDiem() + ";";
                List<DiemDanhGia> diemDanhGiaArray = hinhThucDG.getDiemDanhGia();
                if (diemDanhGiaArray != null && !diemDanhGiaArray.isEmpty()) {
                    for (int i = 0; i < diemDanhGiaArray.size(); i++) {
                        DiemDanhGia diemDanhGia = diemDanhGiaArray.get(i);
                        line += diemDanhGia.getThanhPhan() + ";"
                                + diemDanhGia.getPhuongPhapDanhGia() + ";"
                                + diemDanhGia.getNoiDungDanhGia() + ";"
                                + diemDanhGia.getTyTrong();
                        if (i < diemDanhGiaArray.size() - 1) {
                            line += ";";
                        } else {
                            line += "\n";
                        }
                    }
                } else {
                    line += "0;";
                }
                writer.write(line);
            }
            System.out.println("Ghi file thanh cong");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public void docFileDeCuong(String filename, GiangVien gv, QuanLyMonHoc q) {
        this.dsDeCuong.clear();
        try ( BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                String tenGiangVienDeCuong = fields[7];
                if (tenGiangVienDeCuong.equals(gv.getTen())) {
                    DeCuongMonHoc deCuong = new DeCuongMonHoc();
                    MonHoc monHoc = q.timKiemMonHocTheoMa(fields[0]);
                    MucTieu mucTieu = new MucTieu();
                    mucTieu.setMucTieu(fields[1]);
                    mucTieu.setMoTa(fields[2]);
                    ChuanDauRa chuanDauRa = new ChuanDauRa();
                    chuanDauRa.setChuanDauRa(fields[3]);
                    chuanDauRa.setMoTa(fields[4]);
                    mucTieu.setChuanDauRa(chuanDauRa);
                    deCuong.setMonHoc(monHoc);
                    deCuong.setMucTieu(mucTieu);
                    deCuong.setNoiDung(fields[5]);
                    deCuong.setHeDaoTao(HeDaoTao.valueOf(fields[6]));
                    deCuong.setNguoiBienSoan(gv);
                    HinhThucDanhGia hinhThucDG = new HinhThucDanhGia();
                    hinhThucDG.setSoCotDiem(Integer.parseInt(fields[8]));
                    List<DiemDanhGia> diemDanhGiaList = new ArrayList<>();
                    for (int i = 0; i < hinhThucDG.getSoCotDiem(); i++) {
                        DiemDanhGia diemDanhGia = new DiemDanhGia();
                        int startIndex = 9 + i * 4;
                        diemDanhGia.setThanhPhan(fields[startIndex]);
                        diemDanhGia.setPhuongPhapDanhGia(fields[startIndex + 1]);
                        diemDanhGia.setNoiDungDanhGia(fields[startIndex + 2]);
                        diemDanhGia.setTyTrong(Double.parseDouble(fields[startIndex + 3]));

                        diemDanhGiaList.add(diemDanhGia);
                    }
                    hinhThucDG.setDiemDanhGia(diemDanhGiaList);
                    deCuong.setHinhThucDG(hinhThucDG);
                    this.dsDeCuong.add(deCuong);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public int soLuongDeCuong() {
        return this.dsDeCuong.size();
    }

    public void xuatDeCuong(DeCuongMonHoc dc) {
        System.out.println("Ten muc tieu: " + dc.getMucTieu().getMucTieu());
        System.out.println("Mo ta muc tieu: " + dc.getMucTieu().getMoTa());
        System.out.println("Ten chuan dau ra: " + dc.getMucTieu().getChuanDauRa().getChuanDauRa());
        System.out.println("Mo ta chuan dau ra: " + dc.getMucTieu().getChuanDauRa().getMoTa());
        System.out.println("Noi dung: " + dc.getNoiDung());
        System.out.println("He dao tao: " + dc.getHeDaoTao());
        System.out.println("Nguoi bien soan: " + dc.getNguoiBienSoan().getTen());
        System.out.println("So cot diem: " + dc.getHinhThucDG().getSoCotDiem());
        List<DiemDanhGia> diemDanhGiaList = dc.getHinhThucDG().getDiemDanhGia();
        for (int i = 0; i < dc.getHinhThucDG().getSoCotDiem(); i++) {
            DiemDanhGia diemDanhGia = diemDanhGiaList.get(i);
            System.out.printf("Thong tin cot diem danh gia thu %d:\n", i + 1);
            System.out.println("Thanh phan: " + diemDanhGia.getThanhPhan());
            System.out.println("Phuong phap: " + diemDanhGia.getPhuongPhapDanhGia());
            System.out.println("Noi dung: " + diemDanhGia.getNoiDungDanhGia());
            System.out.println("Ty trong: " + diemDanhGia.getTyTrong());
        }
    }

    public void xuatDSDeCuong(List<DeCuongMonHoc> dsdc, String maGV) {
        for (DeCuongMonHoc dc : dsdc) {
            System.out.println("Ma mon hoc: " + dc.getMonHoc().getMaMH());
            System.out.println("Ten mon hoc: " + dc.getMonHoc().getTenMH());
            System.out.println("So tin chi: " + dc.getMonHoc().getSoTin());
            System.out.println("He dao tao: " + dc.getHeDaoTao());
            System.out.println();
        }
    }

    public DeCuongMonHoc timDeCuong(MonHoc mh, HeDaoTao heDaoTao) {
        Optional<DeCuongMonHoc> dc = dsDeCuong.stream()
                .filter(g -> {
                    MonHoc monHoc = g.getMonHoc();
                    HeDaoTao hdt = g.getHeDaoTao();
                    return monHoc.equals(mh) && hdt.equals(heDaoTao);
                })
                .findFirst();
        return dc.orElse(null);
    }

    public List<DeCuongMonHoc> timDeCuongTheoGiangVien(String maGiangVien) {
        return this.dsDeCuong.stream().filter(dc -> dc.getNguoiBienSoan().getMaID().equals(maGiangVien)).collect(Collectors.toList());
    }

    public void sapXep() {
        Collections.sort(this.dsDeCuong, (dc1, dc2) -> {
            int st1 = dc1.getMonHoc().getSoTin();
            int st2 = dc2.getMonHoc().getSoTin();
            if (st1 == st2) {
                String ma1 = dc1.getMonHoc().getMaMH();
                String ma2 = dc2.getMonHoc().getMaMH();
                int n1 = Integer.parseInt(ma1.substring(ma1.length() - 4));
                int n2 = Integer.parseInt(ma2.substring(ma2.length() - 4));
                return Integer.compare(n1, n2);
            }
            return Integer.compare(st2, st1);
        });
    }
}
