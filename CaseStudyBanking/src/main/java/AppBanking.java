import view.LoginView;

public class AppBanking {
    private LoginView loginView;
    public AppBanking(){
        loginView = new LoginView();
        loginView.MainView();
    }

    public static void main(String[] args) {
        AppBanking appBanking = new AppBanking();

    }
}
