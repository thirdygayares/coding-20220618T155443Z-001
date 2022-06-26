package casestudy;

import java.util.*;

public class Finalcase {

    public static Scanner johnnyReynan = new Scanner(System.in);
    public static String johnnyTable[][] = {
        {
            "0123-4567-8901",
            "Roel Richard",
            "5000.00",
            "1111"
        },
        {
            "2345-6789-0123",
            "Dorie Marie",
            "0.00",
            "2222"
        },
        {
            "3456-7890-1234",
            "Railee Darrel ",
            "10000",
            "3333"
        },
        {
            "4567-8901-2345",
            "Railynne Dessirei",
            "2500",
            "4444"
        },
        {
            "5678-9012-3456",
            "Raine Dessirei  ",
            "10000",
            "5555"
        }

    }, accountNumber = " ", accountName = " ";

    public static int passwordTrial = 3;
    public static double balance = 0, withdrawn = 0;
    public static void main(String[] args) {
        //how to create method
        jonnyOuput1();

    }

    //method1
    public static void jonnyOuput1() {
        //how to create method
        System.out.println("____________________");
        System.out.println("       JB");
        System.out.println("    Johnny Bank");
        System.out.println("____________________");
        System.out.println("\n   S -> Start Transaction");
        System.out.println("   Q -> Quit");
        System.out.print(" \n\n Enter your choice: ");

        char choiceOne = johnnyReynan.next().charAt(0);

        switch (choiceOne) {
            case 's':
            case 'S':
                passwordTrial = 3;
                jonnyOuput2();
                break;
            case 'q':
            case 'Q':
                System.out.println("You are terminated");
                System.exit(0);
                break;

            default:
                System.out.println("\n   Invalid Choices\n");
                jonnyOuput1();
        }


    }
    //method2
    public static void jonnyOuput2() {

        String pinnumber = "";
        System.out.println("____________________");
        System.out.println("       JB");
        System.out.println("    Johnny Bank");
        System.out.println("____________________");
        System.out.println("\n Enter your Pin Number: ");
        System.out.print(" \n");
        pinnumber = johnnyReynan.next();

        for (int i = 0; i < johnnyTable.length; i++) {
            if (pinnumber.equals(johnnyTable[i][3])) {
                accountNumber = johnnyTable[i][0];
                accountName = johnnyTable[i][1];
                balance = Double.parseDouble(johnnyTable[i][2]);
                jonnyOuput3();
                System.exit(0);
            }
        }


        if (passwordTrial <= 1) {
            System.out.println("CAPTURED CARD….\r\n" + "PLEASE CALL 143-44");
            jonnyOuput1();
        } else {
            System.out.println("Invalid Pincode\nPlease try again");
            --passwordTrial;
            System.out.println("You have " + passwordTrial + " attempt left");
            jonnyOuput2();

        }




    }

    //method3
    public static void jonnyOuput3() {
        System.out.println("____________________");
        System.out.println("       JB");
        System.out.println("    Johnny Bank");
        System.out.println("____________________");
        System.out.println("\n   Select Type of Transaction: ");
        System.out.println("\n     B-> Balance Inquiry ");
        System.out.println("     W-> Withdrawal ");
        System.out.println("     D-> Deposit");
        System.out.println("     C-> Cancel");
        System.out.print("\nEnter transaction Type: ");
        char transactionType = johnnyReynan.next().charAt(0);

        switch (transactionType) {
            case 'b':
            case 'B':
                jonnyOuputBalanceInquiry();
                break;
            case 'w':
            case 'W':
                jonnyOuputWithdrawal();
                break;
            case 'd':
            case 'D':
                jonnyOuputDeposit();
                break;
            default:
                System.out.println("Invalid Choices");
                jonnyOuput3();
        }


    }

    //method 4 balance inquiry 
    public static void jonnyOuputBalanceInquiry() {
        System.out.println("____________________");
        System.out.println("       JB");
        System.out.println("    Johnny Bank");
        System.out.println("____________________");
        System.out.println("\n      Account #:       " + accountNumber);
        System.out.println("      Account Name:    " + accountName);
        System.out.println("      Balance:         " + balance);

        System.out.println("\n     Press X to Exit");
        char pressx = johnnyReynan.next().charAt(0);

        switch (pressx) {
            case 'x':
            case 'X':
                jonnyOuput3();
                break;
        }

    }

    public static void jonnyOuputWithdrawal() {


        System.out.println("____________________");
        System.out.println("       JB");
        System.out.println("    Johnny Bank");
        System.out.println("____________________");
        System.out.println("\nEnter amount to be withdrawn ");
        withdrawn = johnnyReynan.nextDouble();






        if (withdrawn < 100) {
            System.out.println("\n\nWithdrawn amount should not be\r\n" +
                "lower than 100 pesos");
            System.out.println("Valid amount: 100, 200, 1700....etc(100 denomination)");
            System.out.println("Invalid amount: 450, 10 , 1000.25....etc\n");
            jonnyOuputWithdrawal();
        } else if (withdrawn > balance) {
            System.out.println("\n\nInsufficient Fund");
            jonnyOuputWithdrawal();
        } else {

            if (withdrawn % 100 == 0) {
                balance = balance - withdrawn;
            } else {
                System.out.println("Valid amount: 100, 200, 1700....etc(100 denomination)");
                System.out.println("Invalid amount: 450, 10 , 1000.25....etc\n");
                jonnyOuputWithdrawal();
            }



        }

        System.out.println("\n     Press X to Exit");
        char pressx = johnnyReynan.next().charAt(0);

        switch (pressx) {
            case 'x':
            case 'X':
                jonnyOuput3();
                break;
        }
    }

    public static void jonnyOuputDeposit() {
        System.out.println("____________________");
        System.out.println("       JB");
        System.out.println("    Johnny Bank");
        System.out.println("____________________");
        System.out.println("\nEnter amount to be deposited ");
        double deposited = johnnyReynan.nextDouble();



        if (deposited < 100) {
            System.out.println("\ndeposit amount should not be\n" +
                "lower than 100 pesos");
            jonnyOuputDeposit();
        } else {
            balance = balance + deposited;

        }
        System.out.println("\n     Press X to Exit");
        char pressx = johnnyReynan.next().charAt(0);

        switch (pressx) {
            case 'x':
            case 'X':
                jonnyOuput3();
                break;
        }
    }


}