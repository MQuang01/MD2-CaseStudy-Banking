import model.Admin;
import view.AdminView;
import view.LoginView;
import view.UserView;

public class AppBanking {
    private LoginView loginView;
    private AdminView adminView;
    private UserView userView;

    public AppBanking(){
        loginView = new LoginView();
        adminView = new AdminView();
        userView = new UserView();
    }

    public static void main(String[] args) {
        AppBanking appBanking = new AppBanking();
        appBanking.run();
    }

    private void run() {
        loginView.MainView();
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
