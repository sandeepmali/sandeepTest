package project_code;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * A utility that downloads a file from a URL.
 * 
 * @author www.codejava.net
 *
 */
public class DownloadFile {
	public static final int BUFFER_SIZE = 4096;

	/**
	 * Downloads a file from a URL
	 * 
	 * @param fileURL
	 *            HTTP URL of the file to be downloaded
	 * @param saveDir
	 *            path of the directory to save the file
	 * @throws IOException
	 */
	public void downloadFile(String countryName, String weatherType, String fileURL, String saveDir)
			throws IOException {
		String baseUrl = "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/"+fileURL;
		URL url = new URL(baseUrl);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		int responseCode = httpConn.getResponseCode();

		// always check HTTP response code first
		if (responseCode == HttpURLConnection.HTTP_OK) {
			String fileName = "";
			String disposition = httpConn.getHeaderField("Content-Disposition");
			String contentType = httpConn.getContentType();
			int contentLength = httpConn.getContentLength();

			if (disposition != null) {
				// extracts file name from header field
				int index = disposition.indexOf("filename=");
				if (index > 0) {
					fileName = disposition.substring(index + 10, disposition.length() - 1);
				}
			} else {
				// extracts file name from URL
				fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1, fileURL.length());
			}

			System.out.println("Content-Type = " + contentType);
			System.out.println("Content-Disposition = " + disposition);
			System.out.println("Content-Length = " + contentLength);
			System.out.println("fileName = " + fileName);

			// opens input stream from the HTTP connection
			try {
				InputStream inputStream = httpConn.getInputStream();
				String saveFilePath = /* File.separator */ saveDir + fileName;

				// create file if not Exists
				// File writeFile = new File(saveFilePath);

				// opens an output stream to save into file
				FileOutputStream outputStream = new FileOutputStream(saveFilePath);

				int bytesRead = -1;
				byte[] buffer = new byte[BUFFER_SIZE];
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				outputStream.close();
				inputStream.close();
				//Parse file
				parseDataAsPerRequirement(saveFilePath,countryName, weatherType);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("File downloaded");
		} else {
			System.out.println("No file to download. Server replied HTTP code: " + responseCode);
		}
		httpConn.disconnect();
	}
/**
 * Parse file and add to CSV file
 * @param InputFile
 * @param countryName
 * @param WeatherType
 * @throws IOException
 */
	private void parseDataAsPerRequirement(String InputFile,String countryName, String WeatherType) throws IOException {
		BufferedReader br = null;
		InputStream inputStream = null;
		try {
			br = new BufferedReader(new FileReader(InputFile));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			for (int i = 0; i < 6; i++) {
				line = br.readLine();
			}

			FileOutputStream outputStreamCsv = new FileOutputStream("CSV.txt",true);
//			outputStreamCsv.flush();

			// Stream<String> stream = br.lines();
			// for(int i = 0 ;i<stream.count();i++) {
			// if(i>7) {
			// line = br.readLine();
			// outputStreamCsv.write(line.getBytes());
			// }
			// }
			String printResult = "";

			line = br.readLine();
			String splitArray[];
			while (line != null) {

				sb.append(line);
				// sb.append(System.lineSeparator());
				line = br.readLine();
				if (line != null) {
					ArrayList<String> arrayList = new ArrayList<>(13);
					// while (line.length() != 0) {
					String traverseString = "";
					splitArray = line.split(" ");
					for (int i = 0; i < splitArray.length; i++) {
						if (!splitArray[i].equalsIgnoreCase(""))
							arrayList.add(splitArray[i]);
					}
					// traverseString = splitArray[0];
					// if (traverseString.trim().length() > 0) {
					// arrayList.add(traverseString);
					// line = splitArray[1];
					// } else
					// line = splitArray[1];

					// }

					String monthArray[] = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV",
							"DEC" };
					for (int i = 0; i < monthArray.length; i++) {
						printResult = countryName + " ," + WeatherType + " ," + arrayList.get(0) + ", " + monthArray[i]
								+ ", " + arrayList.get(i + 1);
						printResult = printResult + System.lineSeparator();
						if (printResult.getBytes() != null && !printResult.equalsIgnoreCase("null")) {
							outputStreamCsv.write(printResult.getBytes());
						}
					}
					outputStreamCsv.write(System.lineSeparator().getBytes());
					// line = br.readLine();
					// if (printResult.getBytes() != null && !printResult.equalsIgnoreCase("null"))
					// {
					// line = br.readLine();
					// } else
					// break;

					// FileInputStream fileInputStream = new FileInputStream(line);
					// int bytesRead = -1;
					// byte[] buffer = new byte[DownloadFile.BUFFER_SIZE];
					// while ((bytesRead = fileInputStream.read(buffer)) != -1) {
					// outputStreamCsv.write(buffer, 0, bytesRead);
					// }
				} else
					break;
				// sb.toString();

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			br.close();
		}
	}
}
