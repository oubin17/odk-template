package com.odk.odk.template.service;

import com.odk.base.vo.response.ServiceResponse;
import com.odk.odktemplateutil.dto.HelloWorldDto;

/**
 * HelloWorldService
 *
 * @description:
 * @version: 1.0
 * @author: oubin on 2023/11/10
 */
public interface HelloWorldService {

    String helloWorld(HelloWorldDto dto);
}
