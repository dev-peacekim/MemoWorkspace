package edu.java.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ImageCrawler {
	
	public static void main(String[] args) {
		
		URL url = null;
		URLConnection urlConn = null;
		BufferedInputStream bis= null;
		BufferedOutputStream bos = null; 
		
		try {
			url = new URL("http://thumb.mt.co.kr/06/2023/10/2023101516072125394_1.jpg/dims/optimize/");  // 가끔 이미지 저작권 사이트는 url 왜곡 시키는 경우가 있음
			urlConn = url.openConnection();
			
			bis = new BufferedInputStream(urlConn.getInputStream());
			
			bos = new BufferedOutputStream(new FileOutputStream("C:/data/kimzz.jpg"));
			
			byte[] buffer = new byte[1024];
			int readedBytes= 0;
			
			while((readedBytes=bis.read(buffer))!=-1) {
				bos.write(buffer, 0, readedBytes);
			}
		} catch(MalformedURLException murl) {
			murl.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
