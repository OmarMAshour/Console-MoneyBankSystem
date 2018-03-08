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
public abstract class Transaction {
    
    
    protected Client client;
    protected Teller teller;

    public Transaction() {
    }

    public Transaction(Client client, Teller teller) {
        this.client = client;
        this.teller = teller;
    }

    public Client getClient() {
        return client;
    }

    public Teller getTeller() {
        return teller;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTeller(Teller teller) {
        this.teller = teller;
    }
   
    
    
    public  abstract boolean doTrans();
    
}
