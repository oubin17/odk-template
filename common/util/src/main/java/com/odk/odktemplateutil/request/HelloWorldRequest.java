package com.odk.odktemplateutil.request;


import com.odk.base.vo.request.BaseRequest;
import lombok.Data;

/**
 * HelloWorldRequest
 *
 * @description:
 * @version: 1.0
 * @author: oubin on 2023/11/10
 */
@Data
public class HelloWorldRequest extends BaseRequest {

    private String name;

}
