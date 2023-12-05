package edu.java.gui;

import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class GUIExer2 extends JFrame {

	public GUIExer2() {
		init();
	}
	
	private void init() {
		this.setLayout(new GridLayout(3, 2));
		this.setBounds(new Rectangle(400, 400)); // 범위를 정하는 것
		this.setTitle("스윙 JFRAME");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JToggleButton jToggleButton = new JToggleButton();
		this.add(jToggleButton);
		
		JOptionPane.showConfirmDialog(this, "확인해주세요!"); 
		
		JToolBar jToolBar = new JToolBar();
		this.add(jToolBar);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new GUIExer2();
		
	}
	
}
