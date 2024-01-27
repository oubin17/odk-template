package com.odk.odk.template.service;


import com.odk.odktemplateutil.dto.UserLoginDTO;
import com.odk.odktemplateutil.vo.UserLoginVO;

/**
 * UserLoginService
 *
 * @description:
 * @version: 1.0
 * @author: oubin on 2024/1/19
 */
public interface UserLoginService {

    /**
     * 用户登录
     *
     * @param userLoginRequest
     * @return
     */
    UserLoginVO userLogin(UserLoginDTO userLoginDTO);
}
