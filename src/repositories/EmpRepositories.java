package repositories;

import data.interfaces.IDB;
import ent.Employee;
import repositories.interfaces.IEmpRepositories;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmpRepositories implements IEmpRepositories {
    private final IDB db;
    public EmpRepositories(IDB db){this.db= db;}

    @Override
    public List<Employee> GetAllEmp() {
        Connection con = null;
        Statement st=null;
        try{
            con= db.getConnection(); //getting connection with db
            st=con.createStatement();

            ResultSet rs=st.executeQuery("SELECT*FROM employees");  //executing my sql query
            List<Employee> employees=new LinkedList<>();

            while(rs.next()){   //loop for save every object of Employee to LIST
                Employee employee=new Employee(rs.getInt("id"),
                        rs.getString("name"), rs.getString("surname"),
                       rs.getInt("salary"),rs.getString("post"),
                        rs.getDate("hire_date"),rs.getString("language"),
                        rs.getString("project"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean CreateEmp(Employee employee) {
        Connection con = null;
        try{
            con= db.getConnection();    //getting connection with database

            PreparedStatement st=con.prepareStatement("INSERT INTO employees(name,surname,salary,post,hire_date,language,project) VALUES (?,?,?,?,?,?,?)");  //sql query

            st.setString(1,employee.getName());
            st.setString(2, employee.getSurname());
            st.setInt(3,employee.getSalary());
            st.setString(4,employee.getPost());
            st.setDate(5,employee.getHire_date());
            st.setString(6,employee.getLanguage());
            st.setString(7,employee.getProject());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close();    //closing connection with database
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Employee getEmpById(int id) {
        Connection con=null;
        try{
            con= db.getConnection();

            PreparedStatement st= con.prepareStatement("SELECT*FROM employees WHERE id=?");

            st.setInt(1,id);    //Inputing ID instead of first '?' sign

            ResultSet rs=st.executeQuery();

            if(rs.next()){
                Employee employee=new Employee(rs.getInt("id"),
                        rs.getString("name"), rs.getString("surname"),
                        rs.getInt("salary"),rs.getString("post"),
                        rs.getDate("hire_date"),rs.getString("language"),
                        rs.getString("project"));
                return  employee;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Employee> GetEmpByName(String name) {
        Connection con = null;
        try{
            con= db.getConnection();


            PreparedStatement prst = con.prepareStatement("SELECT*FROM employees WHERE name=?");
            prst.setString(1,name);

            ResultSet rs=prst.executeQuery();


            List<Employee> employees=new LinkedList<>();

            while(rs.next()){
                Employee employee=new Employee(rs.getInt("id"),
                        rs.getString("name"), rs.getString("surname"),
                        rs.getInt("salary"),rs.getString("post"),
                        rs.getDate("hire_date"),rs.getString("language"),
                        rs.getString("project"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Employee> GetEmpByPost(String post) {
        Connection con = null;
        try{
            con= db.getConnection();


            PreparedStatement prst = con.prepareStatement("SELECT*FROM employees WHERE post=?");
            prst.setString(1,post);

            ResultSet rs=prst.executeQuery();


            List<Employee> employees=new LinkedList<>();

            while(rs.next()){
                Employee employee=new Employee(rs.getInt("id"),
                        rs.getString("name"), rs.getString("surname"),
                        rs.getInt("salary"),rs.getString("post"),
                        rs.getDate("hire_date"),rs.getString("language"),
                        rs.getString("project"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Employee> GetEmpBySalaryRange(int salary1, int salary2) {
        Connection con = null;
        try{
            con= db.getConnection();


            PreparedStatement prst = con.prepareStatement("SELECT*FROM employees WHERE salary between ? and ?");
            prst.setInt(1,salary1);
            prst.setInt(2,salary2);

            ResultSet rs=prst.executeQuery();


            List<Employee> employees=new LinkedList<>();

            while(rs.next()){
                Employee employee=new Employee(rs.getInt("id"),
                        rs.getString("name"), rs.getString("surname"),
                        rs.getInt("salary"),rs.getString("post"),
                        rs.getDate("hire_date"),rs.getString("language"),
                        rs.getString("project"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


        return null;
    }

    @Override
    public List<Employee> GetEmpByProject(String project) {
        Connection con = null;
        try{
            con= db.getConnection();


            PreparedStatement prst = con.prepareStatement("SELECT*FROM employees WHERE project=?");
            prst.setString(1,project);

            ResultSet rs=prst.executeQuery();


            List<Employee> employees=new LinkedList<>();

            while(rs.next()){
                Employee employee=new Employee(rs.getInt("id"),
                        rs.getString("name"), rs.getString("surname"),
                        rs.getInt("salary"),rs.getString("post"),
                        rs.getDate("hire_date"),rs.getString("language"),
                        rs.getString("project"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


        return null;
    }

    @Override
    public List<Employee> GetEmpByHireDateRange(Date hire_date1,Date hire_date2) {
        Connection con = null;
        try{
            con= db.getConnection();


            PreparedStatement prst = con.prepareStatement("SELECT*FROM employees WHERE hire_date between ? and ?");
            prst.setDate(1,hire_date1);
            prst.setDate(2,hire_date2);

            ResultSet rs=prst.executeQuery();


            List<Employee> employees=new LinkedList<>();

            while(rs.next()){
                Employee employee=new Employee(rs.getInt("id"),
                        rs.getString("name"), rs.getString("surname"),
                        rs.getInt("salary"),rs.getString("post"),
                        rs.getDate("hire_date"),rs.getString("language"),
                        rs.getString("project"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Employee> GetEmpByLanguage(String language) {
        Connection con = null;


        try{
            con= db.getConnection();


            PreparedStatement prst = con.prepareStatement("SELECT*FROM employees WHERE language=?");
            prst.setString(1,language);

            ResultSet rs=prst.executeQuery();


            List<Employee> employees=new LinkedList<>();

            while(rs.next()){
                Employee employee=new Employee(rs.getInt("id"),
                        rs.getString("name"), rs.getString("surname"),
                        rs.getInt("salary"),rs.getString("post"),
                        rs.getDate("hire_date"),rs.getString("language"),
                        rs.getString("project"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


        return null;
    }

    @Override
    public boolean RemoveEmpById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM employees WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            st.execute();

            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean changeSalary(int salary, int id) {
        Connection con = null;
        try {
            con = db.getConnection();

            String sql = "UPDATE employees SET salary=? WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, salary);
            st.setInt(2,id);

            st.execute();
            return true;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean changePost(String post,int id) {
        Connection con=null;
        try{
            con=db.getConnection();

            PreparedStatement st= con.prepareStatement("UPDATE employees SET post=? WHERE id=?");

            st.setString(1,post);
            st.setInt(2,id);

            st.execute();
            return true;
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean changeProject(String project, int id) {
        Connection con=null;
        try{
            con=db.getConnection();

            PreparedStatement st=con.prepareStatement("UPDATE employees SET project=?  WHERE id=?");

            st.setString(1,project);
            st.setInt(2,id);

            st.execute();
            return  true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public double getAvgSalaryOfPost(String post) {
        Connection con=null;
        try{
            con=db.getConnection();

            PreparedStatement st=con.prepareStatement("Select avg(salary) FROM employees where post=?");
                double res;
            st.setString(1,post);
                ResultSet rs= st.executeQuery();
            if(rs.next()){
               res= rs.getDouble("avg");
               return res;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
