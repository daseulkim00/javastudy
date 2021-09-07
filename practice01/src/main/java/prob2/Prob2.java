package prob2;

public class Prob2 {
	public static void main(String[] args) {
		/* 코드 작성 */

		int k = 0;
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				k++;
				System.out.print(k + "");
			}
			System.out.println("");
			//다음줄로 넘길려고
			k = i;
		}
	}
}
