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
}
