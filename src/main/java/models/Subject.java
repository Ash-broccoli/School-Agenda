package models;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {
    private int subjectId;
    private String subject;
    private String day;
    private boolean archived = false;
    private Login loginId;

    public Subject() {
    }

    public Subject(String subject, String day, Login loginId) {
        this.subject = subject;
        this.day = day;
        this.loginId = loginId;
    }

    public void setEverything(Subject s) {
        this.setSubject(s.subject);
        this.setDay(s.day);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="subjectId")
    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Column(name="subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Column(name="day")
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Column(name="archived" , nullable = false)
    public boolean isArchived() {return archived;}

    public void setArchived(boolean archived) {this.archived = archived;}

    @OneToOne
    @JoinColumn(name="loginId")
    public Login getLoginId() {
        return loginId;
    }

    public void setLoginId(Login loginId) {
        this.loginId = loginId;
    }
}
