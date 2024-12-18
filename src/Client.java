import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("127.0.0.1", 7777);
            BufferedReader serverData = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            System.out.println(serverData.readLine());
        } catch (IOException e) {
            System.err.println("It was not possible to connect to the server: " + e.getMessage());
        }
    }
}
