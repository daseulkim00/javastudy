package chat;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatClientReceiveThread extends Thread {
	
	private Socket socket;

	public ChatClientReceiveThread(Socket socket, BufferedReader response, PrintWriter requset) {
		this.socket = socket;
	}

	@Override
	public void run() {
		
		try {
			BufferedReader request = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			while(true) {
				String rcvString = request.readLine();
				System.out.println(rcvString);
//				if(rcvString == null) {
//					
//				}
				
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			if(socket.isClosed()) {
				System.out.println("정상 종료");
			}else {
				e.printStackTrace();				
			}
		}
	    
		
	}



}
