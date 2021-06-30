import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int SERVER_PORT = 8888;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("New connection accepted");

        String question1 = "Write your name";
        out.write(question1);
        out.flush();

        String name = in.readLine();

        String question2 = "Are you child? (yes/no)";
        out.write(question2);
        out.flush();

        String answer = in.readLine();

        if (answer.equals("yes")) {
            String message1 = String.format("Welcome to the kids area, %s! Let's play!", name);
            out.write(message1);
            out.flush();
        } else if (answer.equals("no")) {
            String message2 = String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name);
            out.write(message2);
            out.flush();
        } else {
            String message3 = "I don't understand you! Bye!";
            out.write(message3);
            out.flush();
        }
        out.close();
        in.close();
    }
}
