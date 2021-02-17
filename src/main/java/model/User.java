package model;

public class User extends Identity{

    private String name;
    private String lastname;
    private String username;
    private String password;

    public User() {
    }

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getLastName() {
        return this.lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString(){
        return String.format("User: { id: %d, name: %s, lastname: %s, username: %s, password:%s}", 
        getId(), getName(), getLastName(), getUsername(), getPassword());
    }
}
