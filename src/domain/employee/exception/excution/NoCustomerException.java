package domain.employee.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.employee.exception.EmployeeExceptionList.NO_CUSTOMER;


public class NoCustomerException extends EmployeeException {

    public NoCustomerException() {
        super(
                NO_CUSTOMER.getErrorCode(), NO_CUSTOMER.getMessage()
        );
    }
}
