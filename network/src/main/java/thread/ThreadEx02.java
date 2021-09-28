package thread;

public class ThreadEx02 {

	public static void main(String[] args) {
		Thread thread1 = new DigiThread();
		Thread thread2 = new AlphabetThread();
		
		thread1.start();
		thread2.start();
		

	}

}
