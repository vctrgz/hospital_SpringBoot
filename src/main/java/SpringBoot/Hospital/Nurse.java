package SpringBoot.Hospital;

public class Nurse {
    String name;
    String user;
    String password;

    public Nurse(String name, String user, String password){
        this.name = name;
        this.password = password;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
