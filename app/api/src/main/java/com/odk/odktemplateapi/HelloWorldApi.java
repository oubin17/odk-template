package com.odk.odktemplateapi;

import com.odk.base.dto.response.ServiceResponse;
import com.odk.odktemplateutil.request.HelloWorldRequest;
import com.odk.odktemplateutil.response.HelloWorldResponse;

/**
 * HelloWorldTemplate
 *
 * @description:
 * @version: 1.0
 * @author: oubin on 2023/11/10
 */
public interface HelloWorldApi {

    public ServiceResponse<HelloWorldResponse> helloWorld(HelloWorldRequest helloWorldRequest);

}
