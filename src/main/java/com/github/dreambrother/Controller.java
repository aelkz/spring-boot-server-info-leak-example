package com.github.dreambrother;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/foo")
    public String foo() {
        return "bar";
    }

    @RequestMapping("/exception")
    public String error() {
        throw new RuntimeException("Error test");
    }
}
