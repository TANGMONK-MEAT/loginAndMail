package com.ml.controller;

import com.ml.pojo.ResultInfo;
import com.ml.pojo.User;
import com.ml.service.UserService;
import com.ml.utils.CheckCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ZWL
 * @Version: 1.0
 * @create: 2020/2/14 13:45
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取生成验证码显示到界面
     * @param request
     * @param response
     */
    @RequestMapping(value="/checkCode")
    public void checkCode(HttpServletRequest request, HttpServletResponse response) {
        //设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        try {
            //输出图片方法
            CheckCodeUtil.getCheckCode(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册
     * @param user 注册的用户
     * @return ResultInfo
     */
    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResultInfo add(@RequestBody User user, HttpSession session) {
        //响应的信息对象
        ResultInfo info = new ResultInfo();
        //注册
        return userService.register(user, session,info);
    }

    /**
     * 激活账号
     * @param code 激活码
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/active/{code}")
    public String activeUser(@PathVariable("code") String code){
        return userService.activeUser(code);
    }

    /**
     * 登陆验证
     * @param user
     * @param session
     * @return ResultInfo
     */
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResultInfo loginCheck(@RequestBody User user,HttpSession session){
        //验证
        return userService.loginCheck(user, session);
    }

    /**
     *
     */
}
