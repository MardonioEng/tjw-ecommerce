package br.edu.ifce.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Img {
	public static byte[] read(String path) throws IOException {
		File file = new File(path);
		byte[] arquivo = new byte[(int) file.length()];
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(arquivo);
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return arquivo;
	}
}