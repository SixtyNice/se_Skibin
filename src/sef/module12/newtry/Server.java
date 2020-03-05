package sef.module12.newtry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT, 50, InetAddress.getLocalHost());
        System.out.println("Socket created at:" + InetAddress.getLocalHost().getHostAddress());
        System.out.println("Waiting connection");
        while (true) {

            Socket client = server.accept();
            System.out.println("Got a connection from " + client.getInetAddress().getHostAddress());

            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));

            while (true) {
                String line = fromClient.readLine();
                if (line.equalsIgnoreCase("exit")) {
                    PrintWriter toClient = new PrintWriter(client.getOutputStream(), true);
                    toClient.println("Thank you for connecting to " + client.getLocalSocketAddress() + " Goodbye!");
                    System.out.println("User disconnected");
                    break;
                } else {
                    System.out.println(line);
                }
            }

            fromClient.close();

        }
    }
}
