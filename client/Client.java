package client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        final String serverHost = "localhost";  // Change to the server's IP or hostname
        final int serverPort = 12345;

        try (Socket socket = new Socket(serverHost, serverPort)) {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            // You can send and receive data to/from the server here

            // Example: Receiving a message from the server
            String message = (String) in.readObject();
            System.out.println("Server: " + message);

            // Cleanup
            in.close();
            out.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
    

