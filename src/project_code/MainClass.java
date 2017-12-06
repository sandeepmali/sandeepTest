package project_code;

import java.io.IOException;
import java.io.PrintWriter;

public class MainClass {
/**
 * @author sandeep mali
 * @param args
 * @throws IOException
 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String file_Path_UK_Tmax = "Tmax/date/UK.txt";
		String file_Path_UK_Tmin = "Tmin/date/UK.txt";
		String file_Path_UK_Tmean = "Tmean/date/UK.txt";
		String file_Path_UK_Sunshine = "Sunshine/date/UK.txt";
		String file_Path_UK_Rainfall = "Rainfall/date/UK.txt";

		String file_Path_England_Tmax = "Tmax/date/England.txt";
		String file_Path_England_Tmin = "Tmin/date/England.txt";
		String file_Path_England_Tmean = "Tmean/date/England.txt";
		String file_Path_England_Sunshine = "Sunshine/date/England.txt";
		String file_Path_England_Rainfall = "Rainfall/date/England.txt";

		String file_Path_Wales_Tmax = "Tmax/date/Wales.txt";
		String file_Path_Wales_Tmin = "Tmin/date/Wales.txt";
		String file_Path_Wales_Tmean = "Tmean/date/Wales.txt";
		String file_Path_Wales_Sunshine = "Sunshine/date/Wales.txt";
		String file_Path_Wales_Rainfall = "Rainfall/date/Wales.txt";

		String file_Path_Scotland_Tmax = "Tmax/date/Scotland.txt";
		String file_Path_Scotland_Tmin = "Tmin/date/Scotland.txt";
		String file_Path_Scotland_Tmean = "Tmean/date/Scotland.txt";
		String file_Path_Scotland_Sunshine = "Sunshine/date/Scotland.txt";
		String file_Path_Scotland_Rainfall = "Rainfall/date/Scotland.txt";

		//Clear previous write data
		try {
			PrintWriter printWriter = new PrintWriter("CSV.txt");
			printWriter.print("");
			printWriter.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DownloadFile downloadFile = new DownloadFile();

		downloadFile.downloadFile("UK", "Max Temp", file_Path_UK_Tmax, "UK_Tmax");
		downloadFile.downloadFile("UK", "Min Temp", file_Path_UK_Tmin, "UK_Tmin");
		downloadFile.downloadFile("UK", "Mean Temp", file_Path_UK_Tmean, "UK_Tmean");
		downloadFile.downloadFile("UK", "Sunshine Temp", file_Path_UK_Sunshine, "UK_Sunshine");
		downloadFile.downloadFile("UK", "RainFall Temp", file_Path_UK_Rainfall, "UK_Rainfall");
		
		downloadFile.downloadFile("England", "Max Temp", file_Path_England_Tmax, "England_Tmax");
		downloadFile.downloadFile("England", "Min Temp", file_Path_England_Tmin, "England_Tmin");
		downloadFile.downloadFile("England", "Mean Temp", file_Path_England_Tmean, "England_Tmean");
		downloadFile.downloadFile("England", "Sunshine Temp", file_Path_England_Sunshine, "England_Sunshine");
		downloadFile.downloadFile("England", "RainFall Temp", file_Path_England_Rainfall, "England_Rainfall");
		
		downloadFile.downloadFile("Wales", "Max Temp", file_Path_Wales_Tmax, "Wales_Tmax");
		downloadFile.downloadFile("Wales", "Min Temp", file_Path_Wales_Tmin, "Wales_Tmin");
		downloadFile.downloadFile("Wales", "Mean Temp", file_Path_Wales_Tmean, "Wales_Tmean");
		downloadFile.downloadFile("Wales", "Sunshine Temp", file_Path_Wales_Sunshine, "Wales_Sunshine");
		downloadFile.downloadFile("Wales", "RainFall Temp", file_Path_Wales_Rainfall, "Wales_Rainfall");
		
		downloadFile.downloadFile("Scotland", "Max Temp", file_Path_Scotland_Tmax, "Scotland_Tmax");
		downloadFile.downloadFile("Scotland", "Min Temp", file_Path_Scotland_Tmin, "Scotland_Tmin");
		downloadFile.downloadFile("Scotland", "Mean Temp", file_Path_Scotland_Tmean, "Scotland_Tmean");
		downloadFile.downloadFile("Scotland", "Sunshine Temp", file_Path_Scotland_Sunshine, "Scotland_Sunshine");
		downloadFile.downloadFile("Scotland", "RainFall Temp", file_Path_Scotland_Rainfall, "Scotland_Rainfall");
		

	}

}
