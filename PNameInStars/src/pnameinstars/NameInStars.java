package pnameinstars;

public class NameInStars 
{
	private String username;
	private final int STARSL = 4;
	private final int STARSR = 5;
	private final int ROWS = 3;
	
	public NameInStars(String username)
	{
		setUsername(username);
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String surroundNameInStars()
	{
		String nameInStars = "";
		
		for	(int i = 0; i < ROWS; i++)
		{
			nameInStars += "*".repeat(STARSL);
			nameInStars += username;
			nameInStars += "*".repeat(STARSR);
			nameInStars += "\n";
		}
		
		return nameInStars;
	}
}
