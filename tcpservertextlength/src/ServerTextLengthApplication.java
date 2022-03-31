

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * This class launch the server side application
 * The server will count the number of words in the given text
 * and return the word count to the client
 */

public class ServerTextLengthApplication 
{	
	public static void main(String[] args) throws IOException 
	{
		// Launch the server frame
		ServerTextLengthFrame serverTextLengthFrame = new ServerTextLengthFrame();
		serverTextLengthFrame.setVisible(true);
		
		// Bind to a port
		int portNo = 4228;
		ServerSocket serverSocket = new ServerSocket(portNo);
		
		// Server need always to be alive
		while(true)
		{
			// Message to indicate that the server is alive
			serverTextLengthFrame.updateServerStatus(true);
			
			// Accept client request for connection
			Socket socket = serverSocket.accept();
			
			// Read data from socket
			BufferedReader bufferedReader = new
					BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// Get the text from client
			String text = bufferedReader.readLine();
			
			// Send the text to ServerTextLengthFrame
			serverTextLengthFrame.getText(text);
			
			// Count the number of words in the text
			int wordCount = CountWord.wordCounter(text);
			
			// Write data to socket
			DataOutputStream dataOutputStream = new
					DataOutputStream(socket.getOutputStream());
			
			// Send the word count to client
			dataOutputStream.writeBytes(Integer.toString(wordCount));
			
			// Close the socket
			socket.close();
			
		}
	}
}
