package casestudy.view;

import casestudy.model.Member;
import casestudy.service.MemberService;
import casestudy.service.impl.MemberServiceImpl;
import casestudy.utils.InputUtils;

public class MemberView {
    private MemberService memberService;

    public MemberView(MemberService memberService) {
        this.memberService = memberService;
    }

    public void chooseUserActive(Member member){
        do {
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("%-20s %-30s %20s\n", "|", "1. Kiểm tra số dư tài khoản", "|");
            System.out.printf("%-20s %-30s %20s\n", "|", "2. Nạp tiền", "|");
            System.out.printf("%-20s %-30s %20s\n", "|", "3. Chuyển tiền", "|");
            System.out.printf("%-20s %-30s %20s\n", "|", "4. Rút tiền", "|");
            System.out.printf("%-20s %-30s %20s\n", "|", "5. Đăng ký sổ tiết kiệm", "|");
            System.out.printf("%-20s %-30s %20s\n", "|", "6. Đăng xuất", "|");
            System.out.println("------------------------------------------------------------------------");

            int choice = InputUtils.getNumberMinMax("Mời nhập: ", 0 , 6);

            switch (choice){
                case 0:
                    System.exit(-1);
                case 1:
                    showBalance(member);
                    break;
                case 2:
                    depositToCard(member);
                    break;
                case 3:
                    transferMoney(member);
                    break;
                case 4:
                    withdrawnFromCard(member);
                    break;
                case 5:
                    registerBankPassBook(member);
                    break;
                case 6:
                    logOut();
                    break;
            }
        }while (true);
    }

    private void logOut() {
        memberService = new MemberServiceImpl();
        memberService.logOut();
    }

    private void registerBankPassBook(Member member) {
        memberService = new MemberServiceImpl();

        long money = Long.parseLong(InputUtils.getString("Nhập số tiền bạn muốn gửi: "));
        System.out.printf("Với %s này.\nBạn sẽ nhận được %s đồng sau 6 tháng.\n", money, Double.parseDouble(String.valueOf(Math.round((money * Math.pow(1 + 0.044 / 1, 1 * 6)) * 100 / 100))));
        System.out.printf("Với %s này.\nBạn sẽ nhận được %s đồng sau 12 tháng.\n", money, Double.parseDouble(String.valueOf(Math.round((money * Math.pow(1 + 0.042 / 1, 1 * 12)) * 100 / 100))));
        System.out.printf("Với %s này.\nBạn sẽ nhận được %s đồng sau 24 tháng.\n", money, Double.parseDouble(String.valueOf(Math.round((money * Math.pow(1 + 0.041 / 1, 1 * 24)) * 100 / 100))));

        System.out.println("Chọn hạn mức với lãi suất");
        System.out.println("1. 6 Tháng với 4,40% lãi suất");
        System.out.println("2. 12 Tháng với 4,20% lãi suất");
        System.out.println("3. 24 Tháng với 4,10% lãi suất");
        System.out.println("0. Quay lại");

        int choice = InputUtils.getNumberMinMax("Mời nhập: ", 0, 3);
        switch (choice){
//            userService.openPassBook(member);
        }

    }

    private void withdrawnFromCard(Member member) {
        memberService = new MemberServiceImpl();
        memberService.getMoney(member);
        showBalance(member);
    }

    private void transferMoney(Member member) {
        memberService = new MemberServiceImpl();
        memberService.transferTo(member);
    }

    private void depositToCard(Member member) {
        memberService = new MemberServiceImpl();
        memberService.addMoney(member);
        showBalance(member);
    }
    private void showBalance(Member member) {
        memberService = new MemberServiceImpl();
        memberService.getInforMember(member);
    }
}
