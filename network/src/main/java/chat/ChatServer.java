package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private static final int PORT = 9999;
	public static List<PrintWriter> writerList = new ArrayList<>();

	public static void main(String[] args) {
		// 1. 서버 소켓 생성
		ServerSocket serverSocket = null;

		// 2. binding
		Socket socket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("연결 기다림 :" + PORT); //켜진지 알수있음

			while (true) {
				// 3. 클라이언트로 부터 연결 요청이 올 때까지 대기
				socket = serverSocket.accept();
				// 4. 연결 요청이 오면 연결이 되었다는 메세지 출력
				new ChatServerThread(socket).start();
			}

		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed())
					serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void log(String log) {
		System.out.println("[Server] " + log);
	}

}
