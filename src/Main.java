import controllers.EmpController;
import data.PostgreDB;
import data.interfaces.IDB;
import repositories.EmpRepositories;
import repositories.interfaces.IEmpRepositories;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgreDB();
        IEmpRepositories repo= new EmpRepositories(db);
        EmpController controller=new EmpController(repo);
        MyApp app=new MyApp(controller);
        app.start();
    }
}
