package repositories.interfaces;

import ent.Employee;
import ent.Programmer;

import java.sql.Date;
import java.util.List;

public interface IEmpRepositories {
   List<Employee> GetAllEmp();      //to get all existing emp in database
    boolean CreateEmp(Programmer employee); //to create emp
    Employee getEmpById(int id);            //to get emp by id
    List<Employee> GetEmpByName(String name); //to get emp by name
    List<Employee> GetEmpByPost(String post);  //to get emp by post
    List<Employee> GetEmpBySalaryRange(int salary1, int salary2);   //to get emp in the given range of salary
    List<Employee> GetEmpByProject(String project);     //to get employees who work on the same Project
    List<Employee> GetEmpByHireDateRange(Date hire_date1, Date hire_date2);  //to get emp in the given range of hire date
    List<Employee> GetEmpByLanguage(String language);    //to get emp who knows exactly written Language of Programming
    boolean RemoveEmpById(int id);    //to remove emp by the given id
    boolean changeSalary(int salary,int id); //to change salary of emp
    boolean changePost(String post,int id); //to change post of emp by id
    boolean changeProject(String project, int id); //to change project of emp by id
    double getAvgSalaryOfPost(String post);



}
