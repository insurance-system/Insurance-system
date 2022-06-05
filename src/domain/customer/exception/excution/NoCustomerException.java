package domain.customer.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.customer.exception.CustomerExceptionList.NOCUSTOMER;


public class NoCustomerException extends EmployeeException {

    public NoCustomerException() {
        super(
                NOCUSTOMER.getErrorCode(), NOCUSTOMER.getMessage()
        );
    }
}
