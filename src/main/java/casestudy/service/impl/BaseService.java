package casestudy.service.impl;

import casestudy.view.AdminView;
import casestudy.view.LoginView;
import casestudy.view.UserView;

public class BaseService {
    private AdminView adminView;
    private LoginView loginView;
    private UserView userView;

    public BaseService() {
    }
    public BaseService(AdminView adminView, LoginView loginView, UserView userView) {
        this.adminView = adminView;
        this.loginView = loginView;
        this.userView = userView;
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
