import java.util.List;
public class Sach extends SanPham {
    private String tacGia, theLoai, namXuatBan, ngonNgu;
    public void setTacGia(){
        System.out.print("Nhập tác giả: ");
        tacGia = cin.nextLine();
    }
    public String getTacGia(){ return "Tác giả: " + tacGia; }

    public void setTheLoai(){
        System.out.print("Nhập thể loại: ");
        theLoai = cin.nextLine();
    }
    public String getTheLoai(){ return "Thể loại: " + theLoai; }

    public void setNamXuatBan(){
        System.out.print("Nhập năm xuất bản: ");
        namXuatBan = cin.nextLine();
    }
    public String getNamXuatBan(){ return "Năm xuất bản: " + namXuatBan; }

    public void setNgonNgu(){
        System.out.print("Nhập ngôn ngữ: ");
        ngonNgu = cin.nextLine();
    }
    public String getNgonNgu(){ return "Ngôn ngữ: " + ngonNgu; }

    public void Add(){
        super.Add();
        setTacGia();
        setTheLoai();
        setNamXuatBan();
        setNgonNgu();
    }
    public boolean cmp(String s){
        return super.cmp(s) || comp(tacGia, s) || comp(theLoai, s) || comp(namXuatBan, s) || comp(ngonNgu, s);
    }
    public void showInfo(){
        showMainInfo();
        System.out.println(getTheLoai());
        System.out.println(getTacGia());
        System.out.println(getNamXuatBan());
        System.out.println(getNgonNgu());
    }

    public void collectData(List<String> l){
        super.collectData(l);
        l.add(getTheLoai());
        l.add(getTacGia());
        l.add(getNamXuatBan());
        l.add(getNgonNgu());
    }
}
