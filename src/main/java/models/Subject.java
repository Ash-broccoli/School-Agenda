package models;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {
    private int subjectId;
    private String subject;

    public Subject() {
    }

    public Subject(String subject) {
        this.subject = subject;
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
}
