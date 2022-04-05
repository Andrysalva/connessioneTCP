/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connessionetcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salva
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
        ServerSocket serverSocket=new ServerSocket(2000);
        System.out.print("Server in ascolto...");
        Socket socket=serverSocket.accept();
        BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        buffer.write("hello world\n");
        buffer.flush();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String msg = reader.readLine();
        System.out.print(msg);
        if(msg.equals("SYN")){
            buffer.write((new Date()).toString() + "\n");
            buffer.flush();
        }
        socket.close();
        }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
