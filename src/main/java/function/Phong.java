package function;
import java.io.*;

public class Phong extends DatPhong{
    public Phong(){}
    public double tinhTongTien(String maKH){
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\LichSu.txt"))){
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if (parts[1].equals(maKH)){    
                    if (Integer.parseInt(parts[2].substring(1)) <= 5){
                        PhongDon pdon = new PhongDon();
                        return pdon.tinhTongTien();
                    } else {
                        PhongDoi pdoi = new PhongDoi();
                        return pdoi.tinhTongTien();
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
