package demo;

import models.Login;

import java.util.ArrayList;

public class DBData {

    public ArrayList<Login> getLogin() {
        ArrayList<Login> loginList = new ArrayList<>();

        loginList.add(new Login("admin", "admin"));

        return loginList;
    }
}
