package com.enes.oauth2.google.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public Map<String, Object> getHome(Principal principal){
       return ((OAuth2AuthenticationToken) principal).getPrincipal().getAttributes();
    }
}
