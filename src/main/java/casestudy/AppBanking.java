package casestudy;

import casestudy.view.AdminView;
import casestudy.view.LoginView;
import casestudy.view.UserView;

public class AppBanking {
    private LoginView loginView;
    private AdminView adminView;
    private UserView userView;


    public AppBanking(LoginView loginView, AdminView adminView, UserView userView) {
        this.loginView = loginView;
        this.adminView = adminView;
        this.userView = userView;
    }


    public void run() {
        loginView.MainView(this);
    }



    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public AdminView getAdminView() {
        return adminView;
    }

    public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }
}
