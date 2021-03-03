package ent;

import java.sql.Date;

public class Employee {
    // Creating fields which are most relevant:
    private int id;
    private String name;
    private String surname;
    private int salary;
    private String post;
    private Date hire_date;
    private String language;
    private String project;


    public Employee(){

    }

    // Here I create constuctors:
    public  Employee( String name, String surname, int salary, String post, Date hire_date,String language,String project){
        setName(name);
        setSurname(surname);
        setSalary(salary);
        setPost(post);
        setHire_date(hire_date);
        setLanguage(language);
        setProject(project);
    }


    public Employee(int id, String name, String surname, int salary, String post, Date hire_date,String language,String project){
        setId(id);
        setName(name);
        setSurname(surname);
        setSalary(salary);
        setPost(post);
        setHire_date(hire_date);
        setLanguage(language);
        setProject(project);
    }


    //Creating getters and setter for all fields:
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
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

    @Override
    public String toString() {
        return "Employee:" + '\n'+
                " id=" + id +
                " name=" + name + '\n' +
                " surname=" + surname + '\n' +
                " salary=" + salary +'\n'+
                " post=" + post + '\n' +
                " hire_date=" + hire_date +'\n'+
                " language=" + language + '\n' +
                " project=" + project + '\n'+'\n'+"-----------------------------------------------"+'\n';
    }
}
