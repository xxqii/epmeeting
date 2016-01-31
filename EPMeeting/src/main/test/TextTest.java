import com.epmeeting.dao.TextDao;
import com.epmeeting.module.EpmText;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by 草帽boy on 2016/1/29.
 */
public class TextTest {
    TextDao dao;
    @Before
    public void before() {
        ApplicationContext c = new ClassPathXmlApplicationContext("spring.xml");
        dao = (TextDao)c.getBean("textDao");
    }

    @Test
    public void testAdd() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        System.out.println(dao.getClass().getCanonicalName());
        EpmText text =new EpmText();
        text.setText_number("v0001");
        text.setText_expertid(1222);
        text.setText_meetingid(132131);
        text.setText_userid(131231);
        text.setText_content("sfsafdafasf");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddd");
        try {
            text.setText_uploadtime(sdf.parse("1985-03-12"));
        }catch (ParseException e){
            e.printStackTrace();
        }
        int result = dao.addtest(text);
        System.out.println("save user finished, result = " + result);
    }
    @Test
    public void testList(){
        List<EpmText> users = dao.listtest(1,10);
        for(EpmText user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testget(){
        List<EpmText> users = dao.gettext("v0001");
        for(EpmText user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testdel(){
        int result  = dao.deltest(1);
        System.out.println("delete result : " + result);
    }
}
