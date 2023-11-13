package com.odk.odktemplatedomain.interfaces;

import com.odk.odktemplatedomain.domain.User;

/**
 * IUser
 *
 * @description:
 * @version: 1.0
 * @author: oubin on 2023/11/13
 */
public interface IUser {

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    User findOne(Integer id);

}
