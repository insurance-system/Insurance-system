package domain.employee.exception.excution;

import domain.employee.exception.EmployeeException;
import domain.employee.exception.EmployeeExceptionList;

import static domain.employee.exception.EmployeeExceptionList.NOAUTHORITYDP;

public class NoAuthorityDPException extends EmployeeException {
    public NoAuthorityDPException() {
        super(
                NOAUTHORITYDP.getErrorCode(),
                NOAUTHORITYDP.getMessage());
    }
}
