package model;

import utils.DateUtils;

import java.time.LocalDate;

public class Account implements IParser{
    private long id;
    private String username;
    private String password;
    private String fullName;
    private int phoneNum;
    private LocalDate doB;
    private ERank eRank;
    public static int currentId;

    public Account() {
    }

    public Account(long id, String fullName, int phoneNum, LocalDate doB, ERank eRank) {
        this.id = id;
        this.username = Integer.toString(phoneNum);
        this.password = "123123";
        this.fullName = fullName;
        this.phoneNum = phoneNum;
        this.doB = doB;
        this.eRank = eRank;
    }

    public Account(String fullName, int phoneNum, LocalDate doB, ERank eRank) {
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

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
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
    public void parse(String line) {
        String [] items = line.split(",");

        //id,username,psw,fullName,doB,ranked
        this.id = Long.parseLong(items[0]);
        this.username = items[1];
        this.password = items[2];
        this.fullName = items[3];
        this.doB = DateUtils.parse(items[4]);
        this.eRank = ERank.valueOf(items[5]);
    }
}
