package edu.java.message;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class MessageGUI extends JFrame {

	public MessageGUI() {
		init();
	}
	
	void init() {
		this.setTitle("Message GUI");
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, 400, 400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JTextArea jTextArea = new JTextArea(20,30);
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JButton jButton = new JButton("데이터 가져오기");
		jScrollPane.setViewportView(jTextArea);
		
		this.add(jScrollPane, BorderLayout.CENTER);
		this.add(jButton, BorderLayout.SOUTH);
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				BufferedReader br = null;
				
				try {
					br = new BufferedReader(new FileReader("C:/java_logs/log_20231121.txt"));
					String readedLine = "";
					String printStr = "";
					while((readedLine=br.readLine()) != null) {
						printStr += readedLine+"\n";
					}
					
					jTextArea.setText(printStr);
					
				} catch(FileNotFoundException ffe) {
					ffe.printStackTrace();
				} catch(IOException ioe) {
					ioe.printStackTrace();
				}
				
			}
			
		});
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new MessageGUI();
		
	}
	
}
