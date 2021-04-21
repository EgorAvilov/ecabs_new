package com.itechart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping
public class AuthorizationController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHelloWorld() {
        return "Hello world !";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        return principal;
    }
}
