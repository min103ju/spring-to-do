package com.security.todo.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Component
public class SigninFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private final String LOGIN_FAIL_MSG = "아이디와 패스워드를 확인해주시기 바랍니다.";

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        setDefaultFailureUrl("/?error=true&errorMsg=" + URLEncoder.encode(LOGIN_FAIL_MSG, "UTF-8"));

        super.onAuthenticationFailure(request, response, exception);
    }
}
