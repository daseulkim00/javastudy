package prob5;

public class MyStack {
	private int top;
	private String[] buffer;

	public MyStack(int capacity) {
		top = -1; //top이 가르키는 값이 비어있다는 뜻, 제일 상단에 잇는 인덱스
		buffer = new String[capacity];
	}

	public void push(String s) {
		if (top == buffer.length - 1) {
			resize();
		}// 2=(3-1)과 같게되면 리사이즈해라

		//top = top + 1;
		
		buffer[++top] = s;
		// top = top+1
	}

	
	// 먼저 복사해두고 그다음에 탑 감소
	
	public String pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException("stack is empty");
		}

		String result = buffer[top];
		buffer[top--] = null;

		return result;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	//
	private void resize() {
		String[] temp = new String[buffer.length * 2];
		for (int i = 0; i <= top; i++) {
			temp[i] = buffer[i];
		}

		buffer = temp;
	}
}