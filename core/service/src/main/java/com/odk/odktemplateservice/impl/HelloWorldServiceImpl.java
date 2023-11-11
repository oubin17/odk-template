package com.odk.odktemplateservice.impl;

import com.odk.base.dto.response.ServiceResponse;
import com.odk.odktemplatemanager.HelloWorldManager;
import com.odk.odktemplateservice.HelloWorldService;
import com.odk.odktemplateutil.dto.HelloWorldDto;
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
    public ServiceResponse<HelloWorldDto> helloWorld(HelloWorldDto dto) {
        dto.setName("Hello World: " + dto.getName());
        return ServiceResponse.valueOfSuccess(dto);
    }
}
