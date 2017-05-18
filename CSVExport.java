package csvexport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CSVExport {

	public static void main(String[] args) {
		readFile("C:\\Users\\Rishabh\\Documents\\abc.txt");

	}
	private static void readFile(String FILENAME){
		FileReader fr = null; 
		BufferedReader br = null;
		Map<List<String>, Integer> map = null;
		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));
			map = new LinkedHashMap <List<String>, Integer >();
			
			while ((sCurrentLine = br.readLine()) != null) {
				String[] readLine = sCurrentLine.split(" ");
				if(map.get(Arrays.asList("test",readLine[0], readLine[1])) == null){
					map.put(Arrays.asList("test",readLine[0], readLine[1]),Integer.parseInt(readLine [2]));
				}
				else
				{
					map.put(Arrays.asList("test",readLine[0], readLine[1]),Integer.parseInt(readLine [2]) + map.get(Arrays.asList("test",readLine[0], readLine[1])));
				}
				
				
				System.out.println(sCurrentLine);
			}
			

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
		try (FileWriter writer = new FileWriter("C:\\Users\\Rishabh\\Documents\\somefile.csv",true)) {
			  for (Entry<List<String>, Integer> entry : map.entrySet()) {
			    writer.append(entry.getKey().get(0))
			          .append(',')
			          .append(entry.getKey().get(1))
			          .append(',')
			          .append(entry.getKey().get(2) + " (" + entry.getValue() + ")")
			          .append("\n");
			  }
			} catch (IOException ex) {
			  ex.printStackTrace(System.err);
			}

	}

}
