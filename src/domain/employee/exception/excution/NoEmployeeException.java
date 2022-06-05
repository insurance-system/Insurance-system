package domain.employee.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.employee.exception.EmployeeExceptionList.NO_EMPLOYEE;


public class NoEmployeeException extends EmployeeException {

    public NoEmployeeException() {
        super(
                NO_EMPLOYEE.getErrorCode(), NO_EMPLOYEE.getMessage()
        );
    }
}
