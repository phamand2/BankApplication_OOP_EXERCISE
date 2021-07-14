package com.company;
import utilities.CSV;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[] args) throws IOException {
        List<Account> accounts = new LinkedList<>();

        String file = "src/utilities/NewBankAccounts.csv";


        List<String[]> newAccountHolders = CSV.read(file);
        for (String[] newAccountHolder : newAccountHolders) {
            String name = newAccountHolder[0];
            String sSN = newAccountHolder[1];
            String accountType = newAccountHolder[2];
            double initDeposit = Double.parseDouble(newAccountHolder[3]);

            if (accountType.equalsIgnoreCase("Savings")) {
                accounts.add(new Savings(name, sSN, initDeposit));
            } else if (accountType.equalsIgnoreCase("Checking")) {
                accounts.add(new Checking(name,sSN,initDeposit));
            } else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }


        accounts.forEach(account -> account.showInfo());

    }
}
