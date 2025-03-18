package function;
import java.io.*;
import java.util.*;

public class Hotel implements IThongTin{
    private String tenKhachSan = "Khach San 24";
    private String diaChi = "273 An Duong Vuong, Quan 5";
    Scanner scanner = new Scanner(System.in, "UTF-8");
    public Hotel(){}
    //constructor
    public Hotel(String tenKhachSan, String diaChi){
        this.tenKhachSan = tenKhachSan;
        this.diaChi = diaChi;
    }
    public void themPhong(Phong phong) {
        boolean added = false, tontai = false;
        String[] addP = new String[1000];
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\ThongTinPhong.txt"))) {
            System.out.print("Nhap ma phong muon them (T: tang tret hoac L: tang lau + so phong):");
            String newP = scanner.nextLine();
            while (!newP.startsWith("L") && !newP.startsWith("T")) {
                System.out.print("Nhap du lieu bi loi, hay thu lai:  ");
                newP = scanner.nextLine();
            }
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(newP)) {
                    System.out.println("Phong " + newP + " da ton tai");
                    tontai = true;
                    break;
                }
                addP[count++] = line;
            }
            if (!tontai) {
                for (int i = 0; i < count; i++) {
                    String[] parts = addP[i].split(",");
                    if (newP.startsWith("T") && parts[0].startsWith("T")) {
                        if (Integer.parseInt(parts[0].substring(1)) > Integer.parseInt(newP.substring(1))) {
                            for (int j = count; j > i; j--) {
                                addP[j] = addP[j - 1];
                            }
                            addP[i] = newP + ",0,NULL,NULL";
                            added = true;
                            count++;
                            break;
                        }
                    } else if (newP.startsWith("L") && parts[0].startsWith("L")) {
                        if (Integer.parseInt(parts[0].substring(1)) > Integer.parseInt(newP.substring(1))) {
                            for (int j = count; j > i; j--) {
                                addP[j] = addP[j - 1];
                            }
                            addP[i] = newP + ",0,NULL,NULL";
                            added = true;
                            count++;
                            break;
                        }
                    }
                }
                if (!added) {
                    addP[count++] = newP + ",0,NULL,NULL";
                }
                //khong tim thay de so sanh thu tu phong - > them phong o cuoi
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\ThongTinPhong.txt"))) {
                    for (int i = 0; i < count; i++) {
                        bw.write(addP[i]);
                        bw.newLine();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void xoaPhong(Phong phong) {
        System.out.print("Nhap ma phong can xoa: ");
        String xoaP = scanner.nextLine();
        String line;
        boolean findToDelete = false;
        String[] xoaPhong = new String[1000];
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\ThongTinPhong.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(xoaP)) {
                    findToDelete = true;
                } else {
                    xoaPhong[count++] = line;
                }
            }
            if (findToDelete) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\ThongTinPhong.txt"))) {
                    for (int i = 0; i < count; i++) {
                        bw.write(xoaPhong[i]);
                        bw.newLine();
                    }
                    System.out.println("Da xoa thanh cong phong " + xoaP);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Phong can xoa khong ton tai " + xoaP + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    public void docFileXuatDSPhongTrong() {
        String[] DSPhongTrong = new String[1000];
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\ThongTinPhong.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals("0")) {
                    DSPhongTrong[count++] = parts[0];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < count; i++) {
            System.out.print(DSPhongTrong[i] + ",");
        }
    }
    public void hienThiThongTin(){
        System.out.print("THONG TIN KHACH SAN\n");
        System.out.println("TEN: " + tenKhachSan);
        System.out.println("DIA CHI: " + diaChi);
        System.out.print("Danh sach phong con trong: ");
        docFileXuatDSPhongTrong(); 
    }
}
