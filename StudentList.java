import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	
	public static void main(String[] args) {
		
		Constants constant = new Constants();
//		Check arguments

		if(args.length != 1) {
			
			System.out.println("Invalid operation\nPlease enter a proper arguments : ");
			return;
		}
		
		if(args[0].equals(constant.printAll)) {
			
			System.out.println("Loading data ...");		
			
			try {
				
				String words[] = bufferedReader().readLine().split(", ");
				
				for(String word : words) {
					
					System.out.println(word);
					
				}
			}
				
			catch (Exception e){} 
			System.out.println("Data Loaded.");
		}
		
		else if(args[0].equals(constant.randomPrint)) {
			
			System.out.println("Loading data ...");	
			
			try {
				
				String words[] = bufferedReader().readLine().split(", ");	
				int index = new Random().nextInt(4);
				System.out.println(words[index]);
			}

			catch (Exception e){} 
			System.out.println("Data Loaded.");	
			
		}
		
		else if(args[0].contains(constant.appendWord)){
			
			System.out.println("Loading data ...");	
			
			try {
		
				DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss a");
				bufferedWriter().write(", "+args[0].substring(1)+"\nList last updated on "+dateFormat.format(new Date()));
				bufferedWriter().close();
			} 
			
			catch (Exception e){}
			System.out.println("Data Loaded.");	
			
		}
		
		else if(args[0].contains(constant.checkWord)) {
			
			System.out.println("Loading data ...");		
			
			try {
				
				String words[] = bufferedReader().readLine().split(",");	
				for(int index = 0; index<words.length; index++) {
					
					if(words[index].equals(args[0].substring(1))) {
						
						System.out.println("We found it!");
						break;
						
					}
					
				}
			
			}

			catch (Exception e){} 
			System.out.println("Data Loaded.");	
			
		}
		
		else if(args[0].contains(constant.countWord)) {
			
			System.out.println("Loading data ...");	
			
			try {
				
				char array[] = bufferedReader().readLine().toCharArray();			
				boolean intWord = false;
				int count = 0;
				for(char c : array) {
					
					if(c ==' ') {
						
						if (!intWord) {
							
							count++;
							intWord = true;
							
						}
						
						else {
							
							intWord = false;
							
						}
						
					}
					
				}
			
			System.out.println(count +" word(s) found ");
			
		} 
		
		catch (Exception e){} 
		System.out.println("Data Loaded.");	
		
		}
	}
	
	public static BufferedReader bufferedReader(){
		
		BufferedReader reader = null;
		
		try{
			
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			
		}
		
		catch(Exception e) {}
		return reader;
		
	}
	
	public static BufferedWriter bufferedWriter(){
		
		BufferedWriter writer = null;
		
		try{
			
			writer = new BufferedWriter(new FileWriter("students.txt", true));
			
		}
		
		catch(Exception e) {}
		return writer;
		
	}
	
	
}