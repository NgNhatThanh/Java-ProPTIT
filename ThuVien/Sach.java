import java.util.Scanner;
public class Sach {
    Scanner cin = new Scanner(System.in);
    private String Ten, tacGia, theLoai, xuatBan;
    public void setTen(){
        System.out.print("Nhập tên: ");
        Ten = cin.nextLine();
    }
    public void setTacGia(){
        System.out.print("Nhập tác giả: ");
        tacGia = cin.nextLine();
    }
    public void setTheLoai(){
        System.out.print("Nhập thể loại: ");
        theLoai = cin.nextLine();
    }
    public void setXuatBan(){
        System.out.print("Nhập ngày xuất bản: ");
        xuatBan = cin.nextLine();
    }
    public String getTen(){
        return Ten;
    }
    public String getTacGia(){
        return tacGia;
    }
    public String getTheLoai(){
        return theLoai;
    }
    public String getXuatBan(){
        return xuatBan;
    }
}
