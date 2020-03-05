package sef.module12.newtry;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    static final int PORT = Server.PORT;

    public static void main(String[] args) throws IOException {

        Socket client = new Socket(InetAddress.getLocalHost(), PORT);
        System.out.println("Ты подключился к чату по адресу " + client.getInetAddress().getHostAddress());
        PrintWriter toServer = new PrintWriter(client.getOutputStream(), true);
        BufferedReader inputKeyboard = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fromServer;

        while (true) {
            String line = inputKeyboard.readLine();
            if (line.equalsIgnoreCase("exit")) {
                toServer.println(line);
                fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String response = fromServer.readLine();
                System.out.println(response);

                client.close();
                break;
            } else {
                toServer.println(line);
            }


        }



    }
}
