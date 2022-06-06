package domain.employee.exception;

public enum EmployeeExceptionList {

    NO_EMPLOYEE("E0001", "해당 번호를 가진 사원을 찾을 수 없습니다."),
    CHECK_MENU_NUMBER("E0002","양식에 맞게 입력 부탁드립니다."),
    NO_AUTHORITY_DEPARTMENT("E0003", "접근 권한이 없습니다."),
    NO_CUSTOMER("E0004", "찾으시는 고객 ID를 잘못입력하셨거나 없는 고객 ID입니다."),
    NO_CONSULT_CUSTOMER("E0005","상담 대기 고객이 없습니다."),
    NO_INCIDENT("E0006","담당자 미배정 사건이 없습니다."),
    NO_REWARD("E0007","보상금 심사 대상이 없습니다.");

    private String ErrorCode;
    private String Message;

    EmployeeExceptionList(String errorCode, String message) {
        ErrorCode = errorCode;
        Message = message;
    }

    public String getErrorCode() {
        return this.ErrorCode;
    }

    public String getMessage() {
        return this.Message;
    }

}
