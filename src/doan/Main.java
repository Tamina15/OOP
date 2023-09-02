package doan;

import static doan.FinalBill.generator;
import java.util.Scanner;

public class Main {

    private static int masohoadon = 0;
    public static int[][] mangbill = new int[255][9];
    public static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        int tablenum;
        tablenum = Table.chonban();
        if (tablenum <= 0 || tablenum > 50); else {
            tablenum = Table.goiban(tablenum);
            masohoadon++;
            mangbill[masohoadon - 1][0] = masohoadon;
            System.out.println("Mã số hóa đơn " + masohoadon);
            mangbill[masohoadon - 1][6] = generator.nextInt(19) + 1;
            mangbill[masohoadon - 1][7] = generator.nextInt(19) + 1;
            mangbill[masohoadon - 1][1] = tablenum;
            System.out.println("Chọn món ăn");
            bowl.input(masohoadon);
            int inner = -1;
            while (inner != 0 && inner != 4) {
                System.out.println("Nhập lựa chọn");
                System.out.println("1.Chọn món thêm");
                System.out.println("2.In hóa dơn bàn");
                System.out.println("3.Tình trạng bàn");
                System.out.println("4.Thoát");
                System.out.println("0.Trả tiền và về");
                inner = scanner.nextInt();
                switch (inner) {
                    case 1:
                        bowl.more(masohoadon);
                        break;
                    case 2:
                        FinalBill.outputbill(masohoadon);
                        break;
                    case 3:
                        Table.bigdisplay();
                        break;
                    case 4:
                        break;
                    case 0:
                        Table.table[tablenum - 1].status = 0;
                        break;
                }
            }
        }
    }

    public static void goithem() {
        int tablenum;
        int them;
        System.out.println("Nhập mã số hóa đơn ");
        them = scanner.nextInt();
        if (them > 0) {
            if (mangbill[them - 1][0] != 0) {
                tablenum = mangbill[them - 1][1];
                if (Table.table[tablenum - 1].status != 0) {
                    System.out.println("Chọn món ăn");
                    bowl.input(them);
                    int inner = -1;
                    while (inner != 0 && inner != 4) {
                        System.out.println("Nhập lựa chọn");
                        System.out.println("1.Chọn món thêm");
                        System.out.println("2.In hóa dơn bàn");
                        System.out.println("3.Tình trạng bàn");
                        System.out.println("4.Thoát");
                        System.out.println("0.Trả tiền và về");
                        inner = scanner.nextInt();
                        switch (inner) {
                            case 1:
                                bowl.more(them);
                                break;
                            case 2:
                                FinalBill.outputbill(them);
                                break;
                            case 3:
                                Table.bigdisplay();
                                break;
                            case 4:
                                break;
                            case 0:
                                Table.table[tablenum - 1].status = 0;
                                break;
                        }
                    }
                } else {
                    System.out.println("Hóa đơn đã thanh toán");
                }
            } else {
                System.out.println("Không tồn tại hóa đơn");
            }
        }
    }

    public static void main(String[] args) {
        Table.create(); //Tạo mảng bàn
        bill.initialize();
        int outer = -1;
        while (outer != 0) {
            System.out.println("Nhập lựa chọn");
            System.out.println("1.Dặt bàn");
            System.out.println("2.In hóa dơn trong ngày");
            System.out.println("3.Tình trạng bàn");
            System.out.println("4.Thanh toán hóa đơn bàn");
            System.out.println("5.Gọi thêm");
            System.out.println("0.Kết thúc ngày");
            outer = scanner.nextInt();
            switch (outer) {
                case 1:
                    menu();
                    break;
                case 2:
                    FinalBill.output();
                    break;
                case 3:
                    Table.bigdisplay();
                    break;
                case 4:
                    Table.thanhtoanhoadon();
                    break;
                case 5:
                    goithem();
                    break;
                case 0:
                    break;
            }
        }
    }
}
