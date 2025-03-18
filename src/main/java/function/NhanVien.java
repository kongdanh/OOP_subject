package function;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class NhanVien extends DangNhap{
    public NhanVien(){}
    public NhanVien(String hoTen){
    }
    public void menuNV(){
        System.out.print("----- NHAN VIEN ------\n");
        System.out.print("1. Quan ly phong (dat phong, huy phong)\n");
        System.out.print("2. Xuat hoa don theo ma khach hang\n");
        System.out.print("3. Xem trang thai khach san\n");
        System.out.print("4. Thay doi thong tin ca nhan (ten, so dien thoai, gmail)\n");
        System.out.print("5. Cham cong\n");
        System.out.print("6. Dang xuat\n");
        System.out.print("  Nhap chuc nang muon thuc hien: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                DatPhong a = new DatPhong();
                Hotel trangthai = new Hotel();
                trangthai.hienThiThongTin();
                System.out.print("\n1. Dat them phong\n");
                System.out.print("2. Huy phong da dat\n");
                System.out.print("3. Tro ve\n");
                System.out.print("Nhap chuc nang: ");
                int c = scanner.nextInt();
                while (c < 1 && c > 3) {
                    System.out.print("Chua co chuc nang khac, hay nhap lai: ");
                    c = scanner.nextInt();
                }
                scanner.nextLine();
                if (c == 1) {
                    a.nhapDuLieuDatPhong();
                    if (checkcotn()) {
                        menuNV();
                    }
                    break;
                }
                if (c == 2) {
                    a.huyPhong();
                    if (checkcotn()) {
                        menuNV();
                    }
                    break;
                }
                if (c == 3) menuNV();
                break;
            case 2:
                HoaDon hd = new HoaDon();
                System.out.print("Nhap ma khach hang (KH + ***): ");
                String maKH = scanner.nextLine();
                System.out.print("Xuat hoa don: \n");
                if (hd.thongTinHoaDon(maKH)){
                    ThanhToanHD tt = new ThanhToanHD();
                    tt.thanhToan(maKH,tenDangNhap, matKhau);
                }
                if (checkcotn()) {
                    menuNV();
                }
                break;
            case 3:
                QuanLy xemTrangThai = new QuanLy();
                xemTrangThai.tinhTrangKhachSan();
                if (checkcotn()) {
                    menuNV();
                }
                break;
            case 4:
                TienIchTaiKhoan.chinhSuaThongTinCaNhan(tenDangNhap, matKhau);
                if (checkcotn()) {
                    menuNV();
                }
                break;
            case 5:
                int sc = ChamCongNV(tenDangNhap, matKhau);
                System.out.print("Ban da cham cong thanh cong!\nSo ngay lam vien hien tai cua ban la: " + sc + "\n");
                if (checkcotn()) {
                    menuNV();
                }
                break;
            case 6:
                break;
            default:
                break;
        }
    }
    public int ChamCongNV(String tenDn, String mk){
        int scht = 0;
        String[] ChamC = new String[1000];
        int index = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\\\Users\\\\danhc\\\\Documents\\\\HK2\\\\OOP\\\\QuanLyKhachSan\\\\DuLieu\\\\account.txt"))){
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if (parts[0].equals(tenDn) && parts[1].equals(mk) && parts[2].equals("NV")){
                    ChamC[index++] = parts[0] + "," + parts[1] + "," + parts[2] + "," + parts[3] + "," + parts[4]
                            + "," + parts[5] + "," + (Integer.parseInt(parts[6]) + 1);
                    scht = Integer.parseInt(parts[6]) + 1;
                } else {
                    ChamC[index++] = line;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\\\Users\\\\danhc\\\\Documents\\\\HK2\\\\OOP\\\\QuanLyKhachSan\\\\DuLieu\\\\account.txt"))){
            for (int i = 0; i < index; i++){
                if (ChamC[i] != null) {
                    bw.write(ChamC[i]);
                    bw.newLine();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return scht;
    }    
    public boolean checkcotn(){
        System.out.print("Ban co muon tiep tuc (Y): ");
        String ctncase2 = scanner.nextLine();
        if (ctncase2.toLowerCase().equals("y") || ctncase2.toLowerCase().equals("yes")){
            return true;
        }
        else {
            System.out.print("Ket thuc chuong trinh... tam biet ban  !\n");
            return false;
        }
    }
}
