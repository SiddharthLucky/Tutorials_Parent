package trng.io;

import java.io.File;
import java.io.IOException;

public class FileUsage {

	public static void main(String[] args) throws IOException {
		File file = new File("c:/temp/test.txt");
		if (file.exists()) {
			System.out.println("File already exists");
		} else {
			file.createNewFile();
		}
		
		System.out.println("isFile : " + file.isFile());
	}

}
