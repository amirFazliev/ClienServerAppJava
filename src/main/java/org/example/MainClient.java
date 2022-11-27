package org.example;

import java.io.*;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8095;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out =
                     new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())), true);
             BufferedReader in =
                     new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("Amir");

            String text = in.readLine();
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}