package models;

import javax.persistence.*;

@Entity
@Table(name = "test")
public class Test {
    private int testId;
    private String content;
    private Subject subjectId;
    private String date;
    private Double grade;
    private boolean completed = false;

    public Test() {
    }

    public Test( String content, Subject subjectId, String date, Double grade, boolean completed) {
        this.content = content;
        this.subjectId = subjectId;
        this.date = date;
        this.grade = grade;
        this.completed = completed;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="testId")
    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    @Column(name="content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        content = content;
    }

    @OneToOne
    @JoinColumn(name="subjectId")
    public Subject getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

    @Column(name="date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name="grade")
    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Column(name="completed")
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
