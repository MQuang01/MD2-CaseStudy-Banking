package casestudy.service.impl;

import casestudy.model.Member;
import casestudy.model.Admin;
import casestudy.model.ERank;
import casestudy.model.Information;
import casestudy.service.LoginService;
import casestudy.utils.Config;
import casestudy.utils.DateUtils;
import casestudy.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class LoginServiceImpl extends BaseService implements LoginService {
//    private AdminView adminView;
//
//    public LoginServiceImpl(AdminView adminView){
//        this.adminView = adminView;
//    }

    @Override
    public void initInfor() {
        List<Information> inforList = new ArrayList<>();

        inforList.add(new Information(++Information.currentId, "Minh Quang 1", "0934960651", DateUtils.parse("2000-11-21")));
        inforList.add(new Information(++Information.currentId, "Minh Quang 2", "0771231232", DateUtils.parse("1898-05-11")));

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
    public void initMember() {
        List<Member> members = new ArrayList<>();

        members.add(new Member(++Member.currentId, "Quoc Anh", "0772717214", DateUtils.parse("2000-05-21"),500000, ERank.NORMAL));
        members.add(new Member(++Member.currentId, "Quoc Phu", "0795648524", DateUtils.parse("1995-06-14"),300000, ERank.NORMAL));

        FileUtils.writeFile(members, Config.PATH_FILE_MEMBER);
    }
    public void setCurrentIdMember() {
        List<Member> members = getAllMember();

        members.sort((o1, o2) -> Long.compare(o1.getId(), o2.getId()));
        Member.currentId = members.get(members.size() - 1).getId();
    }






    public static void requestToAdmin() {
        Admin.setRequest(++Admin.request);
    }

    public void checkLogin(String username, String psw) {
        if (username.contains("admin")) {
            List<Admin> adminList = getAllAdmin();
            for (Admin ad : adminList) {
                if (ad.getUsername().equals(username) && ad.getPassword().equals(psw)) {
                    callAdminView();
                }
            }
            callLogInView();
        } else {
            List<Member> memberList = getAllMember();
            for (Member member : memberList) {
                if (member.getUsername().equals(username) && member.getPassword().equals(psw)) {
                    System.out.println("Đăng nhập thành công");
                    System.out.println("Xin chào " + member.getFullName());
                    callUserView(member);
                }
            }
            System.out.println("Sai thông tin đăng nhập");
            callLogInView();
        }
    }


}
