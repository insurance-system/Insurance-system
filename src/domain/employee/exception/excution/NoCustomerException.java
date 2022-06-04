package domain.employee.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.employee.exception.EmployeeExceptionList.NOCUSTOMER;


public class NoCustomerException extends EmployeeException {

    public NoCustomerException() {
        super(
                NOCUSTOMER.getErrorCode(), NOCUSTOMER.getMessage()
        );
    }
}
