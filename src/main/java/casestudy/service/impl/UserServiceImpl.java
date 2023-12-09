package casestudy.service.impl;

import casestudy.model.Member;
import casestudy.service.UserService;
import casestudy.utils.Config;
import casestudy.utils.FileUtils;
import casestudy.utils.InputUtils;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl extends BaseService implements UserService {
    @Override
    public void addMoney(Member member) {
        long money = InputUtils.getNumber("Nhập số tiền muốn nạp: ");

        List<Member> members = getAllMember();
        for (Member m : members){
            if(m.getUsername().equals(member.getUsername())){
                m.setBalance(m.getBalance() + money);
                member.setBalance(member.getBalance() + money);
                System.out.println("Nạp tiền thành công");


                FileUtils.writeFile(members, Config.PATH_FILE_MEMBER);

                return;
            }
        }
        System.err.println("Nạp tiền không thành công");
    }
    @Override
    public void getInforMember(Member member) {
        List<Member> members = getAllMember();
        for (Member m : members){
            if(m.getId() == member.getId()){
                System.out.printf("%20s %20s\n", "Họ và Tên", "Số dư tài khoản");
                System.out.printf("%20s %20s\n", member.getFullName(), member.getBalance());
                return;
            }
        }
    }
    @Override
    public void transferTo(Member member) {
        List<Member> members = getAllMember();
        String numberCard = InputUtils.getString("Chuyển đến số tài khoản: ");
        if (numberCard == member.getUsername()){
            System.err.println("Không thể chuyển tiền vào số tài khoản của bạn");
        }

        for (Member m : members){
            if(m.getUsername().equals(numberCard)){
                long money = InputUtils.getNumber("Nhập số tiền cần chuyển: ");

                if(member.getBalance() < money){
                    System.err.println("Tài khoản không đủ");
                    callUserView(member);
                }else {
                    // trừ tiền tài khoản
                    for (Member m1 : members){
                        if (m1.getUsername().equals(member.getUsername())){
                            m1.setBalance(m1.getBalance() - money);
                        }
                    }
                    member.setBalance(member.getBalance() - money);

                    // nạp tiền tài khoản
                    m.setBalance(m.getBalance() + money);
                    System.out.println("Đã chuyển thành công");

                    FileUtils.writeFile(members, Config.PATH_FILE_MEMBER);
                    return;
                }
            }
        }
        System.err.println("Không tìm thấy số tài khoản người nhận");
    }

    @Override
    public void getMoney(Member member) {
        List<Member> members = getAllMember();
        long money = InputUtils.getNumber("Nhập số tiền cần rút: ");
        for (Member m : members){
            if(m.getBalance() < money){
                System.out.println("Số dư tài khoản không đủ");
                callUserView(member);
            }else {
                m.setBalance(m.getBalance() - money);
                System.out.println("Rút tiền thành công");
            }
        }
        System.err.println("Rút tiền không thành công");
    }

    @Override
    public void logOut() {
        System.out.println("Đăng xuất thành công");
        callLogInView();
    }
}
