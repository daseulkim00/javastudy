package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
		
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			// 2. binding - 어떤 소켓으로 연결을 기다릴 것인지 바인딩
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 9999));
			//                          IP 소켓 주소 (IP 주소 + 포트 번호)를 구현
			//                          0.0.0.0 = 나 
			log("strats...[port:" + 9999 + "]");
			// 3. accept
			
			while(true) {
				Socket socket = serverSocket.accept(); //연결을 기다리며, 연결이 될 때까지 block 상태가 됨
				new EchoServerReceiveThread(socket).start();
			}
		} catch (IOException e) {
			log("[server] error " + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed())
					serverSocket.close();
				// 습관적으로 닫아 주는 것 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// 좀더 상세하게 에러 정보를 출력해주는 것 
			}
		}
	}

	public static void log(String log) {
		System.out.println("[EchoServer] " + log);
	}
}
