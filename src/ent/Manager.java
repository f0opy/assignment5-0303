package ent;

import java.sql.Date;

public class Manager extends Employee{
    public Date deadl;


    public Manager() {
    }

    public Manager(String name, String surname, int salary, Date hire_date) {
        super(name, surname, salary, hire_date);
    }

    public Manager(int id, String name, String surname, int salary, Date hire_date) {
        super(id, name, surname, salary, hire_date);
    }

    public Date getDeadl() {

        return deadl;
    }

    public void setDeadl(Date deadline) {
        this.deadl = deadline;
    }



    @Override
    public String toString() {
        return "Manager{" +
                "deadline=" + deadl +
                '}';
    }
}
