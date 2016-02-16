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

}
