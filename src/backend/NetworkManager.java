package backend;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetworkManager {
	public static String getMac() {
		// TODO Auto-generated method stub
		String sMac = "";
		try {
			Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
			NetworkInterface net;
			while (nets.hasMoreElements()) {
				net = nets.nextElement();
				if (net.getName().equals("wlan0")) {
					byte[] mac = net.getHardwareAddress();
					if (mac != null) {
						for (int i = 0; i < mac.length; i++) {
							sMac += String.format("%02X%s", mac[i], (i < mac.length - 1) ? ":" : "");
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sMac;
	}

}
