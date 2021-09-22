package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		System.out.print("실행결과: ");
		
		for(int i=0; i<COUNT_GOODS;i++) {
	
			String name =scanner.next();
			int price = scanner.nextInt();
			int countstock = scanner.nextInt();
			
			goods[i] = new Goods();
			goods[i].setName(name);
			goods[i].setPrice(price);
			goods[i].setCountstock(countstock);
	
		}
		
		// 상품 출
		
		for(int i = 0; i<COUNT_GOODS; i++) {
			
			System.out.println(goods[i].getName()+ "(가격:" + goods[i].getPrice() +"원) 이 " + goods[i].getCountstock() + "개 입고 되었습니다.");
		}
		
		
		// 자원정리
		scanner.close();
	}
}
