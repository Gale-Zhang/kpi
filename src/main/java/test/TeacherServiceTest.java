package test;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.gale.service.TeacherService;
import com.gale.entity.Teacher;
import com.gale.service.impl.TeacherServiceImpl;


public class TeacherServiceTest extends BaseTest{
	@Autowired
	private TeacherService teacherService;
	
	private TeacherServiceImpl t = new TeacherServiceImpl();
	
	@Test
	public void testAppoint() throws Exception {
		long ID = 123;
		String name = "Gale";
		Teacher teacher = new Teacher(ID, name);
		teacherService.addTeacher(teacher);
	}
}
