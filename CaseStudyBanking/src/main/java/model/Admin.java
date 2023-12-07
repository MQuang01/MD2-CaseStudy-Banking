package model;

public class Admin implements IParser{
    private long id;
    private String username;
    private String password;
    private String fullName;
    public static int request;
    public static long currentId;

    public Admin() {
    }

    public Admin(long id, String username, String fullName) {
        this.id = id;
        this.username = username;
        this.password = "123";
        this.fullName = fullName;
        request = 0;
    }

    public Admin(String username, String fullName) {
        this.username = username;
        this.password = "123";
        this.fullName = fullName;
        request = 0;

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

    public static int getRequest() {
        return request;
    }

    public static void setRequest(int request) {
        Admin.request = request;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s",id,username,password,fullName,request);
    }

    @Override
    public void parse(String line) {
        String[] items = line.split(",");

        this.id = Long.parseLong(items[0]);
        this.username = items[1];
        this.password = items[2];
        this.fullName = items[3];
        request = Integer.parseInt(items[4]);
    }
}
