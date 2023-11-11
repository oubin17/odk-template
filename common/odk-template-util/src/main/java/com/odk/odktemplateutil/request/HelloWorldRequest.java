package com.odk.odktemplateutil.request;

import com.odk.base.dto.request.BaseRequest;

/**
 * HelloWorldRequest
 *
 * @description:
 * @version: 1.0
 * @author: oubin on 2023/11/10
 */
public class HelloWorldRequest extends BaseRequest {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
