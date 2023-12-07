package service;

import model.Admin;
import model.Information;
import utils.Config;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    public List<Information> getAllInfor(){
        return FileUtils.readFile(Config.PATH_FILE_INFORMATION, Information.class);
    }

    public List<Admin> getAllAdmin(){
        return FileUtils.readFile(Config.PATH_FILE_ADMIN, Admin.class);
    }

    public void init(){
        List<Admin> adminList = new ArrayList<>();

        adminList.add(new Admin(++Admin.currentId, "admin", "Minh Quang"));
        adminList.add(new Admin(++Admin.currentId, "admin1", "Quang Minh"));

        FileUtils.writeFile(adminList, Config.PATH_FILE_ADMIN);
    }

    public void setCurrentId(){
        List<Admin> adminList = getAllAdmin();

        adminList.sort((o1, o2) -> Long.compare(o1.getId(), o2.getId()));
        Admin.currentId = adminList.get(adminList.size()-1).getId();
    }
}
