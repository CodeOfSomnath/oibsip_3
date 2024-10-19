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

    public void flush() {
        sc.nextLine(); // flushing all input
    }

    public void showHistory() {
        User user = bank.getCurrentUser();
        ArrayList<String> history = user.getTransactionsHistory();
        for (String s : history) {
            System.out.println(s);
        }
    }

    public void dipositBalance() {
        User user = bank.getCurrentUser();
        System.out.println("Enter the amount: ");
        double balance = sc.nextDouble();
        user.diposit(balance);
        System.out.println("diposit succesfull.");
        System.out.printf("Current Balance: ₹%.2f\n", user.getBalance());
    }

    public void transferBalance() {
        User currentUser = bank.getCurrentUser();
        System.out.println("Enter the reciver uid:");
        int reciverUid = sc.nextInt();
        if (reciverUid == currentUser.getUid()) {
            System.out.println("Same user transfer is not allowed.");
        }
        User reciver = bank.getByUid(reciverUid);
        if (reciver == null) {
            System.out.printf("Unable to find user with id %d\n", reciverUid);
            return;
        }

        
        System.out.println("Enter the amount: ");
        double balance = sc.nextDouble();
        if (balance <= currentUser.getBalance()) {
            currentUser.transfer(balance, reciver);
            System.out.printf("Transfer successful, new balance: $%.2f\n", currentUser.getBalance());
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    public void widrawBalance() {
        User user = bank.getCurrentUser();
        System.out.println("Enter the amount: ");
        double balance = sc.nextDouble();

        if (balance <= user.getBalance()) {
            user.widraw(balance);
            System.out.println("widraw succesfull.");
            System.out.printf("Current Balance: ₹%.2f\n", user.getBalance());
        } else {
            System.out.println("Insufficient Balance.");
        }
        
    }
    
    
}
