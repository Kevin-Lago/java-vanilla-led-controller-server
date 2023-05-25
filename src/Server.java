import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int port=8080;

    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(port);
            System.out.println("Started Server");

            while (true) {
                Socket connection = socket.accept();
                Request request = new Request(connection);

                // ToDo: Control LED
            }
        } catch (Throwable tr) {
            System.err.println("Could not start server: "+tr);
        }
    }
}
