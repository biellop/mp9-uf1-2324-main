package mp9.uf1.exercicis.test;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            String inputLine;
            while ((inputLine = consoleInput.readLine()) != null) {
                out.println(inputLine);
                System.out.println("Servidor: " + in.readLine());
            }

            in.close();
            out.close();
            consoleInput.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
