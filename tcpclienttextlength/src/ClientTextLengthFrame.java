

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 This class represent window for the client side TCP client Application
 It displays the number of words in a text counted from the server
*/

public class ClientTextLengthFrame extends JFrame 
{

	private static final long serialVersionUID = 1L;
		
	// Private frame components
	private JLabel lblServerTextLength;
	private JLabel lblStatusValue;
		
	// Private attributes for frame size
	private int width = 700;
	private int height = 200;
	


	/**
	* The constructor that initialize and organize the Swing components on 
	* the frame.
	*/
	public ClientTextLengthFrame () 
	{
			
		// Default frame setting
		getContentPane().setLayout(new BorderLayout());
		this.setTitle("TCP Application: Client Side");
		this.setSize(width, height);
			
			
		// Center the frame on the screen
	    this.setLocationRelativeTo(null);
			
		// Initialize default value for label
		lblServerTextLength = new JLabel("-");
		lblServerTextLength.setBounds(469, 64, 63, 39);
		lblStatusValue = new JLabel("-");
			
		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		// Organize components
		loadComponent();
			
	}
		
		
	/**
	* This method update the value of text length on the frame
	*/
	public void updateServerTextLength (String serverTextLength) 
	{
			
		this.lblServerTextLength.setText(serverTextLength);
			
	}
		
	/**
	* This method update the status of connection to the server.
	*/
	public void updateConnectionStatus (boolean connStatus) 
	{
			

		// Default status. Assuming for the worst case scenario.
		String status = "No connection to server.";
			
		// Validate status of connection
		if (connStatus)
				status = "Connection has been established.";
			
		// Update the status on frame
		this.lblStatusValue.setText(status);
	}
		
	/**
	* This method creates and arrange Swing components to display status of 
	* client's connection to the server.
	*/
	private JPanel getConnectionStatusPanel(Font font) 
	{
			
		// Create component
		JPanel panel = new JPanel();
		JLabel lblConnStatus = new JLabel ("Connection status: ");
			
		// Style the component
		lblConnStatus.setFont(font);
		lblStatusValue.setFont(font);
		lblConnStatus.setBackground(Color.WHITE);
		lblConnStatus.setOpaque(true);
		lblStatusValue.setBackground(Color.WHITE);
		lblStatusValue.setOpaque(true);
			
		// Organize components into panel
		panel.add(lblConnStatus);
		panel.add(lblStatusValue);
			
		return panel;
			
	}
		
	/**
	* This method creates and arrange Swing components to text length retrieved 
	* from the server.
	*/
	private JPanel getServerTextLengthPanel(Font font) 
	{
			
		// Create component to display text length retrieve from the server
		JPanel panel = new JPanel();
		JLabel lblTextLength = new JLabel ("Text length (from Server): ");
		lblTextLength.setBounds(139, 64, 320, 39);
		
		// Style the component
		lblTextLength.setFont(font);
		lblServerTextLength.setFont(font);
		lblTextLength.setBackground(Color.WHITE);
		lblTextLength.setOpaque(true);
		lblServerTextLength.setBackground(Color.WHITE);
		lblServerTextLength.setOpaque(true);
		panel.setLayout(null);
		
		// Organize components into panel
		panel.add(lblTextLength);
		panel.add(lblServerTextLength);
		
		// Create label of text
		JLabel lblText = new JLabel("Text:");
		lblText.setOpaque(true);
		lblText.setFont(new Font("Serif", Font.PLAIN, 30));
		lblText.setBackground(Color.WHITE);
		lblText.setBounds(139, 14, 81, 39);
		panel.add(lblText);
		
		// Create label of text input
		JLabel lblTextInput = new JLabel("This is java program");
		lblTextInput.setOpaque(true);
		lblTextInput.setFont(new Font("Serif", Font.PLAIN, 30));
		lblTextInput.setBackground(Color.WHITE);
		lblTextInput.setBounds(230, 14, 258, 39);
		panel.add(lblTextInput);
			
		return panel;
	 } 
		
	/**
	* This method arrange the Swing components on the frame.
	*/
	private void loadComponent() 
	{
			
		// Get font
		Font font = this.getFontStyle();
			
		// Get server status's panel and add to frame
		JPanel northPanel = this.getConnectionStatusPanel(font);		
		getContentPane().add(northPanel, BorderLayout.NORTH);
			
		// Get server text length's panel and add to frame
		JPanel center = getServerTextLengthPanel(font);
		getContentPane().add(center, BorderLayout.CENTER);
			
	 }
		
		
	/**
	* This method define a font to a generic style.
	* 
	* @return font object
	*/
	private Font getFontStyle() 
	{
			
			Font font = new Font ("Serif", Font.PLAIN, 30);
			
			return font;
			
	}
}
