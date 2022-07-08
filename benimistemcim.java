/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flash.aydemir;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author requ
 */
public class benimistemcim {
public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Istemci bilgisayar adi girin: ");
        String hostname = scan.nextLine();
        
        
        
        while(true){
            try (Socket socket = new Socket(hostname,Integer.parseInt(args[0]))) {
 
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                
               

                String text;
                System.out.println("Giris yapiniz: ");
                text = scan.nextLine();

                writer.println(text);
                if(text.equals("Bye")){
                    System.out.println("Istemci kapaniyor");
                    return;
                }
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                do {

                    String message = reader.readLine();
                                                            //THREAD
                    System.out.println(message);

                } while (!text.equals("Bye"));

                socket.close();

            } catch (UnknownHostException ex) {
 
                System.out.println("Sunucu bulunamadi: " + ex.getMessage());
 
            } catch (IOException ex) {
 
                System.out.println("I/O error: " + ex.getMessage());
            }
        }
    }
}
