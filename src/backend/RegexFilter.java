package backend;
import java.util.regex.Pattern;

public class RegexFilter {
	public static boolean checkIPValidity(String ip) {
		Pattern pattern = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
		return (pattern.matcher(ip).matches() || ip.equals("localhost"));
	}
	
	public static boolean checkAlphaNumericOnly(String text) {
		Pattern pattern = Pattern.compile("([A-Za-z0-9])\\w+");
		return (pattern.matcher(text).matches());
	}
	
	public static boolean checkMAC(String mac) {
		Pattern pattern = Pattern.compile("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$");
		return (pattern.matcher(mac).matches());
	}
}
