package casestudy.model;

import casestudy.utils.DateUtils;

import java.time.LocalDate;

public class Account implements IParser{
    private long id;
    private String username;
    private String password;
    private String fullName;
    private String phoneNum;
    private LocalDate doB;
    private ERank eRank;
    public static long currentId;

    public Account() {
    }

    public Account(long id, String fullName, String phoneNum, LocalDate doB, ERank eRank) {
        this.id = id;
        this.username = String.valueOf(phoneNum);
        this.password = "123123";
        this.fullName = fullName;
        this.phoneNum = phoneNum;
        this.doB = doB;
        this.eRank = eRank;
    }

    public Account(String fullName, String phoneNum, LocalDate doB, ERank eRank) {
        this.fullName = fullName;
        this.username = String.valueOf(phoneNum);
        this.password = "123123";
        this.phoneNum = phoneNum;
        this.doB = doB;
        this.eRank = eRank;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public LocalDate getDoB() {
        return doB;
    }

    public void setDoB(LocalDate doB) {
        this.doB = doB;
    }

    public ERank geteRank() {
        return eRank;
    }

    public void seteRank(ERank eRank) {
        this.eRank = eRank;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s", id,username,password,phoneNum,fullName,doB,eRank);
    }

    @Override
    public void parse(String line) {
        String [] items = line.split(",");

        //id,username,psw,fullName,doB,ranked
        this.id = Long.parseLong(items[0]);
        this.username = items[1];
        this.password = items[2];
        this.phoneNum = items[3];
        this.fullName = items[4];
        this.doB = DateUtils.parse(items[5]);
        this.eRank = ERank.valueOf(items[6]);
    }
}
