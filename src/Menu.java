import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    public void menuDanhBa() throws Exception {
        QuanLyDanhBa quanLyDanhBa = new QuanLyDanhBa();
        menu();
        int luaChon = sc.nextInt();
        switch (luaChon){
            case 1 -> quanLyDanhBa.hienThi();
            case 2 -> quanLyDanhBa.themDanhBa();
            case 3 -> quanLyDanhBa.suaThongTinDanhBa();
            case 4 -> quanLyDanhBa.xoaDanhBa();
            case 5 -> quanLyDanhBa.timKiem();
            case 6 -> quanLyDanhBa.ghiRaFileCSV();
            case 7 -> quanLyDanhBa.docTuFileCSV();
            case 8 -> quanLyDanhBa.ghiDanhBaRaFileNhiPhan("FileDanhBa.txt");
            case 9 -> quanLyDanhBa.docDanhBaTuFileNhiPhan("FileDanhBa.txt");
            case 10 -> quanLyDanhBa.thoatDanhba();
        }
    }
    public void menu(){
        System.out.println("---------------------------------------------------");
        System.out.println("|  --------CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ---------  |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("|  1. Xem danh sách                               |");
        System.out.println("|  2. Thêm mới                                    |");
        System.out.println("|  3. Cập Nhật                                    |");
        System.out.println("|  4. Xóa                                         |");
        System.out.println("|  5. Tìm kiếm                                    |");
        System.out.println("|  6. Ghi danh bạ ra file CSV                     |");
        System.out.println("|  7. Đọc danh bạ từ file CSV                     |");
        System.out.println("|  8. Ghi danh bạ ra file Txt                     |");
        System.out.println("|  9. Đọc danh bạ từ file Txt                     |");
        System.out.println("|  10. Thoát                                      |");
        System.out.println("|_________________________________________________/");
    }
}
