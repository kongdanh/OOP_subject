package funtion;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class KhachHang implements IDatPhong{
    private String hoTen;
    private String cmnd;
    private String soDienThoai;
    private String diaChi;
    private String ngayThue;
    private String ngayTra;
    protected String maKhachHang;
    private String maPhong;
    private String gmail;
    Scanner scanner = new Scanner(System.in);
    public KhachHang(){}
    //constructor
    public KhachHang(String hoTen, String cmnd, String soDienThoai, String diaChi,String maPhong,String gmail, String ngayThue, String ngayTra, String maKhachHang){
        this.hoTen = hoTen;
        this.cmnd = cmnd;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.maPhong = maPhong;
        this.gmail = gmail;
        this.ngayThue = ngayThue;
        this.ngayTra = ngayTra;
        this.maKhachHang = maKhachHang;
    }
    public String getgmail(){
        return gmail;
    }
    public String getmaPhong(){
        return maPhong;
    }
    public String gethoTen(){
        return hoTen;
    }
    public String getcmnd(){
        return cmnd;
    }
    public String getsoDienThoai(){
        return soDienThoai;
    }
    public String getdiaChi(){
        return diaChi;
    }
    public String getngayThue(){
        return ngayThue;
    }
    public String getngayTra(){
        return ngayTra;
    }
    public String getmaKhachHang(){
        try (BufferedReader bw = new BufferedReader(new FileReader("C:\\\\Users\\\\danhc\\\\Documents\\\\HK2\\\\OOP\\\\QuanLyKhachSan\\\\Dulieu\\\\ThongTinKhachHang.txt"))){
            String line;
            while ((line = bw.readLine()) != null) {
                String[] parts = line.split(",");
                maKhachHang = parts[0];
            }
            int number = Integer.parseInt(maKhachHang.substring(2));
            number++;
            maKhachHang = String.format("%03d", number);
            return maKhachHang;
        } catch (Exception e){
            e.printStackTrace();
        }
        return maKhachHang;
    }
    public void setgmail(String gmail){
        while (!gmail.contains("@")){
            System.out.print("Gmail bi loi, hay nhap lai: ");
            gmail = scanner.nextLine();
        }
        this.gmail = gmail;
    }
    public void setmaPhong(String maPhong){
        this.maPhong = maPhong;
    }
    public void setNgayThue(String ngayThue){
        this.ngayThue = ngayThue;
    }
    public void setNgayTra(String ngayTra){
        this.ngayTra = ngayTra;
    }
    public void sethoTen(String hoTen){
        this.hoTen = hoTen;
    }
    public void setdiaChi(String diaChi){
        this.diaChi = diaChi;
    }
    public void setmaKhachHang(String maKhachHang){
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\Dulieu\\ThongTinKhachHang.txt"))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                this.maKhachHang = maKhachHang;
                while (maKhachHang.equals(parts[0]) || maKhachHang.length() != 3 || !maKhachHang.matches("\\d+")){
                    System.out.print("Ma khach hang da ton tai hoac khong dung du lieu, hay nhap lai:  ");
                    this.maKhachHang = "KH" + maKhachHang;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return;
    }
    public boolean setCmnd(String cmnd){
        int namSinh = Integer.parseInt(cmnd.substring(4,6));
        if (namSinh > 24){
            this.cmnd = cmnd;
            return true;
        }
        if ((24 - namSinh) < 18){
            System.out.print("Chua du tuoi de thue phong !\n");
            System.out.print("Tro ve menu...\n");
            QuanLy a = new QuanLy();
            a.menu();
            return false;
        }
        else this.cmnd = cmnd;
        return true;
    }
    public void setsoDienThoai(String soDienThoai){
        if (soDienThoai.matches("\\d+") && soDienThoai.length() == 10){
            this.soDienThoai = soDienThoai;
        }
        else {
            System.out.print("So dien thoai khong hop le, hay nhap lai: ");
            soDienThoai = scanner.nextLine();
            this.soDienThoai = soDienThoai;
        }
    }
    public void nhapDuLieuKhachHang(){
        System.out.print("Nhap ten khach hang: ");
        hoTen = scanner.nextLine();
        System.out.print("Nhap can cuoc cong dan: ");
        if (!setCmnd(scanner.nextLine())) return;
        System.out.print("Nhap so dien thoai khach hang: ");
        setsoDienThoai(scanner.nextLine());
        System.out.print("Nhap dia chi khach hang: ");
        diaChi = scanner.nextLine();
        System.out.print("Nhap gmail khach hang: ");
        setgmail(scanner.nextLine());
        System.out.print("Ma khach hang la : " + getmaKhachHang() + "\n");
    }
    public void hienThiThongTin(){
        
    }
    @Override
    public boolean datPhong(Phong phong) {
        return false;
    }
    @Override
    public boolean huyPhong(Phong phong) {
        return false;
    }
    public void themKH(String makh,String map, String tenkh, String dichi, String sdt, String gmail,String nthue, String ntra){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\ThongTinKhachHang.txt", true))){
            bw.write(makh + "," + map + "," + tenkh + "," + diaChi + "," + sdt + "," + gmail + "," + nthue + "," + ntra + "," + cmnd);
            bw.newLine();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
