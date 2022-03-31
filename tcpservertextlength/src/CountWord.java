

public class CountWord 
{
	public static int wordCounter(String text)
	{
		int wordCount = 0;
	
	    if (!(" ".equals(text.substring(0, 1))) || 
	    		!(" ".equals(text.substring(text.length() - 1))))
	    {
	        for (int i = 0; i < text.length(); i++)
	        {
	            if (text.charAt(i) == ' ')
	            {
	                wordCount++;
	            }
	        }
	        wordCount = wordCount + 1; 
	    }
	    
	    // returns 0 if string starts or ends with space " "
	    return wordCount; 
	}
}
