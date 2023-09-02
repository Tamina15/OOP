package doan;
import static doan.bowl.mangbowl;
import static doan.bowl.mangextra;

public class bill {
    private static int sum;
    public static void initialize() //Khởi tạo giá trị cho mảng mangextra
    {
        for(int i=0;i<50;i++)
        {    
            Main.mangbill[i][0]=0;
            for(int j=1;j<7;j++)
                Main.mangbill[i][j]=0;
        }
    }
    public static void outputbowl(int mshd) //In giá tiền các tô phở đã gọi       
    {
        int sotopho=0;
        for(int j=1;j<50;j++)
        {
            if(mangbowl[mshd-1][j][0]!=0) sotopho++;
        }
        System.out.println("Số tô phở đã gọi: "+sotopho);
        for (int i = 1; i <= sotopho;i++) 
        {      
            switch(mangbowl[mshd-1][i][0])
            {
                case 1:System.out.println("Tô nhỏ: 45000d");break;
                case 2:System.out.println("Tô lớn: 60000d");break;
                case 3:System.out.println("Tô đặc biệt: 75000d");break;
            }
        }
    }
    public static void outputextra(int mshd)    //In tổng tiền các món gọi thêm
    {
        sum=0;
        for(int j=1;j<7;j++)
        {
            int tong=0;
            switch(j)
            {
                case 1:tong=tong+5000*mangextra[mshd-1][j];sum=sum+tong;System.out.println("Quẩy "+tong+"đ");break;
                case 2:tong=tong+5000*mangextra[mshd-1][j];sum=sum+tong;System.out.println("Hột gà: "+tong+"đ");break;
                case 3:tong=tong+10000*mangextra[mshd-1][j];sum=sum+tong;System.out.println("Bánh phở thêm: "+tong+"đ");break;
                case 4:tong=tong+10000*mangextra[mshd-1][j];sum=sum+tong;System.out.println("Tiết: "+tong+"đ");break;
                case 5:tong=tong+15000*mangextra[mshd-1][j];sum=sum+tong;System.out.println("Tiết hột gà: "+tong+"đ");break;
                case 6:tong=tong+25000*mangextra[mshd-1][j];sum=sum+tong;System.out.println("Thịt thêm: "+tong+"đ");break;                            
            }
        }
        System.out.println("Tổng tiền món thêm: "+sum+"đ");
    }
        public static void sumbill(int mshd)    //In tổng tiền các tô phở đã gọi
    {
        int sotopho=0;
        for(int j=1;j<50;j++)
        {
            if(mangbowl[mshd-1][j][0]!=0) sotopho++;    //Dếm số tô đã gọi
        }
        int  tong=0;
        for(int i=1;i<=sotopho;i++) // Tính tổng tiền các tô phở đã gọi
        {      
            switch(mangbowl[mshd-1][i][0])
            {
                case 1: tong =tong+45000;break;
                case 2: tong =tong+60000;break;
                case 3: tong =tong+75000;break;
            }
        }
        tong=tong+sum;
        System.out.println("Tổng số tiền "+tong+ "đ");
    }
}

    

