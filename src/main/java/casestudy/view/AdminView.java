package casestudy.view;


import casestudy.service.AdminService;

public class AdminView {
    private final AdminService adminService;
    public AdminView(AdminService adminService) {
        this.adminService = adminService;
    }


    public void chooseAdminActive(){
        do {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.printf("%-20s %-35s %20s\n", "|", "1. Hiển thị tất cả yêu cầu", "|");
            System.out.printf("%-20s %-35s %20s\n", "|", "2. Hiển thị yêu cầu tạo tài khoản", "|");
            System.out.printf("%-20s %-35s %20s\n", "|", "3. Hiện thị yêu cầu giao dịch", "|");
            System.out.println("-----------------------------------------------------------------------------");
        }while (true);
    }
}
