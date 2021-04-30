package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCP_Client1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",3000);
        OutputStream out = socket.getOutputStream();

        System.out.println("输入正方形边长：");
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        out.write(length);

        InputStream in = socket.getInputStream();
        int len = in.read();
        System.out.println("服务器回复：周长为："+len);

        socket.close();
    }
}
