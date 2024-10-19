package atm_interface;

import java.util.ArrayList;

public class User {
    private String name;
    private int password;
    private double balance;
    private int uid;
    

    private ArrayList<String> tHistory;


    public User(int uid, String name, int password, int initBalance) {
        this.name = name;
        this.password = password;
        this.uid = uid;
        this.balance = initBalance;
        tHistory = new ArrayList<>();
    }
    public int getUid() {
        return uid;
    }

    public double getBalance() {
        return this.balance;
    }

    public ArrayList<String> getTransactionsHistory() {
        return this.tHistory;
    }


    public void transfer(double amount, User reciver) {
        this.balance = this.balance - amount;
        reciver.diposit(amount);
        this.tHistory.add(String.format("Transfer of ₹%.2f to uid %d  New balance: ₹%.2f", amount, reciver.getUid(), this.getBalance()));
    }

    public void widraw(double amount) {
        this.balance = this.balance - amount;
        this.tHistory.add(String.format("Withdrawal: -₹%.2f  New balance: ₹%.2f", amount, balance));
    }

    public void diposit(double amount) {
        this.balance = this.balance + amount;
        this.tHistory.add(String.format("Diposit: +₹%.2f  New balance: ₹%.2f", amount, balance));
    }


    public boolean isSameUser(String name, int password) {
        if (this.name.toLowerCase().equals(name.toLowerCase()) && this.password == password) {
            return true;
        }
        return false;
    }




}
