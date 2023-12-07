package service;

import model.Account;
import model.Admin;
import utils.Config;
import utils.FileUtils;

import java.util.List;

public interface LoginService {
     List<Account> getAllAccount();

     void checkLogin(String username, String psw);
}
