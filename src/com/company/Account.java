package com.company;

// Abstract means objects cannot be created from Account class
public abstract class Account implements iBaseRate {
    // List common properties for savings and checking account
    private String name;
    private String sSN;
    private double balance;

    private static int index = 10000;
    protected String accountNumber;
    protected double rate;


    // Constructor to set base properties and initialize the account

    public Account(String name, String sSN, double balance) {
        this.name = name;
        this.sSN = sSN;
        this.balance = balance;

        // Set account number
        index++;
        this.accountNumber = setAccountNumber();

        setRate();

    }


    // List common methods - transactions

    public void deposit (double amount){
        balance += amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    public void withdrawal(double amount){
        balance -= amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount){
        balance -= amount;
        System.out.println("Transferring $" + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance(){
        System.out.println("Your balance is now: $" + balance );
    }

    public void showInfo(){
        System.out.println(
                "NAME: " + name +
                        "\nACCOUNT NUMBER: " + accountNumber +
                        "\nBALANCE: $" + balance +
                        "\nRATE: " + rate + "%"
        );
    }

    private String setAccountNumber(){
        String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));

        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    public void compound(){
        double accruedInterest = balance * (rate/100);
        balance += accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();
    }

    public abstract void setRate();


}
