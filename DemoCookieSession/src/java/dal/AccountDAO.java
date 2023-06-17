/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import model.Account;

/**
 *
 * @author macbookair
 */
public class AccountDAO {
    
    public Account getAccountByUsernameAndPassword(String username,
            String password)
    {
        if(username.equals("billy") && password.equals("12345"))
        {
            Account account = new Account();
            account.setUsername(username);
            account.setPassword(password);
            return account;
        }
        else
            return null;
    }
    
}
