package SpringBoot.Hospital;

public class Nurse {
    
    private String name;
    private String user;
    private String password;

    public Nurse(String name, String user, String password) {
        this.name = name;
        this.password = password;
        this.user = user;
    }

    // Getter and setter for 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for 'user'
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    // Getter and setter for 'password'
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

