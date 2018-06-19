package trng.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This class read data 
 * @author Manohar
 *
 */
public class IOProgramming {
	public static void main(String args[]) throws IOException {
		OutputStream fos = null;
		OutputStream bos = null;
		InputStream bis = null; 

		bis = new BufferedInputStream(System.in);
		File outputFile = new File("c:\\temp\\ImcsMyFile.txt");

		try {
			if (! outputFile.exists()) {
				try {
					outputFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				fos = new FileOutputStream(outputFile, true);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			bos = new BufferedOutputStream(fos);
			
			try {
				int data;
				
				while ((data = bis.read()) != 10) {
					System.out.println(data);
					bos.write(data);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				bos.flush();
				fos.flush();
				bos.close();
				fos.close();
				bis.close();
		}
	}
}
