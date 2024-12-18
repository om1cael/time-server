import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(7777);
            ExecutorService executorService = Executors.newCachedThreadPool()
        ) {
            System.out.println("Server up and running!");

            while(true) {
                executorService.execute(new ServerThread(serverSocket.accept()));
            }
        } catch (IOException e) {
            System.err.println("There was an error while setting up the server: " + e.getMessage());
        }
    }
}