package function;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DatPhong extends KhachHang{
    private String datp;
    private KhachHang khachHang;
    private Phong phong;
    private String ngayDat;
    private String ngayTra;
    Scanner scanner = new Scanner(System.in);
    public DatPhong(){}
    public DatPhong(String datp, KhachHang khachHang, Phong phong, String ngayDat, String ngayTra, double tongTien){
        this.datp = datp;
        this.khachHang = khachHang;
        this.phong = phong;
        this.ngayDat = ngayDat;
        this.ngayTra = ngayTra;
    }
    public void nhapDatPhong(){
        khachHang = new KhachHang();
        khachHang.nhapDuLieuKhachHang();
        phong = new Phong(){};
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        System.out.print("Nhap ngay dat phong (dd-MM-yyy): ");
        Date nd = nhapNgay(dateFormat);
        ngayDat = dateFormat.format(nd);
        System.out.print("Nhap ngay tra phong(dd-MM-yyy): ");
        Date nt = nhapNgay(dateFormat);
        ngayTra = dateFormat.format(nt);
        while (!nt.after(nd)  && !nt.equals(nd)){
            System.out.print("Ngay tra phai sau ngay dat !\nHay nhap lai (dd-mm-yyy): ");
            nt = nhapNgay(dateFormat);
            ngayTra = dateFormat.format(nt);
        }
    }
    public String getmaKH(){
        return "KH" + khachHang.getmaKhachHang();
    }
    public String getgmail(){
        return khachHang.getgmail();
    }
    public String gethoTen(){
        return khachHang.gethoTen();
    }
    public String getcmnd(){
        return khachHang.getcmnd();
    }
    public String getsoDienThoai(){
        return khachHang.getsoDienThoai();
    }
    public String getdiaChi(){
        return khachHang.getdiaChi();
    }
    public Date nhapNgay(SimpleDateFormat dateFormat) {
        Date date = null;
        while (date == null) {
            String dateStr = scanner.nextLine();
            try {
                date = dateFormat.parse(dateStr);
            } catch (ParseException e) {
                System.out.print("Ngay nhap khong dung dinh dang, hay nhap lai dd-MM-yyyy: ");
            }
        }
        return date;
    }
    public double tinhTongTien(String maKH) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\LichSu.txt"))){
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if (parts[1].equals(maKH)){
                    ngayDat = parts[3];
                    ngayTra = parts[4];
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        phong = new Phong();
        try {
            Date dateNgayDat = dateFormat.parse(ngayDat);
            Date dateNgayTra = dateFormat.parse(ngayTra);
            long diffInMillies = Math.abs(dateNgayTra.getTime() - dateNgayDat.getTime());
            long diffInDays = diffInMillies / (24 * 60 * 60 * 1000);
            return diffInDays * phong.tinhTongTien(maKH);
    
        } catch (ParseException e) {
            System.out.println("Loi khi tinh tong tien: " + e.getMessage());
            return 0;
        }
    }
    public void nhapDuLieuDatPhong() {
        nhapDatPhong();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\ThongTinPhong.txt"))) {
            String line;
            boolean found = false;
            String[] Mtmp = new String[1000];
            int index = 0;
            System.out.print("Nhap phong muon dat: ");
            datp = scanner.nextLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(datp)) {
                    if (parts[0].equals(datp) && parts[1].equals("1")){
                        System.out.print("Phong da co nguoi dat, hay nhap lai: ");
                        datp = scanner.nextLine();
                    } else 
                    if (parts[1].equals("0")) {
                        Mtmp[index++] = datp + ",1," + ngayDat + "," + ngayTra;
                        LichSuDatPhong addls = new LichSuDatPhong();
                        addls.themLichSuDatPhong(null, getmaKH(), datp, ngayDat, ngayTra);
                        themKH(getmaKH(), datp, gethoTen(), getdiaChi(), getsoDienThoai(), getgmail(), ngayDat, ngayTra);
                        found = true;
                    } else {
                        Mtmp[index++] = line;
                    }
                } else {
                    Mtmp[index++] = line;
                }
            }
            if (found) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\ThongTinPhong.txt"))) {
                    for (int i = 0; i < index; i++) {
                        if (Mtmp[i] != null) {
                            bw.write(Mtmp[i]);
                            bw.newLine();
                        }
                    }
                    System.out.print("Da dat phong " + datp + " thanh cong\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void huyPhong(){
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\ThongTinPhong.txt"))){
            String line;
            String[] Mtmp = new String[1000];
            int index = 0;
            boolean found = false;
            System.out.print("Nhap ma phong muon huy: ");
            String huyp = scanner.nextLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (!parts[0].equals(huyp)){
                    Mtmp[index++] = line;
                } else {
                    if (parts[1].equals("1")){
                        Mtmp[index++] = huyp + ",0,NULL,NULL";
                        found = true;
                    } else {
                        System.out.print("Phong chua duoc dang ki, khong the huy\n");
                        Mtmp[index++] = line;
                    }
                }
            }
            if (found) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\ThongTinPhong.txt"))){
                    for (int i = 0; i < index; i++) {
                        if (Mtmp[i] != null) {
                            bw.write(Mtmp[i]);
                            bw.newLine();
                        }
                    }
                    System.out.print("Phong " + huyp + " da duoc huy thanh cong\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
