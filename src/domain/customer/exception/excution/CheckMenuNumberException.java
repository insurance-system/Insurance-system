package domain.customer.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.employee.exception.EmployeeExceptionList.CHECK_MENU_NUMBER;

public class CheckMenuNumberException extends EmployeeException {

    public CheckMenuNumberException() {
        super(
                CHECK_MENU_NUMBER.getErrorCode(), CHECK_MENU_NUMBER.getMessage());
    }
}
