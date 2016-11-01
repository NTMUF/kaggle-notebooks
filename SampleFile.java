import java.util.*;
import java.io.*;

public class SampleFile{

	public static void main(String[] args) throws Exception{
		Random rand = new Random(42);

		String filename = "data/train_ver2.csv";

		java.io.BufferedReader r = new java.io.BufferedReader(
			new java.io.InputStreamReader(new FileInputStream(filename)));
		
		String fileout = "data/sample_train.csv";
		PrintStream out = new PrintStream(new File(fileout));
		String line;
		String[] parts;
		String n1, n2;
		int id;
		int linesRead=0;

		HashMap<Integer,Boolean> keep = new HashMap(10_000_000);
		line = r.readLine();
		out.println(line); // skip headers
		while (true) {
			line = r.readLine();
			linesRead++;
			if(linesRead% 100_000 == 0)
				System.out.print("Read : "+linesRead+" lines  \033[0G");
			if (line == null)
				break;
			if (line.startsWith("#"))
				continue;
			parts = line.split(",");
			n1 = parts[1];
			id = Integer.parseInt(n1.replaceAll("\\s",""));
			if(!keep.containsKey(new Integer(id))){
				keep.put(id,(rand.nextInt()% 10 == 0));
			}
			if(keep.get(id)){
				out.println(line);
			}

		}
		r.close();
		out.close();
	}


}