package domain.customer.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.customer.exception.CustomerExceptionList.NOJOINLIFEINSURANCE;
import static domain.customer.exception.CustomerExceptionList.NOJOINNONLIFEINSURANCE;


public class NoJoinLifeInsuranceException extends EmployeeException {

    public NoJoinLifeInsuranceException() {
        super(
                NOJOINLIFEINSURANCE.getErrorCode(), NOJOINLIFEINSURANCE.getMessage()
        );
    }
}
