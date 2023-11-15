import java.util.Scanner;
import java.util.List;
public class SanPham {
    protected Scanner cin = new Scanner(System.in);
    protected String Ten, Gia, thuongHieu, maSanPham;
    public void setTen(){
        System.out.print("Nhập tên: ");
        Ten = cin.nextLine();
    }
    public void setGia(){
        System.out.print("Nhập giá: ");
        Gia = cin.nextLine();
    }
    public void setThuongHieu(){
        System.out.print("Nhập nhà xuất bản / thương hiệu: ");
        thuongHieu = cin.nextLine();
    }
    protected void Add(){
        setTen();
        setGia();
        setThuongHieu();
        maSanPham = String.valueOf(this.hashCode());
    }
    protected boolean comp(String a, String b){
        return a.toLowerCase().contains(b.toLowerCase());
    }
    protected boolean cmp(String s){
        return comp(Ten, s) || comp(Gia, s) || comp(thuongHieu, s);
    }
    public void showInfo(){}
    public void showMainInfo(){
        System.out.println("Mã sản phẩm: " + maSanPham);
        System.out.println("Tên: " + Ten);
        System.out.println("Giá: " + Gia);
        System.out.println("Thương hiệu: " + thuongHieu);
    }

    protected void collectData(List<String> l){
        l.add(maSanPham);
        l.add(Ten);
        l.add(Gia);
        l.add(thuongHieu);
    }
}
