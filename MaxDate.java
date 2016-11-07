package kaggle;

import java.util.*;
import java.io.*;

public class MaxDate {

	public static void main(String[] args) throws Exception {
		String filename = "/media/boris/Data/Kaggle/kaggle-notebooks/data/train_ver2.csv";

		java.io.BufferedReader r = new java.io.BufferedReader(
				new java.io.InputStreamReader(new FileInputStream(filename)));

		String fileout = "/media/boris/Data/Kaggle/kaggle-notebooks/data/MaxDate_train.csv";
		PrintStream out = new PrintStream(new File(fileout));
		String line;
		String[] parts;
		
		String MaxDate = "2016-05-28";

		line = r.readLine();
		out.println(line); // skip headers
		line = r.readLine();
		while (line != null) {
			parts = line.split(",");
			if(parts[0].equals(MaxDate))
				out.println(line);
			line = r.readLine();
		}
		r.close();
		out.close();
	}

}
