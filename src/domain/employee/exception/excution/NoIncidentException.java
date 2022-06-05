package domain.employee.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.employee.exception.EmployeeExceptionList.NO_INCIDENT;

public class NoIncidentException extends EmployeeException {
    public NoIncidentException() {
        super(NO_INCIDENT.getErrorCode(), NO_INCIDENT.getMessage());
    }
}
