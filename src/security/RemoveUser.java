/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import static moneybanksystem.MoneyBankSystem.Clients;
import static moneybanksystem.MoneyBankSystem.Tellers;
import user.Client;
import user.Teller;

/**
 *
 * @author root
 */
public class RemoveUser extends Security{
    
    
    public static void RemoveClient(String id){
        
        for(Client c:Clients){
            if(c.getId().equals(id)){
                Clients.remove(c);
            }
        }
        
        
    }
    
    
    public static void RemoveTeller(String id){
        
        for(Teller c:Tellers){
            if(c.getId().equals(id)){
                Tellers.remove(c);
            }
        }
        
        
    }
    
    
}
