import java.util.List;

public class VoGhi extends SanPham {
    private String soTrang, loaiVo, mauBia, chatLieu, kichThuoc;
    public void setSoTrang() {
        System.out.print("Nhập số trang: ");
        soTrang = cin.nextLine();
    }
    public String getSoTrang(){ return "Số trang: " + soTrang; }
    public void setLoaiVo() {
        System.out.print("Nhập loại vở: ");
        loaiVo = cin.nextLine();
    }
    public String getLoaiVo(){ return "Loại vở: " + loaiVo; }
    public void setMauBia() {
        System.out.print("Nhập màu bìa: ");
        mauBia = cin.nextLine();
    }
    public String getMauBia(){ return "Màu bìa: " + mauBia; }

    public void setChatLieu() {
        System.out.print("Nhập chất liệu: ");
        chatLieu= cin.nextLine();
    }
    public String getChatLieu(){ return "Chất liệu: " + chatLieu; }

    public void setKichThuoc() {
        System.out.print("Nhập kích thước: ");
        kichThuoc= cin.nextLine();
    }
    public String getKichThuoc(){ return "Kích thước: " + kichThuoc; }

    public void Add(){
        super.Add();
        setSoTrang();
        setLoaiVo();
        setMauBia();
        setChatLieu();
        setKichThuoc();
    }
    public boolean cmp(String s){
        return super.cmp(s) || comp(soTrang, s) || comp(mauBia, s) || comp(loaiVo, s) || comp(chatLieu, s) || comp(kichThuoc, s);
    }
    public void showInfo(){
        showMainInfo();
        System.out.println(getSoTrang());
        System.out.println(getLoaiVo());
        System.out.println(getMauBia());
        System.out.println(getChatLieu());
        System.out.println(getKichThuoc());
    }

    public void collectData(List<String> l){
        super.collectData(l);
        l.add(getSoTrang());
        l.add(getLoaiVo());
        l.add(getMauBia());
        l.add(getChatLieu());
        l.add(getKichThuoc());
    }
}
