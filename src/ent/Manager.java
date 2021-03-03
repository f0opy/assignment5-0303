package ent;

import java.sql.Date;

public class Manager extends Employee{
    public Date deadline;

    public void setDeadlines(Date date){

    }



    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "deadline=" + deadline +
                '}';
    }
}
