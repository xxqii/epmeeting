import com.epmeeting.dao.IssueDao;
import com.epmeeting.dao.UserDao;
import com.epmeeting.module.EpmIssue;
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
public class IssueTest {
    IssueDao dao;
    @Before
    public void before() {
        ApplicationContext c = new ClassPathXmlApplicationContext("spring.xml");
        dao = (IssueDao)c.getBean("issueDao");
    }

    @Test
    public void testAdd() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        System.out.println(dao.getClass().getCanonicalName());
        EpmIssue user = new EpmIssue();
        user.setIssue_name("sdfsd");
        user.setMeetingid(1);
        user.setNumber(1);
        user.setIssue_note("adfsfgdf");
        int result = dao.add(user);
        System.out.println("save user finished, result = " + result);
    }
    @Test
    public void testGet() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmIssue> users = dao.get("zhangsi@bainainfo.com");
        for(EpmIssue user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testList() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmIssue> users = dao.list(1, 10);
        for(EpmIssue user : users) {
            System.out.println(user);
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

