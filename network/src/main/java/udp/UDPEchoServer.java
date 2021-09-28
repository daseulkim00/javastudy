package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
   public static final int PORT = 7000;
   public static final int BUFFER_SIZE = 1024;
   
   public static void main(String[] args) {
      DatagramSocket socket = null;
      try {
         //1. 소켓 생성
         socket = new DatagramSocket(PORT);
         
         while(true) {
            //2. 데이서 수신
            DatagramPacket rcvPacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(rcvPacket);   //blocking... (데이터를 받으면 blocking이 풀림 올때까지 대기)
   
            byte[] rcvData = rcvPacket.getData();
            int length = rcvPacket.getLength();
            String message = new String(rcvData, 0, length, "UTF-8");
            
            System.out.println("[server] receive:" + message);
            
            
            //3. 데이터 송신 (ehco)
            byte[] sndData = message.getBytes("utf-8");
            DatagramPacket sndPacket = new DatagramPacket(sndData, sndData.length, rcvPacket.getAddress(), rcvPacket.getPort());
            
//            System.out.println("[server] receive:" + message);
            socket.send(sndPacket);
         }
         
         
         
      } catch (SocketException e) {
         System.out.println("error:" + e);
      } catch (IOException e) {
         System.out.println("error:" + e);
      } finally {
         //자원 정리
         if(socket != null && socket.isClosed() == false) {
            socket.close();
         }
         
      }

      

   }

}