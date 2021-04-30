package TCP;

import javax.naming.ldap.SortKey;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Tcp_Server {
    public static void main(String[] args) throws IOException {
            ServerSocket ss = new ServerSocket(3000);
            Socket socket = ss.accept();
                InputStream in = socket.getInputStream();
                int len = in.read();
                System.out.println("客户连入，边长为"+len);

                OutputStream out = socket.getOutputStream();
                out.write(4*len);

                socket.close();
                ss.close();
    }
}
