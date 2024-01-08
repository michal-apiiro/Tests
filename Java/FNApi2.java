package javaxs;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ExceptionHandler;

@PostMapping(path = "/SpoofCookie/login")
@ResponseBody
@ExceptionHandler(UnsatisfiedServletRequestParameterException.class)
public class login(
    @RequestParam String username,
    @RequestParam String password,
    @CookieValue(value = COOKIE_NAME, required = false) String cookieValue,
    HttpServletResponse response) {

    if (StringUtils.isEmpty(cookieValue)) {
        return credentialsLoginFlow(username, password, response);
    } else {
        return cookieLoginFlow(cookieValue);
    }
  }