package com.kim.ch08Project1;

import java.io.File;

public class MainClass08 {
							// args = String 으로 이뤄진 배열[]
	public static void main(String[] args) {
		try {
			// main 메서드의 매개변수로 arg 사용 시, run configurations로
			// 자바 실행할 때 직접 값을 넣어줘야 한다
			File f = createFile(args[0]); // args[0]은 파일 이름으로 교체할 수 있음
			// File 클래스는 file 처리에 관한 속성, 메서드를 가지고 있는 클래스 
			System.out.println(f.getName() + "파일이 성공적으로 생성되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "다시 입력해 주시기 바랍니다.");
		}
		System.out.println("main 메서드의 마지막");
	}
	
	static File createFile(String fileName) throws Exception {
		// Exception 예외처리를 호출한 main 메서드로 위임함
		if(fileName==null || fileName.equals("")) {
			throw new Exception ("파일 이름이 유효하지 않습니다.");
			// 메시지가 '파일 이름이 유효하지 않습니다' 예외를 만들어 던져줌
		}
		File f = new File(fileName);	// 파일 객체 생성, fileName을 가진 파일들을 처리하는 객체(인스턴스)
		f.createNewFile();				// 실제 파일을 생성 (내용 없는 파일을 디스크에 만듬, 성공 시 true)
		return f;						// 생성된 객체의 참조 반환
	}
	

}