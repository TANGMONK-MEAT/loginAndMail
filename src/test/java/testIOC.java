import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther:zwl
 * @Version: 1.0
 * @create: 2020/2/14 21:42
 */
public class testIOC {
    @Test
    public void test01(){

        ApplicationContext ioc = new ClassPathXmlApplicationContext("springMVC.xml");
        System.out.println(ioc.getBean("userController"));
    }
}
