package quemepongo.Guardarropa;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class GuardarropaNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(GuardarropaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String GuardarropaNotFoundHandler(GuardarropaNotFoundException ex) {
        return ex.getMessage();
    }
}
