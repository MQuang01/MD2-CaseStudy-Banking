package service;

import model.Admin;
import model.Information;
import utils.Config;
import utils.FileUtils;

import java.util.List;

public class AdminService {
    public List<Information> getAll(){
        return FileUtils.readFile(Config.PATH_FILE_INFORMATION, Information.class);
    }

    public List<Admin> getAllAdmin(){
        return FileUtils.readFile(Config.PATH_FILE_ADMIN, Admin.class);
    }
}
