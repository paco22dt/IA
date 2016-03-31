package files;
import java.io.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class FilesManager {
	String rute="";
	String ruteUsers=rute+"";
	String ruteBooks=rute+"";
	String ruteConsults = rute+"";
	String ErrorMessage;
	
	public FilesManager()
	{
		ErrorMessage="";
	}
	
	public int Login(String _username, String _password)
	{
		try
		{
			BufferedReader Lector = new BufferedReader( new InputStreamReader(new FileInputStream(ruteUsers), "8859_1"));
			
		}
		catch(Exception ex)
		{
			ErrorMessage="Error with Users.txt at login";
		}
		return 0;
	}
	
	public String GetErrorMessage()
	{
		return ErrorMessage;
	}

}
