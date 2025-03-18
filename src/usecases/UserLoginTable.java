package usecases;

import java.util.Scanner;

import dao.UserIMPL;
import dao.Userdao;

public class UserLoginTable {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter accountNumber:");
        int accountNumber=sc.nextInt();
        System.out.println("Enter username:");
        String username=sc.next();
        System.out.println("Enter password:");
        String password=sc.next();
        Userdao dao=(Userdao) new UserIMPL();
        double balance=dao.getBalance();
        String result=dao.UserLoginTable(accountNumber,username, password, balance);
        System.out.println(result);
    }
}
