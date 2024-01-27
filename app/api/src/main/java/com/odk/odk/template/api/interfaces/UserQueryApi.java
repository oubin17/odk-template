package com.odk.odk.template.api.interfaces;

import com.odk.base.vo.response.ServiceResponse;
import com.odk.odk.template.api.request.UserQueryRequest;
import com.odk.odk.template.domain.entity.UserEntity;

/**
 * UserQueryApi
 *
 * @description:
 * @version: 1.0
 * @author: oubin on 2024/1/18
 */
public interface UserQueryApi {

    /**
     * 根据userId查询对象
     *
     * @param userId
     * @return
     */
    ServiceResponse<UserEntity> queryUserByUserId(String userId);

    /**
     * 根据loginId查询对象
     *
     * @param userQueryRequest
     * @return
     */
    ServiceResponse<UserEntity> queryUserByLoginId(UserQueryRequest userQueryRequest);


}
