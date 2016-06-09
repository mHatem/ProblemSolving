package springmvc.java.service;

import springmvc.java.domain.User;

public interface UserService {

	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(Long userId);
	public User getUserbyId(Long id);
	public User getUserbyEmail(String email);
}
