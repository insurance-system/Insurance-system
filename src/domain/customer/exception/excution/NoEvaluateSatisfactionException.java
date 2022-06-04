package domain.customer.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.customer.exception.CustomerExceptionList.NOCUSTOMER;
import static domain.customer.exception.CustomerExceptionList.NOEVALUATESATISFACTION;


public class NoEvaluateSatisfactionException extends EmployeeException {

    public NoEvaluateSatisfactionException() {
        super(
                NOEVALUATESATISFACTION.getErrorCode(), NOEVALUATESATISFACTION.getMessage()
        );
    }
}
