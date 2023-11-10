import java.util.ArrayList;
import java.util.Scanner;

class Sach{
    String Ten, TacGia, TheLoai, XuatBan, MaSach;
}

public class ThuVien{
    public ArrayList<Sach> DanhSach = new ArrayList<>();
    Scanner cin = new Scanner(System.in);

    void AdminFunctions(){
        System.out.println("*****************************");
        System.out.println("* Vui lòng chọn chức năng:  *");
        System.out.println("* 1, Thêm sách              *");
        System.out.println("* 2, Xóa sách               *");
        System.out.println("* 3, Sửa sách               *");
        System.out.println("* 4, Tìm sách               *");
        System.out.println("* 5, Xem danh sách sách     *");
        System.out.println("* 6, Đăng xuất              *");
        System.out.println("*****************************");
    }

    void GuestFunctions() {
        System.out.println("*****************************");
        System.out.println("* Vui lòng chọn chức năng:  *");
        System.out.println("* 1, Tìm sách               *");
        System.out.println("* 2, Xem danh sách sách     *");
        System.out.println("* 3, Đăng xuất              *");
        System.out.println("*****************************");
    }

    void Add(){
        Sach tmp = new Sach();
        System.out.println("Nhập thông tin sách muốn thêm:");
        System.out.print("Tên sách: ");
        tmp.Ten = cin.nextLine();
        System.out.print("Tác giả: ");
        tmp.TacGia = cin.nextLine();
        System.out.print("Thể loại: ");
        tmp.TheLoai = cin.nextLine();
        System.out.print("Ngày xuất bản: ");
        tmp.XuatBan = cin.nextLine();
        tmp.MaSach = String.valueOf(tmp.hashCode());
        DanhSach.add(tmp);
        System.out.println("Đã thêm sách.");
    }

    Boolean cmp(String a, String b){
        return a.toLowerCase().contains(b.toLowerCase());
    }

    void Find(String s, int[] cnt){
        for(Sach x : DanhSach){
            if(cmp(x.Ten, s) || cmp(x.TacGia, s) || cmp(x.TheLoai, s) || cmp(x.XuatBan, s) || cmp(x.MaSach, s)){
                ++cnt[0];
                System.out.println(cnt[0] + " - " + x.Ten + " - " + x.TacGia + " - " + x.TheLoai + " - " + x.XuatBan + " - " + x.MaSach);
            }
        }
        if(cnt[0] == 0) System.out.println("Không tìm thấy sách phù hợp.");
    }

    void Delete(){
        System.out.print("Nhập từ khóa sách muốn xóa: ");
        String s = cin.nextLine();
        int[] cnt = {0};
        Find(s, cnt);
        if(cnt[0] > 0){
            System.out.print("Nhập mã sách muốn xóa: ");
            String ma = cin.nextLine();
            for(int i=0; i<DanhSach.size(); ++i){
                if(DanhSach.get(i).MaSach.equals(ma)){
                    System.out.println("Da xoa sach " + DanhSach.get(i).Ten);
                    DanhSach.remove(i);
                    break;
                }
            }
        }
    }

    void Change(){
        System.out.print("Nhập từ khóa sách muốn sửa: ");
        String s = cin.nextLine();
        int[] cnt = {0};
        Find(s, cnt);
        if(cnt[0] > 0){
            System.out.print("Nhập mã sách muốn sửa: ");
            String ma = cin.nextLine();
            for(Sach x : DanhSach) {
                if (x.MaSach.equals(ma)) {
                    int n;
                    do{
                        System.out.println("Thông tin cần sửa:");
                        System.out.println("1, Tên.");
                        System.out.println("2, Tác giả.");
                        System.out.println("3, Thể loại.");
                        System.out.println("4, Xuất bản.");
                        System.out.println("5, Đã sửa xong.");
                        n = cin.nextInt();
                        cin.nextLine();
                        switch (n){
                            case 1:
                                System.out.print("Nhập tên: ");
                                x.Ten = cin.nextLine();
                                break;
                            case 2:
                                System.out.print("Nhập tác giả: ");
                                x.TacGia = cin.nextLine();
                                break;
                            case 3:
                                System.out.print("Nhập thể loại: ");
                                x.TheLoai = cin.nextLine();
                                break;
                            case 4:
                                System.out.print("Nhập ngày xuất bản: ");
                                x.XuatBan = cin.nextLine();
                        }
                    }
                    while(n < 5);
                }
            }
        }
    }

    void ShowList(){
        int stt = 1;
        for(Sach x : DanhSach){
            System.out.println(stt + " - " + x.Ten + " - " + x.TacGia + " - " + x.TheLoai + " - " + x.XuatBan + " - " + x.MaSach);
            ++stt;
        }
    }

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
            int n;
            do{
                AdminFunctions();
                n = cin.nextInt();
                cin.nextLine();
                switch (n){
                    case 1: Add(); break;
                    case 2: Delete(); break;
                    case 3: Change(); break;
                    case 4:
                        System.out.print("Nhập từ khóa của sách: ");
                        String s = cin.nextLine();
                        int[] dem = {0};
                        Find(s, dem);
                        break;
                    case 5: ShowList();
                }
            }
            while(n < 6);
            Log();
        }
        else{
            int n;
            do{
                GuestFunctions();
                n = cin.nextInt();
                cin.nextLine();
                switch (n){
                    case 1:
                        System.out.print("Nhập từ khóa của sách: ");
                        String s = cin.nextLine();
                        int[] dem = {0};
                        Find(s, dem);
                        break;
                    case 2: ShowList();
                }
            }
            while(n < 3);
            Log();
        }
    }
}