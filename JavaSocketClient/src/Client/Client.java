package Client;

import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 2017/7/3.
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.2.217", 7588);
            socket.setSoTimeout(3000);

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.print("服务端您好，我是客户端");
            printWriter.flush();
            socket.shutdownInput();

            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String info = "";
            String temp = null;
            while ((temp = bufferedReader.readLine()) != null){
                info += temp;
                System.out.println("客户端接收服务器端发送的信息：" + info);

                bufferedReader.close();
                inputStream.close();
                printWriter.close();
                outputStream.close();
                socket.close();
            }
        }catch (Exception e){

        }
    }
}
