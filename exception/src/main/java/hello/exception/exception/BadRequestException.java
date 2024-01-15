package hello.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;


@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "error.bad") // 400 Error
public class BadRequestException extends RuntimeException {

}
