package casestudy.service.impl;

import casestudy.model.Account;
import casestudy.model.Admin;
import casestudy.model.ERank;
import casestudy.model.Information;
import casestudy.service.LoginService;
import casestudy.utils.Config;
import casestudy.utils.DateUtils;
import casestudy.utils.FileUtils;
import casestudy.view.AdminView;

import java.util.ArrayList;
import java.util.List;

public class LoginServiceImpl extends BaseService implements LoginService {

    @Override
    public void initInfor() {
        List<Information> inforList = new ArrayList<>();

        inforList.add(new Information(++Information.currentId, "Minh Quang 1", "0934960651", DateUtils.parse("2000-11-21")));

        FileUtils.writeFile(inforList, Config.PATH_FILE_INFORMATION);
    }
    public void setCurrentIdInfor() {
        List<Information> inforList = getAllInfor();

        inforList.sort((o1, o2) -> Long.compare(o1.getId(), o2.getId()));
        Information.currentId = inforList.get(inforList.size() - 1).getId();
    }
    public void initAdmin() {
        List<Admin> adminList = new ArrayList<>();

        adminList.add(new Admin(++Admin.currentId, "admin", "Minh Quang"));
        adminList.add(new Admin(++Admin.currentId, "admin1", "Quang Minh"));

        FileUtils.writeFile(adminList, Config.PATH_FILE_ADMIN);
    }
    public void setCurrentIdAdmin() {
        List<Admin> adminList = getAllAdmin();

        adminList.sort((o1, o2) -> Long.compare(o1.getId(), o2.getId()));
        Admin.currentId = adminList.get(adminList.size() - 1).getId();
    }
    public void initAccount() {
        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account(++Account.currentId, "Quoc Anh", "0772717214", DateUtils.parse("2000-05-21"), ERank.NORMAL));
        accounts.add(new Account(++Account.currentId, "Quoc Phu", "0795648524", DateUtils.parse("1995-06-14"), ERank.NORMAL));

        FileUtils.writeFile(accounts, Config.PATH_FILE_ACCOUNT);
    }
    public void setCurrentIdAccount() {
        List<Account> accounts = getAllAccount();

        accounts.sort((o1, o2) -> Long.compare(o1.getId(), o2.getId()));
        Account.currentId = accounts.get(accounts.size() - 1).getId();
    }


    public List<Information> getAllInfor() {
        return FileUtils.readFile(Config.PATH_FILE_INFORMATION, Information.class);
    }
    public List<Account> getAllAccount() {
        return FileUtils.readFile(Config.PATH_FILE_ACCOUNT, Account.class);
    }
    public List<Admin> getAllAdmin() {
        return FileUtils.readFile(Config.PATH_FILE_ADMIN, Admin.class);
    }



    public static void requestToAdmin() {
        Admin.setRequest(++Admin.request);
    }

    public void checkLogin(String username, String psw) {
        if (username.contains("admin")) {
            List<Admin> adminList = getAllAdmin();
            for (Admin ad : adminList) {
                if (ad.getUsername().equals(username) && ad.getPassword().equals(psw)) {

                } else {

                }
            }
        } else {
            List<Account> accountList = getAllAccount();
            for (Account acc : accountList) {
                if (acc.getUsername().equals(username) && acc.getPassword().equals(psw)) {
                    System.out.println("Đăng nhập thành công");
                    System.out.println("Xin chào" + acc.getFullName());
                    // UserService làm gì đó
                    return;
                } else {
                    System.out.println("Sai thông tin đăng nhập");
                    return;
                }
            }
        }
    }


}
