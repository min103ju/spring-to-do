package com.security.todo.controller;

import com.security.todo.exception.CustomUserException;
import com.security.todo.exception.enums.ErrorEnum;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    private final String MSG_ATTRIBUTE = "msg";
    private final String CUSTOM_USER_EXCEPTION = "org.springframework.boot.web.servlet.error.DefaultErrorAttributes.ERROR";

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        CustomUserException customException = (CustomUserException) request.getAttribute(CUSTOM_USER_EXCEPTION);

        int value = HttpStatus.NOT_FOUND.value();

        if(status != null) {
            int statusCode = Integer.parseInt(status.toString());
            switch (statusCode) {
                case 404 : //404 Not Found Page
                    mv.addObject(MSG_ATTRIBUTE, ErrorEnum.ERROR_WRONG_PATH.getDesc());
                    break;
                case 500 : //500 Internal Server Error
                    if (customException != null) {
                        mv.addObject(MSG_ATTRIBUTE, customException.getMessage());
                    } else {
                        mv.addObject(MSG_ATTRIBUTE, ErrorEnum.ERROR_INTERNAL_SERVER_ERROR.getDesc());
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + status);
            }
        }
        
        return mv;
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
