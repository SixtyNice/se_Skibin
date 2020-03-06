package sef.module12.FireChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {
    private static final int PORT = Server.getPORT();

    private Socket clientSocket;

    private Scanner fromServer;
    private PrintWriter toServer;
    private BufferedReader inputKeyboard = new BufferedReader(new InputStreamReader(System.in));


    private String clientName;

    public Client(String name) {
        try {
            clientName = name;
            clientSocket = new Socket(InetAddress.getLocalHost(), PORT);
            fromServer = new Scanner(clientSocket.getInputStream());
            toServer = new PrintWriter(clientSocket.getOutputStream());
            new Thread(this).start();

            sendMsg();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        try {
            while (true) {
                if (fromServer.hasNext()) {
                    String serverMessage = fromServer.nextLine();
                    System.out.println(serverMessage);
                }
            }
        } catch (Exception e) {

        }

    }

    public void sendMsg() throws IOException {

        while (true) {
            String clientMessage = inputKeyboard.readLine();
            toServer.println(this.clientName + ": " + clientMessage);
            toServer.flush();
        }

    }

    public static void main(String[] args) {
        Client client = new Client("Dima");
    }
}
