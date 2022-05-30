package global.exception;

public abstract class ApplicationException {
    final String errorCode;
    final String message;

    public ApplicationException(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
        System.out.println("에러코드: "+ errorCode +" \n"+ message);
    }
}
