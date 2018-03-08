/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

import user.Client;
import user.Teller;

/**
 *
 * @author root
 */
public class Transfer extends Transaction{

    private double amount;
    private Client toCLient;

    public Transfer(double amount, Client toCLient, Client client, Teller teller) {
        super(client, teller);
        this.amount = amount;
        this.toCLient = toCLient;
    }

    public double getAmount() {
        return amount;
    }

    public Client getToCLient() {
        return toCLient;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setToCLient(Client toCLient) {
        this.toCLient = toCLient;
    }
    
    
    @Override
    public boolean doTrans() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
