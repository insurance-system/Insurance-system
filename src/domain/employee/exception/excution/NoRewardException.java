package domain.employee.exception.excution;

import domain.employee.exception.EmployeeException;

import static domain.employee.exception.EmployeeExceptionList.NO_REWARD;

public class NoRewardException extends EmployeeException {
    public NoRewardException() {
        super(
                NO_REWARD.getErrorCode(), NO_REWARD.getMessage());
    }
}
