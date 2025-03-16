package funtion;

public class PhongDon extends Phong{
    private double giaPhong = 300000;
    public PhongDon(){}
    public PhongDon(double giaPhong){
        this.giaPhong = giaPhong;
    }
    public void hienThiThongTin(){
        System.out.print("Gia phong: " + giaPhong);
    }
    public double tinhTongTien(){
        return giaPhong;
    }
}
