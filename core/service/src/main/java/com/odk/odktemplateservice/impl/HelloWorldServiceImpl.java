package com.odk.odktemplateservice.impl;

import com.odk.odktemplatemanager.HelloWorldManager;
import com.odk.odktemplateservice.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * HelloWorldServiceImpl
 *
 * @description:
 * @version: 1.0
 * @author: oubin on 2023/11/10
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Autowired
    private HelloWorldManager helloWorldManager;

    @Override
    public String helloWorld() {
        return helloWorldManager.helloWorld();
    }
}
