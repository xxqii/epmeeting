import com.epmeeting.dao.FieldDao;
import com.epmeeting.dao.MeetingIssueDao;
import com.epmeeting.module.EpmField;
import com.epmeeting.module.EpmMeetingIssue;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by ptf on 2016/1/29.
 */
public class MeetingIssueTest {
    MeetingIssueDao dao;
    @Before
    public void before() {
        ApplicationContext f = new ClassPathXmlApplicationContext("spring.xml");
        dao = (MeetingIssueDao)f.getBean("meetingIssueDao");
    }

    @Test
    public void testAdd() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        System.out.println(dao.getClass().getCanonicalName());
        EpmMeetingIssue meetingIssue = new EpmMeetingIssue();
        meetingIssue.setMeetingId(1738);
        meetingIssue.setIssueId(3525);
        int result = dao.add(meetingIssue);
        System.out.println("save meetingissue finished, result = " + result);
    }
    @Test
    public void testGet(){
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmMeetingIssue> meetingIssues = dao.get(22222);
        for(EpmMeetingIssue meetingIssue : meetingIssues) {
            System.out.println(meetingIssue);
        }
    }

    @Test
    public void testList() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmMeetingIssue> meetingIssues = dao.list(1, 10);
        for(EpmMeetingIssue meetingIssue : meetingIssues) {
            System.out.println(meetingIssue);
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
