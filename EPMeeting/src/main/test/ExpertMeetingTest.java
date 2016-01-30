import com.epmeeting.dao.ExpertMeetingDao;
import com.epmeeting.module.ExpertMeeting;
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
public class ExpertMeetingTest {
    ExpertMeetingDao dao;
    @Before
    public void before() {
        ApplicationContext c = new ClassPathXmlApplicationContext("spring.xml");
        dao = (ExpertMeetingDao)c.getBean("expertMeetingDao");
    }
    @Test
    public void testAdd() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        System.out.println(dao.getClass().getCanonicalName());
        ExpertMeeting expertMeeting = new ExpertMeeting();
        expertMeeting.setExpertId("0001");
        expertMeeting.setMeetingId(4);
        expertMeeting.setOperatorName("张宏浩");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddd hh时mm分ss秒");
        try {
            expertMeeting.setOperateTime(sdf.parse("1985-03-12 18时05分32秒"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int result = dao.add(expertMeeting);
        System.out.println("save expertMeeting finished, result = " + result);
    }

    @Test
    public void testGet() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<ExpertMeeting> expertMeetings = dao.get("0001");
        for(ExpertMeeting expertMeeting : expertMeetings) {
            System.out.println(expertMeeting);
        }
    }

    @Test
    public void testList() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<ExpertMeeting> expertMeetings = dao.list(1, 10);
        for(ExpertMeeting expertMeeting : expertMeetings) {
            System.out.println(expertMeeting);
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
