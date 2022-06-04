package domain.customer.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.customer.exception.CustomerExceptionList.NOCUSTOMER;
import static domain.customer.exception.CustomerExceptionList.NOJOINEDINSURANCE;


public class NoJoinedInsuranceException extends EmployeeException {

    public NoJoinedInsuranceException() {
        super(
                NOJOINEDINSURANCE.getErrorCode(), NOJOINEDINSURANCE.getMessage()
        );
    }
}
