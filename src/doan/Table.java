package doan;

import static doan.Main.mangbill;
import java.util.Scanner;

class Table {

    private String type;
    private int id;
    public int status;
    public static Table[] table = new Table[50];
    static Scanner scanner = new Scanner(System.in);

    public Table(int id, String type, int status) {
        this.type = type;
        this.id = id;
        this.status = status;
    }

    public void display() // In trạng thái một bàn
    {
        System.out.print("Số " + id + " ");
        System.out.print("Loại: " + type + " ");
        if (status == 0) {
            System.out.print("Trạng thái: Trống ");
        } else {
            System.out.print("Trạng thái: Đã có khách ");
        }
    }

    public static void bigdisplay() //In trang thái của tất cả bàn
    {
        for (int i = 0; i < 20; i++) {
            table[i].display();
            System.out.print("                                              ");
            table[i + 30].display();
            System.out.println();
        }
        for (int i = 20; i < 30; i++) {
            table[i].display();
            System.out.println();
        }
    }

    public static void create() //Khởi tạo bàn ăn
    {
        table[0] = new Table(1, " Nhỏ", 0);
        table[1] = new Table(2, " Nhỏ", 0);
        table[2] = new Table(3, " Nhỏ", 0);
        table[3] = new Table(4, " Nhỏ", 0);
        table[4] = new Table(5, " Nhỏ", 0);
        table[5] = new Table(6, " Nhỏ", 0);
        table[6] = new Table(7, " Nhỏ", 0);
        table[7] = new Table(8, " Nhỏ", 0);
        table[8] = new Table(9, " Nhỏ", 0);
        table[9] = new Table(10, "Nhỏ", 0);
        table[10] = new Table(11, "Nhỏ", 0);
        table[11] = new Table(12, "Nhỏ", 0);
        table[12] = new Table(13, "Nhỏ", 0);
        table[13] = new Table(14, "Nhỏ", 0);
        table[14] = new Table(15, "Nhỏ", 0);
        table[15] = new Table(16, "Nhỏ", 0);
        table[16] = new Table(17, "Nhỏ", 0);
        table[17] = new Table(18, "Nhỏ", 0);
        table[18] = new Table(19, "Nhỏ", 0);
        table[19] = new Table(20, "Nhỏ", 0);
        table[20] = new Table(21, "Nhỏ", 0);
        table[21] = new Table(22, "Nhỏ", 0);
        table[22] = new Table(23, "Nhỏ", 0);
        table[23] = new Table(24, "Nhỏ", 0);
        table[24] = new Table(25, "Nhỏ", 0);
        table[25] = new Table(26, "Nhỏ", 0);
        table[26] = new Table(27, "Nhỏ", 0);
        table[27] = new Table(28, "Nhỏ", 0);
        table[28] = new Table(29, "Nhỏ", 0);
        table[29] = new Table(30, "Nhỏ", 0);
        table[30] = new Table(31, "Lớn", 0);
        table[31] = new Table(32, "Lớn", 0);
        table[32] = new Table(33, "Lớn", 0);
        table[33] = new Table(34, "Lớn", 0);
        table[34] = new Table(35, "Lớn", 0);
        table[35] = new Table(36, "Lớn", 0);
        table[36] = new Table(37, "Lớn", 0);
        table[37] = new Table(38, "Lớn", 0);
        table[38] = new Table(39, "Lớn", 0);
        table[39] = new Table(40, "Lớn", 0);
        table[40] = new Table(41, "Lớn", 0);
        table[41] = new Table(42, "Lớn", 0);
        table[42] = new Table(43, "Lớn", 0);
        table[43] = new Table(44, "Lớn", 0);
        table[44] = new Table(45, "Lớn", 0);
        table[45] = new Table(46, "Lớn", 0);
        table[46] = new Table(47, "Lớn", 0);
        table[47] = new Table(48, "Lớn", 0);
        table[48] = new Table(49, "Lớn", 0);
        table[49] = new Table(50, "Lớn", 0);
    }

    public static int chonban() {
        System.out.print("Chọn bàn từ 1 đến 50: ");
        int m = scanner.nextInt();
        if (m <= 0 || m > 50) {
            System.out.println("Không tồn tại bàn");
        }
        return m;
    }

    public static int goiban(int n) {
        if (table[n - 1].status == 0) {
            table[n - 1].status = 1;
        } //Ghi nhận đã chọn bàn
        else {
            System.out.println("Bàn đã có người. Mời chọn lại");
            n = scanner.nextInt();
            goiban(n);
        }
        return n;
    }

    public static void thanhtoanhoadon() {
        int tablenum;
        System.out.print("Nhập hóa đơn muốn thanh toán: ");
        int n = scanner.nextInt();
        if (n > 0) {
            if (mangbill[n - 1][0] != 0) //Kiểm tra xem có tồn tại hóa đơn hay không
            {
                tablenum = mangbill[n - 1][1];
                if (Table.table[tablenum - 1].status != 0) //Kiểm tra bàn có khách không
                {
                    Table.table[tablenum - 1].status = 0;
                    System.out.println("Đã thanh toán hóa đơn ");
                } else {
                    System.out.println("Hóa đơn đã thanh toán");
                }
            } else {
                System.out.println("Không tồn tại hóa đơn");
            }
        }
    }
}
