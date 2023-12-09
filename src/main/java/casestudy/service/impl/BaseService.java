package casestudy.service.impl;

import casestudy.model.Admin;
import casestudy.model.Information;
import casestudy.model.Member;
import casestudy.service.AdminService;
import casestudy.service.LoginService;
import casestudy.service.UserService;
import casestudy.utils.Config;
import casestudy.utils.FileUtils;
import casestudy.view.AdminView;
import casestudy.view.LoginView;
import casestudy.view.UserView;

import java.util.List;

public class BaseService {
    private AdminView adminView;
    private LoginView loginView;
    private UserView userView;
    private AdminService adminService;
    private LoginService loginService;
    private UserService userService;


    public BaseService() {
    }

    public BaseService(AdminView adminView, LoginView loginView, UserView userView,
                       AdminService adminService, LoginService loginService, UserService userService) {
        this.adminView = adminView;
        this.loginView = loginView;
        this.userView = userView;
        this.adminService = adminService;
        this.loginService = loginService;
        this.userService = userService;
    }

    public void callAdminView(){
        adminView = new AdminView(adminService);
        adminView.chooseAdminActive();
    }

    public void callLogInView(){
        loginView = new LoginView(loginService);
        loginView.logIn();
    }

    public void callUserView(Member member){
        userView = new UserView(userService);
        userView.chooseUserActive(member);
    }

    public List<Information> getAllInfor() {
        return FileUtils.readFile(Config.PATH_FILE_INFORMATION, Information.class);
    }
    public List<Member> getAllMember() {
        return FileUtils.readFile(Config.PATH_FILE_MEMBER, Member.class);
    }
    public List<Admin> getAllAdmin() {
        return FileUtils.readFile(Config.PATH_FILE_ADMIN, Admin.class);
    }


    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    public AdminView getAdminView() {
        return adminView;
    }

    public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }
}
