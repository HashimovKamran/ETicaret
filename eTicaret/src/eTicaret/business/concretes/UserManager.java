package eTicaret.business.concretes;

import java.util.List;

import eTicaret.business.abstracts.AuthService;
import eTicaret.business.abstracts.EMailService;
import eTicaret.business.abstracts.UserService;
import eTicaret.dataAccess.abstracts.UserDao;
import eTicaret.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private EMailService eMailService;
	private AuthService authService;

	public UserManager(UserDao userDao, AuthService authService, EMailService eMailService) {
		super();
		this.eMailService = eMailService;
		this.userDao = userDao;
		this.authService = authService;
	}

	@Override
	public void add(User user) {
		if (authService.validate(user)) {
			userDao.add(user);
			System.out.println("Doğrulama kodu gönderildi! " + eMailService.eMailSend());
			System.out.print("Doğrulama kodunu girin: ");

		} else {
			System.out.println("Hata oluştu! Kullanıcı bilgilerini kontrol edin!");
		}
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public User get(int id) {
		User result = userDao.get(id);
		return result;
	}

	@Override
	public List<User> getAll() {
		List<User> result = userDao.getAll();
		return result;
	}

	@Override
	public void userVerify(User user, int verificationCode) {
		int result = eMailService.eMailSend();
		if (result == verificationCode) {
			System.out.println(user.getFirstName() + " " + user.getLastName() + " kullanıcısı doğrulandı!");
		} else {
			System.out.println("Doğrulama kodunuz yanlış");
		}
	}

	@Override
	public void login(User user) {
		if (authService.login(user)) {
			userDao.login(user);
		}
	}

}
