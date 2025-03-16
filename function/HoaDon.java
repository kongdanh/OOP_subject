package funtion;

import java.io.BufferedReader;
import java.io.FileReader;

public class HoaDon extends DichVu {
    public HoaDon(){}
    public boolean thongTinHoaDon(String maKH){
        String maP = "";
        boolean foundKH = false;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\LichSu.txt"))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(maKH)){
                    foundKH = true;
                    maP = parts[2];
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        if (foundKH){
            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\LichSu.txt"))){
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                     if (parts[1].equals(maKH) && parts[2].equals(maP)){
                        if (parts[5].equals("paid")){
                            System.out.print("Khach hang voi ma " + maKH + " da thanh toan\n");
                            return false;
                        }
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            System.out.print("Khong tim thay khach hang voi ma  " + maKH + "\n");
            return false;
        }
        return true;
    }
}
