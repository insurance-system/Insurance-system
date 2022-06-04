package domain.employee.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.employee.exception.EmployeeExceptionList.NOCONSULTCUSTOMER;

public class NoConsultCustomerException extends EmployeeException {
    public NoConsultCustomerException() {
        super(NOCONSULTCUSTOMER.getErrorCode(), NOCONSULTCUSTOMER.getMessage());
    }
}
