package casestudy.service;

import casestudy.model.Member;

public interface UserService {
    void addMoney(Member member);

    void getInforMember(Member member);

    void transferTo(Member member);

    void getMoney(Member member);
    void logOut();
}
