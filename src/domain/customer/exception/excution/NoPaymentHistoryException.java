package domain.customer.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.customer.exception.CustomerExceptionList.NOCUSTOMER;
import static domain.customer.exception.CustomerExceptionList.NOPAYMENTHISTORY;


public class NoPaymentHistoryException extends EmployeeException {

    public NoPaymentHistoryException() {
        super(
                NOPAYMENTHISTORY.getErrorCode(), NOPAYMENTHISTORY.getMessage()
        );
    }
}
