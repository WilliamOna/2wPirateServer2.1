import org.apache.log4j.Logger;

import com.revature.pirate.servlet.HelloServlet;

public class App extends HelloServlet{
	public static void main(String[] args){
//		PirateRepository pirateRepository = new PirateRepository();
//		PirateLogic pirateLogic = new PirateLogic();
//		
//		//Ask for user input
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter the name of the pirate!");
//		
//		String name = scanner.nextLine();
//		ArrayList<Pirate> pirates = pirateRepository.readFile();
//
//		//output all of the pirates
//		pirateLogic.showPirates(pirates);
//		
//		System.out.println("What role do you want this pirate to have");
//		String role = scanner.nextLine();
//		pirateLogic.setPirate(pirates, name, role);
//			
//		
//		pirateLogic.showPirates(pirates);
//		scanner.close();
		Logger logger = Logger.getLogger(App.class);
		logger.debug("Logger Works! (Log4j 1)");
		
	}
	



	
	
	
}
