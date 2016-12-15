package com.jpmorgan.rest.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAPI {

	@RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
