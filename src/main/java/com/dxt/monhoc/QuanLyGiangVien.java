package com.dxt.monhoc;

import java.util.*;
import java.io.*;

public class QuanLyGiangVien {
    List<GiangVien> dsgv = new ArrayList<>();
    
    public void docFileGiangVien(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String txt[] = line.split(";");
                dsgv.add(new GiangVien(txt[0], txt[1]));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public GiangVien timGiangVien(String ma) {
        Optional<GiangVien> gv = dsgv.stream()
                .filter(g -> g.getMaID().equals(ma)).findFirst();
        return gv.orElse(null);
    };
}
