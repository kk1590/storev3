package online.store.shop.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author BigData
 */
@RequestMapping("login")
@RestController
public class LoginController {

    @RequestMapping("getLoginUser")
    public Map getLoginUser(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, String> loginUser = new HashMap<>();
        loginUser.put("loginUserName",name);
        return loginUser;
    }
}
