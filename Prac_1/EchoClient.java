import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 3333;

        try (Socket socket = new Socket(host, port);
             BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            System.out.println("Connected to server. Type messages, 'stop' to end.");

            String userLine;
            while ((userLine = userIn.readLine()) != null) {
                out.println(userLine);
                if ("stop".equalsIgnoreCase(userLine.trim())) break;
                String reply = in.readLine();
                System.out.println("Server replied: " + reply);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Client terminated.");
    }
}