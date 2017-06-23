package com.huangting.electricity.service;

import com.huangting.electricity.dto.Result;

/**
 * Created by huangting on 2017/6/20.
 */
public interface BaseService {

    /**
     * 系统成员统一登录的入口
     * @param memberType 系统成员类型
     * @param object 系统成员实例
     */
    public Result<String> login(Class<?> memberType, Object object);

}
