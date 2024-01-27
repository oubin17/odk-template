package com.odk.odk.template.service;


import com.odk.odk.template.domain.entity.UserEntity;
import com.odk.odktemplateutil.dto.UserQueryDTO;

/**
 * UserService
 *
 * @description:
 * @version: 1.0
 * @author: oubin on 2024/1/18
 */
public interface UserQueryService {

    /**
     * 根据 userID查找用户
     *
     * @param userId
     * @return
     */
    UserEntity queryUserByUserId(String userId);

    /**
     * 根据 userID查找用户
     *
     * @param userId
     * @return
     */
    UserEntity queryUserByLoginId(UserQueryDTO userQueryDTO);
}
