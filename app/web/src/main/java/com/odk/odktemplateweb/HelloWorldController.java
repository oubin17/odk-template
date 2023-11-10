package com.odk.odktemplateweb;

import com.odk.odktemplateapi.HelloWorldApi;
import com.odk.odktemplateweb.request.HelloWorldRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private HelloWorldApi helloWorldTemplate;



    @PostMapping
    public String helloWorld(@RequestBody HelloWorldRequest helloWorldRequest) {
        return helloWorldTemplate.helloWorld();
    }
}
