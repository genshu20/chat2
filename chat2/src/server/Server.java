package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public Server() {
        ServerSocket server=null;
        Socket socket=null;
        try {
            server=new ServerSocket(8189);
            System.out.println("server is run");

            while (true){
            socket=server.accept();
            System.out.println("client is connected");
            new ClientHandler(this,socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
