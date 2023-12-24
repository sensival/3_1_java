//사용: java TCPServer 포트번호

import java.io.*;
import java.net.*;

class TCPServer {
    public static void main(String args[]) throws Exception {
        int port = Integer.parseInt(args[0]);
        ServerSocket ssocket = new ServerSocket(port);// 서버 소켓 생성

        System.out.println("서버 실행 중..");
        boolean serverRunning = true;
        while (serverRunning) {
            try {
                Socket csocket = ssocket.accept(); // 연결 수락 클라이언트 소켓 생성
                OutputStream ostream = csocket.getOutputStream(); // 소켓 출력 스트림 생성
                DataOutputStream dostream = new DataOutputStream(ostream); // 스트림 변환

                for (int imsg = 1; imsg <= 5; imsg++) // 숫자 1~5을 5회에 걸쳐 송신
                    dostream.writeInt(imsg);

                // 스트림과 소켓 닫기
                dostream.close();
                csocket.close();
            } catch (IOException e) {
                // 예외 처리 (예외 발생 시 루프 종료)
                e.printStackTrace();
                serverRunning = false;
            }
        }
        // 서버 소켓 닫기
        ssocket.close();
    }
}