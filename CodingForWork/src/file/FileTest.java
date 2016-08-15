package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileTest {

	public static void main(String[] args) {
		copyFile2("test", "test3");
	}

	public static void printFileList(File file, int level) {
		for (int i = 0; i < level; i++) {
			System.out.print("    ");
		}
		if (!file.isDirectory()) {

			System.out.println(file.getName());

		} else {
			level++;

			System.out.println(file.getName());

			File[] fileList = file.listFiles();
			for (int i = 0; i < fileList.length; i++) {
				printFileList(fileList[i], level);
			}
		}
	}

	public static void copyFile2(String src, String dest) {
		File destFile = new File(dest);
		if (!destFile.exists()) {
			try {
				destFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(src))));
			// FileWriter filewriter=new FileWriter(destFile,true);
			// FileReader reader2=new FileReader(src);

			//BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destFile)));
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destFile, true));
			// char[] cbuf = new char[1024];
			String string = reader.readLine();
			while (string != null) {
				// filewriter.write(string+ "\r\n");
				 bufferedWriter.write(string + "\r\n");
				// bufferedWriter.flush();
				string = reader.readLine();
			}
			reader.close();
			bufferedWriter.close();
			// filewriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

	}

	public static void copyFile(String src, String dest) {
		File destFile = new File(dest);
		if (!destFile.exists()) {
			try {
				destFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			FileInputStream in = new FileInputStream(src);
			FileOutputStream out = new FileOutputStream(destFile);

			byte buffer[] = new byte[1024];
			while (in.read(buffer) != -1) {

				out.write(buffer);
			}
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
