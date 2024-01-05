package com.dxt.monhoc;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class QuanLyMonHoc {
    List<MonHoc> ds = new ArrayList<>();

    public void docFileMonHoc(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] infoArray = line.split(";");
                MonHoc monHoc = new MonHoc(infoArray[0], infoArray[1], infoArray[2],
                        Integer.parseInt(infoArray[3]), KhoiKienThuc.valueOf(infoArray[4]), new ArrayList<>(), new ArrayList<>());

                // Kiểm tra xem môn học này có môn trước hay không
                if ("0".equals(infoArray[5])) {
                    monHoc.setMonTruoc(null);
                } else {
                    String[] dsMonTruoc = infoArray[5].split("-");

                    for (String dsMonTruoc1 : dsMonTruoc) {
                        monHoc.getMonTruoc().add(this.timKiemMonHocTheoTen(dsMonTruoc1.trim()));
                    }
                }

                // Kiểm tra xem môn học này có môn tiên quyết hay không
                if ("0".equals(infoArray[6])) {
                    monHoc.setMonTQ(null);
                } else {
                    String[] dsMonTQ = infoArray[6].split("-");

                    for (String dsMonTQ1 : dsMonTQ) {
                        monHoc.getMonTQ().add(this.timKiemMonHocTheoTen(dsMonTQ1.trim()));
                    }
                }
                this.ds.add(monHoc);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public List<MonHoc> timKiemDS(String ma) {
        return this.ds.stream()
                .filter(d -> 
                    (d.getMonTruoc() != null && d.getMonTruoc().stream().anyMatch(m -> m.getMaMH().equals(ma))) ||
                    (d.getMonTQ() != null && d.getMonTQ().stream().anyMatch(m -> m.getMaMH().equals(ma)))
                )
                .collect(Collectors.toList());
    }

    public MonHoc timKiemMonHocTheoMa(String ma) {
        return this.ds.stream().filter(m -> m.getMaMH().equals(ma)).findFirst().orElse(null);
    }

    public MonHoc timKiemMonHocTheoTen(String ten) {
        return this.ds.stream().filter(m -> m.getTenMH().equals(ten)).findFirst().orElse(null);
    }

    public void hienThi() {
        this.ds.forEach(m -> m.hienThi());
    }
}

