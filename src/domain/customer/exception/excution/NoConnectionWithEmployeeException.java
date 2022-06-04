package domain.customer.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.customer.exception.CustomerExceptionList.NOCONNECTIONWITHEMPLOYEE;
import static domain.customer.exception.CustomerExceptionList.NOEVALUATESATISFACTION;


public class NoConnectionWithEmployeeException extends EmployeeException {

    public NoConnectionWithEmployeeException() {
        super(
                NOCONNECTIONWITHEMPLOYEE.getErrorCode(), NOCONNECTIONWITHEMPLOYEE.getMessage()
        );
    }
}
