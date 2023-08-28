import java.time.LocalDateTime;
import java.util.Date;
public class Account {
    private static int nextId;
    private int id = 0;
    private double balance;

    private double annualInterestRate;

    private LocalDateTime dateCreated = LocalDateTime.now();

    private LocalDateTime lastTransation;

    private double withdraw;
    private double deposit;

    private int counter;
    private int numberOfUse;
   


    public Account()
    {
        this.id += nextId;
        nextId++;

    }

    public Account( double balance1, double annualInterestRate1)    // double balance inden i
    {
        this();
        this.balance = balance1;
        this.annualInterestRate = annualInterestRate1;
        this.lastTransation = getLastTransation();

    }

    public Account(int id1)
    {
        this.id = id1;

    }


    public LocalDateTime getDateCreated()
    {
        return dateCreated;
    }

    public LocalDateTime getLastTransation()
    {
        return lastTransation;
    }


    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance1)
    {
        this.balance = balance1;
    }


    public int getId()
    {
        return id;

    }

    public void setId(int id1)
    {
        this.id = id1;

    }

    public void setAnnualInterestRate(double annualInterestRate1)
    {

        this.annualInterestRate = annualInterestRate1;
    }

    public double getAnnualInterestRate()
    {
        double annualInterestRate1 = annualInterestRate / 100;
        return annualInterestRate1;
    }


    public double getmonthlyInterestRate()
    {
        double monthlyInterest = getAnnualInterestRate() / 12;
        return monthlyInterest;
    }

    public double getmonthlyInterest()
    {
//      double monthlyInterest = getmonthlyInterestRate() * balance;

        return getmonthlyInterestRate() * balance;
    }

    public void setWithdraw(double withdraw1)
    {
        counter++;
        this.lastTransation = LocalDateTime.now();
        this.withdraw = withdraw1;
        this.balance -= withdraw1;
    }

    public double getWhitdraw()
    {
        return withdraw;
    }

    public void setDeposit(double deposit1)
    {
        this.lastTransation = LocalDateTime.now();
        counter++;
        this.deposit = deposit1;
        this.balance += deposit1;
    }

    public double getDeposit()
    {
        return deposit;

    }

    @Override
    public String toString() {
        return "Account{" +
                "id= " + id + " balance = "+ balance + " Kr " +
                '}';
    }

    //    public void udskrivAccountBalance()
//    {
//        System.out.println("Date: " + getDateCreated());
//        System.out.println("ID: " + id);
//        System.out.println("Balance: " + balance);
//        System.out.println("Anual interest: " + (getAnnualInterestRate() * 100  ) + "%");
//        System.out.println("monthly interest rate: " + (getmonthlyInterestRate() * 100) + "%");
//        System.out.println("Monthly interest: " + getmonthlyInterest());
//        System.out.println();

//        for (int i = 0; i <= counter; i++)
//        {
////            System.out.println("Date: " + getLastTransation());
//            if (withdraw > 0 )
//            {
//                System.out.println("Date: " + getLastTransation());
//                System.out.println("Withdrawn " + getWhitdraw());
//                System.out.println("Balance: " + (getBalance() - getWhitdraw()));
//                setWithdraw(0);
//            }
//
//            System.out.println();
//
//            if (deposit > 0)
//            {
//                System.out.println("Date: " + getLastTransation());
//                System.out.println("Deposit " + getDeposit());
//                System.out.println("Balance: " + (getBalance() + getDeposit()));
//                setDeposit(0);
//
//            }
//
//
//            System.out.println();
//        }

    }


