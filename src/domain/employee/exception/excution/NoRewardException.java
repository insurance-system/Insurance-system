package domain.employee.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.employee.exception.EmployeeExceptionList.NOREWARD;

public class NoRewardException extends EmployeeException {
    public NoRewardException() {
        super(
                NOREWARD.getErrorCode(), NOREWARD.getMessage());
    }
}
