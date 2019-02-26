package nia.chapter4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @author FELIX
 * <p>
 * Listing 4.1 Blocking networking without Netty
 */
public class PlainOioServer {
    public void serve(int port) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(port);
        try {
            for (; ; ) {
                final Socket socket = serverSocket.accept();
                System.out.println("Accepted connection from " + socket);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStream out;
                        try {
                            out = socket.getOutputStream();
                            out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));
                            out.flush();
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                socket.close();
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
