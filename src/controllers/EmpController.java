package controllers;

import ent.Employee;
import repositories.interfaces.IEmpRepositories;

import java.security.PublicKey;
import java.sql.Date;
import java.util.List;

public class EmpController {
    private final IEmpRepositories repo;


    public EmpController(IEmpRepositories repo){this.repo=repo;}

    public String createEmp(String name, String surname, int salary, String post, Date hire_date,String language, String project){
        Employee employee=new Employee(name,surname,salary,post,hire_date,language,project);

        boolean created=repo.CreateEmp(employee);

        return (created ? "Employee was created successfully!" : "Employee creation was failed! ");
    }

    public String getAllEmployee(){
        List<Employee> employees = repo.GetAllEmp();


        return employees.toString();
    }

    public String getEmpById(int id){
        Employee employee= repo.getEmpById(id);

        return (employee == null ? "Employee was not found!" : employee.toString());


    }

    public String getEmpByName(String name){
        List<Employee> employees=repo.GetEmpByName(name);

        return (employees == null ? "Employee was not found!" : employees.toString());
    }

    public String getEmpByPost(String post){
        List<Employee> employees=repo.GetEmpByPost(post);

        return (employees == null ? "Employee was not found!" : employees.toString());
    }

    public String GetEmpBySalaryRange(int price1,int price2){
        List<Employee> employees=repo.GetEmpBySalaryRange(price1,price2);

        return (employees == null ? "Employee was not found!" : employees.toString());
    }

    public String getEmpByProject(String project){
        List<Employee> employees=repo.GetEmpByProject(project);

        return (employees == null ? "Employee was not found!" : employees.toString());
    }

    public String GetEmpByHireDateRange(Date hire_date1,Date hire_date2){
        List<Employee> employees=repo.GetEmpByHireDateRange(hire_date1,hire_date2);

        return (employees == null ? "Employee was not found!" : employees.toString());
    }

    public String GetEmpByLanguage(String language){
        List<Employee> employees=repo.GetEmpByLanguage(language);

        return (employees == null ? "Employee was not found!" : employees.toString());
    }
    public  String RemoveEmpById(int id){
        boolean deleted=repo.RemoveEmpById(id);

        return (deleted == false ? "Employee was not deleted!" : "Employee has been deleted successfully" );
    }

    public String changeSalary(int id,int salary){
        boolean updated=repo.changeSalary(id,salary);
        return (updated == false ? "Employee's salary was not updated!" : "Employee's salary has been updated successfully");
    }

    public String changePost(int id, String post){
        boolean updated=repo.changePost(post,id);

        return(updated==false?"Employee's post was not updated!":"Employee's post has been updated successfully");
    }

    public String changeProject(int id,String project){
        boolean updated=repo.changeProject(project,id);

        return(updated==false?"Employee's project was not updated":"Employee's project has been updated successfully");
    }

    public String  getAvgSalaryOfPost(String post){
        double pos=repo.getAvgSalaryOfPost(post);
        return ("Average salary of post "+post+" is "+pos);
    }

}
