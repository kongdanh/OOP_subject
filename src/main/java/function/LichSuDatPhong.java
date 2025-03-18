package function;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class LichSuDatPhong extends DatPhong{
    private String maLichSu;
    public LichSuDatPhong(){}
    public LichSuDatPhong(String maLichSu){
        this.maLichSu = maLichSu;
    }
    public void nhapDuLieuLichSu(){
        super.nhapDuLieuDatPhong();
    }
    public String getmaLichSu(){
        String getma;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\LichSu.txt"))){
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                maLichSu = parts[0];
            }
            int number = Integer.parseInt(maLichSu.substring(1));
            number++;
            String t = String.format("%03d", number);
            getma = maLichSu.charAt(0) + t;
            return getma;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void themLichSuDatPhong(String maLichSu, String maKhachHang, String maPhong, String ngayThue, String ngayTra){
        try {
        FileWriter WF = new FileWriter("C:\\Users\\danhc\\Documents\\HK2\\OOP\\QuanLyKhachSan\\DuLieu\\LichSu.txt", true);
            WF.write(getmaLichSu() + "," + maKhachHang + "," + maPhong + "," + ngayThue + "," + ngayTra + ",unpaid\n");
            WF.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void xemLichSu(){
    }
}
