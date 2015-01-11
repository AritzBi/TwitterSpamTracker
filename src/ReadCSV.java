import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadCSV {

	public ArrayList<Tuit> run(String file) {
		ArrayList<Tuit> tuits = new ArrayList<Tuit>();
		String csvFile = "csv/" + file;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				String[] tuit = line.split(cvsSplitBy);
				tuits.add(new Tuit(tuit[0],Integer.parseInt(tuit[1]),Integer.parseInt(tuit[2]),Integer.parseInt(tuit[3].replaceAll(";", ""))));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return tuits;
	}
}
