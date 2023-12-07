package view;

import model.Information;
import service.LoginService;
import utils.Config;
import utils.DateUtils;
import utils.FileUtils;
import utils.InputUtils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoginView {
    private LoginService loginService;
    public LoginView(){
        loginService = new LoginService();
    }
    public void MainView() {
        do {
            System.out.println("-----------------------------------------------------");
            System.out.println("|                                                   |");
            System.out.printf("%-20s %s %20s\n", "|", "App Banking", "|");
            System.out.println("|                                                   |");
            System.out.println("-----------------------------------------------------");
            System.out.printf("%-20s %-11s %20s\n", "|", "1. Login", "|");
            System.out.printf("%-20s %-11s %20s\n", "|", "2. Sign in", "|");
            System.out.println("-----------------------------------------------------");

            int choice = InputUtils.getNumber("Mời nhập lựa chọn: ");
            switch (choice){
                case 1:
                    logIn();
                    break;
                case 2:
                    signIn();
                    break;
            }
        } while (true);
    }

    public void logIn() {
        String username = InputUtils.getString("Nhập tài khoản: ");
        String password = InputUtils.getString("Nhập mật khẩu: ");

        loginService.checkLogin(username, password);
    }

    private void signIn() {
        String fullName = InputUtils.getString("Nhập họ và tên: ");
        String phoneNum = InputUtils.getPhoneNumber("Mời nhập số điện thoại: ");
        LocalDate doB = DateUtils.parse(InputUtils.getString("Nhập ngày sinh nhật: "));

        Information inforUser = new Information(++Information.currentId, fullName, phoneNum, doB);
        List<Information> information = new ArrayList<>();
        information.add(inforUser);
        LoginService.requestToAdmin();

        FileUtils.writeFile(information, Config.PATH_FILE_INFORMATION);
    }
}
