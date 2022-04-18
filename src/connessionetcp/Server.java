/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connessionetcp;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salva
 */
public class Server {
    ServerSocket serverSock;
    Socket server;
    BufferedReader reader;
    BufferedWriter writer;
    
    public Server(int porta) {
        try {
            serverSock=new ServerSocket(porta);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void attendi() {
        try {
            server=serverSock.accept();
            reader=new BufferedReader(new InputStreamReader(server.getInputStream()));
            writer=new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void chiusuraServer() {
        try {
            serverSock.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void chiusuraConnessione() {
        try {
            server.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void scrittura() {
        try {
            writer.write("Benvenuto!\n");
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void lettura() {
        try {
            System.out.println(reader.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void data() {
        try {
            if("date".equals(reader.readLine())) {
                Long tmStmp = System.currentTimeMillis();
                writer.write(tmStmp+"\n");
                writer.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
