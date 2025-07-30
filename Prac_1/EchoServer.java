import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        int port = 3333; // Choose your port
        System.out.println("Server starting on port " + port);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);) {
                String line;
                while ((line = in.readLine()) != null) {
                    if ("stop".equalsIgnoreCase(line.trim()))
                        break;
                    System.out.println("Received from client: " + line);
                    out.println("Echo: " + line);
                }
            }

            System.out.println("Closing connection with client.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server shutting down.");
    }
}