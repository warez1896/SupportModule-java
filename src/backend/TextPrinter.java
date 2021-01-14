package backend;
import java.io.File;
import java.io.PrintStream;

public class TextPrinter {
	public static void print(String fileName, String output) {
		try {
			File file = new File(createDirs("verbose"), fileName);
			PrintStream ps = new PrintStream(file);
			ps.println(output);
			ps.flush();
			ps.close();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	public static void print(String fileName, Exception e) {
		try {
			File file = new File(createDirs("error"), fileName);
			PrintStream ps = new PrintStream(file);
			e.printStackTrace(ps);
			ps.flush();
			ps.close();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	private static File createDirs(String subFolder) {
		File file = new File("output");
		file.mkdir();
		File subFile = new File(file, subFolder);
		subFile.mkdir();
		return subFile;
	}
}