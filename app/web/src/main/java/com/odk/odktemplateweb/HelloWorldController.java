package com.odk.odktemplateweb;

import com.odk.base.dto.response.ServiceResponse;
import com.odk.odktemplateapi.HelloWorldApi;
import com.odk.odktemplateutil.request.HelloWorldRequest;
import com.odk.odktemplateutil.response.HelloWorldResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorldController
 *
 * @description:
 * @version: 1.0
 * @author: oubin on 2023/11/10
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {


    private final HelloWorldApi helloWorldApi;

    public HelloWorldController(HelloWorldApi helloWorldApi) {
        this.helloWorldApi = helloWorldApi;
    }

    @PostMapping
    public ServiceResponse<HelloWorldResponse> helloWorld(@RequestBody HelloWorldRequest helloWorldRequest) {
        return helloWorldApi.helloWorld(helloWorldRequest);
    }
}
