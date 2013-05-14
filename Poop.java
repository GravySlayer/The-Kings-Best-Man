import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class IOFun {

public static void main(String[] args){
  int num;
	System.out.println("What would you like to do?");
	System.out.println("(1) Read from a file");
	System.out.println("(2) Write to a file");
	System.out.println("(3) Quit");
	System.out.print("Choose: ");
	Scanner s = new Scanner(System.in);
	num = s.nextInt();
	try{
	if (num == 1) {
		String file;
		Scanner n = new Scanner(System.in);
		file = n.nextLine();
		ReadFile(file);
		}
	else if (num == 2) {
		String file;
		System.out.print("Filename: ");
		Scanner n = new Scanner(System.in);
		file = n.nextLine();
		WriteFile(file);
		}
	else if (num == 3)
		System.exit(0);
	else {
		throw new IllegalArgumentException();
	}}
	catch (IllegalArgumentException e) {
		System.out.println("Invalid number: please choose 1, 2, or 3");
	} 
		
	
		
}

private static void ReadFile(String file){
	BufferedReader reader;
	String line;
	
	System.out.println("Filename: ");

	try
	{
		reader = new BufferedReader(new FileReader("input.txt"));

		while ((line = reader.readLine()) != null)
		{
			System.out.println(line);
		}

		reader.close();
	}
	catch (Exception e) {}
}

private static void WriteFile(String file){
	FileWriter file;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String line;

	try
	{
		writer = new FileWriter("output.txt");

		while ((line = br.readLine()) != null)
		{
			writer.write(line + "\n");
		}
		System.out.println("poop");
		br.close();
		writer.close();
	}
	catch (Exception e) {}
	
}
}
