import domain.customer.controller.CustomerController;
import domain.employee.controller.EmployeeController;
import global.util.Choice;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        systemInitial();
    }

    private static void systemInitial(){
        Choice choice = new Choice();
        CustomerController customerController = new CustomerController(choice);
        EmployeeController employeeController = new EmployeeController(choice);

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
