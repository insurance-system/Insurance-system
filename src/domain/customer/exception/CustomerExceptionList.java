package domain.customer.exception;

public enum CustomerExceptionList {

    NOCUSTOMER("C0001", "존재하지 않는 회원입니다. 아이디와 비밀번호를 다시 확인해주세요."),
    CHECKMENUNUMBER("C0002","메뉴 번호를 확인해주세요."),
    NOJOINEDINSURANCE("C0003","가입한 보험이 존재하지 않습니다."),
    NOPAYMENTHISTORY("C0004","납부한 보험금 내역이 존재하지 않습니다.");

    private String ErrorCode;
    private String Message;

    private CustomerExceptionList(String errorCode, String message) {
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
