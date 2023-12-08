package casestudy;

import casestudy.service.AdminService;
import casestudy.service.LoginService;
import casestudy.service.UserService;
import casestudy.service.impl.AdminServiceImpl;
import casestudy.service.impl.LoginServiceImpl;
import casestudy.service.impl.UserServiceImpl;
import casestudy.view.AdminView;
import casestudy.view.LoginView;
import casestudy.view.UserView;

public class Main {
    public static void main(String[] args) {
        AdminService adminService= new AdminServiceImpl();
        UserService userService= new UserServiceImpl();
        LoginService loginService= new LoginServiceImpl();


        LoginView loginView = new LoginView(loginService);
        AdminView adminView = new AdminView(adminService);
        UserView userView= new UserView();


        AppBanking appBanking = new AppBanking(loginView,adminView,userView);
        appBanking.run();
    }

}
