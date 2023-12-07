package model;

public class Admin implements IParser{
    private long id;
    private String username;
    private String password;
    private String fullName;
    public static int request;

    public Admin() {
        username = "admin";
        password = "123";
    }

    public Admin(long id, String username, String password, String fullName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
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
    public void parse(String line) {
        String[] items = line.split(",");

        this.id = Long.parseLong(items[0]);
        this.username = items[1];
        this.password = items[2];
        this.fullName = items[3];
        request = Integer.parseInt(items[4]);
    }
}
