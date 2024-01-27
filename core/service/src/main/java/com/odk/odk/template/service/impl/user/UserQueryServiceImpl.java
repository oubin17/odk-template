package com.odk.odk.template.service.impl.user;

import com.odk.odk.template.domain.entity.UserEntity;
import com.odk.odk.template.domain.impl.UserRepository;
import com.odk.odk.template.service.UserQueryService;
import com.odk.odktemplateutil.dto.UserQueryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 *
 * @description:
 * @version: 1.0
 * @author: oubin on 2024/1/18
 */
@Service
public class UserQueryServiceImpl implements UserQueryService {

    private UserRepository userRepository;

    @Override
    public UserEntity queryUserByUserId(String userId) {
        return userRepository.queryByUserId(userId);
    }

    @Override
    public UserEntity queryUserByLoginId(UserQueryDTO userQueryDTO) {
        return userRepository.queryByAccessToken(userQueryDTO.getLoginType(), userQueryDTO.getLoginId());
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
