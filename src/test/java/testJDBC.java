import com.ml.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Auther:zwl
 * @Version: 1.0
 * @create: 2020/2/15 1:42
 */
public class testJDBC {

    @Test
    public void test01(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ioc.getBean("jdbcTemplate");
        String sql = "SELECT * FROM `user` WHERE email=?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), "2950371251@qq.com");
        System.out.println(user.toString());
    }

    @Test
    public void test02(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ioc.getBean("jdbcTemplate");
        User user = new User("ZWL",
                "123456",
                "15970924595",
                "2950371251@qq.com",
                "100",
                "2020-02-17",
                "2020-02-17",
                (byte) 1,
                "",
                "1111111111111",
                "1");
        String sql = "INSERT INTO `user` VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,null,
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
}
