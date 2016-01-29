import com.epmeeting.dao.UserDao;
import com.epmeeting.module.EpmUser;
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
        user.setUserType((short)1);
        user.setUserName("zhangsi@bainainfo.com");
        user.setRoleIds("1,");
        user.setRealName("张思");
        user.setAvatar("http://img1.imgtn.bdimg.com/it/u=363281080,427001469&fm=21&gp=0.jpg");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddd");
        try {
            user.setBirthday(sdf.parse("1985-03-12"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setPasswdMd5("asdfg");
        int result = dao.add(user);
        System.out.println("save user finished, result = " + result);
    }

    @Test
    public void testGet() {
        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmUser> users = dao.get("zhangsi@bainainfo.com");
        for(EpmUser user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testList() {
        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmUser> users = dao.list(1, 10);
        for(EpmUser user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testDelete() {
        UserDao dao = (UserDao)c.getBean("userDao");
        int result = dao.delete(1);
        System.out.println("delete result : " + result);
        testList();
    }
}
