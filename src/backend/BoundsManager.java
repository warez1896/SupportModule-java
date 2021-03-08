package backend;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

public class BoundsManager {

	public static void getCenter(Window window, int width, int height) {
		int[] bounds = new int[4];
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		bounds[0] = (dimension.width - width) / 2;
		bounds[1] = (dimension.height - height) / 2;
		bounds[2] = width;
		bounds[3] = height;
		window.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		window.setMinimumSize(new Dimension(bounds[2], bounds[3]));
	}
}
