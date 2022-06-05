import domain.customer.controller.CustomerController;
import domain.employee.controller.EmployeeController;
import global.util.CommonComment;

public class Main {

    public static void main(String[] args){
        systemInitial();
    }

    private static void systemInitial(){
        CustomerController customerController = new CustomerController();
        EmployeeController employeeController = new EmployeeController();
        CommonComment commonComment = new CommonComment();
        Exit:
        while (true){
            switch (commonComment.initial()){
                case 1:
                    customerController.initial();
                    break;
                case 2:
                    employeeController.initial();
                    break;
                case 0:
                    break Exit;
            }
        }
    }
}
