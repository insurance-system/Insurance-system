package domain.customer.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.customer.exception.CustomerExceptionList.NOCUSTOMER;
import static domain.employee.exception.EmployeeExceptionList.NOEMPLOYEE;


public class NoCustomerException extends EmployeeException {

    public NoCustomerException() {
        super(
                NOCUSTOMER.getErrorCode(), NOCUSTOMER.getMessage()
        );
    }
}
