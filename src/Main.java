import domain.customer.controller.CustomerController;
import domain.employee.controller.EmployeeController;
import global.util.Choice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        Choice choice = new Choice();
        CustomerController customerController = new CustomerController();
        EmployeeController employeeController = new EmployeeController(new Choice());
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://umcdb.cuiea55gxaoy.ap-northeast-2.rds.amazonaws.com:3306/Insurance",
                    "admin",
                    "sojung210");


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        while (true){
            switch (choice.inital()){
                case 1:
                    customerController.customerInitial();
                    break;
                case 2:
                    employeeController.inital();
                    break;
                case 3:
                    employeeController.connect();
                case 4:
                    System.exit(0);
            }
        }

    }
}
