package org.helper.component;

import org.helper.exceptions.ThoughtNotFoundException;
import org.helper.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(ThoughtNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String thoughtNotFoundException(ThoughtNotFoundException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFoundException(UserNotFoundException e) {
        return e.getMessage();
    }
}
