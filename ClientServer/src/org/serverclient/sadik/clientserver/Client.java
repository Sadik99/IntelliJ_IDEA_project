package org.serverclient.sadik.clientserver;
/*
 * author: Sadik Hassan
 * created: 5:45 pm, 10/10/2022
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Client Started...");
        Socket socket = new Socket("127.0.0.1", 22222);
        System.out.println("Client Connected....");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        objectOutputStream.writeObject(message);
        try {
            String response = (String) objectInputStream.readObject();
            System.out.println("Server: " + response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
