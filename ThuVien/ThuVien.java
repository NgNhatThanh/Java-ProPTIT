import java.util.ArrayList;
import java.util.Scanner;

public class ThuVien{
    public static ArrayList<Sach> DanhSach = new ArrayList<>();
    Scanner cin = new Scanner(System.in);
    void Log(){
        String Username;
        String PassWord;
        int cnt = 0;
        System.out.println("Nhập \"exit\" để thoát chương trình.");
        do{
            if(cnt > 0) System.out.println("Username chưa chính xác!");
            System.out.print("Nhập username: ");
            Username = cin.nextLine();
            if(Username.equals("exit")) return;
            ++cnt;
        }
        while(!Username.equals("admin") && !Username.equals("khach"));
        if(Username.equals("admin")) {
            cnt = 0;
            do {
                if(cnt > 0) System.out.println("Mật khẩu chưa chính xác!");
                System.out.print("Nhập mật khẩu: ");
                PassWord = cin.nextLine();
                ++cnt;
            }
            while (!PassWord.equals("admin"));
            Admin tmp = new Admin();
            tmp.ShowFunctions();
            Log();
        }
        else{
            Guess tmp = new Guess();
            tmp.ShowFunctions();
            Log();
        }
    }
}