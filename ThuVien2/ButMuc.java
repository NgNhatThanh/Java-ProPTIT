import java.util.List;

public class ButMuc extends But{
    private String loaiMuc, doMin;
    public void setLoaiMuc(){
        System.out.print("Nhập loại mực: ");
        loaiMuc = cin.nextLine();
    }
    public String getLoaiMuc(){ return "Loại mực: " + loaiMuc; }

    public void setDoMin(){
        System.out.print("Nhập độ mịn: ");
        doMin = cin.nextLine();
    }
    public String getDoMin(){ return "Độ mịn: " + doMin; }

    public void Add(){
        super.Add();
        setLoaiMuc();
        setDoMin();
    }
    public boolean cmp(String s){
        return super.cmp(s) || comp(loaiMuc, s) || comp(doMin, s);
    }
    public void showInfo(){
        showMainInfo();
        System.out.println(getMauSac());
        System.out.println(getChatLieu());
        System.out.println(getLoaiMuc());
        System.out.println(getDoMin());
    }

    public void collectData(List<String> l){
        super.collectData(l);
        l.add(getMauSac());
        l.add(getChatLieu());
        l.add(getLoaiMuc());
        l.add(getDoMin());
    }
}
