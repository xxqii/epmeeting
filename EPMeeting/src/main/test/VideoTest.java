import com.epmeeting.dao.VideoDao;
import com.epmeeting.module.EpmVideo;
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
public class VideoTest {
    VideoDao dao;
    @Before
    public void before() {
        ApplicationContext c = new ClassPathXmlApplicationContext("spring.xml");
        dao = (VideoDao)c.getBean("videoDao");
    }

    @Test
    public void testAdd() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        System.out.println(dao.getClass().getCanonicalName());
        EpmVideo video = new EpmVideo();
        video.setVideoNumber(22);
        video.setUserId(222);
        video.setExpertId("0001");
        video.setMeetingId(2222);
        video.setVideo("\n" +
                "习近平，男，汉族，1953年6月生，陕西富平人，1969年1月参加工作，1974年1月加入中国共产党，清华大学人文社会学院马克思主义理论与思想政治教育专业毕业，在职研究生学历，法学博士学位。\n" +
                "现任中国共产党中央委员会总书记，中共中央军事委员会主席，中华人民共和国主席，中华人民共和国中央军事委员会主席。\n");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddd hh时mm分ss秒");
        try {
            video.setVideoBegin(sdf.parse("2016-01-29 19时51分32秒"));
            video.setVideoEnd(sdf.parse("2016-01-29 19时52分32秒"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
       video.setVideoSzie("500MB");
        int result = dao.add(video);
        System.out.println("save video finished, result = " + result);
    }

    @Test
    public void testGet() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmVideo> videos = dao.get(11);
        for(EpmVideo video : videos) {
            System.out.println(video);
        }
    }

    @Test
    public void testList() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmVideo> videos = dao.list(1, 10);
        for(EpmVideo video : videos) {
            System.out.println(video);
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
