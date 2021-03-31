/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matiplikv2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 *
 * @author dabro
 */
public class MatiplikV2 {

private static void copy(File src, File dest) throws IOException { 
        InputStream is = null; 
        OutputStream os = null; 
        try { 
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);  
            byte[] buf = new byte[1024]; 
            int bytesRead; 
            while ((bytesRead = is.read(buf)) > 0) 
            { os.write(buf, 0, bytesRead); } } 
        finally { is.close(); os.close(); } }


public static String nazwa(String linia){
        String[] a=linia.split(",");    
        String nazwa=a[0];         
            
        return nazwa;
    }
    
public static void main(String[] args) {
        File dir = new File("C:\\Users\\dabro\\Documents\\NetBeansProjects\\MatiplikV2\\Folder");
        String[] children =dir.list();
                
        try{
        if(children == null)
        {
        System.out.println("Nie ma");
        }else{     
                    
        for (int i = 0; i < children.length; i++) {
            String filename = children[i];
            System.out.println(filename);          
                        
            File g=new File("C:\\Users\\dabro\\Documents\\NetBeansProjects\\MatiplikV2\\Folder\\"+filename);
            
            Scanner scan=new Scanner(g);        
        
        while(scan.hasNextLine())
        {                        
            String data=scan.nextLine();
            System.out.print(data);
            String naz=nazwa(data);            
            System.out.println(naz);          
            File e=new File("C:\\Users\\dabro\\Documents\\NetBeansProjects\\MatiplikV2\\Folder\\level\\"+naz+".csv");
            copy(g,e);
                   
        }
        scan.close();
                           
            
                                                  }
        }
        }
        catch(IOException e)
        {
             System.out.println("Blad");
             e.printStackTrace();
        }
}
}
