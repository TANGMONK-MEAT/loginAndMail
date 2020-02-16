package com.ml.dao;

import com.ml.pojo.User;

/**
 * @author ZWL
 * @version : 1.0
 * @date : 2020/2/14 19:30
 */
public interface UserDao {

    /**
     * 根据id获取用户信息
     * @param id 用户id
     * @return User
     */
    public User getUserById(int id);

    /**
     * 根据用户id修改用户信息
     * @param user 用户id
     * @return User
     */
    public int updateUserById(User user);

    /**
     * 插入在User表中插入用户数据
     * @param user 用户信息
     * @return 影响行数
     */
    public int insert(User user);

    /**
     * 根据用户的id删除用户信息
     * @param id 用户的id
     * @return User
     */
    public int deleteUserById(int id);

    /**
     * 查看用户是否存在
     * @param email
     * @return user
     */
    public boolean isExist(String email);

    /**
     * 修改用户的激活状态
     * @param status 用户的激活状态
     * @param code 用户的激活码
     * @return 影响行数
     */
    public int updateStatus(byte status,String code);

    /**
     * 根据Email查询用户
     * @param email
     * @return user
     */
    public User findUserByEmail(String email);

    /**
     * 根据email和password查询用户
     * @param email 用户的邮箱
     * @param password 用户的密码
     * @return user
     */
    public User findUserByEmailAndPassword(String email,String password);

}
