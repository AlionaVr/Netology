package org.javaCore.clientServerApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    public void run() {

        String host = "netology.homework";
        int port = 8081;
        try {
            Thread.sleep(500);
            try (Socket clientSocket = new Socket(host, port);
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                in.readLine();
                out.println("Aliona");

                in.readLine();
                out.println("yes");
                in.readLine();

                String finalResponse = in.readLine();
                System.out.println(finalResponse);
            }
        } catch (InterruptedException | IOException e) {
            System.err.println("Client error: " + e);
        }
    }
}