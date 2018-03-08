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
public class Deposit extends Transaction{
    
    private double amount;

    public Deposit(double amount, Client client, Teller teller) {
        super(client, teller);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
    @Override
    public boolean doTrans() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
