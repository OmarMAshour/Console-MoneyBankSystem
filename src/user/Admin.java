/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import static moneybanksystem.MoneyBankSystem.Admins;

/**
 *
 * @author root
 */
public class Admin extends User{

    public Admin() {
    }

    public Admin( String name, String username, String password) {
        super(name, username, password);
        id = "A"+ (Admins.size()+1);
        
    }
    
    public boolean addUser(User user, String type){
        
        //TO BE DEClARED
        
        return false;
        
    }
    
    public boolean removeUser(User user, String type){
        //TO BE DEClARED
        
        return false;
    }
    
    public boolean SaveDate(){
        //TO BE DEClARED
        
        return false;
    }
    
    public boolean LoadData(){
        //TO BE DEClARED
        
        return false;
        
    }
    
}
