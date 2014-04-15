package com.sundeepmachado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class App {
	public static void main(String[] args) {
		LinkList linklist = new LinkList();
		ArrayList<Integer> datalist = new ArrayList<Integer>();
		int totalelements;
		File file = new File(System.getProperty("user.dir") + "\\data.txt");
		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(file));
			while ((sCurrentLine = br.readLine()) != null) {
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		totalelements = datalist.size();
		for (int i = 0; i < totalelements; i++) {
			linklist.insert(i, datalist.get(i));
		}
		linklist.displayList();
	}
}