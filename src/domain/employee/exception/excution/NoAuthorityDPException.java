package domain.employee.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.employee.exception.EmployeeExceptionList.NO_AUTHORITY_DEPARTMENT;

public class NoAuthorityDPException extends EmployeeException {
    public NoAuthorityDPException() {
        super(NO_AUTHORITY_DEPARTMENT.getErrorCode(), NO_AUTHORITY_DEPARTMENT.getMessage());
    }
}
