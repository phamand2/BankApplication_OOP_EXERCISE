package com.company;

public class Checking extends Account{
    // List properties specific to a Checking account
    private long debitCardNumber;
    private int debitCardPin;

    // Constructor to initialize checking account properties

    public Checking(String name, String sSN, double balance) {
        super(name, sSN, balance);
        accountNumber = "2" + accountNumber;

        setDebitCard();

    }


    // List any methods specific to checking account

    @Override
    public void showInfo() {
        System.out.println("ACCOUNT TYPE: " + getClass().getSimpleName());
        super.showInfo();
        System.out.println(
                "Your Checking Account Features" +
                        "\n Debit Card Number: " + debitCardNumber +
                        "\n Debit Card Pin: " + debitCardPin
        );

    }

    @Override
    public void setRate() {
        rate = getBaseRate() * .15;
    }

    private void setDebitCard(){
        // 12 digits long
        debitCardNumber = (long) (Math.random() * Math.pow(10,12));
        // 4 digits long
        debitCardPin = (int) (Math.random() * Math.pow(10,4));
    }
}
