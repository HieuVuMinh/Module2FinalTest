public class Main {
    public static void main(String[] args) {
        QuanLyDanhBa quanLyDanhBa = new QuanLyDanhBa();
        Menu menu = new Menu();

        do {
            try {
                menu.menuDanhBa();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }while (true);

    }
}
