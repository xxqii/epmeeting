import com.epmeeting.dao.MeetingDao;
import com.epmeeting.module.EpmMeeting;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Administrator on 2016/1/30.
 */
public class MeetingTest {

    MeetingDao dao;
    @Before
    public void before() {
        ApplicationContext c = new ClassPathXmlApplicationContext("spring.xml");
        dao = (MeetingDao)c.getBean("meetingDao");
    }

    @Test
    public void testAdd() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        System.out.println(dao.getClass().getCanonicalName());
        EpmMeeting meeting = new EpmMeeting();
        meeting.setMeetingNo("001");
        meeting.setMeetingName("南海会议");
        meeting.setEmceeId("0001");
        meeting.setPlace("湖北工业大学");
        meeting.setState(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddd hh时mm分ss秒");
        try {
            meeting.setTimeBegin(sdf.parse("2016-1-30 11时30分28秒"));
            meeting.setTimeEnd(sdf.parse("2016-1-30 12时28分51秒"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        meeting.setSummary("\n" +
                "习近平，男，汉族，1953年6月生，陕西富平人，1969年1月参加工作，1974年1月加入中国共产党，清华大学人文社会学院马克思主义理论与思想政治教育专业毕业，在职研究生学历，法学博士学位。\n" +
                "现任中国共产党中央委员会总书记，中共中央军事委员会主席，中华人民共和国主席，中华人民共和国中央军事委员会主席。\n");
        meeting.setVideoPath("000120");
        int result = dao.add(meeting);
        System.out.println("save meeting finished, result = " + result);
    }
    @Test
    public void testGet() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmMeeting> meetings = dao.get("001");
        for(EpmMeeting meeting : meetings) {
            System.out.println(meeting);
        }
    }

    @Test
    public void testList() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmMeeting> meetings = dao.list(1, 10);
        for(EpmMeeting meeting : meetings) {
            System.out.println(meeting);
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
