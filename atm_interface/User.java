package atm_interface;

import java.util.ArrayList;

public class User {
    private String name;
    private int password;
    private int balance;
    private int uid;
    

    private ArrayList<String> tHistory;


    public User(String name, int password, int uid) {
        this.name = name;
        this.password = password;
        this.uid = uid;
    }
    public int getUid() {
        return uid;
    }

    public int getBalance() {
        return this.balance;
    }

    public ArrayList<String> getTransactionsHistory() {
        return this.tHistory;
    }


    public void transfer() {
        
    }

    public void widraw(int amount) {
        this.balance = this.balance - amount;
        this.tHistory.add(String.format("Withdrawal: -₹%d  New balance: ₹%d", amount, balance));
    }

    public void diposit(int amount) {
        this.balance = this.balance + amount;
        this.tHistory.add(String.format("Diposit: +₹%d  New balance: ₹%d", amount, balance));
    }


    public boolean isSameUser(String name, int password) {
        if (this.name.toLowerCase().equals(name.toLowerCase()) && this.password == password) {
            return true;
        }
        return false;
    }




}
