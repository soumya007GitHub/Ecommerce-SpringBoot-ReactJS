package com.soumya.ecommerce.controller;

import com.soumya.ecommerce.response.APIResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public APIResponse homeControllerHandler(){
        return new APIResponse("Welcome to ecommerce");
    }


}
