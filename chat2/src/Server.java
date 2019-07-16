import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        ServerSocket server=null;
        Socket socket=null;

        try {
            server=new ServerSocket(8189);
            System.out.println("server is run");
            socket=server.accept();
            System.out.println("client is connected");

            Scanner sc=new Scanner(socket.getInputStream());

            while (true){
                String str=sc.nextLine();
                System.out.println(str);
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
