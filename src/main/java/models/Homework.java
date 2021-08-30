package models;

import javax.persistence.*;

@Entity
@Table(name="homework")
public class Homework {
    private int homeworkId;
    private String homework;
    private Subject subjectId;
    private String dueTill;
    private boolean completed = false;
    private Login loginId;


    public Homework() {
    }

    public Homework(String homework, Subject subjectId, String dueTill, boolean completed, Login loginId) {
        this.homework = homework;
        this.subjectId = subjectId;
        this.dueTill = dueTill;
        this.completed = completed;
        this.loginId = loginId;
    }

    public void setEverything(Homework h) {
        this.setHomework(h.homework);
        this.setSubjectId(h.subjectId);
        this.setDueTill(h.dueTill);
        this.setCompleted(h.completed);
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="homeworkId")
    public int getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
    }

    @Column(name="homework")
    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    @OneToOne
    @JoinColumn(name = "subjectId")
    public Subject getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

    @Column(name="dueTill")
    public String getDueTill() {
        return dueTill;
    }

    public void setDueTill(String dueTill) {
        this.dueTill = dueTill;
    }

    @Column(name="completed")
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @OneToOne
    @JoinColumn(name="loginId")
    public Login getLoginId() {
        return loginId;
    }

    public void setLoginId(Login loginId) {
        this.loginId = loginId;
    }
}
