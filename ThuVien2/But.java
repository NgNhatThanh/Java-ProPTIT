public class But extends SanPham{
    protected String mauSac, chatLieu;
    public void setMauSac(){
        System.out.print("Nhập màu sắc: ");
        mauSac = cin.nextLine();
    }
    public String getMauSac(){ return "Màu sắc: " + mauSac; }

    public void setChatLieu(){
        System.out.print("Nhập chất liệu: ");
        chatLieu = cin.nextLine();
    }
    public String getChatLieu(){ return "Chất liệu: " + chatLieu; }

    protected void Add(){
        super.Add();
        setMauSac();
        setChatLieu();
    }
    protected boolean cmp(String s){
        return super.cmp(s) || comp(mauSac, s) || comp(chatLieu, s);
    }
}
