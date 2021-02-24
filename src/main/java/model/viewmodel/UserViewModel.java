package model.viewmodel;

import java.security.NoSuchAlgorithmException;

import services.security.EncryptService;

public class UserViewModel {

    private String username;
    private String password;

    public UserViewModel() {
    }

    public UserViewModel(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        try {
            this.password = EncryptService.Encrypt(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String getPassword() {
        return this.password;
    }

}
