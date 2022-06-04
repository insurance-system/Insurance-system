package domain.customer.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.customer.exception.CustomerExceptionList.EXISTBENEFICIARY;
import static domain.customer.exception.CustomerExceptionList.EXISTPAYER;


public class ExistBeneficiaryException extends EmployeeException {

    public ExistBeneficiaryException() {
        super(
                EXISTBENEFICIARY.getErrorCode(), EXISTBENEFICIARY.getMessage()
        );
    }
}
