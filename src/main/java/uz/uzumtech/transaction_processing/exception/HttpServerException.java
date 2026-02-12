package uz.uzumtech.transaction_processing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import uz.uzumtech.transaction_processing.constant.enums.ErrorType;
import uz.uzumtech.transaction_processing.exception.ApplicationException;

import static uz.uzumtech.transaction_processing.constant.enums.Error.HTTP_SERVICE_ERROR_CODE;

public class HttpServerException extends ApplicationException {

    public HttpServerException(String message, HttpStatusCode status) {
        super(HTTP_SERVICE_ERROR_CODE.getCode(), message, HttpStatus.valueOf(status.value()), ErrorType.EXTERNAL);
    }
}
