package com.company;

public class Savings extends Account{
    // List properties to the Savings Account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    // Constructor to initialize settings for the Savings properties

    public Savings(String name, String sSN, double balance) {
        super(name, sSN, balance);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }




    // List any methods specific to savings account
    @Override
    public void showInfo() {
        System.out.println("ACCOUNT TYPE: " + getClass().getSimpleName());
        super.showInfo();
        System.out.println(
                "Your Savings Account Features" +
                        "\n Safety Deposit Box ID: " + safetyDepositBoxID +
                        "\n Safety Deposit Box Key: " + safetyDepositBoxKey
        );
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - .25;
    }


    private void setSafetyDepositBox(){
        // 3 digits long
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10,3));
        // 4 digits long
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,4));
    }


}
