package demo;

import database.DAO.SubjectDAO;
import models.Homework;
import models.Login;
import models.Subject;

import java.util.ArrayList;

public class DBData {

    public ArrayList<Login> getLogin() {
        ArrayList<Login> loginList = new ArrayList<>();

        loginList.add(new Login("admin", "admin"));

        return loginList;
    }

//    public ArrayList<Homework> getHomework() {
//        ArrayList<Homework> hwList = new ArrayList<>();
//        Subject s = new SubjectDAO().selectById(2);
//
//        hwList.add(new Homework("Dream", s, "234", false, 1));
//
//
//        return hwList;
//    }
}
