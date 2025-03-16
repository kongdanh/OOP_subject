package funtion;
import java.util.Scanner;

public class DangNhap extends Hotel{
    protected static String tenDangNhap;
    protected static String matKhau;
    static Scanner scanner = new Scanner(System.in, "UTF-8");
    public DangNhap(){}
    // constructor
    public DangNhap(String tenDangNhap, String matKhau){
    }
    public static void dangNhap(){
        System.out.println("______________________________");
        System.out.println("||             H            ||");
        System.out.println("||             O            ||");
        System.out.println("||             T            ||");
        System.out.println("||             E            ||");
        System.out.println("||             L            ||");
        System.out.println("||             2            ||");
        System.out.println("||             4            ||");
        System.out.println("||==========================||");
        System.out.println("||           Welcome        ||");
        System.out.println("||~~~~~~~~~~~~~~~~~~~~~~~~~~||");
        System.out.println("||         L O G I N        ||");
        System.out.println("||~~~~~~~~~~~~~~~~~~~~~~~~~~||");
        System.out.print(" - Nhap ten dang nhap: ");
        tenDangNhap = scanner.nextLine();
        System.out.print(" - Nhap mat khau: ");
        matKhau = scanner.nextLine();
        TienIchTaiKhoan.kiemTraDangNhap(tenDangNhap, matKhau);
            return;
        }
    public void dangXuat(){
        return;
    }
}
