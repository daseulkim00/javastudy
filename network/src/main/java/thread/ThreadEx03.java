package thread;

public class ThreadEx03 {

	public static void main(String[] args) {
		Thread thread1 = new DigiThread();
		Thread thread2 = new AlphabetThread();
		Thread thread3 = new Thread(new UpperCaseAlphabetRunnablelmpl());
		
		thread1.start();
		thread2.start();
		thread3.start();

	}

}
