package domain.customer.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.employee.exception.EmployeeExceptionList.CHECKMENUNEUBER;

public class CheckMenuNumberException extends EmployeeException {

    public CheckMenuNumberException() {
        super(
                CHECKMENUNEUBER.getErrorCode(), CHECKMENUNEUBER.getMessage());
    }
}
