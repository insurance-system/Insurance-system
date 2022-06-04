package domain.customer.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.customer.exception.CustomerExceptionList.EXISTCUSTOMER;
import static domain.customer.exception.CustomerExceptionList.EXISTPAYER;


public class ExistCustomerException extends EmployeeException {

    public ExistCustomerException() {
        super(
                EXISTCUSTOMER.getErrorCode(), EXISTCUSTOMER.getMessage()
        );
    }
}
