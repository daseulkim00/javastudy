package prob03;

public class CurrencyConverter {
	private static double rate;
	
	public static void setRate(double r) {
		CurrencyConverter.rate =r;
		
		//환율 설정
	}
	
	public static double toDollar(double won) {
		return won / rate;
	}
	public static double toKRW(double dollar) {
		return dollar*rate;
	}
	
	
	
}
