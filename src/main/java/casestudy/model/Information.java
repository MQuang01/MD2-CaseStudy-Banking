package casestudy.model;

import casestudy.utils.DateUtils;

import java.time.LocalDate;

public class Information implements IParser{
    private long id;
    private String fullName;
    private String phoneNum;
    private LocalDate doB;
    private boolean status;
    private Admin approved_by;
    private Admin cancel_by;

    public static long currentId;

    public Information() {
    }

    public Information(long id, String fullName, String phoneNUm, LocalDate doB) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNum = phoneNUm;
        this.doB = doB;
        this.status = false;
    }

    public Information(String fullName, String phoneNUm, LocalDate doB) {
        this.fullName = fullName;
        this.phoneNum = phoneNUm;
        this.doB = doB;
        this.status = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Admin getApproved_by() {
        return approved_by;
    }

    public void setApproved_by(Admin approved_by) {
        this.approved_by = approved_by;
    }

    public Admin getCancel_by() {
        return cancel_by;
    }

    public void setCancel_by(Admin cancel_by) {
        this.cancel_by = cancel_by;
    }

    //id,fullName,phone,doB,null,null
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", id, fullName, phoneNum, doB);
    }

    public void parse(String line) {
        String [] items = line.split(",");

        //1,Minh Quang 1,0934960651,2000-11-21
        this.id = Long.parseLong(items[0]);
        this.fullName = items[1];
        this.phoneNum = items[2];
        this.doB = DateUtils.parse(items[3]);
    }
}
