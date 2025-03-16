package funtion;

public class PhongDoi extends Phong{
    private double giaPhong = 500000;
    public PhongDoi(){}
    public PhongDoi(double giaPhong){
        this.giaPhong = giaPhong;
    }
    public void hienThiThongTin(){
        System.out.print("Gia phong: " + giaPhong);
    }
    public double tinhTongTien(){
        return giaPhong;
    }
}
