package eTicaret;

import java.util.Scanner;

import eTicaret.business.abstracts.AuthService;
import eTicaret.business.abstracts.UserService;
import eTicaret.business.concretes.AuthManager;
import eTicaret.business.concretes.EMailManager;
import eTicaret.business.concretes.UserManager;
import eTicaret.core.RegisterWithGoogle.GoogleManager;
import eTicaret.dataAccess.concretes.InMemoryUserDao;
import eTicaret.entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		User user = new User(1, "Kamran", "Hashimov", "email@gmail.com", "12azAZ#");
		UserService userService = new UserManager(new InMemoryUserDao(), new AuthManager(), new EMailManager());

		System.out.println("====================== Kayıt işlemi ======================");
		userService.add(user);
		Scanner verify = new Scanner(System.in);
		int verificationCode = verify.nextInt();
		userService.userVerify(user, verificationCode);

		System.out.println("====================== Oturum açma işlemi ======================");
		userService.login(user);

		System.out.println("====================== Google ile kayıt işlemi ======================");
		AuthService googleManager = new GoogleManager(new AuthManager());
		googleManager.validate(user);

		System.out.println("====================== Google ile oturum açma işlemi ======================");
		googleManager.login(user);
	}

}
