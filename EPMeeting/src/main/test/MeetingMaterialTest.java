import com.epmeeting.dao.MeetingMaterialDao;

import com.epmeeting.module.EpmMeetingMaterial;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by ptf on 2016/1/29.
 */
public class MeetingMaterialTest {
    MeetingMaterialDao dao;
    @Before
    public void before() {
        ApplicationContext f = new ClassPathXmlApplicationContext("spring.xml");
        dao = (MeetingMaterialDao)f.getBean("meetingMaterialDao");
    }

    @Test
    public void testAdd() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        System.out.println(dao.getClass().getCanonicalName());
        EpmMeetingMaterial meetingMaterial = new EpmMeetingMaterial();
        meetingMaterial.setMeetingId(1738);
        meetingMaterial.setMaterialId(1850);;
        int result = dao.add(meetingMaterial);
        System.out.println("save meetingissue finished, result = " + result);
    }
    @Test
    public void testGet(){
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmMeetingMaterial> meetingMaterials = dao.get(1738);
        for(EpmMeetingMaterial meetingMaterial : meetingMaterials) {
            System.out.println(meetingMaterial);
        }
    }

    @Test
    public void testList() {
//        UserDao dao = (UserDao)c.getBean("userDao");
        List<EpmMeetingMaterial> meetingMaterials = dao.list(1, 10);
        for(EpmMeetingMaterial meetingMaterial : meetingMaterials) {
            System.out.println(meetingMaterial);
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
