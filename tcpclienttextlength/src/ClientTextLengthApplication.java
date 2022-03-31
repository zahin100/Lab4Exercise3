

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * This class launch the frame and manage connection to the server
 */

public class ClientTextLengthApplication 
{	
	public static void main(String[] args) 
			throws UnknownHostException, IOException 
	{
		// Launch client-side frame
		ClientTextLengthFrame clientTextLengthFrame = new ClientTextLengthFrame();
		clientTextLengthFrame.setVisible(true);
		
		// Connect to the server localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
		
		// Update the status of the connection
		clientTextLengthFrame.updateConnectionStatus(socket.isConnected());
		
		// Write to socket
		PrintWriter printWriter = new 
				PrintWriter(socket.getOutputStream());
		
		// Send the text to server
		printWriter.println("This is java program");
		printWriter.flush();
		
		// Read text length from socket
		BufferedReader bufferedReader = new 
				BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		// Display the text length
		String textLength = bufferedReader.readLine();
		clientTextLengthFrame.updateServerTextLength(textLength);
		
		// Close everything
		bufferedReader.close();
		socket.close();
	}
}
