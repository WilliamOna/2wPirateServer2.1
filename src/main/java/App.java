import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class App{
	public static void main(String[] args){
		//Start Download
		Dowloader downloader = new Dowloader();
		downloader.start();
		
		//Ask for user input
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the pirate!");
		
		String name = scanner.nextLine();
		ArrayList<Pirate> pirates = readFile();

		//output all of the pirates
		showPirates(pirates);

		// Set Role of Pirate
		int index = search(pirates, name);
		if(index == -1) {
			System.out.println("Pirate not found Exception"); // we could make our own exception
		}else {
			System.out.println("What role do you want this pirate to have");
			pirates.get(index).setRole(scanner.nextLine());
		}
			
		
		showPirates(pirates);

		//  how we can make this better:
		// 
		//   listening for user input during runtimemenu, or user-friendly-ness
		//  giving them suggestions <--- extra feature
		scanner.close();
		
	}
	
	private static int search(ArrayList<Pirate> pirates, String name) {
		int index = -1;
//		pirates.forEach((pirate) -> {
//			
//		});
		for(Pirate pirate:pirates) {
			index++;
			if(pirate.getName().equals(name)) {
				return index;
			}
		}
		return -1;
		
	}

	private static void showPirates(ArrayList<Pirate> pirates) {
		for(Pirate pirate: pirates) {
			System.out.println(pirate);
		}
	}
	
	private static ArrayList<Pirate> readFile(){
		ArrayList<Pirate> pirates = new ArrayList<>();
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("db.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(fileReader);
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
