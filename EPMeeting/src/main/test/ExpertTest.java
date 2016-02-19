import com.epmeeting.dao.ExpertDao;
import com.epmeeting.module.EpmExpert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by chqi on 2016/1/27.
 */
public class ExpertTest {
    ExpertDao dao;
    @Before
    public void before() {
        ApplicationContext c = new ClassPathXmlApplicationContext("spring.xml");
        dao = (ExpertDao)c.getBean("expertDao");
    }


    @Test
    public void testGet() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmExpert> experts = dao.get("张宏浩");
        for(EpmExpert expert : experts) {
            System.out.println(expert);
        }
    }
}
