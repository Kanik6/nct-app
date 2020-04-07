package com.ort.ortnct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController
{
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public Authentication login(@RequestParam String userName, String password)
    {
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(userName, password);
        Authentication auth = authenticationManager.authenticate(authReq);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        if(sc.getAuthentication().isAuthenticated())
        {
            return auth;
        }
        return null;
    }


}
//    public void login(HttpServletRequest req, String user, String pass) {
//        UsernamePasswordAuthenticationToken authReq
//                = new UsernamePasswordAuthenticationToken(user, pass);
//        Authentication auth = authManager.authenticate(authReq);
//
//        SecurityContext sc = SecurityContextHolder.getContext();
//        sc.setAuthentication(auth);
//        HttpSession session = req.getSession(true);
//        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
//    }