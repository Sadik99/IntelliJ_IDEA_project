package org.serverclient.sadik.clientserver;
/*
 * author: Sadik Hassan
 * created: 4:37 pm, 10/10/2022
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(22222);
        System.out.println("Server Started....");
        while(true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected...");
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            try {
                Object clientMessage = objectInputStream.readObject();
                System.out.println("Client : " + clientMessage);
//                ((String) clientMessage).toUpperCase();
                String sm=(String)clientMessage;
                sm=sm.toUpperCase();
                objectOutputStream.writeObject(sm);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
