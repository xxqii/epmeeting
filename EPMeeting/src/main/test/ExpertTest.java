import com.epmeeting.dao.ExpertDao;
import com.epmeeting.module.EpmExpert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by chqi on 2016/1/27.
 */
public class ExpertTest {
    ExpertDao dao;
    @Before
    public void before() {
        ApplicationContext c = new ClassPathXmlApplicationContext("spring.xml");
        dao = (ExpertDao)c.getBean("expertDao");
    }

    @Test
    public void testAdd() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        System.out.println(dao.getClass().getCanonicalName());
        EpmExpert expert = new EpmExpert();
        expert.setExpertNumber("0001");
        expert.setExpertName("张宏浩");
        expert.setExpertAchievement("大学生标兵");
        expert.setExpertEducation("本科");
        expert.setAvatar("http://img1.imgtn.bdimg.com/it/u=363281080,427001469&fm=21&gp=0.jpg");
        expert.setSex((short) 0);
        expert.setExpertDegree("学士");
        expert.setExpertEmail("296423@qq.com");
        expert.setQQ(296423);
        expert.setExpertIntroduction("\n" +
                "习近平，男，汉族，1953年6月生，陕西富平人，1969年1月参加工作，1974年1月加入中国共产党，清华大学人文社会学院马克思主义理论与思想政治教育专业毕业，在职研究生学历，法学博士学位。\n" +
                "现任中国共产党中央委员会总书记，中共中央军事委员会主席，中华人民共和国主席，中华人民共和国中央军事委员会主席。\n");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddd");
        try {
            expert.setBirthday(sdf.parse("1994-07-20"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int result = dao.add(expert);
        System.out.println("save expert finished, result = " + result);
    }
    @Test
    public void testGet() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmExpert> experts = dao.get("张宏浩");
        for(EpmExpert expert : experts) {
            System.out.println(expert);
        }
    }

    @Test
    public void testList() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmExpert> experts = dao.list(1, 10);
        for(EpmExpert expert : experts) {
            System.out.println(expert);
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
