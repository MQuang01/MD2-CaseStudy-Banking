package service;

import model.Admin;
import model.Information;
import utils.Config;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public interface AdminService {
     List<Information> getAllInfor();

     List<Admin> getAllAdmin();

     void init();

     void setCurrentId();
}
