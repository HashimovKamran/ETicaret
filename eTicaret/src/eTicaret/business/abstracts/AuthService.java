package eTicaret.business.abstracts;

import eTicaret.entities.concretes.User;

public interface AuthService {
	boolean validate(User user);

	boolean login(User user);
}
