package com.ehi.user.service;

import com.ehi.base.service.inter.user.UserService;

/**
 * time   : 2018/12/03
 *
 * @author : xiaojinzi 30212
 */
public class UserServiceImpl implements UserService {

    /**
     * 写 demo 就随便弄个值了
     */
    public static boolean isLogin = false;

    @Override
    public boolean isLogin() {
        return isLogin;
    }

    @Override
    public void loginOut() {
        isLogin = false;
    }

}