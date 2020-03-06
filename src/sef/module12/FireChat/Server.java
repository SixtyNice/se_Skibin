package sef.module12.FireChat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server {

    private static final int PORT = 8080;

    private static List<ClientHandler> clients = new LinkedList<>();

    public static void main(String[] args) {
        Socket clientSocket = null;
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT, 5, InetAddress.getLocalHost());
            System.out.println("Server is started");
            while (true) {
                clientSocket = server.accept();
                System.out.println("Got a connection from " + clientSocket.getInetAddress());
                ClientHandler client = new ClientHandler(clientSocket, new Server());
                clients.add(client);
                new Thread(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                clientSocket.close();
                System.out.println("Server has been stop");
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void sendMsgToAllClients(String msg) {
        for (ClientHandler client : clients) {
            client.sendMsg(msg);
        }
    }

    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }

    public static int getPORT() {
        return PORT;
    }
}
