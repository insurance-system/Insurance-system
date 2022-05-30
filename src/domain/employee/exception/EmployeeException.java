package domain.employee.exception;

import global.exception.ApplicationException;

public abstract class EmployeeException extends ApplicationException {
    protected EmployeeException(String errorCode, String message) {
        super(errorCode, message);
    }
}
