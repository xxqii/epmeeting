import com.epmeeting.dao.LogDao;
import com.epmeeting.module.EpmLog;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by zhy on 2016/1/29.
 */
public class LogTest {
    LogDao dao;
    @Before
    public void before() {
        ApplicationContext c = new ClassPathXmlApplicationContext("spring.xml");
        dao = (LogDao)c.getBean("logDao");
    }

    @Test
    public void testAdd() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        System.out.println(dao.getClass().getCanonicalName());
        EpmLog log = new EpmLog();
        log.setCreateIpaddr("127.0.0.1");
        log.setCreateUsername("张宏浩");
        log.setLogType("文本");
        log.setContent("\n" +
                "习近平，男，汉族，1953年6月生，陕西富平人，1969年1月参加工作，1974年1月加入中国共产党，清华大学人文社会学院马克思主义理论与思想政治教育专业毕业，在职研究生学历，法学博士学位。\n" +
                "现任中国共产党中央委员会总书记，中共中央军事委员会主席，中华人民共和国主席，中华人民共和国中央军事委员会主席。\n");
        log.setOperationType("添加专家");
        log.setOperateTable("专家表");
        log.setMemo("\n" +
                "习近平，男，汉族，1953年6月生，陕西富平人，1969年1月参加工作，1974年1月加入中国共产党，清华大学人文社会学院马克思主义理论与思想政治教育专业毕业，在职研究生学历，法学博士学位。\n" +
                "现任中国共产党中央委员会总书记，中共中央军事委员会主席，中华人民共和国主席，中华人民共和国中央军事委员会主席。\n");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddd hh时mm分ss秒");
        try {
            log.setCreateDatetime(sdf.parse("1985-03-12 23时36分23秒"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int result = dao.add(log);
        System.out.println("save user finished, result = " + result);
    }

    @Test
    public void testGet() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmLog> logs = dao.get("专家表");
        for(EpmLog log : logs) {
            System.out.println(log);
        }
    }

    @Test
    public void testList() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmLog> logs = dao.list(1, 10);
        for(EpmLog log : logs) {
            System.out.println(log);
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
