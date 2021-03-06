import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("netology.homework", Server.SERVER_PORT);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        Scanner scanner = new Scanner(System.in);

        String question1 = in.readLine();
        System.out.println(question1);

        String name = scanner.nextLine();
        out.write(name);
        out.flush();

        String question2 = in.readLine();
        System.out.println(question2);

        String answer = scanner.nextLine();
        out.write(answer);
        out.flush();

        String message = in.readLine();
        System.out.println(message);


        out.close();
        in.close();
        scanner.close();
    }
}
