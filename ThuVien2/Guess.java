import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class Guess {
    Scanner cin = new Scanner(System.in);
    void ShowFunctions() {
        int n;
        System.out.println("-------------------------------");
        System.out.println("| Vui lòng chọn chức năng:    |");
        System.out.println("| 1, Tìm sản phẩm             |");
        System.out.println("| 2, Xem tất cả sản phẩm      |");
        System.out.println("| 3, Đăng xuất                |");
        System.out.println("-------------------------------");
        n = cin.nextInt();
        cin.nextLine();
        switch (n){
            case 1:
                Find(); ShowFunctions();
                break;
            case 2:
                ShowAll(ThuVien.DanhSach);
                ShowFunctions();
                break;
            case 3:
                return;
            default:
                System.out.println("Không hợp lệ.");
                ShowFunctions();
        }
    }

    protected int Find(){
        System.out.print("Nhập từ khóa sản phẩm: ");
        String s = cin.nextLine();
        List<SanPham> l = new ArrayList<>();
        for(var x : ThuVien.DanhSach){
            if(x.cmp(s)) l.add(x);
        }
        if(l.isEmpty()) System.out.println("Không tìm thấy sản phẩm phù hợp.");
        else ShowAll(l);
        return l.size();
    }

    protected void ShowAll(List<SanPham> l){
        if(l.isEmpty()){
            System.out.println("Không có sản phầm nào.");
            return;
        }
        System.out.println("Bạn muốn hiển thị dạng bảng hay danh sách ?");
        System.out.println("1, Bảng.");
        System.out.println("2, Danh sách.");
        int n = cin.nextInt();
        cin.nextLine();
        if(n == 1) ShowTable(l);
        else if(n == 2) ShowList(l);
        else System.out.println("Không hợp lệ.");
    }

    protected void ShowList(List<SanPham> l){
        System.out.println("DANH SÁCH SẢN PHẨM TÌM ĐƯỢC: ");
        System.out.println("-----");
        for(var x : l){
            x.showInfo();
            System.out.println("-----");
        }
    }

    private int tinhLe(int col, int len){
        return -((col*-1) - len) / 2 + 1;
    }

    private void underLine(int len){
        len *= -1; len += 15;
        while(len-->0) System.out.print("-");
        System.out.print("\n");
    }

    protected void ShowTable(List<SanPham> l){
        int col1 = -15, col2 = -30, col3 = -15, col4 = -25, col5 = -30; // độ rộng cột
        int sum = col1 + col2 + col3 + col4 + col5;
        String s1 = "Mã sản phẩm", s2 = "Tên sản phẩm", s3 = "Giá", s4 = "NXB/Thương hiệu", s5 = "Thông tin khác";
        int le1 = tinhLe(col1, s1.length()), le2 = tinhLe(col2, s2.length()), le3 = tinhLe(col3, s3.length()), le4 = tinhLe(col4, s4.length()), le5 = tinhLe(col5, s5.length()); // căn lề 2 bên
        System.out.println("DANH SÁCH SẢN PHẨM TÌM ĐƯỢC:");
        underLine(sum);
        System.out.printf("| %" + le1 + "s %" + (col1 - le1) + "s| %" + le2 + "s %" + (col2 - le2) + "s| %" + le3 + "s %" + (col3 - le3) + "s| %" + le4 + "s %" + (col4 - le4) + "s| %" + le5 + "s %" + (col5 - le5 + 1) + "s|\n", "", s1, "", s2, "", s3, "", s4, "", s5);
        underLine(sum);
        for(var x : l){
            List<String> tmp = new ArrayList<>();
            x.collectData(tmp);
            for(int i=0; i<=tmp.size()-5; ++i){
                System.out.printf("| %" + col1 + "s | %" + col2 + "s | %" + col3 + "s | %" + col4 + "s | %" + col5 + "s|\n", tmp.get(i), tmp.get(i+1), tmp.get(i+2), tmp.get(i+3), tmp.get(i+4));
                for(int j=i; j<i+5; ++j) tmp.set(j, "");
            }
            underLine(sum);
        }
    }
}
