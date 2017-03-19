package reader;

import java.io.*;
import java.util.*;
import java.awt.*;

public class reader
{
	String inputFolderName = "input";
	
	// Main program
	public static void main(String [] args) throws InterruptedException, IOException
	{
		File folder = new File("input");
		File[] list = folder.listFiles();
		FileWriter output = new FileWriter("output.txt");
		for (File file : list) {
			if (file.isFile()) {
				//System.out.println(file.getName());
				String innerText = file.getName();
				innerText = innerText.replace("-", " ");
				innerText = innerText.substring(0, innerText.length()-4);
				innerText = Capitalize(innerText);
				String tempText[] = innerText.split(" ");
				innerText = "";
				for (int i = 0; i < tempText.length-1; i++) {
					if (i != tempText.length-2) {
						innerText += tempText[i] + " ";
					}
					else {
						innerText += tempText[i];
					}
				}
				//System.out.println(innerText);
				output.write("<li><a href=\"/main-folder/second-folder/third-folder/" + file.getName() + "\" target=\"_blank\">" + innerText + "</a></li>");
				output.write(System.getProperty("line.separator"));
			}
		}
		output.close();
	}
	
	private static String Capitalize(String s) {
		String source = s;
	    StringBuffer res = new StringBuffer();

	    String[] strArr = source.split(" ");
	    for (String str : strArr) {
	        char[] stringArray = str.trim().toCharArray();
	        stringArray[0] = Character.toUpperCase(stringArray[0]);
	        str = new String(stringArray);

	        res.append(str).append(" ");
	    }

	    return res.toString().trim();
	}
}
	
