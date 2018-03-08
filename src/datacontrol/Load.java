/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datacontrol;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.List;
import user.Client;
import static moneybanksystem.MoneyBankSystem.Clients;
import static moneybanksystem.MoneyBankSystem.Admins;
import static moneybanksystem.MoneyBankSystem.Tellers;
import user.Admin;
import user.Teller;

/**
 *
 * @author root
 */
public class Load extends DataControl{
    
    
    public static void perform(){
        
        // LOAD CLIENTS
              try{
            
           BufferedReader br = null;

           br = new BufferedReader(new FileReader("clients.txt"));		

           //One way of reading the file
	  
               String x = br.readLine();
               
//                x = new Gson().toJson(m);
//               br.r
//            JsonArray ar = new JsonArray();
                  java.lang.reflect.Type t = new TypeToken<List<Client>>() {}.getType();
                Clients= new Gson().fromJson(x, t);     
          
           br.close();
              }
           
           catch(Exception e){
                   System.out.println("Exception in loading clients.txt try/catch 1");
                   }
              
              
              //LOAD ADMINS
               try{
            
           BufferedReader br = null;

           br = new BufferedReader(new FileReader("admins.txt"));		

           //One way of reading the file
	  
               String x = br.readLine();
               
//                x = new Gson().toJson(m);
//               br.r
//            JsonArray ar = new JsonArray();
                  java.lang.reflect.Type t = new TypeToken<List<Admin>>() {}.getType();
                Admins= new Gson().fromJson(x, t);     
          
           br.close();
              }
           
           catch(Exception e){
                   System.out.println("Exception in loading admins.txt try/catch 1");
                   }
               
               
               //LOAD TELLERS
                try{
            
           BufferedReader br = null;

           br = new BufferedReader(new FileReader("tellers.txt"));		

           //One way of reading the file
	  
               String x = br.readLine();
               
//                x = new Gson().toJson(m);
//               br.r
//            JsonArray ar = new JsonArray();
                  java.lang.reflect.Type t = new TypeToken<List<Teller>>() {}.getType();
                Tellers= new Gson().fromJson(x, t);     
          
           br.close();
              }
           
           catch(Exception e){
                   System.out.println("Exception in loading tellers.txt try/catch 1");
                   }
                
           

    
    }

   
    
}
