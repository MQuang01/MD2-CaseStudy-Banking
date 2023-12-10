package casestudy.view;


import casestudy.model.Admin;
import casestudy.model.Information;
import casestudy.service.AdminService;
import casestudy.service.impl.AdminServiceImpl;
import casestudy.utils.InputUtils;

import java.util.List;

public class AdminView {
    private AdminService adminService;

    public AdminView(AdminService adminService) {
        this.adminService = adminService;
    }

    public void chooseAdminActive(Admin admin){
        do {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.printf("%-20s %-35s %20s\n", "|", "0. Thoát chương trình ", "|");
            System.out.printf("%-20s %-35s %20s\n", "|", "1. Hiển thị yêu cầu tạo tài khoản", "|");
            System.out.printf("%-20s %-35s %20s\n", "|", "2. Hiển thị tất cả người dùng", "|");
            System.out.printf("%-20s %-35s %20s\n", "|", "3. Thêm người dùng", "|");
            System.out.printf("%-20s %-35s %20s\n", "|", "4. Xóa người dùng", "|");
            System.out.printf("%-20s %-35s %20s\n", "|", "5. Chỉnh sửa người dùng", "|");
            System.out.printf("%-20s %-35s %20s\n", "|", "6. Tìm kiếm người dùng", "|");
            System.out.printf("%-20s %-35s %20s\n", "|", "7. Đăng xuất", "|");
            System.out.println("-----------------------------------------------------------------------------");

            int choice = InputUtils.getNumberMinMax("Mời nhập: ", 0, 7);
            switch (choice){
                case 0:
                    System.exit(-1);
                case 1:
                    showRequest(admin);
                    break;
                case 2:
                    showMember();
                    break;
                case 3:
                    createMember(admin);
                    break;
                case 4:
                    deleteMember(admin);
                    break;
                case 5:
                    editMember(admin);
                    break;
                case 6:
                    findMembber(admin);
                    break;
                case 7:
                    logOut();
                    break;
            }
        }while (true);
    }

    private void findMembber(Admin admin) {
        adminService = new AdminServiceImpl();
        adminService.findBy(admin);
    }

    private void editMember(Admin admin) {
        adminService = new AdminServiceImpl();
        adminService.editInforMember(admin);
    }

    private void deleteMember(Admin admin) {
        adminService = new AdminServiceImpl();
        adminService.deleteMemberBy(admin);
    }

    private void createMember(Admin admin) {
        adminService = new AdminServiceImpl();
        adminService.createNewMemberBy(admin);
        showMember();
    }

    private void logOut() {
        adminService = new AdminServiceImpl();
        adminService.logOut();
    }

    private void showMember() {
        adminService = new AdminServiceImpl();
        adminService.showAllMember();
    }

    private void showRequest(Admin admin) {
        adminService = new AdminServiceImpl();
        adminService.getRequest();

        adminService.hanldeRequest(admin);
    }

}
