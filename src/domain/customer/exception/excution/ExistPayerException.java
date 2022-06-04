package domain.customer.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.customer.exception.CustomerExceptionList.EXISTPAYER;
import static domain.customer.exception.CustomerExceptionList.EXISTSATISFACTION;


public class ExistPayerException extends EmployeeException {

    public ExistPayerException() {
        super(
                EXISTPAYER.getErrorCode(), EXISTPAYER.getMessage()
        );
    }
}
