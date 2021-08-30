package demo;

import database.DAO.SubjectDAO;
import models.Homework;
import models.Login;
import models.Subject;

import java.util.ArrayList;

public class DBData {

    public ArrayList<Subject> getSubject() {
        ArrayList<Subject> subjectList = new ArrayList<>();

//        subjectList.add(new Subject("English", "Monday", 1));

        return subjectList;
    }

    public ArrayList<Homework> getHomework() {
        ArrayList<Homework> hwList = new ArrayList<>();
        Subject s = new SubjectDAO().selectById(2);

//        hwList.add(new Homework("Dream", s, "234", false, 1));


        return hwList;
    }
}
