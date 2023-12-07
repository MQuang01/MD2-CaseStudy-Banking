package model;

import java.time.LocalDate;

public class Information {
    private long id;
    private String fullName;
    private String phoneNUm;
    private LocalDate doB;
    private boolean status;
    private Admin approved_by;
    private Admin cancel_by;

    public static int currentId;

    public Information() {
    }

    public Information(long id, String fullName, String phoneNUm, LocalDate doB) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNUm = phoneNUm;
        this.doB = doB;
        this.status = false;
    }

    public Information(String fullName, String phoneNUm, LocalDate doB) {
        this.fullName = fullName;
        this.phoneNUm = phoneNUm;
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

    public String getPhoneNUm() {
        return phoneNUm;
    }

    public void setPhoneNUm(String phoneNUm) {
        this.phoneNUm = phoneNUm;
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
}
