/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flash.aydemir;

import java.io.*;
import java.net.*;
import java.util.*;


/**
 *
 * @author requ
 */
public class benimsunucum {
     
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String hostname ="localhost";
        System.out.println("Lutfen port girisi yapiniz: ");
        int port = Integer.parseInt(scan.nextLine());
        System.out.println("Lutfen kategori bilgisi girisi yapiniz: ");
        String kategori_bilgisi = scan.nextLine();
        
        System.out.println(port+"  :  "+kategori_bilgisi);
        ArrayList<String> kategori = new ArrayList<String>(); 
        try{
          File dosya = new File("kitaplik\\"+kategori_bilgisi+"\\dizin.txt");
          Scanner myReader = new Scanner(dosya);   
          while(myReader.hasNextLine()){
              String dizinsatir = myReader.nextLine();
              //System.out.println(dizinsatir);    
              kategori.add(dizinsatir);     
          }
          myReader.close();
      }
        catch (FileNotFoundException e){
           System.out.println("bir hata olustu");
            e.printStackTrace();
     }
        
         try (ServerSocket serverSocket = new ServerSocket(port)) {
 
            System.out.println("Sunucu portta dinliyor " + port);
               
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Yeni istemci baglandi");
                
                

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
 
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                String text="";
 
                do {
                    text = reader.readLine();
                    System.out.println(text);
                    if(text.equals("KLST")){
                        
                        for(int i=0;i<kategori.size();i++){
                            
                          writer.println(kategori.get(i));
                          System.out.println(kategori.get(i));  
                        }
                    }else if (text.equals("Bye")){
                        socket.close();
                        System.out.println("Server kapaniyor...");
                        return;
                    }else{
                        
                        int no = Integer.parseInt(text.split(" ")[1]);
                        String eleman = kategori.get(no-1).split(" ")[0];
                        ArrayList<String> parca = new ArrayList<String>(); 
                        try{
                            File dosya = new File("kitaplik\\"+kategori_bilgisi+"\\"+eleman+".txt");
                            Scanner myReader = new Scanner(dosya);   
                            while(myReader.hasNextLine()){
                                String dizinsatir = myReader.nextLine();
                                //System.out.println(dizinsatir);    
                                parca.add(dizinsatir);     
                            }
                            myReader.close();
                        }
                          catch (FileNotFoundException e){
                             System.out.println("bir hata olustu");
                              e.printStackTrace();
                       }
                        
                        for(int i=0;i<parca.size();i++){
                            
                          writer.println(parca.get(i));
                          System.out.println(parca.get(i));  
                        }
                        
                    }
 
                } while (true);
 
                
            }
 
        } catch (IOException ex) {
            System.out.println("Sunucuda sira disi durum: " + ex.getMessage());
            ex.printStackTrace();
        }
        
    }
}
