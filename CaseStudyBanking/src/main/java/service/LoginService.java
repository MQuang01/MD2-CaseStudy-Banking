package service;

import model.Account;
import model.Admin;
import utils.Config;
import utils.FileUtils;
import view.AdminView;
import view.LoginView;

import java.util.List;

public class LoginService {
    private AdminService adminService;

    public static void requestToAdmin() {
        Admin.setRequest(++Admin.request);
    }

    public List<Account> getAllAccount(){
        return FileUtils.readFile(Config.PATH_FILE_ACCOUNT, Account.class);
    }

    public void checkLogin(String username, String psw) {
        if(username.contains("admin")){
            List<Admin> adminList = adminService.getAllAdmin();
            for (Admin ad : adminList){
                if(ad.getUsername().equals(username) && ad.getPassword().equals(psw)){
                    System.out.println("Đăng nhập thành công");
                    System.out.println("Xin chào" + ad.getFullName());
                    adminService.getAll();  // Xử lí
                }else {
                    System.out.println("Sai thông tin đăng nhập");
                    return ;
                }
            }
        }else {
            List<Account> accountList = getAllAccount();
            for (Account acc : accountList){
                if(acc.getUsername().equals(username) && acc.getPassword().equals(psw)){
                    System.out.println("Đăng nhập thành công");
                    System.out.println("Xin chào" + acc.getFullName());
                    adminService.getAll();  // Xử lí
                }
            }
        }
    }
}
