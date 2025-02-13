package org.javaCore.clientServerApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {
    public void run() {
        int port = 8081;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running...");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    System.out.println("New connection accepted. Port:" + clientSocket.getPort());
                    out.println("Write your name");
                    String name = in.readLine();

                    out.println(String.format("Hi %s, your port is %d.\n Are you child? (yes/no)", name, clientSocket.getPort()));
                    String isChild = in.readLine();
                    if (isChild.equalsIgnoreCase("yes")) {
                        out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
                    } else if (isChild.equalsIgnoreCase("no")) {
                        out.println(String.format("Welcome to the adult zone,%s! " +
                                "Have a good rest, or a good working day!", name));
                    } else {
                        out.println("Invalid response. Please answer with 'yes' or 'no'.");
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Server Error: " + e.getMessage());
        }
    }
}

