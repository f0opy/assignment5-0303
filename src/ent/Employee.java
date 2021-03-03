package ent;

import java.sql.Date;

public class Employee {
    // Creating fields which are most relevant:
    private int id;
    private String name;
    private String surname;
    private int salary;
    private Date hire_date;



    public Employee(){

    }

    // Here I create constuctors:
    public  Employee( String name, String surname, int salary, Date hire_date){
        setName(name);
        setSurname(surname);
        setSalary(salary);

        setHire_date(hire_date);

    }


    public Employee(int id, String name, String surname, int salary, Date hire_date){
        setId(id);
        setName(name);
        setSurname(surname);
        setSalary(salary);

        setHire_date(hire_date);

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



    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }



    @Override
    public String toString() {
        return "Employee:" + '\n'+
                " id=" + id +
                " name=" + name + '\n' +
                " surname=" + surname + '\n' +
                " salary=" + salary +'\n'+
                " hire_date=" + hire_date +'\n'+
                 '\n'+'\n'+"-----------------------------------------------"+'\n';
    }
}
