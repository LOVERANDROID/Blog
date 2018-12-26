package com.blog.service.impl;

public interface LoginServiceI {
    /**
     * 检查用户名
     * @param username
     * @return
     */
    boolean checkUserName(String username);

    /**
     * 检查密码
     * @param password
     * @return
     */
    boolean checkPassword(String password);

    /**
     * 检查用户
     * @param username
     * @param password
     * @return
     */
    boolean chechUser(String username, String password);

}
