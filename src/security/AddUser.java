/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import static moneybanksystem.MoneyBankSystem.Clients;
import static moneybanksystem.MoneyBankSystem.Tellers;
import user.Client;
import user.ClientAccount;
import user.Teller;

/**
 *
 * @author root
 */
public class AddUser extends Security{
    
    
    public static void AddClient(String name, String username, String password, double balance, boolean opened, ClientAccount type ){
        
        Clients.add(new Client(balance, opened, type, name, username, password));
        
    }
    
    public static void AddTeller(String name , String username, String password ){
        Tellers.add(new Teller(name, username, password));
    }
}
