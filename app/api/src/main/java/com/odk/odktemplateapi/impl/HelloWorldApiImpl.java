package com.odk.odktemplateapi.impl;

import com.odk.odktemplateapi.HelloWorldApi;
import com.odk.odktemplateservice.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * HelloWorldTemplateImpl
 *
 * @description:
 * @version: 1.0
 * @author: oubin on 2023/11/10
 */
@Service
public class HelloWorldApiImpl implements HelloWorldApi {

    @Autowired
    private HelloWorldService helloWorldService;

    @Override
    public String helloWorld() {
        return helloWorldService.helloWorld();
    }
}
