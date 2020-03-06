package sef.module12.FireChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {

    private Socket clientSocket;
    private Server server;

    private PrintWriter toClient;
    private Scanner fromClient;

    private static final int PORT = 8080;
    private static int clients_count = 0;

    public ClientHandler(Socket clientSocket, Server server) {
        try {

            this.server = server;
            this.clientSocket = clientSocket;
            this.toClient = new PrintWriter(clientSocket.getOutputStream());
            this.fromClient = new Scanner(clientSocket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {


            while (true) {
                server.sendMsgToAllClients("Новый участник вошел ");
                server.sendMsgToAllClients("Учатсников в чате: " + clients_count++);
                break;
            }

            while (true) {
                if (fromClient.hasNext()) {
                    String clientMessage = fromClient.nextLine();
                    if (clientMessage.equalsIgnoreCase("exit")) {
                        server.sendMsgToAllClients("Участник отключился из чата");
                        server.sendMsgToAllClients("Учатсников в чате: " + clients_count--);
                        break;
                    }
                    System.out.println(clientMessage);

                    server.sendMsgToAllClients(clientMessage);
                }
            }
        } finally {
            this.close();
        }

    }


    public void sendMsg(String msg) {
        try {
            toClient.println(msg);
            toClient.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void close() {
        // удаляем клиента из списка
        server.removeClient(this);
        clients_count--;
        server.sendMsgToAllClients("Клиентов в чате = " + clients_count);
    }
}
