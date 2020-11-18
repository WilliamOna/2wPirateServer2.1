package com.revature.pirate.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.revature.pirate.model.Pirate;

public class PirateRepository {
	public ArrayList<Pirate> readFile(){
		ArrayList<Pirate> pirates = new ArrayList<>();
		InputStream inputStream = null;
		inputStream = this.getClass().getClassLoader().getResourceAsStream("db.txt");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		try {
			while(bufferedReader.ready()) {
				
				String[] tokens = bufferedReader.readLine().split(",");
				pirates.add(new Pirate(tokens[0],tokens[1]));
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pirates;
	}
}
