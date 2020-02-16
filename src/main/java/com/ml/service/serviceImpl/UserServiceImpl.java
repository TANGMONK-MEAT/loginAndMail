package com.ml.service.serviceImpl;

import com.ml.dao.UserDao;
import com.ml.pojo.ResultInfo;
import com.ml.pojo.User;
import com.ml.service.UserService;
import com.ml.utils.DateUtil;
import com.ml.utils.MailUtils;
import com.ml.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.sound.sampled.Line;

/**
 * @Auther:zwl
 * @Version: 1.0
 * @create: 2020/2/14 19:25
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    /**
     * 添加用户
     *
     * @param user 用户信息
     */
    @Override
    public void save(User user) {
        userDao.insert(user);
    }


    /**
     * 注册用户
     * @param user
     * @return true正常成功;否则注册失败
     */
    @Override
    public ResultInfo register(User user, HttpSession session, ResultInfo info) {
        //获取session中的验证码
        String code = session.getAttribute("checkCode").toString();
        //移除session中的验证码,保证一次性
        session.removeAttribute("checkCode");
        //校验验证码
        if(code != null && code.equalsIgnoreCase(user.getCheckCode())){
            //判断用户是否已经注册
            if(!userDao.isExist(user.getEmail())){
                String nowTime = DateUtil.getNowTime();
                user.setCreate_at(nowTime);//初始化注册时间
                user.setLast_login(nowTime);//初始化最近登陆的时间
                user.setStatus((byte) 0);//初始未激活状态
                user.setPower("100");//初始化信誉分
                String activateID = UuidUtil.getUuid();//随机生成激活码
                user.setCode(activateID);//初始化激活码
                //保存用户
                this.save(user);
                //激活邮件发送
                String content = "<a href='http://localhost:8080/user/active/" + user.getCode() +"'>点击激活[二手交易平台]</a>";
                MailUtils.sendMail(user.getEmail(),content,"激活邮件");
                info.setFlag(true);
                return info;
            }
            info.setErrorMsg("此用户已经注册");
            return info;
        }
        info.setErrorMsg("验证码错误");
        return info;
    }

    /**
     * 激活用户
     */
    @Override
    public String activeUser(String code) {
        int flag = userDao.updateStatus((byte) 1, code);
        String msg = null;
        //用户存在
        if(flag > 0){
            //激活成功
            msg = "激活成功！欢迎<a style='text-align:center;font-weight:bold;height:150px;padding-top:100px;font-size:30px;' href='https://localhost:8080/index'>登录</a>";
        }else{
            //激活失败
            msg = "激活失败！请联系管理员";
        }
        return msg;
    }

    /**
     * 登陆验证
     *
     * @param user
     * @param session
     * @return ResultInfo
     */
    @Override
    public ResultInfo loginCheck(User user, HttpSession session) {
        //定义响应对象
        ResultInfo info = new ResultInfo();
        if(user != null){
            //获取验证码
            String checkCode = user.getCheckCode();
            Object checkCode1 = session.getAttribute("checkCode");
            //移除验证码，保证唯一性
            session.removeAttribute("checkCode");
            //判断验证码
            if( checkCode != null && checkCode1 != null && checkCode.equalsIgnoreCase(checkCode.toString())){
                User user1 = userDao.findUserByEmailAndPassword(user.getEmail(),user.getPassword());
                //判断用户的email和密码
                if( user1 != null){
                    //判断是否激活
                    if(user.getStatus() == 1){
                        //将用户的信息保存到session中
                        session.setAttribute("user",user1);
                    }else{
                        info.setErrorMsg("账号尚未激活");
                    }
                }else {
                    info.setErrorMsg("邮箱或密码错误");
                }
            }else{
                info.setErrorMsg("验证码错误");
            }
        }
        return info;
    }
}
