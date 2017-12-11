package Assignment6;

import java.util.*;

public class Atm {

    double availableAmountInMachine; //  should be private
    double transactionFee;
    static List<UserData> userList;
    UserData current;
    Scanner sc = new Scanner(System.in);
    //
    protected static List<String> transactions;

    public static void main(String[] args) {
        Atm atm = new Atm(99999999.0, 2.0);
        atm.start();
        //

    }

    public Atm(double availableAmountInMachine, double transactionFee) {
        this.availableAmountInMachine = availableAmountInMachine;
        this.transactionFee = transactionFee;
        userList = new ArrayList<>();
        transactions = new ArrayList<>();
        //
       // User user1 = new User("1",1,"1","1","1");
        //current = new UserData(user1, "000");
        //userList.add(current);
    }

    void login() {
        //String account,pw;
        String bankAccountNumber;
        String password;
        boolean b;
        do{
            System.out.print("Please enter account:");
            bankAccountNumber = sc.next();
            System.out.print("Please enter password:");
            password = sc.next();
            b = check(bankAccountNumber, password);
            if(b == false) {
                System.out.println("Your account number or password is wrong!");
                System.out.println("if forget password, press 1; if try again, press 0");
                int decision = sc.nextInt();
                if (decision == 1) {
                    forgotPassword(bankAccountNumber);
                    b = true;
                }
            }
            if (b == true) {
                operate();
            }
        } while (b == false);
    }

    boolean check(String bankAccountNumber, String password) {
        UserData a;
        for(int i = 0; i < userList.size(); i++){
            a = userList.get(i);
            if (bankAccountNumber.equals(a.getUser().getBankAccountNumber())
                    && password.equals(a.getPassword())) {
                current = a;
                return true;
            }
        }
        return false;
    }

    boolean validate(String name, int age, String phone) {
        //UserData userData = userList.get();
        if (current.getUser().getName().equals(name)
                && current.getUser().getAge() == age
                && current.getUser().getPhoneNumber().equals(phone)) {
            return true;
        }
        return false;

    }

    public void operate() {
        int i;
        do {
            System.out.println("please choose:");
            System.out.println("1:Available Balance;");
            System.out.println("2:Withdraw;");
            System.out.println("3:Deposit");
            System.out.println("4:recentTransactions");
            System.out.println("5:changePassword");
            System.out.println("6:quit");
            try {
                i = sc.nextInt();
                if (i == 1) {
                    availableBalance();
                } else if (i == 2) {
                    System.out.println("\nHow much would you like to withdrawal?");
                    double withdrawalMoney = Double.valueOf(sc.next());
                    withDrawal(withdrawalMoney);
                } else if (i == 3) {
                    System.out.println("\nHow much would you like to deposit?");
                    double depositMoney = Double.valueOf(sc.next());
                    deposit(depositMoney);
                } else if (i == 4) {
                    recentTransactions();
                } else if (i == 5) {
                    System.out.print("\nPlease set your new password:");
                    changePassword(sc.next());
                } else if (i == 6) {
                    exit();
                } else {
                    System.out.println("Your input is not valid, please try again");
                }


            } catch (InputMismatchException e) {
                System.out.println("Your input error!\nPlease choose1-6:");
                sc.nextLine();
            }
        } while (true);
    }

    double availableBalance() {
        double balance = current.getBalance();
        System.out.println("Your available balance is: "+ balance);
        return balance;
    }

    protected boolean withDrawal(double money){
        String str = "withDrawal";
        if(current.getBalance() < money) {
            System.out.println("I am sorry. You don't have enough money.");
            return false;
        }
        else{
            double balance = current.getBalance() - money - this.transactionFee;
            current.setBalance(balance);
            this.availableAmountInMachine -= money;
            this.print(str, money);
            return true;
        }
    }


    protected void deposit(double money){
        String str = "deposit";
        double balance = current.getBalance() + money - this.transactionFee;
        current.setBalance(balance);
        this.availableAmountInMachine += money;
        print(str, money);
    }

    private void print(String str, double money){
        String output = str + " - " + money + " (fee:"+this.transactionFee+")";
        System.out.println(output);
        transactions.add(output);
    }

    int recentTransactions(){
        int size = 0;
        if(transactions!=null) {
            System.out.println("\nThe recent transactions are:");
            size = transactions.size();
            int end = transactions.size() - 1;
            if (size > 10) {
                for (int i = end; i >= end - 9; i--){
                    System.out.println(transactions.get(i));
                    size = 10;
                }
            } else {
                for (int i = end; i >= 0; i--) {
                    System.out.println(transactions.get(i));
                }
            }
        }else{
            System.out.println("No transactions so far.");
        }
        return size;
    }

    boolean changePassword(String newPassword){
        current.setPassword(newPassword);
        System.out.println("Your password has been changed to " + newPassword);
        return true;
    }

    void exit(){
        System.out.println("Exit");
        sc.close();
        System.exit(0);
    }

    void forgotPassword(String bankAccountNumber) {
        boolean validBankAccount = false;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUser().getBankAccountNumber().equals(bankAccountNumber)) {
                validBankAccount = true;
                break;
            }
        }
        if (validBankAccount == true) {
            System.out.print("If you forget your password, please enter your name, year age, and phone number:\n");
            String name = sc.next();
            int age = Integer.valueOf(sc.next());
            String phone = sc.next();
            if (this.validate(name, age, phone)) {
                System.out.print("\nYou are a current user. Please enter your new password:\n");
                String password = sc.next();
                resetPassword(name, age, phone, password);
            } else {
                System.out.print("\nYour information is not valid. Please start again\n");
                start();
            }
        } else {
            System.out.println("Your bank account is not valid. Please start again");
            start();
        }
    }

    boolean resetPassword(String name, int age, String phone, String newPassword) {
        //resetted by validating the name, age and phoneNumber
        if(validate(name, age, phone)){
            return this.changePassword(newPassword);
        }else{
            return false;
        }
    }

    UserData register() {
        UserData userdata = new UserData();
        System.out.println("Please input your bank account number");
        String account = Long.toString(sc.nextLong());
        userdata.setUser(new User(account));
        System.out.println("Please input your password");
        String password = sc.next();
        userdata.setPassword(password);
        System.out.println("Please input your phone number");
        String phoneNumber = sc.next();
        userdata.getUser().setPhoneNumber(phoneNumber);
        System.out.println("Please input your name");
        userdata.getUser().setName(sc.next());
        System.out.println("Please input your address");
        userdata.getUser().setAddress(sc.next());
        System.out.println("Please input your age");
        //Integer.valueOf(scanner.nextLine());
        userdata.getUser().setAge(sc.nextInt());
        userList.add(userdata);
        current = userdata;
        return current;
    }

    public void start() {
        int userType;
        System.out.println("Welcome to ATM! If you are a NEW USER, press 1; If you are a CURRENT USER, press 2");
        System.out.println("If you want to exit, press 0");
        userType = sc.nextInt();
        //newUser
        if (userType == 1) {
            register();
            operate();
        }
        //old user
        if (userType == 2) {
            login();
        }

        if (userType == 0) {
            exit();
        }
    }
}
