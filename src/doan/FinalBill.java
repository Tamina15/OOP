package doan;

import java.util.Random;
import java.util.Scanner;

public class FinalBill extends bill {

    private static Scanner scanner = new Scanner(System.in);
    public static Random generator = new Random();
    private static java.util.Date date = new java.util.Date();

    public static void outputbill(int mshd) // xuất hóa đơn
    {
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("Mã số hóa đơn " + mshd);
        System.out.println("Bàn số: " + Main.mangbill[mshd - 1][1]);
        outputbowl(mshd);
        outputextra(mshd);
        sumbill(mshd);
        System.out.println("Thới gian xuất hóa đon: " + date);
        System.out.println("Mã số nhân viên chạy bàn: " + Main.mangbill[mshd - 1][6]);
        System.out.println("Mã số nhân viên tính bill: " + Main.mangbill[mshd - 1][7]);
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public static void output() {
        for (int i = 1; i < 50; i++) {
            if (Main.mangbill[i - 1][0] != 0) {
                outputbill(i);
            }
        }
    }
}
