package service;

import java.sql.SQLException;
import java.util.Scanner;

import dao.impl.AccountDaoImpl;
import dao.impl.UserDaoImpl;
import domain.Account;
import domain.Person;

public class Client {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter what to do (insert=1 /update=2 /select=3 /selectAll=4 /delete=5 /deleteAll=6 :");
		//String action=scan.nextLine();
		int action=scan.nextInt();
		
		
		UserDaoImpl usrDaoImpl = new UserDaoImpl();
		Person p1= new Person("90787878", "Nihal", "Perera", "nihal1972@gmail.com", "011 0101010");
		AccountDaoImpl accDaoImpl = new AccountDaoImpl();
		Account a1=new Account(112233, "011123123", "Fixed", "809898985V", 250000);
		
		try {
			if(action == 1 ) {
				usrDaoImpl.insertPerson(p1);
				accDaoImpl.insertAccount(a1);
				System.out.println(" Person Details Inserted ");
				System.out.println(" Account Details Inserted ");
				
			}else if (action== 2) {
				usrDaoImpl.updatePerson(p1);
				accDaoImpl.updateAccount(a1);
				System.out.println(" Person Details Updated ");
				System.out.println(" Account Details Updated ");
				
			}else if (action== 3) {
				accDaoImpl.selectAllAccount(a1);
				usrDaoImpl.selectAllPerson(p1);
				
			}else if (action== 4) {
				accDaoImpl.selectAccount(a1);
				usrDaoImpl.selectPerson(p1);
				
			}else if (action== 5) {
				usrDaoImpl.deleteAllPerson(p1);
				accDaoImpl.deleteAllAccount(a1);
				System.out.println(" Person Details Deleted ");
				System.out.println(" Account Details Deleted ");
				
			}else if (action== 6) {	
				usrDaoImpl.deletePerson(p1);
				accDaoImpl.deleteAccount(a1);
				System.out.println(" Person Details Deleted ");
				System.out.println(" Account Details Deleted ");
				
			}else {
				System.out.println("Try again");
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
				

	}

	}
}
