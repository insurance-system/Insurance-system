package domain.employee.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.employee.exception.EmployeeExceptionList.NOINCIDENT;

public class NoIncidentException extends EmployeeException {
    public NoIncidentException() {
        super(NOINCIDENT.getErrorCode(), NOINCIDENT.getMessage());
    }
}
