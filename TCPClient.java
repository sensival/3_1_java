// 사용예: java TCPClient 서버주소 포트번호

import java.io.*;
import java.net.*;

public class TCPClient{
    public static void main(String args[]) throws Exception{
        String server = args[0];
        int port = Integer.parseInt(args[1]) ;
        Socket csocket =new Socket(server, port) ; // 클라이언트 소켓 생성( 서버에 연결 요청)
        InputStream istream = csocket.getInputStream() ; // 소켓 입력 스트림 생성
        DataInputStream distream = new DataInputStream(istream) ; // 스트림 변환
        
        for(int i=1 ; i <= 5 ; i++){ // 숫자 1~5를 5회에 걸쳐 수신
            int imsg = distream.readInt() ;
            System.out.println("서버로 받은 데이터: " + imsg) ;
        }
        csocket.close();
    }
}