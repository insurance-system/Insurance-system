package domain.customer.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.customer.exception.CustomerExceptionList.NOCUSTOMER;
import static domain.customer.exception.CustomerExceptionList.NOJOINNONLIFEINSURANCE;


public class NoJoinNonlifeInsuranceException extends EmployeeException {

    public NoJoinNonlifeInsuranceException() {
        super(
                NOJOINNONLIFEINSURANCE.getErrorCode(), NOJOINNONLIFEINSURANCE.getMessage()
        );
    }
}
