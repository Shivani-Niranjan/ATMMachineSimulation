//Write a Java program that simulates an ATM machine. The program should handle the following exceptions:
//        InsufficientFundsException: Thrown when a user tries to
//        withdraw an amount greater than their account balance.

//        InvalidAmountException: Thrown when a user tries to withdraw
//        a negative or zero amount.
//        The program should have the following functionalities:

//        Initialise the account balance with a default value.
//        Provide options for the user to deposit or withdraw funds.
//        Handle exceptions appropriately and display meaningful error messages to the user.

import com.sun.tools.attach.AgentInitializationException;

import java.util.Scanner;
class Account{
    private int balance = 4500;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void validate(int amount) throws InvalidAmountException {
        if (amount <= 0){
            throw new InvalidAmountException("Enter a proper Amount");
        }
    }

    public void Withdraw(int amount, int balance) throws InsufficientFundsException{
        if (amount > balance){
            throw new InsufficientFundsException("Withdraw Amount is greater than Balance");
        }
        else{
            System.out.println("Amount withdrawn : " + amount);
            System.out.println("Balance : " + (balance - amount));
            balance = balance - amount;
            setBalance(balance);
        }
    }

    public void deposit(int amount, int balance) {

            System.out.println("Amount  : " + amount);
            System.out.println("Balance : " + (balance + amount));
            balance = balance + amount;
            setBalance(balance);
    }


}

public class Main {
    public static void main(String[] args) {
        Account shiv = new Account();
        Scanner sc = new Scanner(System.in);
        int end = 0;
        while (end!=4) {
            System.out.println("Enter 1 for Deposit : ");
            System.out.println("Enter 2 for Withdrawal : ");
            System.out.println("Enter 3 for check balance : ");
            System.out.println("Enter 4 to end ");
            int choice = sc.nextInt();

            if (choice > 0 && choice < 4) {
                if (choice == 3) {
                    System.out.println("Balance : " + (shiv.getBalance()));
                }
                else{
                System.out.println("Enter Amount : ");
                int amount = sc.nextInt();

                try {
                    shiv.validate(amount);
                } catch (InvalidAmountException exception) {
                    System.out.println(exception.getMessage());
                    return;
                }

                if (choice == 1) {
                    shiv.deposit(amount, shiv.getBalance());
                }

                if (choice == 2) {
                    try {
                        shiv.Withdraw(amount, shiv.getBalance());
                    } catch (InsufficientFundsException exception) {
                        System.out.println(exception.getMessage());
                        return;
                    }
                }
            }
        }

            else if (choice == 4) {
                end = 3;
                return;

            }

            else{
                System.out.println("Invalid Input");
            }
        }


    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException (String errorMessage){
        super(errorMessage);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException (String errorMessage){
        super(errorMessage);
    }
}