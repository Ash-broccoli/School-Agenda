package models;

import login.SHA256;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loginId")
    private int loginId;
    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = SHA256.getInstantSHA(password);
    }

    public Login() {
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        setPassword(password, true);
    }

    public void setPassword(String password, boolean encrypted) {
        if (encrypted) {
            this.password = SHA256.getInstantSHA(password);
        } else {
            this.password = password;
        }
    }
}
