package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        int port = 8095;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out =
                             new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())), true);
                     BufferedReader in =
                             new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){

                    System.out.println("New connection accepted. Port: " + clientSocket.getPort());

                    final String name = in.readLine();

                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

                }
            }
        }
    }
}