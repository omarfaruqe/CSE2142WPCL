import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {
//		Check arguments
		if(args[0].equals("AlineSplit")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
				String Line = bufferedReader.readLine();
				String Names[] = Line.split(", ");
				for(String student : Names) {
					System.out.println(student);
				}
			}
			catch (Exception e){
			}
				System.out.println("Data Loaded.");
		}
		else if(args[0].equals("RandomStudent")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt")));
				String Line = bufferedReader.readLine();
				System.out.println(Line);
				String students[] = Line.split(", ");
				Random random = new Random();
				int studentIndex = random.nextInt(4);
				System.out.println(students[studentIndex]);
			} catch (Exception e){
			}
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")) {
			System.out.println("Loading data ...");			
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter("students.txt", true));
				String t = args[0].substring(1);
	        	Date d = new Date();
	        	String df = "dd/mm/yyyy-hh:mm:ss a";
	        	DateFormat dateFormat = new SimpleDateFormat(df);
	        	String fd= dateFormat.format(d);
				bufferedWriter.write(", "+t+"\nList last updated on "+fd);
				bufferedWriter.close();
			} catch (Exception e){
			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("?")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
				String r = bufferedReader.readLine();
				String i[] = r.split(",");
				boolean done = false;
				String t = args[0].substring(1);
				for(int idx = 0; idx<i.length && !done; idx++) {
					if(i[idx].equals(t)) {
						System.out.println("We found it!");
						done=true;
					}
			    }
			} catch (Exception e){
			}
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("CountWord")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
				String Line = bufferedReader.readLine();
				char words[] = Line.toCharArray();
				boolean in_word = true;
				int count = 0;
				for(char word : words) {
					if(word == ' ') {
						count++;
						in_word = true;
					}
					else
					{
						in_word = false;
					}
			   }
				if(!in_word)
					count++;
			System.out.println(count +" word(s) found ");
			} catch (Exception e){
			}
			System.out.println("Data Loaded.");				
		}
		else
			System.out.println("Wrong Input of argument. Give Valid inputes");
	}
}
