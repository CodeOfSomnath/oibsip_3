import java.util.Scanner;

import atm_interface.Atm;

public class Main {
    public static void prompt() {
        System.out.println("\t******* Welcome to atm cli *******");
        System.out.println("\t\t1. Transactions History");
        System.out.println("\t\t2. Withdraw");
        System.out.println("\t\t3. Deposit");
        System.out.println("\t\t4. Transfer");
        System.out.println("\t\t5. Quit");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;

        Atm atm = new Atm();

        while (true) {
            if (atm.login()) {
                while (true) {
                    prompt();
                    System.out.println("Enter your option(1-5):");
                    option = sc.nextInt();
                    if (option == 1) {
                        // history
                        atm.showHistory();
                    } else if (option == 2) {
                        // widraw
                        atm.widrawBalance();
                    }
                    else if (option == 3) {
                        // deposit
                        atm.dipositBalance();
                    }
                    else if (option == 4) {
                        atm.transferBalance();
                    }
                    else if (option == 5) {
                        atm.flush();
                        System.out.println("Goodbye! Thank you for using.");
                        break;
                    }
                    else {
                        System.out.println("Invalid choice, please try again.");
                    }
                }
            } else {
                atm.flush();
                System.out.println("Unable to login, username or password is incorrect.");
            }
        }
    }
}
