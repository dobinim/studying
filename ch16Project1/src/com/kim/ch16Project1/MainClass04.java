package com.kim.ch16Project1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class MainClass04 {

	public static void main(String[] args) throws Exception {
		URL url = null;
		BufferedReader input = null;
		String address = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_elements";
		String line = "";
		url = new URL(address);
		input = new BufferedReader(new InputStreamReader(url.openStream()));
		// url.openStream()�� InputStream ��ü�� ����
		// url.openStream()�� url.openConnection() �� �ؼ� HttpURLConnection ��ü�� ���� �� 
		// getInputStream()�� ȣ����  InputStream ��ü�� ��ȯ
		
		while((line = input.readLine()) != null ) {
			System.out.println(line);
		}
		
		input.close();

	}

}
