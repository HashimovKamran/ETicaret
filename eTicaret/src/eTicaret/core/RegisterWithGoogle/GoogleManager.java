package eTicaret.core.RegisterWithGoogle;

import eTicaret.business.abstracts.AuthService;
import eTicaret.core.utilities.BusinessRules;
import eTicaret.entities.concretes.User;

public class GoogleManager implements AuthService {

	private AuthService authService;

	public GoogleManager(AuthService authService) {
		super();
		this.authService = authService;
	}

	@Override
	public boolean validate(User user) {
		boolean result = authService.validate(user);
		if (result != true) {
			return false;
		}
		System.out.println(user.getFirstName() + " " + user.getLastName() + " kişisi Google ile kayıt olundu!");
		return true;
	}

	@Override
	public boolean login(User user) {
		boolean result = BusinessRules.Run(checkEMailAndPassword(user));
		if (result) {
			System.out.println(user.getFirstName() + " " + user.getLastName() + " kişisi Google ile oturum açdı!");
			return result;
		}
		return false;
	}

	private boolean checkEMailAndPassword(User user) {
		if (user.geteMail() == null || user.getPassword() == null) {
			System.out.println("Kullanıcı adı veya parola yanlıştır!");
			return false;
		}
		return true;
	}

}
