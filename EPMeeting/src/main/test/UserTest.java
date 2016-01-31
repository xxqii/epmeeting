import com.epmeeting.dao.UserDao;
import com.epmeeting.module.EpmUser;
import com.epmeeting.utils.MD5Utils;
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
public class UserTest {
    private ApplicationContext c;
    @Before
    public void before() {
        c = new ClassPathXmlApplicationContext("spring.xml");
    }

    @Test
    public void testAdd() {
        UserDao dao = (UserDao)c.getBean("userDao");
        System.out.println(dao.getClass().getCanonicalName());
        EpmUser user = new EpmUser();
        user.setUserType((short)0);
        user.setEmail("xxqi1229@126.com");
        user.setPasswdMd5(MD5Utils.encrypt("123456"));
        user.setRealName("祁超");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            user.setBirthday(sdf.parse("1988-12-29"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setMobile("186109761116");
        user.setTelphone("027-85851234");
        user.setQq("1056250853");
        user.setAvatar("http://hdn.xnimg.cn/photos/hdn521/20110922/0015/h_large_GNDz_3c6200005ddd2f75.jpg");
        user.setWorkunit("百纳信息技术有限公司");
        int result = dao.add(user);
        System.out.println("save user finished, result = " + result);
    }

    @Test
    public void testGet() {
        UserDao dao = (UserDao)c.getBean("userDao");
        EpmUser user = dao.get("xxqi1229@126.com");
        System.out.println(user);
    }

    @Test
    public void testDelete() {
        UserDao dao = (UserDao)c.getBean("userDao");
        int result = dao.delete(1);
        System.out.println("delete result : " + result);
    }
}
