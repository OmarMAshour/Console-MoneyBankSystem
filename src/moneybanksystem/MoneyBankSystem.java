/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneybanksystem;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import currency.CurrencyExchange;
import datacontrol.Clear;
import datacontrol.Load;
import datacontrol.Save;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import security.AddUser;
import security.RemoveUser;
import user.Admin;
import user.Client;
import user.Teller;
import user.ClientAccount;
import user.UsersEnum;
import security.VerifyUser;
import user.ATM;
import user.User;
/**
 *
 * @author root
 */
public class MoneyBankSystem {
    
    
    public static ArrayList<Client> Clients =new ArrayList<Client>();
    public static ArrayList<Admin> Admins =new ArrayList<Admin>();
    public static ArrayList<Teller> Tellers =new ArrayList<Teller>();
    public static UsersEnum LoggedType;
    public static User LoggedUser;
    
    public static Client getClient(String id){
        
        for(Client c:Clients){
            if(c.getId().equals(id)){
                return c;
            }
        }
        System.out.println("Client doesn't exist !!");
        return null;
    }
    
    

    
    public static boolean Login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("********Welcome To Our Bank********");
        System.out.println();
        System.out.println("Login...");
        System.out.println();
        System.out.print("Username: ");
        String username = sc.next();
        System.out.print("Password: ");
        String password = sc.next();
        System.out.println();
        
        
        return VerifyUser.perform(username, password);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
                Load.perform();
                
//                readJsonFromUrl("http://apilayer.net/api/live?access_key=a921fa1d6ebd929f0a7f6e861cf9f73f");
//                
//                for(Teller a : Tellers){
//                    System.out.println(a.getUsername());
//                }
//                
//                for(Admin x : Admins){
//                    System.out.println(x.getUsername());
//                }
                Scanner sc = new Scanner(System.in);
                if(Login()){
                    System.out.println("Logged in successfully !!!");
                    System.out.println();
                    System.out.println("******************************");
                    System.out.println();
                    System.out.println("Welcome "+LoggedUser.getName()+" ,");
                    System.out.println();
                    System.out.println("Kindly enter the number of the process you want to perform...");
                }else{
                    System.out.println("User doesn't exits !!!");
                    System.exit(0);
                }
                
                
                switch(LoggedType){
                    
                    case CLIENT:{
                        
                        ATM atm = new ATM();
                        atm.setClient((Client)LoggedUser);

                        System.out.println();
                        System.out.println("1 ==> Deposit");
                        System.out.println("2 ==> Withdraw");
                        System.out.println("3 ==> Transfer");
                        System.out.println("4 ==> Change Currency");
                        
                        System.out.println();
                        
                        System.out.print("Your Choice: ");
                        int choice = sc.nextInt();
                        
                        switch(choice){
                            case 1:{
                                System.out.println("");
                                System.out.print("Enter the amount of money you want to deposit: ");
                                double amount = sc.nextDouble();
                                
                                atm.doDeposit(amount);
                                
                                System.out.println("Your Transaction is done successfully /n Thanks for using our bank system.");
                                
                                break;
                            }
                            
                            case 2:{
                               
                               System.out.println("");
                                System.out.print("Enter the amount of money you want to withdraw: "); 
                                double amount = sc.nextDouble();

                                if(atm.doWithdraw(amount)){
                                System.out.println("Your Transaction is done successfully /n Thanks for using our bank system.");

                            }else{
                                    System.out.println("Your account balance is smaller than the required amount !!! /n Thanks for using our bank system.");
                                }
                                
                                break;
                            }
                            
                            case 3:{
                                
                                System.out.println("");
                                System.out.print("Enter the amount of money you want to transfer: ");
                                double amount = sc.nextDouble();
                                System.out.print("Enter the id of the client account you want to transfer to: ");
                                String accountId = sc.next();
                                
                                if(!VerifyUser.checkClient(accountId)){
                                    System.out.println("The account id you entered doesn't exist !!! /n Thanks for using our bank system.");
                                break;
                                }
                                
                                if(atm.doTransfer(amount, accountId)){
                                System.out.println("Your Transaction is done successfully /n Thanks for using our bank system.");
                                    
                                }else{
                                    System.out.println("Your account balance is smaller than the required amount to transfer !!! /n Thanks for using our bank system.");
                                    
                                }
                               
                                
                                break;
                            }
                            
                            case 4:{
                               
        // TO BE DECLARED       
                                System.out.println("");
                                System.out.println("Knowing that the main currency is USD...");
                                System.out.println("Enter your choice for the following...");
                                System.out.println("");
                                System.out.println("1 ==> Change to USD");
                                System.out.println("2 ==> Change from USD");
                                System.out.println("");
                                System.out.print("Your Choice: ");
                                int  x = sc.nextInt();
                                
                                switch(x){
                                    
                                    case 1:{
                                        
                                        System.out.println("");
                                        System.out.print("Enter the name of the currency you want to change it to USD Ex. USD, EGP, EUR...etc :");
                                        String from = sc.next();
                                        System.out.print("Enter the amount of money you want to change: ");
                                        double amount = sc.nextDouble();
                                        System.out.println("You know after the exchange have "+atm.ChangeCurrencyToUSD(amount, from)+ "USD");
                                        System.out.println("");
                                        System.out.println("Your Transaction is done successfully \n Thanks for using our bank system.");
                                        System.out.println("");
                                        
                                        break;
                                    }
                                    
                                    case 2:{
                                        
                                         System.out.println("");
                                        System.out.print("Enter the name of the currency you want to change to it from USD Ex. USD, EGP, EUR...etc :");
                                        String to = sc.next();
                                        System.out.print("Enter the amount of money you want to change: ");
                                        double amount = sc.nextDouble();
                                        System.out.println("You know after the exchange have "+atm.ChangeCurrencyFromUSD(amount, to)+ to);
                                        System.out.println("");
                                        System.out.println("Your Transaction is done successfully \n Thanks for using our bank system.");
                                        System.out.println("");
                                        
                                        break;
                                    }
                                    
                                    default:{
                                        System.out.println("Wrong Entry !!! \n Thanks for using our bank system.");
                                    }
                                }
                                
                                break;
                            }
                            
                            default:{
                                System.out.println("Wrong Entry !!! \n Thanks for using our bank system.");
                            }
                            
                        }
                        
                        



                        
                        
                        break;
                    }
                    
                    case TELLER:{
                        
                        Teller teller = (Teller)LoggedUser;
                        
                        System.out.println();
                        System.out.println("1 ==> Deposit");
                        System.out.println("2 ==> Withdraw");
                        System.out.println("3 ==> Transfer");
                        System.out.println("4 ==> Change Currency");
                        
                        System.out.println();
                        
                        System.out.print("Your Choice: ");
                        int choice = sc.nextInt();
                        
                        switch(choice){
                            case 1:{
                                System.out.println("");
                                System.out.print("Enter the amount of money you want to deposit: ");
                                double amount = sc.nextDouble();
                                System.out.print("Enter the id of the client account you want to deposit to: ");
                                String accountId = sc.next();
                                
                                if(!VerifyUser.checkClient(accountId)){
                                    System.out.println("The account id you entered doesn't exist !!! \n Thanks for using our bank system.");
                                    break;
                                }
                                
                                teller.setClient(getClient(accountId));
                                
                                if(VerifyUser.checkClient(accountId)){
                                teller.doDeposit(amount);
                                
                                System.out.println("Your Transaction is done successfully \n Thanks for using our bank system.");
                                }
                                break;
                            }
                            
                            case 2:{
                               
                               System.out.println("");
                                System.out.print("Enter the amount of money you want to withdraw: "); 
                                double amount = sc.nextDouble();
                                System.out.print("Enter the id of the client account you want to withdraw to: ");
                                String accountId = sc.next();
                                
                                if(!VerifyUser.checkClient(accountId)){
                                    System.out.println("The account id you entered doesn't exist !!! \n Thanks for using our bank system.");
                                    break;
                                }
                                
                                teller.setClient(getClient(accountId));
                                
                                if(VerifyUser.checkClient(accountId)){
                                if(teller.doWithdraw(amount)){
                                   System.out.println("Your Transaction is done successfully \n Thanks for using our bank system.");

                                }else{
                                    System.out.println("Your account balance is smaller than the required amount !!! \n Thanks for using our bank system.");
                                }
                                
                                }

                               
                                
                                break;
                            }
                            
                            case 3:{
                                
                                System.out.println("");
                                System.out.print("Enter the amount of money you want to transfer: ");
                                double amount = sc.nextDouble();
                                System.out.print("Enter the id of the client account you want to transfer from: ");
                                String clientId = sc.next();
                                System.out.print("Enter the id of the client account you want to transfer to: ");
                                String accountId = sc.next();
                                
                                if(!VerifyUser.checkClient(accountId)){
                                    System.out.println("The account id that you want to transfer to doesn't exist !!! \n Thanks for using our bank system.");
                                    break;
                                }
                                
                                if(!VerifyUser.checkClient(clientId)){
                                    System.out.println("The account id that you want to transfer from doesn't exist !!! \n Thanks for using our bank system.");
                                    break;
                                }
                                
                                teller.setClient(getClient(clientId));
                                
                                if(teller.doTransfer(amount, accountId)){
                                System.out.println("Your Transaction is done successfully \n Thanks for using our bank system.");
                                    
                                }else{
                                    System.out.println("Your account balance is smaller than the required amount to transfer !!! \n Thanks for using our bank system.");
                                    
                                }
                               
                                
                                break;
                            }
                            
                            case 4:{
                               
        // TO BE DECLARED 
        
                                System.out.println("");
                                System.out.println("Knowing that the main currency is USD...");
                                System.out.println("Enter your choice for the following...");
                                System.out.println("");
                                System.out.println("1 ==> Change to USD");
                                System.out.println("2 ==> Change from USD");
                                System.out.println("");
                                System.out.print("Your Choice: ");
                                int  x = sc.nextInt();
                                
                                switch(x){
                                    
                                    case 1:{
                                        
                                        System.out.println("");
                                        System.out.print("Enter the name of the currency you want to change it to USD Ex. USD, EGP, EUR...etc :");
                                        String from = sc.next();
                                        System.out.print("Enter the amount of money you want to change: ");
                                        double amount = sc.nextDouble();
                                        System.out.println("You know after the exchange have "+teller.ChangeCurrencyToUSD(amount, from)+ "USD");
                                        System.out.println("");
                                        System.out.println("Your Transaction is done successfully \n Thanks for using our bank system.");
                                        System.out.println("");
                                        
                                        break;
                                    }
                                    
                                    case 2:{
                                        
                                         System.out.println("");
                                        System.out.print("Enter the name of the currency you want to change to it from USD Ex. USD, EGP, EUR...etc :");
                                        String to = sc.next();
                                        System.out.print("Enter the amount of money you want to change: ");
                                        double amount = sc.nextDouble();
                                        System.out.println("You know after the exchange have "+teller.ChangeCurrencyFromUSD(amount, to)+ to);
                                        System.out.println("");
                                        System.out.println("Your Transaction is done successfully \n Thanks for using our bank system.");
                                        System.out.println("");
                                        
                                        break;
                                    }
                                    
                                    default:{
                                        System.out.println("Wrong Entry !!! \n Thanks for using our bank system.");
                                    }
                                }
                                
                                break;
                            }
                            
                            default:{
                                System.out.println("Wrong Entry !!! \n Thanks for using our bank system.");
                            }
                            
                        }
                        
                        break;
                    }
                    
                    
                    case ADMIN:{
                        
                        Admin admin = (Admin)LoggedUser;
                        
                        System.out.println();
                        System.out.println("1 ==> Add User");
                        System.out.println("2 ==> Remove User");
//                        System.out.println("4 ==> Change Currency");
                        
                        System.out.println();
                        
                        System.out.print("Your Choice: ");
                        int choice = sc.nextInt();
                        
                        switch(choice){
                            
                            case 1:{
                                
                                 System.out.println("");
                                System.out.println("Enter your choice for the following...");
                                System.out.println("");
                                System.out.println("1 ==> Add Teller");
                                System.out.println("2 ==> Add Client");
                                System.out.println("");
                                System.out.print("Your Choice: ");
                                int  x = sc.nextInt();
                                
                                switch(x){
                                    
                                    case 1:{
                                        
                                        System.out.println("");
                                System.out.println("Enter your choice for the following...");
                                System.out.println("");
                                System.out.print("Enter Name: ");
                                String name = sc.next();
                                System.out.print("Enter Username: ");
                                String username = sc.next();
                                System.out.print("Enter Password: ");
                                String password = sc.next();
                                Tellers.add(new Teller(name, username, password));
                                System.out.println("");
                                
                                System.out.println("Your Transaction is done successfully \n Thanks for using our bank system.");

                                        
                                        
                                        
                                        break;
                                    }
                                    
                                    case 2:{
                                        
                                        System.out.println("");
                                System.out.println("");
                                System.out.print("Enter Name: ");
                                String name = sc.next();
                                System.out.print("Enter Username: ");
                                String username = sc.next();
                                System.out.print("Enter Password: ");
                                String password = sc.next();
                                System.out.print("Enter Balance: ");
                                double balance = sc.nextDouble();
                                System.out.print("Enter is openeed boolean: ");
                                boolean opened = sc.nextBoolean();
                                System.out.print("Enter account type ... 1 ==> Saving ... 2 ==> Checking : ");
                                int acc =sc.nextInt();
                                ClientAccount type;
                                if(acc == 1){
                                    type = ClientAccount.SAVING;
                                }else if (acc == 2){
                                    type = ClientAccount.CHECKING;
                                }else{
                                    type = ClientAccount.SAVING;
                                    System.out.println("Wrong Entry !!! ");
                                    System.exit(0);
                                }
                                        
                                        AddUser.AddClient(name, username, password, balance, opened, type);
                                System.out.println("");
                                
                                System.out.println("Your Transaction is done successfully \n Thanks for using our bank system.");

                                        
                                        break;
                                    }
                                    
                                }
                                
                                break;
                            }
                            
                            
                            
                            case 2:{
                                
                                System.out.println("");
                                System.out.println("Enter your choice for the following...");
                                System.out.println("");
                                System.out.println("1 ==> Remove Teller");
                                System.out.println("2 ==> Remove Client");
                                System.out.println("");
                                System.out.print("Your Choice: ");
                                int  x = sc.nextInt();
                                
                                switch(x){
                                    
                                    case 1:{
                                        
                                        System.out.println("");
                               
                                System.out.print("Enter id of the teller: ");
                                String id = sc.next();
                                
                                RemoveUser.RemoveTeller(id);
                                System.out.println("");
                                
                                System.out.println("Your Transaction is done successfully \n Thanks for using our bank system.");

                                        
                                        
                                        
                                        break;
                                    }
                                    
                                    case 2:{
                                        
                                        System.out.println("");
                               
                                System.out.print("Enter id of the client: ");
                                String id = sc.next();
                                
                                RemoveUser.RemoveClient(id);
                                System.out.println("");
                                
                                System.out.println("Your Transaction is done successfully \n Thanks for using our bank system.");

                                        
                                        
                                        break;
                                    }
                                    
                                }
                                
                                
                                break;
                            }
                            
                            
                        }
                        
                        
                        
                        break;
                    }
                        
                        
                        
                    
                    
                    
                }

//        Clients.add(new Client(1000, true, ClientAccount.SAVING, "Omar Ashour", "OA","1234"));
//        Tellers.add(new Teller("Teller Mohamed","teller1","teller1234"));
//        Admins.add(new Admin("Admin", "admin", "admin1234"));

//        Save.perform();
                Clear.perform();
                Save.perform();

    }
    
}
