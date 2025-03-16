package funtion;

public abstract class ThongKebase implements IThongKe{
    protected double doanhThu;
    protected int soPhongSuDung;
    protected int TongTienDV;
    public ThongKebase(){};
    public ThongKebase(double doanhThu, int soPhongSuDung){
        this.doanhThu = doanhThu;
        this.soPhongSuDung = soPhongSuDung;
    }
    public abstract void doanhThuTB();
    public void xuatThongKe(){
        System.out.print("So phong da thanh toan: " + soPhongSuDung + "\n");
        System.out.println("Tong doanh thu: " + String.format("%,.0f", doanhThu));
    }
}
