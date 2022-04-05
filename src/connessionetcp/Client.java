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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Timestamp;


/**
 *
 * @author salva
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Socket socket = new Socket("127.0.0.1",2000);
            System.out.print("Connessione in corso...\n");
            System.out.println("ok.");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = reader.readLine();
            System.out.print(msg+'\n');
            BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            buffer.write("SYN\n");
            buffer.flush();
            msg = reader.readLine();
            System.out.print(msg + '\n');
            Timestamp sqlTimestamp = new Timestamp(Long.parseLong(msg));
            System.out.print(sqlTimestamp);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
