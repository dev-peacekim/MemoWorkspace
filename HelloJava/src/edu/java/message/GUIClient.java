package edu.java.message;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIClient extends JFrame{

	
	public GUIClient() {
		init();
	}
	
	void init() {
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, 400, 400);
		
		JTextArea serverTextArea = new JTextArea();
		JTextArea clientTextArea = new JTextArea();
		JButton startButton = new JButton("start");
		
		this.add(serverTextArea, BorderLayout.CENTER);
//		this.add(clientTextArea, BorderLayout.CENTER);
		this.add(startButton, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				InputStream is = null;
				
				try {
					Socket socket = new Socket("172.30.1.74", 8879);
					is = socket.getInputStream();
					
					int data = 0;
					String str = "";
					
					serverTextArea.setForeground(Color.RED);
					serverTextArea.setBackground(Color.RED);
					serverTextArea.setText("hi");
					
					while(true) {
						try {
							while((data=is.read())!=-1) {
								str += "+"+data;
								System.out.println("여기임"+serverTextArea.getText());
							}
						} catch(IOException ioe) {
							ioe.printStackTrace();
						}
					}
					
				} catch(UnknownHostException uhe) {
					uhe.printStackTrace();
				} catch(IOException ioe) {
					ioe.printStackTrace();
				}
				
			}
			
		});
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new GUIClient();
			
	}
	
}
