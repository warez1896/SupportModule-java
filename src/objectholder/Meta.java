package objectholder;

import java.awt.Font;

public class Meta {
	public static final Font STD_FONT = new Font("SansSerif", Font.PLAIN, 15);
	public static final Font LARGE_FONT = new Font("SansSerif", Font.PLAIN, 18);
	public static User user;
	public static User getUser() {
		return user;
	}
	public static void setUser(User user) {
		Meta.user = user;
	}
}
