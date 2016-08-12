package rnm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.FileReader;

public class FlurryAnalytics {

	private static String readAll(Reader rd) throws IOException {

		int cp;

		StringBuilder sb = new StringBuilder();

		while ((cp = rd.read()) != -1) {

			sb.append((char) cp);
		}

		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {

		InputStream is = new URL(url).openStream();

		try {

			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);

			// ======================= Writing to JSON file
			// =================================

			System.out.println("Writing data to JSON file...");
			FileWriter jsonFileWriter = new FileWriter("book.json");
			jsonFileWriter.write(json.toString());
			jsonFileWriter.flush();
			jsonFileWriter.close();

			System.out.println(" Done writing to file..");

			// ======================= Writing to JSON file
			// =================================

			return json;

		} finally {

			is.close();
		}
	}

	public static void main(String[] args) throws IOException, JSONException {

		JSONObject json = readJsonFromUrl(
				"http://api.flurry.com/appMetrics/ActiveUsers?apiAccessCode=CRR9D9XY62XQ6T5K2K3Z&apiKey=HXQ2FPYTTSQSVWVWZYDQ&startDate=2015-08-01&endDate=2015-08-14");

		System.out.println(json.toString());

		ReadFromFile();

	}

	public static void ReadFromFile() {

		System.out.println("\n\n Readding from JSON file..");

		String jsonData = "";
		BufferedReader br = null;

		try {

			String line;

			br = new BufferedReader(new FileReader("book.json"));

			while ((line = br.readLine()) != null) {

				jsonData += line + "\n";
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null) {

					br.close();
				}

			} catch (IOException ex) {

				ex.printStackTrace();
			}
		}

		try {

			JSONObject obj = new JSONObject(jsonData);

			for (int i = 0; i < obj.getJSONArray("day").length(); i++) {

				System.out.println("Value of: " + i + " is " + obj.getJSONArray("day").getJSONObject(i).getString("@value"));

			}

		} catch (JSONException e) {

			e.printStackTrace();
		}
	}

}
