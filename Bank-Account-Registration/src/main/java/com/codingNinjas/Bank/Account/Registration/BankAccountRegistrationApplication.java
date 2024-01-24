package com.codingNinjas.Bank.Account.Registration;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class BankAccountRegistrationApplication {

	public static void main(String[] args) {

		/*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.
		
		* 1. Fetch context from ApplicationContext.xml and initiate scanner.
		* 2. Get user details from console.
		* 3. Get account details from user and add them to the account list.
		* 4. Display the list of accounts with their reference ids.
		*/
		
		Scanner scanner=new Scanner(System.in);
		//ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com.codingNinjas.Bank.Account.Registration");
		ApplicationContext context=SpringApplication.run(BankAccountRegistrationApplication.class, args);
		System.out.println("Welcome to Account Registration Application!");
		
		System.out.println("Please Enter your name?");
		String name=scanner.nextLine();
		User user=(User) context.getBean(User.class);
		user.setUserDetails(name);
		boolean cont=true;
		
		System.out.println("Do you want to add Account?\n1.Yes \n2.No \n");
		int inp=scanner.nextInt();
		if(inp==1) {
			
			while(cont) {
			System.out.println("Please select the account type \n1.Current Account \n2.Savings Account \n");
			int accType=scanner.nextInt();
			switch(accType) {
			case 1 -> {
				System.out.println("Enter the opening balance");
				double opening=scanner.nextDouble();
				//scanner.nextLine();
				currentAccount account=(currentAccount) context.getBean(currentAccount.class);
				account.addBalance(opening);
				user.addAccount(account);
				System.out.println("Do you want to add more Accounts?\n1.Yes \n2.No \n");
				int inpp=scanner.nextInt();
				if(inpp==2) {
					cont=false;
					
				}
				break;
				
			}
			case 2 ->{
				System.out.println("Enter the opening balance");
				double opening=scanner.nextDouble();
				//scanner.nextLine();
				savingsAccount account=(savingsAccount) context.getBean(savingsAccount.class);
				account.addBalance(opening);
				user.addAccount(account);
				System.out.println("Do you want to add more Accounts?\n1.Yes \n2.No \n");
				int inpp=scanner.nextInt();
				if(inpp==2) {
					cont=false;
					
				}
				break;
			}
			case 3 ->{
				System.out.println("Invalid input- Exiting....");
				return;
			}
			}
			
			}
			
		}else if(inp==2) {
			return;
		}else {
			System.out.println("Invalid input- Exiting....");
			return;
		}
		
		System.out.println("Hi "+user.getName()+", here is the list of your accounts");
		ArrayList<Account> listAcc=(ArrayList<Account>) user.getAllAccounts();
		for(Account acc:listAcc) {
			System.out.println(acc.getAccountType()+" : Opening Balance - "+acc.getBalance()+"  Reference Id: "+acc.toString());
		}
		//context.close();
		scanner.close();
		
	}

}
