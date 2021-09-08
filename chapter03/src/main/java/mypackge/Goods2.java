package mypackge;

public class Goods2 {
	public String name;		// 모든 접근 가능 (접근제한이 없음)
	protected int price;  	// 같은 패키지 + *자식 접근이 가능
	int countStock; 		// 아무것도없는게 디폴트/ 같은패키지
	private int countSold;	// 클랙스 내부에서만 접근이 가능
	
	void m() {
		countSold = 100;
	}
}
