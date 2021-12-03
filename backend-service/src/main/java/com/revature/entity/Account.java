package com.revature.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String number;
    private double balance;
   

    public Account(){}
    public Account(String number) {
        this.number = number;
    }

    public Account(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }
    @OneToMany(fetch=FetchType.EAGER)

    public List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }



    public void setNumber(String number) {
        this.number = number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                '}';
    }

}
