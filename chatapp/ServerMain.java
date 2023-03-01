/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chatapp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;
import java.util.HashMap;
import java.net.InetSocketAddress;


import java.util.Scanner;

/**
 *
 * @author User
 */
public class ServerMain {

    private static SocketImpl port;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(12345);
        System.out.println("Server started . . .");
        System.out.println(InetAddress.getLocalHost());
        HashMap<String, Information> clientList=new HashMap<>();
        
        
        while (true) {
            Socket socket=serverSocket.accept();
            NetworkConnection nc=new NetworkConnection(socket);
            
            new Thread(new CreateConnection(clientList,nc)).start();
        }
    }
    
}
