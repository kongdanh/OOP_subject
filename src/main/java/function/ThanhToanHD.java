package function;
import java.io.*;
import java.util.*;

public class ThanhToanHD implements IThanhToan{
    private String phuongThucThanhToan;
    private double tiendv;
    private double tienp;
    private DatPhong datPhong = new DatPhong();
    Scanner scanner = new Scanner(System.in, "UTF-8");
    public ThanhToanHD(){}
    public ThanhToanHD(DatPhong datPhong, int tiendv,double tienp, String phuongThucThanhToan){
        this.datPhong = datPhong;
        this.tienp = tienp;
        this.tiendv = tiendv;
        this.phuongThucThanhToan = phuongThucThanhToan;
    }
    public void getPhuongThucThanhToan(String phuongThucThanhToan){
        this.phuongThucThanhToan = phuongThucThanhToan;
    }
    public String setPhuongThucThanhToan(){
        return phuongThucThanhToan;
    }
    public boolean NhanPhuongThucThanhToan(String maKH){
        boolean chontt = false;
        System.out.print("Chon phuong thuc thanh toan: \n");
        System.out.print("1. Thanh toan bang tien mat\n");
        System.out.print("2. Thanh toan bang chuyen khoan\n");
        System.out.print("Nhap phuong thuc: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                hienThiThongTinThanhToan(maKH);
                System.out.print("Hay kiem tra so tien duoc nhan !\n");
                chontt = true;
                break;
            case 2:
                hienThiThongTinThanhToan(maKH);
                System.out.print("So tai khoan cua khach san: \n");
                System.out.print("So tai khoan: 6666333325\nNgan hang: Techcombank\nChu tai khoan: Nguyen Tuan Dat\n");
                System.out.print("Hay kiem tra giao dich !\n");
                chontt = true;
                break;
            default:
                System.out.print("Chua co phuong thuc khac !\n");
                choice = scanner.nextInt();
                if (choice == 3) NhanPhuongThucThanhToan(maKH);
                break;
        }
        return chontt;
    }
    public void thanhToan(String maKH, String tenDN, String MK) {
        String[] Mtmp = new String[1000];
        int index = 0;
        DichVu dv = new DichVu();
        tiendv = dv.hienThiThongTinDichVu();
        tienp = datPhong.tinhTongTien(maKH);
        if (NhanPhuongThucThanhToan(maKH)) {
            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\LichSu.txt"))) {
                String line;
                System.out.print("Kiem tra hoa don va xac nhan thanh toan. Nhap (1) de hoan thanh hoac (2) chua hoan thanh: ");
                int choice = 0;
                while (choice != 1 && choice != 2) {
                    try {
                        choice = scanner.nextInt();
                        if (choice != 1 && choice != 2) {
                            System.out.print("Vui long nhap (1) de hoan thanh hoac (2) de chua hoan thanh: ");
                        }
                    } catch (Exception e) {
                        System.out.print("Loi, hay nhap lai: ");
                        scanner.next();
                    }
                }
                if (choice != 1) {
                    System.out.println("Loi thanh toan, tro ve menu: ");
                    NhanVien nv = new NhanVien();
                    nv.menuNV();
                    return;
                }
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts[1].equals(maKH)) {
                        Mtmp[index] = parts[0] + "," + parts[1] + "," + parts[2] + "," + parts[3] + "," + parts[4] + ",paid" + "," + String.format("%.0f", tiendv);
                    } else {
                        Mtmp[index] = line;
                    }
                    index++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\LichSu.txt"))) {
                for (int i = 0; i < index; i++) {
                    if (Mtmp[i] != null) {
                        bw.write(Mtmp[i]);
                        bw.newLine();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }    
    public void hienThiThongTinThanhToan(String maKH){
        System.out.println("=== HOA DON ===");
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\LichSu.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(maKH)){
                    System.out.println("Ma hoa don " + parts[0]);
                    System.out.println("Ma khach hang: " + parts[1]);
                    System.out.println("So phong: " + parts[2]);
                    System.out.println("Ngay thue: " + parts[3]);
                    System.out.println("Ngay tra: " + parts[4]);
                    System.out.println("Tien phong: " + (long)tienp);
                    System.out.println("Tien dich vu: " + (long)tiendv);
                    System.out.println("Tong tien: " + (long)(tiendv + tienp));
                    System.out.println("--------------------------");
                }
            }
        } catch (Exception e) {
            System.out.println("Khong doc duoc du lieu");
            e.printStackTrace();
        }
    }
}
