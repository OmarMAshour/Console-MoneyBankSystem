/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import static moneybanksystem.MoneyBankSystem.Clients;
import static moneybanksystem.MoneyBankSystem.Admins;
import static moneybanksystem.MoneyBankSystem.Tellers;
import static moneybanksystem.MoneyBankSystem.LoggedType;
import static moneybanksystem.MoneyBankSystem.LoggedUser;
import user.Client;
import user.Teller;
import user.Admin;
import user.User;
import user.UsersEnum;
import java.util.ArrayList;

/**
 *
 * @author root
 */



public class VerifyUser extends Security{
    
//    public static ArrayList<User> array;
//    
//    public static void setArray(){
//        for(int i =0; i<Clients.size();i++){
//            array.add(Clients.get(i));
//        }
//        
//        for(int j =0; j<Tellers.size();j++){
//            array.add(Tellers.get(j));
//        }
//        
//        for(int k=0;k<Admins.size();k++){
//            array.add(Admins.get(k));
//        }
//    }
    
    public static boolean perform(String username, String password){
        
       
//        setArray();
//        
//        for(int i =0;i<array.size();i++){
//            if(array.get(i).getUsername().equals(username) && array.get(i).getPassword().equals(password)){
//                LoggedUser = array.get(i);
//                return true;
//            }
//        }
        
        
        for(User c:Clients){
            if(c.getUsername().equals(username) && c.getPassword().equals(password)){
                LoggedType = UsersEnum.CLIENT;
                LoggedUser = c;
                return true;
            }
        }
        
        for(User a:Admins){
            if(a.getUsername().equals(username) && a.getPassword().equals(password)){
                LoggedType = UsersEnum.ADMIN;
                LoggedUser = a;
                return true;
            }
        }
        
        for(User t:Tellers){
            if(t.getUsername().equals(username) && t.getPassword().equals(password)){
                LoggedType = UsersEnum.TELLER;
                LoggedUser = t;
                
                return true;
            }
        }
        
        
        return false;
    }
    
    public static boolean checkClient(String id){
        
        for(Client c:Clients){
            if(c.getId().equals(id))
                return true;
        }
        
        return false;
        
    }
    
    
    public static boolean VerifyClient(String username, String password){
         for(Client c:Clients){
            if(c.getUsername().equals(username) && c.getPassword().equals(password)){
                LoggedType = UsersEnum.CLIENT;
                LoggedUser = c;
                return true;
            }
        }
        return false;
    }
    
    public static boolean VerifyAdmin(String username, String password){
        for(Admin a:Admins){
            if(a.getUsername().equals(username) && a.getPassword().equals(password)){
                LoggedType = UsersEnum.ADMIN;
                LoggedUser = a;
                return true;
            }
        }
        return false;
    }
    
    public static boolean VerifyTeller(String username, String password){
         for(Teller t:Tellers){
            if(t.getUsername().equals(username) && t.getPassword().equals(password)){
                LoggedType = UsersEnum.TELLER;
                LoggedUser = t;
                
                return true;
            }
        }
        return false;
    }
    
//    public static boolean checkClient(String id){
//        
//        for(Client c:Clients){
//            if(c.getId().equals(id)){
//                return true;
//            }
//        }
//        
//        return false;
//    }
}
