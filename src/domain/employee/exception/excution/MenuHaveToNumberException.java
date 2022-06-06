package domain.employee.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.employee.exception.EmployeeExceptionList.MENU_HAVE_TO_NUMBER;

public class MenuHaveToNumberException extends EmployeeException {
    public MenuHaveToNumberException() {
        super(
                MENU_HAVE_TO_NUMBER.getErrorCode(), MENU_HAVE_TO_NUMBER.getMessage());
    }
}
