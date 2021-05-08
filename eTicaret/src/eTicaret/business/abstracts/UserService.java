package eTicaret.business.abstracts;

import java.util.List;

import eTicaret.entities.concretes.User;

public interface UserService {
	void add(User user);

	void update(User user);

	void delete(User user);

	User get(int id);

	List<User> getAll();

	void login(User user);

	void userVerify(User user, int verificationCode);
}
