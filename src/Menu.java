import java.util.Scanner;

public class Menu {


    Scanner sc = new Scanner(System.in);
    public void menuDanhBa(){
        QuanLyDanhBa quanLyDanhBa = new QuanLyDanhBa();
        menu();
        int luaChon = sc.nextInt();
        switch (luaChon){
            case 1 -> quanLyDanhBa.hienThi();
            case 2 -> quanLyDanhBa.themDanhBa();
            case 3 -> quanLyDanhBa.suaThongTinDanhBa();
            case 4 -> quanLyDanhBa.xoaDanhBa();
            case 5 -> quanLyDanhBa.timKiem();
            case 6 -> quanLyDanhBa.ghiDanhBaRaFileNhiPhan("FileDanhBa.txt");
            case 7 -> quanLyDanhBa.docDanhBaTuFileNhiPhan("FileDanhBa.txt");
            case 8 -> quanLyDanhBa.quayLai();
            case 9 -> quanLyDanhBa.thoatDanhba();
        }
    }
    public void menu(){
        System.out.println("---------------------------------------------------");
        System.out.println("|       **          DANH BẠ              **       |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("|  1. Hiển thị danh bạ                            |");
        System.out.println("|  2. Thêm danh bạ                                |");
        System.out.println("|  3. Sửa thông tin danh bạ                       |");
        System.out.println("|  4. Xóa danh bạ                                 |");
        System.out.println("|  5. Tìm kiếm danh bạ                            |");
        System.out.println("|  6. Viết danh bạ ra file                        |");
        System.out.println("|  7. Đọc danh bạ từ file                         |");
        System.out.println("|  8. Quay lại Menu                               |");
        System.out.println("|  9. Thoát                                       |");
        System.out.println("|_________________________________________________/");
    }
}
