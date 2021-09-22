package prob5;

public class MainApp {

	public static void main(String[] args) {
		try {
			MyStack stack = new MyStack(3);
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			stack.push("java");
			stack.push(".");

			while (stack.isEmpty() == false) {
				String s = stack.pop();
				System.out.println( s );
			}
			System.out.println("======================================");

			stack = new MyStack(3);//3 초기용량
			
			stack.push("Hello");// 1개넣고 2개뽑는다

			System.out.println(stack.pop());//검사안하고 무턱대고뽑아줌
			System.out.println(stack.pop());//비어있어서 예외발생
//			
		} catch ( MyStackException ex) {
			System.out.println( ex );
		}

	}

}
