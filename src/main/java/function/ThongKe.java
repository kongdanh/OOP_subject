package function;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class ThongKe extends ThongKebase{
    public ThongKe(){}
    @Override
    public void doanhThuTB(){
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\LichSu.txt"))){
            String line;
            System.out.println("+------------+------------+------------+------------+");
            System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "Ma Phong", "Tien phong", "Tien DV" , "Tong tien");
            System.out.println("+------------+------------+------------+------------+");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); 
                if (parts[5].equals("paid")) {  
                    String ngayNhan = parts[3];  
                    String ngayTra = parts[4];  
                    Phong p = new Phong();
                    double doanhThu1P = p.tinhTongTien(parts[1]); 
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        Date startDate = sdf.parse(ngayNhan);
                        Date endDate = sdf.parse(ngayTra);
                        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
                        long soNgay = diffInMillies / (24 * 60 * 60 * 1000); 
                        double doanhThuPhong = doanhThu1P * soNgay;
                        double TongTienPhong = doanhThuPhong + Integer.parseInt(parts[6]);
                        TongTienDV += Integer.parseInt(parts[6]);
                        doanhThu += TongTienPhong;
                        soPhongSuDung += 1;
                        System.out.printf("| %-10s | %-10.0f | %-10s | %-10.0f |\n", parts[2], doanhThuPhong, parts[6], TongTienPhong);
                    } catch (Exception e) {
                        e.printStackTrace(); 
                    }
                }
            }
            System.out.println("+------------+------------+------------+------------+");
        } catch (Exception e) {
            e.printStackTrace(); 
       }
    }
}
