package nia.chapter4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * Listing 4.1 Blocking networking without Netty
 * <p>
 * lifei
 */
public class PlainOioServer {
    public void serve(int port) throws Exception {
        final ServerSocket socket = new ServerSocket(port);
        try {
            for (; ; ) {
                final Socket clientSocket = socket.accept();
                System.out.println("Accepted connection from " + clientSocket);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStream out;
                        try {
                            out = clientSocket.getOutputStream();
                            out.write("Hi\r\n".getBytes(Charset.forName("UTF-8")));
                            out.flush();
                            out.close();
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                clientSocket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
