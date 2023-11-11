package com.odk.odktemplateservice;

import com.odk.base.dto.response.ServiceResponse;
import com.odk.odktemplateutil.dto.HelloWorldDto;

/**
 * HelloWorldService
 *
 * @description:
 * @version: 1.0
 * @author: oubin on 2023/11/10
 */
public interface HelloWorldService {

    ServiceResponse<HelloWorldDto> helloWorld(HelloWorldDto dto);
}
