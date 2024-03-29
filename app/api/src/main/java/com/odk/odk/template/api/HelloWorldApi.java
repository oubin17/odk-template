package com.odk.odk.template.api;

import com.odk.base.vo.response.ServiceResponse;
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

    ServiceResponse<HelloWorldResponse> helloWorld(HelloWorldRequest helloWorldRequest);

}
