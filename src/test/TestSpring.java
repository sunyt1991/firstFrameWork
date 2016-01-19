package test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import business.system.service.AdminService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:resource/spring.xml","classpath:resource/spring-hibernate.xml" })
public class TestSpring {

	private static final Logger logger = Logger.getLogger(TestSpring.class);
	
	@Autowired
	private AdminService adminService;
	
	@Test
	public void test1() {
		//Admin admin = new Admin();
		//DataGrid datagrid = adminService.datagrid(admin);
		//System.out.println(datagrid.getTotal());
	}
}
