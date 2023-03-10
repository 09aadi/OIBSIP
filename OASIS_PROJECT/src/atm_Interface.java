/*
* Start
* Initialization: Name, Account no., Password, User ID.
* Initial balance in bank for every user is Rs. 5000 - so that user can directly switch to any options of his choice.
* Registration process which includes: (get) Name, user ID, Password, Account number.
* User Registered successfully.
* Login Process: (get) User ID, Password.
* Atm service options: (Use of switch case)
* 1. Deposit Money - User can deposit money and the transaction will be added to the passbook / history.
* 2. Cash Withdrawal - User can withdraw money and transaction will be added to the passbook / history.
* 3. Transfer Money - User can transfer money to another account.
* 4. Check Balance - User can check their current balance.
* 5. Transaction history - User can check all the transactions they made.
* 6. Exit from the system.
* End.
*  */

import java.util.Scanner;

class bankAcc {
    String name;
    String acc;
    String password;
    String userID;

    double balance = 5000;
    int transaction = 0;
    String history = "";



    // Registration of the user which includes his/her: Name, UserID, password, Account Number.
    public void registration()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        this.name = sc.nextLine();
        System.out.println("Enter your userID: ");
        this.userID = sc.nextLine();
        System.out.println("Enter your password: ");
        this.password = sc.nextLine();
        System.out.println("Enter your Acc. NO.: ");
        this.acc = sc.nextLine();

        System.out.println("You are successfully registered in the online system of XYZ bank.");
        System.out.println("Kindly login");



    }

    // Login Credentials.
    public boolean login() {
        boolean log = false;
        Scanner sc = new Scanner(System.in);

        while (!log) {
            System.out.println("Enter your User ID: ");
            String user = sc.nextLine();

            if (user.equals(userID)) {
                while (!log) {
                    System.out.println("Enter your password: ");
                    String passcode = sc.nextLine();
                    if (passcode.equals(password)) {
                        System.out.println("Credentials are correct. Login successful... ");
                        log = true;
                    } else {
                        System.out.println("Incorrect credentials...");
                    }
                }
            } else {
                System.out.println("Incorrect credentials...");
            }

        }


        return log;
    }
    // CASE 1: Deposition of money(Rs 10000 is limit).
    public void deposit() {
        System.out.println("Enter the amount you want to deposit in your Acc.: ");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();

        try {
            if (amount <= 10000) {
                transaction = transaction + 1;
                balance = balance + amount;
                System.out.println("Amount deposited successfully!!");

                String adt = "+ Rs " + amount + " deposited";
                history = history.concat(adt) + "\n";

            } else {
                System.out.println("Limit for deposition is Rs.10000");
            }

        } catch (Exception e) {
            System.out.println(" ");
        }
    }

    // CASE 2: Cash withdrawal.
    public void withdraw() {
        System.out.print("\nEnter amount to withdraw - ");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        try {

            if (balance >= amount) {
                transaction = transaction + 1;
                balance -= amount;
                System.out.println("Amount Withdrawal successful...");
                String adt = "- Rs " + amount + " withdrawn";
                history = history.concat(adt) + "\n";

            } else {
                System.out.println("\nInsufficient Balance");
            }

        } catch (Exception e) {
            System.out.println(" ");
        }
    }

    // CASE 3: Money transfer to other Account .
    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Receiver's Name: ");
        String recevier = sc.nextLine();
        System.out.println("Enter his/her Acc. No: ");
        String rec_acc = sc.nextLine();
        System.out.println("Enter transfer amount: ");
        double amount = sc.nextDouble();

        try {
            if (balance >= amount) {
                if (amount <= 20000) {
                    transaction = transaction + 1;
                    balance -= amount;
                    System.out.println("The amount is successfully transferred to Acc no. " + rec_acc);
                    String adt = ("Rs." + amount + " transferred to " + recevier);
                    history = history.concat(adt);
                } else {
                    System.out.println("Transfer limit is Rs. 20000...");
                }
            } else {
                System.out.println("Insufficient Balance....");
                System.out.println("Check your Balance.");
            }
        } catch (Exception e) {
            System.out.println(" ");
        }
    }

    // CASE 4: Check balance
    public void balance() {
        System.out.println("Rs. " + balance);
    }

    // CASE 5: Transaction history / E - Passbook
    public void transactionhistory() {
        if (transaction == 0) {
            System.out.println("No balance to display...");
        } else {
            System.out.println("\n" + history);
        }
    }
}

public class atm_Interface {

    // Set limit of the inputs ( 2 for registration, 2 for login, and 6 for ATM Menu).
    public static int inputInt(int limit) {
        int input = 0;
        boolean tag = false;

        while (!tag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                tag = true;

                if (tag && input > limit || input < 1) {
                    System.out.println("Enter Your Choice between 1 to " + limit);
                    tag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter Integer value.");
                tag = false;
            }
        }
        return input;
    }

    public static void main(String[] args) {

        System.out.println("\n\n");
        System.out.println("\t\t\t || Welcome to XYZ Bank online banking system ||\n\n\n");
        System.out.println("1. Sign up/ Registration \n2. Exit");
        System.out.println("Enter your choice: ");
        
        int choice = inputInt(2);

        if (choice == 1) {
            bankAcc bank = new bankAcc();
            bank.registration();
            while (true) {
                System.out.println("1. Login \n2. Exit");
                System.out.println("Enter your choice: ");
                int ad = inputInt(2);

                if (ad == 1) {
                    if (bank.login()) {
                        System.out.println("\n\n\t\t\t || WELCOME " + bank.name + " ||");
                        boolean finish = false;
                        while (!finish) {
                            System.out.println("\n1.Deposit \n2.Withdraw \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                            System.out.println("\nEnter Your Choice:  ");
                            int a = inputInt(6);

                            switch (a) {
                                case 1 -> bank.deposit();
                                case 2 -> bank.withdraw();
                                case 3 -> bank.transfer();
                                case 4 -> bank.balance();
                                case 5 -> bank.transactionhistory();
                                case 6 -> finish = true;

                            }
                        }

                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
