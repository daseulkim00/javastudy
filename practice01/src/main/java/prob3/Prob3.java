package prob3;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		int number;
		int sum = 0;
		System.out.print("숫자를 입력하세요 : ");
		number = scanner.nextInt();

		while (number > 0) {
			sum = sum + number;
			number = number - 2;
		}

		System.out.println("결과 값:" + sum);

		scanner.close();
	}
}
