package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoClient {
   private static final String SERVER_IP = "127.0.0.1";  //내 IP주소
   private static final int SERVER_PORT = 9999;
   
   public static void main(String[] args) {
      // 1. Client 소켓 생성
      // 2. Server에 Connect
      
      try (Socket socket = new Socket()) { //소캣을 열면 / ()안에 넣어주면 finally 생략가능
         socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
         
         
         log("Connected To Server."); //서버에 연결되었다.
         
         BufferedReader response = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
         PrintWriter request = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
         // 위에 두개는 서버에서 보내준거 읽고 쓰는거 서버랑 동일
         
         BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in)); //charset 인자를 주지않으면, 자동으로 시스템의 charset으로 세팅함
         // 밑에 BufferedReader는 키보드치는용, 클라이언트는 자기가 입력할 용의 버퍼리더가 필요하다.
         
         while(true) {            
            // 쓰기
            System.out.print(">> [send to server] ");
            String input = inputReader.readLine();
      
            if(input == null || "exit".equals(input))
               break;
            
            request.println(input);

            
            // 읽기
            String responseString = response.readLine();
            if (responseString == null) {
               //server로부터의 정상종료
               log("[client] closed by server");
            }
            
            System.out.print("<< [response by server]");
            System.out.println(responseString);
         }
      } catch (SocketException e) { // 소켓 예외가 발생하면
         log("[client] suddenly closed by server: " + e);
      } catch (IOException e) {   //IOException가 발생하면 
         log("[client] error: " + e);
      }

   }

   private static void log(String logString) {
      System.out.println(logString);
   }
}