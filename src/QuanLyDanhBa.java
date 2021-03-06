import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuanLyDanhBa {
    public static final String sdtDaTonTai = "Số điện thoại hiện đang tồn tại, vui lòng nhập số điện thoại mới!";
    public static final String emailDaTonTai = "Email hiện đang tồn tại, vui lòng nhập email mới!";
    public static final String notFound = "Không tìm được danh bạ với số điện thoại trên";
    public static final String nhapSoDienThoai = "Nhập số điện thoại: ";
    public static final String xoaDanhBa = "Bạn có muốn xóa danh bạ này không? Nhấn y để đồng ý";
    List<DanhBa> danhBaList = new ArrayList<>();
    Menu menu = new Menu();
    Scanner sc = new Scanner(System.in);
    private String soDienThoai;
    private int nhom;
    private String hoTen;
    private String gioiTinh;
    private String diaChi;
    private String ngaySinh;
    private String email;

    public QuanLyDanhBa() {
        danhBaList.add(new DanhBa("0982339722", 1, "Hieu", "nam",
                "HN", "16/10/1997", "vuhieu638282@gmail.com"));
        danhBaList.add(new DanhBa("0982339211", 2, "Ly", "nữ",
                "HN", "11/3/1997", "lydass@gmail.com"));
    }

    // 1. Hien thi
    public void hienThi() throws Exception {
        System.out.println("1. File Txt");
        System.out.println("2. File CSV");
        int selection = sc.nextInt();
        switch (selection){
            case 1 -> docDanhBaTuFileNhiPhan("FileDanhBa.txt");
            case 2 -> System.out.println(docTuFileCSV());
            default -> menu.menuDanhBa();
        }
//        for (DanhBa danhBa : danhBaList) {
//            System.out.println(danhBa);
//        }
    }

    // 2. Them danh ba
    public void themDanhBa() {
        DanhBa danhBa = nhapThongTinDanhBa();
        danhBaList.add(danhBa);
        ghiDanhBaRaFileNhiPhan("FileDanhBa.txt");
        ghiRaFileCSV();
    }

    private DanhBa nhapThongTinDanhBa() {
        System.out.println("Nhập số điện thoại mới: ");
        soDienThoai = regexDienThoai();
        for (DanhBa danhBa: danhBaList) {
            if (danhBa.getSoDienThoai().equals(soDienThoai)){
                System.err.println(sdtDaTonTai);
                nhapThongTinDanhBa();
            } else {
                break;
            }
        }
        System.out.println("Nhập nhóm: ");
        nhom = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập họ tên: ");
        hoTen = sc.nextLine();
        System.out.println("Nhập giới tính: ");
        gioiTinh = sc.nextLine();
        System.out.println("Nhập địa chỉ: ");
        diaChi = sc.nextLine();
        System.out.println("Nhập ngày sinh: ");
        ngaySinh = sc.nextLine();
        System.out.println("Nhập email: ");
        email = regexEmail();
        DanhBa danhBa = new DanhBa(soDienThoai, nhom, hoTen, gioiTinh, diaChi, ngaySinh, email);
        return danhBa;
    }

    public String regexEmail() {
        String email = sc.nextLine();
        if (email.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$")) {
            return email;
        } else {
            System.err.println("Nhập không đúng Email!");
            return regexEmail();
        }
    }

    public String regexDienThoai() {
        String soDienThoai = sc.nextLine();
        if (soDienThoai.matches("^[0-9]{10,11}$")) {
            return soDienThoai;
        } else {
            System.err.println("Nhập không đúng số điện thoại!");
            return regexDienThoai();
        }
    }

//    private void isFinds(String string, String thongbao) {
//        while (true) {
//            boolean isFind = false;
//            for (DanhBa danhBa : danhBaList) {
//                if (danhBa.getSoDienThoai().equals(string)) {
//                    isFind = true;
//                }
//            }
//            if (!isFind)
//                break;
//            else {
//                System.err.println(thongbao);
//            }
//        }
//    }

    // 3. Sửa thông tin danh bạ
    public void suaThongTinDanhBa() {
        System.out.println("Nhập số điện thoại muốn tìm kiếm: ");
        String soDienThoai = sc.nextLine();
        DanhBa danhBa = timKiemDanhBaTheoSDT(soDienThoai);
        if (danhBa == null) {
            System.out.println(notFound);
        } else {
            nhapThongTinDanhBa();
            danhBa.setSoDienThoai(soDienThoai);
            danhBa.setNhom(nhom);
            danhBa.setHoTen(hoTen);
            danhBa.setGioiTinh(gioiTinh);
            danhBa.setDiaChi(diaChi);
            danhBa.setNgaySinh(ngaySinh);
            danhBa.setEmail(email);
        }
        ghiDanhBaRaFileNhiPhan("FileDanhBa.txt");
    }

    // 4. Xóa danh bạ
    public void xoaDanhBa() {
        System.out.println(nhapSoDienThoai);
        String soDienThoai = sc.nextLine();
        DanhBa danhBa = timKiemDanhBaTheoSDT(soDienThoai);
        if (danhBa == null) {
            System.out.println(notFound);
        } else {
            System.out.println(xoaDanhBa);
            String yes = sc.nextLine();
            if (yes.equals("y")) {
                danhBaList.remove(danhBa);
                ghiDanhBaRaFileNhiPhan("FileDanhBa.txt");
            } else {
                try {
                    menu.menuDanhBa();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 5. Tìm kiếm danh bạ
    public void timKiem() {
        System.out.println(nhapSoDienThoai);
        String soDienThoai = sc.nextLine();
        DanhBa danhBa = timKiemDanhBaTheoSDT(soDienThoai);
        if (danhBa == null) {
            System.out.println(notFound);
        } else {
            System.out.println("Đây là danh bạn có số điện thoại bạn tìm kiếm!\n" + danhBa);
        }
    }

    private DanhBa timKiemDanhBaTheoSDT(String soDienThoai) {
        int count = -1;
        for (int i = 0; i < danhBaList.size(); i++) {
            DanhBa danhBa = danhBaList.get(i);
            if (danhBa.getSoDienThoai().equals(soDienThoai)) {
                count = i;
                break;
            }
        }
        if (count == -1) {
            return null;
        } else {
            return danhBaList.get(count);
        }
    }

    // 6. Ghi danh bạ ra file CSV
    public void ghiRaFileCSV(){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("contacts.csv"));
            String[] str;
            for (DanhBa danhBa : danhBaList) {
                str = danhBa.ToString().split(",");
                for (String s : str) {
                    bufferedWriter.write(s + ",");
                }
                bufferedWriter.newLine();
            }
            System.out.println("File CSV đã được cập nhật");
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 7. Đọc danh bạ từ file CSV
    public String docTuFileCSV() throws Exception {
        FileReader fileReader = new FileReader(new File("contacts.csv"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String hienThi = "";
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            hienThi = hienThi.concat(line);
            hienThi = hienThi.concat("\n");
        }
        return hienThi;
    }

    // 8. Viết danh bạ ra file Txt
    public void ghiDanhBaRaFileNhiPhan(String nameFile) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nameFile));
            oos.writeObject(danhBaList);
            System.out.println("FileDanhBa.txt đã được cập nhật!\n");
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 9. Đọc danh bạ từ file Txt
    public void docDanhBaTuFileNhiPhan(String nameFile) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nameFile));
            danhBaList = (List<DanhBa>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (DanhBa danhBa : danhBaList) {
            System.out.println(danhBa);
        }
    }

    // 10. Thoát
    public void thoatDanhba() {
        System.exit(0);
    }
}
