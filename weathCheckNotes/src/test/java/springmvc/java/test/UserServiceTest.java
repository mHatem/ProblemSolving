package springmvc.java.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import springmvc.java.config.WebConfig;
import springmvc.java.domain.User;
import springmvc.java.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={WebConfig.class}, loader=AnnotationConfigWebContextLoader.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testUserService() {
		User newUser = new User();
		newUser.setEmail("Ahmed@gmail.com");
		newUser.setName("Amed");
		newUser.setMobileNumber("01112321");
		newUser.setPassword("1234");
		newUser.setType(0);	
		userService.saveUser(newUser);
		
		User user = userService.getUserbyEmail("Ahmed@gmail.com");
		assertTrue(user != null);
		
		userService.deleteUser(user.getId());
		
		user = userService.getUserbyEmail("Ahmed@gmail.com");
		assertTrue(user == null);
			
	}

}
