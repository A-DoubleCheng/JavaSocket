package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/7/3.
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(7588);
            System.out.println("服务器端已经启动，等待客户端连接");
            Socket socket = serverSocket.accept();//监听

            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String temp = null;
            String info = "";

            while ((temp = bufferedReader.readLine()) != null){
                info += temp;
                System.out.println("已接收到客户端连接");
                System.out.println("服务器端收到客户端信息：" + info + "，当前客户端ip" + serverSocket.getInetAddress().getHostAddress());

            }

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.print("你好，服务器端已收到您的信息");
            printWriter.flush();
            socket.shutdownInput();

            printWriter.close();
            outputStream.close();
            bufferedReader.close();
            inputStream.close();
            socket.close();

        }catch (Exception e){

        }
    }
}
