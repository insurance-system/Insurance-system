package domain.employee.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.employee.exception.EmployeeExceptionList.NOEMPLOYEE;


public class NoEmployeeException extends EmployeeException {

    public NoEmployeeException() {
        super(
                NOEMPLOYEE.getErrorCode(), NOEMPLOYEE.getMessage()
        );
    }
}
