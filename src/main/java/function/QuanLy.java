package function;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class QuanLy extends DangNhap{
    Scanner scanner = new Scanner(System.in, "UTF-8");
    public QuanLy(){}
    public QuanLy(DangNhap tkmk){
    }
    public void quanLyNhanVien(NhanVien nhanVien){
        System.out.print("  1. Xem thong tin nhan vien\n");
        System.out.print("  2. Them nhan vien\n");
        System.out.print("  3. Xoa nhan vien\n");
        System.out.print("  4. Thay doi thong tin nhan vien\n");
        System.out.print("  5. Tro ve\n");
        System.out.print("  6. Thoat\n");
        System.out.print("  - Nhap chuc nang: ");
        int choice = scanner.nextInt();
        while (choice < 1 || choice > 6){
            System.out.print(" !!! Chua co chuc nang khac, hay nhap lai !!!\n");
            System.out.print("  1. Xem thong tin nhan vien\n");
            System.out.print("  2. Them nhan vien\n");
            System.out.print("  3. Xoa nhan vien\n");
            System.out.print("  4. Thay doi thong tin nhan vien\n");
            System.out.print("  5. Tro ve\n");
            System.out.print("  - Nhap chuc nang: ");
            choice = scanner.nextInt();
        }
        switch (choice) {
            case 1:
                xemThongTinNhanVien();
                break;
            case 2:
                themNhanVien();
                break;
            case 3:
                xoaNhanVien();
                break;
            case 4:
                chinhSuaTTNV();
                break;
            case 5:
                menu();
                break;
            default:
                System.out.print("Chưa có chức năng này");
                break;
        }
    }
    public void menu(){
        System.out.print("----- QUAN LY ------\n");
        System.out.print("1. Quan ly nhan vien\n");
        System.out.print("2. Quan ly dat phong\n");
        System.out.print("3. Hien trang cua khach san\n");
        System.out.print("4. Lich su thue phong\n");
        System.out.print("5. Danh sach khach hang da thue\n");
        System.out.print("6. Thay doi thong tin ca nhan\n");
        System.out.print("7. Doanh thu\n");
        System.out.print("8. Bang luong nhan vien\n");
        System.out.print("9. Thoat\n");
        System.out.print("10. kiem tra tuoi khach\n ");
        System.out.print(" - Nhap chuc nang: ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                quanLyNhanVien(null);
                break;
            case "2":
                DatPhong a = new DatPhong();
                Hotel trangthai = new Hotel();
                trangthai.hienThiThongTin();
                System.out.print("   \n1. Dat them phong moi\n");
                System.out.print("   2. Huy phong da dat\n");
                System.out.print("   3. Tro ve\nHay nhap chuc nang: ");
                int c = scanner.nextInt();
                while (c < 1 && c > 3 ) {
                    System.out.print("Loi, nhap lai chuc nang: ");
                    c = scanner.nextInt();
                }
                scanner.nextLine();
                if (c == 1) {
                    a.nhapDuLieuDatPhong();
                    if (checkcotn()) {
                        menu();
                    }
                    break;
                }
                if (c == 2) {
                    a.huyPhong();
                    if (checkcotn()) {
                        menu();
                    }
                    break;
                }
                if (c == 3) menu();
                break;
            case "3": 
                System.out.print("Cac thao tac khach san cua QUAN LY: \n");
                System.out.print("1. Them phong moi cho khach san\n");
                System.out.print("2. Xoa phong cua khach san\n");
                System.out.print("3. Xem trang thai khach san hien tai\n");
                System.out.print("4. Tro ve\n");
                System.out.print("Nhap chuc nang: ");
                int select = scanner.nextInt();
                while (select > 4 && select < 1) {
                    System.out.print("Chua co chuc nang khac, hay nhap lai: ");
                    select = scanner.nextInt();
                }
                scanner.nextLine();
                Hotel h = new Hotel();
                if (select == 1) h.themPhong(null);
                if (select == 2) h.xoaPhong(null);
                if (select == 3) tinhTrangKhachSan();
                if (select == 4) menu();
                if (checkcotn()) {
                    menu();
                }
                break;
            case "4":
                lichSuThuePhong();
                if (checkcotn()) {
                    menu();
                }
                break;
            case "5":
                thongTinKhachHang();
                if (checkcotn()) {
                    menu();
                }
                break;
            case "6":
                TienIchTaiKhoan.chinhSuaThongTinCaNhan(tenDangNhap,matKhau);
                if (checkcotn()) {
                    menu();
                }
                break;
            case "7":
                System.out.println("Bang doanh thu: ");
                ThongKebase dt = new ThongKe();
                dt.doanhThuTB();
                dt.xuatThongKe();
                if (checkcotn()) {
                    menu();
                }
                break;
            case "8":
                KtraBL();
                if (checkcotn()) {
                    menu();
                }
                break;
            case "9":
                System.out.print("Ket thuc phien dang nhap... tam biet ban !\n");
                break;
            case "10":
                kiemtraKhach();
                break;
            default:
                System.out.print("Chua co chuc nang khac");
                break;
        }
    }
    public void xemThongTinNhanVien() {
        System.out.print("1. Xem thong tin cua nhan vien theo ten\n");
        System.out.print("2. Xem thong tin toan bo nhan vien\n");
        System.out.print("3. Tro ve\n");
        System.out.print("Nhap chuc nang muon thuc hien: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Nhap ten cua nhan vien: ");
                String tmp = scanner.nextLine();
                boolean found = false;
                try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\account.txt"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts.length == 6 && tmp.equals(parts[3].trim())) {
                            System.out.print("Ten nhan vien: " + parts[3] + "\n");
                            System.out.print("So dien thoai: " + parts[4] + "\n");
                            System.out.print("Dia chi gmail: " + parts[5] + "\n");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Khong co nhan vien voi ten da nhap");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (checkcotn()) {
                    menu();
                }
                break;
            case 2:
                try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\account.txt"))) {
                    String line;
                    boolean hasEmployee = false;
                    System.out.println("Thong tin toan bo nhan vien:");
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts[2].trim().equals("NV")) {
                            System.out.print("--------------------------------\n");
                            System.out.print("Ten nhan vien: " + parts[3] + "\n");
                            System.out.print("So dien thoai: " + parts[4] + "\n");
                            System.out.print("Dia chi gmail: " + parts[5] + "\n");
                            System.out.print("So ngay cong: " + parts[6] + "\n");
                            System.out.print("Luong hien tai: " + Integer.parseInt(parts[6]) * 500000 + "\n");
                            hasEmployee = true;
                        }
                    }
                    if (!hasEmployee) {
                        System.out.println("Khong co nhan vien !");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (checkcotn()) {
                    menu();
                }
                else break;
            case 3:
                System.out.print("\033[H\033[2J");
                menu();
                break;
    
            default:
                System.out.print("Chua co chuc nang khac\n");
                break;
        }
    }
    public void themNhanVien(){
            System.out.print("  1. Them 1 nhan vien\n");
            System.out.print("  2. Them nhieu nhan vien\n");
            System.out.print("  3. Tro ve\n");
            System.out.print("  Nhap chuc nang: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\account.txt", true))){
                        System.out.print("  Nhap ten dang nhap cho nhan vien moi: ");
                        String tenDN = scanner.nextLine();
                        System.out.print("  Nhap mat khau cho nhan vien moi: ");
                        String MK = scanner.nextLine();
                        System.out.print("  Nhap chuc vu cho nhan vien moi (QL: quan ly hoac NV: nhan vien):  ");
                        String CV = scanner.nextLine();
                        while (!CV.equals("QL") && !CV.equals("NV")) {
                            System.out.print("  Chua co chuc vu khac, hay nhap lai: ");
                            CV = scanner.nextLine();
                        }
                        System.out.print("  Nhap ho ten cho nhan vien moi: ");
                        String hoTen = scanner.nextLine();
                        System.out.print("  Nhap so dien thoai cho nhan vien moi: ");
                        String sdt = scanner.nextLine();
                        while (sdt.length() != 10 || !sdt.matches("\\d+")) {
                            System.out.print("  So dien thoai bi loi, hay nhap lai: ");
                            sdt = scanner.nextLine();
                        }
                        System.out.print("  Nhap gmail cho nhan vien moi: ");
                        String gmail = scanner.nextLine();
                        while (!gmail.contains("@")){
                            System.out.print("  Gmail bi loi, hay nhap lai: ");
                            gmail = scanner.nextLine();
                        }
                        bw.newLine();
                        bw.write(tenDN + "," + MK + "," + CV + "," + hoTen + "," + sdt + "," + gmail);
                        System.out.print("\tDa them nhan vien thanh cong\n");
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    if (checkcotn()) {
                        menu();
                    }
                    else break;
                case 2:
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\account.txt", true))){
                        System.out.print("  Nhap so luong nhan vien muon them: ");
                        int slg = scanner.nextInt();
                        scanner.nextLine();
                        for (int i = 1; i <= slg; i++){
                            System.out.print("  Nhap ten dang nhap cho nhan vien moi thu  " + i + ": ");
                            String tenDN = scanner.nextLine();
                            System.out.print("  Nhap mat khau cho nhan vien moi: ");
                            String MK = scanner.nextLine();
                            System.out.print("  Nhap chuc vu cho nhan vien moi (QL: quan ly hoac NV: nhan vien): ");
                            String CV = scanner.nextLine();
                            while (!CV.equals("QL") && !CV.equals("NV")) {
                                System.out.print("  Chua co chuc vu khac, hay nhap lai: ");
                                CV = scanner.nextLine();
                            }
                            System.out.print("  Nhap ho ten cho nhan vien moi: ");
                            String hoTen = scanner.nextLine();
                            System.out.print("  Nhap so dien thoai cua nhan vien moi: ");
                            String sdt = scanner.nextLine();
                            while (sdt.length() != 10 || !sdt.matches("\\d+")) {
                                System.out.print("  So dien thoai bi loi, hay nhap lai: ");
                                sdt = scanner.nextLine();
                            }
                            System.out.print("  Nhap gmail cua nhan vien moi: ");
                            String gmail = scanner.nextLine();
                            while (!gmail.contains("@")){
                                System.out.print("  Gmail bi loi, hay nhap lai: ");
                                gmail = scanner.nextLine();
                            }
                            bw.newLine();
                            bw.write(tenDN + "," + MK + "," + CV + "," + hoTen + "," + sdt + "," + gmail);
                        }
                        System.out.print("\tDa them " + slg + " nhan vien moi\n");
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                    if (checkcotn()) {
                        menu();
                    }
                    else break;
                    case 3:
                    System.out.print("\033[H\033[2J");
                    menu();
                    break;
                default:
                    System.out.print("Chua co chuc nang khac");
                    break;
            }
    }
    public void xoaNhanVien(){
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\account.txt"))){
            System.out.print("   1. Xoa 1 nhan vien\n");
            System.out.print("   2. Xoa toan bo nhan vien(!)\n");
            System.out.print("   3. Tro ve\n");
            System.out.print("   Nhap chuc nang: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    String line;
                    String[] Mtmp = new String[1000];
                    int count = 0;
                    System.out.print("Nhap ten nhan vien can xoa: ");
                    String xnv = scanner.nextLine();
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (!parts[3].trim().equals(xnv)) {
                            Mtmp[count++] = line;
                        }
                    }
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\account.txt"))) {
                        for (int i = 0; i < count; i++) {
                            bw.write(Mtmp[i]);
                            bw.newLine();
                        }
                        System.out.println("Da xoa nhan vien " + xnv);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (checkcotn()) {
                        menu();
                    } else {
                        break;
                    }                
                    case 2:
                        System.out.print("Ban co chac chan xoa toan bo nhan vien? (Y) ");
                        String sure = scanner.nextLine();
                        if (sure.toLowerCase().equals("y") || sure.toLowerCase().equals("yes")) {
                            String[] Mtmpcase2 = new String[1000];
                            count = 0;
                            System.out.print("Nhap lai mat khau cua ban");
                            String MKQL = scanner.nextLine();
                            boolean ktmk = false;
                    
                            while ((line = br.readLine()) != null) {
                                String[] checkMK = line.split(",");
                                if (checkMK[1].equals(MKQL) && checkMK[2].equals("QL")) {
                                    ktmk = true;
                                }
                    
                                if (ktmk) {
                                    String[] parts = line.split(",");
                                    if (!parts[2].trim().equals("NV")) {
                                        Mtmpcase2[count++] = line;
                                    }
                                } else {
                                    System.out.print("Sai mat khau -> chuc nang bi huy\n");
                                    break;
                                }
                            }
                            if (ktmk) {
                                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\account.txt"))) {
                                    for (int i = 0; i < count; i++) {
                                        bw.write(Mtmpcase2[i]);
                                        bw.newLine();
                                    }
                                    System.out.println("Da xoa toan bo nhan vien");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            System.out.print("Chuc nang bi huy\n");
                        }
                        if (checkcotn()) {
                            menu();
                        } else {
                            break;
                        }
                case 3:
                    System.out.print("\033[H\033[2J");
                    menu();
                    break;
                default:
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }   
    public boolean checkcotn(){
        System.out.print("Ban co muon tiep tuc (Y): ");
        String ctncase2 = scanner.nextLine();
        if (ctncase2.toLowerCase().equals("y") || ctncase2.toLowerCase().equals("yes")){
            return true;
        }
        else {
            System.out.print("Ket thuc chuong trinh... tam biet ban !\n");
            return false;
        }
    }
    public void chinhSuaTTNV() {
        System.out.print("1. Nhap nhan vien muon thay doi thong tin\n");
        System.out.print("2. Tro ve\n");
        System.out.print("Nhap chuc nang: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
    
        switch (choice) {
            case 1:
                System.out.print("Nhap ten nhan vien thuc hien chuc nang: ");
                String tenv = scanner.nextLine();
                try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\account.txt"))) {
                    String[] linecs = new String[1000];
                    int count = 0;
                    String line;
                    boolean found = false;
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts[3].equals(tenv)) {
                            found = true;
                            System.out.print("   Thay doi thong tin   \n");
                            System.out.print("  Nhap ma loai thay doi (cach nhay boi ','): \n");
                            System.out.print("  Ten dang nhap(tendangnhap)\n");
                            System.out.print("  Mat khau(matkhau)\n");
                            System.out.print("  Chuc vu(cv)\n");
                            System.out.print("  Ho ten(hoten)\n");
                            System.out.print("  So dien thoai(sdt)\n");
                            System.out.print("  Dia chi gmail(gmail)\n");
                            System.out.print("  Tat ca thong tin(all)\n");
                            System.out.print("  ---> ");
                            String cs = scanner.nextLine();
                            String[] loaitt = cs.split(",");
                            for (String tmp : loaitt) {
                                if (tmp.equals("tendangnhap")) {
                                    System.out.print("Nhap ten dang nhap moi ho nhan vien: ");
                                    parts[0] = scanner.nextLine();
                                }
                                if (tmp.equals("matkhau")) {
                                    System.out.print("Nhap mat khau moi cho nhan vien: ");
                                    parts[1] = scanner.nextLine();
                                }
                                if (tmp.equals("cv")) {
                                    System.out.print("Nhap chuc vu moi (QL: quan ly hoac NV: nhan vien): ");
                                    parts[2] = scanner.nextLine();
                                    while (!parts[2].equals("QL") && !parts[2].equals("NV")) {
                                        System.out.print("Khong co chuc vu khac, hay nhap lai: ");
                                        parts[2] = scanner.nextLine();
                                    }
                                }
                                if (tmp.equals("hoten")) {
                                    System.out.print("Nhap ho ten moi cho nhan vien: ");
                                    parts[3] = scanner.nextLine();
                                }
                                if (tmp.equals("sdt")) {
                                    System.out.print("Nhap so dien thoai moi cho nhan vien: ");
                                    parts[4] = scanner.nextLine();
                                    while (parts[4].length() != 10 || !parts[4].matches("\\d+")) {
                                        System.out.print("So dien thoai bi loi, hay nhap lai: ");
                                        parts[4] = scanner.nextLine();
                                    }
                                }
                                if (tmp.equals("gmail")) {
                                    System.out.print("Nhap gmail moi cho nhan vien: ");
                                    parts[5] = scanner.nextLine();
                                    while (!parts[5].contains("@")) {
                                        System.out.print("Gmail bi loi, hay nhap lai: ");
                                        parts[5] = scanner.nextLine();
                                    }
                                }
                            }
                            line = String.join(",", parts);
                        }
                        linecs[count++] = line;
                    }
                    if (found) {
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\account.txt"))) {
                            for (int i = 0; i < count; i++) {
                                bw.write(linecs[i]);
                                bw.newLine();
                            }
                            System.out.println("Thong tin da duoc cap nhat");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Khong tim thay nhan vien");
                    }
    
                } catch (IOException e) {
                    e.printStackTrace();
                }
    
                if (checkcotn()) {
                    menu();
                }
                break;
    
            case 2:
                menu();
                break;
    
            default:
                System.out.print("Chua co chuc nang khac");
                break;
        }
    }
    public void tinhTrangKhachSan() {
        try (BufferedReader bw = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\ThongTinPhong.txt"))) {
            String line;
            int tongSoPhong = 0;
            System.out.println("+------------+------------+------------+------------+------------+");
            System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s |\n", "Tang", "Phong", "Trang thai", "Ngay nhan", "Ngay tra");
            System.out.println("+------------+------------+------------+------------+------------+");
            while ((line = bw.readLine()) != null) {
                tongSoPhong++;
                String[] parts = line.split(",");
                String floor = "", room = "", Trangthai = "", NgayNhan = "", NgayTra = "";
                    if (parts[0].startsWith("T")) {
                    floor = "Tret";
                    room = parts[0].substring(1);
                    if (parts[1].equals("0")){
                        Trangthai = "Trong";
                    }
                    else Trangthai = "Da thue";
                    NgayNhan = parts[2];
                    NgayTra = parts[3];
                } else if (parts[0].startsWith("L")) {
                    floor = parts[0].substring(1, 2);
                    room = parts[0].substring(2);
                    if (parts[1].equals("0")){
                        Trangthai = "Trong";
                    }
                    else Trangthai = "Da thue";
                    NgayNhan = parts[2];
                    NgayTra = parts[3];
                }
                System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s |\n", floor, room, Trangthai,NgayNhan, NgayTra);
            }
            System.out.println("+------------+------------+------------+------------+------------+");
            System.out.println("Tong so phong: " + tongSoPhong);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void lichSuThuePhong(){
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\LichSu.txt"))) {
            String line;
            System.out.println("+------------------+---------------+------------+------------------+----------------+-----------------------+");
            System.out.printf("| %-16s | %-9s | %-10s | %-16s | %-14s | %-21s |\n", "Ma dat phong", "Ma khach hang", "Phong", "Ngay nhan", "Ngay tra", "Thanh toan");
            System.out.println("+------------------+---------------+------------+------------------+----------------+-----------------------+");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String MaDP = "", MaKH = "",Phong = "", NgayNhan = "", NgayTra = "", ThanhToan = "";
                MaDP = parts[0];
                MaKH = parts[1];
                Phong = parts[2];
                NgayNhan = parts[3];
                NgayTra = parts[4];
                ThanhToan = parts[5];
                System.out.printf("| %-16s | %-9s | %-10s | %-16s | %-14s | %-21s |\n", MaDP, MaKH, Phong, NgayNhan,NgayTra,ThanhToan);
            }
            System.out.println("+------------------+---------------+------------+------------------+----------------+-----------------------+");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void thongTinKhachHang(){
        System.out.println("+---------------+------------+-----------------+------------+------------+-----------------+-----------------+-----------------+");
        System.out.printf("| %-6s | %-5s | %-20s | %-10s | %-10s | %-20s | %-10s | %-10s |\n", "Ma khach hang","Ma phong", "Ho ten", "Dia chi", "So dien thoai", "Gmail","Ngay nhan","Ngay Tra");
        System.out.println("+--------------+---------------+------------+------------+------------+-----------------+-----------------+-----------------+");
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\ThongTinKhachHang.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String MaKH = "", MaPhong = "", hoTen = "", diaChi = "", soDienThoai = "", gmail = "", NgayNhan = "", NgayTra = "";
                MaKH = parts[0]; MaPhong = parts[1];
                hoTen = parts[2]; diaChi = parts[3];
                soDienThoai = parts[4]; gmail = parts[5];
                NgayNhan = parts[6]; NgayTra = parts[7];
                System.out.printf("| %-12s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n", MaKH,MaPhong,hoTen,diaChi,soDienThoai,gmail,NgayNhan,NgayTra);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("+--------------+---------------+------------+------------+------------+-----------------+-----------------+-----------------+");
    }
    public void KtraBL() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\account.txt"))) {
            String line;
            System.out.println("+--------------+------------+------------+--------------+");
            System.out.printf("| %-10s | %-10s | %-10s | %-12s |\n", "Ten NhanVien","So cong","Luong","Thuong");
            System.out.println("+--------------+------------+------------+--------------+");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[2].equals("NV")) {
                    int soCong = Integer.parseInt(parts[6]);
                    int luong = soCong * 500000;
                    double ThuongNV = 0;
                    if (soCong > 27) {
                        ThuongNV = luong * 0.1;
                    }
                    System.out.printf("| %-10s | %-10s | %-10s | %-12s |\n", parts[3], String.valueOf(soCong),String.format("%,d", luong),String.format("%,.2f", ThuongNV));
                }
            }
            System.out.println("+--------------+------------+------------+--------------+");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void kiemtraKhach(){
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\\\Users\\\\danhc\\\\Documents\\\\HK2\\\\OOP\\\\QuanLyKhachSan\\\\DuLieu\\\\ThongTinKhachHang.txt"))){
            String line;
            int behon25 = 0, tu25toi40 = 0, tren40 = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int tuoi = Integer.parseInt(parts[8].substring(4,6));
                if (tuoi < 25) behon25++;
                if (tuoi >= 25 && tuoi <= 40) tu25toi40++;
                if (tuoi>40) tren40++;
            }
            System.out.println("be hon 25 la: " + behon25);
            System.out.println("tu 25 toi 40 la"  + tu25toi40);
            System.out.println("tren 40 la: " + tren40);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
