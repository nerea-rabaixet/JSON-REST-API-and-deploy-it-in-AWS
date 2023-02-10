package upf.at.s4.message;


import java.util.List;

public class Users {
	private List<User> users;

	public Users(List<User> users) {
		super();
		this.setUsers(users);
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void add(User user) {
		users.add(user);
	}
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		String st = null;
		for (User user : users) {
			st = st + user.toString();
		}
		return st;
	}
	
	


	
}