package Assignment6;
import netscape.security.UserTarget;

import java.util.*;

public class UserData {
    private User user;
    private String password;
    private double balance;
    private List<String> recentTransaction;

    UserData() {
        balance = 0.0;
    }

    UserData(User user, String password){
        this.password = password;
        this.user = user;
        balance = 0.0;
        recentTransaction = new ArrayList<>();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRecentTransaction(String recentTransaction) {
        this.recentTransaction.add(recentTransaction);
    }

    public List<String> getRecentTransaction() {
        return recentTransaction;
    }


}
