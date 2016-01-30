import com.epmeeting.dao.FieldDao;
import com.epmeeting.module.EpmField;
import com.epmeeting.module.EpmUser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Administrator on 2016/1/29.
 */
public class FieldTest {
    FieldDao dao;
    @Before
    public void before() {
        ApplicationContext c = new ClassPathXmlApplicationContext("spring.xml");
        dao = (FieldDao)c.getBean("fieldDao");
    }

    @Test
    public void testAdd() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        System.out.println(dao.getClass().getCanonicalName());
        EpmField field = new EpmField();
        field.setNumber(11111);
        field.setField_name("dfgdg");
        field.setDescribe("sxcasd");
        field.setFfid(1);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddd");
//        try {
//            user.setBirthday(sdf.parse("1985-03-12"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//
         dao.add(field);
      //  System.out.println("save user finished, result = " + result);
    }
    @Test
    public void testGet() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmField> fields = dao.get("dfgdg");
        for(EpmField field : fields) {
            System.out.println(field);
        }
    }

    @Test
    public void testList() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmField> fields = dao.list(1, 10);
        for(EpmField field : fields) {
            System.out.println(field);
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
