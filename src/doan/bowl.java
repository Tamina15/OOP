package doan;

import java.util.Scanner;

public class bowl {
    public static int[][] mangextra=new int[50][7];
    public static int[][][] mangbowl=new int[50][50][5]; //[mã số hóa đơn][][]
    private static Scanner scanner =new Scanner(System.in);
    public static void input(int mshd)
    {
        int stp=bowl.sotopho(); //stp= số tô phở
        bowl.goitopho(stp,mshd);
    }
    public static int sotopho() //Nhập số tô phở
    {
        int stp;
        System.out.println("Nhập số tô phở");
        stp= scanner.nextInt();
        if(stp<=0) return 0; 
        else return stp;
    }
    public static void goitopho(int stp,int mshd)   // Gọi loại tô     
    {                                                                                                    
        int loaito;
            for(int i=1;i<=stp;i++)    
            {
                System.out.println("Tô "+i+":");
                System.out.print("Loại tô : 1.Nhỏ, 2.Lớn, 3.Đặc biệt ");
                loaito=scanner.nextInt();
                if(loaito==1||loaito==2||loaito==3) mangbowl[mshd-1][i][0]=loaito;
                else 
                {
                    System.out.println("Nhập sai");
                }
                goiloaithit(loaito,i,mshd);
            }                                                                                                          
    }
     public static void goiloaithit(int loaito,int i,int mshd)  //Gọi loại thịt cho từng tô
    {
        int thit;
        switch(loaito)
        {
            case 1: 
                System.out.print("Nhập tối đa 2 trong 5 loại thịt:");
                System.out.print("1.Tái, 2.Nạm, 3.Gầu, 4.Gân, 5.Bò viên ");
                for(int k=1;k<=2;k++)
                {
                    thit=scanner.nextInt();
                    mangbowl[mshd-1][i][k]=thit;
                }
                break;
        
            case 2: 
                System.out.print("Nhập tối đa 3 trong 5 loại thịt:");
                System.out.print("1.Tái, 2.Nạm, 3.Gầu, 4.Gân, 5.Bò viên ");
                for(int k=1;k<=3;k++)
                {
                    thit=scanner.nextInt();
                    mangbowl[mshd-1][i][k]=thit;
                }
                break;
            case 3: 
                System.out.print("Nhập tối đa 4 trong 5 loại thịt:");
                System.out.print("1.Tái, 2.Nạm, 3.Gầu, 4.Gân, 5.Bò viên ");
                for(int k=1;k<=4;k++)
                {
                    thit=scanner.nextInt();
                    mangbowl[mshd-1][i][k]=thit;
                }
                break;
        }
    }
     
    public static void initializebowl()    //Khởi tạo giá trị cho mảng mangbowl
    {
        for(int i=0;i<50;i++)
        {   mangbowl[i][0][0]=i+1;  //Mã số bàn
            for(int j=1;j<50;j++)
            {
                mangbowl[i][j][0]=0;
                for(int k=1;k<5;k++)
                mangbowl[i][j][k]=0;
            }    
        }
    }
    public static void initializeextra() //Khởi tạo giá trị cho mảng mangextra
    {
        for(int i=0;i<50;i++)
        {    
            mangextra[i][0]=i+1;
            for(int j=1;j<7;j++)
                mangextra[i][j]=0;
        }
    }
    public static void more(int mshd)   //Gọi thêm món
    {
        int ex=7;
        System.out.println("Món gọi thêm: 1.Quẩy, 2.Hột gà, 3.Bánh phở thêm, 4.Tiết, 5.Tiết hột gà, 6.Thịt thêm");
        System.out.println("Nhấn 0 để thoát");
        while(ex!=0)
        {    
            ex=scanner.nextInt();
            if(ex<0||ex>=7) ex=0;
            else mangextra[mshd-1][ex]++;   //Số lượng món tại vị trí j tương ứng cho từng món (Xem giá trị tương ứng cho j tại dòng println())
        }
        
    }
}
