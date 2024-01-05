package com.dxt.monhoc;

import java.util.*;
import java.io.*;

public class Demo {

    public static void main(String[] args) throws IOException {
        QuanLyGiangVien q1 = new QuanLyGiangVien();
        q1.docFileGiangVien("src/main/resources/giangVien.txt");
        QuanLyMonHoc q2 = new QuanLyMonHoc();
        q2.docFileMonHoc("src/main/resources/dsMonHoc.txt");
        Scanner sc = new Scanner(System.in);
        boolean found = false;
        boolean rep = true;
        do {
            System.out.print("Nhap ma giang vien: ");
            String mgv = sc.nextLine();
            GiangVien gv = q1.timGiangVien(mgv);
            if (gv != null) {
                found = true;
            }
            if (found) {
                QuanLyDeCuong q3 = new QuanLyDeCuong();
                q3.docFileDeCuong("src/main/resources/deCuong.txt", gv, q2);
                do {
                    System.out.println("\nMENU");
                    System.out.println("1.Tao de cuong");
                    System.out.println("2.Cap nhat thong tin de cuong");
                    System.out.println("3.Tim kiem mon hoc");
                    System.out.println("4.Xuat danh sach mon hoc (mon hoc truoc hoac mon tien quyet)");
                    System.out.println("5.Sap xep danh sach de cuong");
                    System.out.println("6.Xuat danh sach de cuong thuoc ma giang vien");
                    System.out.println("7.Xuat de cuong");
                    System.out.println("8.Thong ke so luong de cuong");
                    System.out.println("0.Thoat(EXIT)");
                    System.out.print("Nhap lua chon: ");
                    int chon = sc.nextInt();
                    sc.nextLine();
                    switch (chon) {
                        case 1:
                            System.out.print("Nhap ma mon hoc can tao de cuong: ");
                            String mmh = sc.nextLine();
                            MonHoc mh = new MonHoc();
                            mh = q2.timKiemMonHocTheoMa(mmh);
                            if (mh != null) {
                                System.out.println("Mon hoc can tao de cuong ung voi ma mon " + mmh + " la: " + mh.getTenMH());
                                System.out.println("Hay nhap cac thong tin sau cho de cuong: ");
                                DeCuongMonHoc h = new DeCuongMonHoc();
                                MucTieu mt = new MucTieu();
                                ChuanDauRa cdr = new ChuanDauRa();
                                h.setMonHoc(mh);
                                System.out.print("Nhap muc tieu cho de cuong: ");
                                mt.setMucTieu(sc.nextLine());
                                System.out.print("Nhap mo ta muc tieu cho de cuong: ");
                                mt.setMoTa(sc.nextLine());
                                System.out.print("Nhap chuan dau ra cho de cuong: ");
                                cdr.setChuanDauRa(sc.nextLine());
                                System.out.print("Nhap mo ta chuan dau ra cho de cuong: ");
                                cdr.setMoTa(sc.nextLine());
                                mt.setChuanDauRa(cdr);
                                h.setMucTieu(mt);
                                System.out.print("Nhap noi dung cho de cuong: ");
                                h.setNoiDung(sc.nextLine());
                                boolean rep2 = true;
                                do {
                                    System.out.println("Chon he dao tao cho de cuong:");
                                    System.out.println("1.CHINH QUY");
                                    System.out.println("2.LIEN THONG");
                                    System.out.print("Nhap lua chon (1 or 2): ");
                                    int choose = sc.nextInt();
                                    switch (choose) {
                                        case 1:
                                            h.setHeDaoTao(HeDaoTao.CHINH_QUY);
                                            rep2 = false;
                                            break;
                                        case 2:
                                            h.setHeDaoTao(HeDaoTao.LIEN_THONG);
                                            rep2 = false;
                                            break;
                                        default:
                                            System.out.println("Nhap sai. Hay nhap lai");
                                    }
                                } while (rep2);
                                h.setNguoiBienSoan(gv);
                                HinhThucDanhGia dg = new HinhThucDanhGia();
                                do {
                                    System.out.print("Nhap so cot diem danh gia (tu 2 den 4): ");
                                    int soCotDiem = sc.nextInt();
                                    if (soCotDiem >= 2 && soCotDiem <= 4) {
                                        dg.setSoCotDiem(soCotDiem);
                                        break;
                                    } else {
                                        System.out.println("So cot diem danh gia phai nam trong khoang tu 2 den 4. Vui long nhap lai.");
                                    }
                                } while (true);
                                DiemDanhGia[] danhGiaArray = new DiemDanhGia[dg.getSoCotDiem()];
                                for (int i = 0; i < dg.getSoCotDiem(); i++) {
                                    DiemDanhGia d = new DiemDanhGia();
                                    System.out.printf("Nhap thong tin cot diem danh gia thu %d%n", i + 1);
                                    System.out.print("Nhap thanh phan: ");
                                    sc.nextLine();
                                    d.setThanhPhan(sc.nextLine());
                                    System.out.print("Nhap phuong phap danh gia: ");
                                    d.setPhuongPhapDanhGia(sc.nextLine());
                                    System.out.print("Nhap noi dung danh gia: ");
                                    d.setNoiDungDanhGia(sc.nextLine());
                                    System.out.print("Nhap ty trong: ");
                                    d.setTyTrong(sc.nextDouble());
                                    danhGiaArray[i] = d;
                                }
                                dg.setDiemDanhGia(Arrays.asList(danhGiaArray));
                                h.setHinhThucDG(dg);
                                
                                int number = q3.soLuongDeCuong();
                                if (number < 5) {
                                    gv.getDsdc().themDeCuongMonHoc(h);
                                    System.out.println("Da tao de cuong thanh cong");
                                    gv.getDsdc().ghiFileDeCuong("src/main/resources/deCuong.txt");
                                } else {
                                    System.out.println("Da vuot qua so luong de cuong toi da (MAX=5). Khong the tao them");
                                }
                            } else {
                                System.out.println("Ma mon hoc khong ton tai");
                            }
                            break;
                        case 2:

                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                        case 5:
                            q3.sapXep();
                            System.out.println("Da sap xep thanh cong");
                            break;
                        case 6:
                            List<DeCuongMonHoc> dsdc = q3.timDeCuongTheoGiangVien(mgv);
                            for (DeCuongMonHoc dc : dsdc) {
                                System.out.println("Ma mon hoc: " + dc.getMonHoc().getMaMH());
                                System.out.println("Ten mon hoc: " + dc.getMonHoc().getTenMH());
                                System.out.println("So tin chi: " + dc.getMonHoc().getSoTin());
                                System.out.println("He dao tao: " + dc.getHeDaoTao());
                                System.out.println();
                            }
                            break;
                        case 7:
                            System.out.print("Nhap ma mon hoc cua de cuong muon xuat: ");
                            String mmh1 = sc.nextLine();
                            MonHoc mh1 = q2.timKiemMonHocTheoMa(mmh1);
                            boolean flag = true;
                            do {
                                System.out.println("Chon he dao tao cho de cuong:");
                                System.out.println("1.CHINH QUY");
                                System.out.println("2.LIEN THONG");
                                System.out.print("Nhap lua chon (1 or 2): ");
                                int choice = sc.nextInt();
                                switch (choice) {
                                    case 1:
                                        DeCuongMonHoc dc = q3.timDeCuong(mh1, HeDaoTao.CHINH_QUY);
                                        mh1.hienThi();
                                        q3.xuatDeCuong(dc);
                                        flag = false;
                                        break;
                                    case 2:
                                        DeCuongMonHoc dc2 = q3.timDeCuong(mh1, HeDaoTao.LIEN_THONG);
                                        mh1.hienThi();
                                        q3.xuatDeCuong(dc2);
                                        flag = false;
                                        break;
                                    default:
                                        System.out.println("Nhap sai. Hay nhap lai");
                                }
                            } while (flag);
                            break;
                        case 8:

                            break;
                        case 0:
                            System.out.println("Da thoat khoi MENU");
                            rep = false;
                            break;
                        default:
                            System.out.println("Nhap sai. Hay nhap lai");
                    }
                } while (rep);
            }
            if (!found) {
                System.out.println("Ma giang vien khong ton tai. Hay nhap lai.");
            }
        } while (!found);
    }
}
