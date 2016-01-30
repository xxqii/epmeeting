import com.epmeeting.dao.MaterialDao;
import com.epmeeting.module.EpmMaterial;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by zhy on 2016/1/30.
 */
public class MaterialTest {
    MaterialDao dao;
    @Before
    public void before() {
        ApplicationContext c = new ClassPathXmlApplicationContext("spring.xml");
        dao = (MaterialDao)c.getBean("materialDao");
    }

    @Test
    public void testAdd() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        System.out.println(dao.getClass().getCanonicalName());
        EpmMaterial material = new EpmMaterial();
        material.setMeetingId(11);
        material.setMaterialId(111);
        int result = dao.add(material);
        System.out.println("save user finished, result = " + result);
    }
    @Test
    public void testGet() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmMaterial> materials = dao.get("11");
        for(EpmMaterial material : materials) {
            System.out.println(material);
        }
    }

    @Test
    public void testList() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmMaterial>  materials = dao.list(1, 10);
        for(EpmMaterial material : materials) {
            System.out.println(material);
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
