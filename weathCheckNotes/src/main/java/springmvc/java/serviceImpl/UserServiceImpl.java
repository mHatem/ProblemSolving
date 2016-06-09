package springmvc.java.serviceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springmvc.java.dao.UserDAO;
import springmvc.java.domain.User;
import springmvc.java.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class); 
	
	@Autowired
	private UserDAO userDao;
	
	@Override
	public void saveUser(User user){
		logger.debug("UserServiceImpl : saveUser Called");
		userDao.save(user);


	}

	@Override
	public void updateUser(User user) {
		logger.debug("UserServiceImpl : updateUser Called");
		userDao.save(user);
	}

	@Override
	public void deleteUser(Long userId) {
		logger.debug("UserServiceImpl : deleteUser Called");
		userDao.delete(userId);
	}

	@Override
	public User getUserbyId(Long id) {
		
		return userDao.findOne(id);
	}

	@Override
	public User getUserbyEmail(String email) {
		return userDao.findUserByEmail(email);
	}

}
