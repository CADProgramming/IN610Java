package pwordreverser;

public class Words {

	private String message;
	private String[] words;
	
	public Words(String message)
	{
		setMessage(message);
	}
	
	public void setMessage(String message)
	{
		this.message = message;
		words = message.split("\\*");
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public String reverseWords()
	{
		String reversedWords = "";
		
		for (int n = words.length - 1; n >= 0; n--)
		{
			reversedWords += words[n];
			
			if (n > 0)
			{
				reversedWords += "*";
			}
		}
		
		return reversedWords;
	}
	
	public String toString()
	{
		return "Original: " + message + "\n" +
				"Reversed: " + reverseWords();
	}
}
