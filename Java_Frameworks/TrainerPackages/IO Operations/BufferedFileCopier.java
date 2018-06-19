package trng.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedFileCopier {

	public void fileCopy() throws Exception {
	   File inFile = null;
	   File outFile = null;	
	
	   FileInputStream fis = null;
	   BufferedInputStream bis = null;

	   FileOutputStream fos = null;
	   BufferedOutputStream bos = null;	

		try {
			inFile  = new File( "C:/temp/ReviewComments.txt" );
			outFile = new File( "C:/temp/CopyOfReviewComments.java" );
			
			fos = new FileOutputStream(outFile);
			fis = new FileInputStream( inFile );
			
			bis = new BufferedInputStream( fis );
			bos = new BufferedOutputStream( fos );
			
			boolean keepReading = true;
		
			int count = 0;
			byte[] byteArray = new byte[1024];
			while (keepReading) {
				count++;
				int size = bis.read(byteArray);
				if (size == -1) {
					keepReading = false;
				} else {
					bos.write(byteArray);
				}
			}
			
			System.out.println("Number of iterations: " + count);
		} finally {
			bis.close();
			fis.close();
			bos.flush();
			fos.flush();
			bos.close();
			fos.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		new BufferedFileCopier().fileCopy();
	}
}
