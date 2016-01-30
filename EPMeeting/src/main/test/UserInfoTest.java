import com.epmeeting.dao.UserInfoDao;
import com.epmeeting.dao.impl.UserInfoDaoImpl;
import com.epmeeting.module.EpmUser;
import com.epmeeting.module.EpmUserInfo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by 草帽boy on 2016/1/29.
 */
public class UserInfoTest {
    UserInfoDao dao = new UserInfoDaoImpl();
    @Before
    public void before() {
        ApplicationContext c = new ClassPathXmlApplicationContext("spring.xml");
        dao = (UserInfoDao)c.getBean("userInfoDao");
    }

    @Test
    public void testAdd() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        System.out.println(dao.getClass().getCanonicalName());
        EpmUserInfo useri = new EpmUserInfo(10002,"sd","sds","sds","sdsd","sdfs","sfs","sfsd","sfs");
        int result = dao.addUserInfo(useri);
        System.out.println("save user finished, result = " + result);
    }
    @Test
    public void testdel(){
        int result = dao.del(1);
        System.out.println("delete result : " + result);
        //testList();
    }

    @Test
    public void testGet() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmUserInfo> users = dao.getuserinfo("sd");
        for(EpmUserInfo user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testList() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmUserInfo> users = dao.showuserinfolist(1,10);
        for(EpmUserInfo user : users) {
            System.out.println(user);
        }
    }
}
