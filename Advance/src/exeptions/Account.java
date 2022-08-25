package exeptions;

import java.io.IOException;

public class Account {
    private double balance;
    public void deposit(double value) throws IOException {
        if(value<=0)
        {
            throw new IOException();
        }
    }
    public void withdraw(double value) throws AccountException {
        if(value>balance){
            throw new AccountException(new InsufficientFundsException());
        }
    }
}
