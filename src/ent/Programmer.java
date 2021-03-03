package ent;

import java.sql.Date;

public class Programmer extends Employee{
    private String post;
    private String language;
    private String project;

    public Programmer(String post, String language, String project) {
        this.post = post;
        this.language = language;
        this.project = project;
    }

    public Programmer(String name, String surname, int salary,  String post,Date hire_date, String language, String project) {
        super(name, surname, salary, hire_date);
        this.post = post;
        this.language = language;
        this.project = project;
    }

    public Programmer(int id, String name, String surname, int salary, String post,Date hire_date,  String language, String project) {
        super(id, name, surname, salary, hire_date);
        this.post = post;
        this.language = language;
        this.project = project;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
