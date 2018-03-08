/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datacontrol;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author root
 */
public class Clear extends DataControl{
    
   public static void perform(){
       try{
        FileWriter fwOb = new FileWriter("clients.txt", false); 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
        }
        catch(Exception e){
            System.out.println("Error Clearing File clients.txt");
        }
       
       try{
        FileWriter fwOb = new FileWriter("admins.txt", false); 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
        }
        catch(Exception e){
            System.out.println("Error Clearing File admins.txt");
        }
       
       try{
        FileWriter fwOb = new FileWriter("tellers.txt", false); 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
        }
        catch(Exception e){
            System.out.println("Error Clearing File tellers.txt");
        }

    }
   }
    

