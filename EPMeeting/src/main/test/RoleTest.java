import com.epmeeting.dao.RoleDao;
import com.epmeeting.module.EpmRole;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

/**
 * Created by 草帽boy on 2016/1/29.
 */
public class RoleTest {
    RoleDao dao;
    @Before
    public void before() {
        ApplicationContext c = new ClassPathXmlApplicationContext("spring.xml");
        dao = (RoleDao)c.getBean("roleDao");
    }
    @Test
    public void TestRoleadd(){
        EpmRole role = new EpmRole();
        role.setRole_no("v");
        role.setDesc("sdsd");
        role.setPermissions("fsds");
        int result = dao.add(role);
        System.out.println("save user finished, result = " + result);

    }
    @Test
    public void TestRoleget(){
        List<EpmRole> users = dao.getlistRole("v");
        for(EpmRole user : users) {
            System.out.println(user);
        };

    }
    @Test
    public void TestRolelist(){
        List<EpmRole> users = dao.listRole(1,1);
        for(EpmRole user : users) {
            System.out.println(user);
        };

    }
    @Test
    public void TestRoledel(){
      int result = dao.del(2);
        System.out.println("save user finished, result = " + result);
    }
}
