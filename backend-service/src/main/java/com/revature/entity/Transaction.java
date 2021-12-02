package com.revature.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public double amount;
    @Column(name="type")
    @Enumerated(EnumType.STRING)
    public TransactionType type;
    @Temporal(TemporalType.TIMESTAMP)
    public Date date;
    @Transient
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="account_number")
    public Account account_number;

    public Account getAccount_number() {
        return account_number;
    }

    public void setAccount_number(Account account_number) {
        this.account_number = account_number;
    }

    public TransactionType getType() {
        return type;
    }

    public Transaction() {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}