package domain.customer.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.customer.exception.CustomerExceptionList.*;


public class ExistSatisfactionException extends EmployeeException {

    public ExistSatisfactionException() {
        super(
                EXISTSATISFACTION.getErrorCode(), EXISTSATISFACTION.getMessage()
        );
    }
}
