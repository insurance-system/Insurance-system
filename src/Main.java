import domain.customer.controller.CustomerController;
import domain.employee.controller.EmployeeController;
import global.util.Choice;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Choice choice = new Choice();
        CustomerController customerController = new CustomerController();
        EmployeeController employeeController = new EmployeeController(new Choice());




        while (true){
            switch (choice.initial()){
                case 1:
                    customerController.initial();
                    break;
                case 2:
                    employeeController.initial();
                    break;
                case 3:
                    System.exit(0);
            }
        }

    }
}
