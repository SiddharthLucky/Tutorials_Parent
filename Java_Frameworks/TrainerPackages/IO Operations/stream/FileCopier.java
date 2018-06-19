package trng.io.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class FileCopier {

	public boolean copy(String sourceFile, String targetFile) throws IOException {
		FileInputStream fileIS = null;
		FileOutputStream fileOS = null;
		BufferedInputStream bufferedIS = null;
		BufferedOutputStream bufferedWriter = null;
		long timeInMilliseconds = 0;
//		File file = new File(sourceFile);
		
		try 
/*			(			
				fileIS = new FileInputStream(file);
				fileOS = new FileOutputStream(targetFile);

				bufferedIS = new BufferedInputStream(fileIS);
				bufferedWriter = new BufferedOutputStream(fileOS);
			)*/
		{
			File file = new File(sourceFile);

			if (!file.exists()) {
				System.out.println("Give File not exist");
			}

			fileIS = new FileInputStream(file);
			fileOS = new FileOutputStream(targetFile);

			bufferedIS = new BufferedInputStream(fileIS);
			bufferedWriter = new BufferedOutputStream(fileOS);

			timeInMilliseconds = new Date().getTime();

			byte[] data = new byte[1024];
			while (bufferedIS.available() > 0) {
				bufferedIS.read(data);
				bufferedWriter.write(data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bufferedWriter.flush();
			bufferedIS.close();
			bufferedWriter.close();

			fileIS.close();
			fileOS.close();
		}

		System.out.println("Total time is: " + (new Date().getTime() - timeInMilliseconds));

		return true;
	}

	public static void main(String[] args) throws Exception {
		FileCopier betterFileCopier = new FileCopier();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Give the input file");
		String sourceFile = scanner.next();

		System.out.println("Give the output file");
		String targetFile = scanner.next();
		betterFileCopier.copy(sourceFile, targetFile);
	}
}
