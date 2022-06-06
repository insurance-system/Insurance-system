package domain.employee.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.customer.exception.CustomerExceptionList.CHECKMENUNUMBER;


public class CheckMenuNumberException extends EmployeeException {

    public CheckMenuNumberException() {
        super(
                CHECKMENUNUMBER.getErrorCode(),
                CHECKMENUNUMBER.getMessage());
    }
}
