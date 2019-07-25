import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	
	public static void main(String[] args) {

//		Check arguments

		if(args.length != 1) {
			
			System.out.println("Invalid operation\nPlease enter a proper arguments : ");
			return;
		}
		
		if(args[0].equals("a")) {
			
			System.out.println("Loading data ...");		
			
			try {
				
				BufferedReader textReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String stringReader = textReader.readLine();
				String words[] = stringReader.split(", ");
				
				for(String word : words) {
					
					System.out.println(word);
					
				}
			}
				
			catch (Exception e){} 
			System.out.println("Data Loaded.");
		}
		
		else if(args[0].equals("r")) {
			
			System.out.println("Loading data ...");	
			
			try {
				
				BufferedReader textReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String stringReader = textReader.readLine();
				String words[] = stringReader.split(", ");	
				Random randomData = new Random();
				int index = randomData.nextInt(4);
				System.out.println(words[index]);
			}

			catch (Exception e){} 
			System.out.println("Data Loaded.");	
			
		}
		
		else if(args[0].contains("+")){
			
			System.out.println("Loading data ...");	
			
			try {
		
				BufferedWriter textReader = new BufferedWriter(new FileWriter("students.txt", true));
				String subString = args[0].substring(1);
				Date date = new Date();
				String dateStyle = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateStyle);
				String formatStyle = dateFormat.format(date);
				textReader.write(", "+subString+"\nList last updated on "+formatStyle);
				textReader.close();
			} 
			
			catch (Exception e){}
			System.out.println("Data Loaded.");	
			
		}
		
		else if(args[0].contains("?")) {
			
			System.out.println("Loading data ...");		
			
			try {
				
				BufferedReader textReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String stringReader = textReader.readLine();
				String words[] = stringReader.split(",");	
				boolean done = false;
				String subString = args[0].substring(1);
				for(int index = 0; index<words.length && !done; index++) {
					
					if(words[index].equals(subString)) {
						
						System.out.println("We found it!");
						done = true;
						
					}
					
				}
			
			}

			catch (Exception e){} 
			System.out.println("Data Loaded.");	
			
		}
		
		else if(args[0].contains("c")) {
			
			System.out.println("Loading data ...");	
			
			try {
				
				BufferedReader textReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String lineReader = textReader.readLine();
				char array[] = lineReader.toCharArray();			
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
}