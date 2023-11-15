import java.util.List;

public class ButChi extends But{
    private String doCung;
    public void setDoCung(){
        System.out.print("Nhập độ cứng: ");
        doCung = cin.nextLine();
    }
    public String getDoCung(){ return "Độ cứng: " + doCung; }

    public void Add(){
        super.Add();
        setDoCung();
    }
    public boolean cmp(String s){
        return super.cmp(s) || comp(doCung, s);
    }
    public void showInfo(){
        showMainInfo();
        System.out.println(getMauSac());
        System.out.println(getChatLieu());
        System.out.println(getDoCung());
    }

    public void collectData(List<String> l){
        super.collectData(l);
        l.add(getMauSac());
        l.add(getChatLieu());
        l.add(getDoCung());
    }
}
