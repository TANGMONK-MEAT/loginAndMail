package com.ml.dao.daoImpl;

import com.ml.dao.UserDao;
import com.ml.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author ZWL
 * @Version: 1.0
 * @create: 2020/2/14 19:32
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据id获取用户信息
     * @param id 用户的id
     * @return User
     */
    @Override
    public User getUserById(int id) {
        return null;
    }

    /**
     * 根据用户id修改用户信息
     *
     * @param user 用户id
     * @return User
     */
    @Override
    public int updateUserById(User user) {
        return 0;
    }

    /**
     * 插入在User表中插入用户数据
     *
     * @param user 用户信息
     * @return 影响行数
     */
    @Override
    public int insert(User user) {
        String sql = "INSERT INTO `user` VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,null,
                user.getUsername(),
                user.getUname(),
                user.getPassword(),
                user.getSex(),
                user.getPhone(),
                user.getEmail(),
                user.getPower(),
                user.getCreate_at(),
                user.getLast_login(),
                user.getStatus(),
                user.getCode());
    }
    /**
     * 根据用户的id删除用户信息
     *
     * @param id 用户的id
     * @return User
     */
    @Override
    public int deleteUserById(int id) {
        return 0;
    }

    /**
     * 根据用户的邮箱查找用户
     *
     * @param email
     * @return user
     */
    @Override
    public boolean isExist(String email) {
        String sql = "SELECT email FROM `user` WHERE email=?";
        try{
            jdbcTemplate.queryForObject(sql, String.class, email);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * 修改用户的激活状态
     *
     * @param status 1状态为激活;0状态为未激活
     * @param code 用户的激活码
     * @return 影响行数
     */
    @Override
    public int updateStatus(byte status,String code) {
        String sql = "UPDATE `user` SET `status`=? WHERE `code`=?";
        return jdbcTemplate.update(sql, status,code);
    }

    /**
     * 根据Email查询用户
     *
     * @param email
     * @return
     */
    @Override
    public User findUserByEmail(String email) {
        User user =null;
        String sql = "select * from user where email=?";
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), email);
        }catch (Exception e){
        }
        return user;
    }

    /**
     * 根据email和password查询用户
     *
     * @param email
     * @param password
     * @return user
     */
    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        User user =null;
        String sql = "select * from user where email=? and password=?";
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), email,password);
        }catch (Exception e){
        }
        return user;
    }

}
