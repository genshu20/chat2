package server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Server server;
    private Socket socket;
    DataOutputStream out;
    DataInputStream in;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            in=new DataInputStream(socket.getInputStream());
            out=new DataOutputStream(socket.getOutputStream());
            new Thread(()->{
                try {
                while (true){
                    String str= in.readUTF();
                    if(str.equals("/end")){
                        System.out.println("client is disconnected");
                        break;
                    }
                    out.writeUTF(str);
                }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
