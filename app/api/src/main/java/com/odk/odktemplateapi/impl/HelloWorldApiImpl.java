package com.odk.odktemplateapi.impl;

import com.odk.base.dto.request.BaseRequest;
import com.odk.base.dto.response.ServiceResponse;
import com.odk.base.exception.AssertUtil;
import com.odk.base.exception.BizErrorCode;
import com.odk.odktemplateapi.HelloWorldApi;
import com.odk.odktemplateapi.api.AbstractApiImpl;
import com.odk.odktemplateservice.HelloWorldService;
import com.odk.odktemplateutil.dto.HelloWorldDto;
import com.odk.odktemplateutil.enums.BizScene;
import com.odk.odktemplateutil.request.HelloWorldRequest;
import com.odk.odktemplateutil.response.HelloWorldResponse;
import org.springframework.stereotype.Service;

/**
 * HelloWorldTemplateImpl
 *
 * @description:
 * @version: 1.0
 * @author: oubin on 2023/11/10
 */
@Service
public class HelloWorldApiImpl extends AbstractApiImpl implements HelloWorldApi {

    private final HelloWorldService helloWorldService;

    public HelloWorldApiImpl(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @Override
    public ServiceResponse<HelloWorldResponse> helloWorld(HelloWorldRequest helloWorldRequest) {
        return super.bizProcess(BizScene.HELLO_WORLD, helloWorldRequest, HelloWorldResponse.class, new ApiCallBack<HelloWorldDto, HelloWorldResponse>() {
            @Override
            protected void checkParams(BaseRequest request) {
                super.checkParams(request);
                HelloWorldRequest hello = (HelloWorldRequest) request;
                AssertUtil.notNull(hello.getName(), BizErrorCode.PARAM_ILLEGAL, "request is null.");
            }

            @Override
            protected Object convert(BaseRequest request) {
                HelloWorldRequest hello = (HelloWorldRequest) request;
                HelloWorldDto dto = new HelloWorldDto();
                dto.setName(hello.getName());
                return dto;
            }

            @Override
            protected ServiceResponse<HelloWorldDto> doProcess(Object args) {
                HelloWorldDto dto = (HelloWorldDto) args;
                return helloWorldService.helloWorld(dto);
            }

            @Override
            protected ServiceResponse<HelloWorldResponse> assembleResult(ServiceResponse<HelloWorldDto> apiResult, Class<HelloWorldResponse> resultClazz) throws Throwable {
                ServiceResponse<HelloWorldResponse> helloWorldResponseServiceResponse = super.assembleResult(apiResult, resultClazz);
                HelloWorldDto data = apiResult.getData();
                HelloWorldResponse response = new HelloWorldResponse();
                response.setResult(data.getName());
                helloWorldResponseServiceResponse.setData(response);
                return helloWorldResponseServiceResponse;

            }
        });
    }
}
