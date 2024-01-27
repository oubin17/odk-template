package com.odk.odk.template.service.impl;

import com.odk.base.exception.AssertUtil;
import com.odk.base.exception.BizErrorCode;
import com.odk.odk.template.domain.domain.UserBase;
import com.odk.odk.template.domain.impl.UserRepository;
import com.odk.odk.template.manager.HelloWorldManager;
import com.odk.odk.template.service.HelloWorldService;
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
    private UserRepository userRepository;

    @Override
    public String helloWorld(HelloWorldDto dto) {
        UserBase one;
        one = userRepository.findOne(Integer.valueOf(dto.getName()));
        AssertUtil.notNull(one, BizErrorCode.PARAM_ILLEGAL, "参数非法");
        dto.setName("Hello World: " + one.getUserName());
        return dto.getName();
    }
}
