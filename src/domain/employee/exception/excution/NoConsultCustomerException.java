package domain.employee.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.employee.exception.EmployeeExceptionList.NO_CONSULT_CUSTOMER;

public class NoConsultCustomerException extends EmployeeException {
    public NoConsultCustomerException() {
        super(NO_CONSULT_CUSTOMER.getErrorCode(), NO_CONSULT_CUSTOMER.getMessage());
    }
}
