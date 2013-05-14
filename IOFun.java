import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class IOFun {

public static void main(String[] args){

	
boolean boo = true;
while (boo == true) {

	System.out.println("What would you like to do?");
	System.out.println("(1) Read from a file");
	System.out.println("(2) Write to a file");
	System.out.println("(3) Quit");
	System.out.print("Choose: ");
	Scanner s = new Scanner(System.in);
	String num = s.nextLine();
	try{
	if (num.equals("1")) {
		System.out.print("Filename: ");
		Scanner n = new Scanner(System.in);
		String file = n.nextLine();
		ReadFile(file);
		}
	else if (num.equals("2")) {
		System.out.print("Filename: ");
		Scanner n = new Scanner(System.in);
		String fileO = n.nextLine();
		WriteFile(fileO);
		}
	else if (num.equals("3"))
		System.exit(0);
	else {
		throw new IllegalArgumentException();
		}
	}
	catch (IllegalArgumentException e) {
		System.out.println("Invalid number: please choose 1, 2, or 3");
	} 
		
	}
}

private static void ReadFile(String file){
	BufferedReader reader;
	String line;

	try
	{
		reader = new BufferedReader(new FileReader(file));

		while ((line = reader.readLine()) != null)
		{
			System.out.println(line);
		}

		reader.close();
	}
	catch (Exception e) {
		System.out.println("ERROR: " + file + " not found.");
		System.out.print("Filename: ");
                Scanner n = new Scanner(System.in);
                file = n.nextLine();
		ReadFile(file);
		
	}
}

private static void WriteFile(String fileO){
	FileWriter writer;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String line;

	try
	{
		writer = new FileWriter(fileO);

		while ((line = br.readLine()) != null)
		{
			writer.write(line+"\n");
		}
		System.out.println("");
		writer.close();
	}
	catch (Exception e) {}
	
}
}
