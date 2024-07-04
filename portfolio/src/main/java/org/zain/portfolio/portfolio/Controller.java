package org.zain.portfolio.portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/get")
    public String doGet(){
        return "Hello World,This Is doGet Method!";
    }
    @PostMapping("/post")
    public String doPost(){
        return "Hello World,This Is doPost Method!";
    }
}
