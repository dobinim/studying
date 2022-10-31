package com.kim.ch08Project1;

public class QuizClass1 {

	public static void main(String[] args) {

		int[] myNumbers = new int[] {1,2,3}; // 배열크기 3
		try {
			System.out.println(myNumbers[10]);
			return; // 메서드를 빠져나오라는 뜻 ㅡ 강사님이 설명할 때 추가하심
		}
		catch (Exception e) {
			// System.out.println(e.getMessage()); ㅡ 강사님이 설명할 때 추가하심
			// Index 10 out of bounds for length 3 
			// → 배열은 최대 3인데 인덱스 10번 (11번째)을 찾을 수 없다. 범위 이탈! 
			System.out.println("something went wrong.");
			return;		// 여기서 빠져나오라고 해도 finally까지 실행 후 빠져나옴.
		}
		finally { // 2번 문제
			System.out.println("The 'try - catch' is finished.");
		}
	}
}


/* 1. int 배열 myNumbers를 만들고 초기화는 1,2,3으로 한다.
 *    배열 색인번호 10번의 원소를 출력할 때 예외가 발생하는데 이를 처리하라. 
 *    try - catch 를 사용하고 예외처리 시 "something went wrong." 출력 
 *    
 * 2. 1번 문제에 예외가 있거나 없거나 The 'try catch' is finished. 를 출력하도록 함 */


