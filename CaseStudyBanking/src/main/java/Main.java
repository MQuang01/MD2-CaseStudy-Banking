import service.AdminService;
import service.LoginService;
import service.UserService;
import service.impl.AdminServiceImpl;
import service.impl.LoginServiceImpl;
import service.impl.UserServiceImpl;
import view.AdminView;
import view.LoginView;
import view.UserView;

public class Main {
    public static void main(String[] args) {
        AdminService adminService= new AdminServiceImpl();
        UserService userService= new UserServiceImpl();
        LoginService loginService= new LoginServiceImpl(adminService);

        LoginView loginView = new LoginView(loginService);
        AdminView adminView = new AdminView(adminService);
        UserView userView= new UserView();

        AppBanking appBanking = new AppBanking(loginView,adminView,userView);
        appBanking.run();
    }
}
