package domain.employee.exception;

import static domain.employee.exception.EmployeeExceptionList.NOEMPLOYEE;

public class NOEMPLOYEEEXCEPTION extends EmployeeException {

    public NOEMPLOYEEEXCEPTION() {
        super(
                NOEMPLOYEE.getErrorCode(), NOEMPLOYEE.getMessage()
        );
    }
}
