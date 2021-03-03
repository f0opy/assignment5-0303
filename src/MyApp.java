import controllers.EmpController;

import java.sql.Date;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApp {
    private final EmpController controller;
    private final Scanner scanner;

    public MyApp(EmpController controller){
        this.controller=controller;
        scanner=new Scanner(System.in);
    }

    public void start(){
        while(true){
            System.out.println();
            System.out.println("Welcome to Application");
            System.out.println("Who are you?");
            System.out.println("1. Admin");
            System.out.println("2. Programmer");

            try{
                System.out.println("Enter the option: (1-2)");
                int op=scanner.nextInt();
                if(op==1){
                    System.out.println("1. GET All employee list");
                    System.out.println("2. Hire employee");
                    System.out.println("3. GET employee by ID");
                    System.out.println("4. GET employees by name");
                    System.out.println("5. GET employees by post");
                    System.out.println("6. GET employees by salary range");
                    System.out.println("7. GET employees by common Project");
                    System.out.println("8. GET employees by hire date range");
                    System.out.println("9. GET employees by Language of Programming");
                    System.out.println("10. To FIRE employee from company by id");
                    System.out.println("11. UPDATE Salary of employee by id");
                    System.out.println("12. UPDATE Post of employee by id ");
                    System.out.println("13. UPDATE Project of employee by id");
                    System.out.println("14. GET Average salary of post ");
                    System.out.println();
                }
                else if(op==2){
                    System.out.println("1. GET All employee list");
                    System.out.println("3. GET employee by ID");
                    System.out.println("4. GET employees by name");
                    System.out.println("5. GET employees by post");
                    System.out.println("6. GET employees by salary range");
                    System.out.println("7. GET employees by common Project");
                    System.out.println("8. GET employees by hire date range");
                    System.out.println("9. GET employees by Language of Programming");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


            try {
                System.out.println("Enter the option: (1-14)");
                int option = scanner.nextInt();
                if(option==1){
                    getAllEmpMenu();
                }

                else if(option == 2){
                    createUserMenu();
                }
                else if (option==3){
                    getEmpByIdMenu();
                }
                else if (option==4){
                    getEmpByNameMenu();
                }
                else if (option==5){
                    getEmpByPostMenu();
                }
                else if (option==6){
                    GetEmpBySalaryRangeMenu();
                }
                else if(option==7){
                    getEmpByProjectMenu();
                }
                else if(option==8){
                    GetEmpByHireDateRangeMenu();
                }
                else if(option==9){
                    GetEmpByLanguageMenu();
                }
                else if (option==10){
                    RemoveEmpByIdMenu();
                }
                else if (option==11){
                    changeSalaryMenu();
                }
                else if (option==12){
                    changePostMenu();
                }
                else if(option==13){
                    changeProjectMenu();
                }
                else if(option==14){
                    getAvgSalaryOfPostMenu();
                }

                else{
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            System.out.println("*******************************");
        }
    }

    public void getAllEmpMenu(){
        String res=controller.getAllEmployee();

        System.out.println(res);
    }

    public void createUserMenu(){
        System.out.println("Please enter name of employee");
        String name= scanner.next();
        System.out.println("Please enter surname of employee");
        String surname =scanner.next();
        System.out.println("Please enter salary");
        int salary=scanner.nextInt();
        System.out.println("Please enter post of employee (e.g Software Engineer, CyberSecurity, Manager etc)");
        String post=scanner.next();
        System.out.println("Please enter hire of date in format yyyy-mm-dd");
        Date date=Date.valueOf(scanner.next());
        System.out.println("Please enter language (e.g Java, Python, C++, C# etc)");
        String language=scanner.next();
        System.out.println("Please enter name of Project where employee work on");
        String project=scanner.next();


        String res= controller.createEmp(name,surname,salary,post,date,language,project);
        System.out.println(res);
    }

    public void getEmpByIdMenu(){
        System.out.println("Please enter ID of employee");
        int id=scanner.nextInt();

        String res=controller.getEmpById(id);
        System.out.println(res);
    }

    public void getEmpByNameMenu(){
        System.out.println("Please enter name:");
        String name=scanner.next();

        String res=controller.getEmpByName(name);
        System.out.println(res);
    }

    public void getEmpByPostMenu(){
        System.out.println("Please enter post:");
        String post=scanner.next();

        String res=controller.getEmpByPost(post);
        System.out.println(res);
    }

    public void GetEmpBySalaryRangeMenu(){
        System.out.println("Please enter salary 'FROM' ");
        int price1=scanner.nextInt();
        System.out.println("Please enter salary 'TO' ");
        int price2=scanner.nextInt();

        String res=controller.GetEmpBySalaryRange(price1,price2);

        System.out.println(res);

    }

    public void getEmpByProjectMenu(){
        System.out.println("Please enter name of Project, program will output all employees who working on this project");
        String project=scanner.next();
        String res=controller.getEmpByProject(project);
        System.out.println(res);
    }

    public void GetEmpByHireDateRangeMenu(){
        System.out.println("Please enter first range of hire date:");
        Date hire_date1=Date.valueOf(scanner.next());
        System.out.println("Please enter second range of hire date:");
        Date hire_date2=Date.valueOf(scanner.next());
        String res=controller.GetEmpByHireDateRange(hire_date1,hire_date2);
        System.out.println(res);
    }

    public void GetEmpByLanguageMenu(){
        System.out.println("Please enter language of programming which employee know");
        String language=scanner.next();
        String res=controller.GetEmpByLanguage(language);
        System.out.println(res);
    }

    public void RemoveEmpByIdMenu(){
        System.out.println("Please enter id of employee who should be fired:");
        int id=scanner.nextInt();
        String res=controller.RemoveEmpById(id);
        System.out.println(res);
    }

    public void changeSalaryMenu(){
        System.out.println("Please enter id of employee");
        int id=scanner.nextInt();
        System.out.println("Please enter updated salary ");
        int salary=scanner.nextInt();
        String res=controller.changeSalary(id,salary);
    }

    public void changePostMenu(){
        System.out.println("Please enter id of employee");
        int id=scanner.nextInt();
        System.out.println("Please enter updated post");
        String post=scanner.next();

        String res=controller.changePost(id,post);
        System.out.println(res);
    }

    public void changeProjectMenu(){
        System.out.println("Please enter ID of employee");
        int id=scanner.nextInt();
        System.out.println("Please enter updated Project name");
        String project=scanner.next();

        String res=controller.changeProject(id,project);
        System.out.println(res);
    }

    public void getAvgSalaryOfPostMenu(){
        System.out.println("Please enter post name to get avg salary of it");
        String post=scanner.next();

        String res=controller.getAvgSalaryOfPost(post);
        System.out.println(res);
    }
}
