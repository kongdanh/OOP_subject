package function;
import java.util.Scanner;

public class DichVu{
    private String[] tenDichVu;
    private double giaDichVu;
    public DichVu(){}
    public DichVu(String[] tenDichVu, double giaDichVu){
        this.tenDichVu = tenDichVu;
        this.giaDichVu = giaDichVu;
    }
    Scanner scanner = new Scanner(System.in);
        public double hienThiThongTinDichVu(){
        System.out.print("Cac loai dich vu cua khach san: \n");
        System.out.print(" 1. An uong: 50.000/lan\n");
        System.out.print(" 2. Spa: 100.000/nguoi\n");
        System.out.print(" 3. Don phong: 30.000/lan\n");
        System.out.print(" 4. Dua don: 30.000/lan\n");
        System.out.print(" 5. Cac dich vu con lai cua khach san la mien phi\n");
        System.out.print(" Hay chon dich vu cho phong: ");
        String line = scanner.nextLine();
        String[] parts = line.trim().split(",");
        for (int i = 0; i < parts.length; i++){
            parts[i] = parts[i].trim();
        }
        tenDichVu = new String[parts.length];
        for (int i = 0; i < parts.length; i++){
            switch (parts[i]) {
                case "1":
                    System.out.print("Nhap so nguoi su dung dich vu an uong: ");
                    giaDichVu += scanner.nextInt()*50000;
                    tenDichVu[i] = "An uong";
                    break;
                case "2":
                    System.out.print("Nhap so nguoi su dung dich vu spa: ");
                    giaDichVu += scanner.nextInt()*100000;
                    tenDichVu[i] = "Spa";
                    break;
                case "3":
                    System.out.print("Nhap so lan don phong: ");
                    giaDichVu += scanner.nextInt()*30000;
                    tenDichVu[i] = "Don phong";
                    break;
                case "4":
                    System.out.print("Nhap so nguoi su dung dich vu dua don: ");
                    giaDichVu += scanner.nextInt()*30000;
                    tenDichVu[i] = "Dua don";
                    break;
                case "5":
                    giaDichVu += 0;
                    tenDichVu[i] = "Cac dich vu mien phi khac";
                    break;
                default:
                    System.out.print("Khong co dich vu tuong ung voi " + parts[i] + " -> Loi !\n");
                    break;            
            }
        }
        if (tenDichVu != null){
            System.out.print("Dich vu: ");
            for (String tmp: tenDichVu){
                if (tmp != "null") System.out.print(tmp + ", ");
            }
            System.out.print("\n");
        }
        return giaDichVu;
    }
    public double getgiaDichVu(){
        return giaDichVu;
    }
}
