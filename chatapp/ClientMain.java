/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class ClientMain {
    public static void main (String [] args)throws IOException{
        Socket socket = new Socket();
       try {
           socket.connect(new InetSocketAddress("www.google.com", 80)); //To get client IP (connect with google server).
       } catch (IOException e) {
           e.printStackTrace();
       }
       System.out.println("Client Started--- ");
       System.out.println(socket.getLocalAddress().getHostAddress());
       NetworkConnection nc=new NetworkConnection(socket.getLocalAddress().getHostAddress(),12345);

        System.out.println("Enter your username");
        Scanner in=new Scanner(System.in);
        String username=in.next();
        nc.write(username);

        Thread readerThread=new Thread(new Reader(nc));
        Thread writerThread=new Thread(new Writer(nc));
        
        readerThread.start();
        writerThread.start();
        
        try{
            readerThread.join();  //join means main thread alive unlill reader thread operate. 
            writerThread.join();  ////join means main thread alive unlill writer thread operate.
        }
        catch(Exception e){
            System.out.println("Thread exited");
        }
    }
}
    

