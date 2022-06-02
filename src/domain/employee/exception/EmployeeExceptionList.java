package domain.employee.exception;

public enum EmployeeExceptionList {

    NOEMPLOYEE("E0001", "해당 번호를 가진 사원을 찾을 수 없습니다."),
    CHECKMENUNEUBER("E0002","메뉴 번호를 확인해주세요."),
    NOAUTHORITYDP("E0003", "접근 권한이 없습니다.");

    private String ErrorCode;
    private String Message;
    private EmployeeExceptionList(String errorCode, String message) {
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
