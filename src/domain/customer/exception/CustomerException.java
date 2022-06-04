package domain.customer.exception;

import global.exception.ApplicationException;

public abstract class CustomerException extends ApplicationException {
    protected CustomerException(String errorCode, String message) {
        super(errorCode, message);
    }
}
