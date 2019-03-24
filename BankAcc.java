import java.util.Scanner;
import java.text.DecimalFormat;
/*
Jonathan Li
3/22/2019
Creates a bank account with the parameters of an account number, owner name, type of account, and the balance
*/
public class BankAcc {
    private int AcctNum;
    private String name;
    private String type;
    private double balance;
    DecimalFormat money = new DecimalFormat("$0.00");
    //Constructors
    public BankAcc(){
        boolean check = true;
        //Asks for name
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your name, both last and first");
            name = sc.nextLine();
            //Asks for the account type
            do {
                System.out.println("Please enter if this is or savings or checking account.");
                String newType = sc.next();
                //If they don't input checking of savings it will reject the input and try again
                if(newType.equalsIgnoreCase("checking") || newType.equalsIgnoreCase("savings"))
                {
                    type = newType;
                    check = false;
                }
                else
                    System.out.println("That doesn't specify if it's a checking or savings account");
            }while(check);
            check = true;
            //Asks for the balance or initial deposit
            do {System.out.println("Enter how much you want to deposit \n Note: It has to be above 200 and in 0.00 format");
                double newBalance = 0;
                //Checks if it's a double so it doesn't crash the program
                try {newBalance = Double.parseDouble(sc.next());
                } catch (NumberFormatException ignore) {
                    System.out.println("Invalid input");
                }
                //Checks if it's above 200
                if (newBalance > 200) {
                    balance = newBalance;
                    check = false;
                }
                else
                    System.err.println("A deposit has to be more than 200");
            }while(check);
        //sets the Account Number
        AcctNum++;
    }
    //Accessors
    public int getAcctNum() {
        return AcctNum;
    }

    public double getbalance() {
        return balance;
    }

    public String getname() {
        return name;
    }

    public String getType() { return type; }

    //Mutators
    //method for depositing money
    public void deposit()
    {
        boolean check = true;
        double deposit = 0;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter how much money you want to deposit in the format of 0.00 with only 2 decimal points");
            try {deposit = Double.parseDouble(sc.next());
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }
            if (deposit > 0) {
                balance = balance + deposit;
                check = false;
            }
            else
                System.err.println("A deposit has to be more than 0");
        }while(check);
        System.out.println("Your current balance is " + money.format(balance));
        fee();
    }
    //method for withdrawing money
    public void withdraw()
    {
        boolean check = true;
        double withdraw = 0;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter how much money you want to withdraw in the format of 0.00 with only 2 decimal points");
            try {withdraw = Double.parseDouble(sc.next());
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }
            if (withdraw > 0 && balance - withdraw > 0) {
                balance = balance - withdraw;
                check = false;
            }
            else
                System.err.println("Please enter a positive number that is less than your current balance");
            System.out.println("Your current balance is " + money.format(balance));
        }while(check);
        fee();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void transfer(BankAcc obj, BankAcc obj2) {
        boolean check = true;
        if ((obj.name).equalsIgnoreCase(obj2.name)) {
            do {
                System.out.println("How much do you want to transfer from account 2 to account 1? Please Enter in 0.00 form");
                Scanner sc = new Scanner(System.in);
                double transfer = 0;
                try {
                    transfer = Double.parseDouble(sc.next());
                } catch (NumberFormatException ignore) {
                    System.out.println("Invalid input, please enter in a double");
                }
                if (transfer > 0) {
                    obj.balance = obj.balance + transfer;
                    obj2.balance = obj2.balance - transfer;
                    check = false;
                } else
                    System.out.println("Please enter a positive number");
            } while (check);
        }
        else
            System.out.println("Sorry you can't transfer money between these because they don't have the same owner");

        fee(obj2);
    }
    //ToString

    public String toString() {
        return "Your account # is " + AcctNum + " the owner is " + name + "the type is " + type + " and the balance is " + money.format(balance);
    }

    //Equals method
    @Override
    public boolean equals(Object obj) {
        if( obj instanceof BankAcc)
        {
            BankAcc BankAcc2 = (BankAcc) obj;
            if(BankAcc2.getbalance() == balance && BankAcc2.getname().equals(name) && BankAcc2.getType().equals(type))
            {
                return true;
            }
            else {
                System.out.println("These two are not the same bank account");
                return false;
            }
        }
        else
        {
            System.err.println("That ain't a bank account");
            return false;
        }
    }
    //Fee method
    public void fee()
    {
        if(balance < 200)
        {
            balance = balance -50;
            System.out.println("You must keep your balance above 200 or you will be charged $50");
            System.out.println("Your current balance is " + money.format(balance));
        }
        else
            System.out.println("Don't forget, if your account dips below 200 you will be charged $50");
    }
    public void fee(BankAcc obj)
    {
        if(obj.balance < 200)
        {
            obj.balance = obj.balance -50;
            System.out.println("You must keep your balance above 200 or you will be charged $50");
            System.out.println("Your current balance is " + money.format(obj.balance));
        }
        else
            System.out.println("Don't forget, if your account dips below 200 you will be charged $50");
    }
}
