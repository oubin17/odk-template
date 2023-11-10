package com.odk.odktemplateweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorldController
 *
 * @description:
 * @version: 1.0
 * @author: oubin on 2023/11/10
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    private static final String HELLO_WORLD = "Hello World";

    @GetMapping
    public String helloWorld() {
        return HELLO_WORLD;
    }
}
