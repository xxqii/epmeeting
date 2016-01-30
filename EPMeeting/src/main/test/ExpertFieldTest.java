import com.epmeeting.dao.ExpertFieldDao;
import com.epmeeting.module.ExpertField;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by 张宏浩 on 2016/1/29.
 */
public class ExpertFieldTest {
    ExpertFieldDao dao;
    @Before
    public void before() {
        ApplicationContext c = new ClassPathXmlApplicationContext("spring.xml");
        dao = (ExpertFieldDao)c.getBean("expertFieldDao");
    }

    @Test
    public void testAdd() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        System.out.println(dao.getClass().getCanonicalName());
        ExpertField expertField = new ExpertField();
        expertField.setExpertId("0002");
        expertField.setFieldId(3);
        expertField.setOperatorName("张宏浩");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddd hh时mm分ss秒");
        try {
            expertField.setOperateTime(sdf.parse("1985-03-12 18时05分32秒"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int result = dao.add(expertField);
        System.out.println("save expertField finished, result = " + result);
    }

    @Test
    public void testGet() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<ExpertField> expertFields = dao.get("0001");
        for(ExpertField expertField : expertFields) {
            System.out.println(expertField);
        }
    }

    @Test
    public void testList() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<ExpertField> expertFields = dao.list(1, 10);
        for(ExpertField expertField : expertFields) {
            System.out.println(expertField);
        }
    }

    @Test
    public void testDelete() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        int result = dao.delete(1);
        System.out.println("delete result : " + result);
        testList();
    }
}
