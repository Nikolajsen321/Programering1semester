import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        Account[] account1 = new Account[10];

        for (int i = 0; i < account1.length; i++) {
            Account a = new Account(i);
            account1[i] = a;
            account1[i].setBalance(100);
        }


        int valg = 0 ;
        Account a = account1[valg];
        System.out.println(a);

    while (valg != 10) {
        System.out.println("Indtast konto ID 0-9 eller logud på 10 ");
         valg = input.nextInt();
            if (valg > 9 || valg < 0)
            {
                if(valg!= -1)
                {
                    System.out.println("Du skal vælge et ID fra 0 - 9");
                }
            } else {
                a = account1[valg] ;
                System.out.println("ID: " + a.getId());
                System.out.println("Balance: 1 \nWhitdraw: 2 \nDeposit: 3 \nExit: 4");
               int chose = input.nextInt();
               while (chose != 4) {
               if (chose == 1)
               {
               //TODO Vis saldo
               System.out.println("Der er på kontoen: "+a.getBalance() + "kr \n");
               }
               if (chose == 2)
               {
                   double oldBalance = 0;
                   System.out.println("vælg mængde ");
                   double withdraw1 = input.nextDouble();
                  oldBalance = a.getBalance();
                   a.setWithdraw(withdraw1);
                   System.out.println("før på konto " + oldBalance + " kr ");
                   System.out.println("tilbage på konto " + a.getBalance() + " kr " + "\n");
               }
               if(chose == 3)
               {
                   double oldBalance = 0;
                   System.out.println("Vælg mængde: ");
                   double deposit1 = input.nextDouble();
                   oldBalance = a.getBalance();
                   a.setDeposit(deposit1);
                   System.out.println("Før på konto: " + oldBalance + " kr ");
                   System.out.println("Tilbage på konto " + a.getBalance() + " kr \n ");
               }
               if(chose > 4 || chose < 1)
               {
                   System.out.println("Du må vidst ikke have forstået konceptet prøv igen");
               }
                   System.out.println("Balance: 1 \nWhitdraw: 2 \nDeposit: 3 \nExit: 4 ");
                   chose = input.nextInt();
                }


            }
        }
    }





//        System.out.println("ID " + account1.getId());
//        System.out.println("Created:" + account1.getDateCreated());
//        System.out.println("Balance: " + account1.getBalance());
//        System.out.println( "Monthly interest money " + account1.getmonthlyInterest());
//        account1.setWithdraw(500);
//        System.out.println(account1.getLastTransation());
//        System.out.println("Trukken fra konto: " + account1.getWhitdraw());
//        System.out.println("Tilbage på konto: " + account1.getBalance());
//        account1.setWithdraw(500);
//        System.out.println("Trukken fra konto: " + account1.getWhitdraw());
//        System.out.println("Tilbage på konto: " + account1.getBalance());
//        account1.setDeposit(1000);
//        System.out.println("Tilføjet til konto: " + account1.getDeposit());
//        System.out.println("Tilbage på konto: " + account1.getBalance());


//
//        account1.setWithdraw(500);
//        account1.setDeposit(1000);
//        account1.setWithdraw(500);
//        account1.setDeposit(500);


//        account1.setWithdraw(500);
//        sleep(5000);
//        System.out.println(account1.getLastTransation());
//
//
//        System.out.println();
//        Account account2 = new Account(20000,45);
//
//        account1.udskrivAccountBalance();
//        System.out.println();

//        account2.udskrivAccountBalance();
//
//        account1.setBalance(5000);
//
//        System.out.println(account1.getBalance());

        }


