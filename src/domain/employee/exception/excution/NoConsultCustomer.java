package domain.employee.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.employee.exception.EmployeeExceptionList.NOCONSULTCUSTOMER;

public class NoConsultCustomer extends EmployeeException {
    public NoConsultCustomer() {
        super(NOCONSULTCUSTOMER.getErrorCode(), NOCONSULTCUSTOMER.getMessage());
    }
}
