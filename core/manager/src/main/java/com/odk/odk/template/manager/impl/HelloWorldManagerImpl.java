package com.odk.odk.template.manager.impl;

import com.odk.odk.template.manager.HelloWorldManager;
import org.springframework.stereotype.Service;

/**
 * HelloWorldManagerImpl
 *
 * @description:
 * @version: 1.0
 * @author: oubin on 2023/11/10
 */
@Service
public class HelloWorldManagerImpl implements HelloWorldManager {

    private static final String HELLO_WORLD = "Hello World";

    @Override
    public String helloWorld() {
        return HELLO_WORLD;
    }
}
