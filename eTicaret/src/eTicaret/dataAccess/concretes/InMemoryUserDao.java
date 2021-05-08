package eTicaret.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTicaret.dataAccess.abstracts.UserDao;
import eTicaret.entities.concretes.User;

public class InMemoryUserDao implements UserDao {

	private List<User> userArrayList = new ArrayList<User>();

	public InMemoryUserDao() {
		System.out.println("==================== Kullanıcılar ====================");
		User user1 = new User(1, "Kamran", "Hashimov", "email@gmail.com", "19khKH#");
		User user2 = new User(2, "Engin", "Demirog", "engindemirog34@gmail.com", "123edED@");

		userArrayList.add(user1);
		userArrayList.add(user2);
	}

	@Override
	public void add(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName() + " kişisi kayıt edildi!");
	}

	@Override
	public void update(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName() + " kişisinin kayıtı güncellendi!");

	}

	@Override
	public void delete(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName() + " kişisinin kayıtı silindi!");

	}

	@Override
	public User get(int id) {
		User user = userArrayList.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
		System.out.println("Kullanıcı adı: " + user.getFirstName());
		return user;
	}

	@Override
	public List<User> getAll() {
		for (User user : userArrayList) {
			System.out.println(user.getFirstName());
		}
		System.out.println("================================");
		return this.userArrayList;
	}

	@Override
	public void login(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName() + " kişisi oturum açdı!");
	}

}
