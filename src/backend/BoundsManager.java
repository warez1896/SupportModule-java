package backend;

import java.awt.Dimension;
import java.awt.Toolkit;

public class BoundsManager {
	public static int[] getCenter(int width, int height) {
		int[] bounds = new int[4];
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		bounds[0] = (dimension.width - width) / 2;
		bounds[1] = (dimension.height - height) / 2;
		bounds[2] = width;
		bounds[3] = height;
		return bounds;
	}
}
