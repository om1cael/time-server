import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class ServerThread implements Runnable {
    private final Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("New connection by " + socket.getLocalAddress() + " at server " + Thread.currentThread().getName());
        LocalDateTime dateTime = LocalDateTime.now();

        try(PrintWriter clientData = new PrintWriter(socket.getOutputStream(), true)) {
            clientData.println(dateTime);
        } catch (IOException e) {
            System.err.println("It was not possible to connect to the socket: " + e.getMessage());
        }
    }
}
