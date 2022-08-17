import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {
//		Check arguments if their length is less then 1 or not
    if(args[0].length() <= 1){
			System.out.println(Constant.WrongInput);
			}
		if(args[0].equals(Constant.ShowAll)) { // shows all names of StudentList file
			System.out.println(Constant.Loading);
			try {
				String[] Names = getStrings();
				for(String student : Names) {
					System.out.println(student);
				}
        System.out.println(Constant.Loaded);
			}
			catch (Exception e){
        System.out.println(Constant.NotLoaded);
			}
		}
		else if(args[0].equals(Constant.RandomStudent)) { // shows random student
			System.out.println(Constant.Loading);
			try {
				String[] Names = getStrings();
				Random random = new Random();
				System.out.println(Names[random.nextInt(4)]);
        System.out.println(Constant.Loaded);
			} 
      catch (Exception e){
        System.out.println(Constant.NotLoaded);
			}
		}
		else if(args[0].contains(Constant.AddStudent)) { //Adds new student in the StudentList file
			System.out.println(Constant.Loading);
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(
						new FileWriter(Constant.StudentList, true));
				String string = args[0].substring(1);
				Date date = new Date();
				String df = Constant.Date;
				DateFormat dateFormat = new SimpleDateFormat(df);
				//String fd = 
				bufferedWriter.write(Constant.SplitComa + string + Constant.LastUpdate + dateFormat.format(date));
				bufferedWriter.close();
        System.out.println(Constant.Loaded);
			} 
      catch (Exception e){
        System.out.println(Constant.NotLoaded);
			}
		}
		else if(args[0].contains(Constant.SearchStudent)) { // search a perticular student from StudentList file
			System.out.println(Constant.Loading);
			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream(Constant.StudentList)));
				String Line = bufferedReader.readLine();
				String i[] = Line.split(Constant.SplitComa);
				String t = args[0].substring(1);
				for(int idx = 0; idx<i.length; idx++) {
					if(i[idx].equals(t)) {
						System.out.println(Constant.FoundStudent);
						break;
					}
          System.out.println(Constant.Loaded);
				}
			} 
      catch (Exception e){
        System.out.println(Constant.NotLoaded);
			}
		}
		else if(args[0].contains(Constant.CountWord)) { // counts number of students from StudentList file
			System.out.println(Constant.Loading);
			try {
				String[] Names = getStrings();
				int count = 0;
				for(String word : Names) {
					count++;
				}
				System.out.println(count + Constant.WordsFound);
        System.out.println(Constant.Loaded);
			} 
      catch (Exception e){
        System.out.println(Constant.NotLoaded);
			}
		}
		else {
			System.out.println(Constant.WrongInput); // shows wrong input message and shows also what are the correct inputs
		}
	}

	private static String[] getStrings() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(Constant.StudentList)));
		String Line = bufferedReader.readLine();
		return Line.split(Constant.SplitComa);
	}
}
