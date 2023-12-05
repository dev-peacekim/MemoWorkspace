package edu.java.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;


public class GUIExer1 extends Frame {
	
	Image image;
	
	GUIExer1() {
		
		this.setTitle("처음 만들어보는 프레임");
		this.setBackground(Color.ORANGE);
		this.setSize(400, 400);
		this.setLayout(new BorderLayout());
		
		this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	System.out.println(e.getClass().getName());
                dispose(); // 프레임을 닫음
            }
        });
		
		// 한글깨짐 해결 : Run > Run configration > Arguments
		//                  > VM arguments > -Dfile.encoding=MS949
		
		Button button = new Button("exit");
		button.setBackground(Color.BLUE);
		button.setSize(200, 200);
		
		this.add(button, BorderLayout.NORTH);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                System.out.println("버튼이 눌렸습니다.");
			}
			
		});
		
		
		TextField textField = new TextField("여기에 입력", 10);
		
		
		Button button2 = new Button("check");
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();
				System.out.println("입력하신 내용은 "+str+"입니다.");
			}
		});
		
		Panel panel = new Panel(new BorderLayout());
		panel.add(textField, BorderLayout.WEST);
		panel.add(button2, BorderLayout.EAST);
		
		this.add(panel, BorderLayout.SOUTH);
		
		String imgPath = "C:/data/kimzz.jpg";
		image = Toolkit.getDefaultToolkit().getImage(imgPath);
		
//		this.pack(); // 불필요한 공간 없애기
		this.setVisible(true); // 이걸 안하면 메모리엔 있는데 화면엔 안보임
		
	}
	
	public static void main(String[] args) {
		
		new GUIExer1();
		
	} // main
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}
	
} // class
