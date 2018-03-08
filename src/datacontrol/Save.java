/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datacontrol;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import user.Client;
import static moneybanksystem.MoneyBankSystem.Clients;
import static moneybanksystem.MoneyBankSystem.Admins;
import static moneybanksystem.MoneyBankSystem.Tellers;

/**
 *
 * @author root
 */
public class Save extends DataControl{
 
    
    public static void perform(){
        
        //SAVE CLIENTS
        try{
    	
        //Specify the file name and path here
    	File file =new File("clients.txt");

    	/* This logic is to create the file if the
    	 * file is not already present
    	 */
    	if(!file.exists()){
    	   file.createNewFile();
    	}

    	//Here true is to append the content to file
    	FileWriter fw = new FileWriter(file,true);
    	//BufferedWriter writer give better performance
    	BufferedWriter bw = new BufferedWriter(fw);
        //PrintWriter writer for more higher performance
        PrintWriter pw = new PrintWriter(bw);
    	
        
        
    	
        //This will add a new line to the file content
        /* Below three statements would add three 
         * mentioned Strings to the file in new lines.
         */
         
         
//              Clients = new Arraylist();
             String clients_json = new Gson().toJson(Clients);
                       pw.println(clients_json);

    	//Closing BufferedWriter Stream
         pw.close();
        //This will add a new line to the file content
    	  

      }catch(Exception e){
         System.out.println("Exception occurred \" ERROR \"");
       }
        
        
        //SAVE ADMINS
        try{
    	
        //Specify the file name and path here
    	File file =new File("admins.txt");

    	/* This logic is to create the file if the
    	 * file is not already present
    	 */
    	if(!file.exists()){
    	   file.createNewFile();
    	}

    	//Here true is to append the content to file
    	FileWriter fw = new FileWriter(file,true);
    	//BufferedWriter writer give better performance
    	BufferedWriter bw = new BufferedWriter(fw);
        //PrintWriter writer for more higher performance
        PrintWriter pw = new PrintWriter(bw);
    	
        
        
    	
        //This will add a new line to the file content
        /* Below three statements would add three 
         * mentioned Strings to the file in new lines.
         */
         
         
//              Clients = new Arraylist();
             String clients_json = new Gson().toJson(Admins);
                       pw.println(clients_json);

    	//Closing BufferedWriter Stream
         pw.close();
        //This will add a new line to the file content
    	  

      }catch(Exception e){
         System.out.println("Exception occurred \" ERROR \"");
       }
        
        
        //SAVE TELLERS
        try{
    	
        //Specify the file name and path here
    	File file =new File("tellers.txt");

    	/* This logic is to create the file if the
    	 * file is not already present
    	 */
    	if(!file.exists()){
    	   file.createNewFile();
    	}

    	//Here true is to append the content to file
    	FileWriter fw = new FileWriter(file,true);
    	//BufferedWriter writer give better performance
    	BufferedWriter bw = new BufferedWriter(fw);
        //PrintWriter writer for more higher performance
        PrintWriter pw = new PrintWriter(bw);
    	
        
        
    	
        //This will add a new line to the file content
        /* Below three statements would add three 
         * mentioned Strings to the file in new lines.
         */
         
         
//              Clients = new Arraylist();
             String clients_json = new Gson().toJson(Tellers);
                       pw.println(clients_json);

    	//Closing BufferedWriter Stream
         pw.close();
        //This will add a new line to the file content
    	  

      }catch(Exception e){
         System.out.println("Exception occurred \" ERROR \"");
       }
        
        
    
    }
    
}
