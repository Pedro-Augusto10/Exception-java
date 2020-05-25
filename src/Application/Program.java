package Application;

import java.util.Locale;
import java.util.Scanner;
import model.entities.Account;
import model.exception.DomainException;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner ler = new Scanner(System.in);

        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = ler.nextInt();
            ler.nextLine();
            System.out.print("Holder: ");
            String holder = ler.nextLine();
            System.out.print("Initial balance: ");
            double balance = ler.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = ler.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.println("");
            System.out.print("Enter amount for withdrw: ");
            double amount = ler.nextDouble();
            account.withdraw(amount);

            System.out.println("");
            System.out.println(account.getHolder());
            System.out.println("New balance: " + String.format("%.2f", account.getBalance()));

        } catch (DomainException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Erro não detectado");
        } finally {
         ler.close();

        }

    }

}
