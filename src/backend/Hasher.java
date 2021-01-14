package backend;
import java.security.MessageDigest;

public class Hasher {
	public static String toMD5(String plainText) {
		String hashedPassword = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			hashedPassword = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hashedPassword;
	}
}
