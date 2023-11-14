import java.util.Scanner;
public class Guess {
    Scanner cin = new Scanner(System.in);
    void ShowFunctions() {
        int n;
        System.out.println("*****************************");
        System.out.println("* Vui lòng chọn chức năng:  *");
        System.out.println("* 1, Tìm sách               *");
        System.out.println("* 2, Xem danh sách sách     *");
        System.out.println("* 3, Đăng xuất              *");
        System.out.println("*****************************");
        n = cin.nextInt();
        cin.nextLine();
        switch (n){
            case 1:
                Find(); ShowFunctions();
                break;
            case 2:
                ShowList();
                break;
        }
    }
    Boolean cmp(String a, String b){
        return a.toLowerCase().contains(b.toLowerCase());
    }
    protected int Find(){
        int cnt = 0;
        System.out.print("Nhập từ khóa sách: ");
        String s = cin.nextLine();
        int idx = 0;
        for(Sach x : ThuVien.DanhSach){
            if(cmp(x.getTen(), s) || cmp(x.getTacGia(), s) || cmp(x.getTheLoai(), s) || cmp(x.getXuatBan(), s)){
                ++cnt;
                System.out.println((idx+1) + " - " + x.getTen() + " - " + x.getTacGia() + " - " + x.getTheLoai() + " - " + x.getXuatBan());
            }
            ++idx;
        }
        if(cnt == 0) System.out.println("Không tìm thấy sách phù hợp.");
        return cnt;
    }
    protected void ShowList(){
        int stt = 1;
        for(Sach x : ThuVien.DanhSach){
            System.out.println(stt + " - " + x.getTen() + " - " + x.getTacGia() + " - " + x.getTheLoai() + " - " + x.getXuatBan());
            ++stt;
        }
        ShowFunctions();
    }
}
