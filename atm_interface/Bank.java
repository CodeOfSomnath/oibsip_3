package atm_interface;

import java.util.ArrayList;

public class Bank {
    private ArrayList<User> bankUsers;
    private User currentUser;

   

    public Bank() {
        // creating some test user
        this.bankUsers = new ArrayList<>();
        this.bankUsers.add(new User("Somnath", 9876,1));
        this.bankUsers.add(new User("Rohan", 8956, 2));
        this.bankUsers.add(new User("Rahul", 4564, 3));
    }

    public boolean authUser(String name, int pass) {
        for (User user : bankUsers) {
            if (user.isSameUser(name, pass)) {
                this.currentUser = user;
                return true;
            }
        }
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public User getByUid(int uid) {
        for (User user : bankUsers) {
            if (user.getUid() == uid) {
                return user;
            }
        }
        return null;
    }

}
