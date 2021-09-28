package httpd;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {
	private static final int PORT = 8080;

	public static void main(String[] args) {

		ServerSocket serverSocket = null;

		try {
			// 1. Create Server Socket
			serverSocket = new ServerSocket();
			   
			// 2. Bind
			serverSocket.bind( new InetSocketAddress("0.0.0.0", PORT));
			consolLog("stats... [" + PORT + "]");

			while (true) {
				// 3. Wait for connecting (accept)
				Socket socket = serverSocket.accept();

				// 4. Delegate Processing Request
				new RequestHandler(socket).start();// start가 레디큐상태로 넣어주는거
			}
		} catch (IOException ex) {
			consolLog("error:" + ex);
		} finally {
			// 5. 자원정리 - 자원을 열면 닫아주는 게 필요하다 그래서 함 
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close(); // 이미 닫혀있지않은지 
				}
			} catch (IOException ex) {
				consolLog("error:" + ex);
			}
		}
	}

	public static void consolLog(String message) {
		System.out.println("[HttpServer#" + Thread.currentThread().getId()  + "] " + message);
	}
}