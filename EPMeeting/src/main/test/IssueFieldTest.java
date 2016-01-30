import com.epmeeting.dao.IssueFieldDao;
import com.epmeeting.module.IssueField;
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
public class IssueFieldTest {
    IssueFieldDao dao;

    @Before
    public void before() {
        ApplicationContext c = new ClassPathXmlApplicationContext("spring.xml");
        dao = (IssueFieldDao) c.getBean("issueFieldDao");
    }

    @Test
    public void testAdd() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        System.out.println(dao.getClass().getCanonicalName());
        IssueField user = new IssueField();
        user.setField_id(1);
        user.setIssue_id(1);
        int result = dao.add(user);
        System.out.println("save user finished, result = " + result);
    }

    @Test
    public void testGetbyissueid() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<IssueField> users = dao.getbyissueid(1);
        for (IssueField user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testGetbyfieldid() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<IssueField> users = dao.getbyfieldid(1);
        for (IssueField user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testList() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<IssueField> users = dao.list(1, 10);
        for (IssueField user : users) {
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
