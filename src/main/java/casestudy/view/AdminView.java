package casestudy.view;


import casestudy.service.AdminService;
import casestudy.utils.InputUtils;

public class AdminView {
    private final AdminService adminService;

    public AdminView(AdminService adminService) {
        this.adminService = adminService;
    }

    public void chooseAdminActive(){
        do {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.printf("%-20s %-35s %20s\n", "|", "1. Hiển thị yêu cầu tạo tài khoản", "|");
            System.out.printf("%-20s %-35s %20s\n", "|", "2. Hiển thị tất cả giao dịch", "|");
            System.out.printf("%-20s %-35s %20s\n", "|", "3. Hiển thị tất cả member", "|");
            System.out.println("-----------------------------------------------------------------------------");

            int choice = InputUtils.getNumberMinMax("Mời nhập: ", 0, 3);
            switch (choice){
                case 0:
                    System.exit(-1);
                case 1:
                    showAllRequest();
                    break;
                case 2:
//                    showRequestSignIn();
                    break;
                case 3:
//                    showRequestTransaction();
                    break;
            }
        }while (true);
    }

    private void showAllRequest() {
        adminService.getAllRequest();
    }
}
