package test;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.BaseTest;
import com.gale.dao.TeacherDao;
import com.gale.entity.Teacher;
public class TeacherDaoTest extends BaseTest{
	@Autowired
	private TeacherDao teacherDao;
	@Test
	public void testQueryByID() {
		long ID = 1l;
		Teacher teacher = teacherDao.queryByID(ID);
		System.out.println(teacher);
	}
	@Test
	public void testAddTeacher() {
		Teacher t = new Teacher(123l, "Gale");
		teacherDao.addTeacher(t);
	}
}
