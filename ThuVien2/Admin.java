public class Admin extends Guess{
     void ShowFunctions(){
         int n;
         System.out.println("-------------------------------");
         System.out.println("| Vui lòng chọn chức năng:    |");
         System.out.println("| 1, Thêm sản phẩm            |");
         System.out.println("| 2, Xóa sản phẩm             |");
         System.out.println("| 3, Sửa sản phẩm             |");
         System.out.println("| 4, Tìm sản phẩm             |");
         System.out.println("| 5, Xem tất cả sản phẩm      |");
         System.out.println("| 6, Đăng xuất                |");
         System.out.println("-------------------------------");
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
                 ShowAll(ThuVien.DanhSach);
                 ShowFunctions();
                 break;
             case 6:
                 return;
             default:
                 System.out.println("Không hợp lệ.");
                 ShowFunctions();
         }
    }

    private void Add(){
        SanPham tmp = new SanPham();
        System.out.println("Chọn loại sản phẩm muốn thêm:");
        System.out.println("1, Sách.");
        System.out.println("2, Vở ghi.");
        System.out.println("3, Bút chì.");
        System.out.println("4, Bút mực.");
        int n = cin.nextInt();
        cin.nextLine();
        switch (n){
            case 1:
                tmp = new Sach();
                tmp.Add();
                break;
            case 2:
                tmp = new VoGhi();
                tmp.Add();
                break;
            case 3:
                tmp = new ButChi();
                tmp.Add();
                break;
            case 4:
                tmp = new ButMuc();
                tmp.Add();
        }
        if(n <= 4){
            ThuVien.DanhSach.add(tmp);
            System.out.println("Đã thêm sản phẩm.");
        }
        else System.out.println("Không hợp lệ.");
        ShowFunctions();
    }

    private void Delete(){
        int res = Find();
        if(res > 0){
            System.out.print("Nhập mã của sản phẩm muốn xóa: ");
            String ma = cin.nextLine();
            int idx = 0;
            for(var x : ThuVien.DanhSach){
                if(x.maSanPham.equals(ma)){
                    ThuVien.DanhSach.remove(idx);
                    System.out.println("Đã xóa sản phầm.");
                    idx = -1;
                    break;
                }
                ++idx;
            }
            if(idx == 0) System.out.println("Mã không tồn tại.");
        }
        ShowFunctions();
    }

    private void Change(){
        int res = Find();
        if(res > 0){
            System.out.print("Nhập mã của sản phẩm muốn sửa: ");
            String ma = cin.nextLine();
            int idx = 0;
            for(var x : ThuVien.DanhSach){
                if(x.maSanPham.equals(ma)) {
                    x.Add();
                    idx = 1;
                    break;
                }
            }
            if(idx == 0) System.out.println("Mã không tồn tại.");
        }
        ShowFunctions();
    }
}
