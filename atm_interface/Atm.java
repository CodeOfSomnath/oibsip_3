package atm_interface;

import java.util.ArrayList;
import java.util.Scanner;

public class Atm {
    private Bank bank;
    private Scanner sc;

    public Atm() {
        this.bank = new Bank();
        sc = new Scanner(System.in);
    }

    public boolean login() {
        System.out.println("Enter user name:");
        String name = sc.nextLine();
        System.out.println("Enter password:");
        int pass = sc.nextInt();
        return bank.authUser(name, pass);
    }

    public void showHistory() {
        User user = bank.getCurrentUser();
        ArrayList<String> history = user.getTransactionsHistory();
        for (String s : history) {
            System.out.println(s);
        }
    }

    public void logout() {
        sc.close();
    }

    public void dipositBalance() {
        User user = bank.getCurrentUser();
        System.out.println("Enter the amount: ");
        int balance = sc.nextInt();
        user.diposit(balance);
        System.out.println("diposit succesfull.");
        System.out.printf("Current Balance: ₹%d\n", user.getBalance());
    }

    public void transferBalance() {
        System.out.println("Enter the reciver uid:");
        int reciverUid = sc.nextInt();
        User reciver = bank.getByUid(reciverUid);
        User currentUser = bank.getCurrentUser();
        System.out.println("Enter the amount: ");
        int balance = sc.nextInt();
        if (balance <= currentUser.getBalance()) {
            currentUser.widraw(balance);
            reciver.diposit(balance);
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    public void widrawBalance() {
        User user = bank.getCurrentUser();
        System.out.println("Enter the amount: ");
        int balance = sc.nextInt();

        if (balance <= user.getBalance()) {
            user.widraw(balance);
            System.out.println("widraw succesfull.");
            System.out.printf("Current Balance: ₹%d\n", user.getBalance());
        } else {
            System.out.println("Insufficient Balance.");
        }
        
    }
    
    
}
