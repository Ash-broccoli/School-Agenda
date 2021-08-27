package demo;

import database.DAO.SubjectDAO;
import models.Homework;
import models.Subject;

import java.util.ArrayList;

public class DBData {
    public ArrayList<Subject> getSubject() {
        ArrayList<Subject> subjectList = new ArrayList<>();

        subjectList.add(new Subject("English"));
        subjectList.add(new Subject("German"));
        subjectList.add(new Subject("Math"));

        return subjectList;
    }

    public ArrayList<Homework> getHomework() {
        ArrayList<Homework> hwList = new ArrayList<>();
        Subject s = new SubjectDAO().selectById(1);

        hwList.add(new Homework("Dream", s, "234", false));


        return hwList;
    }
}
