package chapter03;

public class Goods {
	private String name;
	// private 적으면 외부에서 접근 할 수없음>정보은닉,캡슐화
	private int price;
	private int countStock;
	private int countSold;

	// public 외부에서 볼수잇음, 메소드는 일반적으로 퍼블릭으로가지고있음
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCountStock() {
		return countStock;
	}

	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}

	public int getCountSold() {
		return countSold;
	}

	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

	public void showInfo() {
		System.out.println(
				"name:" + name +
				", price:" + price +
				", countStock:" + countStock + 
				",countSold:" + countStock);

	}

}