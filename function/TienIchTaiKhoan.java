package funtion;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TienIchTaiKhoan {
    static final File file = new File("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\account.txt");
    private static final Scanner scanner = new Scanner(System.in, "UTF-8");
    public static void kiemTraDangNhap(String tenDangNhap, String matKhau) {
        boolean found = false;
        int count = 0;
        while (!found && count < 3) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                boolean findUser = false;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts[0].equals(tenDangNhap) && parts[1].equals(matKhau)) {
                        findUser = true;
                        found = true;
    
                        if ("QL".equals(parts[2])) {
                            QuanLy quanLy = new QuanLy();
                            quanLy.menu();
                        } else if ("NV".equals(parts[2])) {
                            NhanVien nhanVien = new NhanVien();
                            nhanVien.menuNV();
                        }
                        break;
                    }
                }
                if (!findUser) {
                    count++;
                    if (count < 3) {
                        System.out.println("Sai ten dang nhap hoac mat khau lan " + count + "!");
                        System.out.print("Nhap lai ten dang nhap: ");
                        tenDangNhap = scanner.nextLine();
                        System.out.print("Nhap lai mat khau: ");
                        matKhau = scanner.nextLine();
                    } else {
                        System.out.println("Ban da nhap sai qua 3 lan !\nHay lien he voi quan li de tim lai mat khau");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static final void chinhSuaThongTinCaNhan(String tenDangNhap, String matKhau) {
        boolean isAuthenticated = false;
        String[] lines = new String[1000];
        int lineCount = 0;
        if (!file.exists()) {
            System.out.println("File account.txt khong ton tai!");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(tenDangNhap) && parts[1].equals(matKhau)) {
                    isAuthenticated = true;
                    System.out.println("Hay chinh sua thong tin ca nhan");
                    System.out.print("Nhap ho ten moi(hoac de trong de giu nguyen): ");
                    String hoten = scanner.nextLine();
                    if (!hoten.isEmpty()) {
                        parts[3] = hoten;
                    }
                    System.out.print("Nhap so dien thoai moi (hoac de trong de giu nguyen): ");
                    String sdt = scanner.nextLine();
                    if (!sdt.isEmpty()) {
                        while (!sdt.matches("\\d{10}")) {
                            System.out.print("So dien thoai khong hop le, hay nhap lai: ");
                            sdt = scanner.nextLine();
                        }
                        parts[4] = sdt;
                    }
                    System.out.print("Nhap gmail moi (hoac de trong de giu nguyen): ");
                    String gmail = scanner.nextLine();
                    if (!gmail.isEmpty()) {
                        while (!gmail.contains("@")){
                            System.out.print("Gmail bi loi, hay nhap lai: ");
                            gmail = scanner.nextLine();
                        }
                        parts[5] = gmail;
                    }
                    line = String.join(",", parts);
                }
                lines[lineCount++] = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        if (isAuthenticated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                for (int i = 0; i < lineCount; i++) {
                    bw.write(lines[i]);
                    bw.newLine();
                }
                System.out.println("Thong tin ca nhan da duoc cap nhat");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Loi tinh nang !");
        }
    }     
}
