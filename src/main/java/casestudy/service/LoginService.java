package casestudy.service;

import casestudy.model.Account;
import casestudy.model.Admin;
import casestudy.model.Information;

import java.util.List;

public interface LoginService {

     void initInfor();
     void setCurrentIdInfor();
     List<Information> getAllInfor();

     void initAdmin();
     void setCurrentIdAdmin();
     List<Admin> getAllAdmin();

     void initAccount();
     void setCurrentIdAccount();
     List<Account> getAllAccount();


     void checkLogin(String username, String psw);
}
