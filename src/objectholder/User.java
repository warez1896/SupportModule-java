package objectholder;

public class User {
	int id;
	String name, username, password;

	public User(int id, String name, String username) {
		setId(id);
		setName(name);
		setUsername(username);
	}

	public User(int id, String name) {
		setId(id);
		setName(name);
	}

	public User(int id, String name, String username, String password) {
		setId(id);
		setName(name);
		setUsername(username);
		setPassword(password);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
