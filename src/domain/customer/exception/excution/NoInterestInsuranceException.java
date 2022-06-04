package domain.customer.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.customer.exception.CustomerExceptionList.NOINTERESTINSURANCE;
import static domain.customer.exception.CustomerExceptionList.NOJOINEDINSURANCE;


public class NoInterestInsuranceException extends EmployeeException {

    public NoInterestInsuranceException() {
        super(
                NOINTERESTINSURANCE.getErrorCode(), NOINTERESTINSURANCE.getMessage()
        );
    }
}
