package org.javaCore.clientServerApp;

public class Main {
    public static void main(String[] args) {
        new ServerThread().start();
        new ClientThread().start();
    }
}