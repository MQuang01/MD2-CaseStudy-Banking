package casestudy.view;

public class UserView {
    public void chooseUserActive(){
        do {
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("%-20s %-30s %20s\n", "|", "1. Nạp tiền", "|");
            System.out.printf("%-20s %-30s %20s\n", "|", "2. Chuyển tiền", "|");
            System.out.printf("%-20s %-30s %20s\n", "|", "3. Rút tiền", "|");
            System.out.printf("%-20s %-30s %20s\n", "|", "4. Đăng ký sổ tiết kiệm", "|");
            System.out.println("------------------------------------------------------------------------");
        }while (true);
    }
}
