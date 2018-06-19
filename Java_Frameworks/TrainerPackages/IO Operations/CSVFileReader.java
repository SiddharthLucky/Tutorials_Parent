package trng.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class CSVFileReader {

	public Employee[] readEmployees(File inFile) throws Exception {

		Employee[] employees = new Employee[20];
		Reader fr = null;
		BufferedReader br = null;

		try {
			// inFile = new File( "C:/temp/EmpData.csv" );

			fr = new FileReader(inFile);
			br = new BufferedReader(fr);

			String line = null;
			boolean keepReading = true;

			int index = 0;
			while (keepReading) {
				line = br.readLine();

				if (line == null || line.equals("")) {
					break;
				}
				if (index != 0) {
					Employee emp = parseLine(line);
					employees[index - 1] = emp;
				}

				index++;
			}
		} finally {
			br.close();
			fr.close();
		}

		return employees;
	}

	private Employee parseLine(String line) {
		String[] tokens = line.split(",");
		Employee emp = new Employee(tokens[1], tokens[0], Float.parseFloat(tokens[2]));
		return emp;
	}
}
