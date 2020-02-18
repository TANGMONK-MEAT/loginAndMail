package com.ml.service;

import com.ml.pojo.ResultInfo;
import com.ml.pojo.User;

import javax.servlet.http.HttpSession;

/**
 * @author ZWL
 * @Version: 1.0
 * @create: 2020/2/14 19:26
 */
public interface UserService {

    /**
     * 添加用户
     * @param user 用户信息
     */
    public void save(User user);


    /**
     * 注册用户
     * @return true正常成功;否则注册失败
     */
    public ResultInfo register(User user, HttpSession session, ResultInfo info);

    /**
     * 激活用户
     * @param code 激活码
     */
    public String activeUser(String code);

    /**
     * 登陆验证
     * @param user
     * @param session
     * @return ResultInfo
     */
    ResultInfo loginCheck(User user, HttpSession session);
}
