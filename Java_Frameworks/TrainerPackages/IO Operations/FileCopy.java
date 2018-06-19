package trng.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class FileCopy {

	public void fileCopy() throws Exception {
	   File inFile = null;
	   File outFile = null;	
	
	   FileReader fr = null;
	   BufferedReader br= null;

	   FileWriter fw = null;
	   BufferedWriter bw = null;	

		try {
			inFile  = new File( "C:/temp/IOProgramming.java" );
			outFile = new File( "C:/temp/CopyOfIOProgramming.java" );
			
			fw = new FileWriter(outFile);
			fr = new FileReader( inFile );
			bw = new BufferedWriter( fw );
			br = new BufferedReader( fr );
			
			String temp = null;
			boolean keepReading = true;
			
			while (keepReading) {
				temp = br.readLine();
				if (temp == null) {
					keepReading = false;
				} else {
					bw.write(temp);
				}
			}
		} finally {
			br.close();
			fr.close();
			bw.close();
			fw.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		new FileCopy().fileCopy();
	}
}