

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * This class represent window for the server side TCP client Application
 * It displays the text given by the client and return the word count to the
 * client
 */

public class ServerTextLengthFrame extends JFrame
{
	
	// Private components
	private JLabel lblServerStatus;
	private JTextArea txtGivenText;
		
	// Private dimension
	private int width = 700;
	private int height = 500;
	
	public ServerTextLengthFrame () 
	{
		
		// Default frame setting
		this.setLayout(new BorderLayout());
		this.setTitle("TCP Application: Server Side");
		this.setSize(new Dimension(width, height));  
		
		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Center the frame on the screen
        this.setLocationRelativeTo(null);
 
		// Initialize component
		this.lblServerStatus = new JLabel ("-");
		
		// Row, Column
		this.txtGivenText = new JTextArea(20, 70);
		
		// Load more component
		loadComponent();
	}
	
	
	/**
	 * This method create and arrange Swing components to display the status of 
	 * the server application
	 */
	private JPanel getServerStatusPanel(Font font) {
		
		// Components to display server's status
		JPanel panel = new JPanel();
		JLabel lblServer = new JLabel ("Server status: ");
		
		// Style the components
		lblServer.setFont(font);
		lblServerStatus.setFont(font);
		lblServer.setBackground(Color.WHITE);
		lblServer.setOpaque(true);
		lblServerStatus.setBackground(Color.WHITE);
		lblServerStatus.setOpaque(true);

		// Organize component into the panel
		panel.add(lblServer);
		panel.add(lblServerStatus);
		
		return panel;
		
	}
	
	/*
	 * This method get the text from main method
	 */
	public void getText(String text)
	{
		// Display the given text from client
		txtGivenText.setText("Given text : " + text);
		txtGivenText.setEditable(false);
	}
	
	/**
	 * This method create and arrange Swing components the status of request 
	 * send to the client.
	 */
	private JPanel getGivenTextPanel () {
		
		// Component to display given text's status
		JPanel panel = new JPanel();
		
		// Display the given text from client
		txtGivenText.setText("Given text : - " );
		txtGivenText.setEditable(false);
		
		// Manage the style
		txtGivenText.setFont(new Font("Courier", Font.PLAIN, 15));

		// Add component to panel
		panel.add(txtGivenText);
		
		return panel;
	}
	
	/**
	 * This method arrange the GUI component on the frame
	 */
	public void loadComponent() {
		
		// Get the server status panel and add to frame
		Font font = this.getFontStyle();
		JPanel topPanel = this.getServerStatusPanel(font);
		this.add(topPanel, BorderLayout.NORTH);
		
		
		// Component to display request's status
		JPanel centrePanel = this.getGivenTextPanel();		
		this.add(centrePanel, BorderLayout.CENTER);
	}
	
	/**
	 * This method update the status of the server
	 */
	public void updateServerStatus(boolean flag) {
		
		String status = "Waiting for connection.";
		
		if (flag == true)
			status = "Received connection.";
		
		this.lblServerStatus.setText(status);
		
	}
	
	/**
	 * This method define a font to a generic style.
	 */
	private Font getFontStyle() 
	{
		
		Font font = new Font (Font.SANS_SERIF, Font.PLAIN, 30);
		
		return font;
		
	}

}
