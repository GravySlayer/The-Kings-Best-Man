import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StarFun
{
  public static void main(String[] args)
	{
		String Dumbasterisk;
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line;

			while ((line = br.readLine()) != null)
			{
				Dumbasterisk = line;
				StringBuilder Jackasterisk = new StringBuilder(Dumbasterisk);
				for(int i = 0; i < Dumbasterisk.length(); i++)
				{
				   if (Dumbasterisk.charAt(i) == ' ')
				   {
					   Jackasterisk.setCharAt(i, '*');
				   }
				   else if (Dumbasterisk.charAt(i) == '*')
				   {
					   Jackasterisk.setCharAt(i,  ' ');
				   }
				}
				System.out.println(Jackasterisk);
			}

			br.close();
		} catch (Exception e) {}
	}
}
