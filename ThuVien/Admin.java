import java.util.Scanner;
public class Admin extends Guess{
    Scanner cin = new Scanner(System.in);
     void ShowFunctions(){
         int n;
         System.out.println("*****************************");
         System.out.println("* Vui lòng chọn chức năng:  *");
         System.out.println("* 1, Thêm sách              *");
         System.out.println("* 2, Xóa sách               *");
         System.out.println("* 3, Sửa sách               *");
         System.out.println("* 4, Tìm sách               *");
         System.out.println("* 5, Xem danh sách sách     *");
         System.out.println("* 6, Đăng xuất              *");
         System.out.println("*****************************");
         n = cin.nextInt();
         cin.nextLine();
         switch (n){
             case 1:
                 Add();
                 break;
             case 2:
                 Delete();
                 break;
             case 3:
                 Change();
                 break;
             case 4:
                 Find();
                 ShowFunctions();
                 break;
             case 5:
                 ShowList();
                 break;
         }
    }
    private void Add(){
        Sach tmp = new Sach();
        System.out.println("Nhập thông tin sách muốn thêm:");
        tmp.setTen();
        tmp.setTacGia();
        tmp.setTheLoai();
        tmp.setXuatBan();
        ThuVien.DanhSach.add(tmp);
        System.out.println("Đã thêm sách.");
        ShowFunctions();
    }
    private void Delete(){
        int res = Find();
        if(res > 0){
            System.out.print("Nhập số thứ tự của sách muốn xóa: ");
            int n = cin.nextInt();
            cin.nextLine();
            if(n <= ThuVien.DanhSach.size()){
                System.out.println("Đã xóa sách " + ThuVien.DanhSach.get(n-1).getTen());
                ThuVien.DanhSach.remove(n-1);
            }
            else System.out.println("Số nhập không hợp lệ.");
        }
        ShowFunctions();
    }
    private void Change(){
        int res = Find();
        if(res > 0){
            System.out.print("Nhập số thứ tự của sách muốn sửa: ");
            int idx = cin.nextInt();
            cin.nextLine();
            if(idx <= ThuVien.DanhSach.size()){
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
                            ThuVien.DanhSach.get(idx-1).setTen();
                            break;
                        case 2:
                            ThuVien.DanhSach.get(idx-1).setTacGia();
                            break;
                        case 3:
                            ThuVien.DanhSach.get(idx-1).setTheLoai();
                            break;
                        case 4:
                            ThuVien.DanhSach.get(idx-1).setXuatBan();
                    }
                }
                while(n < 5);
            }
            else System.out.println("Số nhập không hợp lệ.");
        }
        ShowFunctions();
    }
}
